package Frame;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDome {
	@SuppressWarnings("unused")
	private void testConnection(){
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ������ַ���
			String dbURL = "jdbc:mysql://localhost:3306/test";			
			//�������ݿ�����
			try {
				Connection connection = (Connection)
						DriverManager.getConnection(dbURL,"root","lyl0813");			
			}
			catch (SQLException e) {
				e.printStackTrace();				
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();			
		}
	
	}

}
