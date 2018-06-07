

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
           if (testURL.isValid(urlString)) {
               System.out.print(urlString + " is a good URL - Test Passes!\n");
           } else {
               System.out.print(urlString + " is a bad URL - Test Fails!\n");
           }
   }
   
   
   public void testManualTest()
   {
	   //Manual Testing header
	   System.out.println("*************************************************************");
	   System.out.print("Manual Testing\n");
	   System.out.println("Calling the isValid methon or URLValidator with different");
	   System.out.println("possible valid/invalid inputs to see if we find any failures");
	   System.out.println("*************************************************************");
	   UrlValidator testURL = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES );
	   
	   //Valid URL's expected to pass the isValid checker
	   //IE these are good URL's
       assertTrue(testURL.isValid("http://www.oregonstate.edu"));
       assertTrue(testURL.isValid("http://www.oregonstate.edu/"));
       assertTrue(testURL.isValid("http://www.oregonstate.edu/about"));
       assertTrue(testURL.isValid("http://www.oregonstate.edu/about"));
       assertTrue(testURL.isValid("http://oregonstate.edu"));
       assertTrue(testURL.isValid("http://oregonstate.edu/"));
       assertTrue(testURL.isValid("http://oregonstate.edu/about"));
       
       //This one below fails so it's commented out to run and we'll send this one 
       //to the manualTestHelper. Note that this is a real valid URL and we need to check
       //if this is a bug
       //assertTrue(testURL.isValid("https://login.oregonstate.edu/idp/profile/cas/login?execution=e1s1"));
       
       //This one below passes but the URL is wrong with the .beaver. Let's check if 
       //this is a bug
       assertTrue(testURL.isValid("http://www.github.beaver"));
       
       //This one below fails but the URL is valid so we need to check if this is a bug.
       //we'll comment this out and use the manualTestHelper 
       //assertTrue(testURL.isValid("http://www.oregonstate.edu:80"));
       
       //This is a valid URL but fails
       manualTestHelper(testURL, "http://www.oregonstate.edu:80");
       //This is a valid URL but fails and causes the program to crash so let's comment it out
       //manualTestHelper(testURL, "https://login.oregonstate.edu/idp/profile/cas/login?execution=e1s1");
       //This is an invalid URL but passes
       manualTestHelper(testURL, "http://www.github.beaver");

      
       System.out.println("Completed the manual testing!\n");
       
   }
   

   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
