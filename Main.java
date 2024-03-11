public class Main {
    public static void main(String[] args) {
        int opcion=0;

        do{
            System.out.println("1. Propuesto");
            opcion= Leer.leerEntero("Introduce una opcion");
            switch(opcion){
                case 1:
                    propuesto();
            }
        }while(opcion !=0);
        
    }
    public static void mostrarKms(Coche c){
        if(c instanceof Coche2mano){
            System.out.println("Coche de segunda mano con "+((Coche2mano) c).getKm()+" kms");
        }else{
            System.out.println("Coche nuevo, 0 kms");
        }
    }
    public static void propuesto(){
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
        if(!cocheAnt.revisar(new boolean []{false,false})){
            System.out.println("No se ha podido realizar la copia");
        }
        mostrarKms(cocheNu);
        mostrarKms(cocheAnt);
    }
}