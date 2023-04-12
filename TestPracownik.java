import java.util.Random;

public class TestPracownik {
    static class Pracownik {
        private String nazwisko;
        private double pensja;

        private int id;

        private static int nastepnyId;


        static {
            Random rand = new Random();
            nastepnyId = rand.nextInt(100);
        }

        {
            przyznajId(this);
        }

        Pracownik() {
            setNazwisko("Domyslne");
            setPensja(1000);
        }

        Pracownik(String i_naz, double i_pen) {
            setNazwisko(i_naz);
            setPensja(i_pen);
        }

        Pracownik(double i_pen) {
            this(" ", i_pen);
        }

        public void setNazwisko(String i_naz) {
            nazwisko = i_naz;
        }

        public void setPensja(double i_pen) {
            pensja = i_pen;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public double getPensja() {
            return pensja;
        }

        public void podniesPensje(double i_proc) {
            double pomoc = 1 + (i_proc / 100);
            setPensja(pensja * pomoc);
        }

        private static void przyznajId(Pracownik p) {
            p.id = nastepnyId;
            nastepnyId++;
        }

        public int getId() {
            return id;
        }

        public int getNastepnyId() {
            return nastepnyId;
        }
    }

    static class Menadzer extends Pracownik {
        private double bonus;

        public void zmienBonus(double i_bon){
            bonus = i_bon;
        }

        public double getPensja(){
            return super.getPensja() + bonus;
        }

        Menadzer(){
            super();
            bonus = 10;
        }

        Menadzer(String str, double i_pen, double i_bon){
            super(str,i_pen);
            zmienBonus(i_bon);
        }

        Menadzer(double i_pen, double i_bon){
            super(i_pen);
            zmienBonus(i_bon);
        }
    }

    public static void main(String[] args) {
        Pracownik[] tabPrac = new Pracownik[]{new Pracownik("prac1", 100), new Pracownik("prac2", 1000), new Pracownik("prac3", 1000)};
        tabPrac[0].podniesPensje(5);
        tabPrac[1].podniesPensje(5);
        tabPrac[2].podniesPensje(5);
        for (int i = 0; i < 3; i++) {
            System.out.println(tabPrac[i].getNazwisko() + " id:" + tabPrac[i].getId() + " pensja: " + tabPrac[i].getPensja());
        }
    }
}