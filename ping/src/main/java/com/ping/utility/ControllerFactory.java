package com.ping.utility;

import com.ping.controller.PingController;
import com.ping.controller.PingControllerInterface;

public class ControllerFactory {

	public static PingControllerInterface createObject() {
		// TODO Auto-generated method stub
		return new PingController();
	}

}
