#if !defined(Eventd_h)
#define Eventd_h
#include "EnumDummy.hpp"

class Event
{
private:
    /* data */
    EventTyp my_type;
public:
    Event(EventTyp type);
    ~Event();
    EventTyp return_Event_typ();
};

#endif //