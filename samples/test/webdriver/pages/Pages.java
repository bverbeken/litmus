package webdriver.pages;

import static litmus.webdriver.Page.open;

public class Pages {

    public static HelloWorldPage goToHelloWorldPage() {
        open("/html/helloworld");
        return new HelloWorldPage();
    }

    public static SayHelloPage goToSayHelloPage(String name){
        open("/html/sayHello?name=" + name);
        return new SayHelloPage();
    }
}
