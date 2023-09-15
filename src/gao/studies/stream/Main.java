package gao.studies.stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> listValues = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Crude form
        List<String> result1 = listValues.stream()
                .collect(
                        () -> new ArrayList<>(),                            //Instance of the type I want to return
                        (list, element) -> list.add(element.toString()),    //How I store the result inside the type above
                        (list1, list2) -> list1.addAll(list2)               //How I combine the threads that can be treating in the "same time" this stream
                );
        System.out.println("1:  " + result1);

        // Crude form (with syntax sugar)
        List<Integer> result2 = listValues.stream()
                .collect(
                        ArrayList::new,     //Instance of the type I want to return
                        ArrayList::add,     //How I store the result inside the type above
                        ArrayList::addAll   //How I combine the threads that can be treating in the "same time" this stream
                );
        System.out.println("2:  " + result2);


        ////Using Collectors
        //toList
        List<Integer> result3 = listValues.stream()
                .collect(Collectors.toList());
        System.out.println("3:  " + result3);

        List<Integer> result4 = listValues.stream()
                .filter(element -> element % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("4:  " + result4);


        //toCollection
        List<String> result5 = listValues.stream()
                .map(element -> element.toString())
                .collect(Collectors.toCollection(() -> new ArrayList<String>()));
        System.out.println("5:  " + result5);


        //toCollection (with syntax sugar)
        List<String> result6 = listValues.stream()
                .map(Object::toString)
                .collect(Collectors.toCollection(ArrayList<String>::new));
        System.out.println("6:  " + result6);//toCollection (with syntax sugar)

        Deque<Integer> result7 = listValues.stream()
                .skip(2)
                .limit(5)
                .collect(Collectors.toCollection(ArrayDeque<Integer>::new));
        System.out.println("7:  " + result7);


        //joining
        String result8 = listValues.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println("8:  " + result8);

        String result9 = listValues.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("9:  " + result9);


        //counting
        Long result10 = listValues.stream()
                .collect(Collectors.counting());
        System.out.println("10: " + result10);

        //count (Without collection)
        long result11 = listValues.stream()
                .count();
        System.out.println("11: " + result11);

        //count (Without collection) using method of the List interface (Just for the sake of remembering)
        int result12 = listValues.size();
        System.out.println("12: " + result12);


        //summing
        Integer result13 = listValues.stream()
                .collect(Collectors.summingInt(element -> element.intValue()));
        System.out.println("13: " + result13);

        //summing (without collectors)
        int result14 = listValues.stream().mapToInt(element -> element).sum();
        System.out.println("14: " + result14);


        //averaging


        //summarizing


        //max/minBy


        //groupingBy


        //partitioningBy


        //toMap

    }

    private static void print(Supplier function) {

    }
}
