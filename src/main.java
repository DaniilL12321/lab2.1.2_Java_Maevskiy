import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class main {
    private JPanel frame;
    private JButton button1;
    private JTextField textField1;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public main() {
        textField1.setText("1, 2, 3, 0, 1, 5, 6, 0, 7, 8");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculations();
            }
        });

        // Добавляем слушатель событий клавиш для textField1
        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performCalculations();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private void performCalculations() {
        String input = textField1.getText();
        String[] inputArray = input.split(", ");
        int[] array = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }

        int product = 1;
        for (int i = 0; i < array.length; i += 2) {
            product *= array[i];
        }
        jLabel1.setText("" + product);

        int sum = 0;
        boolean foundFirstZero = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (foundFirstZero) {
                    break;
                } else {
                    foundFirstZero = true;
                }
            } else if (foundFirstZero) {
                sum += array[i];
            }
        }
        jLabel2.setText("" + sum);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Вычисление массивов");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700, 400));

        // Создаем и настраиваем JLabel для отображения результатов
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        // Размещаем JLabel'ы для отображения результатов в нужных местах
        label1.setBounds(10, 200, 500, 30);
        label2.setBounds(10, 230, 500, 30);

        frame.add(label1);
        frame.add(label2);

        // Создаем экземпляр класса main
        main main = new main();

        // Добавляем panel на JFrame
        frame.setContentPane(main.frame);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.pack();
        frame.setSize(new Dimension(700, 400));
        frame.pack();
        frame.setVisible(true);
    }
}
