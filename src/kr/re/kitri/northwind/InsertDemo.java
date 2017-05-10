package kr.re.kitri.northwind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class InsertDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "0409";

    public static void main(String[] args) {

        // driver loading
        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("driver loading ok..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO categories(categoryid, categoryname, description) " +      // VALUES 앞에 공백 필수
                "VALUES (?, ?, ?)";

        // get a connection
        try {
            Connection conn =
                DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("connection ok..");

            PreparedStatement pstmt = conn.prepareStatement(query);     // query를 JAVA 형태로 컴파일
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Desktop");
            pstmt.setString(3, "집에 놓고 쓰는 컴퓨터");

            pstmt.executeUpdate();                                      // Insert에는 executeUpdate
            System.out.println("insert ok..");

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
