import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class StudentDynamicTest {
	
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
    Stream<DynamicTest> dynamicPosiTestGetFirstName() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr", "Petrov", 19));
		k.add(new Student("Ivan", "Ivanov", 29));
		k.add(new Student("Sidor", "Sidorov", 39));
		k.add(new Student("Kirill", "Kirillov", 49));
		for(int i=0; i < k.size(); i++) {
			String fN = k.get(i).getFirstName();
			String[] fnA = fN.split("-");
			for (int j=0; j < fnA.length; j++) {
				String everyFN = fnA[j];
				dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(everyFN.charAt(0) >= 'A' & everyFN.charAt(0) <= 'Z');}));
			}
		}
		return dynamicTests.stream();
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicNegaTestGetFirstName() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr1", "Petrov", 19));
		k.add(new Student("IvanÚ", "Ivanov", 29));
		k.add(new Student("sidor", "Sidorov", 39));
		k.add(new Student("KKirill", "Kirillov", 49));
		for(int i=0; i < k.size(); i++) {
			String fN = k.get(i).getFirstName();
			String[] fnA = fN.split("-");
			for (int j=0; j < fnA.length; j++) {
				String everyFN = fnA[j];
				dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(everyFN.charAt(0) >= 'A' & everyFN.charAt(0) <= 'Z');}));
			}
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
			String[] lnA = lN.split("-");
			for (int j=0; j < lnA.length; j++) {
				String everyLN = lnA[j];
				dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(everyLN.charAt(0) >= 'A' & everyLN.charAt(0) <= 'Z');}));
			}
		}
		return dynamicTests.stream();
    }
	
	@TestFactory
    Stream<DynamicTest> dynamicNegaTestGetLastName() {
		List<DynamicTest> dynamicTests = new ArrayList<>();
		List<Student> k = new ArrayList<Student>();
		k.add(new Student("Petr", "Petrov2", 19));
		k.add(new Student("Ivan", "IvanovÚ", 29));
		k.add(new Student("Sidor", "sidorov", 39));
		k.add(new Student("Kirill", "Kirilëov", 49));
		for(int i=0; i < k.size(); i++) {
			String lN = k.get(i).getLastName();
			String[] lnA = lN.split("-");
			for (int j=0; j < lnA.length; j++) {
				String everyLN = lnA[j];
				dynamicTests.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(everyLN.charAt(0) >= 'A' & everyLN.charAt(0) <= 'Z');}));
			}
		}
		return dynamicTests.stream();
    }
	
}
