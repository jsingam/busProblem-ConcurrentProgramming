

/**
 * This is class is created by singam
 **/
public class Application {


    public static void main(String[] args) {
        //Bus Queue is printed for the first time and the bus generating thread and the rider generation threads are started
        System.out.print("Bus Queue: ");
        new RiderGenerator().start();
        new BusGenerator().start();

    }



}
