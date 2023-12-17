
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class TestRegularMethods {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Test
	public void testCheckPureName1() {
		// input: "name123"
		// expected output: "not pure name"	
		PureNameCheck nameCheck=new PureNameCheck();
		nameCheck.checkPureName("name123");			
		assertEquals("not pure name", systemOutRule.getLog().strip());	
	}	
	
	@Test
	public void testCheckPureName2() {		
		// input: "name"
	    // expected output: "pure name"
		PureNameCheck nameCheck=new PureNameCheck();
		nameCheck.checkPureName("name");		
		assertEquals("pure name", systemOutRule.getLog().strip());
	}
	
	
	@Rule
	  public final TextFromStandardInputStream systemInMock
	    = emptyStandardInputStream();
	
	@Test
	public void testGetNameFromSystemIn() {
		// input:"nameFromSystemIn123" (provided through system.in)
		// output: "not pure name"
		systemInMock.provideLines("nameFromSystemIn123");	
		PureNameCheck nameCheck=new PureNameCheck();		
		assertEquals("nameFromSystemIn123",nameCheck.getNameFromSystemIn() );		
	}
	
		

}
