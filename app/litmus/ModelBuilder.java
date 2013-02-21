package litmus;

import com.google.common.base.Function;
import play.data.validation.Validation;
import play.db.jpa.GenericModel;

public abstract class ModelBuilder<T extends GenericModel> extends Builder<T> {

    public T save() {
        T model = build();
        if (Validation.current().valid(model).ok) {
            return model.save();
        } else {
            throw new RuntimeException("Invalid object: " + Validation.errors());
        }
    }



}
