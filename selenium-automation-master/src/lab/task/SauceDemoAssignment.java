package lab.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class SauceDemoAssignment {
	WebDriver driver;
	String url = "https://www.saucedemo.com/";
	 
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","/home/arnob/selenium_setup/chromedriver_linux64/chromedriver");
		 
		driver = new ChromeDriver();
		 
		driver.get(url);
	}
	
	private void login() {
        WebElement user = driver.findElement(By.id("user-name"));
        user.sendKeys("standard_user");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        System.out.println("Login successful");
	}
	
	private void addProductsToCart() throws InterruptedException {		
		WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(@id, 'add-to-cart-sauce-labs-backpack')]"));
        System.out.println(addToCartButton.getText());
        addToCartButton.click();
        addToCartButton = driver.findElement(By.xpath("//button[contains(@id, 'add-to-cart-sauce-labs-fleece-jacket')]"));
        addToCartButton.click();
        System.out.println("Products added");
        Thread.sleep(3000);
	}
	
	private void goToInfoPage() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_container"));
        cartIcon.click();
        System.out.println("Going to the cart");
         WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(),'Checkout')]"));
        checkoutButton.click();
        System.out.println("Checkout to the next page");
 
	}
	
	private void fillAndSubmitForm() {
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("Shahriar");
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Habib");
        WebElement zipField = driver.findElement(By.id("postal-code"));
        zipField.sendKeys("123456");
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        System.out.println("Fill the form");
        
        WebElement finishButton = driver.findElement(By.xpath("//button[contains(text(),'Finish')]"));
        finishButton.click();
        System.out.println("finish");
	}
	 
	@Test
	public void test() throws InterruptedException {
		login();
		addProductsToCart();
		goToInfoPage();
		fillAndSubmitForm();
    }
	 
	@After
	public void tearDown() {
		driver.close();
	}

}
