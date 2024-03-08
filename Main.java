public class Main {
    public static void main(String[] args) {
        Coche cocheNu = new Coche(2335,"7328-JDS","Ford","Fiesta","Negro",32000);
        Coche2mano cocheAnt = new Coche2mano(3564,"9753-KLM","Renault","Coupé","Blanco",45000,30000,4);
        Coche cocheNu2 = new Coche(9976,"5463-GHT","Peugeot","206","Gris",45000);
        Coche2mano cocheAnt2 = new Coche2mano(4675,"4888-TGR","Toyota","Corolla","Rojo",56000,67000,5);
        cocheNu.aumentarPrecioPorcentaje(3);

        cocheNu.mostrarInfo();
        System.out.println("----------");
        System.out.println(cocheNu);
        System.out.println("----------");
        cocheAnt.mostrarInfo();
        System.out.println("----------");
        System.out.println(cocheAnt);
        System.out.println("----------");
        Coche [] coches = new Coche[]{cocheNu,cocheAnt,cocheNu2,cocheAnt2};
        for(Coche c:coches){
            c.mostrarInfo();
            System.out.println("----------");
            System.out.println(c);
            System.out.println("----------");
        }
    }
}