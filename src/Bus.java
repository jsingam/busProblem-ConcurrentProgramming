/**
 * This is class is created by singam
 **/
public class Bus extends Thread{


    @Override
    public void run() {


        try {
            Stop.BoardBus();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
