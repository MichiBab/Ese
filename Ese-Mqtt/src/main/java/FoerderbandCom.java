import java.util.HashMap;
import java.util.Map;

public class FoerderbandCom {

	public Map<String, Integer> topicsmap;

	FoerderbandCom() {
		topicsmap = new HashMap<String, Integer>();
		initTopicsList();
	}

	private void initTopicsList() {
		// Events
		//LEDS
		//@all leds: (Schalte Led an/aus an fb1/fb2 => Change Colour of Plane)
		topicsmap.put("/foerderband/led/StartLed/An",1);
		topicsmap.put("/foerderband/led/StartLed/Aus",1);
		topicsmap.put("/foerderband/led/ResetLed/An",1);
		topicsmap.put("/foerderband/led/ResetLed/Aus",1);
		topicsmap.put("/foerderband/led/q1led/An",1);		   
		topicsmap.put("/foerderband/led/q1led/Aus",1);			
		topicsmap.put("/foerderband/led/q2led/An",1);
		topicsmap.put("/foerderband/led/q2led/Aus",1);
		//LAMPEN
		topicsmap.put("/foerderband/lampe/rot/an",1);				//lampeAn("rot",FB)
		topicsmap.put("/foerderband/lampe/rot/blienken/halb",1);		//lampeBlinkenHertz("rot",0.5,FB)
		topicsmap.put("/foerderband/lampe/rot/blinken/eins",1);		//lampeBlinkenHertz("rot",1.0,FB)
		topicsmap.put("/foerderband/lampe/rot/aus",1);				//lampeAus("rot",FB)
		topicsmap.put("/foerderband/lampe/gruen/an",1);				//lampeAn("gruen",FB)
		topicsmap.put("/foerderband/lampe/gruen/blinken/halb",1);	//lampeBlinkenHertz("gruen",0.5,FB)
		topicsmap.put("/foerderband/lampe/gruen/blinken/eins",1);	//lampeBlinkenHertz("gruen",1.0,FB)
		topicsmap.put("/foerderband/lampe/gruen/aus",1);				//lampeAus("gruen",FB)
		topicsmap.put("/foerderband/lampe/gelb/an",1);				//lampeAn("gelb",FB)
		topicsmap.put("/foerderband/lampe/gelb/blinken/halb",1);		//lampeBlinkenHertz("gelb",0.5,FB)
		topicsmap.put("/foerderband/lampe/gelb/blinken/eins",1);		//lampeBlinkenHertz("gelb",1.0,FB)
		topicsmap.put("/foerderband/lampe/gelb/aus",1);				//lampeAus("gelb",FB)
		//LOG
		topicsmap.put("/foerderband/log",1);							//printLogEvent(STRINGMSG)
		
		//STATES
		topicsmap.put("/foerderband/disconnected",1);
		

	}

}
/*
 * DOKUMENTATION: UNTERSCHEIDUNG DER FB's DURCH GESENDETE MSG "FB1" ODER "FB2"!
 * 
 * ---FOERDERBAND 1 / 2 MÜSSEN DARAUF ABONNIEREN-----------------------------------------------
 * ACTION: TOPIC: FOERDERBANDEVENT
 * 	IF a / b ==> a=fb1; b=fb2 (if string msg == "FB1" oder "FB2")
 * 
 * StartKnopf: 		remote/event/startknopf: 	Start1IstGedrueckt() / Start2IstGedrueckt()
 * 												FOLGEND	  IF(FB1) Start1IstGeloest()
 * StopKnopf: 		remote/event/stopknopf: 	StopIstGedrueckt()
 * ResetKnopf: 		remote/event/resetknopf: 	Reset1IstGedrueckt() / Reset2IstGedrueckt()
 * ServiceKnopf:	remote/event/servicemode:	Start1IstGedrueckt(), sleep(5sec), Start1IstGeloest()
 * 
 * ---DIE GUI MUSS DARAUF ABONNIEREN:-----------------------------------------------------------
 * FOERDEERBANDEVENT: TOPIC: ACTION
 * 
 * StartLedAn(): 					foerderband/led/StartLed/An: 
 * StartLedAus(): 					foerderband/led/StartLed/Aus:
 * ResetLedAn(): 					foerderband/led/ResetLed/An: 
 * ResetLedAus(): 					foerderband/led/ResetLed/Aus: = @all leds: (Schalte Led an/aus 
 * Q1LedAn(): 						foerderband/led/q1led/An:	   			    an fb1/fb2 => Change 
 * Q1LedAus(): 						foerderband/led/q1led/Aus:   			    Colour of Plane)
 * Q2LedAn(): 						foerderband/led/q2led/An:    
 * Q2LedAus(): 						foerderband/led/q2led/Aus:   
 * 																		FB=FB1||FB2 (STRING IN MSG)
 * RoteLampeAn(): 					foerderband/lampe/rot/an:				lampeAn("rot",FB)
 * RoteLampeBlinkenHalbenHertz(): 	foerderband/lampe/rot/blienken/halb:	lampeBlinkenHertz("rot",0.5,FB)
 * RoteLampeBlinkenEinHertz(): 		foerderband/lampe/rot/blinken/eins:		lampeBlinkenHertz("rot",1.0,FB)
 * RoteLampeAus(): 					foerderband/lampe/rot/aus:				lampeAus("rot",FB)
 * GrueneLampeAn(): 				foerderband/lampe/gruen/an:				lampeAn("gruen",FB)
 * GrueneLampeBlinkenHalbenHertz(): foerderband/lampe/gruen/blinken/halb:	lampeBlinkenHertz("gruen",0.5,FB)
 * GrueneLampeBlinkenEinHertz(): 	foerderband/lampe/gruen/blinken/eins:	lampeBlinkenHertz("gruen",1.0,FB)
 * GrueneLampeAus(): 				foerderband/lampe/gruen/aus:			lampeAus("gruen",FB)
 * GelbeLampeAn(): 					foerderband/lampe/gelb/an:				lampeAn("gelb",FB)
 * GelbeLampeBlinkenHalbenHertz(): 	foerderband/lampe/gelb/blinken/halb:	lampeBlinkenHertz("gelb",0.5,FB)
 * GelbeLampeBlinkenEinHertz(): 	foerderband/lampe/gelb/blinken/eins:	lampeBlinkenHertz("gelb",1.0,FB)
 * GelbeLampeAus(): 				foerderband/lampe/gelb/aus:				lampeAus("gelb",FB)
 * 
 * 
 * LogEvent()|STRINGMSG:			foerderband/log:						printLogEvent(STRINGMSG)
 * 
 * */


