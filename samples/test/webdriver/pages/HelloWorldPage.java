package webdriver.pages;


import litmus.webdriver.Page;
import litmus.webdriver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HelloWorldPage extends Page<HelloWorldPage> {

    public HelloWorldPage() {
        super(HelloWorldPage.class, "/html/helloworld");
    }

    @Override
    protected boolean arrivedAt() {
        return WebDriverFactory.getWebdriver().getTitle().equals("HelloWorld");
    }

    public HelloWorldPage enterName(String name) {
        WebElement element = WebDriverFactory.getWebdriver().findElement(By.id("name"));
        element.sendKeys(name);
        return this;
    }

    public SayHelloPage clickSubmit() {
        submit();
        return new SayHelloPage();
    }

    private void submit() {
        WebElement element = WebDriverFactory.getWebdriver().findElement(By.id("submit"));
        element.click();
    }

    public HelloWorldPage clickSubmitAndExpectValidationErrors() {
        submit();
        return new HelloWorldPage().assertArrivedAt();
    }

    public String getErrorMessage() {
        return WebDriverFactory.getWebdriver().findElement(By.className("error")).getText();
    }
}
