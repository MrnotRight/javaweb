package cn.edu.swu.mvc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
	public void deleteByFlowId(int flowId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://120.79.76.125:3306/swu";
			String user = "root";
			String password = "123456+";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "delete from examstudent where flow_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, flowId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public List<Student> getAll(){
		List<Student> students = new ArrayList<Student>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://120.79.76.125:3306/swu";
			String user = "root";
			String password = "123456+";
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "select flow_id, type, id_card, exam_card, student_name, location,"
					+ "grade from examstudent";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int flow_id = resultSet.getInt(1);
				int type = resultSet.getInt(2);
				String idCard = resultSet.getString(3);
				String examCard = resultSet.getString(4);
				String studentname = resultSet.getString(5);
				String location = resultSet.getString(6);
				int grade = resultSet.getInt(7);
				Student student = new Student(flow_id, type, idCard, examCard, 
						studentname, location, grade);
				students.add(student);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}
}
