
public abstract class SavasKonumu extends Konum {
    protected Zorluklar zorluklar;
    protected String award;

    SavasKonumu(Oyuncular oyuncular, String name, Zorluklar zorluklar, String award) {
        super(oyuncular);
        this.zorluklar = zorluklar;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation() {
        int obsCount = zorluklar.count();
        System.out.println("Şu an buradasınız : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + zorluklar.getName() + " var !");
        System.out.print("Savaş veya Kaç :");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz !");
                if (this.award.equals("Food") && oyuncular.getInv().isFood() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    oyuncular.getInv().setFood(true);
                } else if (this.award.equals("Water") && oyuncular.getInv().isWater() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    oyuncular.getInv().setWater(true);
                } else if (this.award.equals("Firewood") && oyuncular.getInv().isFirewood() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    oyuncular.getInv().setFirewood(true);
                }
                return true;
            }

            if(oyuncular.getHealthy() <= 0) {
                System.out.println("Rahmetli oldunuz !");
                return false;
            }

        }
        return true;
    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealth = zorluklar.getHealth();
            playerStats();
            enemyStats();
            while (oyuncular.getHealthy() > 0 && zorluklar.getHealth() > 0) {
                System.out.print("Vur veya Kaç (V/K) :");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println("Siz vurdunuz !");
                    zorluklar.setHealth(zorluklar.getHealth() - oyuncular.getTotalDamage());
                    afterHit();
                    if (zorluklar.getHealth() > 0) {
                        System.out.println();
                        System.out.println("Canavar size vurdu !");
                        oyuncular.setHealthy(oyuncular.getHealthy() - (zorluklar.getDamage() - oyuncular.getInv().getArmor()));
                        afterHit();
                    }
                } else {
                    return false;
                }
            }

            if (zorluklar.getHealth() < oyuncular.getHealthy()) {
                System.out.println("Düşman yendiniz !");
                oyuncular.setMoney(oyuncular.getMoney() + zorluklar.getAward());
                System.out.println("Güncel Paranız : " + oyuncular.getMoney());
                zorluklar.setHealth(defObsHealth);
            } else {
                return false;
            }
            System.out.println("-------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri\n--------------");
        System.out.println("Can:" + oyuncular.getHealthy());
        System.out.println("Hasar:" + oyuncular.getTotalDamage());
        System.out.println("Para:" + oyuncular.getMoney());
        if (oyuncular.getInv().getDamage() > 0) {
            System.out.println("Silah:" + oyuncular.getInv().getwName());
        }
        if (oyuncular.getInv().getArmor() > 0) {
            System.out.println("Zırh:" + oyuncular.getInv().getaName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + zorluklar.getName() + " Değerleri\n--------------");
        System.out.println("Can:" + zorluklar.getHealth());
        System.out.println("Hasar:" + zorluklar.getDamage());
        System.out.println("Ödül:" + zorluklar.getAward());
    }

    public void afterHit() {
        System.out.println("Oyuncu Canı:" + oyuncular.getHealthy());
        System.out.println(zorluklar.getName() + " Canı:" + zorluklar.getHealth());
        System.out.println();
    }

}