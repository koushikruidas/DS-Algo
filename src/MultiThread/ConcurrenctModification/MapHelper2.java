package MultiThread.ConcurrenctModification;

import java.util.Map;

public class MapHelper2 implements Runnable {
    private Map<String,Integer> map;
    public MapHelper2(Map<String ,Integer> map, String name){
        this.map = map;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        map.put("two",2);
        try {
            System.out.println("maphelper2 sleeping..");
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
