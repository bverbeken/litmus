package litmus.webdriver;

import org.fest.assertions.Assertions;
import org.openqa.selenium.WebDriver;

import static litmus.webdriver.WebDriverFactory.getWebdriver;
import static org.openqa.selenium.support.PageFactory.initElements;

@SuppressWarnings("unchecked")
public abstract class Page<T extends Page> {

    private final String relativeUrl;
    protected WebDriver driver;

    public Page(String relativeUrl) {
        this.relativeUrl = relativeUrl;
        this.driver = WebDriverFactory.getWebdriver();
        initElements(driver, this);
    }

    public T open() {
        WebDriver driver = getWebdriver();
        driver.get("http://localhost:9000" + relativeUrl); // TODO: detect the localhost:9000 part
        return assertArrivedAt();
    }

    protected abstract boolean arrivedAt();

    protected String getTitle(){
        return driver.getTitle();
    }

    public T assertArrivedAt() {
        Assertions.assertThat(arrivedAt()).isTrue();
        return (T) this;
    }


}
