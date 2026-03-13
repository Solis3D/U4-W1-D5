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
                System.out.println();
                objectType = scanner.nextInt();

                if (objectType >= 1 && objectType <= 3) {
                    condition = false;
                } else {
                    System.out.println("Input non consentito, riprovare...");
                    System.out.println();
                }
            }
            while (condition);

            // Switch che gestisce i diversi tipi di elemento che l'utente può scegliere
            switch (objectType) {
                //caso 1: Immagine
                case 1:
                    condition = true;

                    System.out.println("Hai scelto di creare un'Immagine");
                    System.out.println();

                    scanner.nextLine();

                    do {
                        System.out.println("Inserisci titolo...");
                        titolo = scanner.nextLine();

                        if (titolo.isBlank()){
                            System.out.println("Titolo non valido. Riprovare.");
                        }else {
                            condition = false;
                        }
                    } while (condition);


                    do {
                        condition = true;
                        System.out.println("Scegli la luminosità dell'Immagine da 1 a 10...");
                        luminosita = scanner.nextInt();

                        if (luminosita > 0 && luminosita <= 10) {
                            condition = false;
                        } else {
                            System.out.println("Valore non valido. Inserire un valore da 1 a 10.");
                            System.out.println();
                        }
                    }
                    while (condition);

                    arrElementi[i] = new Immagine(titolo, luminosita);
                    break;

                    //caso 2: audio
                case 2:

                    condition = true;

                    System.out.println("Hai scelto di creare un audio");
                    System.out.println();

                    scanner.nextLine();

                    do {
                        System.out.println("Inserisci titolo...");
                        titolo = scanner.nextLine();

                        if (titolo.isBlank()){
                            System.out.println("Titolo non valido. Riprovare.");
                        }else {
                            condition = false;
                        }
                    } while (condition);

                    //chiede la durata
                    do {
                        System.out.println("Inserisci durata da 1 a 10...");
                        durata = scanner.nextInt();

                        if (durata > 0 && durata <= 10) {
                            condition = false;
                        } else {
                            System.out.println("Valore non valido. Inserire un valore da 1 a 10.");
                            System.out.println();
                        }
                    }
                    while (condition);

                    //chiede il volume
                    do {
                        condition = true;
                        System.out.println("Inserisci volume da 0 a 10...");
                        volume = scanner.nextInt();

                        if (volume >= 0 && volume <= 10) {
                            condition = false;
                        } else {
                            System.out.println("Valore non valido. Inserire un valore da 0 a 10.");
                            System.out.println();
                        }
                    }
                    while (condition);

                    arrElementi[i] = new Audio(titolo, durata, volume);
                    break;

                    //caso 3: Video
                case 3:
                    condition = true;

                    System.out.println("Hai scelto di creare un Video");
                    System.out.println();

                    scanner.nextLine();

                    do {
                        System.out.println("Inserisci titolo...");
                        titolo = scanner.nextLine();

                        if (titolo.isBlank()){
                            System.out.println("Titolo non valido. Riprovare.");
                        }else {
                            condition = false;
                        }
                    } while (condition);

                    do {
                        System.out.println("Inserisci durata da 1 a 10...");
                        durata = scanner.nextInt();

                        if (durata > 0 && durata <= 10) {
                            condition = false;
                        } else {
                            System.out.println("Valore non valido. Inserire un valore da 1 a 10.");
                            System.out.println();
                        }
                    }
                    while (condition);

                    //chiede il volume
                    do {
                        condition = true;
                        System.out.println("Inserisci volume da 0 a 10...");
                        volume = scanner.nextInt();

                        if (volume >= 0 && volume <= 10) {
                            condition = false;
                        } else {
                            System.out.println("Valore non valido. Inserire un valore da 0 a 10.");
                            System.out.println();
                        }
                    }
                    while (condition);

                    //chiede il luminosità
                    do {
                        condition = true;
                        System.out.println("Scegli la luminosità del Video da 1 a 10...");
                        luminosita = scanner.nextInt();

                        if (luminosita > 0 && luminosita <= 10) {
                            condition = false;
                        } else {
                            System.out.println("Valore non valido. Inserire un valore da 1 a 10.");
                            System.out.println();
                        }
                    }
                    while (condition);

                    arrElementi[i] = new Video(titolo, durata,volume,luminosita);
                    break;
                default:
                    System.out.println("Errore, oggetto selezionato non riconosciuto");

            }
        }

        boolean isPlaying = true;
        do {

            boolean validation = true;
            do {
                System.out.println("Quale elemento vuole eseguire? ");
                System.out.println("Inserire un numero da 1 a 5");
                System.out.println("Inserire 0 per terminare il programma");
                elementToExecute = scanner.nextInt();

                if (elementToExecute >= 1 && elementToExecute <= 5){
                    validation = false;
                }

                if (elementToExecute == 0){
                    isPlaying = false;
                    validation = false;
                }

            } while(validation);

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
}
