package domain.mediator;

import domain.model.Reservation;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ServerCommunication implements Runnable, Observer {
	private int notificationPort = 1313;
	private BusCompanyModel model;
	private ObjectInputStream inFromClient;
	private ObjectOutputStream outToClient;

	public ServerCommunication(Socket clientSocket, BusCompanyModel model) {
		try {
			this.outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
			this.inFromClient = new ObjectInputStream(clientSocket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.model = model;
	}

	@Override
	public void run() {
		boolean isConnected = true;
		while (isConnected) {
			try {
				String[] inputFromClient = (String[]) inFromClient.readObject();
				String action = inputFromClient[inputFromClient.length - 1];
				switch (action) {
					case "1":
						outToClient.writeObject(model.showReservations());
						break;
					case "2":
						String[] values = new String[inputFromClient.length - 1];
						for (int i = 0; i < values.length; i++) {
							values[i] = inputFromClient[i];
						}
						model.createReservation(values);
						break;
					case "3":
						int index = Integer.parseInt(inputFromClient[0]);
						Reservation deletedReservation = model.deleteReservation(index);
						outToClient.writeObject(deletedReservation);
						break;
					case "4":
						isConnected = false;
						break;
					case "5":
						outToClient.writeObject(model.getReservations());
						break;
					case "6":
						outToClient.writeObject(model.getLog());
						break;
					default:
						break;
				}
			} catch (Exception e) {
				isConnected = false;
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			outToClient.writeObject(arg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
