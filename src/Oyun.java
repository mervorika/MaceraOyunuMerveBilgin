import java.util.Scanner;
public class Oyun {
    Oyuncular oyuncular;
    Konum konum;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen isminizi giriniz : a");
        String playerName = scan.nextLine();
        oyuncular = new Oyuncular("a");
        oyuncular.selectCha();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("=================================================");
            System.out.println();
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz : ");
            System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan, düşman yok !");
            System.out.println("2. Mağara --> Zombi çıkabülü !");
            System.out.println("3. Orman --> Vampir çıkabülü !");
            System.out.println("4. Nehir --> Ayı çıkabülü !");
            System.out.println("5. Mağaza --> Silah yada zırh alabilirsiniz!");
            System.out.print("Gitmek istediğiniz yer : ");
            int selLoc = scan.nextInt();
            while (selLoc < 0 || selLoc > 5) {
                System.out.print("Lütfen geçerli bir yer seçiniz : ");
                selLoc = scan.nextInt();
            }

            switch (selLoc) {
                case 1:
                    konum = new Ev(oyuncular);
                    break;
                case 2:
                    konum = new Magara(oyuncular);
                    break;
                case 3:
                    konum = new Orman(oyuncular);
                    break;
                case 4:
                    konum = new Nehir(oyuncular);
                    break;
                case 5:
                    konum = new Magaza(oyuncular);
                    break;
                default:
                    konum = new Ev(oyuncular);
            }

            if (konum.getClass().getName().equals("SafeHouse")) {
                if (oyuncular.getInv().isFirewood() && oyuncular.getInv().isFood() && oyuncular.getInv().isWater()) {
                    System.out.println("Tebrikler Oyunu Kazandınız !");
                    break;
                }
            }
            if (!konum.getLocation()) {
                System.out.println("Oyun Bitti !");
                break;
            }

        }
    }
}