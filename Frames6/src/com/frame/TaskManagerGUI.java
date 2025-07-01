package com.frame;

import javax.swing.*;
import java.awt.*;
//import java.awt.event
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskManagerGUI {
    private JFrame frame;
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public TaskManagerGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Task field and add button
        JPanel topPanel = new JPanel();
        taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new AddTaskListener());
        topPanel.add(taskField);
        topPanel.add(addButton);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane taskListScrollPane = new JScrollPane(taskList);

        // Delete button
        JButton deleteButton = new JButton("Delete Task");
        deleteButton.addActionListener(new DeleteTaskListener());

        // Layout
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(taskListScrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        }
    }

    private class DeleteTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskManagerGUI();
            }
        });
    }
}
