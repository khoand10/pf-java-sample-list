public class ArrayListImpl<T> extends Object implements List<T> {

    private T[] array;
    private int currPos;

    public ArrayListImpl(int initSize) {
        array = (T[]) new Object[initSize];
        currPos = 0;
    }

    @Override
    public int size() { return currPos; }


    @Override
    public void clear() {
        array = (T[]) new Object[array.length];
        currPos = 0;
    }


    @Override
    public boolean add(T obj) {
        checkFull();
        array[currPos] = obj;
        currPos++;
        return true;
    }

    public void add(T[] array) {
        for(T sel : array) add(sel);
    }

    @Override
    public boolean remove(T obj) {
        for(int i = 0; i < currPos; i++) {
            if(array[i].equals(obj)) {
                for(int a = i; a < currPos; a++) {
                    array[a] = array[a+1];
                }
                currPos--;
                return true;
            }
        }
        return false;
    }


    @Override
    public T removeAt(int pos) {
        if(pos >= array.length) {
            throw new RuntimeException("error" + pos + ">" + array.length);
        } else {
            T Val = array[pos];
            while(pos < currPos) {
                array[pos] = array[pos +1];
            }
            currPos --;
            return Val;
        }
    }


    @Override
    public T get(int pos) {
        if(pos >= currPos  ) {
            throw new RuntimeException("Cannot continue, pos is greater than currPos = " + currPos);
        }
        return array[pos];
    }


    @Override
    public void set(int pos, T obj) {
        if(pos >= array.length) {
            System.out.println("pos >=" + array.length);
        } else if (pos > currPos) {
            System.out.println("can't set ");
        } else if(pos < currPos) {
            array[pos] = obj;
        }
    }


    @Override
    public int findPos(T obj) {
        for(int pos = 0; pos < currPos; pos ++ ) {
            if(array[pos].equals(obj)) {
                return pos;
            }
        }
        return -1;
    }

    private void checkFull() {
        if(currPos == array.length ) {
            if(array.length < 3) {
                T[] newArray = (T[]) new Object [array.length + array.length];
            }
            T[] newArray = (T[]) new Object [array.length + array.length/3];
            for(int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }
}
