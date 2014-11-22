package test.guokao.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;



public class DBDaoUtils {
	/**
	 * 通用的修改，更新，删除，数据库操作方法
	 * @param sql_str:传入的预编译的sql语句包含（delete/update/insert）不包含select
	 * @param params:预编译sql传入的参数，即sql语句的执行条件，放入一个数组中，可以包含多个条件
	 * @return row_count;执行后影响行数
	 */
	public static int executeUpdate(final String sql_str,final Object... params){
		
		Connection conn = DBConnUtil.getConn();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row_count = -1;
		
		try {
			pstmt = conn.prepareStatement(sql_str);
			
			if(null != params){
				
				for(int i = 0 ;i < params.length ; i++){
					
					pstmt.setObject(i+1,params[i] );
				}
			}
			row_count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			DBConnUtil.closeConn(rs, stmt, pstmt, conn);
		}
		return row_count;
	}
	
	/**
	 * 通用查询数据库方法
	 * @param sql_str:传入的要执行的sql语句
	 * @param clazz:传入的要返回集合的类型
	 * @param params:传入的查询参数，
	 */
	public static <T> List<T> executeQuery(final String sql_str , Class<T> clazz,Object... params ){
		
		Connection conn = DBConnUtil.getConn();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql_str);
			
				if(null != params){
				
				for(int i = 0;i<params.length;i++){
					
					pstmt.setObject(i+1,params[i]);
				}
				rs = pstmt.executeQuery();
				
				ResultSetMetaData metadata = rs.getMetaData();
				int count = metadata.getColumnCount();
				List<T> list = new ArrayList<T>();
				
				while(rs.next()){
					
					HashMap<String ,Object> map = new HashMap<String ,Object>();
					T object = clazz.newInstance();
					
					for(int i = 0;i<count;i++){
						
						map.put(metadata.getColumnLabel(i+1),rs.getObject(i+1));
					}
					BeanUtils.populate(object,map);
					list.add(object);
				}
				return list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			DBConnUtil.closeConn(rs, stmt, pstmt, conn);
		}
		return null;
	}
	
public static  List<Object[]> executeQuery(final String sql_str  ){
		
		Connection conn = DBConnUtil.getConn();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			pstmt = conn.prepareStatement(sql_str);
			
				rs = pstmt.executeQuery();
				List<Object []> list = new ArrayList<Object []>();
				ResultSetMetaData metadata = rs.getMetaData();
				int count = metadata.getColumnCount();
				
				while(rs.next()){
					Object [] objData=new Object[count];
					for(int i=0;i<count;i++)
					{
						objData[i]=rs.getObject(i+1);
					}
					list.add(objData);
				}
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			DBConnUtil.closeConn(rs, stmt, pstmt, conn);
		}
		return null;
	}
	
	public static int executeSelect(String sql){
		
		Connection conn = DBConnUtil.getConn();
		Statement stmt = null;
		int i = 0;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				i = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnUtil.closeConn(null, stmt, null, conn);
		}
		return i;
	}
	
	//获得数据库的所有表名
	
	public static List<String> getTableName(){
		
		Connection conn = DBConnUtil.getConn();
		Statement stmt = null;
		int i = 0;
		ResultSet rs = null;
		DatabaseMetaData md=null;
		
		List<String> list  = new ArrayList<String>();
		
		 try
		   {
		    md=conn.getMetaData();
		    rs=md.getTables(null,null,null,null);
		    //System.out.println("+----------------+");
		    while(rs.next())
		    {
		    // System.out.println("|表:"+rs.getString("TABLE_NAME"));
		     list.add(rs.getString("TABLE_NAME"));
		     i++;
		    }
		    
		    return list;
		   }catch(Exception e)
		   {
		    e.printStackTrace();
		   }finally{
				DBConnUtil.closeConn(null, stmt, null, conn);
			}
		return null;
	}
	//返回一个list
public static  List getList(final String sql_str  ){
		
		Connection conn = DBConnUtil.getConn();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			pstmt = conn.prepareStatement(sql_str);
			
				rs = pstmt.executeQuery();
				List list = new ArrayList();
				
				while(rs.next()){
					
					for(int i=0;i<rs.getRow();i++)
					{
						//list.add(rs.);
					}
					
				}
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			DBConnUtil.closeConn(rs, stmt, pstmt, conn);
		}
		return null;
	}
	

}
