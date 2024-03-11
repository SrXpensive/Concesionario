
public class Coche {
    private int numBastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private boolean revisar = true;
    private boolean[] revisiones = new boolean[5];
    public Coche(int numBastidor, String matricula, String marca, String modelo, String color, double precio, boolean revisar) {
        this.numBastidor = numBastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.revisar = revisar;
    }

    public Coche(int numBastidor, String matricula, String marca, String modelo, String color, double precio) {
        this.numBastidor = numBastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    public int getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(int numBastidor) {
        this.numBastidor = numBastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isRevisar() {
        return revisar;
    }

    public void setRevisar(boolean revisar) {
        this.revisar = revisar;
    }

    public boolean[] getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(boolean[] revisiones) {
        this.revisiones = revisiones;
    }
    public void aumentarPrecioPorcentaje(double q){
        setPrecio(this.precio*(1+q/100));
    }
    public void mostrarInfo(){
        String revisado;
        if (isRevisar()){
            revisado = "Está revisado";
        }else{
            revisado = "No está revisado";
        }
        System.out.println("Número de bastidor: "+getNumBastidor());
        System.out.println("Matrícula: "+getMatricula());
        System.out.println("Marca: "+getMarca());
        System.out.println("Modelo: "+getModelo());
        System.out.println("Color: "+getColor());
        System.out.println("Precio: "+getPrecio());
        System.out.println("Revisado: "+revisado);
    }
    public String toString(){
        return this.matricula+" - "+this.marca+" "+this.modelo;
    }
    public boolean revisar(){
        for(int i=0; i < this.revisiones.length;i++){
            if(!this.revisiones[i]){
                this.revisiones[i]=true;
                if(i == this.revisiones.length){
                    this.revisar = false;
                    return false;
                }
            }
        }
        return true;
    }
    public boolean revisar(boolean [] revisiones){
        if (revisiones.length == 5){
            for(int i = 0; i < revisiones.length;i++){
                this.revisiones[i] = revisiones[i];
            }
        }else{
            return false;
        }
        return true;
    }

}
