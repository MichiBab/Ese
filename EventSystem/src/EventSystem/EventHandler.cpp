/*
 * EventHandler.cpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */
#include "EventHandler.hpp"
#include <iostream>
EventHandler::EventHandler():eventqueue(){
    
}

void EventHandler::notify(Event event){
    std::cout<<"notify was called on me with EVENT.EVENTTYPE: "<< event.return_Event_typ()<<"\n";
    eventqueue.enqueue_event(event);//packe event in eigene queue
}

Event EventHandler::receive_event(int timeout){
    //wait timeout or smth
    return eventqueue.dequeue_event(timeout);
}
