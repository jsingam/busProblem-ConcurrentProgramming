/**
 * This is class is created by singam
 **/
public class BusGenerator extends Thread {

    @Override
    public void run() {
        //this creates bus
        while(true){
            try {
                Thread.sleep(getRandom());
                new Bus().start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    public static int getRandom() {
        //this generates random numbers based on the distribution
        double  num=Math.abs(Math.random());
        return (int) (-(Math.log(1-num))*20*1000*60);
    }

}
