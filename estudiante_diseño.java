import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class estudiante_diseño extends estudiante {

    // variables locales de la clase estudiante diseño
    private String mod_est;
    private int cant_asig, serial;

    public estudiante_diseño() {
    }

    // constructor de la clase estudiante diseño
    public estudiante_diseño(String CC, String nombre, String apellido, String telefono, String mod_est, int cant_asig,
            int serial) {
        super(CC, nombre, apellido, telefono);
        this.mod_est = mod_est;
        this.cant_asig = cant_asig;
        this.serial = serial;
    }

    // getters y setters
    public String getMod_est() {
        return mod_est;
    }

    public void setMod_est(String mod_est) {
        this.mod_est = mod_est;
    }

    public int getCant_asig() {
        return cant_asig;
    }

    public void setCant_asig(int cant_asig) {
        this.cant_asig = cant_asig;
    }

    public int getserial(){
        return serial;
    }

    public void setserial(int serial){
        this.serial = serial;
    }
    // metodo para mostrar los datos del objeto estudiante
    @Override
    public String toString() {
        return super.toString() + "\nMODALIDAD DE ESTUDIO: " + mod_est + "\nCANTIDAD DE ASIGNATURAS ACTUALES: "
                + cant_asig + "\n";
    }

    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    // metodo que pide los datos de un estudiante de diseño y retorna un objeto
    // estudiante diseño
    public estudiante_diseño ingresar_datos_dis(manejo_estudiantes lista, manejo_dispositivos pila, String ced) throws IOException {
        estudiante est_aux = new estudiante();
        estudiante_diseño est = null;
        String mod_estu = "";
        int asig = 0, seri = 0;
        boolean flag = true;
        do {
            try {
                est_aux = est_aux.ingresar_datos_base(ced);
                System.out.print("\nINGRESE EL SERIAL DEL DISPOSITIVO A PRESTAR: ");
                seri = Integer.parseInt(leer.readLine());
                if (pila.buscar_tablet_por_serial(seri) == null) {
                    mod_estu = obtener_modalidad_estudio();
                    System.out.print("\nINGRESE LA CANTIDAD DE ASIGNATURAS QUE ESTÁ VIENDO DEL ESTUDIANTE: ");
                    asig = Integer.parseInt(leer.readLine());
                    est = new estudiante_diseño(ced, est_aux.getNombre(), est_aux.getApellido(),
                            est_aux.getTelefono(), mod_estu, asig, seri); // objeto a retornar
                } else {
                    System.out.println("\n\t***LA TABLETA GRÁFICA YA HA SIDO PRESTADA***");
                    est = null;
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE CON UN TIPO DE CARACTERES CORRECTOS***\n");
                flag = false;
            }
        } while (flag == false);
        return est;
    }

    public String obtener_modalidad_estudio() {
        int opc;
        String mod = "";
        boolean flag = false;
        do {
            try {
                System.out.print("\n¿QUÉ MODALIDAD DE ESTUDIO POSEE EL ESTUDIANTE?\n1) Presencial.\n2) Virtual.\nR// ");
                opc = Integer.parseInt(leer.readLine());
                switch (opc) {
                    case 1:
                        mod = "Prensencial";
                        flag = true;
                        break;
                    case 2:
                        mod = "Virtual";
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
        return mod;
    }
}
