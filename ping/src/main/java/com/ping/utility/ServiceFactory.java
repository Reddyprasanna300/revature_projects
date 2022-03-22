package com.ping.utility;

import com.ping.service.PingService;
import com.ping.service.PingServiceInterface;

public class ServiceFactory {

	public static PingServiceInterface createObject() {
		// TODO Auto-generated method stub
		return new PingService();
	}

}
