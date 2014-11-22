package test.guokao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnUtil {


	//mysql数据信息
	 
	/* private static String classname = config.mysqldriverclass;
	 private static String url = config.mysqlconnurl;
	 private static String username = config.mysqlusername;
	 private static String password = config.mysqlpassword;
	 */
	//oracle数据信息
	/* private static String classname = config.oraclediverclass;
	 private static String url = config.oracleconnurl;s
	 private static String username = config.oracleusername;
	 private static String password = config.oraclepassword;
	 */
	 private static String url = "jdbc:mysql://localhost:3306/guokao"; 
	 private static String username = "root";
	 private static String password = "123456";
	// private static String classname = "com.mysql.jdbc.Driver";
	 
	 private static Connection conn = null;
	 
	 //静态块加载驱动（反射）
	 static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
	 }
	 //连接数据库
	 public static Connection getConn(){
		 try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	 }
	 //关闭数据库
	 public static void closeConn(ResultSet rs,Statement stmt,PreparedStatement pstmt,Connection conn){
		 
		 try {
			 if(null != rs){
			 rs.close();
			 }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
					try {
						if(null != stmt)
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						try {
							if(null !=pstmt){
								pstmt.close();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}finally{
								try {
									if(null != conn){
										conn.close();
										}
									} catch (SQLException e) {
										e.printStackTrace();
									}
							}
					}
			}
	 }
}
			
		 
	 
	

