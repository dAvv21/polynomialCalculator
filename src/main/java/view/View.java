package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame {

    private final JPanel contentPane;
    private final JTextField firstPolTxt;
    private final JTextField secondPolTxt;
    private final JButton multiplicateButton;
    private final JButton divideButton;
    private final JButton addButton;
    private final JButton substractButton;
    private final JButton integrationButton;
    private final JButton derivationButton;
    private final JTextField answerTxt;
    private final JTextField restTxt;
    private final JLabel restLabel;


    public View() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 571, 519);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        firstPolTxt = new JTextField();
        firstPolTxt.setFont(new Font("Arial", Font.PLAIN, 17));
        firstPolTxt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (firstPolTxt.getText().equals("First Polynomial")) {
                    firstPolTxt.setText("");
                } else
                    firstPolTxt.selectAll();

            }
        });

        firstPolTxt.setBounds(251, 91, 296, 32);
        contentPane.add(firstPolTxt);
        firstPolTxt.setColumns(10);

        JLabel firstPolLabel = new JLabel("First Polynomial");
        firstPolLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        firstPolLabel.setHorizontalAlignment(SwingConstants.LEFT);
        firstPolLabel.setBounds(10, 91, 214, 23);
        contentPane.add(firstPolLabel);

        JLabel secondPolLabel = new JLabel("Second Polynomial");
        secondPolLabel.setHorizontalAlignment(SwingConstants.LEFT);
        secondPolLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        secondPolLabel.setBounds(10, 152, 241, 23);
        contentPane.add(secondPolLabel);

        secondPolTxt = new JTextField();
        secondPolTxt.setFont(new Font("Arial", Font.PLAIN, 17));
        secondPolTxt.setColumns(10);
        secondPolTxt.setBounds(251, 152, 296, 32);
        contentPane.add(secondPolTxt);

        JLabel titleLbl = new JLabel("Polynomial Calculator");
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.PLAIN, 29));
        titleLbl.setBounds(10, 20, 537, 38);
        contentPane.add(titleLbl);

        multiplicateButton = new JButton("Multiplicate");
        multiplicateButton.setFont(new Font("Arial", Font.PLAIN, 17));
        multiplicateButton.setBounds(42, 337, 182, 38);
        contentPane.add(multiplicateButton);

        divideButton = new JButton("Divide");
        divideButton.setFont(new Font("Arial", Font.PLAIN, 17));
        divideButton.setBounds(42, 392, 182, 38);
        contentPane.add(divideButton);

        addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.PLAIN, 17));
        addButton.setBounds(42, 451, 182, 38);
        contentPane.add(addButton);

        substractButton = new JButton("Substract");
        substractButton.setFont(new Font("Arial", Font.PLAIN, 17));
        substractButton.setBounds(337, 337, 182, 38);
        contentPane.add(substractButton);

        integrationButton = new JButton("Integrate");
        integrationButton.setFont(new Font("Arial", Font.PLAIN, 17));
        integrationButton.setBounds(337, 392, 182, 38);
        contentPane.add(integrationButton);

        derivationButton = new JButton("Derivation");
        derivationButton.setFont(new Font("Arial", Font.PLAIN, 17));
        derivationButton.setBounds(337, 451, 182, 38);
        contentPane.add(derivationButton);

        JLabel lblX = new JLabel("X");
        lblX.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
                    View.this.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblX.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblX.setForeground(Color.WHITE);
            }
        });
        lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblX.setBounds(552, 5, 31, 23);
        contentPane.add(lblX);

        answerTxt = new JTextField();
        answerTxt.setFont(new Font("Arial", Font.PLAIN, 17));
        answerTxt.setColumns(10);
        answerTxt.setBounds(251, 205, 296, 32);
        contentPane.add(answerTxt);

        restTxt = new JTextField();
        restTxt.setColumns(10);
        restTxt.setBounds(251, 261, 296, 32);
        contentPane.add(restTxt);

        JLabel answerLabel = new JLabel("Answer");
        answerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        answerLabel.setBounds(10, 205, 241, 37);
        contentPane.add(answerLabel);

        restLabel = new JLabel("Remainder");
        restLabel.setHorizontalAlignment(SwingConstants.LEFT);
        restLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        restLabel.setBounds(10, 270, 241, 23);
        contentPane.add(restLabel);


        this.setVisible(true);
    }

    public String getFirstPolTxt() {
        return firstPolTxt.getText();
    }

    public String getSecondPolTxt() {
        return secondPolTxt.getText();
    }

    public void setAnswerTxt(String text) {
        this.answerTxt.setText(text);
    }


    public void addMultiplicateActionListener(ActionListener actionListener) {
        multiplicateButton.addActionListener(actionListener);
    }

    public void addDivideActionListener(ActionListener actionListener) {
        divideButton.addActionListener(actionListener);
    }

    public void addAdditionActionListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void addSubstractActionListener(ActionListener actionListener) {
        substractButton.addActionListener(actionListener);
    }

    public void addIntegrationActionListener(ActionListener actionListener) {
        integrationButton.addActionListener(actionListener);
    }

    public void addDerivationActionListener(ActionListener actionListener) {
        derivationButton.addActionListener(actionListener);
    }
}
