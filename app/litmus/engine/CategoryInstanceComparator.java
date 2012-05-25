package litmus.engine;

import java.util.Comparator;

public class CategoryInstanceComparator implements Comparator<CategoryInstance> {

    @Override
    public int compare(CategoryInstance lhs, CategoryInstance rhs) {
        int result = lhs.priority.compareTo(rhs.priority);
        return result == 0 ? lhs.name.compareTo(rhs.name) : result;
    }
}
