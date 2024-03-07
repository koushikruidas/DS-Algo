package MultiThread.ConcurrenctModification;

import java.util.Map;

public class MapHelper3 implements Runnable {
    private Map<String,Integer> map;
    public MapHelper3(Map<String ,Integer> map, String name){
        this.map = map;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        map.put("three",3);
        try {
            System.out.println("maphelper3 sleeping..");
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
