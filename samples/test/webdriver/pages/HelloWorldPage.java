package webdriver.pages;


import litmus.webdriver.Page;

public class HelloWorldPage extends Page<HelloWorldPage> {

    public HelloWorldPage() {
        super(HelloWorldPage.class, "/html/helloworld");
    }

    public HelloWorldPage enterName(String name) {
        // TODO: use name
        return this;
    }

    public void clickSubmit() {
        // TODO
    }
}
