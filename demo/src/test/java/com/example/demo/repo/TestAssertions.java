package com.example.demo.repo;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

@SpringBootTest
public class TestAssertions {

	@Test
	@Disabled
	public void testAssertEquals() {
		// test data
		String str1 = new String("abc");
		String str2 = new String("abc");

		// Check that two objects are equal
		assertEquals(str1, str2);

	}

	@Test
	@Disabled
	public void testAssertTrue() {
		// test data
		int val1 = 5;
		int val2 = 6;

		// Check that a condition is true
		assertTrue(val1 < val2);

	}

	@Test
	@Disabled
	public void testAssertFalse() {
		// test data
		int val1 = 5;
		int val2 = 6;

		// Check that a condition is false
		assertFalse(val1 > val2);

	}

	@Test
	@Disabled
	public void testAssertNotNull() {
		// test data
		String str1 = new String("abc");

		// Check that an object isn't null
		assertNotNull(str1);

	}

	@Test
	@Disabled
	public void testAssertNull() {
		// test data
		String str3 = null;

		// Check that an object is null
		assertNull(str3);

	}

	@Test
	@Disabled
	public void testAssertSame() {
		// test data
		String str4 = "abc";
		String str5 = "abc";

		// Check if two object references point to the same object
		assertSame(str4, str5);

	}

	@Test
	@Disabled
	public void testAssertNotSame() {
		// test data
		String str1 = new String("abc");
		String str3 = null;

		// Check if two object references not point to the same object
		assertNotSame(str1, str3);

	}

	@Test
	@Disabled
	public void testAssertArrayEquals() {
		// test data
		String[] expectedArray = { "one", "two", "three" };
		String[] resultArray = { "one", "two", "three" };

		// Check whether two arrays are equal to each other.
		assertArrayEquals(expectedArray, resultArray);

	}

}
