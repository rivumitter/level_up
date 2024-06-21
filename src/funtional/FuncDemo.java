package funtional;

public class FuncDemo {
    public static void main(String[] args) {
        FuncIntf funcIntf = () -> System.out.println("Printing Func");

        funcIntf.doPrint();
    }
}
