/*
 * Broker.cpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */
#include "Broker.hpp"
#include <iostream>

Broker* Broker::pointer_Instance = NULL;

Broker::Broker():eventqueue(), dispatcher(){
   std::cout<<"Broker Initialised\n";
}

Broker* Broker::getInstance(){//static
   if (!pointer_Instance){ // Only allow one instance of class to be generated.
      pointer_Instance = new Broker;
      pointer_Instance->broker_thread = std::thread(&Broker::broker_watch_queue_threaded,pointer_Instance);
   }  
   return pointer_Instance;
}

void Broker::subscribe(EventTyp evType, IEventObserver& observer){
   dispatcher.add_subscriber(evType,observer);
}

void Broker::unsubscribe(EventTyp evType, IEventObserver& observer){
   dispatcher.remove_subscriber(evType,observer);
}

void Broker::enqueue_event(Event event){ //schnittstelle zum event creator
   eventqueue.enqueue_event(event);
}

void Broker::broker_watch_queue_threaded(){
   std::cout<<"BROKER THREAD IS RUNNING \n";
   while(true){
        std::this_thread::sleep_for(std::chrono::milliseconds(500));
        Event event = eventqueue.dequeue_event(0);//blockierend auf timeout
        if(event.return_Event_typ() == EventTyp::EnumTail){//== No_Event
            //std::cout<<"BROKER: NO EVENT\n";
        }
        else{
           dispatcher.dispatch_event(event);
        }
    }
}

void Broker::join_broker(){
   pointer_Instance->broker_thread.join();
}