#include "Dispatcher.hpp"
#include <iostream>
#include <algorithm>

Dispatcher::Dispatcher(){
    std::cout<<"dispatcher initialised\n";
    //CALL AN OBSERVER: subscriber.at(Event1)[0]->notify(tmp);
    for(EventTyp type = EventTyp(EnumHead+1); type<EnumTail; type=EventTyp(type+1)){
        subscriber.insert(std::pair<EventTyp,std::vector<IEventObserver*>>
                                    (type,std::vector<IEventObserver*>()));
    }
}

Dispatcher::~Dispatcher() = default;

void Dispatcher::add_subscriber(EventTyp evEnum, IEventObserver& observer){
    subscriber.at(evEnum).push_back(&observer);
}

void Dispatcher::remove_subscriber(EventTyp evEnum, IEventObserver& observer){
    subscriber.at(evEnum).erase(std::remove(
        subscriber.at(evEnum).begin(), //from
        subscriber.at(evEnum).end(), //to
        &observer), //value
        subscriber.at(evEnum).end() //till end
        );
    
}

void Dispatcher::dispatch_event(Event event){
    std::vector<IEventObserver*>* vec_ptr = &(subscriber.at(event.return_Event_typ()));
    for(int i = 0; i < vec_ptr->size();i++){
        vec_ptr->at(i)->notify(event);
    }
}