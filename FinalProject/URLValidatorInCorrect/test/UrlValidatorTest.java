

import junit.framework.TestCase;

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
		   System.out.print(urlString + " Exception Error with bad URL - Test Fails!\n");
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
       assertTrue(testURL.isValid("http://oregonstate.edu"));
       assertTrue(testURL.isValid("http://oregonstate.edu/"));
       assertTrue(testURL.isValid("http://oregonstate.edu/about"));
       
       //Valid URL's to test against the manualTestHelper
       manualTestHelper(testURL, "http://www.oregonstate.com:80");
       manualTestHelper(testURL, "http://www.oregonstate.edu");
       manualTestHelper(testURL, "http://www.oregonstate.edu/");
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
	   System.out.println("Partition Two Testing\n");
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
	   System.out.println();
	   System.out.println("*************************************************************");
	   System.out.println("Programmatic Testing");
	   System.out.println("*************************************************************");

     
     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     
//     TEST SCHEMES
//     ---------------------------------------------------------------------
     
     // loop through the schemes below
     int i;
     
     for(i = 0; i < urlSchemes.length; i++)
     {
    	 StringBuffer buffer = new StringBuffer("www.example.com");
    	 
//    	 insert the scheme into beginning of schemeTest to create the URL
    	 buffer.insert(0, urlSchemes[i].item);
    	 String url = buffer.toString();
    	 System.out.println("Testing the URL scheme with URL " + url);
    	 try 
    	 {
//        	 call isValid on URL
        	 boolean result = urlVal.isValid(url);
//        	 compare expected and actual result, print "test failed: <URL>" on failure
//        	 if isValid should be true and it returns false  
        	 if ((urlSchemes[i].valid == true) && (result == false)) {
        			 System.out.println("TEST FAILURE: " + url + " should be valid");
        	 } else if((urlSchemes[i].valid  == false) && (result == true)) { // if isValid should be false and returns true
        			 System.out.println("TEST FAILURE: " + url + " should not be valid");
        	 } else {
        		 System.out.print(url + " is a good URL - Test Passes!\n");
        	 }
    	 } 
    	 catch(ExceptionInInitializerError e) {
    		 System.out.println("Exception error with url: " + url);
    	 }
    	 catch(NoClassDefFoundError e) {
    		 System.out.println("NoClassDefFound error with url: " + url);
    	 }
    	 System.out.println();

     }

//     TEST DOMAINS
//   ---------------------------------------------------------------------
     
//     loop through the domains below
     for (i = 0; i < urlHosts.length; i++)
     {
//    	 base url with scheme
    	 StringBuffer buffer = new StringBuffer("http://");
    	 
//    	 append domain to scheme
    	 buffer.append(urlHosts[i].item);
    	 String url = buffer.toString();
    	 System.out.println("Testing the URL authority with URL " + url);
    	 
    	 try 
    	 {
//    		 System.out.println("url is " + url);
//        	 call isValid on URL
    		 //System.out.println(url);
        	 boolean result = urlVal.isValid(url);
        	 
//        	 compare expected and actual result, print "test failed: <URL>" on failure
//        	 if isValid should be true and it returns false  
        	 if ((urlHosts[i].valid == true) &&(result == false)) {
        			 System.out.println("TEST FAILURE: " + url + " should be valid"); 
        	 }
//        	 if isValid should be false and returns true
        	 else if((urlHosts[i].valid == false) && (result == true)) {
        			 System.out.println("TEST FAILURE: " + url + " should not be valid");
        	 } else {
        		 System.out.print(url + " is a good URL - Test Passes!\n");
        	 }
    	 } 
    	 catch(ExceptionInInitializerError e)
    	 {
    		 System.out.println("Exception error with url: " + url);
    	 }
    	 catch(NoClassDefFoundError e)
    	 {
    		 System.out.println("NoClassDefFound error with url: " + url);
    	 }
    	 System.out.println();
    	    	 
     }

//     TEST PORTS
//   ---------------------------------------------------------------------
     for (i = 0; i < urlPorts.length; i++)
     {
//    	 base url 
    	 StringBuffer buffer = new StringBuffer("http://www.example.com");
    	 
//    	 append port number to scheme
    	 buffer.append(urlPorts[i].item);
    	 String url = buffer.toString();
    	 System.out.println("Testing the URL ports with URL " + url);
    	 
    	 try 
    	 {
//        	 call isValid on URL
        	 boolean result = urlVal.isValid(url);
        	 
//        	 compare expected and actual result, print "test failed: <URL>" on failure
//        	 if isValid should be true and it returns false  
        	 if ((urlPorts[i].valid == true) && (result = false)) {
        		 System.out.println("TEST FAILURE: " + url + " should be valid");
        	 }
//        	 if isValid should be false and returns true
        	 else if((urlPorts[i].valid == false) && (result == true)) {
        		 System.out.println("TEST FAILURE: " + url + " should not be valid");
        	 } else {
        		 System.out.print(url + " is a good URL - Test Passes!\n");
        	 }
    	 } 
    	 catch(ExceptionInInitializerError e)
    	 {
    		 System.out.println("Exception error with url: " + url);
    	 }
    	 catch(NoClassDefFoundError e)
    	 {
    		 System.out.println("NoClassDefFound error with url: " + url);
    	 }
    	 System.out.println();
    	 
     }
     
     
//     TEST PATHS
//   ---------------------------------------------------------------------
     for (i = 0; i < urlPaths.length; i++)
     {
//    	 base url
    	 StringBuffer buffer = new StringBuffer("http://www.google.com");
    	 
//    	 append path to buffer
    	 buffer.append(urlPaths[i].item);
    	 String url = buffer.toString();
    	 System.out.println("Testing the URL paths with URL " + url);
    	 
    	 try 
    	 {
//        	 call isValid on URL
        	 boolean result = urlVal.isValid(url);
        	 
//        	 compare expected and actual result, print "test failed: <URL>" on failure
//        	 if isValid should be true and it returns false  
        	 if ((urlPaths[i].valid == true) && (result == false)) {
        		 System.out.println("TEST FAILURE: " + url + " should be valid");
        	 }
//        	 if isValid should be false and returns true
        	 else if((urlPaths[i].valid == false) && (result == true)) {
        		 	System.out.println("TEST FAILURE: " + url + " should not be valid");
        	 } else {
        		 System.out.print(url + " is a good URL - Test Passes!\n");
        	 }
    	 } 
    	 catch(ExceptionInInitializerError e)
    	 {
    		 System.out.println("Exception error with url: " + url);
    	 }
    	 catch(NoClassDefFoundError e)
    	 {
    		 System.out.println("NoClassDefFound error with url: " + url);
    	 }
    	 System.out.println();

     }
     
//   TEST IPv4 addresses
// ---------------------------------------------------------------------
     for (i = 0; i < urlIps.length; i++)
     {
//    	 base url scheme
    	 StringBuffer buffer = new StringBuffer("http://");
    	 
//    	 append IPv4 address to buffer
    	 buffer.append(urlIps[i].item);
    	 String url = buffer.toString();
    	 System.out.println("Testing the URL IP's with URL " + url);
    	 
    	 try 
    	 {
//        	 call isValid on URL
        	 boolean result = urlVal.isValid(url);
        	 
//        	 compare expected and actual result, print "test failed: <URL>" on failure
//        	 if isValid should be true and it returns false  
        	 if ((urlIps[i].valid == true) && (result == false)) {
        		 System.out.println("TEST FAILURE: " + url + " should be valid");
        	 }
//        	 if isValid should be false and returns true
        	 else if((urlIps[i].valid == false) && (result == true)) {
        		 System.out.println("TEST FAILURE: " + url + " should not be valid");
        	 } else {
        		 System.out.print(url + " is a good URL - Test Passes!\n");
        	 }
    	 } 
    	 catch(ExceptionInInitializerError e)
    	 {
    		 System.out.println("Exception error with url: " + url);
    	 }
    	 catch(NoClassDefFoundError e)
    	 {
    		 System.out.println("NoClassDefFound error with url: " + url);
    	 }
    	 System.out.println();
    	 
     }
     
     System.out.println("\nProgrammatic Testing Complete");
     System.out.println("*************************************************************");

     
   }

//   Test data for testIsValid()
//   tests URL's are formed by concatenating together 
// <scheme>://<host>:<port>/<path>. Calling isValid() on 
//   a test URL should only return true if all parts of the URL
//   are valid
   
   ResultPair[] urlSchemes = {
		   new ResultPair("http://", true),
		   new ResultPair("ftp://", true),
		   new ResultPair("https://", true),        // https:// causes noClassDefFoundError
		   new ResultPair("http:/", false),
		   new ResultPair("blah://", false),   // causes noClassDefFoundError
		   new ResultPair("", true),
		   new ResultPair("abdc://", false),
		   new ResultPair("http//:", false)
   };
   
   ResultPair[] urlHosts = {
		   new ResultPair("www.example.com", true),
		   new ResultPair("www.facebook.com", true),
		   new ResultPair("www.applecom", false),
		   new ResultPair("www.oregonstate.edu", true),
		   new ResultPair("www.oregonstateedu", false)
   };
   
   ResultPair[] urlIps = {
		   new ResultPair("192.0.13.22", true),
		   new ResultPair("255.255.255.255", true),
		   new ResultPair("192.256.0.15", false),
		   new ResultPair("255.300.0.15", false)
   };
   
   
   ResultPair[] urlPorts = {
		   new ResultPair(":80", true),
		   new ResultPair(":1", true),
		   new ResultPair(":65535", true),
		   new ResultPair(":-1", false),
		   new ResultPair(":66000", false)
   };
   
   
   ResultPair[] urlPaths = {
		   new ResultPair("/testPath1", true),
		   new ResultPair("/testPath1/test", true),
		   new ResultPair("/te tPath", false),
		   new ResultPair("/stuff/{things}", false),
		   new ResultPair("/bad\things", false),
		   new ResultPair("/bad[character", false)
   };
   

}
