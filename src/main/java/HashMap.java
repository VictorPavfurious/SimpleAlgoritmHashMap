public class HashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTORY = 0.75f;
    private Integer keys[] = new Integer[DEFAULT_CAPACITY];
    private long values[] = new long[DEFAULT_CAPACITY];
    private int size = 0;

    public void put(int key, long value) {
        if (size > keys.length * LOAD_FACTORY) {
            increaseSize();
        }

        insertKeyAndValue(key, value);
    }

    private void increaseSize() {
        int newCapacity = keys.length * 2;
        Integer[] newKeys = new Integer[newCapacity];
        long[] newValues = new long[newCapacity];
        carryKeys(newKeys);
        carryValues(newValues);
    }

    private void carryValues(long[] newValues) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                int newPosition = keys[i] & (newValues.length);
                newValues[newPosition] = values[i];
                values = newValues;
            }
        }
    }

    public long get(int key) {
        int position = searchPositionKey(key);
        return values[position];
    }

    private int searchPositionKey(int key) {
        int position = lookPosition(key);
        return keys[position];
    }

    private int lookPosition(int key) {
        return key & (keys.length - 1);
    }

    public int getSize() {
        return size;
    }

    private void carryKeys(Integer[] newKeys) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                int newPosition = keys[i] & (newKeys.length);
                newKeys[newPosition] = keys[i];
                keys = newKeys;
            }
        }
    }

    private void insertKeyAndValue(int key, long value) {
        int position = key & (DEFAULT_CAPACITY - 1);
        while (isPositionBusy(position, key)) {
            position++;
        }

        keys[position] = key;
        values[position] = value;
        size++;
    }

    private boolean isPositionBusy(int position, int key) {
        if (keys[position] != null && keys[position] != key) {
            return true;
        }
        return false;
    }
}
