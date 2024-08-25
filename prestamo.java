import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class prestamo {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    menu me = new menu();

    // metodo para registrar los prestamos de los estudiantes de ingeniería
    public String registrar_prestamo_ingenieria(manejo_estudiantes lista, manejo_dispositivos pila, manejo_string str)
            throws IOException {
        estudiante_ingenieria alumno = new estudiante_ingenieria();
        computador_portatil portatil = new computador_portatil();
        String ced = str.leer_sin_caracteres_especiales("\nINGRESE LA CÉDULA DEL ESTUDIANTE: ");
        if (lista.buscar_estudiante_inge_por_CC(ced) == null) {
            alumno = alumno.ingresar_datos_inge(lista, pila, ced);
            if (alumno != null) {
                portatil = portatil.ingresar_datos_pc(alumno.getSerial());
                lista.list_ing.add(alumno);
                pila.pila_pc.add(portatil);
                return "\nINFORMACIÓN DEL ALUMNO:\n" + alumno.toString() + "\nINFORMACIÓN DEL PORTATIL:\n"
                        + portatil.toString(); // retorna la información ingresada
            } else {
                return "";
            }
        } else {
            return "\n\t***EL ESTUDIANTE YA HA HECHO UN PRESTAMO. SOLO SE PERMITE UN DISPOSITIVO POR ESTUDIANTE***\n";
        }

    }

    // metodo para registrar los prestamos de los estudiantes de diseño
    public String registrar_prestamo_diseño(manejo_estudiantes lista, manejo_dispositivos pila, manejo_string str)
            throws IOException {
        estudiante_diseño alumno = new estudiante_diseño();
        tableta_grafica tablet = new tableta_grafica();
        String ced = str.leer_sin_caracteres_especiales("\nINGRESE LA CÉDULA DEL ESTUDIANTE: ");
        if (lista.buscar_estudiante_dis_por_CC(ced) == null) {
            alumno = alumno.ingresar_datos_dis(lista, pila, ced);
            if (alumno != null) {
                tablet = tablet.ingresar_datos_tablet(alumno.getserial());
                lista.list_dis.add(alumno);
                pila.pila_tablet.add(tablet);
                return "\nINFORMACIÓN DEL ALUMNO:\n" + alumno.toString() + "\nINFORMACIÓN DEL PORTATIL:\n"
                        + tablet.toString(); // retorna la información ingresada
            } else {
                return "";
            }
        } else {
            return "\n\t***EL ESTUDIANTE YA HA HECHO UN PRESTAMO. SOLO SE PERMITE UN DISPOSITIVO POR ESTUDIANTE***\n";
        }

    }

    public String modificar_prestamo_ingenieria(manejo_estudiantes lista, manejo_dispositivos pila, String dato)
            throws IOException {
        String mensaje = "";
        if (lista.buscar_estudiante_inge_por_CC(dato) != null) {
            estudiante_ingenieria estudiante = lista.buscar_estudiante_inge_por_CC(dato);
            computador_portatil portatil = pila.buscar_portatil_por_CC(dato, lista);
            System.out.println("\n\t***ESTUDIANTE***\n\n" + estudiante + "\n");
            System.out.println("\n\t***DISPOSITIVO***\n\n" + portatil + "\n");
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') {
                estudiante = me.elegir_cambio_inge(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString();
            } else if (elecc == 'D') {
                portatil = me.elegir_cambio_pc(portatil);
                mensaje = "\n\t***CAMBIO***\n" + portatil.toString();
            } else {
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n";
            }
        } else if (lista.buscar_estudiante_inge_por_serial(dato) != null) {
            estudiante_ingenieria estudiante = lista.buscar_estudiante_inge_por_serial(dato);
            computador_portatil portatil = pila.buscar_portatil_por_serial(dato);
            System.out.println("\n\t***ESTUDIANTE***\n\n" + estudiante + "\n");
            System.out.println("\n\t***DISPOSITIVO***\n\n" + portatil + "\n");
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') {
                estudiante = me.elegir_cambio_inge(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString();
            } else if (elecc == 'D') {
                portatil = me.elegir_cambio_pc(portatil);
                mensaje = "\n\t***CAMBIO***\n" + portatil.toString();
            } else {
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n";
            }
        } else {
            mensaje = "\n\t***NO ENCONTRADO***\n";
        }
        return mensaje;
    }

    public String modificar_prestamo_diseño(manejo_estudiantes lista, manejo_dispositivos pila, String dato_cc,
            int dato_serial) {
        String mensaje = "";
        if (lista.buscar_estudiante_dis_por_CC(dato_cc) != null) {
            estudiante_diseño estudiante = lista.buscar_estudiante_dis_por_CC(dato_cc);
            tableta_grafica tablet = pila.buscar_tablet_por_CC(dato_cc, lista);
            System.out.println("\n\t***ESTUDIANTE***\n\n" + estudiante + "\n");
            System.out.println("\n\t***DISPOSITIVO***\n\n" + tablet + "\n");
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') {
                estudiante = me.elegir_cambio_dis(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString();
            } else if (elecc == 'D') {
                estudiante = me.elegir_cambio_dis(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + tablet.toString();
            } else {
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n";
            }
        } else if (lista.buscar_estudiante_dis_por_serial(dato_serial) != null) {
            estudiante_diseño estudiante = lista.buscar_estudiante_dis_por_serial(dato_serial);
            tableta_grafica tablet = pila.buscar_tablet_por_serial(dato_serial);
            System.out.println("\n\t***ESTUDIANTE***\n\n" + estudiante + "\n");
            System.out.println("\n\t***DISPOSITIVO***\n\n" + tablet + "\n");
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') {
                estudiante = me.elegir_cambio_dis(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString();
            } else if (elecc == 'D') {
                estudiante = me.elegir_cambio_dis(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + tablet.toString();
            } else {
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n";
            }
        } else {
            mensaje = "\n\t***NO ENCONTRADO***\n";
        }
        return mensaje;
    }
}