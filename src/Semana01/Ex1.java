package Semana01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1 {
    private static class FrameTest {
        private JFrame frame;

        public FrameTest() {
            frame = new JFrame("Test JFrame");

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            addFrameContent();
        }

        public void open() {
            frame.setVisible(true);
            frame.setSize(300, 300);
        }

        private void addFrameContent() {
            frame.setLayout(new GridLayout(4, 2));
            frame.add(new JLabel("title"));
            JTextField titleInput = new JTextField("Hello");
            frame.add(titleInput);

            frame.add(new JLabel("width"));
            JTextField widthInput = new JTextField("300");
            frame.add(widthInput);

            frame.add(new JLabel("height"));
            JTextField heightInput = new JTextField("300");
            frame.add(heightInput);

            JCheckBox centerCheck = new JCheckBox("Center");

            JButton updateButton = new JButton("Update");
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent _e) {
                    int newW = Integer.parseInt(widthInput.getText());
                    int newH = Integer.parseInt(heightInput.getText());
                    frame.setSize(newW, newH);

                    String newT = titleInput.getText();
                    frame.setTitle(newT);

                    if(centerCheck.isSelected()) center();
                }
            });
            frame.add(updateButton);

            frame.add(centerCheck);
        }

        private void center() {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

            int paddingLeft = (dimension.width - frame.getWidth()) / 2;
            int paddingTop = (dimension.height - frame.getHeight()) / 2;

            frame.setLocation(paddingLeft, paddingTop);
        }
    }

    public static void main(String[] args) {
        FrameTest window = new FrameTest();
        window.open();
    }
}
