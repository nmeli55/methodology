//დაწერეთ მეთოდი -  private void randomSort(ArrayList<Integer> list) 
//რომელსაც გადაეცემა integer-ების arrayList და რომელიც ამ სიის 
//ელემენტებს გადაალაგებს რანდომ თანმიმდევრობით. ანუ შემთხვევითი 
//მიმდევრობის ამოსვლის ალბათობა ყველა სხვა მიმდევრობასთან შედარებით 
//თანაბარ ალბათური უნდა იყოს.(Final13)
//Tags: ArrayList, Custom Sort, Random

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class randomSNORT extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2,4,7,1,3));
//		int amount = readInt("Enter the amount of numbers you want in an array!~");
//		for(int i = 0; i < amount; i++) {
//			numbers.add(i, readInt("Enter Number:"));
//		}
//		println("Your array: " + numbers);
		//println("Your array, but sorted: " + randomSort(numbers));
		
		HashMap<ArrayList<Integer>, Integer> stat = new HashMap<>();
		
		for(int i = 0; i < 10000; i++) {
			randomSort(numbers);
			
			ArrayList<Integer> listForStatistics = new ArrayList<>(numbers);
			//vamowmebt ramdenjeraa chems statstikis hashmapshi es iteracia da vitvli
			
			if(!stat.containsKey(listForStatistics)) {
				stat.put(listForStatistics, 1);
				//pirvelad davamatet
			} else {
				//anu aqamde yofila chems mapshi, stattistikashi eseti randomvairanti da +1 unda mivuwerot
				stat.put(listForStatistics, stat.get(listForStatistics) + 1);
			}
		}
		
		//warvadginot chveni cxrili tu racaa~~ keyset inaxavs am oermutaciebs da gadavuyvet for it
		for(ArrayList<Integer> keys : stat.keySet()) {
			println(keys.toString() + ": " + stat.get(keys)) ;
		}
	}
	
	
	private void randomSort(ArrayList<Integer> list) {
		//swaps numbers randomly OwO
		for(int i = 0; i < list.size(); i++) {
			int j = rgen.nextInt(0, list.size() - 1);
			swapNums(list, i , j);
		}
		
	}


	private void swapNums(ArrayList<Integer> list, int i, int j) {
		// does the magic swap-swap thing (two pointers)
		int tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
		
		
	}
}
