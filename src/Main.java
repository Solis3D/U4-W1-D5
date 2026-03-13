import entities.Audio;
import entities.Immagine;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("We Will Rock you", 5,1);
        Immagine immagine1 = new Immagine("L'infinito",0);

        audio1.play();


    }
}
