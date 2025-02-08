import java.util.HashMap;
import java.util.TreeSet;

class NumberContainers {
    HashMap<Integer, Integer> indexToNumberMap;
    HashMap<Integer, TreeSet<Integer>> numberToIndicesMap;

    public NumberContainers() {
        indexToNumberMap = new HashMap<>();
        numberToIndicesMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumberMap.containsKey(index)) {
            int prevNum = indexToNumberMap.get(index);
            numberToIndicesMap.get(prevNum).remove(index);
            if (numberToIndicesMap.get(prevNum).isEmpty()) {
                numberToIndicesMap.remove(prevNum);
            }
        }

        indexToNumberMap.put(index, number);
        numberToIndicesMap.putIfAbsent(number, new TreeSet<>());
        numberToIndicesMap.get(number).add(index);
    }

    public int find(int number) {
        if (numberToIndicesMap.containsKey(number)) {
            return numberToIndicesMap.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */