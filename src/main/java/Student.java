class Student {
	
	private String firstName;
	private String lastName;
	private int age;

	public Student(String firstName, String lastName, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

	public Student() {
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() > 1) {
			this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
		} else {
				this.firstName = firstName.toUpperCase();
				}	
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.length() > 1) {
			this.lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1).toLowerCase();
		} else {
			this.lastName = lastName;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age > 17 && age < 50 ? age : 18;
	}

	public String getFullName() {
		return getLastName() + " " + getFirstName();
	}

	public static int avgAge(Student [] array) {
		int avg = 0;
		int ageSum=0;	
		for (int i = 0; i < array.length; i++) {
			ageSum += array[i].getAge();
		}
		avg= ageSum / array.length;
		return avg;
	}
	
	public static int minAge(Student [] array) {
		int min=100;		
		for (int i=0; i < array.length; i++){
			if (array[i].getAge() < min) { 
				min = array[i].getAge();
			}
		}
		return min;
	}
		
	public static int maxAge(Student [] array) {
		int max=0;
		for (int i=0; i < array.length; i++){
			if (array[i].getAge() > max) {
				max = array[i].getAge();
			}
		}
		return max;
	}
}
