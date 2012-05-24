package litmus.webdriver;

import org.fest.assertions.Assertions;
import org.openqa.selenium.WebDriver;

import static litmus.webdriver.WebDriverFactory.getWebdriver;

public abstract class Page<T extends Page> {

    private final T self;
    private final String relativeUrl;

    public Page(Class<T> ownClass, String relativeUrl) {
        this.self = ownClass.cast(this);
        this.relativeUrl = relativeUrl;
    }

    public T open() {
        WebDriver driver = getWebdriver();
        driver.get("http://localhost:9000" + relativeUrl); // TODO: detect the localhost:9000 part
        return assertArrivedAt();
    }

    protected abstract boolean arrivedAt();


    public T assertArrivedAt() {
        Assertions.assertThat(arrivedAt()).isTrue();
        return self;
    }


}
