import org.math.plot.Plot2DPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.math.plot.*;

import javax.swing.*;

class test {
    public static void main(String[] args) {
        try {
            File myObj = new File("./src/values.txt");
            Scanner myReader = new Scanner(myObj);
            double[] x = new double[201];
            double[] y = new double[201];
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                double numThreads = Double.parseDouble(data.split(", ")[0]);
                x[i] = numThreads;
                double duration = Double.parseDouble(data.split(", ")[1]);
                y[i] = duration;
                System.out.println(x[i] + "----->" + y[i]);
                i++;
            }
            myReader.close();
            Plot2DPanel plot = new Plot2DPanel();

            // define the legend position
            plot.addLegend("SOUTH");

            // add a line plot to the PlotPanel
            plot.addLinePlot("CDI LAB02 E2", x, y);

            // put the PlotPanel in a JFrame like a JPanel
            JFrame frame = new JFrame("a plot panel");
            frame.setSize(600, 600);
            frame.setContentPane(plot);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            e.getMessage();
        }
    }
}
