import multimedia.ElementoMultimediale;
import multimedia.Immagine;
import multimedia.Audio;
import multimedia.Riproducibile;
import multimedia.Video;

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
            System.out.print("Tipo (1=Immagine, 2=Video, 3=Audio): "); //Scelta della riproduzione da stampare
            int tipo = scanner.nextInt();
            //Ho gestito nello switch la creazione dei vari oggetti in base alla scelta del tipo, perchè mi sembrava il modo più corretto per gestire le diverse richieste,
            //ho provato a farlo dentro a ogni classe ma mi complicavo sempre di più la vità.
            //Non so se va bene mettere così tanto codice nel main, in caso mi farebbe piacere avere un feedback sul metodo che ho applicato così che possa migliorare o cambiare approccio per i prossimi compiti.
            switch (tipo) {
                case 1 -> { //Immagine
                    System.out.print("Luminosità: ");
                    int luminosita = scanner.nextInt();
                    scanner.nextLine();
                    elementi[i] = new Immagine(titolo, luminosita);
                }
                case 2 -> { //Video
                    System.out.print("Durata: ");
                    int durata = scanner.nextInt();
                    System.out.print("Volume: ");
                    int volume = scanner.nextInt();
                    System.out.print("Luminosità: ");
                    int luminosita = scanner.nextInt();
                    scanner.nextLine();
                    elementi[i] = new Video(titolo, durata, volume, luminosita);
                }
                case 3 -> { //Audio
                    System.out.print("Durata: ");
                    int durata = scanner.nextInt();
                    System.out.print("Volume: ");
                    int volume = scanner.nextInt();
                    scanner.nextLine();
                    elementi[i] = new Audio(titolo, durata, volume);
                }
                default -> {
                    System.out.println("Tipo non valido, riprovare.");
                    i--;
                }
            }
        }

        // Esecuzione degli elementi
        int scelta;
        do {
            System.out.println("Scegli un elemento da eseguire (1-5, 0 per terminare): ");
            scelta = scanner.nextInt();
            scanner.nextLine();
            if (scelta > 0 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                if (elemento instanceof Riproducibile riproducibile) {
                    riproducibile.play();
                } else if (elemento instanceof Immagine immagine) {
                    immagine.show();
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        System.out.println("Lettore multimediale terminato.");
        scanner.close();
    }
}
