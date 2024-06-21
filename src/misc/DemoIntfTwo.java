package misc;

public interface DemoIntfTwo {

    default void demoDiamond() {
        System.out.println("Impl of DemoIntfTwo");
    }
}
