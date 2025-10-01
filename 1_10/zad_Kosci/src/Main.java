import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int kosci;
        do{
            System.out.println("Ile kostek chcesz rzucic(3-10)");
            kosci = input.nextInt();
        }while(kosci < 3 || kosci > 10);

        int[] tab = new int[kosci];
        int punkty = 0;
        for(int i = 0; i < kosci; i++)
        {
            int r = rand.nextInt(5) + 1;
            System.out.println("Kostka: " + (i+1) + ": " + r);
            tab[i] = r;
        }
        for(int j =0; j < 1; j++)
        {
            for (int k = 0; k < tab.length-1; k++)
            {
                if(tab[j]==tab[k] && j!=k);
                {
                    System.out.println(punkty);
                    punkty+=tab[j];

                }
            }
        }
        System.out.println("Punkty: " + punkty);
    }
}