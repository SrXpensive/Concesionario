public class Coche2mano extends Coche{
    private int km;
    private int anios;
    public Coche2mano(int numBastidor, String matricula, String marca, String modelo, String color, double precio, int km, int anios) {
        super(numBastidor, matricula, marca, modelo, color, precio);
        this.km = km;
        this.anios = anios;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Kilómetros: "+getKm());
        System.out.println("Años: "+getAnios());
    }
}
