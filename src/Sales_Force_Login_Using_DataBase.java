import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sales_Force_Login_Using_DataBase {

	public static void main(String[] args) throws SQLException {
		
		/*Connection url
        "jdbc:mysql://"+host+":"+port+"/databasename";
        "jdbc:mysql://"+host+":"+port+"/sales_force_login";
        

       */

		String host="localhost";
		String port="3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/sales_force_login", "root", "rose@3191");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from  login_details where fname='roshani'");
		while(rs.next())
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Drivers\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://login.salesforce.com/?locale=in");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
			driver.findElement(By.name("Login")).click();
			
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));

			driver.close();
		}
	}

}
