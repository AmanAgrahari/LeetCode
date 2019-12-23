package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOFLongestSubstringWithourRepeatingCharacter {

	public static void main(String[] args) {

		String str = "dvdf";
		System.out.println(lengthOfLongestSubstring(str));
	}

	public static int lengthOfLongestSubstring(String s) {
		List<Character> list = new ArrayList<>();
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			if(list.contains(s.charAt(i))) {
				max = Math.max(max, list.size());
				int index = list.indexOf(s.charAt(i));
				while(index >= 0) {
					list.remove(index);
					index--;
				}
				list.add(s.charAt(i));
			} else {
				list.add(s.charAt(i));
			}
		}
		return Math.max(max, list.size());
	}
}
