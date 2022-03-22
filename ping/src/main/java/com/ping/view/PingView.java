package com.ping.view;

import java.util.Scanner;
import java.util.logging.Logger;

import com.ping.controller.PingControllerInterface;
import com.ping.entity.PingUser;
import com.ping.utility.ControllerFactory;

public class PingView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log=Logger.getLogger("PingView");
		PingUser p1=null;
		Scanner sc=new Scanner(System.in);
		String s="y";
		while(s.equals("y")) {
			log.info("-----------------------------");
			log.info("Welcome! Sign-In or Sign Up");
			log.info("-----------------------------");
			System.out.println("press 1 to sign-up");
			System.out.println("press 2 to sign-in");
			System.out.println("Enter your choice");
			int ch=sc.nextInt();
			
			PingControllerInterface sw=ControllerFactory.createObject();
			
			switch(ch) {
			case 1:sw.createProfileController();
					break;
			case 2:p1=sw.signInController();
					if(p1!=null) {
						while(s.equals("y")) {
							System.out.println("			press 1 to view all profile		");
							System.out.println("			press 2 to view profile			");
							System.out.println("			press 3 to delete profile		");
							System.out.println("			press 4 to search profile		");
							System.out.println("			press 5 to edit profile			");
							System.out.println("			press 6 to view timeline			");
							System.out.println("			press 7 to view all profile in sorted order 	");
							
							System.out.println("Enter your choice");
							ch=sc.nextInt();
							switch(ch) {
							case 1:sw.viewAllProfileController();
							break;
							case 2:sw.viewProfileController();
							break;
							case 3:sw.deleteProfileController();
							break;
							case 4:sw.searchProfileController();
							break;
							case 5:sw.editProfileController();
							break;
							case 6:sw.viewTimelineController();
							break;
							case 7:sw.sortProfileController();
							break;
							}
							System.out.println("press y/n to continue");
							s=sc.next();
						}
					}
					else {
						System.out.println("You have not registered");
					}	
					break;
			}
			System.out.println("press y/n to continue");
			s=sc.next();
		}

	}

}
