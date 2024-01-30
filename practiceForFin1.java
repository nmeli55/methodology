//დაწერეთ გრაფიკული პროგრამა, რომელიც იქნება Map<String, String> - ის ვიზუალიზაცია. 
//canvas-ის სამხრეთით დაამატეთ ორი textField: key, value
//სამი ღილაკი: add, remove, get. 
//კანვასის მარცხენა მხარეს მუდმივად უნდა ჩანდეს map-ის ახლანდელი 
//მდგომარეობა - ყოველი key-value წყვილი ახალ ხაზზე.
//get ღილაკზე დაჭერის შემდეგ კანვასის მარჯვენა მხარეს უნდა გამოჩნდეს
//key value წყვილი, რომელიც შეესაბამება textField key- ში შეყვანილ ტექსტს
//add ღილაკზე დაჭერისას ემატება textField-ში key-value წყვილი
//remove ღილაკზე დაჭერისას თუ value Field ცარიელია, უნდა წაიშალოს 
//key field-ის შესაბამისი ელემენტი, თუ სავსეა უნდა წაიშალოს ისეთი 
//ელემენტი , რომელიც key - value წყვილს შეესაბამება
//ღილაკზე დაჭერის შემდეგ field-ები გაასუფთავეთ.
//Tags: Interactors, Graphics, Map

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;


public class practiceForFin1  extends GraphicsProgram{
	private JButton add;
	private JButton remove;
	private JButton get;
	private GLabel text;
	private JTextField key;
	private JTextField value;
	private double x = 50;
	private double y = 30;
	private int counter =1;
	private GLabel right;
	
	
	public void init() {
		add = new JButton("Add");
		remove = new JButton("Remove");
		get = new JButton("Get");
		key = new JTextField(15);
		value = new JTextField(15);
		JLabel keyName = new JLabel("Key:");
		JLabel valueName = new JLabel("Value:");
		add(keyName, SOUTH);
		add(key, SOUTH);
		add(valueName, SOUTH);
		add(value, SOUTH);
		add(add,SOUTH);
		add(remove,SOUTH);
		add(get, SOUTH);
	}
	private Map<String, String> map = new HashMap<String, String>();
	public void run() {
		addActionListeners();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == add) {
			if(!key.getText().equals(" ") && !value.getText().equals(" ")) {
				text = new GLabel(key.getText() + "-" + value.getText());
				add(text, x, y * counter);
				counter++;
				map.put(key.getText(), value.getText());
			}
			
		} else if( e.getSource() == remove) {
			if(!key.getText().equals(" ") && !value.getText().equals(" ")) {
				remove(text);
				map.remove(key.getText(), value.getText());
			} else if(!key.getText().equals(" ")) {
				if(map.containsKey(value.getText())) {
					map.remove(key.getText(), value.getText());
					remove(text);
				}
			} else if(!value.getText().equals(" ")) {
				if(map.containsValue(value.getText())) {
					map.remove(key.getText(), value.getText());
					remove(text);
				}
				
			}
		} else if(e.getSource() == get) {
			if(value.getText().equals(map.get(key.getText()))) {
				right = new GLabel(map.get(key.getText()));
				add(right, getWidth() - 50, counter * y);
				//add visually on canvas
			} else if(key.getText().equals(map.containsKey(key.getText()))) {
				//add visually on canvas
				right = new GLabel(map.get(key.getText()));
				add(right, getWidth() - 50, counter * y);
			}
		}
		
	}

}
