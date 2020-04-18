package hospitalPaf.hospitalPaf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


public class HospitalRepository
{
 
 //DB connection    
     Connection con = null;
     
     public HospitalRepository() 
     {
    	 
    	 String url = "jdbc:mysql://localhost:3306/healthcareapiproject";
    	 String username = "root";
    	 String password ="";
    	 
    	 try
    	 {
    	    Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection(url,username,password);		 
    
    	 }catch(Exception e) {
    		 System.out.println(e);
    	 }

     }
     
  //select query   
     
     public List<Hospital>getHospitals(){
    	 
    	 List<Hospital> hospitals = new ArrayList<>();
    	 String sql = "select * from hospital";
    	 try 
    	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  while(rs.next())
			  {
				  Hospital h = new Hospital();
				  h.setId(rs.getInt(1));
			
				  h.setTelNo(rs.getNString(2));
				  h.setHospitalName(rs.getNString(3));
				  h.setHospitalLocation(rs.getNString(4));
				  
				  hospitals.add(h);
			  }
			
		    } 
    	 catch (Exception e) 
    	  {
			
		   System.out.println(e);
		  }
    	  
    	 return hospitals;
     }
     
     
     
     
     
     
     
     public Hospital getHospital(int id)
     
     {
    	 String sql = "select * from hospital where id="+id;
    	  Hospital h = new Hospital();
    	 try 
    	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  if(rs.next())
			  {
				
				  h.setId(rs.getInt(1));
				 
				  h.setTelNo(rs.getNString(2));
				  h.setHospitalName(rs.getNString(3));
				  h.setHospitalLocation(rs.getNString(4));		
			  }
			
		    } 
    	 catch (Exception e) 
    	  {
			
		   System.out.println(e);
		  } 
    	 return h;
     }

 //insert method called
     
	public void create(Hospital h1) 
	{
		String sql = "insert into hospital values(?,?,?,?)";
   	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, h1.getId());
	
		  st.setString(2, h1.getTelNo());
		  st.setString(3, h1.getHospitalName());
		  st.setString(4, h1.getHospitalLocation());
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	
//update method called	
	
	public void update(Hospital h1) 
	{
		String sql = "update hospital set telNo=?,hospitalName=?,hospitalLocation=? where id=?";
   	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);

	
		  st.setString(1, h1.getTelNo());
		  st.setString(2, h1.getHospitalName());
		  st.setString(3, h1.getHospitalLocation());
		  st.setInt(4, h1.getId());
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}


//delete method called
	
	public void delete(int id) {

		String sql = "delete from hospital where id=?";
   	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, id);
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
		
	}
	
	
}
