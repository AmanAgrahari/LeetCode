package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    /** Initialize your data structure here. */
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    int index;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        index = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || list.isEmpty()){
            return false;
        }
        if(list.size() == 1){
            list.clear();
            map.clear();
            return true;
        }
        int index = map.get(val);
        if(index == list.size()-1){
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        int tmp = list.get(list.size() - 1);
        Collections.swap(list,index,list.size()-1);
        list.remove(list.size()-1);
        map.remove(val);
        map.put(tmp, index);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int ranIndnex = random.nextInt(list.size());
        return list.get(ranIndnex);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.insert(2);
        boolean p4 = obj.insert(3);
        boolean paramm_3 = obj.remove(3);
    }
}
