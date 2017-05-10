package kr.re.kitri.northwind;

import java.sql.*;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class NorthwindMain {

    public static void main(String[] args) {

        // 1. postgreSQL 데이터베이스 JDBC 드라이버를 로딩한다.
        try {
            Class.forName("org.postgresql.Driver");     // 설치한 jar 파일 로딩(프로젝트명 우클릭 + open module setting + dependencies
            System.out.println("driver is loaded..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 데이터베이스와 연결을 수행한다.
        // 즉, Connection 객체를 만든다.
        String dburl = "jdbc:postgresql://localhost:5432/test"; // 5432는 default, test는 db이름
        String username = "postgres";
        String password = "0409";
        try {
            Connection conn =
                    DriverManager.getConnection(dburl, username, password);
            System.out.println("Connection OK..");

            // 3. SQL문을 DB로 전달한다.
            String sql =
                    "INSERT INTO public.sample(first_name, last_name, age) VALUES (?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "찬호");
            pstmt.setString(2, "박");
            pstmt.setInt(3, 40);

            pstmt.executeUpdate();
            System.out.println("Insert conducted..");

            conn.close();
            System.out.println("Connection terminated..");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
