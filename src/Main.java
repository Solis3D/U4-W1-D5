import entities.Audio;
import entities.Immagine;
import entities.Video;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("We Will Rock you", 5,1);
        Immagine immagine1 = new Immagine("L'infinito",0);
        Video video1 = new Video("EpiVideo", 4,3,3);

        audio1.play();
        immagine1.show();
        video1.play();


    }
}
