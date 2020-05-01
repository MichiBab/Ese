#include "EvQueueDummy.hpp"

EventQueue::EventQueue(/* args */)
{
}

EventQueue::~EventQueue()
{
}

Event EventQueue::dequeue_Event(int timeout){
    Event tmp = queue.front();
    queue.pop();
    return tmp;
}

void EventQueue::enqueue_Event(Event input_event){
    queue.push(input_event);
}