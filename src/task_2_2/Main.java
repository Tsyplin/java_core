package task_2_2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
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

		// 1.Найти количество несовершеннолетних (т.е. людей младше 18 лет).
		Stream<Person> young = persons.stream();
		long countYoung = young
				.filter(person -> person.getAge() <= 18)
				.count();
//
		// 2.Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
		Stream<Person> conscriptStream = persons.stream();
		List<String> conscript;
		conscript = conscriptStream
				.filter(person -> Sex.MAN.equals(person.getSex()))
				.filter(person -> person.getAge() >= 18)
				.filter(person -> person.getAge() <= 27)
				.map(Person::getFamily)
				.collect(Collectors.toList());

		// 3.Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
		Stream<Person> workPeopleStream = persons.stream();
		List<Person> workPeople = workPeopleStream
				.filter(person -> Education.HIGHER.equals(person.getEducation()))
				.filter(person -> person.getAge() >= 18)
				.filter(person -> person.getAge() <= 65)
				.filter(person -> !(person.getAge() > 60 && person.getSex().equals(Sex.WOMAN)))
				.sorted(Comparator.comparing(Person::getFamily))
				.toList();
//		System.out.printf("%,d\n", workPeople.size());
//
//		workPeople.stream()
//				.limit(10)
//				.forEach(System.out::println);
	}
}
