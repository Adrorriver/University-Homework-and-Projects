/*
 * generic class for keys and values  
 */

import java.util.Iterator;
import java.util.TreeMap;

public class AssociationTable<K extends Comparable<K>, V> {
	private TreeMap<K, V> map;

	public AssociationTable() {
		super();
		map = new TreeMap<K, V>();
	}

	//construct table from keys and values arrays
	public AssociationTable(K[] kArr, V[] vArr) throws IllegalArgumentException {
		super();
		if (!equalSize(kArr, vArr)) {
			throw (new IllegalArgumentException());
		} else {
			map = new TreeMap<K, V>();
			for (int i = 0; i < kArr.length; i++) {
				map.put(kArr[i], vArr[i]);
			}
		}

	}

	private boolean equalSize(K[] kArr, V[] vArr) {
		return (kArr.length == vArr.length);
	}

	public void add(K key, V value) {
		map.put(key, value);
	}

	public V get(K key) {
		return map.get(key);
	}

	public boolean contains(K key) {
		return map.containsKey(key);
	}

	public boolean remove(K key){
		return map.remove(key)!= null;
	}
	
	public int size (){
		return map.size();
	}
	
	public Iterator<K> keyIterator(){
		return map.navigableKeySet().iterator();
	}
	
	public void printTable(){
		Iterator <K> iterator = this.keyIterator();
		while(iterator.hasNext()){
			K key = iterator.next();
			System.out.printf("%n %s , %s",key,this.get(key));
		}
	}
}
