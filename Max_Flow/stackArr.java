import java.lang.reflect.Array;

public class stackArr <T>{
    private int X;
    private int currentSize;
    private T[] arrlist;
    private Class aClass;
    private void increase() {
        T[] a = (T[]) Array.newInstance(aClass, 2 * X);
        for (int i = 0; i < currentSize; i++)
        {
            a[i] = arrlist[i];
        }
        X *= 2;
        arrlist = a;
    }

    private void decrease() {
        T[] a = (T[]) Array.newInstance(aClass, X / 2);
        for (int i = 0; i < currentSize; i++) {
            a[i] = arrlist[i];
        }
        X /= 2;
        arrlist = a;
    }

    public stackArr(Class<T> t, int n) {
        X = n;
        aClass = t;
        arrlist = (T[]) Array.newInstance(t, n);
        currentSize = 0;

    }
    public stackArr(Class<T> t, stackArr<T> ar)
    {
        X = ar.X;
        currentSize = 0;
        arrlist = (T[]) Array.newInstance(t,X);
        for(int i = 0;i<ar.currentSize;i++)
        {
            T v = (T) ar.arrlist[i];
            push(v);
        }
    }
    public void push (T item)
    {
        if (currentSize == X)
            increase();
        arrlist[currentSize++] = item;
    }
    public T pop ()
    {
        if(currentSize > 0)
        {
            if(currentSize - 1 < (X/2))
                decrease();
            T t = arrlist[currentSize - 1];
            currentSize--;
            return t;
        }
        return null;
    }
    public int length()
    {
        return currentSize;
    }
    public T topValue()
    {
        return arrlist[currentSize - 1];
    }
    public void clear()
    {
        currentSize = 0;
        T[] a = (T[]) Array.newInstance(aClass, X);
        arrlist = a;
    }
    @Override
    public String toString()
    {
        String s1 = "<|";
        String s2 = "";
        for(int i =0;i< currentSize;i++)
        {
            if(i == currentSize - 1)
                s2 = s2 + "| ";
            s2 = s2 + arrlist[i] + " ";
        }
        return s1 + s2 + ">\n";
    }

}
