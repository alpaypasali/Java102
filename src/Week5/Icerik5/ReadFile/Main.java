package Week5.Icerik5.ReadFile;

import javax.imageio.IIOException;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        String[] a = {"1" , "2" , "3" , "4"};
        try {
            CreateFile(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(ReadFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CreateFile (String[] value) throws IOException {
        FileWriter fileWriter = new FileWriter("input.txt",false);
        BufferedWriter output = new BufferedWriter(fileWriter);
        for(String v : value){

            output.write(v);
            output.newLine();

        }
        output.close();

    }
    public static  int ReadFile() throws IOException {

        FileReader fileReader = new FileReader("input.txt");
        BufferedReader input = new BufferedReader(fileReader);
        String line;
        int sum = 0;
        while ((line = input.readLine()) != null) {
           sum += Integer.parseInt(line);
        }
        input.close();
        return  sum;

    }
}
