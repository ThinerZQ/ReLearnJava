package com.zq.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User：ThinerZQ
 * Email：thinerzq@gmail.com
 * Date：2018/1/9 0:24
 * Project：learn
 * Package：com.zq.stream
 */
public class OptionalTest {

    public static void main(String[] args) {

        Person person = new Person();
        Hand hand = new Hand();
        hand.setFinger("wocao");

        List<Hand> handList = new ArrayList<>();
        handList.add(hand);
        person.setHandList(handList);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        Optional.ofNullable(personList).map(persons -> persons).orElse(new ArrayList<>()).stream().forEach(
                person1 -> {
                    Optional.ofNullable(person1.getHandList()).map(hands -> hands).orElse(new ArrayList<>()).stream()
                            .forEach(System.out::println);
                }
        );
        //optional 的map里面是有一个可推到的返回值的
        Optional.ofNullable(personList).map(persons -> {
                    persons.stream().forEach(
                            person1 -> {
                                Optional.ofNullable(person1.getHandList()).map(hands -> {
                                    hands.stream().forEach(hand1 -> {
                                        System.out.println(hand1);
                                    });
                                    return person1;
                                });
                            }
                    );
                    return persons;
                }
        );
    }

    @Data
    public static class Person {
        private String name;
        private List<Hand> handList;
    }

    @Data
    public static class Hand {
        private String finger;

        @Override
        public String toString() {
            return "Hand{" +
                    "finger='" + finger + '\'' +
                    '}';
        }
    }
}
