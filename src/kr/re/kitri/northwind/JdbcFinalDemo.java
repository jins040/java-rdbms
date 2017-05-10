package kr.re.kitri.northwind;

import kr.re.kitri.northwind.model.Customer;
import kr.re.kitri.northwind.service.JdbcService;
import kr.re.kitri.northwind.util.PostgresConstants;

import java.util.List;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JdbcFinalDemo {

    public static void main(String[] args) {

        // 1. 드라이버 로딩
        loadDriver(PostgresConstants.DRIVER_POSTGRES);

        // 2. 쿼리문을 통해 List에 db데이터 담기
        JdbcService service = new JdbcService();
        List<Customer> list = service.makeList();

        // 3. 결과 출력
        if (list.size() > 0) {
            for (Customer e : list) {
                System.out.println(e);
            }

            System.out.printf("총 row 갯수 : %d개", list.size());
        } else {
            System.out.println("데이터가 없습니다.");
        }

    } //main

    private static void loadDriver(String driverPostgres) {

        try {
            Class.forName(driverPostgres);
            System.out.println("Driver loading ok..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    } //loadDriver
}
