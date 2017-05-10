package kr.re.kitri.northwind.service;

import kr.re.kitri.northwind.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JdbcService {

    public List<Customer> makeList(String dbURL, String userID, String password){

        String query =
                "select customerid, " +
                        "       companyname, " +
                        "       contactname, " +
                        "       address, " +
                        "       city, " +
                        "       phone " +
                        "from   customers " +
                        "order  by contactname";

        List<Customer> list = new ArrayList<>();

        try {

            Connection conn =
                    DriverManager.getConnection(dbURL, userID, password);
            System.out.println("Connection ok..");

            PreparedStatement psmt = conn.prepareStatement(query);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                list.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }

            conn.close();
            System.out.println("Connection closed..");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
