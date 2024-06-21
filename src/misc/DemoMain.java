package misc;

public class DemoMain {
    public static void main(String[] args) {
        DemoIntf demoIntf = new DemoClass();

        demoIntf.testDef();

        demoIntf.demoDiamond();

        String s1 = "test";

        System.out.println("hash: "+ s1.hashCode());

        s1 = s1 + "123";

        System.out.println("hash: "+ s1.hashCode());

        StringBuilder sb = new StringBuilder("sb test");

        System.out.println("hash sb: "+ sb.hashCode());

        sb.append("12345");

        System.out.println("hash sb: "+ sb.hashCode());
    }
}
