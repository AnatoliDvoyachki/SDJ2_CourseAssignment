package domain.mediator;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection implements Runnable {
	private ServerModelManager model;
	private int port1;
	private int port2;

	public ServerConnection(int port1, int port2, ServerModelManager model) {
		this.port1 = port1;
		this.port2 = port2;
		this.model = model;
	}

	@Override
	public void run() {
		try {
			ServerSocket welcomeSocket = new ServerSocket(port1);
			ServerSocket notificationWelcomeSocket = new ServerSocket(port2);
			while (true) {
				Socket connectionSocket = welcomeSocket.accept();
				ServerCommunication newClient = new ServerCommunication(connectionSocket, model);
				new Thread(newClient).start();

				Socket notificationSocket = notificationWelcomeSocket.accept();
				ServerCommunication newNotificationThread = new ServerCommunication(notificationSocket, model);
				model.addObserver(newNotificationThread);
				new Thread(newNotificationThread).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
