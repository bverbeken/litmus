package webdriver.pages;


import litmus.webdriver.Page;
import litmus.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelloWorldPage extends Page<HelloWorldPage> {

    public HelloWorldPage() {
        super(HelloWorldPage.class, "/html/helloworld");
    }

    public HelloWorldPage enterName(String name) {
        WebElement element = WebDriverFactory.getWebdriver().findElement(By.id("name"));
        element.sendKeys(name);
        return this;
    }

    public SayHelloPage clickSubmit() {
        WebElement element = WebDriverFactory.getWebdriver().findElement(By.id("submit"));
        element.click();
        return new SayHelloPage();
    }
}
