/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author TxmMinh
 */
public class EmployeeDao {
    private Connection conn;
    
    public EmployeeDao() {
        try {
            String url = "jdbc:mysql://localhost:3306/cafe_management?useSLL=false";
            String user = "root";
            String password = "password1234"; 
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
    public ArrayList<Employee> getListNV() {
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                nv.setId(rs.getInt("ID"));
                nv.setMaNhanVien(rs.getString("EmployeeCode"));
                nv.setTenNhanVien(rs.getString("FullName"));
                nv.setChucVu(rs.getString("RoleName"));
                nv.setNgaySinh(rs.getString("DateOfBirth"));
                nv.setGioiTinh(rs.getString("Gender"));
                nv.setDiaChi(rs.getString("Address"));
                nv.setSoDienThoai(rs.getString("PhoneNumber"));
                nv.setEmail(rs.getString("Email"));
                nv.setLuong(rs.getInt("Salary"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void AddNhanVien(Employee nv) {
        String sql = "INSERT INTO employee(EmployeeCode, FullName, RoleName, DateOfBirth, Gender, "
                + "Address, PhoneNumber, Email, Salary) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getTenNhanVien());
            ps.setString(3, nv.getChucVu());
            ps.setString(4, nv.getNgaySinh());
            ps.setString(5, nv.getGioiTinh());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSoDienThoai());
            ps.setString(8, nv.getEmail());
            ps.setInt(9, nv.getLuong());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void EditNhanVien(Employee nv) {
        String query = "update employee set FullName = '" + nv.getTenNhanVien() + "', RoleName = '" 
                + nv.getChucVu() + "', DateOfBirth = '" + nv.getNgaySinh() + "', Gender = '" 
                + nv.getGioiTinh() + "', Address = '" + nv.getDiaChi() + "', PhoneNumber = '" 
                + nv.getSoDienThoai() + "', Email = '" + nv.getEmail() + "', Salary = '" + nv.getLuong() + "'"
                + " where EmployeeCode = '" + nv.getMaNhanVien() + "'";
        DbOperations.setDataOrDelete(query, "Product Updated Successfully");
    }
    
    public void DeleteNhanVien(int id) {
        String sql = "DELETE FROM employee WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Employee> findByName(String Name) {
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee WHERE FullName LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + Name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee nv = new Employee();
                nv.setId(rs.getInt("ID"));
                nv.setMaNhanVien(rs.getString("EmployeeCode"));
                nv.setTenNhanVien(rs.getString("FullName"));
                nv.setChucVu(rs.getString("RoleName"));
                nv.setNgaySinh(rs.getString("DateOfBirth"));
                nv.setGioiTinh(rs.getString("Gender"));
                nv.setDiaChi(rs.getString("Address"));
                nv.setSoDienThoai(rs.getString("PhoneNumber"));
                nv.setEmail(rs.getString("Email"));
                nv.setLuong(rs.getInt("Salary"));
                list.add(nv);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        new EmployeeDao();
    }
    
}
