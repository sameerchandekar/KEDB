
/*class*/
package com.kedb.jdbc;
import java.sql.*;

public class Connection
{
	
	public Connection()
	{
		
	}
	java.sql.Connection con=null;
public java.sql.Connection getConnection()
{
	
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	this.con=DriverManager.getConnection("jdbc:odbc:DSN","","");	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return this.con;
	
}

public String closeConnection()
{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return e.toString();
	}
	return "closed";
}
	
}
