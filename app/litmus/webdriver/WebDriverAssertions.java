package litmus.webdriver;

import org.openqa.selenium.WebElement;

public class WebDriverAssertions {

    private WebDriverAssertions() {

    }

    public static WebElementAssert assertThat(WebElement actualWebElement) {
        return new WebElementAssert(actualWebElement);
    }

    public static PageAssert assertThat(Page actualPage){
        return new PageAssert(actualPage);
    }
}
