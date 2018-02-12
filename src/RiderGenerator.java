/**
 * This is class is created by singam
 **/
public class RiderGenerator extends Thread{

    @Override
    public void run() {
        while(true){
            try {
                //riders will be created with random time

                Thread.sleep(getRandom());
                new Rider().start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static int getRandom() {
        //generates random numbers based on the distribution
        double  num=Math.abs(Math.random());
        return (int) (-(Math.log(1-num))*30*1000);
    }
}
