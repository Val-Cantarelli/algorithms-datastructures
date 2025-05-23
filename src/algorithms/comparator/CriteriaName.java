package algorithms.comparator;

import java.util.Comparator;
import algorithms.base.Person;

public class CriteriaName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}