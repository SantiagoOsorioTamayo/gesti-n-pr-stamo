import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tableta_grafica extends dispositivo {

    // variables locales de la clase computador portatil
    private String almac;
    private float peso;
    private int serial;

    public tableta_grafica() {

    }

    // constructor de la clase tarjeta grafica
    public tableta_grafica(int serial, String marca, float tam, float precio, String almac, float peso) {
        super(marca, tam, precio);
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

    public int getserial(){
        return serial;
    }

    public void setserial(int serial){
        this.serial = serial;
    }
    // metodo para mostrar los datos del objeto computador portatil
    @Override
    public String toString() {
        return super.toString() + "\nALMACENAMIENTO: " + almac + "\nPESO (KG): " + peso + "\n";
    }

    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public tableta_grafica ingresar_datos_tablet(int serial) {
        dispositivo disp_aux = new dispositivo();
        String alm = "";
        float pe = 0F;
        boolean flag = true;
        do {
            try {
                disp_aux = disp_aux.ingresar_datos_base();
                alm = obtener_almacenamiento();
                System.out.print("\nINGRESE EL PESO DE LA TABLETA (EN KILOGRAMOS): ");
                pe = Float.parseFloat(leer.readLine().trim());
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE CON UN TIPO DE CARACTERES CORRECTOS***\n");
                flag = false;
            }
        } while (flag == false);
        tableta_grafica tablet = new tableta_grafica(serial, disp_aux.getmarca(), disp_aux.gettam(), disp_aux.getprecio(), alm, pe); // objeto a retornar
        return tablet;
    }

    public String obtener_almacenamiento() {
        int opc;
        String alm = "";
        boolean flag = false;
        do {
            try {
                System.out.print("\n¿QUÉ ALMACENAMIENTO POSEE LA TABLETA?\n1) 256 GB.\n2) 512 GB.\n3) 1 TB.\nR// ");
                opc = Integer.parseInt(leer.readLine());
                switch (opc) {
                    case 1:
                        alm = "256 GB";
                        flag = true;
                        break;
                    case 2:
                        alm = "512 GB";
                        flag = true;
                        break;
                    case 3:
                        alm = "1 TB";
                        flag = true;
                        break;
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);
        return alm;
    }
}
