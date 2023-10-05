import java.util.Scanner;

public abstract class Konum {
    protected Oyuncular oyuncular;
    protected String name;
    Scanner scan = new Scanner(System.in);

    Konum(Oyuncular oyuncular){
        this.oyuncular = oyuncular;
    }

    public abstract boolean getLocation();

    public Oyuncular getPlayer() {
        return oyuncular;
    }

    public void setPlayer(Oyuncular oyuncular) {
        this.oyuncular = oyuncular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}