package ir.mapsa.digikala.model;


public enum OrderStatus {

    PENDING,
    PROCESSING,
    COMPLETED,
    CANCELLED;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
