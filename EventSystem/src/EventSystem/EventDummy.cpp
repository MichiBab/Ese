#include "EventDummy.hpp"

Event::Event(EventTyp typ){
    my_type = typ;
}


Event::~Event(){

}

EventTyp Event::return_Event_typ(){
    return my_type;
}