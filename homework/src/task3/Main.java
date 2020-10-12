package task3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите текст:");

		String text = scanner.nextLine();
		String textArray[] = text.split("[.!?]");

		System.out.println("Количество слов в тексте - " + countWords(text));
		System.out.println("Количество предложений в тексте - " + countSentences(text));
		viewMostUsedWord(textArray[0]);
		viewMostUsedWord(text);
	}

	
	static int countWords(String text) {

		String textArray[] = text.split(" ");
		int counter = 0;

		for (int i = 0; i < textArray.length; i++) {

			if (textArray[i].length() > 1) {
				counter++;
			}
		}

		return counter;
	}

	
	static int countSentences(String text) {

		String textArray[] = text.split("[.!?]");
		int counter = 0;

		for (int i = 0; i < textArray.length; i++) {

			if (textArray[i].trim().length() > 1) {
				counter++;
			}
		}

		return counter;
	}

	
	static void viewMostUsedWord(String text) {

		String newText = deleteNonLiteralSymbols(text);
		String textArray[] = newText.toLowerCase().split(" ");

		/*
		 * массив индексов {позиция слова в текстовом массиве, количество встречающихся раз};
		 * храним позицию слова, которое встречается в тексте максимальное количество раз
		 */
		int indexArray[] = { 0, -1 };
		int counter = 0;

		for (int i = 0; i < textArray.length; i++) {

			// обрабатываем первый элемент текстового массива

			// первому слову в текстовом массиве всегда присваиваем в счетчик единицу
			if (indexArray[1] < 0) {
				counter = 1;
			}
			// если слово в тексте не первое, сравниваем его с тем, что на данный момент встречалось наибольшее количество раз
			// если они не равны, т.е. текущее слово новое - присваиваем в счетчик единицу
			else if (!textArray[indexArray[0]].equals(textArray[i])) {
				counter = 1;
			}
			// если слова равны, т.е. текущее слово мы уже просчитали ранее, выходим из итерации цикла
			else {
				continue;
			}

			for (int j = i + 1; j < textArray.length; j++) {

				if (textArray[i].equals(textArray[j])) {
					counter++;
				}
			}

			if (indexArray[1] <= counter) {
				indexArray[0] = i;
				indexArray[1] = counter;
				// System.out.println(i+1 + ". --> " + i + " " + counter);
			}
			// System.out.println(i+1 + ". " + i + " " + counter);
		}

		System.out.println(
				"Самое повторяющееся слово: " + textArray[indexArray[0]] + " (встречается " + indexArray[1] + " раз)");
	}

	
	static String deleteNonLiteralSymbols(String text) {

		String newText = text.replaceAll("[.,:;!?@#$%^*(){}«»]", "");
		return newText;
	}
}
