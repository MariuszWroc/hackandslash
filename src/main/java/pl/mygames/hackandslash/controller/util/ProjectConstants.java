package pl.mygames.hackandslash.controller.util;

public enum ProjectConstants {
    TEST_ID(1);

    private final Integer value;

    private ProjectConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
