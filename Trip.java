public class Trip {
    boolean trip;
    int destinationLength;
    int destinationWidth;
    Passengers passengers;
    Driver driver;
    int originalLength;
    int origenWidth;
    PaymentType paymentType;
    private Trip_status tripStatus;

    public Trip_status getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(Trip_status tripStatus) {
        this.tripStatus = tripStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public int getOriginalLength() {
        return originalLength;
    }

    public void setOriginalLength(int originalLength) {
        this.originalLength = originalLength;
    }

    public int getOrigenWidth() {
        return origenWidth;
    }

    public void setOrigenWidth(int origenWidth) {
        this.origenWidth = origenWidth;
    }

    public boolean isTrip() {
        return trip;
    }

    public void setTrip(boolean trip) {
        this.trip = trip;
    }

    public int getDestinationLength() {
        return destinationLength;
    }

    public void setDestinationLength(int destinationLength) {
        this.destinationLength = destinationLength;
    }

    public int getDestinationWidth() {
        return destinationWidth;
    }

    public void setDestinationWidth(int destinationWidth) {
        this.destinationWidth = destinationWidth;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
	
}