package com.Axos.appiumTest;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Axos.appium.FlashCardMaker;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


    public class TestFlashCardMaker extends TestBaseAppium {
	private FlashCardMaker flashCardMaker;
	  
       @BeforeTest   
       public void SetTesting() {
    	  flashCardMaker=new FlashCardMaker(driver);
    	   
   }

    @Test( priority = 1)
	    //To click flash Card Maker  -  Verify correct redirection
	    public void clickFlashCardMaker() {
	       flashCardMaker.FlashCardMakerclickMethod();
		 
    Assert.assertTrue(flashCardMaker.displayPageTit(), "You are not directed to the correct page");
	    
   }
	   
   @Test(priority = 2)
	    //To click on + icon to add the first flashCard - Verify displaying New Stack Name pop up
	    public void addFlashcard() {
		   flashCardMaker.plusClick();   
	       driver.switchTo().alert();
	      
   Assert.assertTrue(flashCardMaker.popAddingDisplaying(), "The pop up for new stack is not displayed");
   }
	   
	   @Test(priority = 3)
	     //Verify that clicking on "create Stack with empty stack name is rejected
	   public void clickCreateStackNullStackName() {
		   flashCardMaker.clickCreateStack();
		   
	   Assert.assertTrue(flashCardMaker.rejectionMess(), "Create new stack with null Stack Name is Not Accepted");
		   
   }
	   
   @Test(priority = 4)
	      //Verify that clicking "Cancel" will hovering back to the previous page
	    public void clickCancel() {
           flashCardMaker.clickClose();
           flashCardMaker.plusClick();
           driver.switchTo().alert();
           flashCardMaker.clickCancel();
         
      Assert.assertTrue(flashCardMaker.displayPageTit(), "The Cancel button is not working correctly");
         
   }

     @Test(priority = 5)
	   //Verify that the Stack Name field is audible
	   public void TypeStackName() throws InterruptedException {
		  flashCardMaker.plusClick();
		  driver.switchTo().alert();
		  flashCardMaker.clickStackNFie();
		  flashCardMaker.sendKeysStackName("Appium Learning");
		  Thread.sleep(1000);
		  flashCardMaker.getTexOfFieldBack();
		 
	   Assert.assertEquals(flashCardMaker.getTexOfFieldBack(), "Appium Learning");
		    
    } 

    @Test(priority = 6)
      //verify that clicking create Stack button after Typing on StackName redirect the user to (fill cards page)
      public void correctFillPageRedirection() {
         flashCardMaker.clickCreateStack();
         
    Assert.assertEquals(flashCardMaker.StackTitleNextPage(),"Card 1 of 1 in Appium Learning" );
     }
      

      
    @Test(priority = 7 )
      //Verify that the user can type on the question field
      public void questionFieldAudiibility() {
    	  
      flashCardMaker.clickQfield();
      flashCardMaker.sendKeysQ("What is Appium?");
      String condition= flashCardMaker.audiQuesFie();
      
    Assert.assertEquals(condition,"What is Appium?" );
      
    }
    
    
    @Test(priority = 8)
   //Verify that the user can type on the Answer field 
    public void answerfieldAudibibty() {
    	flashCardMaker.clickAfield();
    	flashCardMaker.sendKeysA("Appium is an open-source tool for mobile app testing");
    	String condition2=flashCardMaker.audiAnswerFie();
    	
    Assert.assertEquals(condition2, "Appium is an open-source tool for mobile app testing");
    	
    }
     
      @Test(priority = 9)
   //verify that after typing on the question and answer field and click+ above the card is saved 
    public void clickSaveAfterFilling() {    
        flashCardMaker.clickSavePlusIcon();
    	String cardTitle =flashCardMaker.StackTitleNextPage();
    	
   	Assert.assertTrue(cardTitle.contains("2"), "The next card is not open , there is a problem");
    	
    } 
     
    @Test (priority = 10 )
  //Verify that when click save with empty question and answer fields, the system displayed a rejection message 
   public void clickSaveEmptyFields() {
	   flashCardMaker.clickSavePlusIcon();
	   driver.switchTo().alert();
	   String message= flashCardMaker.getRejectMessEmptyAdd();
	   boolean condition =message.contains("Each card needs an image or text");
	   
   Assert.assertTrue(condition , "The empty is Accepted , there is an issue to check");
  
  }
    
    @Test(priority = 11)
    //verify that clicking on "Continue Editing" will hover you back to the adding cards page
    
   public void clickContinueEditing() {
    	flashCardMaker.clickConEditiing();
 
    	boolean condition=flashCardMaker.pageIsDisplayed();
    	
   	Assert.assertTrue(condition, "the button has a wrong redirection");
    }
    
     @Test (priority = 12)
    //verify that the system reject adding the same question and answer for the same stack          (BUG)
    public void addingDuplicateFlashCards() {
    	String before=flashCardMaker.StackTitleNextPage();
    	System.out.println(before);
        flashCardMaker.clickQfield();
        flashCardMaker.sendKeysQ("What is Appium?");
    	flashCardMaker.clickAfield();
    	flashCardMaker.sendKeysA("Appium is an open-source tool for mobile app testing");
    	flashCardMaker.clickSavePlusIcon();
    
    	String after=flashCardMaker.StackTitleNextPage();
    	System.out.println(after);
    	
    Assert.assertEquals(before, after,("Its a Bug a duplicated flash card is added"));
    	
    }
    
     @Test(priority = 13)
    //Verify that we can after clicking on the camera icon a list of two selected choices will displayed
    public void getImageList()   {
    	flashCardMaker.imageQclick();

   	Assert.assertTrue(flashCardMaker.getImageList(), "Some image adding options are missing!");
    	
    }
     
    @Test (priority = 14)
    //verify the arrow before working as expected
    public void checkPreviousArrowFunction()  {
    	flashCardMaker.toDoBefore();
    	int beforeP=flashCardMaker.getCardNumber();
    	flashCardMaker.pArrowClick();
    	int afterP=flashCardMaker.getCardNumber();
    	
     Assert.assertEquals(afterP, beforeP-1);
    }
    
     @Test(priority = 15)
    //verify the arrow next working as expected
    public void checkNextArrowFunction() {
    	
    	int beforeN=flashCardMaker.getCardNumber();
    	System.out.println(beforeN);
    	flashCardMaker.NarrowClick();
    	int AfterN=flashCardMaker.getCardNumber();
    	System.out.println(AfterN);
    	
   	Assert.assertEquals(AfterN, beforeN+1);
    }

    
    @Test(priority = 16)
    //verify that when click on the delete icon above , a waning message is displayed
     public void deletemessageDisplaying() {
 	  
	   flashCardMaker.deleteIconClick();
	   boolean Wmessage= flashCardMaker.getDeleteWarnngMessage().contains("Are you sure you want to delete this card?");
	   
   Assert.assertTrue(Wmessage, "No warning message is displayed");
	   
	   flashCardMaker.clickCancel();   
   }
    
    @Test(priority = 17 )
   //verify that after click "delete card text link " the card is deleted
   public void deleteCardfunction() {
	   int beforeDelete= flashCardMaker.getTotalCardNum();
	  System.err.println(beforeDelete); 
	  flashCardMaker.deleteIconClick();
	  flashCardMaker.clickDeleteTextLink();
	   int afterDelete= flashCardMaker.getTotalCardNum();
	  System.err.println(afterDelete);  
   Assert.assertEquals(afterDelete, beforeDelete -1);
  } 
    
    
     @Test(priority = 18 )
    //Verify that click on X icon will navigate you to displaying the flash card maker page
     public void checkingXbuttonFunction() throws InterruptedException {
    	 flashCardMaker.clickX();
    	 Thread.sleep(5000);
     Assert.assertTrue( flashCardMaker.displayPageTit() , "the X icon is not functioning");
     }
     
     @Test(priority = 19)
    //Verify that adding a very long stack title is not acceptable                                   (BUG)
     public void addLongStackName() {
    	 flashCardMaker.plusClick();
    	 flashCardMaker.clickStackNFie();
    	 flashCardMaker.sendKeysStackName("abcdefbbbbbbbbbbbbbbbbbbbbbbbbbbbnzcjfidsughhvuxhvjcxvbndfbgufdhbvudfbvuifbv"
    	 		+ "bkjfbkjfinikcvbncvknbcvkbnnnnnnnnnncvkkbnvcbnfcbkcbbifjdbiofdjgifbbbbbbbbbbbfbbfbfdfjgfdjgifjgifjgiofd"
    	 		+ "fddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddbfbfbjgfoigjfoigjfiogj");
    	 flashCardMaker.clickCreateStack();
    	
    	String titleS= flashCardMaker.StackTitleNextPage().trim();
    	boolean coditionTitle=titleS.contains("abcdefbbb");
    	
     Assert.assertFalse(coditionTitle, "Its bug the stack name should not excedds ");
        }
     
    

     @Test(priority = 20)
   //Verify that the user can hover to the gallary of the phone when click on image from gallary text link
   public void addingGalleryimage() throws InterruptedException   {
    	flashCardMaker.imageQclick();
        flashCardMaker.clickImaFroGalla();
        flashCardMaker.gallaryClick();

     System.out.println(driver.currentActivity());
     boolean gallaryOpen= driver.currentActivity().contains("GalleryExternalActivity");
   	
    Assert.assertTrue(gallaryOpen, "The Gallary is Not Opened");
    Thread.sleep(2000);
    driver.pressKey(new KeyEvent(AndroidKey.BACK));
   }
 

    
    }


    
    
