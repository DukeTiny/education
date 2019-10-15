import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {

    public static void main( String[] args ) {
        Stream<String> stream = Stream.of("1", "2", "3");
//        Stream<Integer> integerStream = stream.map(Integer::parseInt);
//        Stream<Person> personStream = stream.map(Person::new);
        stream.forEach(System.out::println);
    }

    public static void consumer(String target,Consumer<String> consumer) {
        consumer.accept(target);
    }

    public static void consumer2(String target,Consumer<String> consumer1,Consumer<String> consumer2) {
        consumer1.accept(target);
        consumer2.accept(target);
//        consumer1.andThen(consumer2).accept(target);
    }



}
class Person{
    private String name;
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
