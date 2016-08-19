package com.sap.junit.assertions;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import java.util.Arrays;
import org.hamcrest.core.CombinableMatcher;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;

public class TestAssertions {
	
	@Test
	public void testAssertArrayEquals(){
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		assertArrayEquals("failed, not the same", expected, actual);
	}
	@Test
	  public void testAssertEquals() {
	    assertEquals("failure - strings are not equal", "text", "text");
	  }

	@Test
	  public void testAssertFalse() {
	    assertFalse("failure - should be false", false);
	  }

	  @Test
	  public void testAssertNotNull() {
	    assertNotNull("should not be null", new Object());
	  }

	  @Test
	  public void testAssertNotSame() {
	    assertNotSame("should not be same Object", new Object(), new Object());
	  }

	  @Test
	  public void testAssertNull() {
	    assertNull("should be null", null);
	  }

	  @Test
	  public void testAssertSame() {
	    Integer aNumber = Integer.valueOf(768);
	    assertSame("should be same", aNumber, aNumber);
	  }

	  //JUnit Matches assertThat
	  @Test
	  public void testAssertThatBothContainsString() {
		    assertThat("albumen", both(containsString("a")).and(containsString("b")));
	  }
	  
	  @Test
	  public void testAssertThatEveryItemContainsString() {
	    assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	  }
	  
	  //Core Hamcrest Matcher with assertThat
	  
	  @Test
	  public void testAssertThatHamcrestCoreMatchers(){
		  assertThat("good", allOf(equalTo("good"), startsWith("good")));
		  assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		  assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		  assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		  assertThat(new Object(), not(sameInstance(new Object())));
	  }
	  
	  @Test
	  public void testAssertTrue(){
		  assertTrue("failure - sould be true", true);
	  }
}
