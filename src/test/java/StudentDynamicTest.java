import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class StudentDynamicTest {
	
	boolean isDoubleName(String anyName) {	//метод определяет содержит ли имя или фамилия дефис
		char[] aNA = anyName.toCharArray();
		boolean iDN = false;
		for (int j=0; j < aNA.length; j++) {
			if ('-' == aNA[j]) iDN = true;	
		}
		System.out.println(iDN);
		return iDN;
	}

	char getFirstLetterSecondName(String anyName) {	//метод возвращает символ после дефиса
		char[] aNA = anyName.toCharArray();
		char fLSN = aNA[0];
		for (int j=0; j < aNA.length; j++) {
			if ('-' == aNA[j]) fLSN = aNA[j+1];	
		}
		System.out.println(fLSN);
		return fLSN;
	}
	 
	@TestFactory
    Stream<DynamicTest> dynamicPosiTestGetAge() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr", "Petrov", 19));
		k.add(new Student("Ivan", "Ivanov", 29));
		k.add(new Student("Sidor", "Sidorov", 39));
		k.add(new Student("Kirill", "Kirillov", 49));
		int minAge = 18;
		int maxAge = 49;
		for(int i=0; i < k.size(); i++) {
			int x = k.get(i).getAge();
			dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(minAge <= x & x <= maxAge);}));
		}
		return dynamicTests.stream();
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicNegaTestGetAge() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr", "Petrov", 17));
		k.add(new Student("Ivan", "Ivanov", 'a'));
		k.add(new Student("Sidor", "Sidorov", -1));
		k.add(new Student("Kirill", "Kirillov", 50));
		int minAge = 18;
		int maxAge = 49;
		for(int i=0; i < k.size(); i++) {
			int x = k.get(i).getAge();
			dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(minAge <= x & x <= maxAge);}));
		}
		return dynamicTests.stream();
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicTestGetDoubleFirstName() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Mary-Ann", "Petrov", 19));//метод класса Student запишет второе имя со строчной буквы: Mary-ann
		k.add(new Student("Ivan", "Ivanov", 29));
		k.add(new Student("Sidor", "Sidorov", 39));
		k.add(new Student("Kirill", "Kirillov", 49));
		for(int i=0; i < k.size(); i++) {
			String fN = k.get(i).getFirstName();		
			if (isDoubleName(fN)) {
				dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue((getFirstLetterSecondName(fN) >= 'a' & getFirstLetterSecondName(fN) <= 'z')&(fN.charAt(0) >= 'A' & fN.charAt(0) <= 'Z'));}));
				System.out.println(fN);
			}
			else 
				dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue((fN.charAt(0) >= 'A' & fN.charAt(0) <= 'Z'));}));
		}
		return dynamicTests.stream();
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicNegaTestGetFirstName() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr1", "Petrov", 19));
		k.add(new Student("IvanЪ", "Ivanov", 29));
		k.add(new Student("sidor", "Sidorov", 39));
		k.add(new Student("KKirill", "Kirillov", 49));
		for(int i=0; i < k.size(); i++) {
			String fN = k.get(i).getFirstName();
			dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(fN.charAt(0) >= 'A' & fN.charAt(0) <= 'Z');}));
		}
		return dynamicTests.stream();
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicPosiTestGetLastName() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr", "Petrov", 19));
		k.add(new Student("Ivan", "Ivanov", 29));
		k.add(new Student("Sidor", "Sidorov", 39));
		k.add(new Student("Kirill", "Kirillov", 49));
		for(int i=0; i < k.size(); i++) {
			String lN = k.get(i).getLastName();
			dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(lN.charAt(0) >= 'A' & lN.charAt(0) <= 'Z');}));
		}
		return dynamicTests.stream();
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicNegaTestGetLastName() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr", "Petrov2", 19));
		k.add(new Student("Ivan", "IvanovЪ", 29));
		k.add(new Student("Sidor", "sidorov", 39));
		k.add(new Student("Kirill", "Kirilлov", 49));
		for(int i=0; i < k.size(); i++) {
			String lN = k.get(i).getLastName();
			dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(lN.charAt(0) >= 'A' & lN.charAt(0) <= 'Z');}));
		}
		return dynamicTests.stream();
    }
	
}
