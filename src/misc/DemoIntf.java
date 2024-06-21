package misc;

public interface DemoIntf {

    default void testDef() {
        System.out.println("impl of DemoIntf");
    }

    default void demoDiamond() {
        System.out.println("Impl of DemoIntfOne");
    }
}
