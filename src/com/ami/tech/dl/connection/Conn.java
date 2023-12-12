package com.ami.tech.dl.connection;
//this package will use to establish the connection and to retreive the data from the database

import java.sql.*;

public class Conn {

  Connection connection;
  public Statement statement;

  public Conn() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root","Ram9691@mitesh");
        statement=connection.createStatement();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }
}
