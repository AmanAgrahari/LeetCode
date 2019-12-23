package ArraysLeet.Medium;

import java.util.Arrays;
import java.util.Collections;

public class FriendsOfApproriateAges {
    public static void main(String[] args) {

        int arr[] = {6, 6, 15, 26, 30, 35, 39, 46, 60, 71, 73, 100, 106, 110, 112};
        System.out.println(numFriendRequests(arr));

    }

    static void reverse(int a[]) {
        int n = a.length;
        int i, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public static int numFriendRequests(int[] ages) {
        int ageA = 0;
        int ageB = 0;
        int res = 0;
        int i;
        for (i = 0; i < ages.length; i++) {
            ages[i] = ages[i] * 2;
        }
        Arrays.sort(ages);
//        for (i = 0; i < ages.length; ++i) {
//            System.out.print(ages[i] + ",");
//        }
//        System.out.println();
        for (i = ages.length - 1; i > 0; i--) {
            ageA = ages[i];
            ageB = ageA / 2 + 14;
            int lowerBound = lower(ages, ageB, 0, i - 1);
            if (lowerBound != -1) {
              //  System.out.println(ageA / 2 + " " + ageB + " " + (i - lowerBound));
                res += (i - lowerBound);
            }
        }
        for (i = 0; i + 1 < ages.length; ++i) {
            if(ages[i] <= 28) continue;
            ageB = ages[i];
            int lowerBound = last(ages, ageB, i + 1, ages.length - 1);
            //     System.out.println(lowerBound);
            if (lowerBound != -1) {
                res += (lowerBound - i);
            }
        }
        return res;
    }

    public static int lower(int[] ages, int target, int low, int high) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        int left = low;
        int right = high;
        int ans = -1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (ages[m] <= target) {
                left = m + 1;
            } else {
                ans = m;
                right = m - 1;
            }
        }
        return ans;
    }

    public static int last(int[] ages, int target, int low, int high) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        int left = low;
        int right = high;
        int ans = -1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (ages[m] <= target) {
                if (ages[m] == target) {
                    ans = m;
                }
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return ans;
    }
}
