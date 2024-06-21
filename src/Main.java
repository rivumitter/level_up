import test.PUATypes;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        boolean user = PUATypes.matchPua("userOnly");

        System.out.println(user);
    }
}