package ArraysLeet.Medium;

public class PreviousPermutation {
    public static void main(String[] args) {
        int arr[] = { 4,3,1,2};
        prevPermOpt1(arr);
    }

    public static int[] prevPermOpt1(int[] nums) {
        if(nums == null || nums.length <=1)
            return nums;
        int i;
        int mark = -1;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] < nums[i+1]) {
                mark = i + 1;
                break;
            }
        }
        if (mark == -1) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }

        int j = 0;
        for (i = 0; i <= mark + 1; i++) {
            if (nums[i] < nums[mark]) {
                j = i;
                break;
            }
        }

        swap(nums, mark, j);

        print(nums);
        reverse(nums, 0,mark);
        print(nums);
        return nums;
    }



    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void print(int[] nums){
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
