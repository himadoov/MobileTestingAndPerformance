package learningTools.QA;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class FlashCardMethodsTest extends LearningToolsTestBase{
	
	private FlashCardMethods flashCardMethod;

	//locators
	By flashCardBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Flashcard Maker\")");
	By firstFC = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/stack_name\")");
	By FCMTitle = AppiumBy.id("com.varsitytutors.learningtools:id/action_bar_title");
	By practiceBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Practice\")");
	By flipBtn = AppiumBy.id("com.varsitytutors.learningtools:id/flashcard_flip");
	By backBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Navigate up\")");
	By editBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Edit Flashcards\")");
	By questionField = AppiumBy.id("com.varsitytutors.learningtools:id/question_text");
	By answerField = AppiumBy.id("com.varsitytutors.learningtools:id/answer_text");
	By saveBtn = AppiumBy.id("com.varsitytutors.learningtools:id/flashcard_save");
	By exitBtn = AppiumBy.id("com.varsitytutors.learningtools:id/exit");
	By renameBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Rename Stack\")");
	By FC1Title = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.varsitytutors.learningtools:id/action_bar_title\")");
	By renameField = AppiumBy.androidUIAutomator("new UiSelector().text(\"appium\")");
	By renameFieldBtn = AppiumBy.id("android:id/button1");
	
	@BeforeTest
	public void TestSetup() throws MalformedURLException {
		flashCardMethod = new FlashCardMethods(driver);
	}
	@Test
    public void FlashCardMakerTest() throws InterruptedException {
		
		//Flash Card Maker Page
		Thread.sleep(5000);
		flashCardMethod.clickMethod(flashCardBtn);
		Assert.assertTrue(flashCardMethod.IsDisplayed(FCMTitle),"You are not directed to the correct page");
		
		//practice
		flashCardMethod.clickMethod(firstFC);
		flashCardMethod.clickMethod(practiceBtn);
		Assert.assertTrue(flashCardMethod.IsDisplayed(FC1Title), "You are not directed to the correct page");
		flashCardMethod.clickMethod(flipBtn);
		flashCardMethod.clickMethod(backBtn);
		Assert.assertTrue(flashCardMethod.IsDisplayed(FCMTitle),"You are not directed to the correct page");
		
		//edit flash cards
		flashCardMethod.clickMethod(firstFC);
		flashCardMethod.clickMethod(editBtn);
		flashCardMethod.sendKeysMethod(questionField, "what is Appium used for??");
		Assert.assertEquals(flashCardMethod.getTextMethod(questionField), "what is Appium used for??", "The question field has not filled successfully");
		flashCardMethod.sendKeysMethod(answerField, "Mobile Automation Testing");
		Assert.assertEquals(flashCardMethod.getTextMethod(answerField), "Mobile Automation Testing", "The answer field has not filled successfully");
		flashCardMethod.clickMethod(saveBtn);
		flashCardMethod.clickMethod(exitBtn);
		Assert.assertTrue(flashCardMethod.IsDisplayed(FCMTitle),"You are not directed to the correct page");
		
		//rename stack
		flashCardMethod.clickMethod(firstFC);
		flashCardMethod.clickMethod(renameBtn);
		flashCardMethod.switchToAlertMethod("Appium Stack");
		Assert.assertEquals(flashCardMethod.getTextMethod(renameField), "Appium Stack", "The rename field has not filled successfully");
		flashCardMethod.clickMethod(renameFieldBtn);
		
		
	}
}
 