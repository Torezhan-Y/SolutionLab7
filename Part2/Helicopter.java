package Part2;

public class Helicopter extends Aircraft {
    public Helicopter(String id) {
        this.id = id;
    }

    public void receive(String msg) {
        System.out.println("Helicopter " + id + " received: " + msg);
    }
}
