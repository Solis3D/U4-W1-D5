package entities;

public class Audio extends ElementoRiproducibile implements RegolaVolume {

    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);
    }

    @Override
    public void play() {
        StringBuilder esclamativi = new StringBuilder();

        //ciclo for per costruire tot punti esclamativi in base al volume
        if (volume > 0){
        for (int i = 0; i < this.volume; i++) {
            esclamativi.append("!");
        }
        }

        for (int i = 0; i < this.durata ; i++) {
            System.out.println(this.getTitolo() + esclamativi);
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
