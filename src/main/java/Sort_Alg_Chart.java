import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Sort_Alg_Chart {
    private static int window_offset = 4;

    public Sort_Alg_Chart() {}

    public void display_chart(Map<String, Sort_Alg_Test.Test_Result> result_Map, String test_name) {
        DefaultCategoryDataset data_set = new DefaultCategoryDataset();
        for (Map.Entry<String, Sort_Alg_Test.Test_Result> entry : result_Map.entrySet()) {
            data_set.addValue(entry.getValue().current_time, " Execution Time ", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                test_name,
                "Algorithm",
                " ",
                data_set,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false
        );

        Font mono_font = new Font("Consolas", Font.PLAIN, 14);
        Font mono_font_bold = new Font("Consolas", Font.BOLD, 24);

        Color background_color = new Color(30, 30, 30);
        Color text_color = Color.WHITE;
        Color grid_color = new Color(80, 80, 80);

        TextTitle title = new TextTitle(test_name);
        title.setFont(mono_font_bold);
        title.setPaint(text_color);
        chart.setTitle(title);


        chart.setBackgroundPaint(background_color);

        if (chart.getLegend() != null) {
            chart.getLegend().setItemFont(mono_font);
            chart.getLegend().setBackgroundPaint(background_color);
            chart.getLegend().setItemPaint(text_color);
        }

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(background_color);
        plot.setDomainGridlinePaint(grid_color);
        plot.setRangeGridlinePaint(grid_color);
        plot.setOutlineVisible(false);

        CategoryAxis y_axis = plot.getDomainAxis();
        y_axis.setLabelFont(mono_font);
        y_axis.setTickLabelFont(mono_font);
        y_axis.setLabelPaint(text_color);
        y_axis.setTickLabelPaint(text_color);

        ValueAxis x_axis = plot.getRangeAxis();
        x_axis.setLabelFont(mono_font);
        x_axis.setTickLabelFont(mono_font);
        x_axis.setLabelPaint(text_color);
        x_axis.setTickLabelPaint(text_color);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.WHITE);
        renderer.setMaximumBarWidth(0.05);
        renderer.setDefaultItemLabelFont(mono_font);
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelPaint(text_color);



        ChartPanel chart_panel = new ChartPanel(chart);
        chart_panel.setBackground(background_color);
        chart_panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JFrame frame = new JFrame(test_name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(chart_panel);
        frame.getContentPane().setBackground(background_color);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frame_width = screenSize.width / 2;
        int frame_height = screenSize.height / 2;
        frame.setSize(frame_width, frame_height);

        int offset = 40 * window_offset++;
        frame.setLocation(offset, offset);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }
}
