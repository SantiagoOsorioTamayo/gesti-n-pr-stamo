import java.io.IOException;

public class estudiante_diseño extends estudiante {

    // variables locales de la clase estudiante_diseño
    private String mod_est;
    private int cant_asig, serial;

    public estudiante_diseño() {
    }

    // constructor de la clase estudiante_diseño
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

    public int getserial() {
        return serial;
    }

    public void setserial(int serial) {
        this.serial = serial;
    }

    // metodo para mostrar los datos del objeto estudiante
    @Override
    public String toString() {
        return super.toString() + "\nMODALIDAD DE ESTUDIO: " + mod_est + "\nCANTIDAD DE ASIGNATURAS ACTUALES: "
                + cant_asig + "\n";
    }

    // metodo que crea un objeto estudiante_diseño
    public estudiante_diseño ingresar_datos_dis(manejo_estudiantes lista, manejo_dispositivos pila,
            manejo_lectura lectura, String ced)
            throws IOException { // recibe las instancias de cada "manejo" y la cedula
        // instancia auxiliar
        estudiante est_aux = new estudiante();

        // variables auxiliares
        estudiante_diseño est = null;
        String mod_estu = "";
        int asig = 0, seri = 0;

        est_aux = est_aux.ingresar_datos_base(ced, lectura);
        seri = lectura.leer_entero_excepciones("\nINGRESE EL SERIAL DEL DISPOSITIVO A PRESTAR: ");
        if (pila.buscar_tablet_por_serial(seri) == null) { // si no encuentra la tablet puede seguir ingresando datos
            mod_estu = obtener_modalidad_estudio(lectura);
            asig = lectura
                    .leer_entero_excepciones("\nINGRESE LA CANTIDAD DE ASIGNATURAS QUE ESTÁ VIENDO DEL ESTUDIANTE: ");
            est = new estudiante_diseño(ced, est_aux.getNombre(), est_aux.getApellido(),
                    est_aux.getTelefono(), mod_estu, asig, seri); // objeto a retornar
        } else { // si la encuentra quiere decir que ya ha sido prestada
            System.out.println("\n\t***LA TABLETA GRÁFICA YA HA SIDO PRESTADA***");
            est = null; // objeto a retornar
        }
        return est;
    }

    // metodo que obtiene la modalidad de estudio controlando las excepciones
    public String obtener_modalidad_estudio(manejo_lectura lectura) throws IOException { //recibe la instancia de manejo_lectura
        // varibles auxiliares
        int opc = 0;
        String mod = "";

        // varible de control de iteración
        boolean flag = false;

        do {
            opc = lectura.leer_entero_excepciones(
                    "\n¿QUÉ MODALIDAD DE ESTUDIO POSEE EL ESTUDIANTE?\n1) Presencial.\n2) Virtual.\nR// ");
            switch (opc) {
                case 1:
                    mod = "Prensencial"; // variable a retornar
                    flag = true;
                    break;
                case 2:
                    mod = "Virtual"; // variable a retornar
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return mod;
    }
}
