package MultiThread.ConcurrenctModification;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Map<String ,Integer> map = new ConcurrentHashMap<>();
        MapHelper1 one = new MapHelper1(map,"one");
        MapHelper2 two = new MapHelper2(map,"two");
        MapHelper3 three = new MapHelper3(map,"three");
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}
