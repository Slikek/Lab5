import java.io.*;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) throws IOException {
        DataOutputStream wr = null;
        DataInputStream rd = null;
        DataInputStream rd2 = null;

        File f2 = null;
        try {
            File f1 = new File("number.txt");
            f1.createNewFile();

            wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.println("Введите количество слов");
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();
            Scanner sc2 = new Scanner(System.in);

            System.out.println("Введите слова: ");
            for(int i = 0; i < count; i++){
                wr.writeUTF(sc2.nextLine());
            }

            f2 = new File("results.txt");
            f2.createNewFile();


            rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));


            String readWord;
            int words = 0;
            try {
                while (true) {
                    readWord = rd.readUTF();
                    char[] charForWord = readWord.toCharArray();
                    if ((charForWord[0] == 'a') || (charForWord[0] == 'а') || (charForWord[0] == 'А') || (charForWord[0] == 'A')) {
                        System.out.println("Слово " + readWord);
                        wr.writeUTF(readWord);
                        words++;
                    }
                }
            } catch (EOFException e) {
                if(words == 0){
                    System.out.println("Нет слов начинающихся на А");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}