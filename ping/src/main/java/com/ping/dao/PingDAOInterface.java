package com.ping.dao;

import java.util.List;

import com.ping.entity.PingUser;
import com.ping.entity.TimelineDetails;

public interface PingDAOInterface {

	int createProfileDAO(PingUser pu);

	List<PingUser> viewAllProfileDAO();

	PingUser signInDAO(PingUser pu);

	PingUser viewProfileDAO(PingUser pu);

	int deleteProfileDAO(PingUser pu);

	List<PingUser> searchProfileDAO(PingUser pu);

	int editName(PingUser pu);

	int editPassword(PingUser pu);

	int editAddress(PingUser pu);

	int timelineDAO(TimelineDetails td);

}
