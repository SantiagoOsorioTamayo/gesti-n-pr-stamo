import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class menu {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    manejo_estudiantes lista = new manejo_estudiantes();
    manejo_dispositivos pila = new manejo_dispositivos();
    manejo_string str = new manejo_string();
    archivo arch = new archivo();

    // metodo que crea el menú principal
    public void crear_menu_principal() throws IOException {
        int opc_princ = 0, opc_est_ing = 0, opc_est_dis = 0;
        System.out.println(arch.pasar_archivo_a_lista(lista)); 
        System.out.println(arch.pasar_archivo_a_pila(pila));
        do {
            try {
                System.out.println("\t*** MENÚ ***\n");
                System.out.println("1. ESTUDIANTES DE INGENIERÍA.\n");
                System.out.println("2. ESTUDIANTES DE DISEÑO.\n");
                System.out.println("3. IMPRIMIR INVENTARIO TOTAL.\n");
                System.out.println("4. SALIR DEL PROGRAMA.\n");
                System.out.print("R// ");
                opc_princ = Integer.parseInt(leer.readLine());
                switch (opc_princ) {
                    case 1 -> {
                        crear_menu_ingenieria(opc_est_ing);
                        break;
                    }
                    case 2 -> {
                        crear_menu_diseño(opc_est_dis);
                        break;
                    }
                    case 3 -> {
                        System.out.print("\n\t***DISPOSITIVOS PRESTADOS***\n");
                        System.out.println("\n***COMPUTADORES PORTATILES***\n");
                        System.out.println(pila.mostrar_todos_los_portatiles());
                        System.out.println("\n***TABLETAS GRÁFICAS***\n");
                        System.out.println(pila.mostrar_todas_las_tablets() + "\n");
                    }
                    case 4 -> {
                        System.out.println(arch.pasar_lista_a_archivo(lista));
                        System.out.println(arch.pasar_pila_a_archivo(pila));
                        System.out.println("\n\t***TENGA BUEN DÍA***");
                        break;
                    }
                    default ->
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                }
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (opc_princ != 4);
    }

    // metodo que crea el menú de estudiantes de ingeniería
    public void crear_menu_ingenieria(int opc_est_ing) throws IOException {
        prestamo pres = new prestamo(); // instancia de la clase prestamo
        String info, dato;
        char opc_aux;
        do {
            try {
                System.out.println("\t*** MENÚ - ESTUDIANTES DE INGENIERÍA ***\n");
                System.out.println("1. REGISTRAR PRÉSTAMO DE EQUIPO.\n");
                System.out.println("2. MODIFICAR PRÉSTAMO DE EQUIPO.\n");
                System.out.println("3. DEVOLUCIÓN DE EQUIPO.\n");
                System.out.println("4. BUSCAR EQUIPO.\n");
                System.out.println("5. VOLVER AL MENÚ PRINCIPAL.\n");
                System.out.print("R// ");
                opc_est_ing = Integer.parseInt(leer.readLine());
                switch (opc_est_ing) {
                    case 1 -> {
                        info = pres.registrar_prestamo_ingenieria(lista, pila, str);
                        System.out.println(info);
                        break;
                    }
                    case 2 -> {
                        if (lista.list_ing.isEmpty() != true) {
                            opc_aux = elegir_CC_o_serial();
                            dato = leer.readLine();
                            System.out.println(pres.modificar_prestamo_ingenieria(lista, pila, dato));
                        } else {
                            System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                        }
                        break;
                    }
                    case 3 -> {
                        if (lista.list_ing.isEmpty() != true) {
                            opc_aux = elegir_CC_o_serial();
                            dato = leer.readLine();
                            if (opc_aux == 'C') {
                                System.out.println(lista.eliminar_registro_inge_por_CC(dato)
                                        + pila.eliminar_registro_pc_por_CC(dato, lista));
                            } else {
                                System.out.println(lista.eliminar_registro_inge_por_serial(dato)
                                        + pila.eliminar_registro_pc_por_serial(dato));
                            }
                        } else {
                            System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                        }
                        break;
                    }
                    case 4 -> {
                        if (lista.list_ing.isEmpty() != true) {
                            opc_aux = elegir_CC_o_serial();
                            dato = leer.readLine();
                            if (opc_aux == 'C') {
                                if (lista.buscar_estudiante_inge_por_CC(dato) != null) {
                                    System.out.println("\n\t***EQUIPO***\n"
                                            + pila.buscar_portatil_por_CC(dato, lista));
                                } else {
                                    System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                                }
                            } else {
                                if (lista.buscar_estudiante_inge_por_serial(dato) != null) {
                                    System.out.println("\n\t***EQUIPO***\n"
                                            + pila.buscar_portatil_por_serial(dato));
                                } else {
                                    System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                                }
                            }
                        } else {
                            System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                        }
                        break;
                    }
                    case 5 -> {
                        System.out.println("\n\t************\n");
                        break;
                    }
                    default ->
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                }
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (opc_est_ing != 5);
    }

    // metodo que crea el menú de estudiantes de diseño
    public void crear_menu_diseño(int opc_est_dis) throws IOException {
        prestamo pres = new prestamo(); // instancia de la clase prestamo
        String info, dato_cc = "";
        char opc_aux;
        int dato_serial = 0;
        do {
            try {
                System.out.println("\t*** MENÚ - ESTUDIANTES DE DISEÑO ***\n");
                System.out.println("1. REGISTRAR PRÉSTAMO DE EQUIPO.\n");
                System.out.println("2. MODIFICAR PRÉSTAMO DE EQUIPO.\n");
                System.out.println("3. DEVOLUCIÓN DE EQUIPO.\n");
                System.out.println("4. BUSCAR EQUIPO.\n");
                System.out.println("5. VOLVER AL MENÚ PRINCIPAL.\n");
                System.out.print("R// ");
                opc_est_dis = Integer.parseInt(leer.readLine()); // lee la opción que escribe el usuario
                switch (opc_est_dis) {
                    case 1 -> {
                        info = pres.registrar_prestamo_diseño(lista, pila, str); // se guarda la información en una variable
                        System.out.println(info); // se muestra la información
                        break;
                    }
                    case 2 -> {
                        if (lista.list_ing.isEmpty() != true) {
                            opc_aux = elegir_CC_o_serial();
                            if(opc_aux == 'C'){
                                dato_cc = leer.readLine();
                                System.out.println(pres.modificar_prestamo_diseño(lista, pila, dato_cc, dato_serial));
                            } else if (opc_aux == 'S')
                                dato_serial = Integer.parseInt(leer.readLine());
                                System.out.println(pres.modificar_prestamo_diseño(lista, pila, dato_cc, dato_serial));
                        } else {
                            System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                        }
                        break;
                    }
                    case 3 -> {
                        if (lista.list_ing.isEmpty() != true) {
                            opc_aux = elegir_CC_o_serial();
                            if (opc_aux == 'C') {
                                dato_cc = leer.readLine();
                                System.out.println(lista.eliminar_registro_dis_por_CC(dato_cc)
                                        + pila.eliminar_registro_tablet_por_CC(dato_cc, lista));
                            } else {
                                dato_serial = Integer.parseInt(leer.readLine());
                                System.out.println(lista.eliminar_registro_dis_por_serial(dato_serial)
                                        + pila.eliminar_registro_tablet_por_serial(dato_serial));
                            }

                        } else {
                            System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                        }
                        break;
                    }
                    case 4 -> {
                        if (lista.list_dis.isEmpty() != true) {
                            opc_aux = elegir_CC_o_serial();
                            if (opc_aux == 'C') {
                                dato_cc = leer.readLine();
                                if (lista.buscar_estudiante_dis_por_CC(dato_cc) != null) {
                                    System.out.println("\n\t***EQUIPO***\n"
                                            + pila.buscar_tablet_por_CC(dato_cc, lista));
                                } else {
                                    System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                                }
                            } else {
                                dato_serial = Integer.parseInt(leer.readLine());
                                if (lista.buscar_estudiante_dis_por_serial(dato_serial) != null) {
                                    System.out.println("\n\t***EQUIPO***\n"
                                            + pila.buscar_tablet_por_serial(dato_serial));
                                } else {
                                    System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                                }
                            }
                        } else {
                            System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                        }
                        break;
                    }
                    case 5 -> {
                        System.out.println("\n\t************\n");
                        break;
                    }
                    default ->
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                }
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (opc_est_dis != 5);
    }

    public char elegir_CC_o_serial() throws IOException {
        char opc;
        do {
            System.out.println("\n¿BUSQUEDA POR CÉDULA O SERIAL (C/S)?");
            opc = leer.readLine().toUpperCase().charAt(0);
            switch (opc) {
                case 'C':
                    System.out.println("\nINGRESE LA CÉDULA DEL ESTUDIANTE: ");
                    break;
                case 'S':
                    System.out.println("\nINGRESE EL SERIAL DEL DISPOSITIVO: ");
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VALIDA***\n");
            }
        } while (opc != 'C' && opc != 'S');
        return opc;
    }

    public char elegir_opcion_cambio() {
        int opc;
        char elecc = ' ';
        boolean flag = false;
        do {
            try {
                System.out.println("¿QÚE DESESA CAMBIAR?");
                System.out.println("1. ESTUDIANTE.\n");
                System.out.println("2. DISPOSITIVO.\n");
                System.out.println("3. NO DESEO REALIZAR CAMBIOS.\n");
                System.out.println("NOTA: LA CÉDULA Y/O EL SERIAL NO PUEDEN SER CAMBIADOS.\n");
                System.out.print("R// ");
                opc = Integer.parseInt(leer.readLine()); // lee la opción que escribe el usuario
                switch (opc) {
                    case 1:
                        elecc = 'E';
                        break;
                    case 2:
                        elecc = 'D';
                        break;
                    case 3:
                        System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);
        return elecc;
    }

    public estudiante_ingenieria elegir_cambio_inge(estudiante_ingenieria est) {
        int opc;
        boolean flag = true;
        do {
            try {
                System.out.println("¿QÚE DATO DESESA CAMBIAR?");
                System.out.println("1. NOMBRE.\n");
                System.out.println("2. APELLIDO.\n");
                System.out.println("3. TELÉFONO.\n");
                System.out.println("4. NÚMERO DEL SEMESTRE.\n");
                System.out.println("5. PROMEDIO ACUMULADO.\n");
                System.out.println("6. NO DESEO REALIZAR CAMBIOS.\n");
                System.out.println("NOTA: LA CÉDULA Y/O EL SERIAL NO PUEDEN SER CAMBIADOS.\n");
                System.out.print("R// ");
                opc = Integer.parseInt(leer.readLine()); // lee la opción que escribe el usuario
                switch (opc) {
                    case 1:
                        System.out.print("\nINGRESE EL NUEVO NOMBRE: ");
                        String new_nom = leer.readLine().toUpperCase();
                        est.setNombre(new_nom);
                        break;
                    case 2:
                        System.out.print("\nINGRESE EL NUEVO APELLIDO: ");
                        String new_ape = leer.readLine().toUpperCase();
                        est.setApellido(new_ape);
                        break;
                    case 3:
                        System.out.print("\nINGRESE EL NUEVO TELÉFONO: ");
                        String new_tel = leer.readLine();
                        est.setTelefono(new_tel);
                        break;
                    case 4:
                        System.out.print("\nINGRESE EL NUEVO NÚMERO DEL SEMESTRE: ");
                        int new_sem = Integer.parseInt(leer.readLine());
                        est.setNum_sem(new_sem);
                        break;
                    case 5:
                        System.out.print("\nINGRESE EL NUEVO PROMEDIO ACUMULADO: ");
                        float new_prom = Float.parseFloat(leer.readLine());
                        est.setProm_acum(new_prom);
                        break;
                    case 6:
                        System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                        break;
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);

        return est;
    }

    public estudiante_diseño elegir_cambio_dis(estudiante_diseño est) {
        int opc;
        boolean flag = false;
        do {
            try {
                System.out.println("¿QÚE DATO DESESA CAMBIAR?");
                System.out.println("1. NOMBRE.\n");
                System.out.println("2. APELLIDO.\n");
                System.out.println("3. TELÉFONO.\n");
                System.out.println("4. MODALIDAD DE ESTUDIO.\n");
                System.out.println("5. CANTIDAD DE ASIGNATURAS.\n");
                System.out.println("6. NO DESEO REALIZAR CAMBIOS.\n");
                System.out.println("NOTA: LA CÉDULA Y/O EL SERIAL NO PUEDEN SER CAMBIADOS.\n");
                System.out.print("R// ");
                opc = Integer.parseInt(leer.readLine()); // lee la opción que escribe el usuario
                switch (opc) {
                    case 1:
                        System.out.print("\nINGRESE EL NUEVO NOMBRE: ");
                        String new_nom = leer.readLine().toUpperCase();
                        est.setNombre(new_nom);
                        break;
                    case 2:
                        System.out.print("\nINGRESE EL NUEVO APELLIDO: ");
                        String new_ape = leer.readLine().toUpperCase();
                        est.setApellido(new_ape);
                        break;
                    case 3:
                        System.out.print("\nINGRESE EL NUEVO TELÉFONO: ");
                        String new_tel = leer.readLine();
                        est.setTelefono(new_tel);
                        break;
                    case 4:
                        System.out.print("\nINGRESE LA NUEVA MODALIDAD DE ESTUDIO: ");
                        String new_mod = leer.readLine();
                        est.setMod_est(new_mod);
                        break;
                    case 5:
                        System.out.print("\nINGRESE LA NUEVA CANTIDAD DE ASIGNATURAS: ");
                        int new_cant = Integer.parseInt(leer.readLine());
                        est.setCant_asig(new_cant);
                        break;
                    case 6:
                        System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                        break;
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);

        return est;
    }

    public computador_portatil elegir_cambio_pc(computador_portatil pc) {
        int opc;
        boolean flag = false;
        do {
            try {
                System.out.println("¿QÚE DATO DESESA CAMBIAR?");
                System.out.println("1. MARCA.\n");
                System.out.println("2. TAMAÑO.\n");
                System.out.println("3. PRECIO.\n");
                System.out.println("4. SISTEMA OPERATIVO.\n");
                System.out.println("5. PROCESADOR.\n");
                System.out.println("6. NO DESEO REALIZAR CAMBIOS.\n");
                System.out.println("NOTA: LA CÉDULA Y/O EL SERIAL NO PUEDEN SER CAMBIADOS.\n");
                System.out.print("R// ");
                opc = Integer.parseInt(leer.readLine()); // lee la opción que escribe el usuario
                switch (opc) {
                    case 1:
                        System.out.print("\nINGRESE EL NUEVO NOMBRE: ");
                        String new_marc = leer.readLine().toUpperCase();
                        pc.setmarca(new_marc);
                        break;
                    case 2:
                        System.out.print("\nINGRESE EL NUEVO APELLIDO: ");
                        float new_tam = Float.parseFloat(leer.readLine());
                        pc.settam(new_tam);
                        break;
                    case 3:
                        System.out.print("\nINGRESE EL NUEVO TELÉFONO: ");
                        float new_pre = Float.parseFloat(leer.readLine());
                        pc.setprecio(new_pre);
                        break;
                    case 4:
                        String new_sist = pc.obtener_sistema_operatico();
                        pc.setsist_ope(new_sist);
                        break;
                    case 5:
                        String new_proce = pc.obtener_procesador();
                        pc.setproce(new_proce);
                        break;
                    case 6:
                        System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                        break;
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);

        return pc;
    }

    public tableta_grafica elegir_cambio_tablet(tableta_grafica tablet) {
        int opc;
        boolean flag = false;
        do {
            try {
                System.out.println("¿QÚE DATO DESESA CAMBIAR?");
                System.out.println("1. MARCA.\n");
                System.out.println("2. TAMAÑO.\n");
                System.out.println("3. PRECIO.\n");
                System.out.println("4. ALMACENAMIENTO.\n");
                System.out.println("5. PESO.\n");
                System.out.println("6. NO DESEO REALIZAR CAMBIOS.\n");
                System.out.println("NOTA: LA CÉDULA Y/O EL SERIAL NO PUEDEN SER CAMBIADOS.\n");
                System.out.print("R// ");
                opc = Integer.parseInt(leer.readLine()); // lee la opción que escribe el usuario
                switch (opc) {
                    case 1:
                        System.out.print("\nINGRESE EL NUEVO NOMBRE: ");
                        String new_marc = leer.readLine().toUpperCase();
                        tablet.setmarca(new_marc);
                        break;
                    case 2:
                        System.out.print("\nINGRESE EL NUEVO APELLIDO: ");
                        float new_tam = Float.parseFloat(leer.readLine());
                        tablet.settam(new_tam);
                        break;
                    case 3:
                        System.out.print("\nINGRESE EL NUEVO TELÉFONO: ");
                        float new_pre = Float.parseFloat(leer.readLine());
                        tablet.setprecio(new_pre);
                        break;
                    case 4:
                        String new_alm = tablet.obtener_almacenamiento();
                        tablet.setalmac(new_alm);
                        break;
                    case 5:
                        System.out.print("\nINGRESE LA NUEVA CANTIDAD DE ASIGNATURAS: ");
                        float new_pe = Float.parseFloat(leer.readLine());
                        tablet.setpeso(new_pe);
                        break;
                    case 6:
                        System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                        break;
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);

        return tablet;
    }
}