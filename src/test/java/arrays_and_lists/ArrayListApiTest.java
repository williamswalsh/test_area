package arrays_and_lists;

import org.junit.Test;

import java.util.*;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class ArrayListApiTest {

    @Test
    public void arrayListAddTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        assertEquals(1, list.size());
    }

    @Test
    public void arrayListAddAtIndexTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);

//        @ index 2 add(insert) value three
        list.add(2, 3);
        assertEquals(5, list.size());
    }

    @Test
    public void arrayListRemoveTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void arrayListPassListToConstructorTest() {
        List<Integer> sourceList = Arrays.asList(3,4,5,6,7,8,9);
        ArrayList<Integer> list = new ArrayList<>(sourceList);
        assertEquals(7, list.size());
    }

    @Test
    public void arrayListAddAllTest() {
        List<Integer> sourceList = Arrays.asList(3,4,5,6,7,8,9);
        assertEquals("class java.util.Arrays$ArrayList", sourceList.getClass().toString());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.addAll(sourceList);

        // Size of original list + 1
        assertEquals(8, list.size());
    }

    @Test
    public void arrayListCollectionToArrayWithoutTypeTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);

//        list.toArray with type argument will create an array of Type.
        Integer[] arrayFromList = list.toArray(new Integer[1]);

        assertEquals("java.lang.Integer[]", arrayFromList.getClass().getCanonicalName());
        assertEquals(1, arrayFromList.length);
    }

    @Test
    public void arrayListCollectionToArrayWithTypeTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);

//        list.toArray without type argument will create an array of objects.
        Object[] arrayFromList = list.toArray();

        assertEquals("java.lang.Object[]", arrayFromList.getClass().getCanonicalName());
        assertEquals(1, arrayFromList.length);
    }


    @Test
    public void arrayListClearTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void arrayListContainsIntegerTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        assertTrue(list.contains(2));
    }

    @Test
    public void arrayListContainsObjectTest() {
        ArrayList<Car> list = new ArrayList<>();
        Car myCar = new Car("BMW", "M3");
        list.add(myCar);
        assertTrue(list.contains(myCar));
    }

    @Test
    public void arrayListContainsObjectSameValuesTest() {
        ArrayList<Car> list = new ArrayList<>();
        Car myCar = new Car("BMW", "M3");
        Car myDuplicateCar = new Car("BMW", "M3");
        list.add(myCar);

        // FALSE when the equals & hashCode methods are undefined - equality -> referential equality
        // TRUE  when the equals & hashCode methods are   defined - equality -> equals method
        assertFalse(list.contains(myDuplicateCar));
    }

    @Test
    public void arrayListEnsureCapacityTest() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(0, list.size());

        // Max ArrayList size is dictated by the argument of the get(int index) method.
        // Max size is: 2,147,483,647
        //              2 billion 147 million 483 thousand 647
        list.ensureCapacity(20);            // takes  2 ms
        list.ensureCapacity(214748364);     // takes 89 ms
        assertEquals(0, list.size());
    }

    @Test
    public void arrayListForEachTest() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(11);
        list.add(33);
        list.forEach(System.out::println);
    }

    @Test
    public void arrayListGetTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);

        int num = numbers.get(0);
        assertEquals(99, num);
    }

    @Test
    public void arrayListIndexOfTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);

        assertEquals(1, numbers.indexOf(66));
    }

    @Test
    public void arrayListIsEmptyTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        assertTrue(numbers.isEmpty());
    }

    @Test
    public void arrayListIteratorTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void arrayListIteratorForEachRemainingTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);

        Iterator<Integer> iterator = numbers.iterator();

//        Skip the first element
        iterator.next();

//        Must be a consumer -> not a function -> therefore it must consume the passed value.
        iterator.forEachRemaining(System.out::println);
    }

    @Test
    public void arrayListListIteratorTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);
        ListIterator<Integer> listIterator = numbers.listIterator();

//        Returns next element & advances cursor position? 1st element  ROOT->99->66->77
//                                                                      ^   --^
        int first = listIterator.next();
        int second = listIterator.next();

        assertEquals(99, first);
        assertEquals(66, second);

//        Equivalent to hasNext for previous elements
        if (listIterator.hasPrevious()) {
            int stillSecond = listIterator.previous();
            assertEquals(66, stillSecond);
        }
    }


//    Spliterator
//    Like a binary tree
//    can be used to split a collection
//
    @Test
    public void arrayListSpliteratorTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);

        Spliterator<Integer> source = numbers.spliterator();
        Spliterator<Integer> firstHalf = source.trySplit();

        System.out.println("First Half:");
        firstHalf.forEachRemaining(System.out::println);

        System.out.println("Second Half:");
        source.forEachRemaining(System.out::println);
    }

    @Test
    public void arrayListSpliteratorTryAdvanceTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);

        Spliterator<Integer> source = numbers.spliterator();

//        6 elements remaining
        assertEquals(6, source.estimateSize());

//        Prints the element at the beginning
        source.tryAdvance(System.out::println);

//        5 elements remaining
        assertEquals(5, source.estimateSize());
    }

    @Test
    public void arrayListSpliteratorTrySplitSizeTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);

        Spliterator<Integer> source = numbers.spliterator();
        Spliterator<Integer> firstHalf = source.trySplit();

//        6 elements remaining
        assertEquals(3, firstHalf.estimateSize());

//        Prints the element at the beginning - printing the elem removes it from the estimateSize()
//        estimateSize: number of elements that would be encountered by a forEachRemaining traversal
//        source.tryAdvance(System.out::println);

//        5 elements remaining
        assertEquals(3, source.estimateSize());
    }

    @Test
    public void arrayListSpliteratorParallelProcessTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Spliterator<Integer> source = numbers.spliterator();
        Spliterator<Integer> firstHalf = source.trySplit();
        int firstHalfSum = process(firstHalf);
        int secondHalfSum = process(source);

        System.out.println(firstHalfSum);
        System.out.println(secondHalfSum);
        assertEquals(12, firstHalfSum);
        assertEquals(30, secondHalfSum);
    }

    private static Integer process(Spliterator<Integer> spliterator) {
        System.out.println("CONCURRENT: " + Spliterator.CONCURRENT);
        System.out.println("ORDERED: " + Spliterator.ORDERED);
        System.out.println("IMMUTABLE: " + Spliterator.IMMUTABLE);
        System.out.println("SIZED: " + Spliterator.SIZED);

        return StreamSupport.stream(spliterator, true)
                .map(e -> {
                    System.out.println(Thread.currentThread().getName());
                    return e * 2;
                })
                .reduce(0, (total, currentElement) -> total + currentElement);
    }

    @Test
    public void arrayListLastIndexOfTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(66);
        numbers.add(77);
        numbers.add(88);
        numbers.add(11);
        numbers.add(33);
        numbers.add(77);    // last occurrence of integer

        int index = numbers.lastIndexOf(77);
        assertEquals(6, index);
    }

    @Test
    public void arrayListLoadFactorTest() {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(1);
        ints.add(1);
        ints.add(1);
        ints.add(1);
        ints.add(1);
        ints.add(1);
        // cant examine the load factor code as can't step into the .add code
    }

    //    UnsupportedOperationException: remove
//    @Test
//    public void arrayListRemoveIf() {
//        List<Integer> numbers = Arrays.asList(2,4,6,8,10,12,14);
//
////        Remove if divisible by 4
//        numbers.removeIf(e -> e % 4 == 0); // ??
//        List<Integer> expected = Arrays.asList(2,6,10,14);
//        assertArrayEquals(expected.toArray(), numbers.toArray());
//    }

    class Car {
        private final String brand;
        private final String model;

        public Car(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Car car = (Car) o;
//
//            if (!brand.equals(car.brand)) return false;
//            return model.equals(car.model);
//        }
//
//        @Override
//        public int hashCode() {
//            int result = brand.hashCode();
//            result = 31 * result + model.hashCode();
//            return result;
//        }
    }
}
