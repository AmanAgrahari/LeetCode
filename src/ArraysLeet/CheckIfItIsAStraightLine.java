package ArraysLeet;

public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {

    }

    public boolean checkStraightLine(int[][] coordinates) {
        double slope = ((double) coordinates[1][1]-(double) coordinates[0][1]) / ((double) coordinates[1][0]-(double) coordinates[0][0]);
        for(int i = 2; i < coordinates.length; i++){
            double sl = ((double) coordinates[i][1]-(double) coordinates[i-1][1]) / ((double) coordinates[i][0]-(double) coordinates[i-1][0]);
            if(sl != slope)
                return false;
        }
        return true;
    }
}
