package Week5.İçerik2.MostFrequentWord;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a text: ");
        String text = scanner.nextLine().toLowerCase();

        String[] words = text.split(" ");
        HashMap<String , Integer> maps =new HashMap<>();

        for(int i = 0 ; i < words.length; i++){

            if(!maps.containsKey(words[i])){
                maps.put(words[i], 1);
            }
            else{
                maps.put(words[i], maps.get(words[i]) + 1);
            }

        }
        for (String a : maps.keySet()) {
            System.out.println("Words : " + a + " \t Count = " + maps.get(a));
        }



    }
}
