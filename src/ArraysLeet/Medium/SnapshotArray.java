package ArraysLeet.Medium;

import java.util.ArrayList;

class SnapshotArray {

    ArrayList<ArrayList<Integer>> snap;
    int id;
    ArrayList<Integer> al;
    int length ;
    public SnapshotArray(int length) {
        al = new ArrayList<>(length);
        for(int i = 0; i < length ; i++){
            al.add(0);
        }
        snap = new ArrayList<>();
        id = 0;
        this.length = length;
    }

    public void set(int index, int val) {
        al.set(index,val);
    }

    public int snap() {
        snap.add(new ArrayList<>(al));
        return snap.size()-1;
    }

    public int get(int index, int snap_id) {
        ArrayList<Integer> list = snap.get(snap_id);
        return list.get(index);
    }

    public static void main(String[] args) {

        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.set(0,5);
        System.out.println(snapshotArray.snap());
        snapshotArray.set(0,6);
        System.out.println( snapshotArray.get(0,0));
      // System.out.println(snapshotArray.get(0,0));
    }
}