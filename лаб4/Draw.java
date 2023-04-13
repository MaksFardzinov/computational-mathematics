package лаб4;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.List;

public class Draw {
    public static void graphics(double[] coff, double x, java.util.List<Double> x_value){
        XYSeries y_line = new XYSeries("y-axis");
        XYSeries x_line = new XYSeries("x-axis");
        y_line.add(0,-1.5);
        y_line.add(0,1.5);
        x_line.add(-5.5,0);
        x_line.add(5.5,0);
        XYSeries sin_func = new XYSeries("sin_func");
        XYSeries func_by_Cubic_splines_method = new XYSeries("func_by_Cubic_splines_method");
        for (double i = -5; i <= 5; i = i + 0.2) {
            sin_func.add(i, Math.sin(i));
            func_by_Cubic_splines_method.add(i,Cubic_splines_method.get_y(coff,i,x_value));
        }
        XYSeriesCollection dt = new XYSeriesCollection();
        dt.addSeries(y_line);
        dt.addSeries(x_line);
        dt.addSeries(sin_func);
        dt.addSeries(func_by_Cubic_splines_method);
        JFreeChart xyline = ChartFactory.createXYLineChart(
                "Графики функции",
                "X",
                "Y", dt,
                PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = xyline.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.black);
        renderer.setSeriesPaint(1, Color.black);
        renderer.setSeriesPaint(2, Color.red);
        renderer.setSeriesPaint(3, Color.blue);
        renderer.setSeriesStroke(2, new BasicStroke(2f));
        renderer.setSeriesStroke(3, new BasicStroke(2f));
        plot.setRenderer(renderer);
        ChartPanel panel = new ChartPanel(xyline);
        JFrame vent = new JFrame("График");
        vent.setVisible(true);
        vent.setSize(800, 600);
        vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vent.add(panel);
    }
}
