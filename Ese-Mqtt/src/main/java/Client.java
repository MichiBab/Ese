
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Client implements MqttCallback {

	private String con_url;
	private MqttClient client;
	private int qos;
	private String id;
	private boolean callback_flagged = false;
	private int timeout = 5; // max response time for connect()

	private Controller my_controller;

	Client(Controller controller, String con_url, int qos, String _id) {
		this.my_controller = controller;
		this.qos = qos;
		if (qos < 0 || qos > 3) {
			System.out.println("Pub: BAD QOS");
			System.exit(1);
		}
		this.con_url = con_url;
		this.id = _id;

	}

	public String connectToBroker() {
		String broker = con_url;
		String clientId = id;
		MemoryPersistence persistence = new MemoryPersistence();
		try {
			client = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("Connecting to broker: " + broker);
			connOpts.setConnectionTimeout(timeout);
			client.connect(connOpts);
			System.out.println("Connected");
		} catch (MqttException e) {
			e.printStackTrace();
			return "Connection Failed";
		}
		return "Connected";
	}

	void publishMsgOnTopic(String topic, String msg) {
		publishMsgOnTopic(topic, msg, qos);
	}

	void publishMsgOnTopic(String topic, String msg, int _qos) {
		try {
			System.out.println("Pub: Publishing message on Topic: " + topic);
			MqttMessage message = new MqttMessage(msg.getBytes());
			message.setQos(_qos);
			client.publish(topic, message);
			System.out.println("Pub: Message published");

		} catch (MqttException me) {
			me.printStackTrace();
		}
	}

	void disconnect() {
		try {
			client.disconnect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
		System.out.println("Disconnected");
	}

	void subscribeToTopic(String topic) {
		subscribeToTopic(topic, qos);
	}

	boolean subscribeToTopic(String topic, int _qos) {
		try {
			if (!callback_flagged) {
				this.client.setCallback(this);
				callback_flagged = true;
			}

			this.client.subscribe(topic, _qos);
			System.out.println("Subscribed");
			return true;
		} catch (MqttException e) {
			e.printStackTrace();
			return false;
		}
	}

	boolean unsubscribeToTopic(String topic) {
		try {
			this.client.unsubscribe(topic);
			System.out.println("Unsubscribed");
			return true;
		} catch (MqttException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost because: " + cause);
		my_controller.setDisconnectedFlag();
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		Foerderband fb; 
		String msg = new String(message.getPayload());
		if(msg.startsWith("FB1")) {
			fb = Foerderband.fb1;
		}
		else if(msg.startsWith("FB2")) {
			fb = Foerderband.fb2;
		}
		else {
			System.out.println("GOT THE WRONG MESSAGE FROM A TOPIC!");
			System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));
			return;
		}
		
		if(topic.contentEquals("/foerderband/led/StartLed/An")) {
			gui.planeChange(Lampe.startled, State.an, fb);
		}
		if(topic.contentEquals("/foerderband/led/StartLed/Aus")) {
			gui.planeChange(Lampe.startled, State.aus, fb);
		}
		if(topic.contentEquals("/foerderband/led/ResetLed/An")) {
			gui.planeChange(Lampe.resetled, State.an, fb);
		}
		if(topic.contentEquals("/foerderband/led/ResetLed/Aus")) {
			gui.planeChange(Lampe.resetled, State.aus, fb);
		}
		if(topic.contentEquals("/foerderband/led/q1led/An")) {
			gui.planeChange(Lampe.q1led, State.an, fb);
		}
		if(topic.contentEquals("/foerderband/led/q1led/Aus")) {
			gui.planeChange(Lampe.q1led, State.aus, fb);
		}
		if(topic.contentEquals("/foerderband/led/q2led/An")) {
			gui.planeChange(Lampe.q2led, State.an, fb);
		}
		if(topic.contentEquals("/foerderband/led/q2led/Aus")) {
			gui.planeChange(Lampe.q2led, State.aus, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/rot/an")) {
			gui.planeChange(Lampe.rot, State.an, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/rot/blienken/halb")) {
			gui.planeChange(Lampe.rot, State.halbhertzblinken, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/rot/blinken/eins")) {
			gui.planeChange(Lampe.rot, State.einhertzblinken, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/rot/aus")) {
			gui.planeChange(Lampe.rot, State.aus, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gruen/an")) {
			gui.planeChange(Lampe.gruen, State.an, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gruen/blinken/halb")) {
			gui.planeChange(Lampe.gruen, State.halbhertzblinken, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gruen/blinken/eins")) {
			gui.planeChange(Lampe.gruen, State.einhertzblinken, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gruen/aus")) {
			gui.planeChange(Lampe.gruen, State.aus, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gelb/an")) {
			gui.planeChange(Lampe.gelb, State.an, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gelb/blinken/halb")) {
			gui.planeChange(Lampe.gelb, State.halbhertzblinken, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gelb/blinken/eins")) {
			gui.planeChange(Lampe.gelb, State.einhertzblinken, fb);
		}
		if(topic.contentEquals("/foerderband/lampe/gelb/aus")) {
			gui.planeChange(Lampe.gelb, State.aus, fb);
		}
		if(topic.contentEquals("/foerderband/log")) {
			gui.appendToLog(String.format("[%s] %s", topic, msg));
		}
		if(topic.contentEquals("/foerderband/disconnected")){
			for(Lampe lamp: Lampe.values()) {
				gui.planeChange(lamp,State.aus,fb);
			}
			gui.appendToLog(msg + " IS DISCONNECTED");
		}
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}

}
