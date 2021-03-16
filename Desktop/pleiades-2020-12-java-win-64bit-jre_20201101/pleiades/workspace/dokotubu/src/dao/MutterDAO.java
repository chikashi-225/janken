package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/dokotubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();

		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECt文の準備
			String sql = "SELECT ID, NAME, TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//SELECT文を実行
			ResultSet rs = pstmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return mutterList;
		}
		return mutterList;
	}

	public boolean create(Mutter mutter) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文の準備（idは自動連番なので指定しなくてよい）
			String sql = "INSERT INTO MUTTER (NAME, TEXT) VALUES(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//INSERT文の中の「？」に使用する値を設定しSQｌを完成
			pstmt.setString(1, mutter.getUserName());
			pstmt.setString(2, mutter.getText());

			//INSERT文を実行（resultには追加された行数が代入される）
			int result = pstmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
