package Imperative;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> stringList =List.of("A","B","C","D","Z", "E" , "F");

        boolean containsA = stringList.contains("A");

        boolean answer = false;
        for (int i = 0; i < stringList.size() ; i++) {
            if (stringList.get(i).equals("A")){
                answer = true;
                break;
            }
        }
//        stringList.forEach(s -> System.out.println(s));
//
//        for (String s : stringList) {
//            System.out.println(s);
//        }
//
//        Stream.iterate(40,n -> n + 2)
//                .limit(20)
//                .forEach(t -> System.out.print(t + " , "));


        stringList.stream()
                .reduce((s, s2) -> String.valueOf((char) Math.max(s.charAt(0), s2.charAt(0))))
                .ifPresent(System.out::println);

    }
}
