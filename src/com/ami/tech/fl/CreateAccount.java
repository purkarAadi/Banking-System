package com.ami.tech.fl;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CreateAccount extends JFrame {

  JPanel backgroundPanel, headPanel, createPanel;
  JButton backButton, loginButton, createButton;
  JLabel typeLabel, nameLabel, aadharLabel, addressLabel, designationLabel, amountLabel;
  Choice choice;
  JTextField nameField, aadharField,  designationField, amountField;
  JTextArea addressArea;

  CreateAccount() {
    setTitle("Create Account");
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
    // setLayout(new BorderLayout());6

    // Create a JPanel to hold the background image
    backgroundPanel =
      new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load your image
          ImageIcon imageIcon = new ImageIcon(
            "Resources/images/create_acc.jpg"
          ); // Replace with your image path

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

    headPanel = new JPanel();
    headPanel.setBounds(0, 0, 1500, 40);
    headPanel.setBackground(Color.LIGHT_GRAY);

    ImageIcon i7 = new ImageIcon("Resources/images/back.png");
    Image i8 = i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);

    backButton = new JButton("Back", new ImageIcon(i8));
    backButton.setBounds(5, 2, 100, 30);

    ImageIcon i2 = new ImageIcon("Resources/images/create_logo.png");
    Image i2i = i2.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
    JLabel imgLabel = new JLabel(new ImageIcon(i2i));
    imgLabel.setBounds(700, 100, 400, 400);

    loginButton = new JButton("Login");
    loginButton.setBackground(Color.BLUE);
    loginButton.setForeground(Color.WHITE);
    loginButton.setBounds(1070, 5, 100, 30);

    createPanel = new JPanel();
    createPanel.setBackground(Color.LIGHT_GRAY);
    createPanel.setBounds(50, 70, 600, 550);

    typeLabel = new JLabel("Type");
    typeLabel.setBounds(80, 100, 100, 30);

    choice = new Choice();
    choice.add("Admin");
    choice.add("User");
    choice.setBounds(200, 100, 100, 30);

    nameLabel = new JLabel("Name : ");
    nameLabel.setBounds(80, 140, 100, 40);

    nameField = new JTextField();
    nameField.setBounds(200, 140, 400, 40);

    aadharLabel = new JLabel("Aadhar no.");
    aadharLabel.setBounds(80, 190, 100, 40);

    aadharField = new JTextField();
    aadharField.setBounds(200, 190, 400, 40);

    designationLabel = new JLabel("Designation : ");
    designationLabel.setBounds(80, 240, 100, 40);

    designationField = new JTextField();
    designationField.setBounds(200, 240, 400, 40);

    
    amountLabel=new JLabel("Amount: ");
amountLabel.setBounds(80, 290, 100, 40);
    
amountField=new JTextField();
 amountField.setBounds(200, 290, 400, 40);
    
    addressLabel = new JLabel("Designation : ");
    addressLabel.setBounds(80, 340, 100, 40);


    addressArea = new JTextArea();
    // addressArea.setBounds(200, 300, 400, 60);

    addressArea.setLineWrap(true);
    addressArea.setWrapStyleWord(true);
    
    JScrollPane scrollPane = new JScrollPane(addressArea);
      scrollPane.setBounds(200, 340, 400, 80);


      createButton=new JButton("Create");
      createButton.setBounds(300,500 , 120, 40);
      createButton.setBackground(Color.GREEN);
      createButton.setForeground(Color.WHITE);





      //  add(addressArea);
      add(createButton);
    add(scrollPane);
    add(nameLabel);
    add(nameField);
    add(typeLabel);
    add(choice);
    add(aadharField);
    add(aadharLabel);
    add(addressLabel);
   
    add(designationLabel);
    add(designationField);
    add(amountField);
    add(amountLabel);
    add(backButton);
    add(loginButton);
    add(createPanel);
    add(headPanel);
    add(imgLabel);
    add(backgroundPanel);
  }

  public static void main(String[] args) {
    new CreateAccount().setVisible(true);
  }
}
