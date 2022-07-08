package com.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.model.Employee;
import com.main.model.Manager;

public class DB {
Connection con;
	
	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded..");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavericks_hex", "root", "Password123");
			System.out.println("Connection Established!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertEmployee(Employee employee) throws SQLException {
		dbConnect();
		String sql = "insert into employee(id,name,username,password,currPts,totalPts)"
				+ "values (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getUsername());
			pstmt.setString(4, employee.getPassword());
			pstmt.setInt(5, employee.getCurrPts());
			pstmt.setInt(6, employee.getTotalPts());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		con.close();
	}
	
	public void insertManager(Manager manager) throws SQLException {
		dbConnect();
		String sql = "insert into manager(id,name,username,password)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getId());
			pstmt.setString(2, manager.getName());
			pstmt.setString(3, manager.getUsername());
			pstmt.setString(4, manager.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		con.close();
	}
	
	public void updateManager(Manager manager) throws SQLException {
		dbConnect();
		String sql = "update manager(id,name,username,password) set password = "
				+ "?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		con.close();
	}
	
	public void updateEmployee(Employee employee) throws SQLException {
		dbConnect();
		String sql = "update employee(id,name,username,password,currPts,totalPts) set password = "
				+ "?" + " where id = " + employee.getId();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getUsername());
			pstmt.setString(4, employee.getPassword());
			pstmt.setInt(5, employee.getCurrPts());
			pstmt.setInt(6, employee.getTotalPts());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		con.close();
	}
	
	public List<Employee> fetchEmployees() throws SQLException{
		dbConnect();
		String sql = "select * from employee";
		List<Employee> list = new ArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Employee(rst.getString("id"),
						rst.getString("name"),
						rst.getString("username"),
						rst.getString("password"),
						rst.getInt("currPts"),
						rst.getInt("totalPts")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return list;
	}
}
