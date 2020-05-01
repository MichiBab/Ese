/*
 * EventHandlerMotorDummy.hpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */

#if !defined(EventHandlerDummyMotor_h)
#define EventHandlerDummyMotor_h
#include "EventHandler.hpp"
#include "EventTyp.hpp"

class EventHandlerMotorDummy : public EventHandler
{
private:
    /* data */
public:
    EventHandlerMotorDummy();
    ~EventHandlerMotorDummy();
    void run();
};


#endif