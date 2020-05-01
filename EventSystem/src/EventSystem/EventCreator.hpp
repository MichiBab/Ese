/*
 * EventCreator.hpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */
#if !defined(EventCreator_h)
#define EventCreator_h
#include "Broker.hpp"
class EventCreator
{
private:
    Broker* broker;
public:
    EventCreator();
    ~EventCreator();
    bool parseEvent(EventTyp type);
    bool parseEvent(EventTyp type,int);
    //bool parseEvent(EventTyp type, *POINTER?); //TODO: POINTER
};




#endif