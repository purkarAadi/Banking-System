package com.ami.tech.fl;

import com.ami.tech.bl.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Home extends JFrame implements ActionListener {

  JButton button1, button2, button3, button4, button5;
  JButton loginButton, createButton;
  JPanel backgroundPanel, loginPanel;
  JTextField textField;
  JPasswordField passwordField;
  JLabel label1, label2, msgLabel;
  Backend backend = new Backend();

  Home() {
    setTitle("Home");
    setSize(1200, 700);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int centerX = (int) (screenSize.getWidth() - this.getWidth()) / 2;
    int centerY = (int) (screenSize.getHeight() - this.getHeight()) / 2;

    // Set the frame's location to the center of the screen
    this.setLocation(centerX, centerY);

    // ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("./images/Home_background.jpg"));
    // Image image=imageIcon.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
    // label1=new JLabel(imageIcon);
    // label1.setBounds(0,0,1200, 700);
    // add(label1);
    // setLayout(new BorderLayout());

    // Create a JPanel to hold the background image
    backgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon("Resources/Home_background.jpg"); // Replace with your image path

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

    // Set the layout manager to null to position components manually
    backgroundPanel.setLayout(null);

    // Add components to the backgroundPanel or customize as needed
    // For example, you can add buttons, labels, etc.
    // Example: backgroundPanel.add(new JButton("Click Me"));

    ImageIcon i2 = new ImageIcon("Resources/create_account.png");
    Image i2i = i2.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT);
    button1 = new JButton("Create Account", new ImageIcon(i2i));
    button1.setBounds(10, 10, getWidth() / 4, 40);
    button1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    // button1.setBackground(Color.LIGHT_GRAY);

    ImageIcon i3 = new ImageIcon("Resources/payment.jpg");
    Image i3i = i3.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT);
    button2 = new JButton("Payment", new ImageIcon(i3i));
    button2.setBounds(270, 10, getWidth() / 4, 40);
    button2.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i4 = new ImageIcon("Resources/deposit.png");
    Image i4i = i4.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT);
    button3 = new JButton("Deposit", new ImageIcon(i4i));
    button3.setBounds(530, 10, getWidth() / 4, 40);
    button3.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i5 = new ImageIcon("Resources/withdraw.jpg");
    Image i5i = i5.getImage().getScaledInstance(30, 20, Image.SCALE_DEFAULT);
    button4 = new JButton("Withdraw", new ImageIcon(i5i));
    button4.setBounds(790, 10, getWidth() / 4, 40);
    button4.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    loginPanel = new JPanel();
    loginPanel.setBackground(Color.WHITE);
    loginPanel.setBounds(25, 100, 400, 450);
    loginPanel.setBorder(new DropShadowBorder());

    label1 = new JLabel("Enter ID or Account Number here :");
    label1.setBounds(60, 110, 298, 40);
    label1.setFont(new Font("Times New Roman", Font.BOLD, 20));

    textField = new JTextField("Enter Text Here");
    textField.setBackground(Color.LIGHT_GRAY);
    textField.setBounds(60, 170, 320, 40);
    textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    textField.addFocusListener(
      new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
          if (textField.getText().equals("Enter Text Here")) {
            textField.setText("");
            textField.setForeground(Color.BLACK); // Set text color to the default color
          }
        }

        @Override
        public void focusLost(FocusEvent e) {
          if (textField.getText().isEmpty()) {
            textField.setText("");
            textField.setForeground(Color.BLACK); // Set text color to the placeholder color
          }
        }
      }
    );

    label2 = new JLabel("Enter Password");
    label2.setBounds(60, 230, 298, 40);
    label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
    passwordField = new JPasswordField();
    passwordField.setBounds(60, 290, 320, 40);
    passwordField.setBackground(Color.LIGHT_GRAY);

    msgLabel = new JLabel("");
    msgLabel.setBounds(130, 330, 310, 30);
    msgLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));

    loginButton = new JButton("Login");
    loginButton.setBounds(80, 370, 250, 50);
    loginButton.setBackground(Color.BLUE);
    loginButton.setForeground(Color.WHITE);
    loginButton.setFont(new Font("Times New Roman", Font.BOLD, 22));

    createButton = new JButton("Create Account");
    createButton.setBounds(80, 440, 250, 50);
    createButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
    createButton.setBackground(Color.GREEN);
    createButton.setForeground(Color.WHITE);

    button1.addActionListener(this);
    button2.addActionListener(this);
    button3.addActionListener(this);
    button4.addActionListener(this);

    loginButton.addActionListener(this);
    createButton.addActionListener(this);

    add(label1);
    add(textField);
    add(label2);
    add(passwordField);
    add(msgLabel);
    add(loginButton);
    add(createButton);
    add(button1);
    add(button2);
    add(button3);
    add(button4);
    add(loginPanel);

    // Add the backgroundPanel to the JFrame
    add(backgroundPanel);
    // Set the size of the frame (width, height)

  }

  public void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getSource() == loginButton) {
      String id = textField.getText();
      String password = passwordField.getText();
      int validity=-10;
      validity = backend.backendLogin(id, password);
      if (validity == 0) {
        msgLabel.setText("Logged in as Admin");
        msgLabel.setForeground(Color.GREEN);
         textField.setText("");
        passwordField.setText("");
        this.setVisible(false);
        new AdminHome(backend).setVisible(true);
      } else if(validity==1) {
        msgLabel.setText("Logged in as User");
        msgLabel.setForeground(Color.GREEN);
        textField.setText("");
        passwordField.setText("");
        this.setVisible(false);
        new UserHome(backend).setVisible(true);
      }else if(validity==-1){
        msgLabel.setText("Invalid Id - Password");
        msgLabel.setForeground(Color.RED);
        textField.setText("");
        passwordField.setText("");
      }else if(validity==-2){
         msgLabel.setText("User not found");
        msgLabel.setForeground(Color.RED);
        textField.setText("");
        passwordField.setText("");
      }
      
      // if(textField.getText().length()==0 && passwordField.getText().length()==0)msgLabel.setText("");

    } else if (actionEvent.getSource() == createButton) {
      this.setVisible(false);
      new CreateAccount().setVisible(true);
    } else if (actionEvent.getSource() == button1) {
      this.setVisible(false);
      new CreateAccount().setVisible(true);
    } else if (actionEvent.getSource() == button2) {
      this.setVisible(false);
      new Login(backend).setVisible(true);
    } else if (actionEvent.getSource() == button3) {
      this.setVisible(false);
      new Login(backend).setVisible(true);
    } else if (actionEvent.getSource() == button4) {
      this.setVisible(false);
      new Login(backend).setVisible(true);
    }
  }

  public static void main(String[] args) {
    new Home().setVisible(true);
  }
  // private static void autoSizeTextField(JTextField textField) {
  //   // Get the preferred size based on the current text and font
  //   Dimension preferredSize = textField.getPreferredSize();

  //   // Set the size of the text field to its preferred size
  //   textField.setSize(preferredSize);

  //   // Set the maximum size to prevent automatic resizing
  //   textField.setMaximumSize(preferredSize);

  //   // Make sure the text field doesn't grow horizontally
  //   textField.setHorizontalAlignment(JTextField.LEFT);
  // }
}

class DropShadowBorder implements Border {

  private static final int SHADOW_SIZE = 5;
  private static final Color SHADOW_COLOR = new Color(0, 0, 0, 50);

  @Override
  public void paintBorder(
    Component c,
    Graphics g,
    int x,
    int y,
    int width,
    int height
  ) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(SHADOW_COLOR);

    // Draw the top shadow
    g2d.fillRect(x, y, width, SHADOW_SIZE);

    // Draw the left shadow
    g2d.fillRect(x, y, SHADOW_SIZE, height);

    // Draw the right shadow
    g2d.fillRect(x + width - SHADOW_SIZE, y, SHADOW_SIZE, height);

    // Draw the bottom shadow
    g2d.fillRect(x, y + height - SHADOW_SIZE, width, SHADOW_SIZE);
  }

  @Override
  public Insets getBorderInsets(Component c) {
    return new Insets(SHADOW_SIZE, SHADOW_SIZE, SHADOW_SIZE, SHADOW_SIZE);
  }

  @Override
  public boolean isBorderOpaque() {
    return false;
  }
}
