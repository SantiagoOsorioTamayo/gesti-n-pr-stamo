import java.io.IOException;

public class tableta_grafica extends dispositivo {

    // variables locales de la clase tableta_grafica
    private String almac, serial;
    private float peso;

    public tableta_grafica() {

    }

    // constructor de la clase tarjeta_grafica
    public tableta_grafica(String serial, String marca, float tam, float precio, String almac, float peso) {
        super(serial, marca, tam, precio);
        this.serial = serial;
        this.almac = almac;
        this.peso = peso;
    }

    // getters y setters
    public String getalmac() {
        return almac;
    }

    public void setalmac(String almac) {
        this.almac = almac;
    }

    public float getpeso() {
        return peso;
    }

    public void setpeso(float peso) {
        this.peso = peso;
    }

    // metodo para mostrar los datos del objeto tableta_grafica
    @Override
    public String toString() {
        return super.toString() + "\nALMACENAMIENTO: " + almac + "\nPESO (KG): " + peso + "\nSERIAL: " + serial + "\n";
    }

    public tableta_grafica ingresar_datos_tablet(int serial, manejo_lectura lectura) throws IOException { // recibe el serial y la instancia de manejo_lectura
        // instancia auxiliar
        dispositivo disp_aux = new dispositivo();

        // variables auxiliares
        String alm = "";
        float pe = 0F;
        
        disp_aux = disp_aux.ingresar_datos_base(lectura, Integer.toString(serial));
        alm = obtener_almacenamiento(lectura);
        pe = lectura.leer_flotante_excepciones("\nINGRESE EL PESO DE LA TABLETA (EN KILOGRAMOS): ");
        tableta_grafica tablet = new tableta_grafica(disp_aux.getSerial(), disp_aux.getmarca(), disp_aux.gettam(), disp_aux.getprecio(), alm, pe); // objeto a retornar
        return tablet;
    }

    // metodo que obtiene el almacenamiento
    public String obtener_almacenamiento(manejo_lectura lectura) throws IOException { // recibe la instancia de manejo_lectura
        // variables auxiliares
        int opc;
        String alm = "";

        // variable de control de iteración
        boolean flag = false;

        do {
            opc = lectura.leer_entero_excepciones("\n¿QUÉ ALMACENAMIENTO POSEE LA TABLETA?\n1) 256 GB.\n2) 512 GB.\n3) 1 TB.\nR// ");
            switch (opc) {
                case 1:
                    alm = "256 GB"; // variable a retornar
                    flag = true;
                    break;
                case 2:
                    alm = "512 GB"; // variable a retornar
                    flag = true;
                    break;
                case 3:
                    alm = "1 TB"; // variable a retornar
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return alm;
    }
}
