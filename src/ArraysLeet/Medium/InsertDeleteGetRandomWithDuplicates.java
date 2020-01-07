package ArraysLeet.Medium;

import javax.swing.*;
import java.util.*;

public class InsertDeleteGetRandomWithDuplicates {

    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> map;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomWithDuplicates() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
            boolean contains = map.containsKey(val);
            // if value is not there in a map
            if (!contains)
                map.put(val, new LinkedHashSet<Integer>());
            map.get(val).add(nums.size());
            nums.add(val);
            return !contains;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        // if value is not there in a map
        if (!map.containsKey(val) || map.get(val).isEmpty())
            return false;

        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);
        int last = nums.get(nums.size()-1);
        nums.set(removeIndex,last);
        map.get(last).remove(removeIndex);
        map.get(last).add(nums.size()-1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomWithDuplicates obj = new InsertDeleteGetRandomWithDuplicates();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }
}
