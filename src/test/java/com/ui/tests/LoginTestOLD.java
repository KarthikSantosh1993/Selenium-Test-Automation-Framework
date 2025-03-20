//
//public class LoginTestOLD {
//
//	public static void main(String[] args) {
//	
//		WebDriver driver = new ChromeDriver();
//		BrowserUtility browserUtility = new BrowserUtility(driver);
//
//		browserUtility.maximizeWindow();
//		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");  
//		
//		By signInLinkLocator= By.xpath("//a[contains(text(),\"Sign in\")]"); 
//		WebElement signInLinkelement = driver.findElement(signInLinkLocator); 
//		signInLinkelement.click();
//		
//		By emailTextboxLocator= By.id("email");
//		WebElement emailTextboxElement = driver.findElement(emailTextboxLocator); 
//		emailTextboxElement.sendKeys("email");
//	
//		By passwordTextboxLocator= By.id("passwd");
//		WebElement passwordTextboxElement = driver.findElement(passwordTextboxLocator); 
//		passwordTextboxElement.sendKeys("password");
//		
//		By submitLoginButtonLocator= By.id("SubmitLogin");
//		WebElement submitLoginButtonElement = driver.findElement(submitLoginButtonLocator); 
//		submitLoginButtonElement.click();
//		browserUtility.clickOn(submitLoginButtonLocator);
//	}
//
//}



