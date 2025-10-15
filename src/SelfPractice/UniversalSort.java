package SelfPractice;
import java.util.*;
public class UniversalSort {
    public static void sortMixed(List<Object> list) {
        Collections.sort(list, (a, b) -> a.toString().compareTo(b.toString()));
    }

    public static void main(String[] args) {
//        List<Object> mixedList = new ArrayList<>(Arrays.asList(3, "apple", 1.5, "banana", 2, "1", 0.5));
//        System.out.println("Before sorting: " + mixedList);
//        sortMixed(mixedList);
//        System.out.println("After sorting: " + mixedList);

        List<Object> mixedList = new ArrayList<>();
        mixedList.add(3);
        mixedList.add("apple");
        mixedList.add(1.5);
        mixedList.add("banana");
        mixedList.add(2);
        mixedList.add("1");
        mixedList.add(0.5);
        System.out.println("Before sorting: " + mixedList);
        sortMixed(mixedList);
        System.out.println("After sorting: " + mixedList);
    }
}