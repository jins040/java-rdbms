package kr.re.kitri.northwind.service;

import kr.re.kitri.northwind.model.Customer;
import kr.re.kitri.northwind.model.JoinCustomerOrder;
import kr.re.kitri.northwind.util.PostgresConstants;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JdbcService {

    public List<Customer> makeList(){

        List<Customer> list = new ArrayList<>();

        Connection conn = this.getConnection();

        if (conn != null) {
            try {

                System.out.println("Connection ok..");

                PreparedStatement psmt = conn.prepareStatement(PostgresConstants.query);
                ResultSet rs = psmt.executeQuery();

                populateCustomer(rs, list);

                conn.close();
                System.out.println("Connection closed..");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {}

        return list;
    }//makeList

    public List<JoinCustomerOrder> makeJoinList() {

        List<JoinCustomerOrder> list = new ArrayList<>();

        Connection conn = this.getConnection();

        if (conn != null) {

            System.out.println("Connection ok..");

            try {
                PreparedStatement psmt = conn.prepareStatement(PostgresConstants.joinQuery);

                ResultSet rs = psmt.executeQuery();

                translateToList(rs, list);

                conn.close();
                System.out.println("Connection closed..");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {}

        return list;
    }

    private void translateToList(ResultSet rs, List<JoinCustomerOrder> list) throws SQLException {

        while (rs.next()) {

            list.add(new JoinCustomerOrder(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5)));
        }
    }

    private void populateCustomer(ResultSet rs, List<Customer> list) throws SQLException {  // 어차피 함수 호출하는 쪽에서 SQL예외 잡아줌
                                                                                            // list를 받아서 사용하기 때문에 void로 하면 list 그대로 사용
        while (rs.next()) {

            list.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6)));
        }

    }//populateCustomer

    private Connection getConnection() {

        try {
            Connection conn = DriverManager.getConnection(
                    PostgresConstants.DB_URL,
                    PostgresConstants.USERNAME,
                    PostgresConstants.PASSWORD
            );
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;            // null이면 connection 이루어지지 않은 것
        }
    }//getConnection
}
