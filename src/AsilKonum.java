
public abstract class AsilKonum extends Konum{

    AsilKonum(Oyuncular oyuncular,String name) {
        super(oyuncular);
        this.name = name;
    }


    public boolean getLocation() {
        return true;
    }


}