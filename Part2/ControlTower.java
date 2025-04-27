package Part2;

import java.util.LinkedList;
import java.util.Queue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeOffQueue = new LinkedList<>();
    private boolean runwayAvailable = true;

    public void broadcast(String msg, Aircraft sender) {
        if ("MAYDAY".equals(msg)) {
            clearRunway(sender);
        } else if (sender instanceof PassengerPlane) {
            System.out.println("PassengerPlane " + sender.id + ": " + msg);
        } else if (sender instanceof CargoPlane) {
            System.out.println("CargoPlane " + sender.id + ": " + msg);
        } else if (sender instanceof Helicopter) {
            System.out.println("Helicopter " + sender.id + ": " + msg);
        }
    }

    public boolean requestRunway(Aircraft a) {
        if (runwayAvailable) {
            if (a instanceof PassengerPlane || a instanceof CargoPlane) {
                takeOffQueue.offer(a);
                System.out.println(a.id + " added to takeoff queue.");
            } else if (a instanceof Helicopter) {
                landingQueue.offer(a);
                System.out.println(a.id + " added to landing queue.");
            }
            return true;
        }
        return false;
    }

    private void clearRunway(Aircraft sender) {
        System.out.println("MAYDAY! " + sender.id + " clears the runway immediately!");
        takeOffQueue.clear();
        landingQueue.clear();
        runwayAvailable = true;
    }

    public void landOrTakeOff() {
        if (!landingQueue.isEmpty()) {
            Aircraft aircraft = landingQueue.poll();
            System.out.println("Landing " + aircraft.id);
        } else if (!takeOffQueue.isEmpty()) {
            Aircraft aircraft = takeOffQueue.poll();
            System.out.println("Takeoff " + aircraft.id);
        }
    }
}

