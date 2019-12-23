package ArraysLeet;

public class DayOfTheWeek {

    public static void main(String[] args) {

    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[]{ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday","Friday", "Saturday"};
        int[] daysDiffForMonths = new int[]{3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
        daysDiffForMonths[2] = 0;
        if(year%400 == 0){
            daysDiffForMonths[2] = 1;
        } else if(month == 2 && year%4 == 0 && year%100!=0){
            daysDiffForMonths[2] = 1;
        }
        return "";
    }
}
