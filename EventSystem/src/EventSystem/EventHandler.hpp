/*
 * EventHandler.hpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */

#if !defined(EventHandler_h)
#define EventHandler_h
#include "IEventObserver.hpp"
#include "EventQueue.hpp"
#include <thread>

class EventHandler: public IEventObserver
{
protected:
    /* data */
    int next_timeout;
    Event receive_event(int timeout);//gets event out of queue
    EventQueue eventqueue;
    virtual void run() = 0; //threadrun
public:
    EventHandler(); /*explicit for inheritance*/
    virtual ~EventHandler() {};
    void notify(Event event); //called by Dispatcher
};


#endif