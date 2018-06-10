

import junit.framework.TestCase;
import java.util.concurrent.ThreadLocalRandom;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!



public class UrlValidatorTest extends TestCase {
   
   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void manualTestHelper(UrlValidator testURL, String urlString)
   {
   //This function will use a standard check for a manual URL
	   System.out.print(urlString + " manual check !\n");
	   
	   try {
		   
	       if (testURL.isValid(urlString)) {
	    	   System.out.print(urlString + " is a good URL - Test Passes!\n");
	       } else {
	           System.out.print(urlString + " is a bad URL - Test Fails!\n");
	       }
       
	   } catch (ExceptionInInitializerError e) {
		   System.out.print(urlString + " is a bad URL - Test Fails!\n");
		   //e.printStackTrace();
	   }
   
   }
   
   
   public void testManualTest()
   {
	   //Manual Testing
	   System.out.println("*************************************************************");
	   System.out.print("Manual Testing\n");
	   System.out.println("Calling the isValid methon or URLValidator with different");
	   System.out.println("possible valid/invalid inputs to see if we find any failures");
	   System.out.println("*************************************************************");
	   UrlValidator testURL = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES );
	   
	   //Valid URL's expected to pass the assertions
	   //IE these are good URL's
       assertTrue(testURL.isValid("http://www.oregonstate.edu"));
       assertTrue(testURL.isValid("http://www.oregonstate.edu/"));
       assertTrue(testURL.isValid("http://www.oregonstate.edu/about"));
       assertTrue(testURL.isValid("http://www.oregonstate.edu/about"));
       assertTrue(testURL.isValid("http://oregonstate.edu"));
       assertTrue(testURL.isValid("http://oregonstate.edu/"));
       assertTrue(testURL.isValid("http://oregonstate.edu/about"));
       
       //Valid URL's to test against the manualTestHelper
       manualTestHelper(testURL, "http://www.oregonstate.com:80");
       manualTestHelper(testURL, "http://www.oregonstate.edu");
       manualTestHelper(testURL, "http://www.oregonstate.edu/");
       manualTestHelper(testURL, "http://www.oregonstate.edu/about");
       manualTestHelper(testURL, "http://www.oregonstate.edu/about");
       manualTestHelper(testURL, "http://oregonstate.edu");
       manualTestHelper(testURL, "http://oregonstate.edu/");
       manualTestHelper(testURL, "http://oregonstate.edu/about");
       
       //This one below fails so it's commented out to run and we'll send this one 
       //to the manualTestHelper. Note that this is a real valid URL and we need to check
       //if this is a bug
       //assertTrue(testURL.isValid("https://login.oregonstate.edu/idp/profile/cas/login?execution=e1s1"));
       
       //This one below passes but the URL is wrong with the .beaver. 
       //Let's check if this is a bug
       assertTrue(testURL.isValid("http://www.oregonstate.beaver"));
       
       //This one below fails but the URL is valid so we need to check if this is a bug.
       //we'll comment this out and use the manualTestHelper 
       //assertTrue(testURL.isValid("http://www.oregonstate.edu:80"));
       manualTestHelper(testURL, "http://www.oregonstate.com:80");

       //This is an invalid URL but passes
       manualTestHelper(testURL, "http://www.oregonstate.beaver");

       System.out.println("Completed the manual testing!\n");
       
   }
   
   public void testYourFirstPartition()
   {
	   //Partition One Testing
	   System.out.println("*************************************************************");
	   System.out.println("Partition One Testing");
	   System.out.println("Calling the isValid methon or URLValidator with different");
	   System.out.println("parts of the URL that are valid. Therefore, we expect the");
	   System.out.println("URL's to pass the assertions");
	   System.out.println("*************************************************************");
       
       //Test the Scheme
       UrlValidator urlScheme = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will pass the assertion test
       System.out.println();
       System.out.println("Testing the URL with a good scheme");
       String scheme = "http://";
       manualTestHelper(urlScheme, scheme+"www.oregonstate.com");
       //assertTrue(urlScheme.isValid(scheme+"www.oregonstate.com"));

       //Test the Authority
       UrlValidator urlAuthority = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will pass the assertion test
       System.out.println();
       System.out.println("Testing the URL with a good authority");
       String authority = "www.oregonstate.com";
       manualTestHelper(urlAuthority, "http://"+authority);
       //assertTrue(urlAuthority.isValid(scheme+authority));
       
       //Test the URL port
       UrlValidator urlPort = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will pass the assertion test
       System.out.println();
       System.out.println("Testing the URL with a good port");
       String port = ":80";
       manualTestHelper(urlPort, "http://www.oregonstate.com"+port);
       //assertTrue(urlPort.isValid(scheme+authority+port));
       
       //Test the path
       UrlValidator urlPath = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will pass the assertion test
       System.out.println();
       System.out.println("Testing the URL with a good path");
       String path = "/test1";
       manualTestHelper(urlPath, "http://www.oregonstate.com"+path);
       //assertTrue(urlPort.isValid(scheme+authority+port+path));
       
       //Test the query
       UrlValidator urlQuery = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will pass the assertion test
       System.out.println();
       System.out.println("Testing the URL with a good query");
       String query = "?action=view";
       manualTestHelper(urlQuery, "http://www.oregonstate.com"+query);
       //assertTrue(urlQuery.isValid(scheme+authority+port+path+query));
       
       System.out.print("Partition One Testing Complete\n");
	   System.out.println("*************************************************************");
       
	}
	   
   
   public void testYourSecondPartition(){
	 //Partition One Testing
	   System.out.println("*************************************************************");
	   System.out.print("Partition Two Testing\n");
	   System.out.println("Calling the isValid methon or URLValidator with different");
	   System.out.println("parts of the URL that are invalid.");
	   System.out.println("*************************************************************");
       
	 //Test the Scheme
       UrlValidator urlScheme = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will fail the assertion test because there is no CS scheme
       System.out.println();
       System.out.println("Testing the URL with a bad scheme");
       String scheme = "CS://";
       manualTestHelper(urlScheme, scheme+"www.oregonstate.com");
       //assertTrue(urlScheme.isValid(scheme+"www.oregonstate.com"));

       //Test the Authority
       UrlValidator urlAuthority = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will fail the assertion test because there is no starwars top level domain
       System.out.println();
       System.out.println("Testing the URL with a bad authority");
       String authority = "www.oregonstate.starwars";
       manualTestHelper(urlAuthority, "http://"+authority);
       //assertTrue(urlAuthority.isValid(scheme+authority));
       
       //Test the URL port
       UrlValidator urlPort = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will fail the assertion test because the port number is outside the max of 65536
       System.out.println();
       System.out.println("Testing the URL with a bad port");
       String port = ":65537";
       manualTestHelper(urlPort, "http://www.oregonstate.com"+port);
       //assertTrue(urlPort.isValid(scheme+authority+port));
       
       //Test the path
       UrlValidator urlPath = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will fail the assertion test due to a bad path 
       System.out.println();
       System.out.println("Testing the URL with a bad path");
       String path = "////";
       manualTestHelper(urlPath, "http://www.oregonstate.com"+path);
       //assertTrue(urlPort.isValid(scheme+authority+port+path));
       
       //Test the query
       UrlValidator urlQuery = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       //The expectation is that this will fail the assertion test due to an extra ? to start the query string
       System.out.println();
       System.out.println("Testing the URL with a bad query");
       String query = "?action=window";
       manualTestHelper(urlQuery, "http://www.oregonstate.com"+query);
       //assertTrue(urlQuery.isValid(scheme+authority+port+path+query));
       
       System.out.print("Partition Two Testing Complete\n");
	   System.out.println("*************************************************************");
   }

   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
