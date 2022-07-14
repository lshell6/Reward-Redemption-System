package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.Employee;
import com.main.Manager;

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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hex_maverick_75572_db", "root", "Password123");
			System.out.println("Connection Established!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertEmployee(Employee employee) throws SQLException {
		dbConnect();
		String sql = "insert into employee(Employee_ID,Name,Username,Password,Curr__Points,Total__Pointts)"
				+ "values (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getUsername());
			pstmt.setString(4, employee.getPassword());
			pstmt.setInt(5, employee.getCurr_Points());
			pstmt.setInt(6, employee.getTotal_Points());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void insertManager(Manager manager) throws SQLException {
		dbConnect();
		String sql = "insert into manager(Manager_ID,Name,Username,Password)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, manager.getId());
			pstmt.setString(2, manager.getName());
			pstmt.setString(3, manager.getUsername());
			pstmt.setString(4, manager.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void updateManagerPassword(Manager manager) throws SQLException {
		dbConnect();
		String sql = "update manager(Manager_ID,Name,Username,Password) set Password = "
				+ "?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void updateEmployeeCurr_entPoints(Employee employee) throws SQLException {
		dbConnect();
		String sql = "update employee(Employee_ID,Name,Username,Password,Curr__Points,Total_Points) set Curr_Points = "
				+ "?" + " where Employee_ID = " + employee.getId();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(5, employee.getCurr_Points());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	public void updateEmployeeTotal_Points(Employee employee) throws SQLException {
		dbConnect();
		String sql = "update employee(Employee_ID,Name,Username,Password,Curr_Points,Total_Points) set Total_Points = "
				+ "?" + " where Employee_ID = " + employee.getId();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(6, employee.getTotal_Points());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void updateEmployeePassword(Employee employee) throws SQLException {
		dbConnect();
		String sql = "update employee(Employee_ID,Name,Username,Password,Curr_Points,Total_Points) set Password = "
				+ "?" + " where Employee_ID = " + employee.getId();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(4, employee.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public List<Employee> fetchEmployees() throws SQLException{
		dbConnect();
		String sql = "select * from employee";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Employee(rst.getInt("Employee_ID"),
						rst.getString("Name"),
						rst.getString("Username"),
						rst.getString("Password"),
						rst.getInt("Curr_Points"),
						rst.getInt("Total_Points")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	public List<Employee> fetchEmployeeIdNameUsername() throws SQLException{
		dbConnect();
		String sql = "select col1,col2,col3 from employee";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Employee(rst.getInt("Employee_ID"),
						rst.getString("Name"),
						rst.getString("Username"),
						rst.getString("Password"),
						rst.getInt("Curr_Points"),
						rst.getInt("Total_Points")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	public List<Manager> fetchManager() throws SQLException{
		dbConnect();
		String sql = "select * from manager";
		List<Manager> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Manager(rst.getInt("Manager_ID"),
						rst.getString("Name"),
						rst.getString("Username"),
						rst.getString("Password")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	public Employee fetchEmployee(String Username){
		dbConnect();
		String sql="select * from employee where Username=?";
		Employee e = new Employee(); 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Username);
			ResultSet  rst = pstmt.executeQuery();
			rst.next();
			e = new Employee(rst.getInt("Employee_ID"),
					rst.getString("Name"),
					rst.getString("Username"),
					rst.getString("Password"),
					rst.getInt("Curr_Points"),
					rst.getInt("Total_Points"));
					  
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		dbClose();
		return e;
	}
	
	public Manager fetchManager(String Username){
		dbConnect();
		String sql="select * from manager where Username=?";
		Manager m = new Manager(); 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Username);
			ResultSet  rst = pstmt.executeQuery();
			rst.next();
			m = new Manager(rst.getInt("Manager_ID"),
					rst.getString("Name"),
					rst.getString("Username"),
					rst.getString("Password"));
					  
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		dbClose();
		return m;
	}

	public Employee selectEmployee() throws SQLException{
		List<Employee> list = new ArrayList<>();
		dbConnect();
		String sql = "select * from employee where id = ?";
		Employee e = new Employee();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();

			while(rst.next()) {
				list.add(new Employee(rst.getInt("id"),
						rst.getString("Name"),
						rst.getString("Username"),
						rst.getString("Password"),
						rst.getInt("Curr_Points"),
						rst.getInt("Total_Points")));
			}
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
		dbClose();
		return e;
	}
	
	public Manager selectManager() throws SQLException{
		List<Manager> list = new ArrayList<>();
		dbConnect();
		String sql = "select * from manager where id = ?";
		Manager m = new Manager();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();

			while(rst.next()) {
				list.add(new Manager(rst.getInt("Manager_ID"),
						rst.getString("Name"),
						rst.getString("Username"),
						rst.getString("Password")));
			}
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
		dbClose();
		return m;
	}

	public List<Item> fetchItems() throws SQLException{
		dbConnect();
		String sql = "select * from items";
		List<Item> list = new ArrayList<>();
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();

			while(rst.next()) {
				list.add(new Item(rst.getInt("Item_ID"),
						rst.getString("Name"),
						rst.getInt("ptValue")));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbClose();
		return list;
	}

	public List<Item> selectItems() throws SQLException{
		dbConnect();
		String sql = "select * from item where Item_ID = ?";
		List<Item> list = new ArrayList<>();
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();

			while(rst.next()) {
				list.add(new Item(rst.getInt("Item_ID"),
						rst.getString("Name"),
						rst.getInt("PtValue")));
				sql = sql + "+ ?";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
}
