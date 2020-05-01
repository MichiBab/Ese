/*
 * EventQueue.cpp
 *
 *  Created on: April 30, 2020
 *      Author: Anja Schmidt
 */

#include "EventQueue.hpp"
#include <chrono>

using namespace std::chrono_literals;

EventQueue::EventQueue() = default;

EventQueue::~EventQueue() = default;

void EventQueue::enqueue_event(Event event) {
    {
        std::lock_guard<std::mutex> mutex_lock(this->queue_mutex);
        this->event_queue.push(event);
    }
    this->cond_var.notify_one();
}

Event EventQueue::dequeue_event(int timeout) {
    Event event(EventTyp::NO_EVENT);

    std::unique_lock<std::mutex> mutex_lock(this->queue_mutex);
    if (timeout == EventQueue::RECEIVED_BLOCKED) {
        /* wait blocked without timeout in queue */
        cond_var.wait(mutex_lock, [this]{return !this->event_queue.empty();});
        event = this->event_queue.front();
        this->event_queue.pop();
    } else {
        /* wait blocked in timeout but stop blocking when no event was
         * received until timeout */
        if (this->cond_var.wait_for(mutex_lock, timeout * 1ms,
                [this]{return !this->event_queue.empty();})) {
            event = this->event_queue.front();
            this->event_queue.pop();
        }
    }
    return event;
}

