package лаб5;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;

public class Draw {
    public static void graphics(int f, ArrayList<ArrayList<Double>> points){
        ArrayList<Double> x_points = points.get(0);
        ArrayList<Double> y_points = points.get(1);
        ArrayList<Double> C = points.get(2);
        XYSeries default_func = new XYSeries("default_func");
        if (f==1){
            for (int i=0;i<points.get(0).size()-1;i++){
                double x = x_points.get(i);
                default_func.add(x, -Math.cos(x) +C.get(0));
            }
        }
        else if(f==2){
            for (int i=0;i<points.get(0).size()-1;i++){
                double x = x_points.get(i);
                double y = y_points.get(i);
                default_func.add(x, y *Math.pow(x,2) / 4 + C.get(0));
            }
        }
        else if (f==3){
            for (int i=0;i<points.get(0).size()-1;i++){
                double x = x_points.get(i);
                double y = y_points.get(i);
                default_func.add(x, (y * x) - (Math.pow(x,2) / y) + C.get(0));
            }
        }
        else if (f==4){
            for (int i=0;i<points.get(0).size()-1;i++){
                double x = x_points.get(i);
                double y = y_points.get(i);
                default_func.add(x, (Math.pow(x,2) / 2) + (y*x) + C.get(0));
            }
        }
        else {
            for (int i=0;i<points.get(0).size()-1;i++){
                double x = x_points.get(i);
                double y = y_points.get(i);
                default_func.add(x, 0);
            }
        }
        XYSeries by_Euler_func = new XYSeries("by_Euler_func");
        for (int i=0;i<x_points.size()-1;i++){
            by_Euler_func.add(x_points.get(i),y_points.get(i));
        }
        XYSeriesCollection dt = new XYSeriesCollection();
        dt.addSeries(by_Euler_func);
        dt.addSeries(default_func);
        JFreeChart xyline = ChartFactory.createXYLineChart(
                "Графики функций",
                "X",
                "Y", dt,
                PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = xyline.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.green);
        renderer.setSeriesPaint(2, Color.black);
        renderer.setSeriesPaint(3, Color.black);
        renderer.setSeriesStroke(0, new BasicStroke(1f));
        renderer.setSeriesStroke(1, new BasicStroke(1f));
        plot.setRenderer(renderer);
        ChartPanel panel = new ChartPanel(xyline);
        JFrame vent = new JFrame("График");
        vent.setVisible(true);
        vent.setSize(800, 600);
        vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vent.add(panel);

    }
}
