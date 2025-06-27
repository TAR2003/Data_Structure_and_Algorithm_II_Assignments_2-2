import java.lang.reflect.Array;
import java.util.Arrays;

public class arr<T> {
    T t;
    int currentPos;
    int X;
    public int currentSize;
    public Class<T> aClass;
    public T[] arrlist;

    private void increase() {
        T[] a = (T[]) Array.newInstance(aClass, 2 * X);
        for (int i = 0; i < currentSize; i++) {
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

    public arr(Class<T> t, int n) {
        X = n;
        aClass = t;
        arrlist = (T[]) Array.newInstance(t, n);
        currentPos = 0;
        currentSize = 0;

    }

    public arr(Class<T> t, arr<T> ar) {
        X = ar.X;
        currentSize = 0;
        currentPos = 0;
        arrlist = (T[]) Array.newInstance(t, X);
        for (int i = 0; i < ar.currentSize; i++) {
            T v = (T) ar.arrlist[i];
            pushback(v);

        }
        currentPos = ar.currentPos;
    }
    public arr(arr<T> ar) {
        X = ar.X;
        currentSize = 0;
        currentPos = 0;
        aClass = ar.aClass;
        arrlist = (T[]) Array.newInstance(ar.aClass, X);
        for (int i = 0; i < ar.currentSize; i++) {
            T v = (T) ar.arrlist[i];
            pushback(v);

        }
        currentPos = ar.currentPos;
    }

    public void addArr(arr<T> ar)
    {
        for (int i = 0; i < ar.currentSize; i++) {
            T v = (T) ar.arrlist[i];
            pushback(v);

        }
    }



    public int size() {
        return currentSize;
    }

    public void push(T item) {
        if (currentSize >= X)
            increase();

        for (int i = currentSize; i > currentPos; i--) {
            arrlist[i] = arrlist[i - 1];
        }
        arrlist[currentPos] = item;
        currentSize++;

    }

    public void pushback(T item) {
        if (currentSize >= X) {
            increase();
        }
        arrlist[currentSize] = item;

        currentSize++;
    }

    public T erase() {
        if (currentSize > 0) {
            if (currentSize - 1 < (X / 2)) {
                decrease();
            }
            T obj = arrlist[currentPos];
            for (int i = currentPos; i < currentSize - 1; i++) {
                arrlist[i] = arrlist[i + 1];
            }
            currentSize--;
            if (currentPos >= currentSize) {
                currentPos--;
            }
            return obj;
        }
        return null;
    }

    public void setToBegin() {
        currentPos = 0;
    }

    public void setToEnd() {
        currentPos = currentSize - 1;
    }

    public void prev() {
        if (currentPos != 0)
            currentPos--;
    }

    public void next() {
        if (currentPos < (currentSize - 1)) {
            currentPos++;
        }
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setToPos(int pos) {
        if (pos >= 0) {
            currentPos = pos;
        }
    }

    public T getValue() {
        return arrlist[currentPos];
    }

    public int find(T item) {
        for (int i = 0; i < currentSize; i++) {
            if (arrlist[i].equals(item))
                return i;
        }
        return -1;
    }

    public void clear() {
        currentSize = 0;
        currentPos = 0;
        T[] a = (T[]) Array.newInstance(aClass, X);
        arrlist = a;
    }

    public void sortArr() {
        Arrays.sort(arrlist,0,currentSize);
    }



    public arr<T> makeFractionArray (int start, int finish) {
        arr<T> a = new arr<>(aClass,3);
        for(int i = start;i<=finish;i++) {
            T temp = arrlist[i];
            a.pushback(temp);
        }
        return a;
    }

    @Override
    public String toString() {
        String s1 = "<";
        String s2 = "";
        for (int i = 0; i < currentSize; i++) {
            if (i == currentPos)
                s2 = s2 + "| ";
            s2 = s2 + arrlist[i] + " ";
        }
        return s1 + s2 + ">\n";
    }



    public void show() {
        System.out.println(this);
    }


}


