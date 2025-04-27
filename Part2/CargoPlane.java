package Part2;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id) {
        this.id = id;
    }

    public void receive(String msg) {
        System.out.println("CargoPlane " + id + " received: " + msg);
    }
}