import java.lang.reflect.Array;

public class queueArr <T>
{
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

    public queueArr(Class<T> t, int n) {
        X = n;
        aClass = t;
        arrlist = (T[]) Array.newInstance(t, n);
        currentSize = 0;

    }
    public queueArr(Class<T> t, queueArr<T> ar)
    {
        X = ar.X;
        currentSize = 0;
        arrlist = (T[]) Array.newInstance(t,X);
        for(int i = 0;i<ar.currentSize;i++)
        {
            T v = (T) ar.arrlist[i];
            enqueue(v);

        }
    }
    public void enqueue (T item)
    {
         if (currentSize == X)
            increase();
         arrlist[currentSize++] = item;
    }
    public T dequeue()
    {
        if(currentSize > 0)
        {
            if(currentSize - 1 < (X/2))
                decrease();
            T t = arrlist[0];
            for(int i = 0;i < currentSize - 1;i++)
            {
                arrlist[i] = arrlist[i+1];
            }
            currentSize--;
            return t;
        }
        return null;
    }
    public T leaveQueue()
    {
        if(currentSize > 0) {
            if (currentSize - 1 < (X / 2))
                decrease();
            T t = arrlist[currentSize - 1];
            currentSize--;
            return t;
        }
        return null;
    }
    public T frontValue()
    {
        return arrlist[0];
    }
    public T rearValue()
    {
        return arrlist[currentSize - 1];
    }
    public int length()
    {
        return currentSize;
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
            s2 = s2 + arrlist[i] + " ";
        }
        return s1 + s2 + ">\n";
    }


}
