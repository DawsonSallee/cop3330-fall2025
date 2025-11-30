public class Lamp extends Device implements Switchable {
    
    public Lamp (String band) {
        super(band);
    }

    @Override
    public void toggle() {
        System.out.println("Lamp " + brand + " toggled");
    }

    public static void main(String[] args) {
        Lamp lamp = new Lamp("Daddy D");
        lamp.toggle();

    }
}

interface Switchable {
    public void toggle();
}

abstract class Device {
    String brand;

    public Device (String brand) {
        this.brand = brand;
    }
}