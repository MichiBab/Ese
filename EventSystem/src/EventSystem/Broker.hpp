/*
 * Broker.hpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */

#if !defined(BrokerHeader_h)
#define BrokerHeader_h
#include <stddef.h>
#include "EventTyp.hpp"
#include "IEventObserver.hpp"
#include "EventQueue.hpp"
#include "Dispatcher.hpp"
#include <thread>

class Broker
{
private:
    //For Singleton Desing Pattern  
    Broker(); // Private so that it can  not be called
	Broker(Broker const&){};             // copy constructor is private
	Broker& operator=(Broker const&){};  // assignment operator is private
	static Broker* pointer_Instance ;
    ~Broker()=default;
    std::thread broker_thread;
    EventQueue eventqueue;
    Dispatcher dispatcher;
public:
    //For Singleton Desing Pattern
    static Broker* getInstance();
    void subscribe(EventTyp evType, IEventObserver& observer);
    void unsubscribe(EventTyp evType, IEventObserver& observer);
    void enqueue_event(Event event);
    void broker_watch_queue_threaded();
    void join_broker();
};

#endif // MACRO
