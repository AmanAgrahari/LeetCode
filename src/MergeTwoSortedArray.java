
public class MergeTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,0,0,0};
		int arr1[] = {2,5,6};
		merge(arr, 3, arr1, 3);
	}

	
public static void merge(int[] nums1, int m, int[] nums2, int n) {
	  int i = m-1;
      int j = n-1;
      int k = m+n-1;

      while(i >=0 && j >= 0){
    	  nums1[k--] = nums1[i] > nums2[j] ? nums1[i--]:nums2[j--];
      }

      while(j >= 0) {
    	  nums1[j]= nums2[j--];
      }	
      for(int ii = 0; ii< nums1.length; ii++)
    	  System.out.println(nums1[ii]);
    }
}
