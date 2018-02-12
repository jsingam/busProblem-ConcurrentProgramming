/**
 * This is class is created by singam
 **/
public class Rider extends Thread {
    @Override
    public void run() {

        try {
            //rider waits for the bus
            Stop.waitForBus();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

