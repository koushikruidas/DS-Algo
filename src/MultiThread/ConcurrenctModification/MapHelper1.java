package MultiThread.ConcurrenctModification;

import java.util.Map;

public class MapHelper1 implements Runnable {
    private Map<String,Integer> map;
    public MapHelper1(Map<String ,Integer> map, String name){
        this.map = map;
        new Thread(this,name).start();
    }

    @Override
    public void run() {
        map.put("one",1);
        try {
            System.out.println("maphelper1 sleeping..");
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
