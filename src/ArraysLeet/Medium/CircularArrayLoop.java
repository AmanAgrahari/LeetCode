package ArraysLeet.Medium;

public class CircularArrayLoop {
    public static void main(String[] args) {
    int arr[] ={-2,-3,-9};
    System.out.print(circularArrayLoop(arr));
    }

    /*
    type = 1 +ve, 0 -ve
     */
    static boolean dfs(int i, int[] nums, int[] visited, final int color, final int type) {
        if((type == 1 && nums[i] < 0) || (type == 0 && nums[i] > 0)) {
            return false;
        }
        visited[i] = color;
        int sz = nums.length;
        int nextIndex;
        if(nums[i] > 0) {
           nextIndex = (i + nums[i]) % sz;
        } else {
           nextIndex = (i - (Math.abs(nums[i]) % sz) + sz) % sz;
        }
        if(visited[nextIndex] == -1) {
            return dfs(nextIndex, nums, visited, color, type);
        } else {
            return  (visited[nextIndex] == color  &&  i != nextIndex);
        }
    }
    public static boolean circularArrayLoop(int[] nums) {
        int visited [] = new int[nums.length];
        int i;
        for(i = 0 ; i < nums.length; i++){
            visited[i] = -1;
        }
        int color = 1;
        for(i = 0 ; i < nums.length; i++){
            if(visited[i] == -1){
               if(dfs(i, nums, visited, color++, nums[i] < 0 ? 0 : 1)) {
                   return true;
               }
            }
        }
        return false;
    }
}
