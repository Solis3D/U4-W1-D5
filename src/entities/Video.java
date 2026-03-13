package entities;

public class Video extends ElementoRiproducibile implements RegolaLuminosita, RegolaVolume {

    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata, volume);
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        StringBuilder asterischi = new StringBuilder();
        StringBuilder esclamativi = new StringBuilder();

        for (int i = 0; i < this.volume; i++) {
            esclamativi.append("!");
        }

        for (int i = 0; i < this.luminosita; i++) {
            asterischi.append("*");
        }

        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.getTitolo() + esclamativi + asterischi);
        }

    }

    @Override
    public void aumentaLuminosita() {
        if (this.luminosita < 10){
            this.luminosita++;
        } else {
            System.out.println("Luminosità è già al livello massimo consentito!");
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if(this.luminosita > 0){
            this.luminosita--;
        } else {
            System.out.println("Luminosità è già al livello minimo consentito!");
        }
    }

    @Override
    public void aumentaVolume() {
        if (this.volume < 10){
            this.volume++;
        } else {
            System.out.println("Volume è già al livello massimo consentito!");
        }
    }

    @Override
    public void diminuisciVolume() {
        if(this.volume > 0){
            this.volume--;
        } else {
            System.out.println("Volume è già al livello minimo consentito!");
        }
    }
}
