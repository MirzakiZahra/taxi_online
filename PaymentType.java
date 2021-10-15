public enum PaymentType {
    ONLINE("o"),CASH("c");
    private String abbr;

    PaymentType(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}