package com.ami.tech.fl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ami.tech.bl.Backend;

public class AdminHome extends JFrame implements ActionListener{
  Backend backend;
  JPanel backgroundPanel, detailPanel, panel1;
  JLabel imgLabel, nameLabel, designationLabel, userLabel;
  JLabel disname, disdesignatin, disuser;
  JButton button1, button2, button3, backButton, logoutButton;


  //show acc variables
  JTable saTable;
  DefaultTableModel model;
  JPanel saBackgroundPanel, saHeadPanel;
  JButton saBackButton, saExportButton;


  //Remove Acc variables
  JLabel raAccLabel;
  JTextField raAccField;
  JButton delButton, raBackButton;
  JPanel raBackgroundPanel, raHeadPanel;


  //search acc variable
  JPanel searchBackgroundPanel, searchHeadPanel;
  JLabel searchAccLabel;
  JTextField searchAccField;
  JButton searchButton, searchBackButton ;
  AdminHome(Backend backend) {
    super("Admin");
    this.backend=backend;
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
          ImageIcon imageIcon = new ImageIcon(
            "Resources/images/admin_back.jpg"
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

    ImageIcon i1 = new ImageIcon("Resources/images/create_account.png");
    Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button1 = new JButton("Create new Account", new ImageIcon(i2));
    button1.setBounds(40, 90, 300, 50);
    button1.setBackground(Color.GREEN);
    button1.setForeground(Color.WHITE);
    button1.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i3 = new ImageIcon("Resources/images/admin_remove.png");
    Image i4 = i3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button2 = new JButton("Remove Account", new ImageIcon(i4));
    button2.setBounds(40, 170, 300, 50);
    button2.setBackground(Color.RED);
    button2.setForeground(Color.WHITE);
    button2.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    ImageIcon i5 = new ImageIcon("Resources/images/admin_accd.jpg");
    Image i6 = i5.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    button3 = new JButton("Account Details", new ImageIcon(i6));
    button3.setBounds(40, 240, 300, 50);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    button3.setFont(new Font("Times New Roman", Font.PLAIN, 18));

       ImageIcon i9 = new ImageIcon("Resources/images/logout.jpg");
    Image i10 = i9.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    logoutButton = new JButton("Log out", new ImageIcon(i10));
    logoutButton.setBounds(1000, 2, 175, 30);
    logoutButton.setBackground(Color.RED);
    logoutButton.setForeground(Color.WHITE);
    logoutButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));



    detailPanel = new JPanel();
    detailPanel.setBounds(500, 90, 600, 300);
    detailPanel.setBackground(Color.lightGray);
    detailPanel.setLayout(new BorderLayout());



    ImageIcon i11=new ImageIcon("Resources/images/admin_img.jpg");
    Image i12=i11.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
    // ImageIcon i13=new ImageIcon(i12);
      imgLabel= new JLabel(new ImageIcon(i12));
      imgLabel.setBounds(800, 40, 50, 50);
 
      nameLabel=new JLabel("Name : ");
      nameLabel.setBounds(550, 125, 100, 
      30);
      nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

      designationLabel=new JLabel("Designation : ");
      designationLabel.setBounds(550, 175, 100, 20);
      designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

       userLabel=new JLabel("User : ");
      userLabel.setBounds(550, 225, 100, 20);
      userLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

      disname=new JLabel("");
      disname.setBounds(700,125,200,30);
      disname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
      disname.setBackground(Color.WHITE);
      disname.setOpaque(true);



      disdesignatin=new JLabel("");
      disdesignatin.setBounds(700, 175, 200, 30);
      disdesignatin.setFont(new Font("Times New Roman", Font.BOLD, 16));
      disdesignatin.setBackground(Color.WHITE);
      disdesignatin.setOpaque(true);


      disuser=new JLabel("Admin");
      disuser.setBounds(700, 225 , 200, 30);
      disuser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
      disuser.setBackground(Color.WHITE);
      
      disuser.setOpaque(true);
backButton.addActionListener(this);
   logoutButton.addActionListener(this);
   button1.addActionListener(this);
   button2.addActionListener(this);
   button3.addActionListener(this);

    add(backButton);
    add(logoutButton);
     add(panel1);
    add(button1);
    add(button2);
    add(button3);

    add(imgLabel);
    add(nameLabel);
     add(designationLabel);
    add(userLabel);
    add(disname);
    add(disdesignatin);
    add(disuser);

    add(detailPanel);
   
    add(backgroundPanel);
    
  }
public void actionPerformed(ActionEvent actionEvent){
  if(actionEvent.getSource()==logoutButton){
    this.setVisible(false);
    new Home().setVisible(true);
  }else if(actionEvent.getSource()==backButton){
    this.setVisible(false);
    new Home().setVisible(true);
  }else if(actionEvent.getSource()==button1){
    new CreateAccount().setVisible(true);
  }else if(actionEvent.getSource()==button2){
    removeAcc();
  }
  else if(actionEvent.getSource()==button3){
    // showAcc();
    searchAcc();
  }
}

private void removeAcc(){
JFrame raFrame = new JFrame("Account Details");
    // JFrame saFrame = new JFrame("Balance");
    raFrame.setSize(450, 300);
    raFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int centerX = (int) (this.getWidth() - raFrame.getWidth()) / 2;
    int centerY = (int) (this.getHeight() - raFrame.getHeight()) / 2;

    raFrame.setLocation(centerX, centerY);
    raBackgroundPanel =
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
    raBackgroundPanel.setLayout(new FlowLayout());

    raHeadPanel = new JPanel();
    raHeadPanel.setBounds(0, 0, 1500, 30);
    raHeadPanel.setBackground(Color.DARK_GRAY);

    ImageIcon i1 = new ImageIcon("Resources/images/back.png");
    Image i1i = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    raBackButton = new JButton("Back", new ImageIcon(i1i));
    raBackButton.setBounds(5, 2, 100, 25);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    raBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));

    raAccLabel=new JLabel("Account no. : ");
    raAccLabel.setBounds(10, 50, 100, 40);

    raAccField=new JTextField();
    raAccField.setBounds(120, 50, 300, 40);

    delButton=new JButton("Delete");
    delButton.setBounds(140, 160, 180, 40);
    delButton.setBackground(Color.RED);
    delButton.setForeground(Color.WHITE);


    raFrame.add(raAccField);
    raFrame.add(raAccLabel);
    raFrame.add(raBackButton);
    raFrame.add(delButton);
    raFrame.add(raHeadPanel);
    raFrame.add(raBackgroundPanel);
    raFrame.setVisible(true);
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
    JLabel headingLabel=new JLabel("Account Details");
    headingLabel.setBounds(220,60,200,40);
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




private void searchAcc(){
JFrame searchFrame = new JFrame("Search Account");
    // JFrame saFrame = new JFrame("Balance");
    searchFrame.setSize(450, 300);
    searchFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    int centerX = (int) (this.getWidth() - searchFrame.getWidth()) / 2;
    int centerY = (int) (this.getHeight() - searchFrame.getHeight()) / 2;

    searchFrame.setLocation(centerX, centerY);
    searchBackgroundPanel =
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
    searchBackgroundPanel.setLayout(new FlowLayout());

    searchHeadPanel = new JPanel();
    searchHeadPanel.setBounds(0, 0, 1500, 30);
    searchHeadPanel.setBackground(Color.DARK_GRAY);

    ImageIcon i1 = new ImageIcon("Resources/images/back.png");
    Image i1i = i1.getImage().getScaledInstance(18, 18, Image.SCALE_DEFAULT);

    searchBackButton = new JButton("Back", new ImageIcon(i1i));
    searchBackButton.setBounds(5, 2, 100, 25);
    // button3.setBackground(Color.RED);
    // button3.setForeground(Color.WHITE);
    searchBackButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));

    searchAccLabel=new JLabel("Account no. : ");
    searchAccLabel.setBounds(10, 50, 100, 40);

    searchAccField=new JTextField();
    searchAccField.setBounds(120, 50, 300, 40);

    searchButton=new JButton("Search");
    searchButton.setBounds(140, 160, 180, 40);
    searchButton.setBackground(Color.GREEN);
    searchButton.setForeground(Color.WHITE);


    searchFrame.add(searchAccField);
    searchFrame.add(searchAccLabel);
    searchFrame.add(searchBackButton);
    searchFrame.add(searchButton);
    searchFrame.add(searchHeadPanel);
    searchFrame.add(searchBackgroundPanel);
    searchFrame.setVisible(true);
}


  public static void main(String args[]) {
    new AdminHome().setVisible(true);
  }
}
