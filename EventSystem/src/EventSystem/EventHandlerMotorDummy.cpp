/*
 * EventHandlerMotorDummy.cpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */
#include "EventHandlerMotorDummy.hpp"
#include <chrono>
#include <iostream>
//rest is inherited. We just need run
#define MOTOR_TIMEOUT 10

void EventHandlerMotorDummy::run(){
    std::cout<<"MOTOR THREAD IS RUNNING \n";
    while(true){
        Event event = receive_event(MOTOR_TIMEOUT);//blockierend auf timeout
        if(event.return_Event_typ() == EventTyp::EnumTail){//== No_Event
            std::cout<<"NO EVENT\n";
        } 
    }
}

EventHandlerMotorDummy::~EventHandlerMotorDummy()=default;

EventHandlerMotorDummy::EventHandlerMotorDummy(){

}



