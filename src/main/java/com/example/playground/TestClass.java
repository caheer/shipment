package com.example.playground;

import com.example.shipment.model.Shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestClass {

    public void useIt(){


        Function<String, Integer> stringLength =
                text -> text.length();

        Integer length = stringLength.apply("shipment");

        List<Number> numbers = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        List<Shipment> shipments = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        Number numberResult = first(numbers);
        Integer integerResult = first(integers);

        Number numberResult2 = second(numbers);
        Number integerResult2 = second(integers);
        Integer integerResult2b = second(integers);
        //String stringResult2 = second(strings);

    }

    public <T> T first(List<T> list) {
        return list.get(0);
    }

    public <T extends Number> T second(List<T> list) {
        return list.get(0);
    }

    public <T extends Shipment> void process(List<? extends T> list) {
    }
}
