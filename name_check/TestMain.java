import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class TestMain {
	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	@Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	 
 
	  @Test
	  public void testMain1() {
		// input:"abcx" (provided through args)
		// output: "pure name"	  
		
		
	    exit.expectSystemExitWithStatus(0);
	    exit.checkAssertionAfterwards(new Assertion() {
	      public void checkAssertion() {
	    	  String printedName=systemOutRule.getLog().strip();
	        assertEquals("pure name", printedName);
	      }
	    });
	    PureNameCheck.main(new String[]{"abcx"});
	  }
	  
	  @Test
	  public void testMain2() {
		// input:"nameFromSystemIn123" (provided through system.in)
		// output: "not pure name"
		  
		String[] simulatedArgs = {};
		systemInMock.provideLines("nameFromSystemIn1");
	    
		exit.expectSystemExitWithStatus(0);
	    exit.checkAssertionAfterwards(new Assertion() {
	      public void checkAssertion() {
	    	  String printedName=systemOutRule.getLog().strip();
	        assertEquals("not pure name", printedName);
	      }
	    });
	    PureNameCheck.main(simulatedArgs);
	  }

}
