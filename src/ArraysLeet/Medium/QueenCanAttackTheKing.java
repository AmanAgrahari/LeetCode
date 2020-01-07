package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

public class QueenCanAttackTheKing {
    public static void main(String[] args) {

        int queen[][] = {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        System.out.println(queen.length);
        int king [] = {3,4};
        System.out.println(queensAttacktheKing(queen,king));
    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> out = new ArrayList<>();
        int[] r_dir = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] c_dir = {0, 0, 1, -1, 1, -1, -1, 1};

        boolean[][] board = new boolean[8][8];
        for(int i = 0; i < queens.length; i++) {
            board[queens[i][0]][queens[i][1]] = true;
        }
        for(int i = 0; i < 8; i++) {
            int r = king[0] + r_dir[i], c = king[1] + c_dir[i];
            while(r >= 0 && r < 8 && c >= 0 && c < 8) {
                if(board[r][c]) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(r);
                    temp.add(c);
                    out.add(temp);
                    break;
                }
                r = r + r_dir[i];
                c = c + c_dir[i];
            }
        }
        return out;
    }
}
