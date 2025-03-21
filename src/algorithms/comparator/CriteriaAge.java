package algorithms.comparator;
import java.util.Comparator;
import algorithms.base.Person;

public class CriteriaAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
