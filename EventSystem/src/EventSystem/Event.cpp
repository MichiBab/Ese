/*
 * Event.cpp
 *
 *  Created on: April 30, 2020
 *      Author: Anja Schmidt
 */

#include <iostream>
#include "Event.hpp"

EventTyp Event::return_Event_typ(){
        return event_typ;
    }

Event::Event(EventTyp event_typ) {
    this->payload_typ = PayloadTyp::NONE;
	this->event_typ = event_typ;
	this->payload.hoehenmesswert = -1;
}

Event::Event(EventTyp event_typ, int payload){
	this->event_typ = event_typ;
    this->payload_typ = PayloadTyp::HOEHENMESSWERT;
	this->payload.hoehenmesswert = payload;
}
Event::Event(EventTyp event_typ, std::shared_ptr<Werkstueck>& payload) {
    this->payload_typ = PayloadTyp::WERKSTUECK_POINTER;
	this->event_typ = event_typ;
	this->payload.werkstueck = payload;
}

Event::Event(const Event &event) {
    this->event_typ = event.event_typ;
    this->payload_typ = event.payload_typ;
    if (this->payload_typ == HOEHENMESSWERT) {
        this->payload.hoehenmesswert = event.payload.hoehenmesswert;
    } else if (this->payload_typ == WERKSTUECK_POINTER) {
        this->payload.werkstueck = event.payload.werkstueck;
    } else {
        this->payload.hoehenmesswert = -1;
    }

}

Event &Event::operator=(const Event &other) {
    if (this!=&other){
        this->event_typ = other.event_typ;
        this->payload_typ = other.payload_typ;
        if (this->payload_typ == HOEHENMESSWERT) {
            this->payload.hoehenmesswert = other.payload.hoehenmesswert;
        } else if (this->payload_typ == WERKSTUECK_POINTER) {
            this->payload.werkstueck = other.payload.werkstueck;
        } else {
            this->payload.hoehenmesswert = -1;
        }
    }
    return *this;
}

EventTyp Event::get_event_typ() {
	return this->event_typ;
}

int Event::get_hoehenmesswert() {
    if (this->payload_typ == PayloadTyp::HOEHENMESSWERT) {
        return this->payload.hoehenmesswert;
    }
    std::cerr << "get_werkstueck() called but payload is not of type HOEHENMESSWERT" << std::endl;
    throw std::exception();
}

std::shared_ptr<Werkstueck> Event::get_werkstueck() {
    if (this->payload_typ == PayloadTyp::WERKSTUECK_POINTER) {
        return this->payload.werkstueck;
    }
    std::cerr << "get_werkstueck() called but payload is not of type WERKSTUECK_POINTER" << std::endl;
    throw std::exception();
}

Payload::Payload() {}
Payload::~Payload() {}






