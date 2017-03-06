package employeePack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditEmployeeServlet
 */
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int employeeId=new Integer(request.getParameter("id"));
		
		ResultSet rs=LoginDao.employeeDetailsById(employeeId);
		java.sql.ResultSetMetaData rsMeta = null;
		try {
			while(rs.next()){
				rsMeta = rs.getMetaData();
				final int columnCount = rsMeta.getColumnCount();
				for (int column = 1; column <= columnCount; column++){
					 if(rsMeta.getColumnName(column).equalsIgnoreCase("fname")){
						 request.setAttribute("fname", rs.getObject(column));
					 }else if(rsMeta.getColumnName(column).equalsIgnoreCase("username")){
						 request.setAttribute("username", rs.getObject(column));
					 }else if(rsMeta.getColumnName(column).equalsIgnoreCase("password")){
						 request.setAttribute("password", rs.getObject(column));
					 }else if(rsMeta.getColumnName(column).equalsIgnoreCase("lname")){
						 request.setAttribute("lname", rs.getObject(column));
					 }else if(rsMeta.getColumnName(column).equalsIgnoreCase("email")){
						 request.setAttribute("email", rs.getObject(column));
					 }else if(rsMeta.getColumnName(column).equalsIgnoreCase("phone")){
						 request.setAttribute("phone", rs.getObject(column));
					 }else if(rsMeta.getColumnName(column).equalsIgnoreCase("location")){
						 request.setAttribute("location", rs.getObject(column));
					 }else if(rsMeta.getColumnName(column).equalsIgnoreCase("id")){
						 request.setAttribute("id", rs.getObject(column));
					 }
				}
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 RequestDispatcher rd =request.getRequestDispatcher("EditEmployeeDetail.jsp");
		 rd.forward(request, response);
			    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int employeeId=new Integer(request.getParameter("id"));
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String location=request.getParameter("location");
		
		EmployeeBean emp=new EmployeeBean();
		emp.setUsername(uname);
		emp.setPassword(pwd);
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setLocation(location);
		emp.setId(employeeId);
		
		int status=LoginDao.editEmployeeDetailById(emp);
		if(status>0){
			response.sendRedirect("LoginPage.jsp");
		}else{
			out.println("0 records updated");
		}
	}

}
