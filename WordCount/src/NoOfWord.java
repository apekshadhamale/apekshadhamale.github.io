
import java.util.ArrayList;
import java.util.Scanner;

public class NoOfWord {
	public static void main(String[] args) {
		String  s1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String :");
		s1 = sc.nextLine();
		String[] s2 = s1.split("[[.]*[\\.]*|[!]*|[?]]+");
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < s2.length; i++) {
			int word_count = 0;
			String temp_string = s2[i].trim();
			String[] wordArray = temp_string.split(" ");
			System.out.println(temp_string);
			for (int j = 0; j < wordArray.length; j++) {
				wordArray[j] = wordArray[j].trim();
				if (wordArray[j].length() != 0 && wordArray[j] != null) {
					word_count++;
				}
			}
			al.add(word_count);
		}
		int min = al.get(0);
		int max = al.get(0);
		for (int i = 0; i < al.size(); i++) {
			int number = al.get(i);
			if (number < min) {
				min = number;
			}
			if (number > max) {
				max = number;
			}
		}
		System.out.println("Max word count is :" + max);
	}

}
