package practice;

public class OurMapUse {
	
	public static void main(String[] args) {
		
		Map<String, Integer> map= new Map<>();
		
		for(int i=0; i<20; i++) {
			map.insert("abc"+i, 1+i);
			System.out.println("i = "+i+" lf = "+ map.loadFactor());
		}
		
		map.removeKey("abc3");
		map.removeKey("abc2");
		
		for(int i=0; i<20; i++) {
			System.out.println("abc"+i+" : "+map.getValue("abc"+i)); 
		}
	}
}
