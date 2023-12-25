/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author TxmMinh
 */
public class tables {
    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key,"
                    + "name varchar(200), email varchar(200), mobileNumber varchar(200), address varchar(200),"
                    + "password varchar(200), securityQuestion varchar(200), answer varchar(200), "
                    + "status varchar(200), UNIQUE(email))";
            String categoryTable = "create table category (id int AUTO_INCREMENT primary key, name varchar(200))";
            String productTable = "create table product (id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200)"
                    + ", price varchar(200))";
            String billTable = "create table bill (id int primary key, name varchar(200), mobileNumber varchar(200), "
                    + "email varchar(200), date varchar(50), total varchar(200), createdBy varchar(200))";
            String employeeTable = "create table employee (id int AUTO_INCREMENT primary key, EmployeeCode varchar(200), FullName varchar(200),"
                    + " RoleName varchar(200), DateOfBirth varchar(200), Gender varchar(200), "
                    + "Address varchar(200), PhoneNumber varchar(50), Email varchar(200), Salary varchar(200))";
//            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
//            DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
//            DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully");
//            DbOperations.setDataOrDelete(billTable, "Bill Table Created Successfully");
            DbOperations.setDataOrDelete(employeeTable, "Employee Table Created Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); 
        }
    }
}
