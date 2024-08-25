
import java.util.Stack;

public class manejo_dispositivos {
    Stack<computador_portatil> pila_pc = new Stack<computador_portatil>();
    Stack<tableta_grafica> pila_tablet = new Stack<tableta_grafica>();

    public computador_portatil buscar_portatil_por_CC(String dato, manejo_estudiantes est) {
        estudiante_ingenieria est_aux = est.buscar_estudiante_inge_por_CC(dato);
        String serial = est_aux.getSerial();
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(serial)) {
                return pc;
            }
        }
        return null;
    }

    public computador_portatil buscar_portatil_por_serial(String dato) {
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(dato)) {
                return pc;
            }
        }
        return null;
    }

    public tableta_grafica buscar_tablet_por_CC(String dato, manejo_estudiantes est) {
        estudiante_diseño est_aux = est.buscar_estudiante_dis_por_CC(dato);
        int serial = est_aux.getserial();
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial() == serial) {
                return tablet;
            }
        }
        return null;
    }

    public tableta_grafica buscar_tablet_por_serial(int dato) {
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial() ==dato) {
                return tablet;
            }
        }
        return null;
    }

    public String eliminar_registro_pc_por_CC(String dato, manejo_estudiantes est) {
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(dato)) {
                pila_pc.remove(pc);
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String eliminar_registro_pc_por_serial(String dato) {
        for (computador_portatil pc : pila_pc) {
            if (pc.getserial().equals(dato)) {
                pila_pc.remove(pc);
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String eliminar_registro_tablet_por_CC(String dato, manejo_estudiantes est) {
        estudiante_diseño est_aux = est.buscar_estudiante_dis_por_CC(dato);
        int serial = est_aux.getserial();
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial() == serial) {
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String eliminar_registro_tablet_por_serial(int dato) {
        for (tableta_grafica tablet : pila_tablet) {
            if (tablet.getserial() == dato) {
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String mostrar_todos_los_portatiles() {
        String mensaje = "\t************";
        if (pila_pc.isEmpty() != true) {
            for (computador_portatil pc : pila_pc) {
                mensaje = mensaje + pc.toString() + "\t************";
            }
        } else {
            mensaje = "\n\t***NO SE ENCONTRARON DISPOSITIVOS***\n";
        }
        return mensaje;
    }

    public String mostrar_todas_las_tablets() {
        String mensaje = "\t************";
        if (pila_tablet.isEmpty() != true) {
            for (tableta_grafica tablet : pila_tablet) {
                mensaje = mensaje + tablet.toString() + "\t************";
            }
        } else {
            mensaje = "\n\t***NO SE ENCONTRARON DISPOSITIVOS***\n";
        }
        return mensaje;
    }

    public String mostrar_todos_los_portatiles_en_archivo() {
        String mensaje = "";
        for (computador_portatil pc : pila_pc) {
            mensaje = mensaje + pc.getserial() + "," + pc.getmarca() + "," + pc.gettam() + "," + pc.getprecio() + ","
                    + pc.getsist_ope() + "," + pc.getproce() + "\n";
        }
        return mensaje;
    }

    public String mostrar_todas_las_tablets_en_archivo() {
        String mensaje = "";
        for (tableta_grafica tablet : pila_tablet) {
            mensaje = mensaje + tablet.getserial() + "," + tablet.getmarca() + "," + tablet.gettam() + ","
                    + tablet.getprecio() + "," + tablet.getalmac() + "," + tablet.getpeso() + "\n";
        }
        return mensaje;
    }
}