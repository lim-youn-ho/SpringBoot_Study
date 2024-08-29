package com.example.springboot_study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.BaseStream;
import java.util.stream.Collector;

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

        //람다식_필터 짝수출력시
        list.stream()
                .filter(num -> num % 2 == 0)
                .forEach(evenNum -> System.out.println(evenNum));
    }


    //자바에서 기본적으로제공하는 함수형 인터페이스를 받는다
    public interface Stream<T> extends BaseStream<T, Stream<T>> {

        Stream<T> filter(Predicate<? super T> predicate);

        <R> Stream<R> map(Function<? super T, ? extends R> mapper);

        void forEach(Consumer<? super T> action);

        <R, A> R collect(Collector<? super T, A, R> collector);


    }

}


