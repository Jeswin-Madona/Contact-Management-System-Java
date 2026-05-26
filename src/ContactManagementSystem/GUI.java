package ContactManagementSystem;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static JLabel label(String text) {

        JLabel label = new JLabel(text);

        label.setFont(
                new Font("Tahoma", Font.PLAIN, 17)
        );

        label.setHorizontalAlignment(
                JLabel.CENTER
        );

        label.setPreferredSize(
                new Dimension(200, 30)
        );

        return label;
    }

    public static JButton button(
            String text,
            Color background
    ) {

        JButton btn = new JButton(text);

        btn.setPreferredSize(
                new Dimension(90, 35)
        );

        btn.setBackground(background);
        btn.setForeground(Color.WHITE);

        btn.setFont(
                new Font("Tahoma", Font.PLAIN, 15)
        );

        btn.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        btn.setFocusPainted(false);

        return btn;
    }

    public static JTextField textField(
            String text
    ) {

        JTextField tf = new JTextField();

        tf.setText(text);

        tf.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        tf.setFont(
                new Font("Tahoma",
                        Font.PLAIN,
                        17)
        );

        tf.setPreferredSize(
                new Dimension(200, 35)
        );

        return tf;
    }
}