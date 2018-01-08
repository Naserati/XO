package nazarov;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class XO {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                XOFrame frame = new XOFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 600);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
            }
        });
    }

    static class XOFrame extends JFrame {
        public XOFrame() {
            setTitle("Крестики-Нолики");
            XOPanel panel = new XOPanel();
            add(panel);
        }
    }

    static class XOPanel extends JPanel {

        JButton displayN, displayNX, displayNO, displayS, b1, b2, b3, b4, b5, b6, b7, b8, b9;
        JPanel panel, panelN;
        Font BigFont = new Font("TimesRoman", Font.BOLD, 20);
        Font XOFont = new Font("TimesRoman", Font.BOLD, 150);
        private String lastCommand = "";
        private int xWin = 0;
        private int oWin = 0;
        private final String x = "Крестики";
        private final String o = "Нолики";
        private ArrayList<JButton> buttons = new ArrayList<>();

        public XOPanel() {
            setLayout(new BorderLayout());
            panelN = new JPanel();
            panelN.setPreferredSize(new Dimension(500, 50));
            panelN.setLayout(new GridLayout(1,3));
            displayN = new JButton();
            displayN.setEnabled(false);
            displayNX = new JButton();
            displayNX.setEnabled(false);
            displayNO = new JButton();
            displayNO.setEnabled(false);
            displayN.setFont(BigFont);
            displayN.setText(xWin + " : " + oWin);
            displayN.setBorderPainted(false);
            displayNX.setText("Крестики");
            displayNX.setFont(BigFont);
            displayNX.setBorderPainted(false);
            displayNO.setText("Нолики");
            displayNO.setFont(BigFont);
            displayNO.setBorderPainted(false);
            panelN.add(displayNX);
            panelN.add(displayN);
            panelN.add(displayNO);

            add(panelN, BorderLayout.NORTH);

            ActionListener input = new InListener();
            panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3));

            b1 = new JButton("");
            b1.addActionListener(input);
            panel.add(b1);
            buttons.add(b1);

            b2 = new JButton("");
            b2.addActionListener(input);
            panel.add(b2);
            buttons.add(b2);

            b3 = new JButton("");
            b3.addActionListener(input);
            panel.add(b3);
            buttons.add(b3);

            b4 = new JButton("");
            b4.addActionListener(input);
            panel.add(b4);
            buttons.add(b4);

            b5 = new JButton("");
            b5.addActionListener(input);
            panel.add(b5);
            buttons.add(b5);

            b6 = new JButton("");
            b6.addActionListener(input);
            panel.add(b6);
            buttons.add(b6);

            b7 = new JButton("");
            b7.addActionListener(input);
            panel.add(b7);
            buttons.add(b7);

            b8 = new JButton("");
            b8.addActionListener(input);
            panel.add(b8);
            buttons.add(b8);

            b9 = new JButton("");
            b9.addActionListener(input);
            panel.add(b9);
            buttons.add(b9);

            for(int i = 0; i < buttons.size(); i++){
                buttons.get(i).setFont(XOFont);
            }

            add(panel, BorderLayout.CENTER);

            displayS = new JButton();
            displayS.setEnabled(false);
            displayS.setPreferredSize(new Dimension(500, 50));
            displayS.setFont(BigFont);
            displayS.setText("Ходят: " + x);
            add(displayS, BorderLayout.SOUTH);
        }

        private class InListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                String command = event.getActionCommand();
                for (int k = 0; k < buttons.size(); k++)
                    if (event.getSource() == buttons.get(k)) {
                        if (command.equals("")) {
                            if (!(lastCommand.equals("X"))) {
                                buttons.get(k).setText("X");
                                buttons.get(k).setEnabled(false);
                                displayS.setText("Ходят: " + o);
                                lastCommand = "X";
                            } else if (lastCommand.equals("X")) {
                                buttons.get(k).setText("O");
                                buttons.get(k).setEnabled(false);
                                displayS.setText("Ходят: " + x);
                                lastCommand = "O";
                            }

                            if ((b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X")) ||
                                (b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X")) ||
                                (b1.getText().equals("X") && b4.getText().equals("X") && b7.getText().equals("X")) ||
                                (b2.getText().equals("X") && b5.getText().equals("X") && b8.getText().equals("X")) ||
                                (b3.getText().equals("X") && b5.getText().equals("X") && b7.getText().equals("X")) ||
                                (b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X")) ||
                                (b4.getText().equals("X") && b5.getText().equals("X") && b6.getText().equals("X")) ||
                                (b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X"))) {

                                JOptionPane.showMessageDialog(null, "Победили Крестики");
                                xWin++;
                                displayN.setText(xWin + " : " + oWin);
                                for (int i = 0; i < buttons.size(); i++) {
                                    buttons.get(i).setText("");
                                    buttons.get(i).setEnabled(true);
                                }
                                break;

                            } else if (b1.getText().equals("O") && b2.getText().equals("O") && b3.getText().equals("O") ||
                                       b1.getText().equals("O") && b5.getText().equals("O") && b9.getText().equals("O") ||
                                       b1.getText().equals("O") && b4.getText().equals("O") && b7.getText().equals("O") ||
                                       b2.getText().equals("O") && b5.getText().equals("O") && b8.getText().equals("O") ||
                                       b3.getText().equals("O") && b5.getText().equals("O") && b7.getText().equals("O") ||
                                       b3.getText().equals("O") && b6.getText().equals("O") && b9.getText().equals("O") ||
                                       b4.getText().equals("O") && b5.getText().equals("O") && b6.getText().equals("O") ||
                                       b7.getText().equals("O") && b8.getText().equals("O") && b9.getText().equals("O")) {

                                JOptionPane.showMessageDialog(null, "Победили Нолики");
                                oWin++;
                                displayN.setText(xWin + " : " + oWin);
                                for (int i = 0; i < buttons.size(); i++) {
                                    buttons.get(i).setText("");
                                    buttons.get(i).setEnabled(true);
                                }
                                break;
                            }
                            else if ((b1.getText().equals("X") || b1.getText().equals("O")) &&
                                     (b2.getText().equals("X") || b2.getText().equals("O")) &&
                                     (b3.getText().equals("X") || b3.getText().equals("O")) &&
                                     (b4.getText().equals("X") || b4.getText().equals("O")) &&
                                     (b5.getText().equals("X") || b5.getText().equals("O")) &&
                                     (b6.getText().equals("X") || b6.getText().equals("O")) &&
                                     (b7.getText().equals("X") || b7.getText().equals("O")) &&
                                     (b8.getText().equals("X") || b8.getText().equals("O")) &&
                                     (b9.getText().equals("X") || b9.getText().equals("O"))) {

                                JOptionPane.showMessageDialog(null, "Ничья");
                                for (int i = 0; i < buttons.size(); i++) {
                                    buttons.get(i).setText("");
                                    buttons.get(i).setEnabled(true);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


