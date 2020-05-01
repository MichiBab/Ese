#include "EventHandlerMotorDummy.hpp"
#include <chrono>

//all is inherited. We just need run
#define MOTOR_TIMEOUT 10

void EventHandlerMotorDummy::run(){
    std::cout<<"MOTOR THREAD IS RUNNING \n";
    while(true){
        std::this_thread::sleep_for(std::chrono::milliseconds(1000));
        Event event = receive_event(MOTOR_TIMEOUT);//blockierend auf timeout
        if(event.return_Event_typ() == EnumTail){//== No_Event
            std::cout<<"NO EVENT\n";
        } 
    }
}

EventHandlerMotorDummy::~EventHandlerMotorDummy(){

}

EventHandlerMotorDummy::EventHandlerMotorDummy(){

}