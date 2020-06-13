import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.DefaultCaret;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ListModel;
import javax.swing.JRadioButton;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import java.util.HashMap;
import javax.swing.JTabbedPane;
public class gui {

	// for abrupt disconnect
	private static JTextField connect_status;
	private static DefaultListModel<String> listModel;
	private static DefaultListModel<String> logList;
	private JFrame frame;
	private JTextField txt_enter_ip;
	private static JSpinner spinner_1;
	private JSpinner spinner;
	private final Action connect = new SwingAction();
	private JList list;
	private static JScrollPane scrollPane;
	static Controller controller;
	private final Action action = new SwingAction_1();
	private JTextField textField;
	private final Action action_1 = new SwingAction_2();
	private final Action action_2 = new SwingAction_3();
	private final Action action_3 = new SwingAction_4();
	private final Action action_4 = new SwingAction_5();
	private JTextField pubtext;
	private final Action action_5 = new SwingAction_6();
	private static FoerderbandCom comlist;
	private static int maxLogSize = 30;
	private JTextField publishing;
	private static String fb1_String = "FB1";
	private static String fb2_String = "FB2";
	private static JPanel fb1q1led;
	private static JPanel fb1q2led;
	private static JPanel fb1grueneLampe;
	private static JPanel fb1gelbeLampe;
	private static JPanel fb1roteLampe;
	private static JPanel fb2q1led;
	private static JPanel fb2q2led;
	private static JPanel fb2grueneLampe;
	private static JPanel fb2gelbeLampe;
	private static JPanel fb2roteLampe;
	private static JPanel fb1startled;
	private static JPanel fb2startled;
	private static JPanel fb1resetled;
	private static JPanel fb2resetled;
	
	private static Thread fb1yellowlampthread;
	private static Thread fb1greenlampthread;
	private static Thread fb1redlampthread;
	private static LampThread fb1yellowlamprunnable;
	private static LampThread fb1greenlamprunnable;
	private static LampThread fb1redlamprunnable;
	private static Thread fb2yellowlampthread;
	private static Thread fb2greenlampthread;
	private static Thread fb2redlampthread;
	private static LampThread fb2yellowlamprunnable;
	private static LampThread fb2greenlamprunnable;
	private static LampThread fb2redlamprunnable;
	private static String STANDARD_IP = "127.0.0.1";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// init controller
		controller = new Controller();
		// init foerderbandcom
		comlist = new FoerderbandCom();

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					// Set System L&F
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (UnsupportedLookAndFeelException e) {
					// handle exception
				} catch (ClassNotFoundException e) {
					// handle exception
				} catch (InstantiationException e) {
					// handle exception
				} catch (IllegalAccessException e) {
					// handle exception
				}
				
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				standard_behaviour();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 989, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 0, 2, 1);

		listModel = new DefaultListModel<String>();

		logList = new DefaultListModel<String>();
		
				connect_status = new JTextField();
				connect_status.setBounds(741, 40, 213, 25);
				frame.getContentPane().add(connect_status);
				connect_status.setEditable(false);
				connect_status.setColumns(10);
		
				JTextPane txtpnStatus = new JTextPane();
				txtpnStatus.setBounds(550, 40, 203, 21);
				frame.getContentPane().add(txtpnStatus);
				txtpnStatus.setFont(new Font("Dialog", Font.PLAIN, 18));
				txtpnStatus.setEditable(false);
				txtpnStatus.setText("Connection Status:");
		JList<String> log = new JList<String>(logList);
		log.setForeground(new Color(255, 255, 255));
		log.setFont(new Font("Dialog", Font.BOLD, 12));
		frame.getContentPane().add(log);
		log.setBackground(Color.GRAY);
		log.setBounds(480, 262, 210, 197);
		scrollPane = new JScrollPane(log);
		scrollPane.setSize(419, 405);
		scrollPane.setLocation(550, 120);
		frame.getContentPane().add(scrollPane);

		JLabel lblTopicsLog = new JLabel("FOERDERBAND LOG:");
		lblTopicsLog.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTopicsLog.setBounds(550, 100, 213, 15);
		frame.getContentPane().add(lblTopicsLog);
		
		SpinnerNumberModel model2 = new SpinnerNumberModel(1, 0, 2, 1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1412, 605);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Standard = new JPanel();
		tabbedPane.addTab("Foerderband Kommunikation", null, Standard, null);
		Standard.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 72, 419, 158);
		Standard.add(panel);
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Start");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startKnopf(fb1_String);
			}
		});
		btnNewButton_1.setBounds(33, 22, 87, 58);
		panel.add(btnNewButton_1);
		
		fb1grueneLampe = new JPanel();
		fb1grueneLampe.setBounds(175, 107, 66, 39);
		panel.add(fb1grueneLampe);
		
		fb1gelbeLampe = new JPanel();
		fb1gelbeLampe.setBounds(258, 107, 66, 39);
		panel.add(fb1gelbeLampe);
		
		fb1roteLampe = new JPanel();
		fb1roteLampe.setBounds(336, 107, 66, 39);
		panel.add(fb1roteLampe);
		
		JLabel lblR = new JLabel("G");
		lblR.setFont(new Font("Dialog", Font.BOLD, 14));
		lblR.setForeground(Color.WHITE);
		lblR.setBounds(175, 93, 34, 15);
		panel.add(lblR);
		
		JLabel lblG = new JLabel("Y");
		lblG.setFont(new Font("Dialog", Font.BOLD, 14));
		lblG.setForeground(Color.WHITE);
		lblG.setBounds(259, 93, 34, 15);
		panel.add(lblG);
		
		JLabel lblB = new JLabel("R");
		lblB.setFont(new Font("Dialog", Font.BOLD, 14));
		lblB.setForeground(Color.WHITE);
		lblB.setBounds(336, 93, 34, 15);
		panel.add(lblB);
		
		JLabel lblLampen = new JLabel("Lamps:");
		lblLampen.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLampen.setForeground(Color.WHITE);
		lblLampen.setBounds(85, 107, 78, 39);
		panel.add(lblLampen);
		
		fb1startled = new JPanel();
		fb1startled.setBounds(111, 22, 23, 58);
		panel.add(fb1startled);
		
		JButton btnNewButton_1_1 = new JButton("Stop");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopKnopf(fb1_String);
			}
		});
		btnNewButton_1_1.setBounds(154, 22, 87, 58);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Reset");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetKnopf(fb1_String);
			}
		});
		btnNewButton_1_2.setBounds(269, 22, 87, 58);
		panel.add(btnNewButton_1_2);
		
		fb1resetled = new JPanel();
		fb1resetled.setBounds(347, 22, 23, 58);
		panel.add(fb1resetled);
		
		fb1q2led = new JPanel();
		fb1q2led.setBounds(43, 107, 23, 43);
		panel.add(fb1q2led);
		
		fb1q1led = new JPanel();
		fb1q1led.setBounds(12, 107, 23, 43);
		panel.add(fb1q1led);
		
		JLabel lblQ_2 = new JLabel("Q1");
		lblQ_2.setForeground(Color.WHITE);
		lblQ_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQ_2.setBounds(12, 92, 28, 16);
		panel.add(lblQ_2);
		
		JLabel lblQ_1_1 = new JLabel("Q2");
		lblQ_1_1.setForeground(Color.WHITE);
		lblQ_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQ_1_1.setBounds(43, 92, 28, 16);
		panel.add(lblQ_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(45, 316, 419, 158);
		Standard.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.GRAY);
		
		JButton btnNewButton_1_3 = new JButton("Start");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startKnopf(fb2_String);
			}
		});
		btnNewButton_1_3.setBounds(33, 22, 87, 58);
		panel_2.add(btnNewButton_1_3);
		
		fb2grueneLampe = new JPanel();
		fb2grueneLampe.setBounds(175, 107, 66, 39);
		panel_2.add(fb2grueneLampe);
		
		fb2gelbeLampe = new JPanel();
		fb2gelbeLampe.setBounds(258, 107, 66, 39);
		panel_2.add(fb2gelbeLampe);
		
		fb2roteLampe = new JPanel();
		fb2roteLampe.setBounds(336, 107, 66, 39);
		panel_2.add(fb2roteLampe);
		
		JLabel lblR_1 = new JLabel("G");
		lblR_1.setForeground(Color.WHITE);
		lblR_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblR_1.setBounds(175, 93, 34, 15);
		panel_2.add(lblR_1);
		
		JLabel lblG_1 = new JLabel("Y");
		lblG_1.setForeground(Color.WHITE);
		lblG_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblG_1.setBounds(259, 93, 34, 15);
		panel_2.add(lblG_1);
		
		JLabel lblB_1 = new JLabel("R");
		lblB_1.setForeground(Color.WHITE);
		lblB_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblB_1.setBounds(336, 93, 34, 15);
		panel_2.add(lblB_1);
		
		JLabel lblLampen_1 = new JLabel("Lamps:");
		lblLampen_1.setForeground(Color.WHITE);
		lblLampen_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLampen_1.setBounds(85, 107, 78, 39);
		panel_2.add(lblLampen_1);
		
		fb2startled = new JPanel();
		fb2startled.setBounds(111, 22, 23, 58);
		panel_2.add(fb2startled);
		
		JButton btnNewButton_1_1_1 = new JButton("Stop");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopKnopf(fb2_String);
			}
		});
		btnNewButton_1_1_1.setBounds(154, 22, 87, 58);
		panel_2.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Reset");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetKnopf(fb2_String);
			}
		});
		btnNewButton_1_2_1.setBounds(269, 22, 87, 58);
		panel_2.add(btnNewButton_1_2_1);
		
		fb2resetled = new JPanel();
		fb2resetled.setBounds(347, 22, 23, 58);
		panel_2.add(fb2resetled);
		
		fb2q1led = new JPanel();
		fb2q1led.setBounds(12, 107, 23, 43);
		panel_2.add(fb2q1led);
		
		fb2q2led = new JPanel();
		fb2q2led.setBounds(43, 107, 23, 43);
		panel_2.add(fb2q2led);
		
		JLabel lblQ = new JLabel("Q1");
		lblQ.setForeground(Color.WHITE);
		lblQ.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQ.setBounds(12, 92, 28, 16);
		panel_2.add(lblQ);
		
		JLabel lblQ_3 = new JLabel("Q2");
		lblQ_3.setForeground(Color.WHITE);
		lblQ_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQ_3.setBounds(43, 92, 28, 16);
		panel_2.add(lblQ_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(295, 7, 169, 53);
		Standard.add(panel_1);
		panel_1.setBackground(Color.GRAY);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Service Mode");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serviceKnopf();
			}
		});
		btnNewButton_2.setBounds(12, 12, 145, 30);
		panel_1.add(btnNewButton_2);
		
		JLabel lblFoerderband = new JLabel("FOERDERBAND 1:");
		lblFoerderband.setBounds(47, 0, 867, 65);
		Standard.add(lblFoerderband);
		lblFoerderband.setFont(new Font("Dialog", Font.BOLD, 24));
		
		JLabel lblFoerderband_2 = new JLabel("FOERDERBAND 2:");
		lblFoerderband_2.setBounds(45, 259, 271, 45);
		Standard.add(lblFoerderband_2);
		lblFoerderband_2.setFont(new Font("Dialog", Font.BOLD, 24));
		
		JPanel Develop = new JPanel();
		tabbedPane.addTab("Develop", null, Develop, null);
		Develop.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Subscribed Topics List:");
				lblNewLabel.setBounds(13, 247, 213, 15);
				Develop.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
				list = new JList<String>(listModel);
				list.setForeground(new Color(0, 0, 0));
				JScrollPane listscroll = new JScrollPane(list);
				listscroll.setBounds(13, 263, 333, 237);
				Develop.add(listscroll);
				list.setBackground(Color.WHITE);
				list.setBounds(12, 249, 272, 247);
				listscroll.setBackground(Color.WHITE);
				
						JTextPane txtpnPublishMessageOn = new JTextPane();
						txtpnPublishMessageOn.setBounds(366, 263, 161, 94);
						Develop.add(txtpnPublishMessageOn);
						txtpnPublishMessageOn.setFont(new Font("Dialog", Font.PLAIN, 14));
						txtpnPublishMessageOn.setText("Publish message on selected Topic or enter a topic with QoS below:");
						txtpnPublishMessageOn.setEditable(false);
						spinner_1 = new JSpinner(model2);
						spinner_1.setBounds(508, 363, 29, 20);
						Develop.add(spinner_1);
						spinner_1.setFont(new Font("Dialog", Font.BOLD, 14));
						spinner_1.setEditor(new JSpinner.DefaultEditor(spinner_1));
						
						publishing = new JTextField();
						publishing.setBounds(358, 357, 146, 31);
						Develop.add(publishing);
						publishing.setColumns(10);
						
								pubtext = new JTextField();
								pubtext.setBounds(366, 420, 161, 46);
								Develop.add(pubtext);
								pubtext.setColumns(10);
								
										JButton btnPublish = new JButton("Publish");
										btnPublish.setBounds(389, 469, 117, 25);
										Develop.add(btnPublish);
										btnPublish.setFont(new Font("Dialog", Font.BOLD, 14));
										btnPublish.setAction(action_5);
										
										JLabel lblMsg = new JLabel("Msg:");
										lblMsg.setBounds(364, 395, 166, 15);
										Develop.add(lblMsg);
										lblMsg.setFont(new Font("Dialog", Font.BOLD, 14));
										
												JButton btnNewButton = new JButton("Sub to Foerderband List");
												btnNewButton.setBounds(13, 142, 333, 25);
												Develop.add(btnNewButton);
												btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
												btnNewButton.setAction(action_3);
												
														JButton btnUnsubToFoerderband = new JButton("Unsub to Foerderband List");
														btnUnsubToFoerderband.setBounds(13, 179, 333, 25);
														Develop.add(btnUnsubToFoerderband);
														btnUnsubToFoerderband.setFont(new Font("Dialog", Font.BOLD, 14));
														btnUnsubToFoerderband.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																Iterator<Entry<String, Integer>> it = comlist.topicsmap.entrySet().iterator();
																while (it.hasNext()) {
																	@SuppressWarnings("rawtypes")
																	Map.Entry pair = (Map.Entry) it.next();
																	unsubToTopic((String) pair.getKey());
																	// System.out.println((String)pair.getKey());
																}
															}
														});
														btnUnsubToFoerderband.setAction(action_4);
														
																JButton btnSubscribe = new JButton("Subscribe");
																btnSubscribe.setBounds(210, 108, 135, 25);
																Develop.add(btnSubscribe);
																btnSubscribe.setFont(new Font("Dialog", Font.BOLD, 14));
																btnSubscribe.setAction(action_1);
																
																		JButton btnUnsubscribe = new JButton("Unsubscribe");
																		btnUnsubscribe.setBounds(210, 70, 135, 25);
																		Develop.add(btnUnsubscribe);
																		btnUnsubscribe.setFont(new Font("Dialog", Font.BOLD, 14));
																		btnUnsubscribe.setAction(action_2);
																		spinner = new JSpinner(model1);
																		spinner.setBounds(170, 70, 29, 20);
																		Develop.add(spinner);
																		spinner.setFont(new Font("Dialog", Font.BOLD, 14));
																		spinner.setEditor(new JSpinner.DefaultEditor(spinner));
																		
																				textField = new JTextField();
																				textField.setBounds(13, 101, 186, 31);
																				Develop.add(textField);
																				textField.setColumns(10);
																				
																						txt_enter_ip = new JTextField();
																						txt_enter_ip.setBounds(91, 12, 254, 25);
																						Develop.add(txt_enter_ip);
																						txt_enter_ip.setColumns(10);
																						
																								JTextPane txtpnIP = new JTextPane();
																								txtpnIP.setBounds(12, 12, 70, 21);
																								Develop.add(txtpnIP);
																								txtpnIP.setFont(new Font("Dialog", Font.PLAIN, 14));
																								txtpnIP.setText("Enter IP:");
																								txtpnIP.setEditable(false);
																												
																														JButton btnDisconnect = new JButton("Disconnect");
																														btnDisconnect.setBounds(357, 39, 112, 25);
																														Develop.add(btnDisconnect);
																														btnDisconnect.setFont(new Font("Dialog", Font.BOLD, 14));
																														btnDisconnect.setAction(action);
																														
																																JButton btnConnect = new JButton("Connect");
																																btnConnect.addActionListener(new ActionListener() {
																																	public void actionPerformed(ActionEvent e) {
																																	}
																																});
																																btnConnect.setBounds(357, 12, 112, 25);
																																Develop.add(btnConnect);
																																btnConnect.setFont(new Font("Dialog", Font.BOLD, 14));
																																btnConnect.setAction(connect);
																																
																																JTextPane txtpnEnterTopicTo = new JTextPane();
																																txtpnEnterTopicTo.setText("Enter topic:");
																																txtpnEnterTopicTo.setFont(new Font("Dialog", Font.PLAIN, 14));
																																txtpnEnterTopicTo.setEditable(false);
																																txtpnEnterTopicTo.setBounds(13, 70, 92, 21);
																																Develop.add(txtpnEnterTopicTo);
																																
																																		JLabel lblQos = new JLabel("QoS:");
																																		lblQos.setBounds(122, 75, 70, 15);
																																		Develop.add(lblQos);
																																		lblQos.setFont(new Font("Dialog", Font.BOLD, 14));
												btnNewButton.addActionListener(new ActionListener() {
													@SuppressWarnings("rawtypes")
													public void actionPerformed(ActionEvent e) {
														Iterator<Entry<String, Integer>> it = comlist.topicsmap.entrySet().iterator();
														while (it.hasNext()) {
															Map.Entry pair = (Map.Entry) it.next();
															subToTopic((String) pair.getKey(), (Integer) pair.getValue());
														}
													}
												});
	}

	static void standard_behaviour() {
		String ip = "tcp://" + STANDARD_IP + ":1883";
		String status = controller.initController(ip);
		connect_status.setText(status);
		System.out.println(status);
		if(status.equals("Connected")) {
			Iterator<Entry<String, Integer>> it = comlist.topicsmap.entrySet().iterator();
			while (it.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry) it.next();
				subToTopic((String) pair.getKey(), (Integer) pair.getValue());
			}
		}
	}
	
	
	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Connect");
			putValue(SHORT_DESCRIPTION, "Connect to MqTT Broker");
		}

		public void actionPerformed(ActionEvent e) {
			// Get ip from textplane
			String erg = txt_enter_ip.getText();
			String ip = "tcp://" + erg + ":1883";

			// check if valid ip
			if (erg.contains("tcp") || erg.contains(":1883")) {
				connect_status.setText("Just IP, no tcp:// & :PORT");
				return;
			}

			// init connection
			String status = controller.initController(ip);

			// Set status
			connect_status.setText(status);

		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Disconnect");
			putValue(SHORT_DESCRIPTION, "disconnect from broker");
		}
		
		public void actionPerformed(ActionEvent e) {
			if (controller.disconnect()) {
				connect_status.setText("Disconnected");
				// free list
				listModel.clear();
				for(Lampe lamp: Lampe.values()) {
					planeChange(lamp,State.aus,Foerderband.fb1);
					planeChange(lamp,State.aus,Foerderband.fb2);
				}
			} else {
				connect_status.setText("still not connected");
			}
		}
	}

	static void unsubToAll() {
		for (int i = 0; i < listModel.getSize(); i++) {
			String topic = listModel.elementAt(i);
			// Cut qos out of String and unsub
			topic = topic.substring(0, topic.length() - 1 - 9);
			// System.out.println(topic);
			unsubToTopic(topic);
		}
	}

	static void signaliseDisconnected() {
		// cleanup after internal disconnect
		connect_status.setText("Abrupt Disconnect from Broker");
	}

	@SuppressWarnings("serial")
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Subscribe");
			putValue(SHORT_DESCRIPTION, "Sub to topic");
		}

		public void actionPerformed(ActionEvent e) {
			String topic = textField.getText();
			// TODO: check if valid input

			String value = spinner.getValue() + "";
			int qos = Integer.parseInt(value);

			subToTopic(topic, qos);
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Unsubscribe");
			putValue(SHORT_DESCRIPTION, "Unsub from topic");
		}

		public void actionPerformed(ActionEvent e) {
			String topic = textField.getText();
			unsubToTopic(topic);
		}
	}

	private static void subToTopic(String topic, int qos) {
		// check if already subd
		for (int i = 0; i < listModel.getSize(); i++) {
			if (listModel.elementAt(i).contains(topic)) {
				return;
			}
		}
		if (controller.subToTopic(topic, qos)) {
			listModel.addElement(topic + "    QoS: " + qos);
		}
	}

	private static void unsubToTopic(String topic) {
		if (controller.unsubToTopic(topic)) {
			for (int i = 0; i < listModel.getSize(); i++) {
				if (listModel.elementAt(i).contains(topic)) {
					listModel.remove(i);
				}
			}
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Subscribe to Foerderband Topics");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			// sub to list
			// TODO ADD FOERDERBAND TOPICS!

		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Unsubscribe to Foerderband Topics");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Publish");
			putValue(SHORT_DESCRIPTION, "Publish msg on selected Topic");
		}

		public void actionPerformed(ActionEvent e) {
			
			String topic;
			int qos = 0;
			if(publishing.getText().length()>0) {
				topic = publishing.getText();
				String value = spinner_1.getValue() + "";
				qos = Integer.parseInt(value);
			}
			else {
				int elemindex = list.getSelectedIndex();
				topic = listModel.getElementAt(elemindex);
				char cqos = topic.charAt(topic.length() - 1);
				qos = Character.getNumericValue(cqos);
				// cut qos of the String
				topic = topic.substring(0, topic.length() - 1 - 9);
				if (elemindex == -1) {
					return;
				}
			}
			

			String msg = pubtext.getText();

			controller.publish(topic, msg, qos);

		}
	}

	static void appendToLog(String msg) {

		// clear 5 Elements to make the log not too big
		if (logList.size() >= maxLogSize) {
			logList.removeElementAt(4);
			logList.removeElementAt(3);
			logList.removeElementAt(2);
			logList.removeElementAt(1);
			logList.removeElementAt(0);
		}

		logList.add(0, msg);

	}
	
	//AB HIER FOERDERBANDSIGNALE
	//----------------------------------------------------------------------------------------------------------------
	
	static void startKnopf(String foerderband) {
		controller.publish("/remote/event/startknopf", foerderband, 2);
	}
	
	static void stopKnopf(String foerderband) {
		controller.publish("/remote/event/stopknopf", foerderband, 2);
	}
	
	static void resetKnopf(String foerderband) {
		controller.publish("/remote/event/resetknopf", foerderband, 2);
	}
	
	static void serviceKnopf() {
		controller.publish("/remote/event/servicemode", fb1_String, 2);
	}
	
	//LEDs
	static void planeChange(Lampe lampe, State state, Foerderband fb) {
		planeChange(lampe,state,fb,false);
	}
	
	static void planeChange(Lampe lampe, State state, Foerderband fb, boolean fromthread) {

		if(!fromthread) {
			resetLampe(lampe,state,fb);
		}

		switch(state) {
		case an: 
			returnJpanel(lampe,fb).setBackground(returnColor(lampe)); 
			return;
		case aus: 
			returnJpanel(lampe,fb).setBackground(Color.white); 
			return;
		case einhertzblinken: 
		case halbhertzblinken: 
			blinken(lampe,fb);
			return;
		}
	}
	
	static void blinken(Lampe lampe, Foerderband fb) {	
		switch(lampe) {
		case gelb: 
			if(fb == Foerderband.fb1) {
				fb1yellowlampthread = new Thread(fb1yellowlamprunnable);
				fb1yellowlampthread.start();
				return;
			}
			fb2yellowlampthread = new Thread(fb2yellowlamprunnable);
			fb2yellowlampthread.start();
			return;
		case rot:  
			if(fb == Foerderband.fb1) {
				fb1redlampthread = new Thread(fb1redlamprunnable);
				fb1redlampthread.start();
				return;
			}
			fb2redlampthread = new Thread(fb2redlamprunnable);
			fb2redlampthread.start();
			return;
		case gruen:  
			if(fb == Foerderband.fb1) {
				fb1greenlampthread = new Thread(fb1greenlamprunnable);
				fb1greenlampthread.start();
				}
			fb2greenlampthread = new Thread(fb2greenlamprunnable);
			fb2greenlampthread.start();
			return;
			
		default:
			break;
		}
	}
	

	static void resetLampe(Lampe lampe, State state, Foerderband fb) {
		if(fb == Foerderband.fb1) {
			switch(lampe) {
			case gelb:
				if(fb1yellowlampthread != null) {
					if(fb1yellowlampthread.isAlive()) {
						fb1yellowlamprunnable.stopThread();
					}
				}
				fb1yellowlamprunnable = new LampThread(lampe,state,fb);
				return;
			case gruen:
				if(fb1greenlampthread != null) {
					if(fb1greenlampthread.isAlive()) {
						fb1greenlamprunnable.stopThread();
					}
				}
				fb1greenlamprunnable = new LampThread(lampe,state,fb);	
				return;
			case rot:
				if(fb1redlampthread != null) {
					if(fb1redlampthread.isAlive()) {
						fb1redlamprunnable.stopThread();
					}
				}
				fb1redlamprunnable = new LampThread(lampe,state,fb);
				return;
			default:
				return;
			}
		}
		switch(lampe) {
		case gelb:
			if(fb2yellowlampthread != null) {
				if(fb2yellowlampthread.isAlive()) {
					fb2yellowlamprunnable.stopThread();
				}
			}
			fb2yellowlamprunnable = new LampThread(lampe,state,fb);
			return;
		case gruen:
			if(fb2greenlampthread != null) {
				if(fb2greenlampthread.isAlive()) {
					fb2greenlamprunnable.stopThread();
				}
			}
			fb2greenlamprunnable = new LampThread(lampe,state,fb);	
			return;
		case rot:
			if(fb2redlampthread != null) {
				if(fb2redlampthread.isAlive()) {
					fb2redlamprunnable.stopThread();
				}
			}
			fb2redlamprunnable = new LampThread(lampe,state,fb);
			return;
		default:
			break;
		}
		
		return;
	}
	

	static Color returnColor(Lampe lampe) {
		switch(lampe) {
		case rot: return Color.red;
		case gelb: return Color.yellow;
		case gruen: return Color.green;
		case q1led: return Color.cyan;
		case q2led: return Color.cyan;
		case startled: return Color.cyan;
		case resetled: return Color.cyan;
		}
		return null;	
	}
	
	static JPanel returnJpanel(Lampe lampe, Foerderband fb) {
		switch(lampe) {
		case rot: return fb == Foerderband.fb1 ? fb1roteLampe : fb2roteLampe;
		case gelb: return fb == Foerderband.fb1 ? fb1gelbeLampe : fb2gelbeLampe;
		case gruen: return fb == Foerderband.fb1 ? fb1grueneLampe : fb2grueneLampe;
		case q1led: return fb == Foerderband.fb1 ? fb1q1led : fb2q1led;
		case q2led: return fb == Foerderband.fb1 ? fb1q2led : fb2q2led;
		case startled: return fb == Foerderband.fb1 ? fb1startled : fb2startled;
		case resetled: return fb == Foerderband.fb1 ? fb1resetled : fb2resetled;
		}
		return null;
	}
}
