public class TryingMap {

    public int size;
    MapNode[] table  ;


    public TryingMap(){
        table = new MapNode[10];
    }

    public int put(Object k, Integer v){
        int hash = k.hashCode()%10;
        if(table[hash] == null){
            table[hash] = new MapNode(hash,k,v);
        }
        else{
            MapNode temp = table[hash];
            while(temp != null){
                if(temp.key.equals(k)){
                    int val = temp.value;
                    temp.value = v;
                    this.size++;
                    return val;
                }else if(temp.next == null){
                    temp.next = new MapNode(hash,k,v);
                    this.size++;
                    return v;
                }
                temp = temp.next;
            }

        }
        this.size++;
        return v;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.size ==0;
    }

    public boolean containsKey(Object k){
        int hash = k.hashCode()%10;
        if(size() ==0 || table[hash] == null){
            return false;
        }else{
            MapNode temp = table[hash];
            while(temp != null){
                if(temp.key.equals(k)){
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public int get(Object k){
        int hash = k.hashCode()%10;
        if(size() ==0 || table[hash] == null){
            return 0;
        }else{
            MapNode temp = table[hash];
            while(temp != null){
                if(temp.key.equals(k)){
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return 0;
    }

    public int remove(Object k){
        int hash = k.hashCode()%10;
        if(size() ==0 || table[hash] == null){
            return 0;
        }else{
            MapNode temp = table[hash];
            while(temp != null){
                if(temp.key.equals(k)){
                    int val = temp.value;
                    temp = temp.next;
                    size--;
                    return val;
                }
                temp = temp.next;
            }
        }
        return 0;
    }

}


class MapNode{
    public int hash;
    public Object key;
    public int value;

    public MapNode next;
    public MapNode(int hash, Object key,int value){
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Object getKey(){return key;}

    public int getValue(){return value;}

    public int setValue(int val){
        int old = this.value;
        this.value = val;
        return old;
    }

}
