package Part2;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id) {
        this.id = id;
    }

    public void receive(String msg) {
        System.out.println("PassengerPlane " + id + " received: " + msg);
    }
}