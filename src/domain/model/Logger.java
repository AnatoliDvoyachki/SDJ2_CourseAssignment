package domain.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {

	private static final Logger logger = new Logger();
	private ArrayList<String> log = new ArrayList<>();

	private Logger() {
	}

	public static Logger getInstance() {
		return logger;
	}

	public void writeToLog(String msg) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = dateFormat.format(date);		
		
		log.add(timeStamp + " - " + msg);
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < log.size(); i++) {
			out.append((log.get(i)) + "\n");
		}
		return out.toString();
	}

}
