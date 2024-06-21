package test;

import java.util.List;

public enum PUATypes {

    USER("user"), USER_ONLY("userOnly");

    private String name;


    PUATypes(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public static List<PUATypes> getPuaTypes() {
        return List.of(USER, USER_ONLY);
    }

    public static boolean matchPua(String acr) {
        return getPuaTypes().stream().anyMatch(puaTypes -> puaTypes.getName().equals(acr));
    }
}
