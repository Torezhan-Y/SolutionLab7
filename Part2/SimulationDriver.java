package Part2;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationDriver {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            Random rand = new Random();
            int type = rand.nextInt(3);
            Aircraft aircraft;

            if (type == 0) {
                aircraft = new PassengerPlane("P" + rand.nextInt(100));
            } else if (type == 1) {
                aircraft = new CargoPlane("C" + rand.nextInt(100));
            } else {
                aircraft = new Helicopter("H" + rand.nextInt(100));
            }

            if (rand.nextInt(10) < 2) { // 20% chance for MAYDAY
                aircraft.send("MAYDAY", tower);
            } else {
                tower.requestRunway(aircraft);
                aircraft.send("Requesting runway", tower);
            }

            tower.landOrTakeOff();
        }, 0, 1, TimeUnit.SECONDS);
    }
}
