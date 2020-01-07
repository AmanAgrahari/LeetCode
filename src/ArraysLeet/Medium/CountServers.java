package ArraysLeet.Medium;

public class CountServers {
    public static void main(String[] args) {
        int arr[][] = {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}
        };
        System.out.println(countServers(arr));
    }

    public static int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        int row[] = new int[r];
        int col[] = new int[c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++) {
                if(grid[i][j] > 0 && (row[i] > 1 || col[j] > 1)){
                    count++;
                }
            }
        }
        return count;
    }
}
