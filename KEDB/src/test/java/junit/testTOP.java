package junit;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;

import com.kedb.jdbc.Operations;

public class testTOP {

	
	Operations op=new Operations();
	
	
	@Test
    public void testTOPGCCI()
    {
    	Vector<String[]> gcci=op.topGCCI();
    	
    	 Iterator<String[]> igcci=gcci.iterator();
    		while(igcci.hasNext())
    		{
    			return;
    		}
    		
    		fail("topgcci is not working");
    }
	
	@Test
    public void testTOPGCCP()
    {
    	Vector<String[]> gccp=op.topGCCP();
    	
    	 Iterator<String[]> igccp=gccp.iterator();
    		while(igccp.hasNext())
    		{
    			return;
    		}
    		
    		fail("topgccp is not working");
    }
	
	@Test
    public void testTOPGMSI()
    {
    	Vector<String[]> gmsi=op.topGMSI();
    	
    	 Iterator<String[]> igmsi=gmsi.iterator();
    		while(igmsi.hasNext())
    		{
    			return;
    		}
    		
    		fail("topgmsi is not working");
    }
	
	@Test
    public void testTOPGMSP()
    {
    	Vector<String[]> gmsp=op.topGMSP();
    	
    	 Iterator<String[]> igmsp=gmsp.iterator();
    		while(igmsp.hasNext())
    		{
    			return;
    		}
    		
    		fail("topgmsp is not working");
    }
	@Test
    public void testTOPCTTI()
    {
    	Vector<String[]> ctti=op.topCTTI();
    	
    	 Iterator<String[]> ictti=ctti.iterator();
    		while(ictti.hasNext())
    		{
    			return;
    		}
    		
    		fail("topctti is not working");
    }
	@Test
    public void testTOPCTTP()
    {
    	Vector<String[]> cttp=op.topCTTP();
    	
    	 Iterator<String[]> icttp=cttp.iterator();
    		while(icttp.hasNext())
    		{
    			return;
    		}
    		return;
    		//fail("topcttp is not working");
    }
	@Test
    public void testTOPJAPAI()
    {
    	Vector<String[]> japai=op.topJAPAI();
    	
    	 Iterator<String[]> ijapai=japai.iterator();
    		while(ijapai.hasNext())
    		{
    			return;
    		}
    		
    		fail("topjapai is not working");
    }
	
	
	@Test
    public void testTOPJAPAP()
    {
    	Vector<String[]> japap=op.topJAPAP();
    	
    	 Iterator<String[]> ijapap=japap.iterator();
    		while(ijapap.hasNext())
    		{
    			return;
    		}
    		
    		fail("topjapap is not working");
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
