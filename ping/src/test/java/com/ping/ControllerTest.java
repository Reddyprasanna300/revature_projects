package com.ping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ping.controller.PingController;
import com.ping.controller.PingControllerInterface;
import com.ping.entity.PingUser;

public class ControllerTest {
	PingControllerInterface sw=null;
	@Before
	public void setUp() throws Exception {
		sw=new PingController();
	}

	@After
	public void tearDown() throws Exception {
		sw=null;
	}

	@Test
	public void testSignUpController() {
		int i=sw.createProfileController();
		assert i>0:"Failed to create profile";
	}

	@Test
	public void testSignIncontroller() {
		PingUser p1=sw.signInController();
		assert p1!=null:"Failed to sign in";
	}
	@Test
	public void testViewAllProfileController() {
		List<PingUser> ll=sw.viewAllProfileController();
		assert ll!=null:"Failed to view all profile";
	}
	@Test
	public void testViewProfilecontroller() {
		PingUser p1=sw.signInController();
		assert p1!=null:"Failed to view profile";
	}
	@Test
	public void testDeleteProfileController() {
		int i=sw.deleteProfileController();
		assert i>0:"Failed to delete profile";
	}
	@Test
	public void testSearchprofileController() {
		List<PingUser> ll=sw.searchProfileController();
		assert ll!=null:"Failed to search profile";
	}
	@Test
	public void testEditProfileController() {
		int i=sw.editProfileController();
		assert i>0:"Failed to edit profile";
	}
	
	@Test
	public void testTimelineController() {
		int i=sw.viewTimelineController();
		assert i>0:"Failed to create timeline";
	}
	@Test
	public void testSortProfileController() {
		List<PingUser> ll=sw.sortProfileController();
		assert ll!=null:"Failed to sort the profiles";
	}
}
