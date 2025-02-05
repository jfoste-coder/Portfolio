/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/








public class GenericCalculator{
    public static void main(String[] args) {


        // task 1 tests
        Byte byteValue1 = 8;
        Byte byteValue2 = 16;
        Long longValue1 = 2005678L;
        GenericAdder<Byte> byteAdder = new GenericAdder<>(byteValue1);
        System.out.println(byteAdder.intAdd(byteValue2));
        System.out.println(byteAdder.intAdd(longValue1));


        Float floatValue1 = 3.14f;
        Integer integerValue1 = 50;
        Short shortValue1 = 16;
        GenericAdder<Float> floatAdder = new GenericAdder<>(floatValue1);
        System.out.println(floatAdder.intAdd(integerValue1));
        System.out.println(floatAdder.intAdd(shortValue1));

        




    }
}
