import java.util.List;
import java.util.ArrayList;

public class manejo_estudiantes {
    // se crean las listas separadas para el tipo de estudiante
    List<estudiante_ingenieria> list_ing = new ArrayList<>();
    List<estudiante_diseño> list_dis = new ArrayList<>();

    public estudiante_ingenieria buscar_estudiante_inge_por_CC(String dato) {
        for (estudiante_ingenieria est_ing : list_ing) {
            if (est_ing.getCC().equals(dato)) {
                return est_ing;
            }
        }
        return null;
    }

    public estudiante_ingenieria buscar_estudiante_inge_por_serial(String dato) {
        for (estudiante_ingenieria est_ing : list_ing) {
            if (est_ing.getSerial().equals(dato)) {
                return est_ing;
            }
        }
        return null;
    }

    public estudiante_diseño buscar_estudiante_dis_por_CC(String dato) {
        for (estudiante_diseño est_dis : list_dis) {
            if (est_dis.getCC().equals(dato)) {
                return est_dis;
            }
        }
        return null;
    }

    public estudiante_diseño buscar_estudiante_dis_por_serial(int dato) {
        for (estudiante_diseño est_dis : list_dis) {
            if (est_dis.getserial() == dato) {
                return est_dis;
            }
        }
        return null;
    }

    public String eliminar_registro_inge_por_CC(String dato) {
        for (estudiante_ingenieria est_ing : list_ing) {
            if (est_ing.getCC().equals(dato)) {
                list_ing.remove(est_ing);
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String eliminar_registro_inge_por_serial(String dato) {

        for (estudiante_ingenieria est_ing : list_ing) {
            if (est_ing.getSerial().equals(dato)) {
                list_ing.remove(est_ing);
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String eliminar_registro_dis_por_CC(String dato) {
        for (estudiante_diseño est_dis : list_dis) {
            if (est_dis.getCC().equals(dato)) {
                list_dis.remove(est_dis);
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String eliminar_registro_dis_por_serial(int dato) {
        for (estudiante_diseño est_dis : list_dis) {
            if (est_dis.getserial() == dato) {
                list_dis.remove(est_dis);
                return "\n\t***EL PRESTAMO SE HA ELIMINADO***\n";
            }
        }
        return "\n\t***NO SE ENCONTRÓ EL PRESTAMO***\n";
    }

    public String mostrar_todos_los_estudiantes_ingenieria_en_archivo() {
        String mensaje = "";
        for (estudiante_ingenieria est_ing : list_ing) {
            mensaje = mensaje + est_ing.getCC() + "," + est_ing.getNombre() + "," + est_ing.getApellido() + ","
                    + est_ing.getTelefono() + "," + est_ing.getNum_sem() + "," + est_ing.getProm_acum() + ","
                    + est_ing.getSerial() + "\n";
        }
        return mensaje;
    }

    public String mostrar_todos_los_estudiantes_diseño_en_archivo() {
        String mensaje = "";
        for (estudiante_diseño est_dis : list_dis) {
            mensaje = mensaje + est_dis.getCC() + "," + est_dis.getNombre() + "," + est_dis.getApellido() + ","
                    + est_dis.getTelefono() + "," + est_dis.getMod_est() + "," + est_dis.getCant_asig() + ","
                    + est_dis.getserial() + "\n";
            ;
        }
        return mensaje;
    }
}
