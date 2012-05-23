package litmus.webdriver;

import org.fest.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Page<T extends Page> {

    private final T self;
    private final String relativeUrl;

    public Page(Class<T> ownClass, String relativeUrl) {
        this.self = ownClass.cast(this);
        this.relativeUrl = relativeUrl;
    }

    public T open() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:9000/html/helloworld");
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("cheese");
        name.submit();
        String msg = driver.findElement(By.id("msg")).getText();
        Assertions.assertThat(msg).isEqualTo("Hello cheese!");
        driver.quit();
        return self;
    }


}
