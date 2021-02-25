import java.util.ArrayList;

/**
 *
 * @author JosemiMoran
 */

public class P2 implements Runnable{
    public static int seconds;
    public static void main (String[] args){
        //TODO validate args[].

        //Number of threads by arg0
        int numThreads = Integer.parseInt(args[0]);
        ArrayList<Thread> threadArrayList = new ArrayList<>(numThreads);
        seconds = Integer.parseInt(args[1]);
        for (int i=0; i<numThreads;i++){
            // Declare new Thread
            Thread thread = new Thread(new P2(), "T" + i);
            threadArrayList.add(thread); // Adding the thread into the arraylist
        }

        for (Thread thread: threadArrayList) {
            //Call run() function
            thread.start();
        }

        for (Thread thread: threadArrayList){
           try{
               thread.join();
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
        }

        System.out.println("End of program");
    }

    @Override
    public void run() {
        System.out.println("My name is " + Thread.currentThread().getName());
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Bye from thread" + Thread.currentThread().getName());
    }
}
