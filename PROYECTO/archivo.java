import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class archivo {
    // archivos de los datos de los dispositivos
    File arch_ing = new File("Estudiantes_ingenieria.txt");
    File arch_dis = new File("Estudiantes_diseño.txt");

    // archivos de los datos de los dispositivos
    File arch_pc = new File("Computadores_portatiles.txt");
    File arch_tablet = new File("Tabletas_graficas.txt");

    // metodo para pasar toda la información de los estudiantes de ingenieria a archivos
    public String pasar_lista_ing_a_archivo(manejo_estudiantes lista) throws IOException {
        try {
            PrintWriter writ_ing = new PrintWriter(new FileWriter(arch_ing)); // verifica si el archivo existe
            writ_ing.write(lista.mostrar_todos_los_estudiantes_ingenieria_en_archivo());
            writ_ing.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\n\t***SE CERRÓ CORRECTAMENTE EL ARCHIVO DE LOS ESTUDIANTES DE INGENIERÍA***"; // texto a retornar
    }

    // metodo para pasar toda la información de los estudiantes de diseño a archivos
    public String pasar_lista_dis_a_archivo(manejo_estudiantes lista) throws IOException {
        try {
            PrintWriter writ_dis = new PrintWriter(new FileWriter(arch_dis)); // verifica si el archivo existe
            writ_dis.write(lista.mostrar_todos_los_estudiantes_diseño_en_archivo());
            writ_dis.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\n\t***SE CERRÓ CORRECTAMENTE EL ARCHIVO DE LOS ESTUDIANTES DE DISEÑO***"; // texto a retornar
    }

    // metodo para pasar toda la información de los portatiles a archivos
    public String pasar_pila_pc_a_archivo(manejo_dispositivos pila) throws IOException {
        try {
            PrintWriter writ_pc = new PrintWriter(new FileWriter(arch_pc)); // verifica si el archivo existe
            writ_pc.write(pila.mostrar_todos_los_portatiles_en_archivo());
            writ_pc.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\n\t***SE CERRÓ CORRECTAMENTE EL ARCHIVO DE LOS COMPUTADORES PORTÁTILES***"; // texto a retornar
    }

    // metodo para pasar toda la información de las tablets a archivos
    public String pasar_pila_tablet_a_archivo(manejo_dispositivos pila) throws IOException {
        try {
            PrintWriter writ_tablet = new PrintWriter(new FileWriter(arch_tablet)); // verifica si el archivo existe
            writ_tablet.write(pila.mostrar_todas_las_tablets_en_archivo());
            writ_tablet.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\n\t***SE CERRÓ CORRECTAMENTE EL ARCHIVO DE LAS TABLETAS GRÁFICAS***"; // texto a retornar
    }

    // metodo para pasar toda la información de los archivos de los estudiantes de ingenieria a listas
    public String pasar_archivo_a_lista_ing(manejo_estudiantes lista) throws IOException {
        // variable auxiliar
        String linea_ing;

        try {
            FileReader leer_ing = new FileReader("Estudiantes_ingenieria.txt");
            BufferedReader leer = new BufferedReader(leer_ing);
            while ((linea_ing = leer.readLine()) != null) {
                String[] datos = linea_ing.split(",");
                estudiante_ingenieria est_ing = new estudiante_ingenieria(datos[0], datos[1], datos[2], datos[3],
                        Integer.parseInt(datos[4]), Float.parseFloat(datos[5]), datos[6]);
                lista.list_ing.add(est_ing);
            }
            leer.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\t***SE LEYÓ EL ARCHIVO DE LOS ESTUDIANTES DE INGENIERÍA***\n"; // texto a retornar
    }

    // metodo para pasar toda la información de los archivos de los estudiantes de diseño a listas
    public String pasar_archivo_a_lista_dis(manejo_estudiantes lista) throws IOException {
        // variable auxiliar
        String linea_dis;
        
        try {
            FileReader leer_dis = new FileReader("Estudiantes_diseño.txt");
            BufferedReader leer = new BufferedReader(leer_dis);
            while ((linea_dis = leer.readLine()) != null) {
                String[] datos = linea_dis.split(",");
                estudiante_diseño est_dis = new estudiante_diseño(datos[0], datos[1], datos[2], datos[3],
                        datos[4], Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
                lista.list_dis.add(est_dis);
            }
            leer.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\t***SE LEYÓ EL ARCHIVO DE LOS ESTUDIANTES DE DISEÑO***\n"; // texto a retornar
    }

    // metodo para pasar toda la información de los archivos de los portatiles a pilas
    public String pasar_archivo_a_pila_pc(manejo_dispositivos pila) throws IOException {
        // variable auxiliar
        String linea_pc;

        try {
            FileReader leer_pc = new FileReader("Computadores_portatiles.txt");
            BufferedReader leer = new BufferedReader(leer_pc); // lee el archivo

            while ((linea_pc = leer.readLine()) != null) {
                String[] datos = linea_pc.split(",");
                computador_portatil pc = new computador_portatil(datos[0], datos[1], Float.parseFloat(datos[2]),
                        Float.parseFloat(datos[3]), datos[4], datos[5]);
                pila.pila_pc.add(pc);
            }
            leer.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\t***SE LEYÓ EL ARCHIVO DE LOS COMPUTADORES PORTATILES***\n"; // texto a retornar
    }

    // metodo para pasar toda la información de los archivos de las tablets a pilas
    public String pasar_archivo_a_pila_tablet(manejo_dispositivos pila) throws IOException {
        // variable auxiliar
        String linea_tablet;
        
        try {
            FileReader leer_tablet = new FileReader("Tabletas_graficas.txt");
            BufferedReader leer = new BufferedReader(leer_tablet);
            while ((linea_tablet = leer.readLine()) != null) {
                String[] datos = linea_tablet.split(",");
                tableta_grafica tablet = new tableta_grafica(datos[0], datos[1], Float.parseFloat(datos[2]),
                        Float.parseFloat(datos[3]), datos[4], Float.parseFloat(datos[5]));
                pila.pila_tablet.add(tablet);
            }
            leer.close(); // guarda y cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\t***SE LEYÓ EL ARCHIVO DE LAS TABLETAS GRÁFICAS***\n"; // texto a retornar
    }
}
