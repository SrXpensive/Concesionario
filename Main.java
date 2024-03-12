import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int opcion;
        ArrayList<Coche> coches = new ArrayList<>();
        do{
            System.out.println("1. Propuesto");
            System.out.println("2. Información del vehículo");
            System.out.println("3. Alta de un vehículo");
            System.out.println("4. Baja de un vehículo");
            System.out.println("5. Mostrar la información de todos los coches");
            System.out.println("6. Borrado total");
            System.out.println("0. Salir");
            opcion= Leer.leerEntero("Introduce una opción: ");
            switch(opcion){
                case 1:
                    propuesto();
                    break;
                case 2:
                    informacion(coches);
                    break;
                case 3:
                    alta(coches);
                    break;
                case 4:
                    baja(coches);
                    break;
                case 5:
                    mostrarTodos(coches);
                    break;
                case 6:
                    borrar(coches);
                    break;
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
    public static void informacion(ArrayList<Coche> array){
        int num;
        if (array.isEmpty()){
            System.out.println("------------");
            System.out.println("No hay coches para solicitar información");
            System.out.println("------------");
        }else{
            for(int i = 0; i<array.size();i++){
                System.out.println((i+1)+". "+array.get(i));
            }
            num = Leer.leerEntero("Escoge el coche del que quieres ver los datos: ");
            System.out.println("----------");
            System.out.println("Marca: "+array.get(num-1).getMarca());
            System.out.println("Matrícula: "+array.get(num-1).getMatricula());
            System.out.println("Modelo: "+array.get(num-1).getModelo());
            System.out.println("Color: "+array.get(num-1).getColor());
            System.out.println("Número de bastidor: "+array.get(num-1).getNumBastidor());
            System.out.println("Precio: "+array.get(num-1).getPrecio()+" euros");
            if(array.get(num-1) instanceof Coche2mano){
                System.out.println("Número de kilómetros: "+((Coche2mano) array.get(num-1)).getKm()+" kms");
                System.out.println("Años: "+((Coche2mano) array.get(num-1)).getAnios());
            }
            System.out.println("----------");
        }
    }
    public static void alta(ArrayList<Coche> array){
        Coche car;
        int numBas = Leer.leerEntero("Introduce el número de bastidor: ");
        String mat = Leer.leerTexto("Introduce la matrícula: ");
        String brand = Leer.leerTexto("Introduce la marca del coche: ");
        String mod = Leer.leerTexto("Introduce el modelo del coche: ");
        String col = Leer.leerTexto("Introduce el color del coche: ");
        double price = Leer.leerDouble("Introduce el precio del coche: ");
        String segunda = Leer.leerTexto("¿Es de segunda mano?: ");
        if (segunda.equalsIgnoreCase("si")){
            int km = Leer.leerEntero("Introduce número de kilómetros del coche: ");
            int anios= Leer.leerEntero("Introduce los años que tiene el coche: ");
            car = new Coche2mano(numBas,mat,brand,mod,col,price,km,anios);
        }else{
            car = new Coche(numBas,mat,brand,mod,col,price);
        }
        array.add(car);
    }
    public static void baja(ArrayList<Coche> array){
        int num;
        for(int i = 0; i< array.size();i++){
            System.out.println((i+1)+". "+array.get(i));
        }
        num = Leer.leerEntero("Introduce el número del coche que quieres dar de baja: ");
        array.remove(num-1);
        System.out.println("------------");
        System.out.println("Baja realizada con éxito");
    }
    public static void mostrarTodos(ArrayList<Coche> array){
        if (array.isEmpty()){
            System.out.println("----------");
            System.out.println("No hay información que mostrar");
            System.out.println("----------");
        }
        for(Coche c:array){
            System.out.println("-----------");
            System.out.println("Marca: "+c.getMarca());
            System.out.println("Matrícula: "+c.getMatricula());
            System.out.println("Modelo: "+c.getModelo());
            System.out.println("Color: "+c.getColor());
            System.out.println("Número de bastidor: "+c.getNumBastidor());
            System.out.println("Precio: "+c.getPrecio());
            if(c instanceof Coche2mano){
                System.out.println("Kilómetros: "+((Coche2mano) c).getKm());
                System.out.println("Años: "+((Coche2mano) c).getAnios());
            }
            System.out.println("-----------");
        }
    }
    public static void borrar(ArrayList<Coche> array){
        int opcion1;
        if(array.isEmpty()){
            System.out.println("-----------");
            System.out.println("No hay coches para borrar");
            System.out.println("-----------");
        }else {
            System.out.println("El borrado será irreversible, ¿estás seguro?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion1 = Leer.leerEntero("Opción: ");
            if (opcion1 == 1) {
                System.out.println("¿De verdad? Piénsalo bien");
                System.out.println("1. Si");
                System.out.println("2. No");
                opcion1 = Leer.leerEntero("Opción: ");
                if (opcion1 == 1) {
                    array.clear();
                    System.out.println("-----------");
                    System.out.println("Información borrada por completo");
                    System.out.println("-----------");
                } else {
                    System.out.println("-----------");
                    System.out.println("Proceso de borrado abortado con éxito");
                    System.out.println("-----------");
                }
            } else {
                System.out.println("-----------");
                System.out.println("Proceso de borrado abortado con éxito");
                System.out.println("-----------");
            }
        }
    }
}