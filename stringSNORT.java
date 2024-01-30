//დაწერეთ მეთოდი, რომელსაც გადმოეცემა სტრინგების 
//ლისთი და სორტავს ამ ლისთს სტრინგების სიგრძის 
//მიხედვით კლებადობით(Final14)
//Tags: Algorithm, Sort, Custom order

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import acm.program.ConsoleProgram;

public class stringSNORT extends ConsoleProgram{
	public void run() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("aaa", "z", "bbbb", "zzzz", "111111"));
		
		ArrayList<String> list2 = new ArrayList<>(list);
		
		sortSecondWay(list);
		println(list);
		
	}
	
	private void sortOneWay(ArrayList<String> list) {
		//Comparator<String> c = Comparator.comparing(String::length).reversed();
		Comparator<String> c = Comparator.comparing(String::length);
		list.sort(c);
	}
	
	private void sortSecondWay(ArrayList<String> list) {
		for(int i = 0; i < list.size(); i++) {
			int j = findLongestString(list, i);
			swap(list, i, j);
		}
	}

	private void swap(ArrayList<String> list, int i, int j) {
		// swaps the next prev longest string with the new longest string, same thing as before, two pointers
		String temp = list.get(i);
		//arraylistebshi "es amas udris" sxvanairadaaa!!!!
		list.set(i, list.get(j));
		list.set(j, temp);
		
		
	}

	private int findLongestString(ArrayList<String> list, int i) {
		// finds or checks each time if the chosen string is the longest,we're looking for smalled index
		//to put the longest strin in the beggining of the array list
		int minIndex = i;
		for(int j = 0; j < list.size(); j++) {
			if(list.get(j).length() > list.get(minIndex).length()) {
				//anu yvelaze min indeqsiani shemdegi stringi agmochnda da undashevcvalot
				minIndex = j;
			}
		}
		return minIndex;
	}
}
