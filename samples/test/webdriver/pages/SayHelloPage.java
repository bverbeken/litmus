package webdriver.pages;

import litmus.webdriver.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SayHelloPage extends Page<SayHelloPage> {

    @FindBy(id = "msg")
    public WebElement message;

    @Override
    protected boolean arrivedAt() {
        return getTitle().equals("SayHello");
    }

}
