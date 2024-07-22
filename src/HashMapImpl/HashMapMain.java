package HashMapImpl;

public class HashMapMain {

    public static void main(String[] args) {

        CustomHashMap<Integer, String> hmp = new CustomHashMap<>();

        hmp.put(1, "test1");
        hmp.put(2, "test2");
        hmp.put(3, "test3");
        hmp.put(1, "test-new");
        hmp.put(4, "test4");
        hmp.put(5, "test5");
        hmp.put(6, "test6");

        System.out.println(hmp.get(2));
        System.out.println(hmp.get(6));

        // before remove
        System.out.println("key: " + hmp.containsKey(1));

        hmp.remove(1);

        System.out.println(hmp.get(1));
        System.out.println(hmp.get(6));

        System.out.println(hmp.containsKey(3));

        // after remove
        System.out.println("key: " + hmp.containsKey(1));
    }
}
