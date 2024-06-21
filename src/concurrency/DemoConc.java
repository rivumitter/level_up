package concurrency;

import java.util.concurrent.Callable;

public class DemoConc {
    public static void main(String[] args) throws Exception {

        Runnable doRun = () -> {
            System.out.println("Running doRun method...");
        };

        doRun.run();

        Callable<String> doCall = () -> "Running doCall method...";

        String call = doCall.call(); // callable can throw exception unlike runnable ..

        System.out.println(call);


    }
}
