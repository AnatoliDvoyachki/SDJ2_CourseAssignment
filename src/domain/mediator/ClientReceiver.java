package domain.mediator;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientReceiver implements Runnable {
	private ObjectOutputStream notifcationOut;
	private ObjectInputStream notificationIn;

	public ClientReceiver(Socket notificationSocket) {
		try {
			this.notifcationOut = new ObjectOutputStream(notificationSocket.getOutputStream());
			this.notificationIn = new ObjectInputStream(notificationSocket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				String message = (String) notificationIn.readObject();
				System.out.println(message);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
