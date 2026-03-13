package entities;

public class Immagine extends ElementoMultimediale implements RegolaLuminosita{

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void show() {

        StringBuilder asterischi = new StringBuilder();

        //ciclo for per costruire tot asterischi in base alla luminosità
        if (luminosita > 0){
        for (int i = 0; i < luminosita; i++) {
            asterischi.append("*");
        }
        }

        System.out.println(this.getTitolo() + asterischi);
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
    public void diminuisciLuminosita(){
        if(this.luminosita > 0){
        this.luminosita--;
        } else {
            System.out.println("Luminosità è già al livello minimo consentito!");
        }
    }
}
