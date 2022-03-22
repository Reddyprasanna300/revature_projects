package com.ping.service;

import java.util.List;

import com.ping.entity.PingUser;
import com.ping.entity.TimelineDetails;

public interface PingServiceInterface {

	int createProfileService(PingUser pu);

	PingUser signInService(PingUser pu);

	PingUser viewProfileService(PingUser pu);

	int deleteProfileService(PingUser pu);

	List<PingUser> viewAllProfileService();

	List<PingUser> searchProfileService(PingUser pu);

	int editName(PingUser pu);

	int editPassword(PingUser pu);

	int editAddress(PingUser pu);

	int timelineService(TimelineDetails td);


}
