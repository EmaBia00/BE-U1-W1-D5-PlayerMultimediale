import multimedia.ElementoMultimediale;
import multimedia.Immagine;
import multimedia.Audio;
import multimedia.Video;
import multimedia.Riproducibile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Creazione degli elementi multimediali
        for (int i = 0; i < elementi.length; i++) {
            System.out.println("Creazione elemento " + (i + 1));
            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();
            //DA GESTIRE OGNI ELEMENTO - probabile con uno switch
        }
    }
}
