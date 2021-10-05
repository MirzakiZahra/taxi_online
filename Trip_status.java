public enum Trip_status {
    ONTRIP("on"),OFFTRIP("off");
    private String abbr;

    Trip_status(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}