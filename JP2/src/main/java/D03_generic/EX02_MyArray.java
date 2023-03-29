package D03_generic;

import java.lang.reflect.Array;

public class EX02_MyArray<T> {

    private T[] list;
    int count;

    public EX02_MyArray(Class<T> clazz) {
        this(clazz, 50);
    }

    public EX02_MyArray(Class<T> clazz, int size) {
        list = (T[]) Array.newInstance(clazz, size);
        count = 0;
    }

    public void add(T elem) {
        list[count++] = elem;
    }
}

class subArray extends EX02_MyArray<String> {

    public subArray() {
        super(String.class);
    }
}

class subArray2<T> extends EX02_MyArray<String> {

    public subArray2() {
        super(String.class);
    }
}
