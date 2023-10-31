package lab5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogGraph extends JPanel {
    private static final int PREF_W = 1200;
    private static final int PREF_H = 1000;
    private static final int BORDER_GAP = 30;
    private static final Color GRAPH_COLOR = Color.BLUE;
    private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final int GRAPH_POINT_WIDTH = 12;
    private static final int Y_HATCH_CNT = 10;
    private ArrayList<Double> dataPoints = new ArrayList<>();

    public LogGraph(String log) {
        Pattern pattern = Pattern.compile("add, ind-(\\d+):\\s+(\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(log);
        while (matcher.find()) {
            int index = Integer.parseInt(matcher.group(1));
            double value = Double.parseDouble(matcher.group(2));
            dataPoints.add(value);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (dataPoints.size() - 1);
        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (dataPoints.stream().mapToDouble(Double::doubleValue).max().orElse(0));

        ArrayList<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < dataPoints.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((dataPoints.get(i)) * yScale + BORDER_GAP);
            graphPoints.add(new Point(x1, y1));
        }

        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

        for (int i = 0; i < Y_HATCH_CNT; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
            int y1 = y0;
            g2.drawString(Integer.toString((int) (yScale * (i + 1))), x0 - 25, y0);
            g2.drawLine(x0, y0, x1, y1);
        }

        for (int i = 0; i < dataPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.setColor(GRAPH_COLOR);
            g2.setStroke(GRAPH_STROKE);
            g2.drawLine(x1, y1, x2, y2);
            g2.setColor(GRAPH_POINT_COLOR);
            g2.fillOval(x1 - GRAPH_POINT_WIDTH / 2, y1 - GRAPH_POINT_WIDTH / 2, GRAPH_POINT_WIDTH, GRAPH_POINT_WIDTH);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public static void main(String[] args) {
        String log = "INFO: Start program\n" +
                "INFO: ArrayList\n" +
                "INFO: add, ind-1:  516750,000 ArrayList\n" +
                "INFO: add, ind-2:  11209,000 ArrayList\n" +
                "INFO: add, ind-3:  11083,000 ArrayList\n" +
                "INFO: add, ind-4:  9541,000 ArrayList\n" +
                "INFO: add, ind-5:  9042,000 ArrayList\n" +
                "INFO: add, ind-6:  8875,000 ArrayList\n" +
                "INFO: add, ind-7:  8750,000 ArrayList\n" +
                "INFO: add, ind-8:  8833,000 ArrayList\n" +
                "INFO: add, ind-9:  9834,000 ArrayList\n" +
                "INFO: add, ind-10:  9375,000 ArrayList\n" +
                "INFO: totalTime: 5584459,000 ArrayList\n" +
                "INFO: remove ArrayList: 334,000\n" +
                "INFO: srTime ArrayList: 60329,000\n" +
                "INFO: Start program\n" +
                "INFO: ArrayList\n";
        JFrame frame = new JFrame("Log Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LogGraph(log));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}