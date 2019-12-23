package Byju;

import java.util.Scanner;

public class Tournament {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			String A = sc.next();
			String B = sc.next();
			
			int count[] = new int[26];
			for(int i = 0; i < n; i++) {
				int d = A.charAt(i) - 'a';
				count[d]++;
			}
			int res = 0;
			for(int i = 0; i < n; i++) {
				int d = B.charAt(i) - 'a';
				if(count[d] >= 1) {
					count[d]--;	
					res++;
				}
			}
			System.out.println(res);
		}
	}
}


