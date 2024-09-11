package val.base;

import comparator.CriteriaAge;
import comparator.CriteriaName;
import java.util.*;

public class Person implements Comparable<Person>{

     static Comparator<Person> comparator = new PersonComparator();
     /*
    Esse "comparator" é um atributo static da class val.base.Person e é uma instância de PersonComparator.
    O fato de ser static significa que é da classe val.base.Person, mas compartilhado pelas instância de val.base.Person.
    Então:
    Quando tenho 2 instâncias de val.base.Person para serem comparadas, acesso o metodo "compareTo()"
    de val.base.Person que delega para PersonComparator, mais especificamente o compare()

    Se eu quiser fazer um outro critério de comparacão(data de nascimento), posso escrever outra classe e ter
    um outro atributo static de Penson que é uma instância dessa classe.

    Ps: e isso tudo porque Java permite apenas objetos e primitivos como parâmetros. Por isso, a necessidade
    de classe encapsulando o metodo ao invés de apenas passar o método.
    PS2: falar de final

    */




    private String name;
    private int age;

    // Construtor e métodos getter
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    @Override
    public int compareTo(Person other) {
        //não tem código porque esse metodo, que é da instancia, delega a comparacao para o comparador da classe.
        // É o que essa linha significa:
        return Person.comparator.compare(this, other);
    }

    public static class PersonComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            // Primeiro critério: comparar por idade
            int ageComparison = Integer.compare(p1.getAge(), p2.getAge());

            // Se as idades são diferentes, retornar o resultado da comparação por idade
            if (ageComparison != 0) {
                return ageComparison;
            }

            // Segundo critério: se as idades são iguais, comparar por nome
            return p1.getName().compareTo(p2.getName());
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 30));
        people.add(new Person("David", 25));
        // Ordenar usando o PersonComparator


        // aqui o sort usou como criterio de ordenacao o que estava no Person.comparator
        // que nesse momento é uma instancia do PersonComparator.
        Collections.sort(people);

        // mas a gente poderia usar outros criterio:
        // aqui a gente passou o criterio CriteriaName
        Collections.sort(people, new CriteriaName());

        // aqui a gente alterou o Person.comparator (re-assigned) - isso foi possível pq
        // comparator não é final
        Person.comparator = new CriteriaAge();
        // entao agora, o sort vai usar como criterio o CriteriaAge
        Collections.sort(people);

        // a gente também poderia criar uma criterio on-the-fly
        // criando uma classe anonima(new Comparator<Person>() - new na interface é falar pro Java criar
        // uma classe anonima).
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return Integer.compare(person1.getAge(), person2.getAge());
            }
        });

        // Sugar syntax:
        Collections.sort(people, (people1, people2) -> Integer.compare(people1.getAge(), people2.getAge()));
        // O .sort exige um Comparator, então o Java quando vê lambda(->) com sort ele cria
        // uma classe anonima que implements Comparator
        // e cria uma nova instancia dessa classe anonima.

        // o Java também fornece outras formas  (ainda mais enxuta) de criar comparadores
        Collections.sort(people, Comparator.comparingInt(Person::getAge));

        for (Person person : people) System.out.println(person);
    }

}




