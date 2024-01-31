//School კლასი(2018 წლის გამოცდის ამოცანა).
//თქვენი მიზანია დაწეროთ School კლასი, რომლის საშუალებითაც შევძლებთ
//უნივერსიტეტის მართვას. კლასს უნდა ჰქონდეს კონსტრუქტორი და 5 public მეთოდი.
//public School()
//კონსტრუქტორს არაფერი არ გადაეცემა. აქ შეგიძლიათ ინიციალიზაცია გაუკეთოთ
//თქვენთვის საჭირო ცვლადებს.
//public void addTeacher(String teacher)
//addTeacher მეთოდის საშუალებით შეგიძლიათ სკოლას დაამატოთ ახალი
//მასწავლებელი. მეთოდს გადაეცემა მასწავლებლის სახელი. შეგიძლიათ ჩათვალოთ,
//რომ მასწავლებლის სახელი უნიკალურია.
//public void addSubject(String teacher, String subject)
//addSubject მეთოდის საშუალებით შეგიძლიათ მასწავლებელს დაუმატოთ საგანი.
//მეთოდს გადაეცემა მასწავლებლის სახელი და საგნის სახელი. ჩათვალეთ, რომ საგნის
//სახელი უნიკალურია. ერთი და იგივე მასწავლებელი შეიძლება რამდენიმე საგანს
//კითხულობდეს, ასევე ერთსა და იმავე საგანს შეიძლება რამდენიმე მასწავლებელი
//კითხულობდეს ერთდროულად.
//თუკი teacher სახელის მქონე მასწავლებელი არ არის აქამდე დამატებული, მაშინ
//მეთოდმა არაფერი არ უნდა გააკეთოს.
//public void addPupil(String pupil, String subject)
//addPupil მეთოდის საშუალებით შეგიძლიათ საგანზე დაამატოთ მოსწავლე. ერთი და
//იგივე მოსწავლე შეიძლება ერთ ან რამდენიმე საგანს სწავლობდეს.
//public Iterator<String> getTeachers(String pupil)
//getTeachers მეთოდს გადაეცემა მოსწავლის სახელი და მან უნდა დააბრუნოს ამ
//მოსწავლის ყველა მასწავლებელზე იტერატორი. ანუ მხოლოდ იმ მასწავლებლების
//სახელები, რომლებიც ასწავლიან იმ საგნებს, რომლებზეც მოსწავლეა
//დამატებული(სწავლობს). თუკი pupil სახელის მოსწავლე არ გვყავს მაშინ მეთოდმა
//უნდა დააბრუნოს null.
//public Iterator<String> getPupils(String teacher)
//getPupils მეთოდს გადაეცემა მასწავლებლის სახელი და მან უნდა დააბრუნოს ამ
//მასწავლებლის ყველა სტუდენტზე იტერატორი. ანუ მხოლოდ იმ სტუდენტების
//სახელები, რომლებიც მის რომელიმე საგანს სწავლობენ. თუკი teacher სახელის მქონე
//ლექტორი არ გვყავს მაშინ მეთოდმა უნდა დააბრუნოს null.
//public void removeTeacher(String teacher)
//მეთოდმა უნდა წაშალოს მასწავლებლის შესახებ ყველა ინფორმაცია. ამ მეთოდის
//გამოძახების, შემდეგ getTeachers მეთოდმა არ უნდა დააბრუნოს teacher სახელი არც
//ერთი სტუდენტისთვის.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class schoolClassPractice {
	
	private HashMap<String, HashSet<String>> subjectTeacher;
	private HashMap<String, HashSet<String>> teacherSubject;
	private HashMap<String, HashSet<String>> pupilSubject;
	private HashMap<String, HashSet<String>> subjectPupil;
	
	public schoolClassPractice() {
		// shevqmnat chveni hashmapunebi am konstruqtoshi ro carieli ar davtovot da ar vawyeninot~
		subjectTeacher = new HashMap<>();
		teacherSubject = new HashMap<>();
		pupilSubject = new HashMap<>();
		subjectPupil = new HashMap<>();
	}
	
	public void addSubject(String teacher, String subject) {
		//aq unda davamatot teacherSubject is hashmapshi data, maswebi ras aswavlian chamonatvali
		if(!teacherSubject.containsKey(teacher)) {
			return;
		}
		
		teacherSubject.get(teacher).add(subject);
		//vipovet es teacheri da mivumatet subject
		//axla sapirispiro hashmapic gvaq da iqac unda movagvarot
		subjectTeacher.putIfAbsent(subject, new HashSet<String>());
		subjectTeacher.get(subject).add(teacher);
		//vipovet es subjecti da mivuweret teacher
	}
	
	public void addTeacher(String teacher) {
		//amit vamatebt masws, romelsac tavisi set aqvs im subjectebis romelsac aswavlis, romelic tavidan carielia
		teacherSubject.putIfAbsent(teacher, new HashSet<String>());
		//tu es teacher ar aris mapshi vamatebt!
	}
	
	public void addPupil(String pupil, String subject) {
		//es amatebs hashmaapshi moswavles da ra sagans swavlobs!
		//jer vamowmebt egeti sagan vabshe arsebobs tu ara
		if(!subjectTeacher.containsKey(subject)) {
			return;
		}
		// axla vamowmebt am sganze es adamiani aris ty ara
		pupilSubject.putIfAbsent(pupil, new HashSet<String>());
		pupilSubject.get(pupil).add(subject);
		
		subjectPupil.putIfAbsent(subject, new HashSet<String>());
		subjectPupil.get(subject).add(pupil);
	}
	
	public Iterator<String> getTeachers(String pupil){
		//abrunebs im mawavleblebs romelebic pupils aswavlian! 
		
		return null;
		
	}
	
	public Iterator<String> getPupils(String teacher){
		//adbrunebs im moswavleebis sias, romelebsac teacher maswi aswavlis!
		return null;
		
	}
	
	public void removeTeacher(String teacher) {
		//shlis masws hashmepidan!
		
	}
}
