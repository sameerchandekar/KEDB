package junit;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.Vector;

import org.junit.Test;

import com.kedb.jdbc.Operations;


public class TestCases 
{


@Test
public void testValidate()
{

	Operations op=new Operations();
	boolean flag=op.validate("Admin","test123");
	assertEquals(true, flag);
	/*
	String role=op.checkRole("Admin","test123");
	assertSame("admin",role);

	String role1=op.checkRole("Sameer","Sameer");
	assertSame("spoc",role1);

	String role2=op.checkRole("User","user");
	assertSame("user",role2);
	
int del=op.deleteIncident("INC00038564");
	assert*/
	
	
}



}
