import entities.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // variabile che deciderà che tipo di oggetto creare
        // 1 = immagine , 2 = audio , 3 = video.
        int objectType = 0;


        String titolo = "";
        int durata = 0;
        int volume = 0;
        int luminosita = 0;

        ElementoMultimediale[] arrElementi = new ElementoMultimediale[5];

        int elementToExecute = 0;

        System.out.println();
        System.out.println("---BENVENUTO NEL PLAYER MULTIMEDIALE---");
        System.out.println();
        System.out.println("Potrai creare fino a 5 elementi multimediali");
        System.out.println();

        for (int i = 0; i < arrElementi.length ; i++) {
            System.out.println();
            System.out.println("Creazione elemento " + (i + 1) + " di 5");
            System.out.println();

            boolean condition = true;
            do {
                System.out.println("Scegliere tipo elemento da creare");
                System.out.println();
                System.out.println("---LEGENDA---");
                System.out.println("1 = Immagine");
                System.out.println("2 = Audio");
                System.out.println("3 = Video");
                System.out.println("0 = Esci dal programma");
                System.out.println();
                objectType = scanner.nextInt();

                if (objectType >= 0 && objectType <= 3) {
                    condition = false;
                } else {
                    System.out.println("Input non consentito, riprovare...");
                    System.out.println();
                }
            }
            while (condition);

            // Switch che gestisce i diversi tipi di elemento che l'utente può scegliere
            switch (objectType) {
                //Case per uscire qui dal programma
                case 0:
                    System.exit(0);
                    break;
                //caso 1: Immagine
                case 1:
                    condition = true;

                    System.out.println("Hai scelto di creare un'Immagine");
                    System.out.println();

                    scanner.nextLine();

                    titolo = readTitle(scanner);

                    luminosita = readValue(scanner,"Inserisci luminosità da 1 a 10", 1, 10);

                    arrElementi[i] = new Immagine(titolo, luminosita);
                    break;

                    //caso 2: audio
                case 2:

                    condition = true;

                    System.out.println("Hai scelto di creare un audio");
                    System.out.println();

                    scanner.nextLine();

                    titolo = readTitle(scanner);

                    //chiede la durata
                    durata = readValue(scanner,"Inserisci durata da 1 a 10...", 1,10);

                    //chiede il volume
                    volume = readValue(scanner, "Inserisci volume da 0 a 10", 0, 10);

                    arrElementi[i] = new Audio(titolo, durata, volume);
                    break;

                    //caso 3: Video
                case 3:
                    condition = true;

                    System.out.println("Hai scelto di creare un Video");
                    System.out.println();

                    scanner.nextLine();

                    titolo = readTitle(scanner);

                    durata = readValue(scanner,"Inserisci durata da 1 a 10", 1, 10);

                    volume = readValue(scanner, "Inserisci volume da 0 a 10" , 0 ,10);

                    luminosita = readValue(scanner, "Inserisci luminosità da 1 a 10", 1, 10);

                    arrElementi[i] = new Video(titolo, durata,volume,luminosita);
                    break;

                    default:
                    System.out.println("Errore, oggetto selezionato non riconosciuto");

            }

            System.out.println();
            System.out.println("ELEMENTO CREATO!");
            System.out.println();
        }

        boolean isPlaying = true;
        do {

            boolean validationReq = true;
            do {
                System.out.println("Quale elemento vuole eseguire? ");
                System.out.println("Inserire un numero da 1 a 5");
                System.out.println("Inserire 0 per terminare il programma");
                elementToExecute = scanner.nextInt();

                if (elementToExecute >= 1 && elementToExecute <= 5){
                    validationReq = false;
                } else {
                    System.out.println("Elemento inesistente. Selezionare un elemento da 1 a 5.");
                }

                if (elementToExecute == 0){
                    isPlaying = false;
                    validationReq = false;
                }

            } while(validationReq);

             if (elementToExecute != 0) {
             ElementoMultimediale chosenElement = arrElementi[elementToExecute - 1];

             if (chosenElement instanceof Immagine) {
                 ((Immagine) chosenElement).show();
             } else {
                ((ElementoRiproducibile) chosenElement).play();
             }
            }

        } while (isPlaying);

    }

    //Metodi per ridurre codice riutilizzato

    //Metodo che legge il titolo e verifica che sia idoneo, ovvero non spazi vuoti o stringa vuota
    public static String readTitle(Scanner scanner){
        String titolo;
        boolean condition = true;

        do {
            System.out.println("Inserisci titolo...");
            titolo = scanner.nextLine();

            if (titolo.isBlank()) {
                System.out.println("Titolo non valido. Riprovare.");
            } else{
                condition = false;
            }
        }while(condition);

        return titolo;
    }

    // Metodo che legge un valore in input e verifica che rispetti i criteri e rientri nel range min e max
    // prende come parametro il messaggio da stampare all'Utente
    public static int readValue(Scanner scanner, String mex, int min, int max) {
        int value;
        boolean condition = true;

        do {
            System.out.println(mex);
            value = scanner.nextInt();

            if (value < min || value > max){
                System.out.println("Valore non valido. Inserire un numero compreso tra " + min + " e " + max);
            } else {
                condition = false;
            }

        }while (condition);

        return value;
    }

}
