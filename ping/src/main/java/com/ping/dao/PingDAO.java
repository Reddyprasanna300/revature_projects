package com.ping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ping.entity.PingUser;
import com.ping.entity.TimelineDetails;
import com.ping.utility.UserDefineException;
public class PingDAO implements PingDAOInterface {
	Connection con=null;
	public PingDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","orcl");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public int createProfileDAO(PingUser pu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			if(pu.getAddress().equals("Pakistan")) {
				throw new UserDefineException();
			}
			PreparedStatement ps=con.prepareStatement("insert into pinguser values(?,?,?,?)");
			ps.setString(1, pu.getName());
			ps.setString(2, pu.getPassword());
			ps.setString(3, pu.getEmail());
			ps.setString(4, pu.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<PingUser> viewAllProfileDAO() {
		// TODO Auto-generated method stub
		List<PingUser> ll=new ArrayList<PingUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from pinguser");
			ResultSet res=ps.executeQuery();
			
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				PingUser ps1=new PingUser();
				ps1.setName(n);
				ps1.setPassword(p);
				ps1.setEmail(e);
				ps1.setAddress(a);
				
				ll.add(ps1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public PingUser signInDAO(PingUser pu) {
		// TODO Auto-generated method stub
		PingUser p1=null;
		try {
			PreparedStatement st=con.prepareStatement("select * from pinguser where email=?");
			st.setString(1, pu.getEmail());
			
			ResultSet res=st.executeQuery();
			if(res.next()) {
				String p=res.getString(2);
				String e=res.getString(3);

				p1=new PingUser();
				p1.setPassword(p);
				p1.setEmail(e);;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p1;
	}

	@Override
	public PingUser viewProfileDAO(PingUser pu) {
		// TODO Auto-generated method stub
		PingUser p1=null;
		try {
			PreparedStatement st=con.prepareStatement("select * from pinguser where email=?");
			st.setString(1, pu.getEmail());
			
			ResultSet res=st.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);

				p1=new PingUser();
				p1.setName(n);
				p1.setPassword(p);
				p1.setEmail(e);
				p1.setAddress(a);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p1;
	}

	@Override
	public int deleteProfileDAO(PingUser pu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement st=con.prepareStatement("delete from pinguser where email=?");
			st.setString(1, pu.getEmail());
			i=st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<PingUser> searchProfileDAO(PingUser pu) {
		// TODO Auto-generated method stub
		List<PingUser> ll=new ArrayList<PingUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from pinguser where name=?");
			ps.setString(1,pu.getName());
			ResultSet res=ps.executeQuery();
			
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				PingUser ps1=new PingUser();
				ps1.setName(n);
				ps1.setPassword(p);
				ps1.setEmail(e);
				ps1.setAddress(a);
				
				ll.add(ps1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public int editName(PingUser pu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("update pinguser set name=? where email=?");
			ps.setString(1, pu.getNewName());
			ps.setString(2, pu.getEmail());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int editPassword(PingUser pu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("update pinguser set password=? where email=?");
			ps.setString(1, pu.getNewPassword());
			ps.setString(2, pu.getEmail());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int editAddress(PingUser pu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("update pinguser set address=? where email=?");
			ps.setString(1, pu.getNewAddress());
			ps.setString(2, pu.getEmail());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int timelineDAO(TimelineDetails td) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into timelinedetails values(?,?,?,?,?)");
			ps.setString(1, td.getMessageId());
			ps.setString(2, td.getReceiver());
			ps.setString(3, td.getMessage());
			ps.setString(4, td.getDate());
			ps.setString(5, td.getSender());
			
			i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}

	
