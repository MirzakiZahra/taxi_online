public class Car {
    private String  name_of_car;
    private int plaque;
    private String color_of_car;

    public Car() {
    }

    public Car(String name_of_car, int plaque, String color_of_car) {
        this.name_of_car = name_of_car;
        this.plaque = plaque;
        this.color_of_car = color_of_car;
    }

    public String getName_of_car() {
        return name_of_car;
    }

    public void setName_of_car(String name_of_car) {
        this.name_of_car = name_of_car;
    }

    public int getPlaque() {
        return plaque;
    }

    public void setPlaque(int plaque) {
        this.plaque = plaque;
    }

    public String getColor_of_car() {
        return color_of_car;
    }

    public void setColor_of_car(String color_of_car) {
        this.color_of_car = color_of_car;
    }
}