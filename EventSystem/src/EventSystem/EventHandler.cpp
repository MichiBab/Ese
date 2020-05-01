#include "EventHandler.hpp"

EventHandler::EventHandler():eventqueue(){
    
}

void EventHandler::notify(Event event){
    std::cout<<"notify was called on me with EVENT.EVENTTYPE: "<<event.return_Event_typ()<<"\n";
    eventqueue.enqueue_Event(event);//packe event in eigene queue
}

Event EventHandler::receive_event(int timeout){
    //wait timeout or smth
    return eventqueue.dequeue_Event(timeout);
}
