import java.util.ArrayList;
import java.util.List;

public class AddOfTwoNumbers {

	public static void main(String[] args) {
		 int A[] = {-2,1,-3,4,-1,2,1,-5,4}, K = 806;

		// List<Integer> a = addToArrayForm(A, K);
		 System.out.println(maxSubArray(A));
	}
    public static  int maxSubArray(int[] nums) {
        
        int max_ending_so_far = 0;
        
        int max_so_far = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            max_ending_so_far+=nums[i];
            
            if(max_so_far < max_ending_so_far) {
            	max_so_far = max_ending_so_far;
            } 
            if(max_ending_so_far < 0) {
            	max_ending_so_far = 0;
            }
        }
        
        return max_so_far;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public static List<Integer> addToArrayForm(int[] A, int K) {
		
		String str1 = "";
		for( int i =0; i< A.length; i++) {
			str1+= A[i];
		}
        String str2 = Integer.toString(K);
        if (str1.length() > str2.length()){  
            String t = str1; 
            str1 = str2; 
            str2 = t; 
        } 
        String str = "";  
        int n1 = str1.length(), n2 = str2.length();  
        str1=new StringBuilder(str1).reverse().toString(); 
        str2=new StringBuilder(str2).reverse().toString();
        int carry = 0;  
        for (int i = 0; i < n1; i++)  
        {  
            int sum = ((int)(str1.charAt(i) - '0') +  
                        (int)(str2.charAt(i) - '0') + carry);  
            str += (char)(sum % 10 + '0');  
      
            carry = sum / 10;  
        }  
        for (int i = n1; i < n2; i++)  
        {  
            int sum = ((int)(str2.charAt(i) - '0') + carry);  
            str += (char)(sum % 10 + '0');  
            carry = sum / 10;  
        }  
        
        if (carry > 0)  
            str += (char)(carry + '0');  
        
        str = new StringBuilder(str).reverse().toString(); 
        
        System.out.println(str);
        List<Integer> al = new ArrayList<Integer>();
        for(int i = 0; i< str.length(); i++) {
        	al.add(str.charAt(i) -'0');
        }
        return null;
    }

}
