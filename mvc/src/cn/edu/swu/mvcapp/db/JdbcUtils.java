package cn.edu.swu.mvcapp.db;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	/**
	 * 释放Connection链接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
	}
	/**
	 * 获取Connection链接
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
