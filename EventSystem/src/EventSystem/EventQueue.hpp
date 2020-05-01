/*
 * EventQueue.h
 *
 *  Created on: April 30, 2020
 *      Author: Anja Schmidt
 */

#ifndef EVENT_SYSTEM_EVENTQUEUE_H_
#define EVENT_SYSTEM_EVENTQUEUE_H_

#include "Event.hpp"
#include <queue>
#include <mutex>
#include <condition_variable>

class EventQueue {

private:
	std::queue<Event> event_queue;
	std::mutex queue_mutex;
	std::condition_variable cond_var;

public:
    /**
     * a constant to pass to the dequeue_event method if the
     * call shall block without a timeout.
     */
	static int const RECEIVED_BLOCKED = -1;

	EventQueue();
	~EventQueue();

	/**
	 * Gets an event out of the queue.
	 * If the queue is empty, the thread will block for the given timeout
	 * in milliseconds.
	 * If timeout == RECEIVED_BLOCKED the call will block without a timeout.
	 *
	 * @param timeout the maximal time to block in the queue in ms
	 * @return an event, or an event with type NONE if a timeout happened
	 */
	Event dequeue_event(int timeout);

	/**
	 * Puts an given invent into the queue.
	 *
	 * @param event the event to insert into the queue
	 */
	void enqueue_event(Event event);
};



#endif /* EVENT_SYSTEM_EVENTQUEUE_H_ */
