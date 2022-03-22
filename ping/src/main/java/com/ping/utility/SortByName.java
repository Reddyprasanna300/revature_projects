package com.ping.utility;

import java.util.Comparator;

import com.ping.entity.PingUser;

public class SortByName implements Comparator<PingUser> {

	public int compare(PingUser p1, PingUser p2) {
		// TODO Auto-generated method stub
		return p1.getName().compareTo(p2.getName());
	}

}
