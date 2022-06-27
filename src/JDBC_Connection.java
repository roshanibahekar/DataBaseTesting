import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {

	public static void main(String[] args) throws SQLException {
		/*Connection url
          "jdbc:mysql://"+host+":"+port+"/databasename";
          "jdbc:mysql://"+host+":"+port+"/Feb_2022";
          

         */
		
		String host="localhost";
		String port="3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Feb_2022", "root", "rose@3191");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from  EmpInfo_2022 where name='Raghav'");
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("location"));
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("age"));

		}
		

	}

}
