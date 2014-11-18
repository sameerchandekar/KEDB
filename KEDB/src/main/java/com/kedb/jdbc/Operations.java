package com.kedb.jdbc;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import com.kedb.bean.Incident_Details;
import com.kedb.bean.ProblemDetails;
import com.kedb.bean.TwoVector;
import com.kedb.util.*;
public class Operations
{ 
	Connection cn=new Connection();
	Util u=new Util();

	public boolean addData(
			String IncidentNumber,
			String IncidentTitle,
			String IncidentDescription,
			String ProblemNumber,
			String WorkAround,
			String CauseCode,
			String Application,
			String CreateDate,
			String CloseDate,
			String UserName,
			String WorkGroup
			)
	{
		try
		{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement ps=con.prepareStatement(Queries.ADD_INCIDENT);
		ps.setString(1,IncidentNumber);
		ps.setString(2,IncidentTitle);
		ps.setString(3,IncidentDescription);
		ps.setString(4,ProblemNumber);
		ps.setString(5,WorkAround);
		ps.setString(6,CauseCode);
		ps.setString(7,Application);
		ps.setDate(8,u.toSQlDate(CreateDate));
		ps.setDate(9,u.toSQlDate(CloseDate));
		ps.setString(10,UserName);
		ps.setString(11,WorkGroup);
		ps.setString(12,UserName);
		//ps.setDate(13, u.toSQlDate(CreateDate));
		int result=ps.executeUpdate();
		if(result>0)
		{
			System.out.println("Executed successfully SQL CODE:"+result);
			return true;
		}
		else
		{
			System.out.println("Error inserting data SQL CODE :"+result);
			return false;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}
	public boolean addProblem(
			String ProblemNumber,
			String ProblemTitle,
			String ProblemDescription,
			String RCA,
			String PR,
			String ETA,
			String WorkGroup,
			String Application,
			String name
		
			
			)
	{
		try
		{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement ps=con.prepareStatement(Queries.ADD_PROBLEM);
		ps.setString(1,ProblemNumber);
		ps.setString(2,ProblemTitle);
		ps.setString(3,ProblemDescription);
		ps.setString(4,RCA);
		ps.setString(5,PR);
		ps.setDate(6,u.toSQlDate(ETA));
		ps.setString(7,Application);
		ps.setString(8,WorkGroup);
		ps.setString(9,name);
		//ps.setDate(10, u.toSQlDate(CreateDate));
		ps.setString(10,name);
		
		int result=ps.executeUpdate();
		if(result>0)
		{
			System.out.println("Executed successfully SQL CODE:"+result);
			return true;
		}
		else
		{
			System.out.println("Error inserting data SQL CODE :"+result);
			return false;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}
	
public boolean validate(String uname,String pswd)
{
	try
	{
		System.out.print("entering validate uname :"+uname+" and pswd :"+pswd);
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.VALIDATE);
		pst.setString(1,uname);
		pst.setString(2,pswd);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
				{
			System.out.println("uname=  "+rs.getString(1)+"pswd"+rs.getString(2));
			return true;
				}
	}
	catch(Exception e)
	{
	e.printStackTrace();
	return false;
	}

	return false;
}

public String checkRole(String uname,String pswd)
{String role1=null;
String role2=null;
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.CHECK_ROLE);
		pst.setString(1,uname );
		pst.setString(2,pswd );
		ResultSet rs=pst.executeQuery();
		if(rs.next())
				{
		
		role1=rs.getString(3);
		role2=rs.getString(4);
				}
	}
	catch(Exception e)
	{
	e.printStackTrace();
	return "error";
	}
         if(role1.equals("1"))  
	         return "admin";
         else if(role2.equals("1"))
        		 return "spoc";
         else
        	 return "user";
}


public Vector<String> getE2E(String LOB)
{
   Vector<String> v=new Vector<String>();
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.GET_E2E);
		pst.setString(1,LOB);
		
		ResultSet rs=pst.executeQuery();
		while(rs.next())
				{
		
		v.add(rs.getString(1));
				}
	}
	catch(Exception e)
	{
	e.printStackTrace();
	cn.closeConnection();
	return null;
	}
	cn.closeConnection();
return v;
}

public com.kedb.bean.TwoVector getAppWork(String E2E)
{
	com.kedb.bean.TwoVector tv=new TwoVector();
   Vector<String> v1=new Vector<String>();
   Vector<String> v2=new Vector<String>();
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.GET_APP_WORK);
		pst.setString(1,E2E);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
				{
		
		v1.add(rs.getString(1));
		v2.add(rs.getString(2));
				}
		tv.v1=v1;
		tv.v2=v2;
	}
	catch(Exception e)
	{
	e.printStackTrace();
	cn.closeConnection();
	return null;
	}
	cn.closeConnection();
return tv;
}

public ResultSet searchData(String choice, String number) 
{

	try
	{
		
		Incident_Details inc=new Incident_Details();
		
	java.sql.Connection con=cn.getConnection();
	
	PreparedStatement ps=null;
	
	if(choice.equalsIgnoreCase("incident"))
	{
		 ps=con.prepareStatement(Queries.SEARCH_INCIDENT);
	}
	else if(choice.equalsIgnoreCase("problem"))
	{
		 ps=con.prepareStatement(Queries.SEARCH_PROBLEM);
	}
	
	
	ps.setString(1,number);
	
	ResultSet result=ps.executeQuery();
	
	/*while(result.next())
	{
		System.out.println("incise while");
		String no=result.getString(1);
		String title=result.getString(2);
		String desc=result.getString(3);
		String pno=result.getString(4);
		String waround=result.getString(5);
		String cc=result.getString(6);
		String app=result.getString(7);
		String cdate=result.getString(8);
		String ccdate=result.getString(10);
		String uname=result.getString(11);
		String luser=result.getString(12);
		String lts=result.getString(13);
		
		inc.setIncidentNumber(no);
		inc.setIncidentTitle(title);
		inc.setIncidentDescription(desc);
		inc.setProblemNumber(pno);
		inc.setWorkAround(waround);
		inc.setCauseCode(cc);
		inc.setApplication(app);
		inc.setCreateDate(cdate);
		inc.setCloseDate(ccdate);
		inc.setUserName(uname);
		inc.setLastUpdatedTimeStamp(luser);
		inc.setLastUpdatedTimeStamp(lts);
		
		
		System.out.println(no);
		System.out.println(title);
		System.out.println(desc);
		
	}*/
	
	
	/*if(result.next())
	{
		System.out.println("incide nxt");
		
		while(result.next())
		{
			System.out.println("incise while");
			String desc=result.getString(1);
			System.out.println(desc);
		}
		
		System.out.println("Executed successfully SQL CODE:"+result);
		return result;
	}
	else
	{
		System.out.println("Error in  SQL CODE :"+result);
		return result;
	}*/
	
	return result;
}
catch(Exception e)
{
	e.printStackTrace();
	
	return null;
}




}
public Incident_Details incident(String inc) {

	Incident_Details incd= new Incident_Details();
	try
	{
		System.out.println("in db...");
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.SEARCH_INCIDENT);
		pst.setString(1,inc);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
				{
		
			incd.setIncidentNumber(rs.getString(1));
			incd.setIncidentTitle(rs.getString(2));
		    incd.setIncidentDescription(rs.getString(3));
		    incd.setProblemNumber(rs.getString(4));
		    incd.setWorkAround(rs.getString(5));
		    incd.setCauseCode(rs.getString(6));
		    incd.setApplication(rs.getString(7));
		    incd.setCreateDate(rs.getString(8));
		    incd.setCloseDate(rs.getString(9));
		    incd.setUserName(rs.getString(10));
		    incd.setWorkGroup(rs.getString(11));
		    incd.setLastUpdatedUser(rs.getString(12));
		    incd.setLastUpdatedTimeStamp(rs.getString(13));
				}
		
	}
	catch(Exception e)
	{
	e.printStackTrace();
	cn.closeConnection();
	return null;
	}
	cn.closeConnection();
return incd;

}
public ProblemDetails problem(String prb) {

	ProblemDetails prbd= new ProblemDetails();
	try
	{
		
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.SEARCH_PROBLEM);
		pst.setString(1,prb);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
				{
		
		prbd.setProblemNumber(rs.getString(1));
		prbd.setProblemTitle(rs.getString(2));
	    prbd.setProblemDescription(rs.getString(3));
	    prbd.setRCA(rs.getString(4));
	    prbd.setPermanantResolution(rs.getString(5));
	    prbd.setETA(rs.getString(6));
	    prbd.setApplication(rs.getString(7));
	    prbd.setWorkGroup(rs.getString(8));
	    prbd.setLastupdUser(rs.getString(9));
	    prbd.setLastupdTimestamp(rs.getString(10));
	  
	    prbd.setUserName(rs.getString(11));
	
	 
	    
		}
		
	}
	catch(Exception e)
	{
	e.printStackTrace();
	cn.closeConnection();
	return null;
	}
	cn.closeConnection();
return prbd;

}
public int deleteIncident(String no) {
	
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement ps=con.prepareStatement(Queries.DELETE_INCIDENT);
		ps.setString(1, no);
		int b=ps.executeUpdate();
	return b;
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	
	return 0;
	
	
}
public int deleteProblem(String pno) {
	
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement ps=con.prepareStatement(Queries.DELETE_PROBLEM);
		ps.setString(1, pno);
		int b=ps.executeUpdate();
	return b;
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	
	return 0;
}
public Vector<String[]> getApp(String app)
{
   Vector<String[]> v=new Vector<String[]>();
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.GET_APP);
		pst.setString(1,app);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
				{
			String[] s=new String[2];
			for(int j=1;j<3;j++)
			{
			
	s[j-1]=rs.getString(j);
			}
	v.add(s);
	
				}
	}
	catch(Exception e)
	{
	e.printStackTrace();
	cn.closeConnection();
	return null;
	}
	cn.closeConnection();
return v;
}
public Vector<String> getWG(String wg)
{
   Vector<String> v=new Vector<String>();
       try
       {
              java.sql.Connection con=cn.getConnection();
              PreparedStatement pst=con.prepareStatement(Queries.GET_WG);
              pst.setString(1,wg);
              ResultSet rs=pst.executeQuery();
              while(rs.next())
                           {
              v.add(rs.getString(1));
                           }
       }
       catch(Exception e)
       {
       e.printStackTrace();
       cn.closeConnection();
       return null;
       }
       cn.closeConnection();
return v;
}
public String countGCCI() 
{
	
	//String ch=null;
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_GCC);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
 	   while(rs.next())
 	   {
 	   
 	   a=rs.getString(1);
 	   }
 	  // System.out.println("a...."+a);
 	   return a;   
       
       /*if(ch.equals("GCCI"))
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_GCC);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;   
       }
       else if(ch.equals("GMSI")) 
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_GMS);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;      
       }
       else if(ch.equals("CTTI")) 
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_CTT);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;      
       }
       
       else if(ch.equals("JAPAI")) 
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_JAPA);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;      
       }
       else if(ch.equals("GCCP")) 
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_GCC);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;      
       }
       
       else if(ch.equals("GMSP")) 
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_GMS);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;      
       }
       
       else if(ch.equals("CTTP")) 
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_CTT);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;      
       }
       
       else
       {
    	   PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_JAPA);
    	   ResultSet rs=pst.executeQuery();
    	   return rs;      
       }
       
       */
       
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
	
}


public String countGCCP() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_GCC);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	   
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}


public String countGMSI() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_GMS);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	   //System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}

public String countGMSP() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_GMS);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	   //System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}
public String countCTTI() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_CTT);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	  // System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}


public String countCTTP() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_CTT);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	  // System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}

public String countJAPAI() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_JAPA);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	  // System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}


public String countJAPAP() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_JAPA);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	  // System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}



public String countMBTI() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_INCIDENT_MBT);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	   System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}


public String countMBTP() 
{
	try
	{
		java.sql.Connection con=cn.getConnection();
		PreparedStatement pst=con.prepareStatement(Queries.COUNT_PROBLEM_MBT);
 	   ResultSet rs=pst.executeQuery();
 	  String a=null;
	   while(rs.next())
	   {
	   
	   a=rs.getString(1);
	   }
	   System.out.println("a...."+a);
	   return a;  
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}







public int modifyIncident(String title, String desc, String pno,
		String waround, String cc,String luser,
		String no) {
	//title,desc,pno,waround,cc,app,cdate,ccdate,uname,wg,luser,lts,no);
	
	
	try
	{
		java.sql.Connection con=cn.getConnection();
        PreparedStatement pst=con.prepareStatement(Queries.MODIFY_INCIDENT);
        
        /*public static String MODIFY_INCIDENT=
        		"update Incident_Details set Incident_Title=?,"
        		+ " Incident_Description=?, Problem_Number=?, Work_Around=?,"
        		+ " Cause_Code=?, Application=?, Create_Date=?, Close_Date=?, User_Name=?,"
        		+ " Work_Group=?, Last_Updt_User=?, Last_Updt_Ts=? where Incident_Number=? 
*/       
        pst.setString(1,title);
        pst.setString(2,desc);
        pst.setString(3,pno);
        pst.setString(4,waround);
        pst.setString(5,cc);
       // pst.setString(6,app);
       // pst.setString(7,cdate);
       // pst.setString(8,ccdate);
        //pst.setString(6,uname);
      //  pst.setString(10,wg);
       pst.setString(6,luser);
       // pst.setString(12,lts);
        pst.setString(7,no);
        
        int modify=pst.executeUpdate();
        cn.closeConnection();
        return modify;
        
        
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	
	return 0;
}
public int modifyProblem(String pt, String pdesc, String rca, String prca,
		String eta, String luu,
		String pno) 

{
	try
	{
		
		System.out.println("in mdfyPrm Opertion");
		
		//System.out.println(pt+" "+pdesc+" "+rca+" "+prca+" "+eta+" "+app+" "+wg+" "+luu+" "+lut+" "+unm+" "+pno);
		
		java.sql.Connection con=cn.getConnection();
        PreparedStatement pst2=con.prepareStatement(Queries.MODIFY_PROBLEM);
        
        pst2.setString(1,pt);
        pst2.setString(2,pdesc);
        pst2.setString(3,rca);
        pst2.setString(4,prca);
        pst2.setString(5,eta);
       // pst2.setString(6,app);
       // pst2.setString(7,wg);
        pst2.setString(6,luu);
       // pst2.setString(9,lut);
       // pst2.setString(10,unm);
        pst2.setString(7,pno);
      
        
        int modifyPro=pst2.executeUpdate();
        
        cn.closeConnection();
        return modifyPro;
        
       /* public static String MODIFY_PROBLEM= "update Problem_Details set Problem_Title=?,"
        		+ " Problem_Description=?, RCA=?, Permanent_Resolution=?,ETA=?, Application=?,"
        		+ " Work_Group=?, Last_Updtd_User=?, Last_Updtd_Ts=? , User_Name=? "
        		+ "where Problem_Number=?";*/
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	
	return 0;
}


public Vector<String[]> search(String query)
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering search method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(query);
	System.out.println("qeury in seacrh method...."+query);

	if(!(rs.equals(null)))
	{
		while(rs.next())
		{	String[] s=new String[7];
			for(int j=1;j<=7;j++)
			{
			
	s[j-1]=rs.getString(j);
			}
	v.add(s);
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;

}


public String createQuery(HashMap<String,String> id)
{
System.out.println("Entering createQuery");
HashMap<String,String> hs=new HashMap<String,String>();	
HashMap<String,String> hs1=getColumns();
hs=id;
//test
/*Set<Entry<String,String>> set1 = hs.entrySet();
Iterator<Entry<String, String>> ii = set1.iterator();

while(ii.hasNext())
   { 
		 Map.Entry<String,String> me = (Map.Entry<String,String>)ii.next();
		 String column=me.getKey();
		 String value=me.getValue();
	System.out.println("column "+column+ "Value ="+value);	 
   }
*/
//test



	try
{
		if(!(hs==null))
		{
			String sql="select Incident_Number,Incident_Title,Problem_Number,Application,Create_date,Close_date,Work_Group from Incident_Details where ";
		 Set<Entry<String,String>> set = hs.entrySet();
	     Iterator<Entry<String, String>> i = set.iterator();
	     while(i.hasNext())
	     {
	    	 Map.Entry<String,String> me = (Map.Entry<String,String>)i.next();
	        	 
	    	 if(me.getKey().equals("IN"))
	    	 {
	    		 String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";
	    	 }
	    	
	    	 if(me.getKey().equals("IT"))
	    	 { String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("ID")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("PN")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("WA")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("AP")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("CD")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" =#"+value+"# and ";}
	    	 if(me.getKey().equals("COD")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" =#"+value+"# and ";}
	    	 if(me.getKey().equals("UN")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("WG")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("LUU")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("LUT")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("CC")){ String value=me.getValue(); sql=sql+hs1.get(me.getKey())+" like '%"+value+"%' and ";}
	    	 if(me.getKey().equals("LOB")){ String value=me.getValue(); sql=sql+"Application"+" IN "+Queries.LOB_SERCH+value+"') and ";}
	    	 if(me.getKey().equals("E2E")){ String value=me.getValue(); sql=sql+"Application"+" IN "+Queries.E2E_SERCH+value+"') and ";}
	      }
	     System.out.println("SQl Query :"+sql);
	     sql=sql.substring(0, sql.length()-5);
	     return sql;
		}}
	catch(Exception e)
	{	
		e.printStackTrace();
		return "error";	
	}
	//System.out.println("SQl Query :"+sql);
	System.out.println("Leaving createQuery");
	return null;

}




public static HashMap<String,String> getColumns()
{
	
	System.out.println("Entering getColumns");
	HashMap<String,String> hs=new HashMap<String,String>();
	hs.put( "IN","Incident_Number");
	hs.put( "IT","Incident_Title");
	hs.put( "ID","Incident_Description");
	hs.put( "PN","Problem_Number");
	hs.put( "WA","Work_Around");
	hs.put( "AP","Application");
	hs.put( "CD","Create_date");
	hs.put( "COD","Close_date");
	hs.put( "UN","User_Name");
	hs.put( "WG","Work_Group");
	hs.put( "LUU","Last_Updt_User");
	//hs.put( "LUT","Last_Updt_Ts");
	hs.put("CC","Cause_Code");
	hs.put("LOB","LOB");
	hs.put("E2E","E2E");
	System.out.println("Leaving getColumns");
	return hs;
	
}

public String createQuery2(String keyword)
{
System.out.println("Entering createQuery2");
	
HashMap<String,String> hs1=getColumns();



System.out.println("hs contails in :"+hs1.containsKey("IN"));
String sql="select Incident_Number,Incident_Title,Problem_Number,Application,Create_date,Close_date,Work_Group from Incident_Details where ";
	try
{
		 Set<Entry<String,String>> set = hs1.entrySet();
	     Iterator<Entry<String, String>> i = set.iterator();
	     while(i.hasNext())
	     {

	    	 
	    	 Map.Entry<String,String> me = (Map.Entry<String,String>)i.next();
	    	 String value=me.getValue();
	    	 //if(value.equals("Create_date")||value.equals("Close_date"))
	    	 //{
	    	 //sql= sql + value + " = #"+keyword+"# OR " ;
	    	 //}
	    	  if(value.equals("LOB"))
	    	 {
	    		 sql= sql + "Application" + " IN "+Queries.LOB_SERCH+keyword+"') OR " ;
	    	 }
	    	 else if(value.equals("E2E"))
	    	 {
	    		 sql= sql + "Application" + " IN "+Queries.E2E_SERCH+keyword+"') OR " ;
	    	 }
	    	 else if (value.equals("Close_date") || value.equals("Create_date")|| value.equals("Last_Updt_Ts") )
	    	 {
	    		 
	    	 }
	    	 else
	    	 { 
	    		
	    		 sql= sql + value +" like '%"+keyword+"%' OR " ;
	    	 }
	     }
	         

	     sql=sql.substring(0, sql.length()-4);
}
	catch(Exception e)
	{	
		e.printStackTrace();
		return "error";	
	}
	System.out.println("SQl Query :"+sql);
	System.out.println("Leaving createQuery");
	return sql;

}



public boolean addUser(String username, String password, boolean admin, boolean spoc) {
	try
	{
	java.sql.Connection con=cn.getConnection();
	PreparedStatement ps=con.prepareStatement(Queries.ADD_USER);
	
	ps.setString(1,username);
	ps.setString(2,password);
	ps.setBoolean(3, admin);
	ps.setBoolean(4, spoc);
	
	System.out.println(username+" "+password+" "+admin+" "+spoc);
	int result=ps.executeUpdate();
	if(result>0)
	{
		System.out.println("Executed successfully SQL CODE:"+result);
		return true;
	}
	else
	{
		System.out.println("Error inserting data SQL CODE :"+result);
		return false;
	}
		
	
}
catch(Exception e)
{
	e.printStackTrace();
	return false;
}
}


public Vector<String[]> topGCCI()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering TopGccI method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_GCCI);
	System.out.println("qeury in seacrh method....");
int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;

}



public Vector<String[]> topGCCP()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering TopGccP method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_GCCP);
	System.out.println("qeury in seacrh method....");
	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;
}

public Vector<String[]> topGMSI()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top gmsi method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_GMSI);
	System.out.println("qeury in seacrh method....");
	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;


}

public Vector<String[]> topGMSP()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top gmsp method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_GMSP);
	System.out.println("qeury in seacrh method....");

	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;
}

public Vector<String[]> topCTTI()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top ctti method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_CTTI);
	System.out.println("qeury in seacrh method....");
	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;


}

public Vector<String[]> topCTTP()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top cttp method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_CTTP);
	System.out.println("qeury in seacrh method....");

	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;

}

public Vector<String[]> topJAPAI()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top japai method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_JAPAI);
	System.out.println("qeury in seacrh method....");
	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;

}

public Vector<String[]> topJAPAP()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top japap method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_JAPAP);
	System.out.println("qeury in seacrh method....");

	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;

}

public Vector<String[]> topMBTI()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top MBTI method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_MBTI);
	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;


}

public Vector<String[]> topMBTP()
{  
	Vector<String[]> v =new Vector<String[]>();
	System.out.println("Entering Top japap method");
try
{
	java.sql.Connection con=cn.getConnection();
	Statement pst=con.createStatement();
	//System.out.println("qeury in seacrh method...."+query);
	ResultSet rs=pst.executeQuery(Queries.TOP_MBTP);
	System.out.println("qeury in seacrh method....");
	int k=0;
	if(!(rs.equals(null)))
	{
		
		
		while(rs.next())
		{	
			if(k>2)
			{
				System.out.println("break in s");
				break;
				
			}
			String[] s=new String[3];
			
			
			s[0]=rs.getString(1);
			System.out.println("qeury in seacrh method...."+s[0]);
		    
			
			 v.add(s);
			k++;

				//System.out.println("qeury in seacrh method....");
				
		}

		cn.closeConnection();
		System.out.println("closed connection returning");
		return v;
	}
	else
	{
		System.out.println("Exit formelse block");
		return null;
	}
	
}
catch(Exception e)
{
e.printStackTrace();
	
	
}
return null;

}



public int getCounter()
	{
		Statement stmt = null;
	    int counter=0;
	    try{
	    	java.sql.Connection con=cn.getConnection();
	    	stmt = con.createStatement();
	    	ResultSet rs121 = stmt.executeQuery("select counter from counter_table");
			 
			  while (rs121.next()) 
			  {
			    counter=rs121.getInt("counter");
			 }
			  
	    }

	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    	  
		  
		return counter;
		
	}

}




