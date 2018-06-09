import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class testMain {
	@Test
	public class doTest {
		Connection connection = null;
		PreparedStatement pstmt = null;
		// Statement stmt = null;  <= Statement 보다는 PreparedStatement를 많이 쓴다고 한다
		ResultSet rs = null;

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		connection = DriverManager.getConnection("jdbc:mysql://heogong.cafe24.com:3306/heogong", "heogong", "wjdtka12");
		String query = "SELECT * FROM customer";
		pstmt = connection.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		
	}
	

}
