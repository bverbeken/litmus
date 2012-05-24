package webdriver.pages;


import litmus.webdriver.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelloWorldPage extends Page<HelloWorldPage> {

    @FindBy(id="name")
    public WebElement nameInput;

    @FindBy(id="submit")
    public WebElement submit;

    @FindBy(className = "error")
    public WebElement error;

    public HelloWorldPage() {
        super("/html/helloworld");
    }

    @Override
    protected boolean arrivedAt() {
        return getTitle().equals("HelloWorld");
    }

    public HelloWorldPage enterName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public SayHelloPage clickSubmit() {
        submit.click();
        return new SayHelloPage();
    }

    public HelloWorldPage clickSubmitAndExpectValidationErrors() {
        submit.click();
        return new HelloWorldPage().assertArrivedAt();
    }

}
