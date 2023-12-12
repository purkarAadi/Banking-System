package com.ami.tech.dl.interfaces.dao;
import com.ami.tech.dl.exceptions.*;
import com.ami.tech.dl.interfaces.dto.*;
public interface DAOInterface{
    public boolean loginValidation(String account,String password,String userType);
    public DTOInterface login();
    public boolean receiverAccValidation(String receiverAcc);
    public void createAccount(DTOInterface dao)throws DAOException;
    public void update(DTOInterface dao)throws DAOException;
    public void withdraw(DTOInterface dao,String amount,String date_time)throws DAOException;
    public void deposite(DTOInterface dao,String amount,String date_time)throws DAOException;
    public void accountChange(DTOInterface dao)throws DAOException;
    public void checkStatus(DTOInterface dao)throws DAOException;
    public void deleteAccount(DTOInterface dao)throws DAOException;
}