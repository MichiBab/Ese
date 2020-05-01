#include "EventCreator.hpp"

EventCreator::EventCreator():broker(Broker::getInstance()){

}

EventCreator::~EventCreator() = default;

bool EventCreator::parseEvent(EventTyp type){
    Event send_event(type);
    broker->enqueue_event(send_event);
}

bool EventCreator::parseEvent(EventTyp type, int hoehenmesswert){

}