package misc;

public class DemoClass implements DemoIntf, DemoIntfTwo {

    @Override
    public void testDef() {
        System.out.println("impl of DemoClass");
    }

//    @Override
//    public void demoDiamond() {
//        DemoIntf.super.demoDiamond();
//    }

    @Override
    public void demoDiamond() {
       // DemoIntf.super.demoDiamond();
        System.out.println("Impl of DemoClass of DemoDiamond method");
    }
}
