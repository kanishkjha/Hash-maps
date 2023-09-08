package practice;
import java.util.ArrayList;

public class Map<K,V> {
	
	ArrayList<MapNode<K,V>> buckets;
	int size;
	int numBuckets;
	
	
// constructor
	
	public Map() {
		numBuckets=5;
		buckets= new ArrayList<>();
		
		for(int i=0; i<numBuckets; i++) {
			buckets.add(null);
		}
	}
	
// hash function
	
	private int getBucketIndex(K key) {
		
/* Here, Every generic class( Integer, String, Character, etc. ) are somehow inherited from the Object class and Object class has this function built             into it. However, some generics like String and Integer have their own hashCode functions implemented so in their case, they will use their functions. */
		int hashCode=key.hashCode();
		return hashCode%numBuckets;
	}
	
	
// size
	
	public int size(){
		return size;
	}
	
// remove
	
	public V removeKey(K key) {
		
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head= buckets.get(bucketIndex);
		MapNode<K,V> prev= null;
		
		while(head!=null) {
			
			if(head.key.equals(key)) {
				
				size--;
				
				if(prev==null) {
/* This is for the case when the first element is the one that we have to remove, in this case, previous would be null. ( EDGE CASE ) */
					buckets.set(bucketIndex, head.next);
				}else {
/* This is the common case */
					prev.next=head.next;
				}
				return head.value;
			}
			prev=head;
			head=head.next;
		}
/* In case, our LinkedList doesn't contain the provided key */
		return null;
	}

// get value
	
	public V getValue(K key) {
		
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head= buckets.get(bucketIndex);
		
		while(head!=null) {
			
			if(head.key.equals(key)) {
				return head.value;
			}
			head=head.next;
		}
		
		return null;
	}
	
// load factor
	
	public double loadFactor() {
		
		return (1.0*size)/numBuckets;
	}
	
// rehash 
	
	public void rehash() {
		
		System.out.println("rehashing: buckets "+numBuckets+" size "+size());
		
		ArrayList<MapNode<K, V>> temp= buckets;
		buckets= new ArrayList<>();
		
		for(int i=0; i<2*numBuckets; i++) {
			buckets.add(null);
		}
		size=0;
		numBuckets*=2;
		
		for(int i=0; i<temp.size(); i++) {
			MapNode<K, V> head= temp.get(i);
			
			while(head!=null) {
				K key= head.key;
				V value= head.value;
				insert(key, value);
				head=head.next;
			}
		}
	}
	
// insert
	
	public void insert(K key, V value) {
		
		int bucketIndex=getBucketIndex(key);
		MapNode<K,V> head= buckets.get(bucketIndex);
		
		while(head!=null) {
			
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head=head.next;
		}
		
		
/* We are again finding head because in above loop, we have made the head reach to the very end */
		
		head= buckets.get(bucketIndex);
		MapNode<K,V> newElementNode= new MapNode<K,V>(key, value); 
		size++;
		newElementNode.next=head;
		
		buckets.set(bucketIndex, newElementNode);
		
		double loadFactor=(1.0*size)/numBuckets;
		
		if(loadFactor>0.7) {
			rehash();
		}
	}
}
