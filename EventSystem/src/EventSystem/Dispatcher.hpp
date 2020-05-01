#if !defined(Dispatcher_h)
#define Dispatcher_h
#include <map>
#include "EnumDummy.hpp"
#include "IEventObserver.hpp"
#include <vector>
class Dispatcher
{
private:
    std::map<EventTyp,std::vector<IEventObserver*>> subscriber;
    
public:
    Dispatcher(/* args */);
    ~Dispatcher();
};




#endif