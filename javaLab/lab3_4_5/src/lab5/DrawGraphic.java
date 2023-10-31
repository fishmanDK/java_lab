package lab5;
//DrawGraphic

import javax.swing.*;
import java.awt.*;

public class DrawGraphic extends JFrame {
//    private double[] data = {10250.0, 9250.0, 9125.0, 9041.0, 8833.0, 10167.0, 9083.0, 11500.0, 10375.0};
    private static final int GRAPH_POINT_WIDTH = 5;
    public DrawGraphic(double[] data, String str) {
        setTitle(str);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int width = getWidth();
                int height = getHeight();
                int padding = 25;
                int maxValue = (int) Math.ceil(getMaxValue(data) / 1000) * 10000;
                int xStep = (width - 2 * padding) / (data.length - 1);
                int yStep = (height - 2 * padding) / maxValue;
                g.setColor(Color.BLACK);
                g.drawLine(padding, height - padding, width - padding, height - padding);
                g.drawLine(padding, padding, padding, height - padding);
                for (int i = 0; i < data.length - 1; i++) {
                    int x1 = padding + i * xStep;
                    int y1 = height - padding - (int) (data[i] / (double) maxValue * (height - 2 * padding));
                    int x2 = padding + (i + 1) * xStep;
                    int y2 = height - padding - (int) (data[i + 1] / (double) maxValue * (height - 2 * padding));
                    g.setColor(Color.BLUE);
                    g.drawLine(x1, y1, x2, y2);
                    g.setColor(Color.BLACK);
                    g.drawString(String.format("%.0f", data[i]), x1, y1 - 5);
                }
                g.drawString(String.format("%.0f", data[data.length - 1]), width - padding, height - padding - (int) (data[data.length - 1] / (double) maxValue * (height - 2 * padding)) - 5);
                for (int i = 0; i <= 10; i++) {
                    int x0 = padding;
                    int x1 = GRAPH_POINT_WIDTH + padding;
                    int y0 = height - (((i + 1) * (height - 2 * padding)) / 11 + padding);
                    int y1 = y0;
                    g.drawString(Integer.toString((i + 1) * 1000), x0 - 25, y0 + 5);
                    g.drawLine(x0, y0, x1, y1);
                }
                for (int i = 0; i < data.length; i++) {
                    int x = padding + i * xStep;
                    int y = height - padding + 15;
                    g.drawString(Integer.toString(i + 1), x, y);
                }
            }
        };
        add(panel);
        setVisible(true);
    }

    private double getMaxValue(double[] data) {
        double maxValue = Double.MIN_VALUE;
        for (double value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

//    public static void main(String[] args) {
//        new DrawGraphic();
//    }
}