package kr.re.kitri.northwind.util;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public interface PostgresConstants {

    String DRIVER_POSTGRES = "org.postgresql.Driver";
    String DB_URL = "jdbc:postgresql://localhost:5432/northwind";
    String USERNAME = "postgres";
    String PASSWORD = "0409";
    // default로 public static final

    String query =
            "select customerid, " +
                    "       companyname, " +
                    "       contactname, " +
                    "       address, " +
                    "       city, " +
                    "       phone " +
                    "from   customers " +
                    "order  by contactname";

    String joinQuery =
            "select a.contactname, a.city, a.country, b.orderdate, b.shipcountry " +
                    "from customers a, orders b " +
                    "where a.customerid = b.customerid";
}
