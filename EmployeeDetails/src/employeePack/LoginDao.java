package employeePack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class LoginDao
{
	private static Connection con=null;
	
	public static int insertEmployee(EmployeeBean emp){	
			int status=0;
			//ResultSet rs=null;
		try 
		{
			con=ConnectionProvider.getcon();
			PreparedStatement ps=con.prepareStatement("insert into  employeedetails values(null,?,?,?,?,?,?,?)");
			ps.setString(1,emp.getUsername());
			ps.setString(2,emp.getPassword());
			ps.setString(3,emp.getFname());
			ps.setString(4,emp.getLname());
			ps.setString(5,emp.getEmail());
			ps.setString(6,emp.getPhone());
			ps.setString(7,emp.getLocation());
			
			status=ps.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
			
	}
	public static ResultSet employeeDetails(){
		ResultSet rs=null;
		con=ConnectionProvider.getcon();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employeedetails");
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public static ResultSet employeeDetailsById(int employeeId){
		ResultSet rs=null;
		con=ConnectionProvider.getcon();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employeedetails where id=?");
			ps.setInt(1, employeeId);
			rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static int editEmployeeDetailById(EmployeeBean emp){
		
		con=ConnectionProvider.getcon();
		int status=0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update employeedetails set username = ?,password = ?,fname = ?,lname = ? ,email = ?,phone = ?,location = ? where id = ?");
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getFname());
			ps.setString(4, emp.getLname());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getPhone());
			ps.setString(7, emp.getLocation());
			ps.setInt(8, emp.getId());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public static int deleteEmployeeDetail(int employeeId ){
		con=ConnectionProvider.getcon();
		int status=0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("delete from employeedetails where id = ?");
			ps.setInt(1, employeeId);
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
