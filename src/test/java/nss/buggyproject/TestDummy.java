package nss.buggyproject;
/**
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * @author nikhils
 *
 */
@RunWith(JUnitPlatform.class)
public class TestDummy {

	protected static Logger logger = Logger.getLogger("TestDummy");

	@DisplayName("First Test")
	@Test
	public void myFirstTest() {
		assertEquals(2, 1 + 1);
		logger.fine("Fine Message");
		logger.info("Info Message");
	}

	@Disabled
	@Test
	public void testWillBeSkipped() {
		System.out.println("dsddsfs");
		logger.fine("Fine Message");
		logger.info("Info Message");
	}

	@Disabled
	@Test
	public void testGetStringLengthSimpleTest() {
		assertEquals("hello:5", "hello", () -> "'hello' (length: 5) wasn't calculated properly");
	}

	@Test
	void testInAllEnvironments() {
		assumingThat("CI".equals(System.getenv("ENV")), () -> {
			// perform these assertions only on the CI server
			assertEquals(2, 3);
			System.out.println("CI");
		});

		// perform these assertions in all environments
		assertEquals("a string", "a string");
		System.out.println("NOT CI");
	}

	@Test
	void testOnlyOnDeveloperWorkstation() {
		assumeTrue("DEV".equals(System.getenv("ENV")), "Aborting test: not on developer workstation");
		// remainder of test
		System.out.println("Executed...");
	}
	
	@Test
	void testCheck() {
		BuggyStringUtil bg = new BuggyStringUtil();
		assertEquals("teststring", bg.trim(" teststring"));
	}

}
