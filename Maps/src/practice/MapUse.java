package practice;

import java.util.HashMap;
import java.util.Set;

public class MapUse {

	public static void main(String[] args) {
		HashMap<String, Integer> map= new HashMap<>();
		
		// Insert
		
		map.put("abc", 1);
		map.put("def", 2);
		map.put("abc1", 1);
		map.put("def1", 2);
		
		// Check presence
		
		if(map.containsKey("abc")) {
			System.out.println("has abc");
		}
		
		if(map.containsKey("abc1")) {
			System.out.println("has abc1");
		}
		
		// Get value
		int v=0;
		
		if(map.containsKey("abc")) {
			v=map.get("abc");
		}
		
		System.out.println(v);
		
		// Remove value
		
		int s=map.remove("abc");
		System.out.println(s);
		
		// Check whether a value is present or not. But it is O(n) not O(1).
		
		if(map.containsValue(2)) {
			System.out.println("has 2");
		}
		
		System.out.println("size: "+map.size());
		
		// This is how we iterate over the map and get key in a data type called Set which we need to import ofcourse. 
		
		Set<String> keys= map.keySet();
		
		for(String str: keys) {
			System.out.println(str);
		}
	}

}
