package litmus.webdriver;

import org.openqa.selenium.WebElement;

public class WebDriverAssertions {

    private WebDriverAssertions() {

    }

    public static WebElementAssert assertThat(WebElement actual) {
        return new WebElementAssert(actual);
    }
}
