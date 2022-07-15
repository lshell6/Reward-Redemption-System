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
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hex_maverick_75572_db", "root", "Password123");
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
		String sql = "insert into employee(Name,Username,Password)"
				+ "values (?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getUsername());
			pstmt.setString(3, employee.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void insertManager(Manager manager) throws SQLException {
		dbConnect();
		String sql = "insert into manager(Name,Username,Password)"
				+ "values (?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getName());
			pstmt.setString(2, manager.getUsername());
			pstmt.setString(3, manager.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void updateManagerPassword(Manager manager) throws SQLException {
		dbConnect();
		String sql = "update manager SET Password = ? where Manager_ID=?";
		System.out.println(manager.getPassword());
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, manager.getPassword());
			pstmt.setInt(2, manager.getId());
			pstmt.executeUpdate();
			System.out.println("hey");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void updateManagerPassword2(String Name, String Username, String Password, int Manager_ID) throws SQLException{
		dbConnect();
		String sql = "update manager SET Name=?,Username=?,Password=? where Manager_ID=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			pstmt.setString(2, Username);
			pstmt.setString(3, Password);
			pstmt.setInt(4, Manager_ID);
			pstmt.executeUpdate();
			System.out.println("hi");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void updateEmployeeCurrentPoints(Employee employee) throws SQLException {
		dbConnect();
		String sql = "update employee set Curr_Points = "
				+ "?" + " where Employee_ID = " + employee.getId();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee.getCurr_Points());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	public void updateEmployeeTotalPoints(Employee employee) throws SQLException {
		dbConnect();
		String sql = "update employee set Total_Points = "
				+ "?" + " where Employee_ID = " + employee.getId();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee.getTotal_Points());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}
	
	public void updateEmployeePassword(Employee employee) throws SQLException {
		dbConnect();
		String sql = "update employee set Password=? where Employee_ID=" + employee.getId();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employee.getPassword());
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
		String sql = "select Employee_ID,Name,Username from employee";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Employee(rst.getInt("Employee_ID"),
						rst.getString("Name"),
						rst.getString("Username")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	public List<Manager> fetchManagers() throws SQLException{
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


	public List<Item> fetchItems() throws SQLException{
		dbConnect();
		String sql = "select * from items order by PtValue asc";
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

	public Item selectItem(int id) throws SQLException{
		dbConnect();
		String sql = "select * from items where Item_ID = ?";
		Item item = new Item();
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rst = pstmt.executeQuery();
			rst.next();
			item = new Item(rst.getInt("Item_ID"), 
					rst.getString("Name"), 
					rst.getInt("ptValue"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		dbClose();
		return item;
	}
	
	public List<Item> itemCart(int numOfItems) throws SQLException{
		dbConnect();
		String sql = "select * from item where Item_ID = ?";
		for(int i = 1; i<numOfItems; i++) {
			sql = sql + "and Item_ID = ?";
		}
		List<Item> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			for(int i = 1; i <= numOfItems; i++) {
				pstmt.setInt(i, list.get(i-1).getId());
			}
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				list.add(new Item(rst.getInt("Item_ID"),
						rst.getString("Name"),
						rst.getInt("PtValue")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
}
