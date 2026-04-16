package com.bst;


//associationn compara k y compra entre dos associationn por su k
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K eng;
    private V es;

    public Association(K eng, V es) {
        this.eng = eng;
        this.es = es;
    }

    @Override
    public int compareTo(Association<K, V> other) { // - menor, 0 igual, + mayor
        return this.eng.compareTo(other.eng);
    }

    @Override
    public String toString() {
        return "(" + eng + ", " + es + ")";
    }

    public K getKey() {
        return eng;
    }

    public V getValue() {
        return es;
    }


}