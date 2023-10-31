import javax.swing.*;
import java.awt.*;

public class DailyPlanner {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Daily Planner");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        mainFrame.add(scrollPane, BorderLayout.NORTH);

        JButton newTaskButton = new JButton("New Task");
        newTaskButton.addActionListener(e -> {
            JFrame taskFrame = new JFrame("New Task");
            taskFrame.setSize(300, 250);

            JPanel taskPanel = new JPanel(new GridLayout(5, 2));
            taskPanel.add(new JLabel("Task Text:"));
            JTextField taskTextField = new JTextField();
            taskPanel.add(taskTextField);
            taskPanel.add(new JLabel("Task Time:"));
            JTextField timeTextField = new JTextField();
            taskPanel.add(timeTextField);
            taskPanel.add(new JLabel("Task Importance:"));
            JComboBox<String> importanceComboBox = new JComboBox<>(new String[]{"Low", "Medium", "High"});
            taskPanel.add(importanceComboBox);
            taskPanel.add(new JLabel("Background Color:"));
            JButton colorButton = new JButton("Choose Color");
            colorButton.addActionListener(e1 -> {
                Color color = null;
                String[] options = {"Red", "Green", "Black"};
                int choice = JOptionPane.showOptionDialog(null, "Choose a color", "Color Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                switch (choice) {
                    case 0:
                        color = Color.RED;
                        break;
                    case 1:
                        color = Color.GREEN;
                        break;
                    case 2:
                        color = Color.BLACK;
                        break;
                }
                if (color != null) {
                    taskPanel.setBackground(color);
                }
            });
            taskPanel.add(colorButton);
            JButton addToListButton = new JButton("Add to List");
            addToListButton.addActionListener(e1 -> {
                String taskText = taskTextField.getText();
                String taskTime = timeTextField.getText();
                String taskImportance = (String) importanceComboBox.getSelectedItem();
                listModel.addElement(taskText + " (" + taskTime + ") - " + taskImportance);
                taskFrame.dispose(); // close the task window
            });
            taskPanel.add(addToListButton);

            taskFrame.add(taskPanel);
            taskFrame.setVisible(true);
        });

        mainFrame.add(newTaskButton, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }
}
