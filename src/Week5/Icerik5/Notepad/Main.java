package Week5.Icerik5.Notepad;


import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try {
            CreateFile();
            ReadFile();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }




    }

    public static void CreateFile () throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter note:");
        String note = input.nextLine();

        FileWriter fileWriter = new FileWriter("notepad.txt",true);
        PrintWriter  output = new PrintWriter (fileWriter);
        output.println(note);

        output.close();

    }
    public static  void ReadFile() throws IOException {

        FileReader fileReader = new FileReader("notepad.txt");
        BufferedReader input = new BufferedReader(fileReader);

        String line;
        String lastLine = null;

        while ((line = input.readLine()) != null) {
            lastLine = line;
        }
        input.close();

        if (lastLine != null) {
            System.out.println("Last recorded text: " + lastLine);
        } else {
            System.out.println("The file is empty.");
        }

    }
}

