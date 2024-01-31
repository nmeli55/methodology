import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
//თქვენი ამოცანაა დაწეროთ გრაფიკული პროგრამა, რომელიც მოგვცემს ბურთთან
//თამაშის შესაძლებლობას. პროგრამის გაშვებისას BALL_SIZE ზომის ბურთი უნდა
//გაჩნდეს ფანჯრის ცენტრში და დაიწყოს შემთხვევითი სიჩქარით და
//მიმართულებით მოძრაობა. ფანჯრის ოთხივე კედლებზე დაჯახების შემთხვევაში
//ბუთრი უნდა აირეკლოს და იცვლიდეს მიმართულებას(ისევე როგორც ბრეიქაუთში).
//ფანჯარას სამხრეთ რეგიონზე უნდა ჰქონდეს ორი ტექსტფილდი რომლებშიც
//შეგვიძლია ჩავწეროთ მთელი რიცხვები Vx ან Vy. ტექსტფილდში რიცხვის
//ჩაწერის და ენტერზე დაჭერის შემთხვევაში ბურთის სიჩქარე უნდა იცვლებოდეს
//იმ რიცხვით რაც ჩაიწერა(თუკი მარცხენა ტექსტფილდში ჩავწერეთ მაშინ უნდა
//შეიცვალოს ბურთის x ღერძის მიმართ სიჩქარე, თუკი მარჯვენაში მაშინ უნდა
//შეიცვალოს y ღერძის მიმართ სიჩქარე). ჩათვალეთ, რომ ტექსტფილდში
//მომხმარებელი ყოველთვის მთელ რიცხვს ჩაწერს.
//ბურთზე შეგვიძლია მაუსით ზემოქმედება. კერძოდ, თუკი ბურთს სამჯერ ზედიზედ
//დააკლიკებთ მაუსით მაშინ ის უნდა გაჩერდეს. ხოლო თუკი გაჩერებულ ბურთს
//ორჯერ ზედიზედ დააკლიკებთ მაშინ განაგრძოს მოძრაობა იმ სიჩქარით და
//მიმართულებით რა სიჩქარითაც მოძრაობდა მანამდე.
//ბურთზე ზედიზედ დაკლიკება ნიშნავს რომ ბურთზე ერთი დაკლიკებიდან მეორე
//დაკლიკებამდე მომხმარებელს სხვაგან არსად არ დაუკლიკებია.
//ამოხსნა დაწერეთ game.java ფაილში
public class graphicsForFin extends GraphicsProgram{
	private JTextField vx, vy;
	private JLabel xSpeed, ySpeed;
	private GOval ball;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int ranSpeedX = rgen.nextInt(-2, 2);
	private int ranSpeedY = rgen.nextInt(-2, 2);
	private JButton changeX, changeY;
	public void init() {
		int centerX = getWidth()/2 - 50;
		int centreY = getHeight()/2 - 50;
		ball = new GOval(100, 100);
		ball.setFilled(true);
		add(ball, centerX, centreY);
		xSpeed = new JLabel("X coordinate speed:");
		add(xSpeed, SOUTH);
		vx = new JTextField(10);
		add(vx, SOUTH);
		changeX = new JButton("ChangeX");
		add(changeX, SOUTH);
		ySpeed = new JLabel("Y coodrindate speed:");
		add(ySpeed, SOUTH);
		vy = new JTextField(10);
		add(vy, SOUTH);
		changeY = new JButton("ChangeY");
		add(changeY, SOUTH);
		
	}
	public void run() {
		addActionListeners();
		addMouseListeners();
		while(true) {
			ball.move(ranSpeedX, ranSpeedY);
			ball.pause(4);
			checkWalls();
		}
		
	}
	private void checkWalls() {
		//reflections
		if((ball.getY() <= 0 ) || (ball.getY() + 100 >= getHeight())) {
			ranSpeedY = - ranSpeedY;
			//ranSpeedX = ranSpeedX + rgen.nextDouble(-1, 1);
		} else if((ball.getX() <= 0 ) || (ball.getX() + 100 >= getWidth())) {
			ranSpeedX = - ranSpeedX;
			//ranSpeedY = ranSpeedY + rgen.nextDouble(-1, 1);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == changeX) {
			changeBallSpeedX(vx.getText());
		} else if(e.getSource() == changeY) {
			changeBallSpeedY(vy.getText());
		}
	}
	private void changeBallSpeedY(String text) {
		// changes x speed
		ranSpeedY = (int) changeToInt(text);
	}
	private void changeBallSpeedX(String text) {
		// changes Y speed
		ranSpeedX = (int) changeToInt(text);
	}
	private double changeToInt(String text) {
		// changes the input of the string "9" to int 9 
		int number = 0;
		for(int i = 0; i < text.length(); i++) {
			int n = text.charAt(i) - '0';
			number = number * 10 + n;
		}
		return number;
	}
	
	public void mouseClicked(ActionEvent e) {
		if(e.equals(ball)) {
			ranSpeedX = 0;
			ranSpeedY = 0;
		}
	}
}
