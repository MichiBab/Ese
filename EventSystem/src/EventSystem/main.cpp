#include "EventHandlerMotorDummy.hpp"
#include "Broker.hpp"
#include "EnumDummy.hpp"
#include <map>
#include "IEventObserver.hpp"
#include <vector>
#include "EventCreator.hpp"

int main(int argc, char const *argv[])
{
    Broker* broker = Broker::getInstance();

    EventHandlerMotorDummy* handler = new EventHandlerMotorDummy();
    EventHandlerMotorDummy* handler2 = new EventHandlerMotorDummy();
    
    std::thread t1(&EventHandlerMotorDummy::run,handler);
    std::thread t2(&EventHandlerMotorDummy::run,handler);

    broker->subscribe(Event1,*handler);
    broker->subscribe(Event1,*handler2);
    broker->subscribe(Event2,*handler);
    
    EventCreator motor_event_creator;

    motor_event_creator.parseEvent(Event1);

    for(int i = 0; i < 1000000000;i++){
        
    }
    motor_event_creator.parseEvent(Event2);



    broker->join_broker();//inf loop
    return 0;
}

