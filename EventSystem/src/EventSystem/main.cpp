#include "EventHandlerMotorDummy.hpp"

int main(int argc, char const *argv[])
{
    EventHandlerMotorDummy* handler = new EventHandlerMotorDummy();
    
    std::thread t1(&EventHandlerMotorDummy::run,handler);
    t1.join();
    
    return 0;
}

