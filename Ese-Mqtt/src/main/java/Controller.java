
public class Controller {

	private Client client;

	private int default_qos = 1;
	private boolean is_connected = false;

	Controller() {

	}

	Controller(int default_qos_change) {
		default_qos = default_qos_change;
	}

	synchronized void setDisconnectedFlag() {
		is_connected = false;
		gui.signaliseDisconnected();
	}

	String initController(String IP) {
		if (is_connected) {
			return "Already Connected";
		}
		client = new Client(this, IP, default_qos, "Controller");
		String erg = client.connectToBroker();
		if (erg.equals("Connected")) {
			is_connected = true;
		}
		return erg;
	}

	public boolean disconnect() {
		if (is_connected) {
			client.disconnect();
			is_connected = false;
			return true;
		}
		return false;
	}

	boolean subToTopic(String topic, int qos) {
		if (is_connected) {
			return client.subscribeToTopic(topic, qos);
		}
		return false;
	}

	boolean unsubToTopic(String topic) {
		if (is_connected) {
			return client.unsubscribeToTopic(topic);
		}
		return false;
	}

	void publish(String topic, String msg, int qos) {
		if (is_connected) {
			client.publishMsgOnTopic(topic, msg, qos);
		}
	}

}
