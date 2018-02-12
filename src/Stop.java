import java.util.concurrent.Semaphore;

/**
 * This is class is created by singam
 **/
public abstract class Stop {

    static int waiting =0;
    static Semaphore mutex= new Semaphore(1);
    static Semaphore bus = new Semaphore(0);
    static Semaphore boarded =new Semaphore(0);

    public static int getWaiting() {
        return waiting;
    }

    public static void setWaiting(int waiting) {
        waiting = waiting;
    }

    public static void waitForBus() throws InterruptedException {
        mutex.acquire();// to avoid other riders from mutual exclution
        waiting++;
        System.out.print("*");
        mutex.release();

        bus.acquire();//waiting for bus
        //boarding
        boarded.release();//confirming the boaring

    }

    public static void BoardBus() throws InterruptedException {
       mutex.acquire(); //locks other riders and other buses
       if(waiting>0) { //this is to ensure that there are some riders waiting
           System.out.println("\nBus arrived and the boarding process is started");
           int n = Math.min(waiting, 50);//finding boaring number of people
           System.out.println(waiting + " passengers are waiting to be boarded");
           Thread.sleep(1000);//boarding time
           System.out.println(n + " passengers are boarded");

           for (int i = 0; i < n; i++) { // boarding people one by one
               bus.release();
               boarded.acquire();
           }
           System.out.println("Bus departed");
           System.out.print("Bus Queue: ");
           waiting = waiting - n;
           for (int i = 0; i < waiting; i++) { // for display
               System.out.print("*");
           }


       }
       else{ //if no passengers are waiting
           System.out.println("No one is waiting for the bus. Bus departed");
           System.out.print("Bus Queue: ");
       }
       mutex.release();


    }
}
