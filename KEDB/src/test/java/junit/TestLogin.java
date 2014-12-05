package junit;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.kedb.jdbc.Operations;


public class TestLogin 
{
 Operations op=new Operations();
   
@Test
public void testValidate()
{

	Operations op=new Operations();
	System.out.println("test validate");
	boolean flag=op.validate("Admin","test123");
	assertEquals(true, flag);
}

@Test
public void testRoles()
{
	System.out.println("test checkrole");
	Operations op=new Operations();
	String role=op.checkRole("Admin","test123");
	assertEquals("admin",role);
	
	String role1=op.checkRole("Spoc","test456");
	assertEquals("spoc",role1);

	String role2=op.checkRole("testuser1","testpass");
	assertEquals("user",role2);
}


}
