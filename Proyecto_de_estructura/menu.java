import java.io.IOException;

public class menu {
    // instancia de los metodos de las clases en cuestion
    manejo_estudiantes lista = new manejo_estudiantes();
    manejo_dispositivos pila = new manejo_dispositivos();
    manejo_lectura lectura = new manejo_lectura();
    archivo arch = new archivo();

    // metodo que crea el menú principal
    public void crear_menu_principal() throws IOException {
        // variables para las opciones de cada menu
        int opc_princ = 0, opc_est_ing = 0, opc_est_dis = 0;

        // abrir archivos
        System.out.println(arch.pasar_archivo_a_lista_ing(lista));
        System.out.println(arch.pasar_archivo_a_lista_dis(lista));
        System.out.println(arch.pasar_archivo_a_pila_pc(pila));
        System.out.println(arch.pasar_archivo_a_pila_tablet(pila));

        do {
            opc_princ = lectura.leer_entero_excepciones(
                    "\n\t*** MENÚ ***\n\n1. ESTUDIANTES DE INGENIERÍA.\n\n2. ESTUDIANTES DE DISEÑO.\n\n3. IMPRIMIR INVENTARIO TOTAL.\n\n4. SALIR DEL PROGRAMA.\n\nR// ");
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
                    System.out.print("\n\t***DISPOSITIVOS PRESTADOS***\n\n***COMPUTADORES PORTATILES***\n\n"
                            + pila.mostrar_todos_los_portatiles() + "\n\n***TABLETAS GRÁFICAS***\n\n"
                            + pila.mostrar_todas_las_tablets() + "\n");
                }
                case 4 -> {
                    System.out.println(
                            arch.pasar_lista_ing_a_archivo(lista) + "\n" + arch.pasar_lista_dis_a_archivo(lista) + "\n"
                                    + arch.pasar_pila_pc_a_archivo(pila) + "\n" + arch.pasar_pila_tablet_a_archivo(pila)
                                    + "\n\n\t***TENGA BUEN DÍA***");
                    break;
                }
                default ->
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (opc_princ != 4);
    }

    // metodo que crea el menú de estudiantes de ingeniería
    public void crear_menu_ingenieria(int opc_est_ing) throws IOException { // recibe la opcion del menu
        // variables auxiliares
        String info, dato;
        char opc_aux;

        // instancia de la clase prestamo
        prestamo pres = new prestamo();

        do {
            opc_est_ing = lectura.leer_entero_excepciones(
                    "\t*** MENÚ - ESTUDIANTES DE INGENIERÍA ***\n\n1. REGISTRAR PRÉSTAMO DE EQUIPO.\n\n2. MODIFICAR PRÉSTAMO DE EQUIPO.\n\n3. DEVOLUCIÓN DE EQUIPO.\n\n4. BUSCAR EQUIPO.\n\n5. VOLVER AL MENÚ PRINCIPAL.\n\nR// ");
            switch (opc_est_ing) {
                case 1 -> { // registra el prestamo y muestra el resultado
                    info = pres.registrar_prestamo_ingenieria(lista, pila, lectura);
                    System.out.println(info);
                    break;
                }
                case 2 -> { // modifica el prestamo buscado y muestra el resultado
                    if (lista.list_ing.isEmpty() != true) { // si se hicieron prestamos
                        opc_aux = elegir_CC_o_serial();
                        dato = lectura.leer_sin_caracteres_especiales("");
                        System.out.println(pres.modificar_prestamo_ingenieria(lista, pila, dato));
                    } else { // de lo contrario, no se puede modificar nada
                        System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                    }
                    break;
                }
                case 3 -> { // elimina el registro del prestamo buscado
                    if (lista.list_ing.isEmpty() != true) { // si se hicieron prestamos
                        opc_aux = elegir_CC_o_serial();
                        dato = lectura.leer_sin_caracteres_especiales("");
                        if (opc_aux == 'C') { // si se busca por cedula
                            System.out.println(pila.eliminar_registro_pc_por_CC(dato, lista)
                                    + lista.eliminar_registro_inge_por_CC(dato));
                        } else if (opc_aux == 'S') { // si se busca por serial
                            System.out.println(lista.eliminar_registro_inge_por_serial(dato)
                                    + pila.eliminar_registro_pc_por_serial(dato));
                        }
                    } else { // de lo contrario, no se puede eliminar nada
                        System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                    }
                    break;
                }
                case 4 -> { // busca y muestra un dispositivo prestado
                    if (lista.list_ing.isEmpty() != true) { // si se hicieron prestamos
                        opc_aux = elegir_CC_o_serial();
                        dato = lectura.leer_sin_caracteres_especiales("");
                        if (opc_aux == 'C') { // si se busca por cedula
                            if (lista.buscar_estudiante_inge_por_CC(dato) != null) { // si se encuentra el dispositivo, lo muestra
                                System.out.println("\n\t***EQUIPO***\n"
                                        + pila.buscar_portatil_por_CC(dato, lista));
                            } else { // no se encuentra el dispositivo
                                System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                            }
                        } else { // si se busca por serial
                            if (lista.buscar_estudiante_inge_por_serial(dato) != null) { // si se encuentra el dispositivo, lo muestra
                                System.out.println("\n\t***EQUIPO***\n"
                                        + pila.buscar_portatil_por_serial(dato));
                            } else { // no se encuentra el dispositivo
                                System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                            }
                        }
                    } else { // de lo contrario, no se puede buscar nada
                        System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                    }
                    break;
                }
                case 5 -> { // seperador de menus
                    System.out.println("\n\t************");
                    break;
                }
                default ->
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (opc_est_ing != 5);
    }

    // metodo que crea el menú de estudiantes de diseño
    public void crear_menu_diseño(int opc_est_dis) throws IOException { // recibe la opcion del menu
        // variables auxiliares
        String info, dato_cc = "";
        char opc_aux;
        int dato_serial = 0;

        // instancia de la clase prestamo
        prestamo pres = new prestamo();

        do {
            opc_est_dis = lectura.leer_entero_excepciones(
                    "\t*** MENÚ - ESTUDIANTES DE DISEÑO ***\n\n1. REGISTRAR PRÉSTAMO DE EQUIPO.\n\n2. MODIFICAR PRÉSTAMO DE EQUIPO.\n\n3. DEVOLUCIÓN DE EQUIPO.\n\n4. BUSCAR EQUIPO.\n\n5. VOLVER AL MENÚ PRINCIPAL.\n\nR// ");
            switch (opc_est_dis) {
                case 1 -> { // registra el prestamo y muestra el resultado
                    info = pres.registrar_prestamo_diseño(lista, pila, lectura);
                    System.out.println(info);
                    break;
                }
                case 2 -> { // modifica el prestamo buscado y muestra el resultado
                    if (lista.list_ing.isEmpty() != true) { // si se hicieron prestamos
                        opc_aux = elegir_CC_o_serial();
                        if (opc_aux == 'C') { // si se busca por cedula
                            dato_cc = lectura.leer_sin_caracteres_especiales("");
                            System.out.println(pres.modificar_prestamo_diseño(lista, pila, dato_cc));
                        } else if (opc_aux == 'S') // si se busca por serial
                            dato_serial = lectura.leer_entero_excepciones("");
                        System.out.println(pres.modificar_prestamo_diseño(lista, pila, dato_serial));
                    } else { // de lo contrario, no se puede modificar nada
                        System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                    }
                    break;
                }
                case 3 -> { // elimina el registro del prestamo buscado
                    if (lista.list_ing.isEmpty() != true) { // si se hicieron prestamos
                        opc_aux = elegir_CC_o_serial();
                        if (opc_aux == 'C') { // si se busca por cedula
                            dato_cc = lectura.leer_sin_caracteres_especiales("");
                            System.out.println(pila.eliminar_registro_tablet_por_CC(dato_cc, lista)
                                    + lista.eliminar_registro_dis_por_CC(dato_cc));
                        } else if (opc_aux == 'S') { // si se busca por serial
                            dato_serial = lectura.leer_entero_excepciones("");
                            System.out.println(lista.eliminar_registro_dis_por_serial(dato_serial)
                                    + pila.eliminar_registro_tablet_por_serial(dato_serial));
                        }
                    } else { // de lo contrario, no se puede eliminar nada
                        System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                    }
                    break;
                }
                case 4 -> { // busca y muestra un dispositivo prestado
                    if (lista.list_dis.isEmpty() != true) { // si se hicieron prestamos
                        opc_aux = elegir_CC_o_serial();
                        if (opc_aux == 'C') { // si se busca por cedula
                            dato_cc = lectura.leer_sin_caracteres_especiales("");
                            if (lista.buscar_estudiante_dis_por_CC(dato_cc) != null) { // si se encuentra el dispositivo, lo muestra
                                System.out.println("\n\t***EQUIPO***\n"
                                        + pila.buscar_tablet_por_CC(dato_cc, lista));
                            } else { // no se encuentra el dispositivo
                                System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                            }
                        } else if (opc_aux == 'S') { // si se busca por serial
                            dato_serial = lectura.leer_entero_excepciones("");
                            if (lista.buscar_estudiante_dis_por_serial(dato_serial) != null) { // si se encuentra el dispositivo, lo muestra
                                System.out.println("\n\t***EQUIPO***\n"
                                        + pila.buscar_tablet_por_serial(dato_serial));
                            } else { // no se encuentra el dispositivo
                                System.out.println("\n\t***NO SE ENCONTRÓ EL EQUIPO***\n");
                            }
                        }
                    } else { // de lo contrario, no se puede buscar nada
                        System.out.println("\n\t***NO HAY PRESTAMOS REGISTRADOS***\n");
                    }
                    break;
                }
                case 5 -> { // seperador de menus
                    System.out.println("\n\t************");
                    break;
                }
                default ->
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (opc_est_dis != 5);
    }

    // metodo que pregunta si desea buscar por cedula o serial
    public char elegir_CC_o_serial() throws IOException {
        // variable auxiliar
        char opc;

        do {
            opc = lectura.leer_char_excepciones("\n¿BUSQUEDA POR CÉDULA O SERIAL (C/S)?\n"); // variable a retornar
            switch (opc) {
                case 'C':
                    System.out.print("\nINGRESE LA CÉDULA DEL ESTUDIANTE: ");
                    break;
                case 'S':
                    System.out.print("\nINGRESE EL SERIAL DEL DISPOSITIVO: ");
                    break;
                default:
                    System.out.print("\n\t***INGRESE UNA OPCIÓN VALIDA***\n");
            }
        } while (opc != 'C' && opc != 'S');
        return opc;
    }

    // metodo que pregunta si el cambio de datos es para el estudiante o el dispositivo
    public char elegir_opcion_cambio() throws IOException {
        // variables auxiliares
        int opc;
        char elecc = ' ';

        // variable de control de iteracion
        boolean flag = false;

        do {
            opc = lectura.leer_entero_excepciones(
                    "¿QÚE DESESA CAMBIAR?\n\n1. ESTUDIANTE.\n\n2. DISPOSITIVO.\n\n3. NO DESEO REALIZAR CAMBIOS.\n\nNOTA: LA CÉDULA Y/O EL SERIAL NO PUEDEN SER CAMBIADOS.\n\nR// ");
            switch (opc) {
                case 1:
                    elecc = 'E'; // variable a retornar
                    flag = true;
                    break;
                case 2:
                    elecc = 'D'; // variable a retornar
                    flag = true;
                    break;
                case 3:
                    elecc = ' '; // variable a retornar
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return elecc;
    }

    // metodo que cambia el dato elegido del estudiante de ingenieria
    public estudiante_ingenieria elegir_cambio_inge(estudiante_ingenieria est) throws IOException { // recibe un objeto estudiante_ingenieria
        // variable auxiliar
        int opc;

        // variable de control de iteracion
        boolean flag = false;

        do {
            opc = lectura.leer_entero_excepciones(
                    "¿QÚE DATO DESEAS CAMBIAR?\n\n1. NOMBRE.\n\n2. APELLIDO.\n\n3. TELÉFONO.\n\n4. NÚMERO DEL SEMESTRE.\n\n5. PROMEDIO ACUMULADO.\n\n6. NO DESEO REALIZAR CAMBIOS.\n\nR// ");
            switch (opc) {
                case 1: // cambia el nombre
                    String new_nom = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL NUEVO NOMBRE: ");
                    est.setNombre(new_nom);
                    flag = true;
                    break;
                case 2: // cambia el apellido
                    String new_ape = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL NUEVO APELLIDO: ");
                    est.setApellido(new_ape);
                    flag = true;
                    break;
                case 3: // cambia el telefono
                    String new_tel = lectura.leer_sin_caracteres_especiales("\nINGRESE EL NUEVO TELÉFONO: ");
                    est.setTelefono(new_tel);
                    flag = true;
                    break;
                case 4: // cambia el numero del semestre
                    int new_sem = lectura.leer_entero_excepciones("\nINGRESE EL NUEVO NÚMERO DEL SEMESTRE: ");
                    est.setNum_sem(new_sem);
                    flag = true;
                    break;
                case 5: // cambia el promedio acumulado
                    float new_prom = lectura.leer_flotante_excepciones("\nINGRESE EL NUEVO PROMEDIO ACUMULADO: ");
                    est.setProm_acum(new_prom);
                    flag = true;
                    break;
                case 6: // no cambia nada
                    System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return est; // retorna el cambio del objeto
    }

    // metodo que cambia el dato elegido del estudiante de diseño
    public estudiante_diseño elegir_cambio_dis(estudiante_diseño est) throws IOException {
        int opc;
        boolean flag = false;
        do {
            opc = lectura.leer_entero_excepciones(
                    "¿QÚE DATO DESEAS CAMBIAR?\n\n1. NOMBRE.\n\n2. APELLIDO.\n\n3. TELÉFONO.\n\n4. MODALIDAD DE ESTUDIO.\n\n5. CANTIDAD DE ASIGNATURAS.\n\n6. NO DESEO REALIZAR CAMBIOS.\n\nR// ");
            switch (opc) {
                case 1: // cambia el nombre
                    String new_nom = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL NUEVO NOMBRE: ");
                    est.setNombre(new_nom);
                    flag = true;
                    break;
                case 2: // cambia el apellido
                    String new_ape = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL NUEVO APELLIDO: ");
                    est.setApellido(new_ape);
                    flag = true;
                    break;
                case 3: // cambia el telefono
                    String new_tel = lectura.leer_sin_caracteres_especiales("\nINGRESE EL NUEVO TELÉFONO: ");
                    est.setTelefono(new_tel);
                    flag = true;
                    break;
                case 4: // cambia la modalidad de estudio
                    String new_mod = est.obtener_modalidad_estudio(lectura);
                    est.setMod_est(new_mod);
                    break;
                case 5: // cambia la cantidad de asignaturas
                    int new_cant = lectura.leer_entero_excepciones("\nINGRESE LA NUEVA CANTIDAD DE ASIGNATURAS: ");
                    est.setCant_asig(new_cant);
                    flag = true;
                    break;
                case 6: // no cambia nada
                    System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return est; // retorna el cambio del objeto
    }

    // metodo que cambia el dato elegido del computador portatil
    public computador_portatil elegir_cambio_pc(computador_portatil pc) throws IOException {
        int opc;
        boolean flag = false;
        do {
            opc = lectura.leer_entero_excepciones(
                    "¿QÚE DATO DESEAS CAMBIAR?\n\n1. MARCA.\n\n2. TAMAÑO.\n\n3. PRECIO.\n\n4. SISTEMA OPERATIVO.\n\n5. PROCESADOR.\n\n6. NO DESEO REALIZAR CAMBIOS.\n\nR// ");
            switch (opc) {
                case 1: // cambia la marca
                    String new_marc = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE LA NUEVA MARCA: ");
                    pc.setmarca(new_marc);
                    flag = true;
                    break;
                case 2: // cambia el tamaño
                    float new_tam = lectura.leer_flotante_excepciones("\nINGRESE EL NUEVO TAMAÑO (EN PULGADAS): ");
                    pc.settam(new_tam);
                    flag = true;
                    break;
                case 3: // cambia el precio
                    float new_pre = lectura.leer_flotante_excepciones("\nINGRESE EL NUEVO PRECIO: ");
                    pc.setprecio(new_pre);
                    flag = true;
                    break;
                case 4: // cambia el sistema operativo
                    String new_sist = pc.obtener_sistema_operativo(lectura);
                    pc.setsist_ope(new_sist);
                    flag = true;
                    break;
                case 5: // cambia el procesador
                    String new_proce = pc.obtener_procesador(lectura);
                    pc.setproce(new_proce);
                    flag = true;
                    break;
                case 6: // no cambia nada
                    System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return pc; // retorna el cambio del objeto
    }

    // metodo que cambia el dato elegido de la tableta grafica
    public tableta_grafica elegir_cambio_tablet(tableta_grafica tablet) throws IOException {
        int opc;
        boolean flag = false;
        do {
            opc = lectura.leer_entero_excepciones(
                    "¿QÚE DATO DESEAS CAMBIAR?\n\n1. MARCA.\n\n2. TAMAÑO.\n\n3. PRECIO.\n\n4. ALMACENAMIENTO.\n\n5. PESO.\n\n6. NO DESEO REALIZAR CAMBIOS.\n\nR// ");
            switch (opc) {
                case 1: // cambia la marca
                    String new_marc = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE LA NUEVA MARCA: ");
                    tablet.setmarca(new_marc);
                    flag = true;
                    break;
                case 2: // cambia el tamaño
                    float new_tam = lectura.leer_flotante_excepciones("\nINGRESE EL NUEVO TAMAÑO (EN PULGADAS): ");
                    tablet.settam(new_tam);
                    flag = true;
                    break;
                case 3: // cambia el precio
                    float new_pre = lectura.leer_flotante_excepciones("\nINGRESE EL NUEVO PRECIO: ");
                    tablet.setprecio(new_pre);
                    flag = true;
                    break;
                case 4: // cambia el almacenamiento
                    String new_alm = tablet.obtener_almacenamiento(lectura);
                    tablet.setalmac(new_alm);
                    flag = true;
                    break;
                case 5: // cambia el peso
                    float new_pe = lectura.leer_flotante_excepciones("\nINGRESE EL NUEVO PESO (EN KILOGRAMOS): ");
                    tablet.setpeso(new_pe);
                    flag = true;
                    break;
                case 6: // no cambia nada
                    System.out.println("\n\t***NO SE REALIZARON CAMBIOS***\n");
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return tablet; // retorna el cambio del objeto
    }
}