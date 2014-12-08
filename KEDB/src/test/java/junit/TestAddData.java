package junit;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.kedb.jdbc.Connection;
import com.kedb.jdbc.Operations;
import com.kedb.util.Queries;

public class TestAddData {

	Operations op=new Operations();
	 String ia;
	 int i;
	
	public void testAddDataaaa() throws Exception {
		
		
		Connection cn=new Connection();
		java.sql.Connection con=cn.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select count from UniqNum");
		while (rs.next()) {
           ia = rs.getString("count");
           System.out.println("this befdore"+ia);
		}
		
		i=Integer.parseInt(ia);
		i++;
		System.out.println("intermediate"+i);
		PreparedStatement ps=con.prepareStatement("insert into UniqNum(count) values (?)");
		String ib=Integer.toString(i);
		ps.setString(1,ib);
		int result=ps.executeUpdate();
		System.out.println("done");
		if(result>0)
		{
			//System.out.println("Executed successfully SQL CODE:"+result);
			System.out.println("after"+i);
			
		}
		
		
	}
	
	
	
	
	@Test
	public void testaddProblem() throws Exception
	{
		testAddDataaaa();
		
		boolean flag=op.addProblem("NotAUniqPrb"+i+"", "testprbtitle", "testprbdesc", "testrca", "testpr", "01/01/2014", "testwg", "GREG", "Admin");
		assertEquals(true, flag);
		System.out.println("addprb");
		
		
	}
	
	@Test
	public void hi()
	{
		boolean aa=true;
		assertEquals(true, aa);
	}
	
	
	@Test
	public void testaddData() throws Exception
	{
		
		testAddDataaaa();
		boolean flag=op.addData("NotAUniqINCa"+i+"", "testtitle", "testdesc", "testprb2", "testWorkAround"," testCauseCode", "GREG","01/01/2014","01/02/2014","Admin","GLCSETW_AXP_GL");
		assertEquals(true, flag);
		System.out.println("adddata");
		//System.out.println("done"+flag);
		
		
	}
	
	
	@Test
    public void testAddUser() throws Exception
    {
		testAddDataaaa();
		boolean aaa=op.addUser("NotAUniqUseraaa"+i+"", "testpass",true,true);
		assertEquals(true, aaa);
		
    	 // assertEquals("adding user fails", true, op.addUser("NotAUniqUsera"+i+"", "testpass",true,true));
    	  System.out.println("adduser");
	
    	
    }

	
	
}
