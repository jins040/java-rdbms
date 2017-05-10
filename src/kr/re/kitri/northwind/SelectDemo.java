package kr.re.kitri.northwind;

import java.sql.*;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class SelectDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "0409";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("driver loading ok..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query =
                "select customerid, " +
                "       companyname, " +
                "       contactname, " +
                "       address, " +
                "       city, " +
                "       phone " +
                "from   customers " +
                "order  by contactname";

        try {
            Connection conn =
                    DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("connection ok..");

            PreparedStatement psmt = conn.prepareStatement(query);  // 쿼리 컴파일
            ResultSet rs = psmt.executeQuery();                     // Select에는 executeQuery, resultset 객체로 반환
                                                                    // 읽는 파일 내부에 커서 생성
//            rs.next();                                              // 커서를 첫 번째 레코드로 이동
//            rs.next();                                              // rs.next()는 boolean type
//            rs.next();
//            rs.next();
//
//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getString(4));
//            System.out.println(rs.getString(5));
//            System.out.println(rs.getString(6));

            while (rs.next()) {
            System.out.print(rs.getString(1) + "\t"
                    + rs.getString(2) + "\t"
                    + rs.getString(3) + "\t"
                    + rs.getString(4) + "\t"
                    + rs.getString(5) + "\t"
                    + rs.getString(6) + "\n");
            }

            conn.close();   // 다른 application도 connection 활용하기 위해 사용하고 바로 닫아준다.
            System.out.println("connection closed..");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
