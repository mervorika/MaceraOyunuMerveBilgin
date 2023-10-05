
public class Ev extends AsilKonum {

    Ev(Oyuncular oyuncular) {
        super(oyuncular, "Güvenli Ev");
    }

    public boolean getLocation() {
        oyuncular.setHealthy(oyuncular.getrHealthy());
        System.out.println("İyileştiniz");
        System.out.println("Artık güvenli alandasınız");
        return true;
    }

}