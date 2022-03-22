package com.ping.controller;

import java.util.List;

import com.ping.entity.PingUser;

public interface PingControllerInterface {

	int createProfileController();

	List<PingUser> viewAllProfileController();

	PingUser signInController();

	void viewProfileController();

	int deleteProfileController();

	List<PingUser> searchProfileController();

	int editProfileController();

	int viewTimelineController();

	List<PingUser> sortProfileController();

	


}
