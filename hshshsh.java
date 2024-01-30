import acm.program.ConsoleProgram;

public class hshshsh extends ConsoleProgram{
	public void run(){
		String wow ="";
		String text = "hello";
		String reverse = "";
		for(int i = text.length()-1; i >= 0 ; i--){
			wow  = wow + text.charAt(i);
		}
		println(wow);
	}
}
