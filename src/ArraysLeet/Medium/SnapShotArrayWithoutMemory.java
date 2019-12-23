package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.TreeMap;

public class SnapShotArrayWithoutMemory {

    ArrayList<TreeMap<Integer,Integer>> snap;
    int id;
    int length ;

    public SnapShotArrayWithoutMemory(int length) {
        snap = new ArrayList<>(length);
        id = 0;
        for(int i = 0; i < length; i++){
            snap.add(new TreeMap<>());
        }
        this.length = length;
    }

    public void set(int index, int val) {
        if(index < length){
            snap.get(index).put(id,val);
        }
    }

    public int snap() {
        return id++;
    }

    public int get(int index, int snap_id) {
        if (index < 0 || index >= length || snap_id < 0 || snap_id >= id) {
            return -1;
        }
        Integer key = snap.get(index).floorKey(snap_id);
        if(key == null){
            return 0;
        }
        return snap.get(index).get(key);
    }

    public static void main(String[] args) {
        //   ["SnapshotArray","set","snap","set","get"]
        //   [[3],[0,5],[],[0,6],[0,0]]


        SnapShotArrayWithoutMemory snapshotArray = new SnapShotArrayWithoutMemory(3);
        snapshotArray.set(0,5);
        System.out.println(snapshotArray.snap());
        snapshotArray.set(0,6);
        System.out.println( snapshotArray.get(0,0));
    }

}
