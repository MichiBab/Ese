/*
 * EventTyp.h
 *
 *  Created on: April 30, 2020
 *      Author: Anja Schmidt
 */

#ifndef EVENT_SYSTEM_EVENTTYP_H_
#define EVENT_SYSTEM_EVENTTYP_H_

enum EventTyp {
	EnumHead,
	NO_EVENT,

	LICHTSCHRANKE_EINLAUF1_UNTERBROCHEN,
	LICHTSCHRANKE_EINLAUF1_FREI,
	LICHTSCHRANKE_EINLAUF2_UNTERBROCHEN,
	LICHTSCHRANKE_EINLAUF2_FREI,
	LICHTSCHRANKE_HOEHENMESSUNG_UNTERBROCHEN,
	LICHTSCHRANKE_HOEHENMESSUNG_FREI,
	LICHTSCHRANKE_AUSSORTIERUNG_UNTERBROCHEN,
	LICHTSCHRANKE_AUSSORTIERUNG_FREI,
	LICHTSCHRANKE_AUSLAUF_UNTERBROCHEN,
	LICHTSCHRANKE_AUSLAUF_FREI,
	LICHTSCHRANKE_RUTSCHE1_UNTERBROCHEN,
	LICHTSCHRANKE_RUTSCHE1_FREI,
	LICHTSCHRANKE_RUTSCHE2_UNTERBROCHEN,
	LICHTSCHRANKE_RUTSCHE2_FREI,

    HOEHENMESSWERT_SIGNAL,

	MOTOR_RECHTSLAUF,
	MOTOR_LINKSLAUF,
	MOTOR_LANGSAM,
	MOTOR_SCHNELL,
	MOTOR_STOP,

	ROTE_LAMPE_AN,
	ROTE_LAMPE_AUS,

	GRUENE_LAMPE_AN,
	GRUENE_LAMPE_AUS,
	GELBE_LAMPE_AN,
	GELBE_LAMPE_AUS,

	START_LED_AN,
	START_LED_AUS,

	RESET1_LED_AN,
	RESET1_LED_AUS,
	RESET2_LED_AN,
	RESET2_LED_AUS,

	Q1_LED_AN,
	Q1_LED_AUS,
	Q2_LED_AN,
	Q2_LED_AUS,

	WEICHE_SCHLIESSEN,
	WEICHE_OEFFNEN,

	AUSWERFER_AUSFAHREN,
	AUSWERFER_EINFAHREN,
	ABSTAND_EINGEHALTEN,

	SORTIERMODE_WECHSEL,

	FOERDERBAND_STOPP,
	FOERDERBAND_START,

	UEBERGABE_WARTEND,
	UEBERGABE_GESTARTET,

	START_IST_GEDRUECKT,
	STOP_IST_GEDRUECKT,

	RESET1_IST_GEDRUECKT,
	RESET2_IST_GEDRUECKT,

	E_STOP1_IST_GEDRUECKT,
	E_STOP2_IST_GEDRUECKT,
	E_STOP1_IST_GELOEST,
	E_STOP2_IST_GELOEST,

	FEHLER_RUTSCHE1_VOLL,
	FEHLER_RUTSCHE1_VOLL_BEHOBEN,
	FEHLER_RUTSCHE2_VOLL,
	FEHLER_RUTSCHE2_VOLL_BEHOBEN,

	START_FEHLER_TIMER,
	START_WARNUNG_TIMER,
	START_SERVICE_TIMER,
	START_BEITRITT_TIMER,
	START_ABSTAND_TIMER,
	START_WEICHE_TIMER,

	TIMEOUT_FEHLER,
	TIMEOUT_WARNUNG,
	TIMEOUT_SERVICE,
	TIMEOUT_BEITRITT,
	TIMEOUT_WEICHE,
	TIMEOUT_ABSTAND,

	START_KALIBRIERUNG_SCHNELL_TIMER,
	START_KALIBRIERUNG_LANGSAM_TIMER,
	STOP_KALIBRIERUNG_SCHNELL_TIMER,
	STOP_KALIBRIERUNG_LANGSAM_TIMER,

	WERKSTUECK_EINLAUF_VERLASSEN,
	WERKSTUECK_HOEHENMESSUNG_VERLASSEN,
	WERKSTUECK_MODUL1_AUFGELEGT,
	WERKSTUECK_AUSSORTIERUNG_VERLASSEN,
	WERKSTUECK_MODUL1_VERLASSEN,
	WERKSTUECK_MODUL2_VERLASSEN,
	EnumTail
};



#endif /* EVENT_SYSTEM_EVENTTYP_H_ */
