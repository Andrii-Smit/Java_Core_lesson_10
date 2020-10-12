package task1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите слово из пяти букв:");

		String word = scanner.next();

		if (word.length() == 5) {
			String wordArray [] = word.split("");
			
			if ((wordArray[0].equalsIgnoreCase(wordArray[4])) && (wordArray[1].equalsIgnoreCase(wordArray[3]))) {
				System.out.println("Введенное слово " + word + " - палиндром!");
			} else {
				System.out.println("Введенное слово " + word + " - не является палиндромом!");
			}
		} else {
			System.out.println("Необходимо ввести слово из пяти букв!");
		}
	}
}
