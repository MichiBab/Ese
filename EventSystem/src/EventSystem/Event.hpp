/*
 * Event.h
 *
 *  Created on: April 30, 2020
 *      Author: Anja Schmidt
 */

#ifndef EVENT_SYSTEM_EVENT_H_
#define EVENT_SYSTEM_EVENT_H_

#include <memory>
#include "EventTyp.hpp"
#include "../sortierung/Werkstueck.hpp"

enum PayloadTyp {
    NONE,
    HOEHENMESSWERT,
    WERKSTUECK_POINTER,
};

union Payload {
public:
    int hoehenmesswert;
    std::shared_ptr<Werkstueck> werkstueck;

    Payload();
    ~Payload();
};

class Event {
private:
    EventTyp event_typ;
    PayloadTyp payload_typ;
    Payload payload;

public:
	explicit Event(EventTyp event_typ);
	Event(EventTyp event_typ, int payload);
	Event(EventTyp event_typ, std::shared_ptr<Werkstueck>& payload);
    Event(const Event &event);
    EventTyp return_Event_typ();

    Event& operator=(const Event& other);

	EventTyp get_event_typ();
	int get_hoehenmesswert();
    std::shared_ptr<Werkstueck> get_werkstueck();

};



#endif /* EVENT_SYSTEM_EVENT_H_ */
