package domain.model;

import java.io.Serializable;

public class Notification implements Serializable {
	private String message = "beer";

	public Notification(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
