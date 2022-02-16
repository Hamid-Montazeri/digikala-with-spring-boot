package ir.mapsa.digikala.product;

public enum Type {
    NORMAL("Normal"),
    PROMOTION("Promotion");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
