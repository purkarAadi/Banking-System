package com.ami.tech.fl;

import com.ami.tech.bl.Backend;
import java.awt.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class UserHome extends JFrame implements ActionListener {

  Backend backend;
  JPanel backgroundPanel, detailPanel, panel1;
  JLabel imgLabel, nameLabel, accountLabel, ifscLabel, addressLabel, welcmLabel;
  JLabel disname, disaccount, disifsc;
  JTextArea disaddress;
  JButton button1, button2, button3, button4, backButton, button5, logoutButton;
  //Payment methods variables...

  JFrame payFrame;
  JPanel payBackgroundPanel, headPanel;
  JButton payBackButton, payPayButton, payCancelButton;
  JLabel payRecNameLabel, payAmountLabel, payPasswordLabel, payMsgLabel;
  JTextField payNameField, payAmountField;
  JPasswordField payPasswordField;

  //Deposit method variables...
  JPanel depositBackgroundPanel, depositHeadPanel;
  JButton depositButton, depositBackButton, depositCancelButton;
  JLabel depositAmountLabel, depositMsgLabel, depositNameLabel;
  JTextField depositAmountField, depositNameField;

  //Withdraw method variables.....
  JPanel wdBackgroundPanel, wdHeadPanel;
  JButton one, two, three, four, five, six, seven, eight, nine, zero, star, hash, wdWithdrawButton, wdBackButton, wdClear, wdCancelButton;
  JTextArea wdAmountArea;
  JLabel wdMsgLabel, wdAmountLabel;

  //Show Balance method variables
  JFrame sbFrame;
  JPanel sbBackgroundPanel, sbHeadPanel;
  JButton sbBackButton, sbCancelButton;
  JLabel sbAccLabel, sbDisAccLabel, sbBalLabel, sbDisBalLabel, sbMsgLabel;

  //show Account details method variables..
  JTable saTable;
  DefaultTableModel model;
  JPanel saBackgroundPanel, saHeadPanel;
  JButton saBackButton, saExportButton;

  UserHome(Backend backend) {
    super("User");
    this.backend = backend;

    setSize(1200, 700);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int centerX = (int) (screenSize.getWidth() - this.getWidth()) / 2;
    int centerY = (int) (screenSize.getHeight() - this.getHeight()) / 2;

    // Set the frame's location to the center of the screen
    this.setLocation(centerX, centerY);

    backgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon("Resources/images/user_back.jpg"); // Replace with your image path

          // Draw the image as the background
          g.drawImage(
            imageIcon.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            this
          );
        }
      };
    backgroundPanel.setLayout(null);

    panel1 = new JPanel();
    panel1.setBounds(0, 0, 1500, 40);
    panel1.setBackground(Color.DARK_GRAY);

    ImageIcon i7 = new ImageIcon("Resources/images/back.png");
    Image i8 = i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);

    backButton = new JButton("Back", new ImageIcon(i8));
    backButton.setBounds(5, 2, 100, 30);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    backButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i17 = new ImageIcon("Resources/images/logout.jpg");
    Image i18 = i17.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    logoutButton = new JButton("Log out", new ImageIcon(i18));
    logoutButton.setBounds(1000, 2, 175, 30);
    logoutButton.setBackground(Color.RED);
    logoutButton.setForeground(Color.WHITE);
    logoutButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i1 = new ImageIcon("Resources/images/payment.jpg");
    Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button1 = new JButton("Make Payment", new ImageIcon(i2));
    button1.setBounds(700, 110, 400, 50);
    // button1.setBackground(Color.GREEN);
    // button1.setForeground(Color.WHITE);
    button1.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i3 = new ImageIcon("Resources/images/deposit.png");
    Image i4 = i3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button2 = new JButton("Deposit", new ImageIcon(i4));
    button2.setBounds(700, 180, 400, 50);
    button2.setBackground(Color.BLUE);
    button2.setForeground(Color.WHITE);
    button2.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i5 = new ImageIcon("Resources/images/withdraw.jpg");
    Image i6 = i5.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button3 = new JButton("Withdraw", new ImageIcon(i6));
    button3.setBounds(700, 250, 400, 50);
    button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    button3.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i9 = new ImageIcon("Resources/images/admin_accd.jpg");
    Image i10 = i9.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button4 = new JButton("Account Details", new ImageIcon(i10));
    button4.setBounds(700, 320, 400, 50);
    // logoutButton.setBackground(Color.RED);
    // logoutButton.setForeground(Color.WHITE);
    button4.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i14 = new ImageIcon("Resources/images/acc_balance.png");
    Image i15 = i14.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button5 = new JButton("Check Balance", new ImageIcon(i15));
    button5.setBounds(700, 390, 400, 50);
    // logoutButton.setBackground(Color.RED);
    // logoutButton.setForeground(Color.WHITE);
    button5.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    detailPanel = new JPanel();
    detailPanel.setBounds(20, 110, 600, 400);
    detailPanel.setBackground(Color.lightGray);
    detailPanel.setLayout(new BorderLayout());

    ImageIcon i11 = new ImageIcon("Resources/images/admin_img.jpg");
    Image i12 = i11.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    // ImageIcon i13=new ImageIcon(i12);
    imgLabel = new JLabel(new ImageIcon(i12));
    imgLabel.setBounds(320, 60, 50, 50);

    nameLabel = new JLabel("Name : ");
    nameLabel.setBounds(50, 140, 100, 40);
    nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    accountLabel = new JLabel("Account No. : ");
    accountLabel.setBounds(50, 210, 150, 40);
    accountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    ifscLabel = new JLabel("ifsc : ");
    ifscLabel.setBounds(50, 270, 100, 40);
    ifscLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    addressLabel = new JLabel("Address : ");
    addressLabel.setBounds(50, 340, 100, 40);
    addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    welcmLabel = new JLabel("::Welcome to Ami Tech Bank::");
    welcmLabel.setBounds(200, 470, 400, 30);
    welcmLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    welcmLabel.setForeground(Color.RED);

    disname = new JLabel(backend.getName());
    disname.setBounds(200, 140, 300, 40);
    disname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    disname.setBackground(Color.WHITE);
    disname.setOpaque(true);

    disaccount = new JLabel(backend.getAccountNumber());
    disaccount.setBounds(200, 210, 300, 40);
    disaccount.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    disaccount.setBackground(Color.WHITE);
    disaccount.setOpaque(true);

    disifsc = new JLabel(backend.getIfscCode());
    disifsc.setBounds(200, 270, 300, 40);
    disifsc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    disifsc.setBackground(Color.WHITE);
    disifsc.setOpaque(true);

    disaddress = new JTextArea(backend.getAddress());
    disaddress.setBounds(200, 340, 300, 80);
    disaddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));

    disaddress.setBackground(Color.WHITE);
    disaddress.setOpaque(true);
    disaddress.setLineWrap(true);
    disaddress.setWrapStyleWord(true);
    disaddress.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(disaddress);
    scrollPane.setVerticalScrollBarPolicy(
      ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
    );
    scrollPane.setHorizontalScrollBarPolicy(
      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    logoutButton.addActionListener(this);
    button1.addActionListener(this);
    button2.addActionListener(this);
    button3.addActionListener(this);
    button4.addActionListener(this);
    button5.addActionListener(this);
    backButton.addActionListener(this);

    add(backButton);
    add(logoutButton);
    add(panel1);
    add(button1);
    add(button2);
    add(button3);
    add(button4);
    add(button5);

    add(imgLabel);
    add(nameLabel);
    add(accountLabel);
    add(ifscLabel);
    add(addressLabel);
    add(welcmLabel);
    add(disname);
    add(disaccount);
    add(disifsc);
    add(disaddress);

    add(detailPanel);
    add(scrollPane);
    add(backgroundPanel);
  }

  public void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getSource() == button1) {
      makePayment();
      
    } else if (
      actionEvent.getSource() == payCancelButton ||
      actionEvent.getSource() == payBackButton
    ) {
      payFrame.dispose();
    } else if (actionEvent.getSource() == button2) {
      Deposit();
    } else if (actionEvent.getSource() == button3) {
      Withdraw();
    } else if (actionEvent.getSource() == button4) {
      showAcc();
    } else if (actionEvent.getSource() == button5) {
      showBalance();
    } else if (actionEvent.getSource() == logoutButton) {
      this.setVisible(false);
      new Home().setVisible(true);
    } else if (actionEvent.getSource() == backButton) {
      this.setVisible(false);
      new Home().setVisible(true);
    } else if (actionEvent.getSource() == one) {
      wdAmountArea.append("1");
    } else if (actionEvent.getSource() == two) {
      wdAmountArea.append("2");
    } else if (actionEvent.getSource() == three) {
      wdAmountArea.append("3");
    } else if (actionEvent.getSource() == four) {
      wdAmountArea.append("4");
    } else if (actionEvent.getSource() == five) {
      wdAmountArea.append("5");
    } else if (actionEvent.getSource() == six) {
      wdAmountArea.append("6");
    } else if (actionEvent.getSource() == seven) {
      wdAmountArea.append("7");
    } else if (actionEvent.getSource() == eight) {
      wdAmountArea.append("8");
    } else if (actionEvent.getSource() == nine) {
      wdAmountArea.append("9");
    } else if (actionEvent.getSource() == zero) {
      wdAmountArea.append("0");
    } else if (actionEvent.getSource() == star) {
      wdAmountArea.append("*");
    } else if (actionEvent.getSource() == hash) {
      wdAmountArea.append("#");
    } else if (actionEvent.getSource() == wdClear) {
      String currentText = wdAmountArea.getText();
      if (!currentText.isEmpty()) {
        // Remove the last character
        String newText = currentText.substring(0, currentText.length() - 1);
        wdAmountArea.setText(newText);
      }
    } else if (actionEvent.getSource() == sbCancelButton) {
      sbFrame.dispose();
    } else if (actionEvent.getSource() == sbBackButton) {
      sbFrame.dispose();
    }else if(actionEvent.getSource()==payPayButton){
      String receiverAcc = payNameField.getText();
      String amount = payAmountField.getText();
      String password = String.valueOf(payPasswordField.getPassword());
      int payment = -10;

      payment = backend.payment(receiverAcc, amount, password);

      if (payment == -3) {
        payMsgLabel.setText("Invalid input");
        payMsgLabel.setForeground(Color.RED);
        payAmountField.setText("");
        payNameField.setText("");
        payPasswordField.setText("");
      }else if(payment==-4){
         payMsgLabel.setText("Invalid password");
        payMsgLabel.setForeground(Color.RED);
        payAmountField.setText("");
        payNameField.setText("");
        payPasswordField.setText("");
      }else if(payment==-5){
         payMsgLabel.setText("Amount in under 10,000 " );
        payMsgLabel.setForeground(Color.RED);
        payAmountField.setText("");
        payNameField.setText("");
        payPasswordField.setText("");
      }else if(payment==-2){
         payMsgLabel.setText("Insufficient balance Min. bal: 1000 " );
        payMsgLabel.setForeground(Color.RED);
        payAmountField.setText("");
        payNameField.setText("");
        payPasswordField.setText("");
      }else if(payment==-1){
         payMsgLabel.setText("Receiver not found" );
        payMsgLabel.setForeground(Color.RED);
        payAmountField.setText("");
        payNameField.setText("");
        payPasswordField.setText("");
      }else if(payment==0){
         payMsgLabel.setText("Transaction Successful: Check Balanceus" );
        payMsgLabel.setForeground(Color.GREEN);
        payAmountField.setText("");
        payNameField.setText("");
        payPasswordField.setText("");
      }
    }
  }

  private void makePayment() {
    payFrame = new JFrame("Payment");
    payFrame.setSize(800, 450);
    payFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int centerX = (int) (this.getWidth() - payFrame.getWidth()) / 2;
    int centerY = (int) (this.getHeight() - payFrame.getHeight()) / 2;

    payFrame.setLocation(centerX, centerY);

    payBackgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon("Resources/images/user_back.jpg"); // Replace with your image path

          // Draw the image as the background
          g.drawImage(
            imageIcon.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            this
          );
        }
      };
    payBackgroundPanel.setLayout(new FlowLayout());

    headPanel = new JPanel();
    headPanel.setBounds(0, 0, 1500, 30);
    headPanel.setBackground(Color.DARK_GRAY);

    ImageIcon i1 = new ImageIcon("Resources/images/back.png");
    Image i1i = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    payBackButton = new JButton("Back", new ImageIcon(i1i));
    payBackButton.setBounds(5, 2, 100, 25);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    payBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));

    payRecNameLabel = new JLabel("Receiver Acc no.: ");
    payRecNameLabel.setBounds(50, 60, 300, 30);
    payRecNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));

    payAmountLabel = new JLabel("Amount: ");
    payAmountLabel.setBounds(50, 110, 300, 30);
    payAmountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));

    payPasswordLabel = new JLabel("Password: ");
    payPasswordLabel.setBounds(50, 160, 300, 30);
    payPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));

    payNameField = new JTextField();
    payNameField.addFocusListener(
      new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
          if (payNameField.getText().equals("Enter Account no. Here")) {
            payNameField.setText("");
            payNameField.setForeground(Color.BLACK); // Set text color to the default color
          }
        }

        @Override
        public void focusLost(FocusEvent e) {
          if (payNameField.getText().isEmpty()) {
            payNameField.setText("");
            payNameField.setForeground(Color.BLACK); // Set text color to the placeholder color
          }
        }
      }
    );
    payNameField.setBounds(380, 60, 350, 30);
    payNameField.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    payAmountField = new JTextField();
    payAmountField.addFocusListener(
      new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
          if (payAmountField.getText().equals("Enter Amount in Rs.")) {
            payAmountField.setText("");
            payAmountField.setForeground(Color.BLACK); // Set text color to the default color
          }
        }

        @Override
        public void focusLost(FocusEvent e) {
          if (payAmountField.getText().isEmpty()) {
            payAmountField.setText("");
            payAmountField.setForeground(Color.BLACK); // Set text color to the placeholder color
          }
        }
      }
    );
    payAmountField.setBounds(380, 110, 350, 30);
    payAmountField.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    payPasswordField = new JPasswordField();
    payPasswordField.setBounds(380, 160, 350, 30);
    payPasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    payMsgLabel = new JLabel("");
    payMsgLabel.setBounds(350, 200, 300, 20);
    payMsgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));

    payPayButton = new JButton("PAY");
    payPayButton.setBounds(50, 230, 300, 40);
    payPayButton.setBackground(Color.GREEN);
    payPayButton.setForeground(Color.WHITE);
    payPayButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

    payCancelButton = new JButton("CANCEL");
    payCancelButton.setBounds(430, 230, 300, 40);
    payCancelButton.setBackground(Color.RED);
    payCancelButton.setForeground(Color.WHITE);
    payCancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    payBackButton.addActionListener(this);
    payCancelButton.addActionListener(this);
    payPayButton.addActionListener(this);

    payFrame.add(payRecNameLabel);
    payFrame.add(payAmountLabel);
    payFrame.add(payPasswordLabel);
    payFrame.add(payNameField);
    payFrame.add(payAmountField);
    payFrame.add(payPasswordField);
    payFrame.add(payMsgLabel);
    payFrame.add(payPayButton);
    payFrame.add(payCancelButton);
    payFrame.add(payBackButton);
    payFrame.add(headPanel);
    payFrame.add(payBackgroundPanel);

    payFrame.setVisible(true);
  }

  private void Deposit() {
    JFrame depositFrame = new JFrame("Deposit");
    depositFrame.setSize(500, 500);
    depositFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int centerX = (int) (this.getWidth() - depositFrame.getWidth()) / 2;
    int centerY = (int) (this.getHeight() - depositFrame.getHeight()) / 2;

    depositFrame.setLocation(centerX, centerY);

    depositBackgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon("Resources/images/user_back.jpg"); // Replace with your image path

          // Draw the image as the background
          g.drawImage(
            imageIcon.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            this
          );
        }
      };
    depositBackgroundPanel.setLayout(new FlowLayout());

    depositHeadPanel = new JPanel();
    depositHeadPanel.setBounds(0, 0, 1500, 30);
    depositHeadPanel.setBackground(Color.DARK_GRAY);

    ImageIcon i1 = new ImageIcon("Resources/images/back.png");
    Image i1i = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    depositBackButton = new JButton("Back", new ImageIcon(i1i));
    depositBackButton.setBounds(5, 2, 100, 25);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    depositBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));

    depositNameLabel = new JLabel("Deposit To : ");
    depositNameLabel.setBounds(50, 60, 150, 30);
    depositNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    depositAmountLabel = new JLabel("Amount in Rs. : ");
    depositAmountLabel.setBounds(50, 120, 150, 30);
    depositAmountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    depositNameField = new JTextField("");
    depositNameField.setBounds(220, 60, 250, 30);
    depositNameField.setEditable(false);

    depositAmountField = new JTextField();
    depositAmountField.addFocusListener(
      new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
          if (depositAmountField.getText().equals("Enter Amount in Rs.")) {
            depositAmountField.setText("");
            depositAmountField.setForeground(Color.BLACK); // Set text color to the default color
          }
        }

        @Override
        public void focusLost(FocusEvent e) {
          if (depositAmountField.getText().isEmpty()) {
            depositAmountField.setText("");
            depositAmountField.setForeground(Color.BLACK); // Set text color to the placeholder color
          }
        }
      }
    );
    depositAmountField.setBounds(220, 120, 250, 30);
    depositAmountField.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    depositButton = new JButton("PAY");
    depositButton.setBounds(100, 170, 300, 40);
    depositButton.setBackground(Color.BLUE);
    depositButton.setForeground(Color.WHITE);
    depositButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

    depositCancelButton = new JButton("CANCEL");
    depositCancelButton.setBounds(100, 230, 300, 40);
    depositCancelButton.setBackground(Color.RED);
    depositCancelButton.setForeground(Color.WHITE);
    depositCancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    depositFrame.add(depositAmountLabel);
    depositFrame.add(depositNameLabel);
    depositFrame.add(depositNameField);
    depositFrame.add(depositAmountField);

    depositFrame.add(depositButton);
    depositFrame.add(depositCancelButton);
    depositFrame.add(depositBackButton);
    depositFrame.add(depositHeadPanel);
    depositFrame.add(depositBackgroundPanel);

    depositFrame.setVisible(true);
  }

  private void Withdraw() {
    JFrame wdFrame = new JFrame("Withdraw");
    wdFrame.setSize(600, 600);
    wdFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int centerX = (int) (this.getWidth() - wdFrame.getWidth()) / 2;
    int centerY = (int) (this.getHeight() - wdFrame.getHeight()) / 2;

    wdFrame.setLocation(centerX, centerY);

    wdBackgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon("Resources/images/user_back.jpg"); // Replace with your image path

          // Draw the image as the background
          g.drawImage(
            imageIcon.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            this
          );
        }
      };
    wdBackgroundPanel.setLayout(new FlowLayout());

    wdHeadPanel = new JPanel();
    wdHeadPanel.setBounds(0, 0, 1500, 30);
    wdHeadPanel.setBackground(Color.DARK_GRAY);

    ImageIcon i1 = new ImageIcon("Resources/images/back.png");
    Image i1i = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    wdBackButton = new JButton("Back", new ImageIcon(i1i));
    wdBackButton.setBounds(5, 2, 100, 25);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    wdBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));

    wdAmountLabel = new JLabel("Amount in Rs. : ");
    wdAmountLabel.setBounds(50, 60, 150, 30);
    wdAmountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    wdAmountArea = new JTextArea();
    wdAmountArea.setBounds(220, 60, 355, 40);
    wdAmountArea.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    one = new JButton("1");
    one.setBackground(Color.BLACK);
    one.setBounds(220, 110, 100, 35);
    one.setForeground(Color.WHITE);

    two = new JButton("2");
    two.setBackground(Color.BLACK);
    two.setBounds(330, 110, 100, 35);
    two.setForeground(Color.WHITE);

    three = new JButton("3");
    three.setBackground(Color.BLACK);
    three.setBounds(440, 110, 100, 35);
    three.setForeground(Color.WHITE);

    four = new JButton("4");
    four.setBackground(Color.BLACK);
    four.setBounds(220, 150, 100, 35);
    four.setForeground(Color.WHITE);

    five = new JButton("5");
    five.setBackground(Color.BLACK);
    five.setBounds(330, 150, 100, 35);
    five.setForeground(Color.WHITE);

    six = new JButton("6");
    six.setBackground(Color.BLACK);
    six.setBounds(440, 150, 100, 35);
    six.setForeground(Color.WHITE);

    seven = new JButton("7");
    seven.setBackground(Color.BLACK);
    seven.setBounds(220, 190, 100, 35);
    seven.setForeground(Color.WHITE);

    eight = new JButton("8");
    eight.setBackground(Color.BLACK);
    eight.setBounds(330, 190, 100, 35);
    eight.setForeground(Color.WHITE);

    nine = new JButton("9");
    nine.setBackground(Color.BLACK);
    nine.setBounds(440, 190, 100, 35);
    nine.setForeground(Color.WHITE);

    star = new JButton("*");
    star.setBackground(Color.BLACK);
    star.setBounds(220, 230, 100, 35);
    star.setForeground(Color.WHITE);

    zero = new JButton("0");
    zero.setBackground(Color.BLACK);
    zero.setBounds(330, 230, 100, 35);
    zero.setForeground(Color.WHITE);

    hash = new JButton("#");
    hash.setBackground(Color.BLACK);
    hash.setBounds(440, 230, 100, 35);
    hash.setForeground(Color.WHITE);

    wdClear = new JButton("<-");
    wdClear.setBounds(550, 110, 30, 155);

    wdWithdrawButton = new JButton("Withdraw");
    wdWithdrawButton.setBounds(200, 305, 240, 40);
    wdWithdrawButton.setBackground(Color.ORANGE);
    wdWithdrawButton.setForeground(Color.WHITE);
    wdWithdrawButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

    wdCancelButton = new JButton("Cancel");
    wdCancelButton.setBounds(200, 365, 240, 40);
    wdCancelButton.setBackground(Color.RED);
    wdCancelButton.setForeground(Color.WHITE);
    wdCancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    one.addActionListener(this);
    two.addActionListener(this);
    three.addActionListener(this);
    four.addActionListener(this);
    five.addActionListener(this);
    six.addActionListener(this);
    seven.addActionListener(this);
    eight.addActionListener(this);
    nine.addActionListener(this);
    zero.addActionListener(this);
    star.addActionListener(this);
    hash.addActionListener(this);
    wdClear.addActionListener(this);

    wdFrame.add(wdAmountArea);
    wdFrame.add(wdAmountLabel);
    wdFrame.add(one);
    wdFrame.add(two);
    wdFrame.add(three);
    wdFrame.add(four);
    wdFrame.add(five);
    wdFrame.add(six);
    wdFrame.add(seven);
    wdFrame.add(eight);
    wdFrame.add(nine);
    wdFrame.add(star);
    wdFrame.add(zero);
    wdFrame.add(hash);
    wdFrame.add(wdClear);

    wdFrame.add(wdWithdrawButton);
    wdFrame.add(wdCancelButton);
    wdFrame.add(wdBackButton);
    wdFrame.add(wdHeadPanel);
    wdFrame.add(wdBackgroundPanel);

    wdFrame.setVisible(true);
  }

  private void showBalance() {
    sbFrame = new JFrame("Balance");
    sbFrame.setSize(300, 300);
    sbFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int centerX = (int) (this.getWidth() - sbFrame.getWidth()) / 2;
    int centerY = (int) (this.getHeight() - sbFrame.getHeight()) / 2;

    sbFrame.setLocation(centerX, centerY);

    sbBackgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon("Resources/images/user_back.jpg"); // Replace with your image path

          // Draw the image as the background
          g.drawImage(
            imageIcon.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            this
          );
        }
      };
    sbBackgroundPanel.setLayout(new FlowLayout());

    sbHeadPanel = new JPanel();
    sbHeadPanel.setBounds(0, 0, 1500, 30);
    sbHeadPanel.setBackground(Color.DARK_GRAY);

    ImageIcon i1 = new ImageIcon("Resources/images/back.png");
    Image i1i = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    sbBackButton = new JButton("Back", new ImageIcon(i1i));
    sbBackButton.setBounds(5, 2, 100, 25);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    sbBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));

    sbAccLabel = new JLabel("Account no.: ");
    sbAccLabel.setBounds(20, 50, 130, 30);
    sbAccLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    sbBalLabel = new JLabel("Balance : ");
    sbBalLabel.setBounds(20, 100, 130, 30);
    sbBalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));

    sbDisAccLabel = new JLabel(backend.getAccountNumber());
    sbDisAccLabel.setBounds(150, 50, 125, 30);
    sbDisAccLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    sbDisAccLabel.setBackground(Color.WHITE);
    sbDisAccLabel.setOpaque(true);

    sbDisBalLabel = new JLabel(backend.getBalance());
    sbDisBalLabel.setBounds(150, 100, 125, 30);
    sbDisBalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    sbDisBalLabel.setBackground(Color.WHITE);
    sbDisBalLabel.setOpaque(true);

    sbMsgLabel = new JLabel("Successfully fetched");
    sbMsgLabel.setBounds(80, 140, 270, 30);
    sbMsgLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    sbMsgLabel.setForeground(Color.GREEN);

    sbCancelButton = new JButton("Cancel");
    sbCancelButton.setBounds(70, 180, 170, 40);
    sbCancelButton.setBackground(Color.RED);
    sbCancelButton.setForeground(Color.WHITE);
    sbDisBalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

    sbCancelButton.addActionListener(this);

    sbBackButton.addActionListener(this);

    sbFrame.add(sbBackButton);
    sbFrame.add(sbAccLabel);
    sbFrame.add(sbBalLabel);
    sbFrame.add(sbDisAccLabel);
    sbFrame.add(sbDisBalLabel);
    sbFrame.add(sbCancelButton);
    sbFrame.add(sbMsgLabel);
    sbFrame.add(sbHeadPanel);
    sbFrame.add(sbBackgroundPanel);
    sbFrame.setVisible(true);
  }

  private void showAcc() {
    JFrame saFrame = new JFrame("Account Details");
    // JFrame saFrame = new JFrame("Balance");
    saFrame.setSize(600, 600);
    saFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int centerX = (int) (this.getWidth() - saFrame.getWidth()) / 2;
    int centerY = (int) (this.getHeight() - saFrame.getHeight()) / 2;

    saFrame.setLocation(centerX, centerY);
    saBackgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon("Resources/images/user_back.jpg"); // Replace with your image path

          // Draw the image as the background
          g.drawImage(
            imageIcon.getImage(),
            0,
            0,
            getWidth(),
            getHeight(),
            this
          );
        }
      };
    saBackgroundPanel.setLayout(new FlowLayout());

    saHeadPanel = new JPanel();
    saHeadPanel.setBounds(0, 0, 1500, 30);
    saHeadPanel.setBackground(Color.DARK_GRAY);

    ImageIcon i1 = new ImageIcon("Resources/images/back.png");
    Image i1i = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    saBackButton = new JButton("Back", new ImageIcon(i1i));
    saBackButton.setBounds(5, 2, 100, 25);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    saBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));

    model =
      new DefaultTableModel(
        new Object[][] {
          { "1", "Alice", "25" },
          { "2", "Bob", "30" },
          { "3", "Charlie", "22" },
          { "4", "David", "35" },
          { "5", "Eve", "28" },
          { "6", "Frank", "29" },
          { "7", "Grace", "31" },
          { "8", "Hannah", "26" },
          { "9", "Ivy", "27" },
          { "10", "Jack", "33" },
          { "1", "Alice", "25" },
          { "2", "Bob", "30" },
          { "3", "Charlie", "22" },
          { "4", "David", "35" },
          { "5", "Eve", "28" },
          { "6", "Frank", "29" },
          { "7", "Grace", "31" },
          { "8", "Hannah", "26" },
          { "9", "Ivy", "27" },
          { "10", "Jack", "33" },
          { "1", "Alice", "25" },
          { "2", "Bob", "30" },
          { "3", "Charlie", "22" },
          { "4", "David", "35" },
          { "5", "Eve", "28" },
          { "6", "Frank", "29" },
          { "7", "Grace", "31" },
          { "8", "Hannah", "26" },
          { "9", "Ivy", "27" },
          { "10564654", "Jack", "33" },
          // Add more rows here...
        },
        new Object[] { "ID", "Name", "Age" }
      );
    // model.addRow(new Object[] { "ajdflj", "sajfj", "djsfkjaskd;ldf" });
    // model.addRow(new Object[] { "jdsfljasdl;", "0rtuiq", "lksjdflkasdj" });

    // model.addColumn("col1");
    // model.addColumn("Col2");
    // model.addColumn("col3");

    saTable = new JTable(model);
    saTable.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    saTable.setEnabled(false);
    JScrollPane scrollPane = new JScrollPane(saTable);
    scrollPane.setBounds(100, 120, 400, 400);

    // saExportButton = new JButton("Download");
    // saExportButton.setBounds(400, 5, 130, 30);
    // saExportButton.setBackground(Color.GREEN);
    // saExportButton.setForeground(Color.WHITE);

    // saExportButton.addActionListener(
    //   new ActionListener() {
    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //       exportTableToPDF(saTable);
    //     }
    //   }
    // );
    JLabel headingLabel = new JLabel("Account Details");
    headingLabel.setBounds(220, 60, 200, 40);
    headingLabel.setForeground(Color.BLACK);
    headingLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

    saFrame.add(scrollPane);
    saFrame.add(headingLabel);
    saFrame.add(saBackButton);
    // saFrame.add(saExportButton);
    saFrame.add(saHeadPanel);
    saFrame.add(saBackgroundPanel);
    saFrame.setVisible(true);
  }

  // private static void exportTableToPDF(JTable table) {
  //   try (PDDocument document = new PDDocument()) {
  //     PDPage page = new PDPage(PDRectangle.A4);
  //     document.addPage(page);

  //     try (
  //       PDPageContentStream contentStream = new PDPageContentStream(
  //         document,
  //         page
  //       )
  //     ) {
  //       int margin = 50;
  //       int yStart = (int) page.getMediaBox().getHeight() - margin;
  //       int tableWidth = (int) page.getMediaBox().getWidth() - 2 * margin;
  //       float yPosition = yStart;
  //       int rowsPerPage = 10;
  //       int rows = table.getRowCount();
  //       int cols = table.getColumnCount();
  //       int fontSize = 12;
  //       File fontFile = new File(
  //         "C:\\Users\\HITS\\Desktop\\Banking Project\\Banking-System\\montserrat-font\\MontserratBoldItalic-4B3w9.ttf"
  //       );
  //       PDType0Font font = PDType0Font.load(document, fontFile);

  //       float tableHeight = 20f; // Adjust as needed

  //       // Create the table headers
  //       contentStream.setFont(font, fontSize);
  //       contentStream.setLineWidth(1f);
  //       contentStream.setNonStrokingColor(Color.BLACK);

  //       float marginX = margin;
  //       for (int i = 0; i < cols; i++) {
  //         contentStream.beginText();
  //         contentStream.newLineAtOffset(marginX, yPosition - tableHeight);
  //         contentStream.showText(table.getColumnName(i));
  //         contentStream.endText();
  //         marginX += tableWidth / cols;
  //       }

  //       yPosition -= tableHeight;

  //       // Create the table content
  //       contentStream.setFont(font, fontSize);
  //       contentStream.setLineWidth(1f);
  //       for (int i = 0; i < Math.min(rows, rowsPerPage); i++) {
  //         yPosition -= tableHeight;
  //         contentStream.addRect(margin, yPosition, tableWidth, tableHeight);
  //         contentStream.stroke();

  //         marginX = margin;
  //         for (int j = 0; j < cols; j++) {
  //             String cellValue = (table.getValueAt(i, j) != null) ? table.getValueAt(i, j).toString() : "";
  //             contentStream.beginText();
  //             contentStream.newLineAtOffset(marginX, yPosition - (tableHeight / 2));
  //             contentStream.showText(cellValue);
  //             contentStream.endText();
  //             marginX += tableWidth / cols;
  //         }
  //     }

  //       // for (int i = 0; i < Math.min(rows, rowsPerPage); i++) {
  //         // yPosition -= tableHeight;
  //         // contentStream.addRect(margin, yPosition, tableWidth, tableHeight);
  //         // contentStream.stroke();

  //         // marginX = margin;
  //         // for (int j = 0; j < cols; j++) {
  //           // contentStream.beginText();
  //           // contentStream.newLineAtOffset(
  //             // marginX,
  //             // yPosition - (tableHeight / 2)
  //           // );
  //           // contentStream.showText(table.getValueAt(i, j).toString());
  //           // contentStream.endText();
  //           // marginX += tableWidth / cols;
  //         // }
  //       // }

  //       contentStream.close();
  //       String fileName = "table.pdf";
  //       try {
  //         document.save(new File(fileName));
  //         JOptionPane.showMessageDialog(null, "Table exported to " + fileName);
  //     } catch (IOException e) {
  //         e.printStackTrace();
  //         JOptionPane.showMessageDialog(null, "Error while saving PDF.");
  //     }
  //       document.save(new FileOutputStream(fileName));
  //       document.close();
  //       JOptionPane.showMessageDialog(null, "Table exported to " + fileName);
  //     } catch (IOException e) {
  //       // e.printStackTrace();
  //       e.printStackTrace();
  //           JOptionPane.showMessageDialog(null, "Error while saving PDF.");

  //     }
  //   } catch (IOException e) {
  //     // e.printStackTrace();
  //     e.printStackTrace();
  //           JOptionPane.showMessageDialog(null, "Error while saving PDF.");
  //   }
  // }

  // private JFrame frame;
  // private JTable table;
  // private DefaultTableModel tableModel;
  // private JButton prevButton;
  // private JButton nextButton;
  // private int currentPage = 1;
  // private int pageSize = 10;
  // private Object[][] data;  // Your data source

  // public void TablePaginationApp() {
  //     // Initialize your data here (e.g., from a database or a list)
  //     // Example data initialization:
  //     data = new Object[][]{
  //             {"Row 1", "Data 1"},
  //             {"Row 2", "Data 2"},
  //             {"Row 2", "Data 3"},
  //             {"Row 2", "Data 4"},
  //             {"Row 2", "Data 5"},
  //             {"Row 2", "Data 6"},
  //             {"Row 2", "Data 7"},
  //             {"Row 2", "Data 8"},
  //             {"Row 2", "Data 9"},
  //             {"Row 2", "Data 10"},
  //             {"Row 2", "Data 11"},
  //             {"Row 2", "Data 12"},
  //             {"Row 2", "Data 13"},
  //             {"Row 2", "Data 14"},
  //             {"Row 2", "Data 15"},
  //             {"Row 2", "Data 16"},
  //             {"Row 2", "Data 17"},
  //             {"Row 2", "Data 18"},
  //             {"Row 2", "Data 19"},
  //             {"Row 2", "Data 20"},
  //             {"Row 2", "Data 21"},
  //             {"Row 2", "Data 22"},
  //             {"Row 2", "Data 2"},

  //              {"Row 1", "Data 1"},
  //             {"Row 2", "Data 2"},
  //             {"Row 2", "Data 3"},
  //             {"Row 2", "Data 4"},
  //             {"Row 2", "Data 5"},
  //             {"Row 2", "Data 6"},
  //             {"Row 2", "Data 7"},
  //             {"Row 2", "Data 8"},
  //             {"Row 2", "Data 9"},
  //             {"Row 2", "Data 10"},
  //             {"Row 2", "Data 11"},
  //             {"Row 2", "Data 12"},
  //             {"Row 2", "Data 13"},
  //             {"Row 2", "Data 14"},
  //             {"Row 2", "Data 15"},
  //             {"Row 2", "Data 16"},
  //             {"Row 2", "Data 17"},
  //             {"Row 2", "Data 18"},
  //             {"Row 2", "Data 19"},
  //             {"Row 2", "Data 20"},
  //             {"Row 2", "Data 21"},
  //             {"Row 2", "Data 22"},
  //             {"Row 2", "Data 2"},
  //             // Add more rows as needed
  //     };

  //     frame = new JFrame("Table Pagination Example");
  //     frame.setLayout(new BorderLayout());
  //     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  //     tableModel = new DefaultTableModel(data, new String[]{"Column 1", "Column 2"});
  //     table = new JTable(tableModel);
  //     JScrollPane scrollPane = new JScrollPane(table);

  //     prevButton = new JButton("Previous");
  //     nextButton = new JButton("Next");

  //     JPanel buttonPanel = new JPanel();
  //     buttonPanel.add(prevButton);
  //     buttonPanel.add(nextButton);

  //     frame.add(scrollPane, BorderLayout.CENTER);
  //     frame.add(buttonPanel, BorderLayout.SOUTH);

  //     prevButton.addActionListener(new ActionListener() {
  //         @Override
  //         public void actionPerformed(ActionEvent e) {
  //             showPreviousPage();
  //         }
  //     });

  //     nextButton.addActionListener(new ActionListener() {
  //         @Override
  //         public void actionPerformed(ActionEvent e) {
  //             showNextPage();
  //         }
  //     });

  //     frame.pack();
  //     frame.setVisible(true);
  // }

  // private void showPreviousPage() {
  //     if (currentPage > 0) {
  //         currentPage--;
  //         updateTableData();
  //     }
  // }

  // private void showNextPage() {
  //     if (currentPage < (data.length - pageSize)) {
  //         currentPage++;
  //         updateTableData();
  //     }
  // }

  // private void updateTableData() {
  //     int startIndex = currentPage * pageSize;
  //     int endIndex = Math.min(startIndex + pageSize, data.length);
  //     Object[][] newData = new Object[endIndex - startIndex][tableModel.getColumnCount()];

  //     for (int i = startIndex; i < endIndex; i++) {
  //         newData[i - startIndex] = data[i];
  //     }

  //     tableModel.setDataVector(newData, new String[]{"Column 1", "Column 2"});
  // }

  // public static void main(String[] args) {
  //
  // }

  public static void main(String args[]) {
    // new UserHome().setVisible(true);
  }
}
