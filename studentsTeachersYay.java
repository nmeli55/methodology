//გაქვთ HashMap<String, String>  studentTeachers, 
//სადაც ვინახავთ მოსწავლე -> მასწავლებლის წყვილებს. 
//ყველა მოსწავლეს ერთი მასწავლებელი ჰყავს, ბევრ 
//მოსწავლეს შეიძლება იგივე მასწავლებელი ჰყავდეს.
//დაწერეთ boolean მეთოდი  validateTeachers, რომელსაც
//გადაეცემა ეს მეპი და ამოწმებს რომ არც ერთი მოსწავლის 
//წინაპარი მასწავლებელი(მასწავლებლის 
//მასწავლების… მასწავლებელი) არ გამოდის საკუთარი თავი.(Final15)
//	Tags: Algorithm, Maps 

import java.util.HashMap;

import acm.program.ConsoleProgram;

public class studentsTeachersYay extends ConsoleProgram{
	private HashMap<String, String> studentsTeachers = new HashMap<>();
	
	public void run() {
		HashMap<String, String>  map = new HashMap<>();
		
		map.put("1", "2");
		map.put("2", "4");
		map.put("3", "4");
		map.put("4", "7");
		map.put("5", "7");
		map.put("6", "7");
		
		println(validateTeachers(map));
		
		map.put("7", "1");
		
		println(validateTeachers(map));
	}
	
	private boolean validateTeachers(HashMap<String, String> studentTeacher) {
		//
		for(String student : studentTeacher.keySet()) {
			boolean currValid = validateCurrStudent(studentTeacher, student);
			if(!currValid) {
				//tu sadme agmochnda ara validuroba, mashin vchrit
				return false;
			}
		}
		
		return true;
	}

	private boolean validateCurrStudent(HashMap<String, String> studentTeacher, String student) {
		// TODO Auto-generated method stub
		String currStudent = studentTeacher.get(student);
		//vamowmebt, sanam es chveni current studenti arsebobs mapshi, vedzebs mas value ebshi
		while(studentTeacher.containsKey(currStudent)) {
			if(currStudent.equals(student)) {
				return false;
				//agmovachinet rom sadgac magalitad ana ---> lizi, lizi ---> ana
			}
		}
		return false; //araferi egeti
	}
}
