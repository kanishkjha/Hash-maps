package practice;

import java.util.HashMap;

public class ArrayIntersection {
	
	public static void printIntersection(int[]arr1, int[] arr2) {
		
		HashMap<Integer, Integer> map= new HashMap<>();
		
		for(int i=0; i<arr1.length; i++) {
			if(map.containsKey(arr1[i])) {
				int value=map.get(arr1[i]);
				map.put(arr1[i], value+1);
			}else {
				map.put(arr1[i], 1);
			}
		}
		
		for(int i=0; i<arr2.length; i++) {
			
			if(map.containsKey(arr2[i])) {
				int frequency= map.get(arr2[i]);
				
				if(frequency>0) {
					System.out.print(arr2[i]+" ");
					map.put(arr2[i], frequency-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1= {1,4,5,2,2,3,6,5,3,2};
		int[] arr2= {2,3,2,6,6,5,1};
		
		printIntersection(arr1, arr2);
	}

}
