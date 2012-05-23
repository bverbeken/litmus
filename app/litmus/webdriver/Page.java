package litmus.webdriver;

import litmus.functional.Request;

public abstract class Page<T extends Page> {

    private final T self;
    private final String relativeUrl;

    public Page(Class<T> ownClass, String relativeUrl) {
        this.self = ownClass.cast(this);
        this.relativeUrl = relativeUrl;
    }

    public T open() {
        System.out.println(new Request(relativeUrl).get().getHtml().getSource());
        // TODO: add webdriver dependency
        return self;
    }


}
