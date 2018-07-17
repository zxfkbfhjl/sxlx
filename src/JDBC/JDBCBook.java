package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCBook {
	private Connection connection;
	private Statement statement;

	private Connection getConnection(){
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ������ַ���
			String dbURL = "jdbc:mysql://localhost:3306/text";			
			//�������ݿ�����
			try {
				Connection connection = DriverManager.getConnection(dbURL,"root","980604");
				return connection;
			}
			catch (SQLException e) {
				e.printStackTrace();				
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();			
		}
		return null;
	}

	@SuppressWarnings("unused")
	private void insertBook(String name,String publishers,String auther,String time) {
		// TODO Auto-generated method stub
		connection = null;
		statement = null;
		try {
			//1.�������ݿ�����		
			connection = getConnection();
			//2.��������鼮��sql���
			String sql = "insert into book (book_name,book_publishers,book_auther,create_time)"+"value('"+ name +"','"+publishers+"','"+auther+"','"+time+"')";
			//3.ִ��sql���
			statement = connection.createStatement();
			//4.�õ�ִ�к�Ľ����ȷ���Ƿ���ӳɹ�
			int rows = statement.executeUpdate(sql);
			System.out.println("��Ӱ�������Ϊ��"+ rows);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection,statement,null);
		}
	}
	
	private void updateBook(int id,String name,String publishers,String auther) {
		Connection connection = null;
		Statement statement = null;
		try {
			//1.�������ݿ�����			
			connection = getConnection();
			//2.����Update sql���
			String sql = "update book set book_name= '"+name+"',book_publishers='"+publishers+"',book_auther='"+auther+"'where id="+ id;
			//3.ִ��update���
			statement = connection.createStatement();
			//4.��ȡִ����Ӱ����������ж��Ƿ���³ɹ�
			int rows = statement.executeUpdate(sql);
			System.out.println("���½��Ϊ��"+ (rows > 0));			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection, statement, null);
		}	
	}
	
	private  void deleteBook(int id) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection();
			//3.����ɾ�����ݵ�sql���
			String sql = "delete from book where id = "+id;
			//4.ִ��ɾ�����
			statement = connection.createStatement();
			//5.��ȡִ����Ӱ����������ж��Ƿ�ɾ���ɹ�
			int rows = statement.executeUpdate(sql);
			System.out.println("��"+ rows +"�б�ɾ���ɹ���");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection, statement, null);
		}	
	}
	
	 private void findAllBook() {
		//1.��ȡ���ݿ�����
		Connection connection =null;
		ResultSet resultSet = null;
		Statement statement = null;
		//2.������ѯ��sql���
		String sql = "select * from book";
		try {
			//3.ִ��sql��䲢��ý����
		   connection=getConnection();
	       statement =connection.createStatement();
	        resultSet = statement.executeQuery(sql);
   		    //4.��������������ÿ����¼����Ϣ
			StringBuffer buffer = new StringBuffer();
			buffer.append("---------------------------------------------------------------------------------------"+System.lineSeparator());
			buffer.append("id\t\t\name\t\t\tpublishers\t\tauther\t\t\t"+System.lineSeparator());
			buffer.append("---------------------------------------------------------------------------------------"+System.lineSeparator());
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("book_name");
				String publishers = resultSet.getString("book_publishers");
				String auther = resultSet.getString("book_auther");
				buffer.append(id+"\t|"+name+"|\t"+publishers+"|\t"+auther+"|"+System.lineSeparator());
			}	
            System.out.println(buffer.toString());
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if (resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		}	
	}
	
	
	
private void findBookDataLikeKeyWord(String Keyword) {
		//��ȡ���ݿ�����
	Connection connection = getConnection();
	//2.������ѯ��sql���
	String sql = "select book_name,book_publishers,book_auther from book where book_name like '%"+Keyword+"%' || book_publishers like '%"+Keyword+"%' || book_auther like '%"+Keyword+"%'";
	try {
		//3.ִ��sql��䲢��ý����
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//4.��������������ÿ����¼����Ϣ
		StringBuffer buffer = new StringBuffer();
		buffer.append("--------------------------------------------------------------------------------------"+System.lineSeparator());
		buffer.append("id\t\t\tname\t\t\tpublishers\t\tauther\t\t\t"+System.lineSeparator());
		buffer.append("--------------------------------------------------------------------------------------"+System.lineSeparator());
		while (resultSet.next()) {
			String name = resultSet.getString("book_name");
			String publishers = resultSet.getString("user_publishers");
			String auther = resultSet.getString("book_auther");
			buffer.append("\t|"+name+"|\t"+publishers+"|\t"+auther+"|"+System.lineSeparator());
		}	
        System.out.println(buffer.toString());
	}
	catch(SQLException e) {
		e.printStackTrace();
	}finally {
        close(connection,statement,null);
    }			
	}

private void close(Connection connection,Statement statement,ResultSet resultSet) {
	try {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
	
public static void main(String  args[]){
	JDBCBook jdbcBook = new JDBCBook();
	int select = 0;//�����û�ѡ�����Ϣ
	String value = null;
	Scanner scanner = new Scanner(System.in);
	while (true){
	    System.out.println("=================================================");
	    System.out.println("ح                                                   ��ӭʹ��                      �˹�����ϵͳ                                             ح");
	    System.out.println("ح 1.����鼮   2.�޸��鼮  3.ɾ���鼮 4.��ѯ�鼮  5.ģ������  6.�˳�ϵͳ  ح");
	    System.out.println("=================================================");
	    System.out.println("��ѡ����Ҫ���еĲ�������");
	    select = scanner.nextInt();
	    while(select < 1 || select > 5) {
	    	System.out.println("ѡ��Ĳ�������ʶ��������ѡ��");
	    	select = scanner.nextInt();
	    }
	    if(select == 1) {//�������
	    	System.out.println("������Ҫ��ӵ��鼮��,�����̣����ߺ�����");
	        value=scanner.next();
	        String [] values=value.split(",");
	        jdbcBook.insertBook(values[0], values[1], values[2], values[3]);
	    }else if (select == 2) {//�޸�����
	    	System.out.println("������Ҫ�޸ĵ�id���鼮���������̺��鼮���ߣ����ŷָ�");
	    	value=scanner.next();
	        String [] values=value.split(",");
	        jdbcBook.updateBook(Integer.parseInt(values[0]),values[1],values[2],values[3]); 
	    }else if (select == 3) {//ɾ������
	    	System.out.println("������Ҫɾ����id");
	    	value=scanner.next();
	        jdbcBook.deleteBook(Integer.parseInt(value));
		}
	    else if (select == 4) {//��ѯ����
	        jdbcBook.findAllBook();
	    }
	    else if (select ==5) {//��ѯ����
	    	System.out.println("������Ҫ����ģ�����ҵ�����");
	    	value=scanner.next();
	        jdbcBook.findBookDataLikeKeyWord(value);
	    }
	    else{//�˳�ϵͳ
	    	System.exit(-1);
		}
	}	
}

}
