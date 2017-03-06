package employeePack;
import static employeePack.LoginProvider.*;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionProvider
	{
		private static Connection con=null;
		static
		{
			try 
			{
				Class.forName(DRIVER);
				con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	
		}
			public static Connection getcon()
			{
				return con;
			}
		
	}
