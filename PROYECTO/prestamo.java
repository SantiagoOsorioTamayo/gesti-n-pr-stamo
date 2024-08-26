import java.io.IOException;

public class prestamo {
    //instancia de la clase menu
    menu me = new menu();

    // metodo para registrar los prestamos de los estudiantes de ingeniería
    public String registrar_prestamo_ingenieria(manejo_estudiantes lista, manejo_dispositivos pila, manejo_lectura lectura) 
            throws IOException { // recibe las instancias de cada "manejo"
        //instancias auxiliares
        estudiante_ingenieria alumno = new estudiante_ingenieria();
        computador_portatil portatil = new computador_portatil();

        String ced = lectura.leer_sin_caracteres_especiales("\nINGRESE LA CÉDULA DEL ESTUDIANTE: ");
        if (lista.buscar_estudiante_inge_por_CC(ced) == null) { // si no se encuentra el estudiante, puede seguir
            alumno = alumno.ingresar_datos_inge(lista, pila, lectura, ced);
            if (alumno != null) { // si el objeto no está vacio, puede seguir
                portatil = portatil.ingresar_datos_pc(alumno.getSerial(), lectura);
                lista.list_ing.add(alumno);
                pila.pila_pc.add(portatil);
                return "\nINFORMACIÓN DEL ALUMNO:\n" + alumno.toString() + "\nINFORMACIÓN DEL PORTATIL:\n"
                        + portatil.toString(); // retorna la información ingresada
            } else { // de lo contrario, quiere decir que el dispositivo que deseaba ya ha sido prestado
                return "";
            }
        } else { // de lo contrario, quiere decir que el estudiante ya ha hecho un prestamo
            return "\n\t***EL ESTUDIANTE YA HA HECHO UN PRESTAMO. SOLO SE PERMITE UN DISPOSITIVO POR ESTUDIANTE***\n";
        }
    }

    // metodo para registrar los prestamos de los estudiantes de diseño
    public String registrar_prestamo_diseño(manejo_estudiantes lista, manejo_dispositivos pila, manejo_lectura lectura) 
            throws IOException { // recibe las instancias de cada "manejo"
        //instancias auxiliares
        estudiante_diseño alumno = new estudiante_diseño();
        tableta_grafica tablet = new tableta_grafica();

        String ced = lectura.leer_sin_caracteres_especiales("\nINGRESE LA CÉDULA DEL ESTUDIANTE: ");
        if (lista.buscar_estudiante_dis_por_CC(ced) == null) { // si no se encuentra el estudiante, puede seguir
            alumno = alumno.ingresar_datos_dis(lista, pila, lectura, ced);
            if (alumno != null) { // si el objeto no está vacio, puede seguir
                tablet = tablet.ingresar_datos_tablet(alumno.getserial(), lectura);
                lista.list_dis.add(alumno);
                pila.pila_tablet.add(tablet);
                return "\nINFORMACIÓN DEL ALUMNO:\n" + alumno.toString() + "\nINFORMACIÓN DEL PORTATIL:\n"
                        + tablet.toString(); // retorna la información ingresada
            } else { // de lo contrario, quiere decir que el dispositivo que deseaba ya ha sido prestado
                return "";
            }
        } else { // de lo contrario, quiere decir que el estudiante ya ha hecho un prestamo
            return "\n\t***EL ESTUDIANTE YA HA HECHO UN PRESTAMO. SOLO SE PERMITE UN DISPOSITIVO POR ESTUDIANTE***\n";
        }

    }

    // metodo para modificar los prestamos de los estudiantes de ingenieria con la cedula o el serial
    public String modificar_prestamo_ingenieria(manejo_estudiantes lista, manejo_dispositivos pila, String dato) 
            throws IOException { // recibe cedula/serial y las instancias de manejo_estudiantes y manejo_dispositivos
        // variable auxiliar
        String mensaje = "";

        if (lista.buscar_estudiante_inge_por_CC(dato) != null) { // si el estudiante ha hecho un prestamo (buscando por cedula)
            estudiante_ingenieria estudiante = lista.buscar_estudiante_inge_por_CC(dato);
            computador_portatil portatil = pila.buscar_portatil_por_CC(dato, lista);
            System.out.print("\n\t***ESTUDIANTE***\n" + estudiante);
            System.out.println("\n\t***DISPOSITIVO***\n" + portatil);
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') { // si desea cambiar los datos del estudiante
                estudiante = me.elegir_cambio_inge(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString(); // texto a retornar
            } else if (elecc == 'D') { // si desea cambiar los datos del dispositivo
                portatil = me.elegir_cambio_pc(portatil);
                mensaje = "\n\t***CAMBIO***\n" + portatil.toString(); // texto a retornar
            } else { // si no desea hacer cambios
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n";
            }
        } else if (lista.buscar_estudiante_inge_por_serial(dato) != null) { // si el estudiante ha hecho un prestamo (buscando por serial)
            estudiante_ingenieria estudiante = lista.buscar_estudiante_inge_por_serial(dato);
            computador_portatil portatil = pila.buscar_portatil_por_serial(dato);
            System.out.print("\n\t***ESTUDIANTE***\n" + estudiante);
            System.out.println("\n\t***DISPOSITIVO***\n" + portatil);
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') { // si desea cambiar los datos del estudiante
                estudiante = me.elegir_cambio_inge(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString(); // texto a retornar
            } else if (elecc == 'D') { // si desea cambiar los datos del dispositivo
                portatil = me.elegir_cambio_pc(portatil);
                mensaje = "\n\t***CAMBIO***\n" + portatil.toString(); // texto a retornar
            } else { // si no desea hacer cambios
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n"; // texto a retornar
            }
        } else { // el estudiante no ha hecho un prestamo
            mensaje = "\n\t***NO ENCONTRADO***\n"; // texto a retornar
        }
        return mensaje;
    }

    // metodo para modificar los prestamos de los estudiantes de diseño con la cedula
    public String modificar_prestamo_diseño(manejo_estudiantes lista, manejo_dispositivos pila, String dato) throws IOException { // recibe la cedula y las instancias de manejo_estudiantes y manejo_dispositivos
        // variable auxiliar
        String mensaje = "";

        if (lista.buscar_estudiante_dis_por_CC(dato) != null) { // si el estudiante ha hecho un prestamo
            estudiante_diseño estudiante = lista.buscar_estudiante_dis_por_CC(dato);
            tableta_grafica tablet = pila.buscar_tablet_por_CC(dato, lista);
            System.out.print("\n\t***ESTUDIANTE***\n" + estudiante);
            System.out.println("\n\t***DISPOSITIVO***\n" + tablet);
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') { // si desea cambiar los datos del estudiante
                estudiante = me.elegir_cambio_dis(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString(); // texto a retornar
            } else if (elecc == 'D') { // si desea cambiar los datos del dispositivo
                tablet = me.elegir_cambio_tablet(tablet);
                mensaje = "\n\t***CAMBIO***\n" + tablet.toString(); // texto a retornar
            } else { // si no desea hacer cambios
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n"; // texto a retornar
            }
        } else { // el estudiante no ha hecho un prestamo
            mensaje = "\n\t***NO ENCONTRADO***\n"; // texto a retornar
        }
        return mensaje;
    }

    // metodo para modificar los prestamos de los estudiantes de ingenieria con el serial
    public String modificar_prestamo_diseño(manejo_estudiantes lista, manejo_dispositivos pila, int dato) throws IOException { // recibe el serial y las instancias de manejo_estudiantes y manejo_dispositivos
        // variable auxiliar
        String mensaje = "";
        
        if (lista.buscar_estudiante_dis_por_serial(dato) != null) { // si el estudiante ha hecho un prestamo
            estudiante_diseño estudiante = lista.buscar_estudiante_dis_por_serial(dato);
            tableta_grafica tablet = pila.buscar_tablet_por_serial(dato);
            System.out.print("\n\t***ESTUDIANTE***\n" + estudiante);
            System.out.println("\n\t***DISPOSITIVO***\n" + tablet);
            char elecc = me.elegir_opcion_cambio();
            if (elecc == 'E') { // si desea cambiar los datos del estudiante
                estudiante = me.elegir_cambio_dis(estudiante);
                mensaje = "\n\t***CAMBIO***\n" + estudiante.toString(); // texto a retornar
            } else if (elecc == 'D') { // si desea cambiar los datos del dispositivo
                tablet = me.elegir_cambio_tablet(tablet);
                mensaje = "\n\t***CAMBIO***\n" + tablet.toString(); // texto a retornar
            } else { // si no desea hacer cambios
                mensaje = "\n\t***NO SE REALIZARON CAMBIOS***\n"; // texto a retornar
            }
        } else { // el estudiante no ha hecho un prestamo
            mensaje = "\n\t***NO ENCONTRADO***\n"; // texto a retornar
        }
        return mensaje;
    }
}