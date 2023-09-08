package practice;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
	
	public static ArrayList<Integer> removeDuplicates(int a[]){
		
		ArrayList<Integer> output= new ArrayList<Integer>();
		HashMap<Integer, Boolean> seen= new HashMap<>();
		
		for(int i=0; i<a.length; i++) {
			
			if(seen.containsKey(a[i])) {
				continue;
			}else {
				output.add(a[i]);
				seen.put(a[i], true);
			}
		}
		
		return output;
	}

	public static void main(String[] args) {
		
		int a[]= {1,3,2,4,1,2,2,2,10000,3,2};
		
		System.out.println(removeDuplicates(a));
	}

}
