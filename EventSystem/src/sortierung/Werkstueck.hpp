/*
 * Werkstueck.h
 *
 *  Created on: May 1, 2020
 *      Author: Anja Schmidt
 */

#ifndef SORTIERUNG_WERKSTUECK_H
#define SORTIERUNG_WERKSTUECK_H

#include "Werkstuecktyp.hpp"

class Werkstueck {
private:
    WerkstueckTyp typ1;
    WerkstueckTyp typ2;
    char kodierung;
    bool metall;
    bool ueberschlagen;
    bool ungueltig;
public:
    Werkstueck();
};

#endif //SORTIERUNG_WERKSTUECK_H
