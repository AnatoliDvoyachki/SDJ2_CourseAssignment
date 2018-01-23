package domain.model;

import java.io.Serializable;
import java.util.ArrayList;


public class ReservationList implements Serializable {

	private ArrayList<Reservation> list;

	public ReservationList() {
		list = new ArrayList<>();
	}

	public void add(Reservation r) {
		list.add(r);
	}

	public Reservation remove(int index) {
		return list.remove(index);
	}

	public int size() {
		return list.size();
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			out.append(i + " - " + (list.get(i)) + "\n");
		}
		return out.toString();
	}

}

