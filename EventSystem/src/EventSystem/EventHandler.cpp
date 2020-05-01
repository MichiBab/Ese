#include "EventHandler.hpp"

/*    explicit EventHandler(); //Creates thread and calls run on it
    virtual ~EventHandler();
    void notify(Event event); 
    //called by Dispatcher
    
    int next_timeout;
    Event receive_event(int timeout);//gets event out of queue
    EventQueue eventqueue;
    //void init_Ev_Handler(); //not needed, inherit base class constructor

    virtual void run() = 0; //threadrun
    
    */

EventHandler::EventHandler():eventqueue(){
    
}

void EventHandler::notify(Event event){
    
}

Event EventHandler::receive_event(int timeout){

}
