package com.ping.utility;

import com.ping.dao.PingDAO;
import com.ping.dao.PingDAOInterface;

public class DAOFactory {

	public static PingDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new PingDAO();
	}

}
