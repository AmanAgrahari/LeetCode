package ArraysLeet.Medium;

public class DecreaseElementToMakeArrayZigZag {
    public static void main(String[] args) {
        int arr[] = {9,6,1,6,2};
        System.out.println(movesToMakeZigzag(arr));
    }

    public static int movesToMakeZigzag(int[] nums) {
        int i, mid, left, right, even = 0, odd = 0;
        for (i = 0; i < nums.length; i=i+2) {
            mid = nums[i];
            left = get(nums, i - 1);
            right = get(nums, i + 1);
            int low = Math.min(left, right);
            int diff = mid - low;
            if (diff >= 0) {
                even += (diff + 1);
            }
        }

        for (i = 1; i < nums.length; i=i+2) {
            mid = nums[i];
            left = get(nums, i - 1);
            right = get(nums, i + 1);
            int low = Math.min(left, right);
            int diff = mid - low;
            if (diff >= 0) {
                odd += (diff + 1);
            }
        }

        return Math.min(even, odd);
    }

    public static int get(int a[], int i) {
        if (i < 0 || i >= a.length) {
            return 9999999;
        }
        return a[i];
    }

}
