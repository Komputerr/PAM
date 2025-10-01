
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\student\\Desktop\\liczby.txt");

        try {

            Scanner sc = new Scanner(file);
            int maxil = 0;
            int maxl =0;
            int maxlr =0;
            int maxr =0;

            while (sc.hasNextInt()) {
                int i = sc.nextInt();
                int h = i;
                int counter =0;
                int counterr =0;
                int dziel = 2;
                while(h > 1)
                {
                    int p =0;
                    while(h%dziel==0)
                    {
                        counter++;
                        h/=dziel;
                        if(p<1)
                        {
                            counterr++;
                        }
                        p++;
                    }dziel++;

                    if(counter>maxil)
                    {
                        maxil = counter;
                        maxl = i;
                    }
                    if(counterr>maxlr) {
                        maxlr = counterr;
                        maxr = i;
                    }

                }

            }
            System.out.println(maxl+" "+maxil);
            System.out.println(maxr+" "+maxlr);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}