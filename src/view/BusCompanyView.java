package view;

import controller.BusCompanyController;

public interface BusCompanyView {
	void start(BusCompanyController controller);
	void show(String value);
	String get(String what);
}
