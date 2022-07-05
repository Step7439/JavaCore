package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        System.out.print("Численость несовершеннолетних ");
        long streamAge = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(streamAge);

        System.out.println("Список призывников");
        persons.stream()
                .filter(person -> person.getAge() > 18)
                .map(Person::getFamily)
                .toList()
                .forEach(System.out::println);

        List<Person> sortFemily = persons.stream()
                .filter(person -> person.getAge() < 65 || person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() < 60 || person.getSex().equals(Sex.WOMAN))
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        sortFemily.forEach(System.out::println);

    }                   
}