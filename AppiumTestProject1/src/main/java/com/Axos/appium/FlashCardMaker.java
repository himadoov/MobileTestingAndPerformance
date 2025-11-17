package com.Axos.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlashCardMaker {
	private AndroidDriver driver;
	private WebDriverWait wait;


public FlashCardMaker(AndroidDriver driver) {
	this.driver=driver;
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

//Locators
	//flash card maker button
	private By FlashCm =          AppiumBy.androidUIAutomator("new UiSelector().text(\"Flashcard Maker\")");

	//page title (FlashCard Maker title)
	private By FlashCmTitle =     AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/action_bar_title\")");
	

	private By plusIcon =         AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/fab_add_stack\")");
	
	//popUp adding 
	private By PopUp =            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/alertTitle\")");
	 
	//click"Create Stack"
	private By createStack =      AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")");
	
	//reject message locator
	private By rejectMassege =    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/wrap_text\")");
	
	// close button
	private By closeButt =        AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")");
	
    // cancel button locator
	private By cancelButt =       AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button2\")");
	
	//Stack name field
	private By stackFiel =        AppiumBy.androidUIAutomator("new UiSelector().text(\"Stack Name\")");
	//Stack name field / Class name Locator
	private By stackField =       AppiumBy.className("android.widget.EditText");
			
	//flash card fill page
	private By fillPage =         AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/action_bar_subtitle\")");
	
	//flash Card question
	private By questionField =    AppiumBy.id("com.varsitytutors.learningtools:id/question_text");
	
	//flash card Answer
	private By answerField =      AppiumBy.id("com.varsitytutors.learningtools:id/answer_text");
	
	//The  save icon  
	private By saveCardIcon =     AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/flashcard_add\")");
	

	//The rejection message for adding a blank cart
	private By rejectEmptyAdd  =  AppiumBy.id("com.varsitytutors.learningtools:id/wrap_text");
	
	//Clicking Continue Editing
	private By contiEdit =        AppiumBy .androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")");
	
	//question image
	private By imageQ =           AppiumBy .androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/question_image\")");

	// image adding choice list
	private By imageList =        AppiumBy .className("android.widget.TextView");
	
	//delete icon
	private By deleteIcon =       AppiumBy .androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/flashcard_delete\")");
	
	// delete message
	private By deleteMessage =    AppiumBy.id("com.varsitytutors.learningtools:id/wrap_text");
	
	//arrow left previous
	private By arrowPre  =        AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/flashcard_prev\")");
	
	//arrow right next
	private By arrowNext =        AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/flashcard_next\")");
	
	//Undo Add
	private By undoAdd =          AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button2\")");
	
	//delete Card text link
	private By deleteTextLink =   AppiumBy.androidUIAutomator("new UiSelector().text(\"DELETE CARD\")");
	
	// X icon
	private By xIcon         =    AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/exit\")");

	//image from gallary
	private By imaFroGall =     AppiumBy.androidUIAutomator("new UiSelector().text(\"Image from Gallery\")");
	
	// gallary
	private By gallaryIm =     AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/icon\").instance(0)");
	
//Methods
   //click flashCard maker
	public void FlashCardMakerclickMethod() {
		driver.findElement(FlashCm).click();
	}
	
   // FlashCardMaker title is displayed
	public boolean displayPageTit() {
		return driver.findElement(FlashCmTitle).isDisplayed();
	}
	
   // click + icon
	public void plusClick() {
		driver.findElement(plusIcon).click();
	}
	
	// popUp adding is displayed
	public boolean popAddingDisplaying() {
		return driver.findElement(PopUp).isDisplayed();
	}

	//click Create Stack button
	public void clickCreateStack() {
		driver.findElement(createStack).click();
	}
	
	//rejectedMessage is displayed
	public boolean rejectionMess() {
		return driver.findElement(rejectMassege).isDisplayed();
	}
	//click close button on New Stack Name popUp
	public void clickClose() {
		driver.findElement(closeButt).click();
	
	}
	
	//click Cancel
	public void clickCancel() {
		driver.findElement(cancelButt).click();
	}

	//StackName field click
	public void clickStackNFie() {
		WebElement sF= wait.until(ExpectedConditions.visibilityOfElementLocated(stackFiel));
		sF.click();
	}
	
	//StackName sendKeys
	public void sendKeysStackName(String text) {
		WebElement sN=wait.until(ExpectedConditions.visibilityOfElementLocated(stackFiel));
		sN.sendKeys(text);
	}

	
	//get the title of the added stack
	public String StackTitleNextPage() {
		
		WebElement fillPageText= wait.until(ExpectedConditions.visibilityOfElementLocated(fillPage));
		return fillPageText.getText();
	}
	
	//get the written text back
	public String getTexOfFieldBack() {
	    WebElement getBackTxt = driver.findElement(stackField);
	    if(getBackTxt.isDisplayed() && getBackTxt.isEnabled())
	    {return getBackTxt.getAttribute("text");
	    }else{
	    	return "";
	    }
	  
	}
	
	//Click on the question field
	public void clickQfield() {
		driver.findElement(questionField).click();
	}
	//send keys on the question field
	public void sendKeysQ(String text) {
		driver.findElement(questionField).sendKeys(text);
	}

   // the question field is audible
	public String audiQuesFie() {
		WebElement qFaudibility=driver.findElement(questionField);
		if(qFaudibility.isDisplayed()
		&& qFaudibility.isEnabled() 
		&& qFaudibility.getAttribute("clickable").equals("true")
		&& qFaudibility.getAttribute("focusable").equals("true")) {
	 return  qFaudibility.getAttribute("text");
	} else {
		 return"";
	 }
	}
		
	
 	//Click on the Answer field
	 public void clickAfield() {
			driver.findElement(answerField).click();
		}
  	 //send keys on the Answer field
		public void sendKeysA(String text) {
			driver.findElement(answerField).sendKeys(text);
		}

      // the Answer field is audible
		public String audiAnswerFie() {
			WebElement AFaudibility=driver.findElement(answerField);
			if(AFaudibility.isDisplayed()
			&& AFaudibility.isEnabled() 
			&& AFaudibility.getAttribute("clickable").equals("true")
			&& AFaudibility.getAttribute("focusable").equals("true")) {
		 return  AFaudibility.getAttribute("text");
		} else {
			 return"";
		}
	    	}
		
	  // click save + icon to save question and answer FlashCard
			public void clickSavePlusIcon() {
				driver.findElement(saveCardIcon).click();
				
			}
	
	  // to get the rejection adding an empty card
			public String getRejectMessEmptyAdd() {
			return	driver.findElement(rejectEmptyAdd).getAttribute("text");
			
				 
			}
	 // to click"continue editing"
			public void clickConEditiing() {
				
				WebElement conE=wait.until(ExpectedConditions.visibilityOfElementLocated(contiEdit));
				conE.click();
			}
		
	 // to verify the page displaying after click continue editing
			public boolean pageIsDisplayed() {
			return driver.findElement(questionField).isDisplayed();
			
			}
	

	 // to click on imageQ
			public void imageQclick() {
				driver.findElement(imageQ).click();
			}
			
			
	// to get image list
			public boolean getImageList() {
			
				List<WebElement>options= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imageList));
				
				boolean ImageFromGallery=false  ;
				boolean ImageFromCamera =false  ;
				
			for(WebElement option:options) {
			String text=	option.getText().trim();
			if(text.equals("Image from Gallery")) {
				ImageFromGallery=true;
			}
			if(text.equals("Image from Camera")) {
				ImageFromCamera =true;
			}
			
		}
		    
			return ImageFromGallery && ImageFromCamera;
			}
			
			
	// to click delete
			public void deleteIconClick() {
			  
			   driver.findElement(deleteIcon).click();
					
			}
			
	// warning delete message
			public String getDeleteWarnngMessage() {
				
				WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(deleteMessage));
				
				return element.getText();		
				
			}
			
	// click on arrow Pre
		    public void pArrowClick() {
		    	driver.findElement(arrowPre).click();
		   
		    }
		    
	//click on arrow Next
		    public void NarrowClick() {
		    	driver.findElement(arrowNext).click();
		    	
		    }
   // Undo Add Click
		    public void undoAddClick() {
		    	driver.findElement(undoAdd).click();
		    }
		    
    // initializing for arrow
		    public void toDoBefore() {
		    	driver.navigate().back();
		    	driver.findElement(arrowPre).click();
		    	driver.findElement(undoAdd).click();
		    }
			
   // To get the card number
		    public int getCardNumber() {
		    	String numberCard=StackTitleNextPage().split(" ")[1];
		    	return Integer.parseInt(numberCard.trim());
		    }
		   
   // to get the total number of cards
		    public int getTotalCardNum() {
		    String totalCardNum =	StackTitleNextPage().split(" ")[3];
		    return Integer.parseInt(totalCardNum.trim());
		    	
		    }
  // to click delete text link
		    public void clickDeleteTextLink() {
		    	
		    WebElement deleting=wait.until(ExpectedConditions.visibilityOfElementLocated(deleteTextLink));
		    deleting.click();
		    
		    }
		    
	// to click X
		    public void clickX() {
		    	driver.findElement(xIcon).click();
		    }
		    
   // to click image from gallary
		    public void clickImaFroGalla() {
		    	WebElement clImC=wait.until(ExpectedConditions.visibilityOfElementLocated(imaFroGall));
		    	clImC.click();	
		    }
	
	// to click the gallary
		    
		    public void gallaryClick() {
		    	WebElement gal=wait.until(ExpectedConditions.visibilityOfElementLocated(gallaryIm));
		    	gal.click();
		    	
		   
		    }
		    
		    
}
    
    
    
	



