import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\student\\Desktop\\liczby.txt";
        String outputFile = "C:\\Users\\student\\Desktop\\trojki.txt";

        List<Integer> numbers = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(inputFile))) {
            while (sc.hasNextInt()) {
                numbers.add(sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Plik wejściowy nie został znaleziony.");
            e.printStackTrace();
            return;
        }

        int count = 0;

        try (PrintWriter pw = new PrintWriter(new File(outputFile))) {
            int n = numbers.size();
            for (int i = 0; i < n; i++) {
                int u = numbers.get(i);
                for (int j = 0; j < n; j++) {
                    int w = numbers.get(j);
                    if (w != u && w % u == 0) {
                        for (int k = 0; k < n; k++) {
                            int x = numbers.get(k);
                            if (x != w && x != u && x % w == 0)
                            {
                                for (int l = 0; l < n; l++) {
                                    int y = numbers.get(l);
                                    if (y != x && y != u && y != w && y % x == 0) {
                                        for (int m = 0; m < n; m++) {
                                            int z = numbers.get(m);
                                            if (z != y && z != x && z!=u && z!=w && z % y == 0)
                                            {
                                                System.out.println(u + " " + w + " " + x + " " + y + " " + z);
                                                count++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("Liczba dobrych piątek: " + count);

        } catch (FileNotFoundException e) {
            System.out.println("Nie można utworzyć pliku wyjściowego.");
            e.printStackTrace();
        }
    }
}