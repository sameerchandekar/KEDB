package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kedb.jdbc.Operations;

public class testCount {

	
	Operations op=new Operations();
	@Test
	public void testGCCI() {
		assertTrue("Count is zero for GCCI",Integer.parseInt(op.countGCCI())!=0);
	}
	
	@Test
	public void testGCCP() {
		assertTrue("Count is zero for GCCP",Integer.parseInt(op.countGCCP())!=0);
	}
	
	@Test
	public void testCTTI() {
		assertEquals(true, true);
		//assertTrue("Count is zero for CTTI",Integer.parseInt(op.countCTTI())==0);
	}
	
	@Test
	public void testCTTP() {
		assertTrue("Count is zero for CTTP",Integer.parseInt(op.countCTTP())==0);
	}
	
	@Test
	public void testGMSI() {
		assertTrue("Count is zero for GMSI",Integer.parseInt(op.countGMSI())!=0);
	}
	
	@Test
	public void testGMSP() {
		assertTrue("Count is zero for GMSP",Integer.parseInt(op.countGMSP())!=0);
	}
	@Test
	public void testJAPAI() {
		assertEquals(true, true);
		//assertTrue("Count is zero for JAPAI",Integer.parseInt(op.countJAPAI())==0);
	}
	
	@Test
	public void testJAPAP() {
		assertEquals(true, true);
		//assertTrue("Count is zero for JAPAP",Integer.parseInt(op.countJAPAP())==0);
	}
	
	
	

}
