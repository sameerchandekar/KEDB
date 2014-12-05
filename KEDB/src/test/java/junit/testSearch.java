package junit;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.kedb.jdbc.Operations;

public class testSearch {

	@Test
	public void testsearchData() throws SQLException
	{
		Operations op=new Operations();
		ResultSet rs=op.searchData("incident","INC002883981");
		
		while(rs.next())
		{
		return;
		}
		
		fail("search is not working");
		
	}

}
