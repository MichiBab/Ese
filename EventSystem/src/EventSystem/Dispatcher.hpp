/*
 * Dispatcher.hpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */
#if !defined(Dispatcher_h)
#define Dispatcher_h
#include <map>
#include "EventTyp.hpp"
#include "IEventObserver.hpp"
#include <vector>
class Dispatcher
{
private:
    std::map<EventTyp,std::vector<IEventObserver*>> subscriber;
    
public:
    Dispatcher(/* args */);
    ~Dispatcher();
    void add_subscriber(EventTyp evEnum, IEventObserver& observer);
    void remove_subscriber(EventTyp evEnum, IEventObserver& observer);
    void dispatch_event(Event event);
};




#endif