import java.util.ArrayList;
import java.util.HashMap;

public class HelloWorld {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i=0; i<10; i++) {
            a.add(i);
        }
        a.set(2, 10000);
//        System.out.println(a.size());
//        System.out.println(a.size());
//        System.out.println(a.size());
//        System.out.println(a.size());

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("test", 23);
        hm.put("test2", 42);
        for (String key : hm.keySet()) {
            System.out.println(key + " " + hm.get(key));
        }
    }
}