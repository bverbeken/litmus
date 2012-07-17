package litmus.engine;

import litmus.Category;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class CategoryInstance {

    public static final String UNIT = "Unit Tests";
    public static final String FUNCTIONAL = "Functional Tests";
    public static final String WEBDRIVER = "WebDriver Tests";
    public static final CategoryInstance NONE = new CategoryInstance("Uncategorized Tests", 999999, false);


    public String name;
    public Integer priority;
    public boolean slow;

    public CategoryInstance(Category annotation) {
        this.name = annotation.value();
        this.priority = annotation.priority();
        this.slow = annotation.slow();
    }

    private CategoryInstance(String name, Integer priority, boolean slow) {
        this.name = name;
        this.priority = priority;
        this.slow = slow;
    }

    @Override
    public boolean equals(Object that) {
        return reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    public String toString() {
        return name;
    }

}
