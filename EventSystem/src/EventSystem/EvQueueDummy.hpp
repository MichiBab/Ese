#if !defined(EventQueued_h)
#define EventQueued_h
#include<bits/stdc++.h> 
#include "EventDummy.hpp"
class EventQueue
{
private:
    std::queue<Event> queue;

public:
    EventQueue(/* args */);
    ~EventQueue();
    Event dequeue_Event(int timeout);
    void enqueue_Event(Event input_event);

};




#endif