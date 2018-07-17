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
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建数据库连接字符串
			String dbURL = "jdbc:mysql://localhost:3306/text";			
			//建立数据库连接
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
			//1.创建数据库连接		
			connection = getConnection();
			//2.构建添加书籍的sql语句
			String sql = "insert into book (book_name,book_publishers,book_auther,create_time)"+"value('"+ name +"','"+publishers+"','"+auther+"','"+time+"')";
			//3.执行sql语句
			statement = connection.createStatement();
			//4.得到执行后的结果，确定是否添加成功
			int rows = statement.executeUpdate(sql);
			System.out.println("所影响的行数为："+ rows);
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
			//1.创建数据库连接			
			connection = getConnection();
			//2.创建Update sql语句
			String sql = "update book set book_name= '"+name+"',book_publishers='"+publishers+"',book_auther='"+auther+"'where id="+ id;
			//3.执行update语句
			statement = connection.createStatement();
			//4.获取执行所影响的行数，判断是否更新成功
			int rows = statement.executeUpdate(sql);
			System.out.println("更新结果为："+ (rows > 0));			
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
			//3.构建删除数据的sql语句
			String sql = "delete from book where id = "+id;
			//4.执行删除语句
			statement = connection.createStatement();
			//5.获取执行所影响的行数，判断是否删除成功
			int rows = statement.executeUpdate(sql);
			System.out.println("有"+ rows +"行被删除成功！");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection, statement, null);
		}	
	}
	
	 private void findAllBook() {
		//1.获取数据库连接
		Connection connection =null;
		ResultSet resultSet = null;
		Statement statement = null;
		//2.构建查询的sql语句
		String sql = "select * from book";
		try {
			//3.执行sql语句并获得结果集
		   connection=getConnection();
	       statement =connection.createStatement();
	        resultSet = statement.executeQuery(sql);
   		    //4.遍历结果集，输出每条记录的信息
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
		//获取数据库连接
	Connection connection = getConnection();
	//2.构建查询的sql语句
	String sql = "select book_name,book_publishers,book_auther from book where book_name like '%"+Keyword+"%' || book_publishers like '%"+Keyword+"%' || book_auther like '%"+Keyword+"%'";
	try {
		//3.执行sql语句并获得结果集
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//4.遍历结果集，输出每条记录的信息
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
	int select = 0;//接收用户选择的信息
	String value = null;
	Scanner scanner = new Scanner(System.in);
	while (true){
	    System.out.println("=================================================");
	    System.out.println("丨                                                   欢迎使用                      人工智能系统                                             丨");
	    System.out.println("丨 1.添加书籍   2.修改书籍  3.删除书籍 4.查询书籍  5.模糊查找  6.退出系统  丨");
	    System.out.println("=================================================");
	    System.out.println("请选择你要进行的操作……");
	    select = scanner.nextInt();
	    while(select < 1 || select > 5) {
	    	System.out.println("选择的操作不能识别，请重新选择");
	    	select = scanner.nextInt();
	    }
	    if(select == 1) {//添加数据
	    	System.out.println("请输入要添加的书籍名,出版商，作者和日期");
	        value=scanner.next();
	        String [] values=value.split(",");
	        jdbcBook.insertBook(values[0], values[1], values[2], values[3]);
	    }else if (select == 2) {//修改数据
	    	System.out.println("请输入要修改的id，书籍名，出版商和书籍作者，逗号分隔");
	    	value=scanner.next();
	        String [] values=value.split(",");
	        jdbcBook.updateBook(Integer.parseInt(values[0]),values[1],values[2],values[3]); 
	    }else if (select == 3) {//删除数据
	    	System.out.println("请输入要删除的id");
	    	value=scanner.next();
	        jdbcBook.deleteBook(Integer.parseInt(value));
		}
	    else if (select == 4) {//查询数据
	        jdbcBook.findAllBook();
	    }
	    else if (select ==5) {//查询数据
	    	System.out.println("请输入要进行模糊查找的内容");
	    	value=scanner.next();
	        jdbcBook.findBookDataLikeKeyWord(value);
	    }
	    else{//退出系统
	    	System.exit(-1);
		}
	}	
}

}
