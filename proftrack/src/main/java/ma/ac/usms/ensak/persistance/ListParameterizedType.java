package ma.ac.usms.ensak.persistance;

import java.lang.reflect.Type;

public class ListParameterizedType implements Type {
    private Type type;

    public ListParameterizedType(Type type) {
        this.type = type;
    }

    public Type[] getActualTypeArguments() {
        return new Type[] {type};
    }

    public Type getRawType() {
        return ListParameterizedType.class;
    }
    

}
