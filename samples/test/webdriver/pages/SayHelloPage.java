package webdriver.pages;

import litmus.webdriver.Page;
import litmus.webdriver.WebDriverFactory;
import org.openqa.selenium.By;

public class SayHelloPage extends Page<SayHelloPage> {

    public SayHelloPage() {
        super(SayHelloPage.class, "/html/sayhello");
    }

    @Override
    protected boolean arrivedAt() {
        return WebDriverFactory.getWebdriver().getTitle().equals("SayHello");
    }

    public String getMessage() {
        return WebDriverFactory.getWebdriver().findElement(By.id("msg")).getText();
    }

}
