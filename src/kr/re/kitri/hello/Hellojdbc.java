package kr.re.kitri.hello;  // 처음에 package명, kr밑에re밑에...
import kr.re.kitri.hello.service.MyBizService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class Hellojdbc {

    public static void main(String[] args) {       // entry class(main, 한 개만 있으면 된다.)

        int firstNum = 3;
        int secondNum = 5;

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int result = MyBizService.processLogic(firstNum, secondNum);
        int resultSum = MyBizService.sumIntList(intList);
        double resultAverage = 0;
        try {
            resultAverage = MyBizService.averageIntList(intList);
        } catch (Exception e) {
            System.out.println(e.getMessage());     // 비어있는 List일 때 클래스 내 메시지 호출
        }

        System.out.println(result);
        System.out.printf("합은 $%d 이고 평균은 $%.1f입니다.", resultSum, resultAverage);

    }

}
