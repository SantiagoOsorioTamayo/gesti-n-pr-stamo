import java.io.BufferedReader;
import java.io.InputStreamReader;

public class dispositivo {

    // variables locales de la clase dispositivo
    protected String marca;
    protected float tam, precio;

    public dispositivo() {

    }

    // constructor de la clase dispositivo
    public dispositivo(String marca, float tam, float precio) {
        this.marca = marca;
        this.tam = tam;
        this.precio = precio;
    }

    // getters y setters
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
        return "\nMARCA: " + marca + "\nTAMAÑO (IN): " + tam + "\nPRECIO: " + precio;
    }

    public dispositivo ingresar_datos_base() {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String marc = "";
        float tam = 0F, prec = 0F;
        boolean flag = true;
        do {
            try {
                System.out.print("\nINGRESE LA MARCA DEL DISPOSITIVO: ");
                marc = leer.readLine().toUpperCase().trim();
                System.out.print("\nINGRESE EL TAMAÑO DEL DISPOSITIVO (EN PULGADAS): ");
                tam = Float.parseFloat(leer.readLine().trim());
                System.out.print("\nINGRESE EL PRECIO DEL DISPOSITIVO: ");
                prec = Float.parseFloat(leer.readLine().trim());
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE CON UN TIPO DE CARACTERES CORRECTOS***\n");
                flag = false;
            }
        } while (flag == false);
        dispositivo disp = new dispositivo(marc, tam, prec); // objeto a retornar
        return disp;
    }
}
