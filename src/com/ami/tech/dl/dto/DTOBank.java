package com.ami.tech.dl.dto;

import com.ami.tech.dl.interfaces.dto.*;

public class DTOBank implements DTOInterface {

  private String name;
  private String accountNo;
  private String password;
  private String balance;
  private String aadharNumber;

  private String designation;
  private String ifscCode;
  private String address;

  public DTOBank() {
    this.name = "";
    this.password = "";
    this.balance = "";
    this.aadharNumber = "";
    
    this.designation = "";
    this.ifscCode = "999xyz111";
    this.address = "";
    this.accountNo = "";
  }

  public void setAccountNumber(String accountNo) {
    this.accountNo = accountNo;
  }

  public String getAccountNumber() {
    return this.accountNo;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setPassword(String password) {
    this.password =password;
  }

  public String getPassword() {
    return this.password;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  public String getBalance() {
    return this.balance;
  }

  public void setAadharNumber(String aadharNumber) {
    this.aadharNumber = aadharNumber;
  }

  public String getAadharNumber() {
    return this.aadharNumber;
  }

 

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getDesignation() {
    return this.designation;
  }

  public String getIfscCode() {
    return this.ifscCode;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return this.address;
  }
}
