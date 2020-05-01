#if !defined(IEventObserver_h)
#define IEventObserver_h
#include "EventDummy.hpp"

class IEventObserver
{
protected:
    IEventObserver(){};
public:
    virtual ~IEventObserver() {};
    virtual void notify(Event event) = 0;
};



#endif // !
