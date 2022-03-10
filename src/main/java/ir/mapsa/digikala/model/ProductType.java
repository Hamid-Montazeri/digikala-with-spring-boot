package ir.mapsa.digikala.model;

public enum ProductType {

    NORMAL("Normal"),
    PROMOTION("Promotion");

    private String value;

    ProductType(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
