
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\student\\Desktop\\liczby.txt");

        try {

            Scanner sc = new Scanner(file);
            int counter = 0;
            int pierwsza_liczba = 0;
            boolean znjdz = false;
            while (sc.hasNextInt()) {
                int i = sc.nextInt();
                int h = i;
                int ostatnia = i % 10;
                int pierwsza = 0;


                while (h > 0) {
                    pierwsza = h % 10;
                    h /= 10;
                }
                if (ostatnia == pierwsza) {

                    if(znjdz == false)
                    {
                        pierwsza_liczba = i;
                    }
                    znjdz = true;

                    //System.out.println(i);
                    counter++;
                }


            }
            System.out.println(counter);
            System.out.println(pierwsza_liczba);

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}