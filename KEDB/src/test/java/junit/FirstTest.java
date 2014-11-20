package junit;

import static org.junit.Assert.*;


import org.junit.Test;

public class FirstTest {

	String message = "Hello someone!!";	
	   MessageUtil messageUtil = new MessageUtil(message);

	   @Test
	   public void testPrintMessage() {	  
	      assertEquals(message,messageUtil.printMessage());
	   }

}
