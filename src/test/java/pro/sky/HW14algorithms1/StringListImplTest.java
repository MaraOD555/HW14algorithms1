package pro.sky.HW14algorithms1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;
import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private final StringListImpl stringUnderTest = new StringListImpl();

    @ParameterizedTest
    @CsvSource({"test, test"})
    void testAdd (String item, String expected) {
        String actual = stringUnderTest.add(item);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({"0,test, test"})
    void testAdd1(int index, String item, String expected) {
        String actual = stringUnderTest.add(index, item);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0,test1, test1"})
    void set(int index, String item, String expected) {
        String actual = stringUnderTest.set(index, item);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"test, test"})
    void testRemove(String item, String expected) {
        assertThat(stringUnderTest.add(item)).isEqualTo(expected);

        assertThat(stringUnderTest.remove(item)).isEqualTo(expected);
    }


    @Test
    void testRemove1() {
        String[] items = new String[3];
        items[0] = "test";
        String expected = stringUnderTest.add(0,"test");
        System.out.println(stringUnderTest.get(0));

        assertThat(stringUnderTest.remove("test")).isEqualTo(expected);
        System.out.println(stringUnderTest.get(0));
    }

    @Test
    void contains() {
      String item = stringUnderTest.add("test");
      //assertEquals("true", String.valueOf(stringUnderTest.contains(expected)));
      assertTrue(Boolean.parseBoolean(String.valueOf(stringUnderTest.contains(item))));
    }

    @Test
    void indexOf() {
        String item = stringUnderTest.add("test");
        int index = 0;
        assertThat(stringUnderTest.indexOf(item)).isEqualTo(index);
    }

    @Test
    void lastIndexOf(){
       stringUnderTest.add(0,"test");
       stringUnderTest.add(1,"test1");
       stringUnderTest.add(2,"test2");
       int index = 2;
       assertThat(stringUnderTest.lastIndexOf("test2")).isEqualTo(index);
    }

    @Test
    void get() {
        stringUnderTest.add(0,"test");
        stringUnderTest.add(1,"test1");
        stringUnderTest.add(2,"test2");
        assertThat(stringUnderTest.get(2)).isEqualTo("test2");
        System.out.println(stringUnderTest.get(2));
    }

    @Test
    void testEquals() {
        String[] expected  =  {"test", "test1", "test2"};
        String[] actual = expected;
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        stringUnderTest.add(0,"test");
        stringUnderTest.add(1,"test1");

        System.out.println(stringUnderTest.size());

    }

    @Test
    void isEmpty() { // подумать над логикой, не могу перейти с размера на boolean
        int expected = stringUnderTest.size();

        assertThat(stringUnderTest.isEmpty()).isEqualTo(expected);
    }

    @Test
    void clear() {
        stringUnderTest.add(0, "test");
        System.out.println(stringUnderTest.size());
        stringUnderTest.clear();
        System.out.println(stringUnderTest.size());
        assertThat(stringUnderTest.size()).isEqualTo(0);
    }

    @Test
    void toArray() { // здесь нужно получить массив а у меня строка...
        stringUnderTest.add(0,"test");
        stringUnderTest.add(1,"test1");
        stringUnderTest.add(2,"test2");
        System.out.println(stringUnderTest.size());

        assertThat(stringUnderTest.toArray()).isEqualTo("test", "test", "test");
    }
}