/*
package com.example.playground;

import com.example.shipment.model.Shipment;

import java.util.*;
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

        HashMap<String, String> stringMap = new HashMap<>();
        stringMap.put("ASD","ASDA");


        Set<String> stringSet =     Set.of("asd","ASDF");
        Shipment shipment = new Shipment(UUID.randomUUID());

        ShipmentValidator shipmentValidatorLiteral = s -> s.getShipmentName() != null;
        validateShipment(shipmentValidatorLiteral,shipment);

        validateShipment(s -> s.getShipmentName() != null,shipment);

        String shipmentSummary = prepareShipmentSummary(s -> s.getShipmentName() + s.getShipmentDescription(),shipment);

        String shipmentSummaryByMethodsReference = prepareShipmentSummary(Shipment::getSummary,shipment);
    }

    private String prepareShipmentSummary(Function<Shipment,String> summaryCreator,Shipment s){
        return summaryCreator.apply(s);
    }

    private void validateShipment(ShipmentValidator sv, Shipment s){
        boolean validationResult = sv.validate(s);
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
*/
