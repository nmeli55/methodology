/*
* File: Hangman.java
* ——————
* This program will eventually play the Hangman game from
* Assignment #4.
*/

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

private String secretWord;
private String guessHiddenWord;
private int guessCtr = 8;

private RandomGenerator rgen = RandomGenerator.getInstance();
private HangmanLexicon hangmanListWords = new HangmanLexicon();

public void run(){

setupGame();
playGame();
}

private void setupGame(){

println(“Welcome to Hangman!”);
secretWord = wordPicker();
guessHiddenWord = wordFirstUpdate();
guessCtrUpdate();
}

private void playGame(){

while(true){

String guess = readLine(“Your guess: “);
guess = guess.toUpperCase();

while( validGuess(guess) == false){

guess = readLine(“Your guess: “);
guess = guess.toUpperCase();

}

checkLetter(guess);

if(checkWinLoss() == false){

wordUpdate();
guessCtrUpdate();
}else{
break;
}
}

}

private boolean checkWinLoss(){

if( guessCtr == 0){
println(“You’re completely hung.”);
println(“The word was: ” + secretWord);
println(“You lose.”);
return true;
}else if ( guessHiddenWord.equals(secretWord)){
println(“You guessed the word: ” + secretWord);
println(“You win.”);
return true;
}
return false;
}

private void wordUpdate(){
println(“The word now looks like this: ” + guessHiddenWord);
}

private void checkLetter(String guess){

	if( secretWord.indexOf(guess) == -1){
	guessCtr–;
	println(“There are no ” + guess + “‘s in the word.”);
	}else{
	println(“That guess is correct.”);
	for( int i = 0; i < secretWord.length(); i++){
	
	if( secretWord.charAt(i) == guess.charAt(0) && i !=0){
	guessHiddenWord = guessHiddenWord.substring(0,i) + guess + guessHiddenWord.substring( i + 1);
	}else if(secretWord.charAt(i) == guess.charAt(0) && i == 0){
	guessHiddenWord = guess + guessHiddenWord.substring(i + 1);
	}
	}
	}
}

private boolean validGuess(String guess){

if(guess.length() > 1){
return false;
}else if( Character.isDigit(guess.charAt(0))){
return false;
}
return true;
}

private String wordPicker(){
int wordIndexInt = rgen.nextInt(0,hangmanListWords.getWordCount() – 1);
String wordSelected = hangmanListWords.getWord(wordIndexInt);
return wordSelected;
}

private String wordFirstUpdate(){
String result = “”;

for( int i = 0; i < secretWord.length(); i++){
result = result + “-“;
}
println(“The word now looks like this: ” + result);
return result;
}

private void guessCtrUpdate(){
println(“You have ” + guessCtr + ” guesses left.”);
}
}