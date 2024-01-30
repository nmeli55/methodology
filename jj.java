import acm.program.ConsoleProgram;

public class jj extends ConsoleProgram{
	public void run() {
		String str = readLine("enter string: ");
		println(statistics(str));
	}

	private String statistics(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i= i + count) {
			count = 1;
			if( i == str.length() - 1 ) {
				println("" + str.charAt(i) + 1);
			}else {
				for(int j = i; j < str.length(); j++) {
					if(j == str.length()-1 ) {
						println(""+str.charAt(i)+ count);
					} else {
					if(str.charAt(j)==str.charAt(j+1)) {
						count++;
					} else {
						println(""+str.charAt(i)+ count);
						break; 
					}
					}
			}
			}
		}
		return "";
	}
}
