import java.io.IOException;
public class dispositivo {

    // variables locales de la clase dispositivo
    protected String marca, serial;
    protected float tam, precio;

    public dispositivo() {

    }

    // constructor de la clase dispositivo
    public dispositivo(String serial, String marca, float tam, float precio) {
        this.serial = serial;
        this.marca = marca;
        this.tam = tam;
        this.precio = precio;
    }

    // getters y setters
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public float gettam() {
        return tam;
    }

    public void settam(float tam) {
        this.tam = tam;
    }

    public float getprecio() {
        return precio;
    }

    public void setprecio(float precio) {
        this.precio = precio;
    }

    // metodo para mostrar los datos del objeto dispositivo
    @Override
    public String toString() {
        return "\nMARCA: " + marca.toUpperCase() + "\nTAMAÑO (IN): " + tam + "\nPRECIO: " + precio;
    }

    // metodo que crea un objeto dispositivo
    public dispositivo ingresar_datos_base(manejo_lectura lectura, String serial) throws IOException { // recibe la instancia de manejo_lectura
        // varibles auxiliares
        String marc = "";
        float tam = 0F, prec = 0F;
        
        marc = lectura.leer_sin_caracteres_especiales("\nINGRESE LA MARCA DEL DISPOSITIVO: ");
        tam = lectura.leer_flotante_excepciones("\nINGRESE EL TAMAÑO DEL DISPOSITIVO (EN PULGADAS): ");
        prec = lectura.leer_flotante_excepciones("\nINGRESE EL PRECIO DEL DISPOSITIVO: ");
        dispositivo disp = new dispositivo(serial, marc, tam, prec); // objeto a retornar
        return disp;
    }
}
