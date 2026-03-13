package entities;

public abstract class ElementoMultimediale {

    private String titolo;

    public ElementoMultimediale (String titolo){
        this.titolo = titolo;
    }

    //Getter
    public String getTitolo(){
        return this.titolo;
    }
}
