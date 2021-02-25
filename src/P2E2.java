import java.io.*;
import java.util.ArrayList;
import java.util.logging.*;
import static java.lang.Math.*;

public class P2E2 implements Runnable {
    public static void main (String[] args) throws IOException {
        int numThreads = Integer.parseInt(args[0]);
        ArrayList<Thread> threadArrayList = new ArrayList<>(numThreads);
        long start = System.currentTimeMillis();
        for (int i=0; i<numThreads;i++){
            // Declare new Thread
            Thread thread = new Thread(new P2E2(), "T" + i);
            System.out.println("Creating: " + thread.getName());
            threadArrayList.add(thread); // Adding the thread into the arraylist
        }

        for (Thread thread: threadArrayList) {
            //Call run() function
            thread.start();
        }

        for (Thread thread: threadArrayList){
            try{
                System.out.println("Ends: "+ thread.getName());
                thread.join();
            }
            catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("The total duration is:" + duration);
        System.out.println("The program has ended correctly");

       appendUsingPrintWriter("values.txt" , numThreads , duration);

    }

    @Override
    public void run() {
        System.out.println("Execute {}"+Thread.currentThread().getName());
        for(int i=0; i<1000000; ++i) {
            double d=tan(atan(
                    tan(atan(
                            tan(atan(
                                    tan(atan(
                                            tan(atan(123456789.123456789))
                                    ))
                            ))
                    ))
            ));
            cbrt(d);
        }

    }

    private static void appendUsingPrintWriter(String filePath, int numThreads , long duration) {
        File file = new File(filePath);
        FileWriter fr = null;
        BufferedWriter br = null;
        PrintWriter pr = null;
        try {
            // to append to file, you need to initialize FileWriter using below constructor
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
            pr = new PrintWriter(br);
            pr.println(numThreads + " " + duration);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
