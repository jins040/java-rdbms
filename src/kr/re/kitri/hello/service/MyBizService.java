package kr.re.kitri.hello.service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class MyBizService {

    public static int processLogic(int firstNum, int secondNum) {

        return firstNum + secondNum;
    }

    public static int sumIntList(List<Integer> intList) {

//        int result = 0;
//
//        for (int e : intList) {
//            result += e;
//        }
//
//        return result;

        return intList.stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

    public static double averageIntList(List<Integer> intList) throws Exception {

//        double result = 0.0;
//
//        for (int e : intList) {
//            result += e;
//        }
//
//        return result / intList.size();

        OptionalDouble result = intList.stream()
                .mapToInt(Integer::intValue)
                .average();

        if (result.isPresent()) {
            return result.getAsDouble();
        } else {
            throw new Exception("데이터가 없어서 평균을 구할 수 없습니다");
        }
    }
}
