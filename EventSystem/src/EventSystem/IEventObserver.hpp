/*
 * IEventObserver.hpp
 *
 *  Created on: May 1, 2020
 *      Author: Michael Babic
 */


#if !defined(IEventObserver_h)
#define IEventObserver_h
#include "Event.hpp"

class IEventObserver
{
protected:
    IEventObserver(){};
public:
    virtual ~IEventObserver() {};
    virtual void notify(Event event) = 0;
};



#endif // !
