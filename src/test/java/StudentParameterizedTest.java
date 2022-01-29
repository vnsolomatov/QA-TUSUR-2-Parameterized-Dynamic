import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StudentParameterizedTest {
	
	@ParameterizedTest
	  @CsvSource({
	            "18,19,20,21,22,23,24,25",
	            "26,27,28,29,30,31,32,33,34,35,36",
	            "37,38,39,40,41,42,43,44,45,46,47,48,49"
	    })
	    void test_csv(String ages) {
			String[] ageA = ages.split(",");
			Student[] sA = new Student[ageA.length];
			int sum = 0;
			for (int i = 0; i < ageA.length; i++) {
				sA[i] = new Student();
				sA[i].setAge(Integer.parseInt(ageA[i]));
				sum += Integer.parseInt(ageA[i]);
			}
	        assertEquals(sum/ageA.length, Student.avgAge(sA));
	    }
}
