package amazon;

import org.openqa.selenium.Dimension;
import amazon.StartApp;



public class Actions {
	
	public static void swipeLeft(){
		
		Dimension size = TestBase.driver.manage().window().getSize(); 
		int startx = (int) (size.width * 0.8); 
		int endx = (int) (size.width * 0.20); 
		int starty = size.height / 2; 
		TestBase.driver.swipe(startx, starty, endx, starty, 1000);
	}
	
	public static void swipeRight(){
		Dimension size = TestBase.driver.manage().window().getSize(); 
		int endx = (int) (size.width * 0.8); 
		int startx = (int) (size.width * 0.20); 
		int starty = size.height / 2; 
		TestBase.driver.swipe(startx, starty, endx, starty, 1000);

}
