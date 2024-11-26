package software.ulpgc.architecture.model;

public class BarchartElement{
    private int value;
    private String field;


    public BarchartElement(int value, String field) {
        this.value = value;
        this.field = field;
    }

    public int getValue() {
        return value;
    }

    public String getField() {
        return field;
    }
}
