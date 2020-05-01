#if !defined(EventHandlerDummyMotor_h)
#define EventHandlerDummyMotor_h
#include "EventHandler.hpp"

class EventHandlerMotorDummy : public EventHandler
{
private:
    /* data */
public:
    EventHandlerMotorDummy();
    ~EventHandlerMotorDummy();
    void run();
};


#endif