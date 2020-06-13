
public class LampThread implements Runnable{

	private Lampe lampe;
	private State state;
	private Foerderband fb;
	private int sleeptime;
	private boolean stopme;
	
	LampThread(Lampe _inp, State _st, Foerderband _fb){
		lampe = _inp;
		state = _st;
		fb = _fb;
		stopme = false;
		if(state==State.einhertzblinken) {
			sleeptime = 1000;
		}else {
			sleeptime = 2000;
		}
			
		
	}
	
	public void stopThread() {
		stopme = true;
	}
	
	public void run() {
		while(!stopme) {
			gui.planeChange(lampe, State.an, fb, true);
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("FATAL ERROR IN LAMP BLINKING THREAD");
				System.exit(1);
			}
			if(stopme) {
				return;
			}
			gui.planeChange(lampe, State.aus, fb, true);
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("FATAL ERROR IN LAMP BLINKING THREAD");
				System.exit(1);
			}
		}
	}

}
