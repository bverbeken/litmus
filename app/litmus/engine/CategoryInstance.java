package litmus.engine;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class CategoryInstance {

    public static final String UNIT = "Unit Tests";
    public static final String FUNCTIONAL = "Functional Tests";
    public static final CategoryInstance NONE = new CategoryInstance("Uncategorized Tests", 999999);


    public String name;
    public Integer priority;

    public CategoryInstance(Category annotation) {
        this.name = annotation.value();
        this.priority = annotation.priority();
    }

    private CategoryInstance(String name, Integer priority) {
        this.name = name;
        this.priority = priority;
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
