class Data{
    private int key;
    private long value;

    public Data(int k, long v){
        key = k;
        value = v;
    }

    public int getKey(){
        return key;
    }

    public long getValue(){
        return value;
    }
}

public class EasyHashMap {
    private Data[] hashArray;
    private int count = 0;
    private final int SIZE = 53;
    private final int CONST = 5;

    EasyHashMap(){
        hashArray = new Data[SIZE];
    }

    private int hashFunc(int key){
        return (key % SIZE);
    }

    private int hashFunc2(int key){
        return CONST - (key % CONST);
    }

    private int containsKey(int key){
        int hashKey = hashFunc(key);
        int step = hashFunc2(key);
        while (hashArray[hashKey] != null)
        {
            if (hashArray[hashKey].getKey() == key)
                return hashKey;
            hashKey += step;
            hashKey %= SIZE;
        }
        return -1;
    }

    //when a hash table is filled with more than 70%, elements are not added to it
    private boolean getLoadFactor(){
        return (double)count/(double)SIZE < 0.7;
    }

    public void put(int key, long value){
        if (getLoadFactor()){
            Data data = new Data(key, value);
            int hashKey = hashFunc(key);
            int step = hashFunc2(key);

            int existingKey = containsKey(key);
            if (existingKey != -1){
                hashArray[existingKey] = data;
            } else {
                while (hashArray[hashKey] != null)
                {
                    hashKey += step;
                    hashKey %= SIZE;
                }
                hashArray[hashKey] = data;
                count++;
            }
        } else {
            System.out.println("The hash map is overfull.");
        }
    }

    public Long get(int key){
        int hashKey = hashFunc(key);
        int step = hashFunc2(key);
        while (hashArray[hashKey] != null)
        {
            if (hashArray[hashKey].getKey() == key) {
                return new Long(hashArray[hashKey].getValue());
            }
            hashKey += step;
            hashKey %= SIZE;
        }
        return null;
    }

    public int size(){
        return count;
    }
}
