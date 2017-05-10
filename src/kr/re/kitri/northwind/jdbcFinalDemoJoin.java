package kr.re.kitri.northwind;

import kr.re.kitri.northwind.model.JoinCustomerOrder;
import kr.re.kitri.northwind.service.JdbcService;
import kr.re.kitri.northwind.util.PostgresConstants;

import java.util.List;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class jdbcFinalDemoJoin {

    public static void main(String[] args) {

        // 1. 드라이버 로딩
        loadDriver(PostgresConstants.DB_URL);

        // 2. 쿼리문 수행, List로 변환
        JdbcService service = new JdbcService();
        List<JoinCustomerOrder> list = service.makeJoinList();

        // 3. 결과 출력

        if (list.size() > 0) {
            for (JoinCustomerOrder e : list) {
                System.out.println(e);
            }

            System.out.printf("총 row 갯수 : %d개", list.size());

        } else {
            System.out.println("데이터가 없습니다.");
        }


    }

    private static void loadDriver(String dbUrl) {

    }
}
