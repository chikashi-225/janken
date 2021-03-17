package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import model.UserCheck;

public class AccountDAO {
	public final String JDBC_URL = "jdbc:h2:tcp://localhost/~/dokotubu";
	public final String DB_USER = "sa";
	public final String DB_PASS = "";

	public UserCheck findByUser(User user) {
		UserCheck uc = new UserCheck();
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQLの準備
			String sql = "SELECT * FROM ACCOUNT WHERE NAME = ? AND PASS = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//SQLの実行
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getPass());
			ResultSet rs = pstmt.executeQuery();

			//SELECT文の結果をUserCheckインスタンスに格納
			while(rs.next()) {
				uc.setName(rs.getString("NAME"));
				uc.setPass(rs.getInt("PASS"));
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return uc;
		}
		return uc;
	}

	public boolean create(User user) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SQLの準備
			String sql = "INSERT INTO ACCOUNT (NAME, PASS) VALUES(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//SQLの実行
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getPass());
			int result = pstmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return false;
		}

		return true;
	}

}
