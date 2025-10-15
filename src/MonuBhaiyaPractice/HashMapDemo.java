package MonuBhaiyaPractice;
import java.util.*;
public class HashMapDemo {
    public static void Main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();

//        Adding a pair
        map.put("Rupam", 1);
        map.put("Shubhang", 2);
        map.put("Krishna", 3);
        map.put("Sanskar", 4);
        map.put("Suryansh", 6);
        map.put("Suryansh", 5);

        System.out.println(map);
    }
}
