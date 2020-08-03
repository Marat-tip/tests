package kz.proger.test;

import kotlin.Triple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generics {
    public static void main(String[] args) {
        Holder<String> hello = new Holder<>("hello");
        hello.addNext("Sup how are you");
        System.out.println("next: " + hello.getNext());
        System.out.println(hello.getValue());

        Triple<String, Long, Double> triple = new GenericMethods().getTriple("String", 1L, 2D);
        printAll(GenericMethods.list());
        System.out.println(triple);
    }

    public static void printAll(List<String> list) {
        System.out.println(String.join("", list));
    }

    public static void printStringIntMap(Map<String, Integer> map) {
        System.out.println(map.keySet());
    }
}

class GenericMethods {
    public <F, S, T> Triple<F, S, T> getTriple(F first, S second, T third) {
        return new Triple<>(first, second, third);
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }
}

class Holder<T extends String> {
    private final T value;
    private Node top;

    private class Node {
        private final T item;
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public void add(Node next) {
            this.next = next;
        }
    }

    Holder(T value) {
        this.value = value;
        top = new Node(value, null);
    }

    public T getValue() {
        return value;
    }

    public void addNext(T value) {
        this.top = new Node(value, top);
    }

    public T getNext() {
        return top.item;
    }
}
