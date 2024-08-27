package com.example.springboot_study.lambda;

import java.util.Arrays;
import java.util.List;

public class lambda01 {

    static {
        //예를들어 데이터 출력
        final List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        // foreach
        for(int num : list) {
            System.out.println(num);
        }
        //람다식으로 간결하게
        list.forEach(num -> System.out.println(num));
    }

}
