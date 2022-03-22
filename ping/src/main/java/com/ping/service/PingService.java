package com.ping.service;

import java.util.List;

import com.ping.dao.PingDAOInterface;
import com.ping.entity.PingUser;
import com.ping.entity.TimelineDetails;
import com.ping.utility.DAOFactory;

public class PingService implements PingServiceInterface {
	PingDAOInterface pd=null;
	public PingService() {
		pd=DAOFactory.createObject();
	}

	public int createProfileService(PingUser pu) {
		// TODO Auto-generated method stub
		PingDAOInterface pd=DAOFactory.createObject();
		int i=pd.createProfileDAO(pu);
		
		return i;
	}

	@Override
	public List<PingUser> viewAllProfileService() {
		// TODO Auto-generated method stub
		return pd.viewAllProfileDAO();
	}

	@Override
	public PingUser signInService(PingUser pu) {
		// TODO Auto-generated method stub
		PingUser p1=pd.signInDAO(pu);
		return p1;
	}

	@Override
	public PingUser viewProfileService(PingUser pu) {
		// TODO Auto-generated method stub
		PingUser p1=pd.viewProfileDAO(pu);
		return p1;
	}

	@Override
	public int deleteProfileService(PingUser pu) {
		// TODO Auto-generated method stub
		int i=pd.deleteProfileDAO(pu);
		return i;
	}

	@Override
	public List<PingUser> searchProfileService(PingUser pu) {
		// TODO Auto-generated method stub
		List<PingUser> p1=pd.searchProfileDAO(pu);
		return p1;

	}
	
	@Override
	public int editName(PingUser pu) {
		// TODO Auto-generated method stub
		int i=pd.editName(pu);
		return i;
	}

	@Override
	public int editPassword(PingUser pu) {
		// TODO Auto-generated method stub
		int i=pd.editPassword(pu);
		return i;
	}

	@Override
	public int editAddress(PingUser pu) {
		// TODO Auto-generated method stub
		int i=pd.editAddress(pu);
		return i;
	}

	@Override
	public int timelineService(TimelineDetails td) {
		// TODO Auto-generated method stub
		int i=pd.timelineDAO(td);
		return i;
	}

}
