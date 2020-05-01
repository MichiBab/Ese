#include "EventHandlerMotorDummy.hpp"
#include "Broker.hpp"
#include "EventTyp.hpp"
#include <map>
#include "IEventObserver.hpp"
#include <vector>
#include "EventCreator.hpp"

int main(int argc, char const *argv[])
{
    //GET BROKER INSTANCE
    Broker* broker = Broker::getInstance();

    //ERSTELLE EVENT HANDLER
    EventHandlerMotorDummy* handler = new EventHandlerMotorDummy();
    EventHandlerMotorDummy* handler2 = new EventHandlerMotorDummy();
    
    //STARTE EVENT HANDLER
    std::thread t1(&EventHandlerMotorDummy::run,handler);
    std::thread t2(&EventHandlerMotorDummy::run,handler);

    
    broker->subscribe(LICHTSCHRANKE_EINLAUF1_UNTERBROCHEN,*handler);
    broker->subscribe(LICHTSCHRANKE_AUSLAUF_FREI,*handler2);
    
    //Event Creator: Schnittstelle einer Komponente zum Broker.
    EventCreator motor_event_creator;

    //SEND EVENTS WITH EVENT CREATOR EXAMPLE
    motor_event_creator.parseEvent(LICHTSCHRANKE_EINLAUF1_UNTERBROCHEN);
    for(int i = 0; i < 5;i++){
        motor_event_creator.parseEvent(LICHTSCHRANKE_AUSLAUF_FREI);
    }
    motor_event_creator.parseEvent(LICHTSCHRANKE_EINLAUF1_UNTERBROCHEN);



    broker->join_broker();//inf loop
    return 0;
}

