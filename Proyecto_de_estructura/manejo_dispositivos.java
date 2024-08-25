
import java.util.Stack;

public class manejo_dispositivos {
    // pilas de los dispositivos
    Stack<computador_portatil> pila_pc = new Stack<computador_portatil>();
    Stack<tableta_grafica> pila_tablet = new Stack<tableta_grafica>();

    // metodo que busca un portatil con la cedula del estudiante
    public computador_portatil buscar_portatil_por_CC(String dato, manejo_estudiantes est) { // recibe la cedula y la instancia de manejo_estudiantes
        estudiante_ingenieria est_aux = est.buscar_estudiante_inge_por_CC(dato);
        String serial = est_aux.getSerial();
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(serial)) {
                return pc; // objeto a retornar
            }
        }
        return null; // en caso de no encontrarlo
    }

    // metodo que busca un portatil con el serial
    public computador_portatil buscar_portatil_por_serial(String dato) { // recibe el serial
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(dato)) {
                return pc; // objeto a retornar
            }
        }
        return null; // en caso de no encontrarlo
    }

    // metodo que busca una tablet con la cedula del estudiante
    public tableta_grafica buscar_tablet_por_CC(String dato, manejo_estudiantes est) { // recibe la cedula y la instancia de manejo_estudiantes
        estudiante_diseño est_aux = est.buscar_estudiante_dis_por_CC(dato);
        int serial = est_aux.getserial();
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial().equals(Integer.toString(serial))) {
                return tablet; // objeto a retornar
            }
        }
        return null; // en caso de no encontrarlo
    }

    // metodo que busca una tablet con el serial
    public tableta_grafica buscar_tablet_por_serial(int dato) { // recibe el serial
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial().equals(Integer.toString(dato))) {
                return tablet; // objeto a retornar
            }
        }
        return null; // en caso de no encontrarlo
    }

    // metodo que elimina un portatil con la cedula del estudiante
    public String eliminar_registro_pc_por_CC(String dato, manejo_estudiantes est) { // recibe la cedula y la instancia de manejo_estudiantes
        estudiante_ingenieria est_aux = est.buscar_estudiante_inge_por_CC(dato);
        String serial = est_aux.getSerial();
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(serial)) {
                pila_pc.remove(pc);
                    return "\n\t***EL REGISTRO DEL DISPOSITIVO SE HA ELIMINADO***\n"; // texto a retornar
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL DISPOSITIVO***\n"; // en caso de no encontrarlo
    }

    // metodo que elimina un portatil con el serial
    public String eliminar_registro_pc_por_serial(String dato) { // recibe el serial
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(dato)) {
                pila_pc.remove(pc);
                return "\n\t***EL REGISTRO DEL DISPOSITIVO SE HA ELIMINADO***\n"; // texto a retornar
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL DISPOSITIVO***\n"; // en caso de no encontrarlo
    }

    // metodo que elimina una tablet con la cedula del estudiante
    public String eliminar_registro_tablet_por_CC(String dato, manejo_estudiantes est) { // recibe la cedula y la instancia de manejo_estudiantes
        estudiante_diseño est_aux = est.buscar_estudiante_dis_por_CC(dato);
        int serial = est_aux.getserial();
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial().equals(Integer.toString(serial))) {
                pila_tablet.remove(tablet);
                return "\n\t***EL REGISTRO DEL DISPOSITIVO SE HA ELIMINADO***\n"; // texto a retornar
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL DISPOSITIVO***\n"; // en caso de no encontrarlo
    }

    // metodo que elimina una tablet con el serial
    public String eliminar_registro_tablet_por_serial(int dato) { // recibe el serial
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial().equals(Integer.toString(dato))) {
                pila_tablet.remove(tablet);
                return "\n\t***EL REGISTRO DEL DISPOSITIVO SE HA ELIMINADO***\n"; // texto a retornar
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL DISPOSITIVO***\n"; // en caso de no encontrarlo
    }

    // metodo que muestra todos los portatiles prestados desde el menu
    public String mostrar_todos_los_portatiles() {
        String mensaje = "\t************";
        if (pila_pc.isEmpty() != true) {
            for (computador_portatil pc : pila_pc) {
                mensaje = mensaje + pc.toString() + "\t************"; // texto a retornar
            }
        } else {
            mensaje = "\n\t***NO SE ENCONTRARON DISPOSITIVOS***\n"; // en caso de no encontrarlo
        }
        return mensaje;
    }

    // metodo que muestra todas las tablets prestadas desde el menu
    public String mostrar_todas_las_tablets() {
        String mensaje = "\t************";
        if (pila_tablet.isEmpty() != true) {
            for (tableta_grafica tablet : pila_tablet) {
                mensaje = mensaje + tablet.toString() + "\t************"; // texto a retornar
            }
        } else {
            mensaje = "\n\t***NO SE ENCONTRARON DISPOSITIVOS***\n"; // en caso de no encontrarlo
        }
        return mensaje;
    }

    // metodo que muestra todos los portatiles prestados desde el archivo
    public String mostrar_todos_los_portatiles_en_archivo() {
        String mensaje = "";
        for (computador_portatil pc : pila_pc) {
            mensaje = mensaje + pc.getserial() + "," + pc.getmarca() + "," + pc.gettam() + "," + pc.getprecio() + ","
                    + pc.getsist_ope() + "," + pc.getproce() + "\n"; // texto a retornar
        }
        return mensaje;
    }

    // metodo que muestra todas las tablets prestadas desde el archivo
    public String mostrar_todas_las_tablets_en_archivo() {
        String mensaje = "";
        for (tableta_grafica tablet : pila_tablet) {
            mensaje = mensaje + tablet.getserial() + "," + tablet.getmarca() + "," + tablet.gettam() + ","
                    + tablet.getprecio() + "," + tablet.getalmac() + "," + tablet.getpeso() + "\n"; // texto a retornar
        }
        return mensaje;
    }
}