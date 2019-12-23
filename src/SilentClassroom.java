import java.util.HashMap;
import java.util.Scanner;

public class SilentClassroom {

	public static void main(String[] args) {
	
		
		//"olivia", "jacob", "tanya", "jack", "oliver" , "jessica"
		

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s[] = new String[n];
		
		for(int i = 0 ; i < n ; i++) {
			s[i] = sc.next();
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0 ; i < s.length; i++) {
			String p = s[i];
			map.putIfAbsent(p.charAt(0), 0);
			map.put(p.charAt(0), map.get(p.charAt(0))+1);
		}
		int pair = 0;
		for(Character j: map.keySet()) {
			if(map.get(j) == 1 || map.get(j) == 2) {
				
			} else {
				int p = map.get(j)/2;
				pair = pair+p;
			}
		}
		System.out.println(pair);
	}

}
