package com.ping.controller;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.ping.entity.PingUser;
import com.ping.entity.TimelineDetails;
import com.ping.service.PingServiceInterface;
import com.ping.utility.ServiceFactory;
import com.ping.utility.SortByName;


public class PingController implements PingControllerInterface {
	Logger log=Logger.getLogger("PingController");
	PingServiceInterface ps=null;
	public PingController(){
		ps=ServiceFactory.createObject();
	}
	Scanner sc=new Scanner(System.in);

	public int createProfileController() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter Address");
		String address=sc.next();
		
		PingUser pu=new PingUser();
		pu.setName(name);
		pu.setPassword(password);
		pu.setEmail(email);
		pu.setAddress(address);
		
		PingServiceInterface ps=ServiceFactory.createObject();
		int i=ps.createProfileService(pu);
		
		if(i>0) {
			System.out.println("Your profile has been created");
		}
		else {
			System.out.println("Something went wrong and profile is not created");
		}
		return i;
	}

	public List<PingUser> viewAllProfileController() {
		// TODO Auto-generated method stub
		List<PingUser> ll=ps.viewAllProfileService();
		ll.forEach(s->{
			System.out.println("*******************");
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		return ll;
	}

	@Override
	public PingUser signInController() {
		// TODO Auto-generated method stub
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		
		PingUser pu=new PingUser();
		pu.setEmail(email);
		pu.setPassword(password);
		
		PingUser pu1=ps.signInService(pu);
		
		if(pu1!=null) {
			System.out.println("Login successful");
		}
		else {
			System.out.println("Login failed incorrect email or paassword entered");
		}
		return pu1;
	}

	@Override
	public void viewProfileController() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Email");
		String email=sc.next();
		
		PingUser pu=new PingUser();
		pu.setEmail(email);
		
		PingUser p1=ps.viewProfileService(pu);
		if(p1!=null) {
			System.out.println("Name is "+p1.getName());
			System.out.println("Password is "+p1.getPassword());
			System.out.println("Email is "+p1.getEmail());
			System.out.println("Address is "+p1.getAddress());
		}
		else {
			System.out.println("Profile not find");
		}
	}

	@Override
	public int deleteProfileController() {
		// TODO Auto-generated method stub
		System.out.println("Enter the email in which you wish to delete profile");
		String email=sc.next();
		
		PingUser pu=new PingUser();
		pu.setEmail(email);
		
		int i=ps.deleteProfileService(pu);
		if(i>0) {
			System.out.println("Profile has been deleted");
		}else {
			System.out.println("Profile not deleted");
		}
		return i;
		
		
	}

	@Override
	public List<PingUser> searchProfileController() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the name in which you wish to search the profile");
		String name=sc.next();
		
		PingUser pu=new PingUser();
		pu.setName(name);
		List<PingUser> ll=ps.searchProfileService(pu);
		ll.forEach(s->{
			System.out.println("*******************");
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		return ll;
	}

	@Override
	public int editProfileController() {
		int i=0;
		// TODO Auto-generated method stub
		System.out.println("Enter the email which you wish to edit the profile");
		String email=sc.next();
		
		PingUser pu=new PingUser();
		pu.setEmail(email);
		
		PingUser p1=ps.viewProfileService(pu);
		if(p1!=null) {
				System.out.println("Name is "+p1.getName());
				System.out.println("Password is "+p1.getPassword());
				System.out.println("Email is "+p1.getEmail());
				System.out.println("Address is "+p1.getAddress());
				
			System.out.println("Enter the field which you wish to edit");
			System.out.println("enter 1 to edit name");
			System.out.println("enter 2 to edit password");
			System.out.println("enter 3 to edit address");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:System.out.println("Enter new name");
					String newName=sc.next();
					pu.setNewName(newName);
					i=ps.editName(pu);
					if(i>0) {
						System.out.println("Name updated successfully");
					}
					else {
						System.out.println("Name has not been updated");
					}
					break;
			case 2:System.out.println("Enter new password");
					String newPassword=sc.next();
					pu.setNewPassword(newPassword);
					i=ps.editPassword(pu);
					if(i>0) {
						System.out.println("Password updated successfully");
					}
					else {
						System.out.println("Password has not been updated");
					}
					break;
			case 3:System.out.println("Enter new Address");
					String newAddress=sc.next();
					pu.setNewAddress(newAddress);
					i=ps.editAddress(pu);
					if(i>0) {
						System.out.println("Address updated successfully");
					}else {
						System.out.println("Address has not been updated");
					}
					break;
			}
		}
		else {
			System.out.println("profile not found");	
		}
		return i;
	}

	@Override
	public int viewTimelineController() {
		// TODO Auto-generated method stub
		System.out.println("Enter message Id");
		String messageId=sc.next();
		
		System.out.println("Enter Receiver Email Id");
		String reciever=sc.next();
		
		System.out.println("Enter message");
		String message=sc.next();
		
		System.out.println("Enter date");
		String date=sc.next();
		
		System.out.println("Enter Sender EmailId");
		String sender=sc.next();
		
		TimelineDetails td=new TimelineDetails();
		td.setMessageId(messageId);
		td.setSender(sender);
		td.setReceiver(reciever);
		td.setMessage(message);
		td.setDate(date);
		
		int i=ps.timelineService(td);
		if(i>0) {
			System.out.println("Timeline updated");
		}else {
			System.out.println("Timeline not updated");
		}
		return i;
		
	}

	@Override
	public List<PingUser> sortProfileController() {
		// TODO Auto-generated method stub
		List<PingUser> ll=ps.viewAllProfileService();
		log.info("*******BEFORE SORTING********");
		ll.forEach(s->{
			System.out.println("*******************");
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		Collections.sort(ll,new SortByName());
		log.info("***********AFTER SORTING********");
		ll.forEach(s->{
			System.out.println("*******************");
			System.out.println(s.getName());
			System.out.println(s.getPassword());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		return ll;
		
	}
}

