package task2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите текст:");

		String text = scanner.nextLine();

		System.out.println(replaceVowels(text));
	}

	static String replaceVowels(String text) {

		char textArray[] = text.toCharArray();
		char vowelArray[] = { 'а', 'о', 'э', 'и', 'у', 'ы', 'е', 'ё', 'ю', 'я', 'А', 'О', 'Э', 'И', 'У', 'Ы', 'Е', 'Ё',	'Ю', 'Я' };

		for (int i = 0; i < textArray.length; i++) {

			for (int j = 0; j < vowelArray.length; j++) {

				if (textArray[i] == vowelArray[j]) {
					textArray[i] = '-';
				}
			}
		}

		String newText = new String(textArray);
		return newText;
	}

}
