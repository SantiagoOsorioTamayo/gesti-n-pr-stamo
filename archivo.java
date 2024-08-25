import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class archivo {
    File arch_ing = new File("Estudiantes_ingenieria.txt");
    File arch_dis = new File("Estudiantes_diseño.txt");
    File arch_pc = new File("Computadores_portatiles.txt");
    File arch_tablet = new File("Tabletas_graficas.txt");

    public String pasar_lista_a_archivo(manejo_estudiantes lista) throws IOException {
        PrintWriter writ_ing = new PrintWriter(new FileWriter(arch_ing));
        PrintWriter writ_dis = new PrintWriter(new FileWriter(arch_dis));
        writ_ing.write(lista.mostrar_todos_los_estudiantes_ingenieria_en_archivo());
        writ_dis.write(lista.mostrar_todos_los_estudiantes_diseño_en_archivo());
        writ_ing.close();
        writ_dis.close();
        return "\n\t***SE REALIZARON CAMBIOS A LOS ARCHIVOS PARA LA INFORMACIÓN DE LOS ESTUDIANTES***\n";
    }

    public String pasar_archivo_a_lista(manejo_estudiantes lista) throws IOException {
        PrintWriter writ_ing = new PrintWriter(new FileWriter(arch_ing));
        PrintWriter writ_dis = new PrintWriter(new FileWriter(arch_dis));
        try (BufferedReader leer_ing = new BufferedReader(new FileReader("Estudiantes_ingenieria.txt"))) {
            String linea_ing = leer_ing.readLine();
            while (linea_ing != null) {
                String[] datos = linea_ing.split(",");
                estudiante_ingenieria est_ing = new estudiante_ingenieria(datos[0], datos[1], datos[2], datos[3],
                        Integer.parseInt(datos[4]), Float.parseFloat(datos[5]), datos[6]);
                lista.list_ing.add(est_ing);
                linea_ing = leer_ing.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader leer_dis = new BufferedReader(new FileReader("Estudiantes_diseño.txt"))) {
            String linea_dis = leer_dis.readLine();
            while (linea_dis != null) {
                String[] datos = linea_dis.split(",");
                estudiante_diseño est_dis = new estudiante_diseño(datos[0], datos[1], datos[2], datos[3], datos[4],
                        Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
                lista.list_dis.add(est_dis);
                linea_dis = leer_dis.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writ_ing.close();
        writ_dis.close();
        return "\t***SE LEYERON LOS DATOS DE LOS ESTUDIANTES***\n";
    }

    public String pasar_pila_a_archivo(manejo_dispositivos pila) throws IOException {
        PrintWriter writ_pc = new PrintWriter(new FileWriter(arch_pc));
        PrintWriter writ_tablet = new PrintWriter(new FileWriter(arch_tablet));
        writ_pc.write(pila.mostrar_todos_los_portatiles_en_archivo());
        writ_tablet.write(pila.mostrar_todas_las_tablets_en_archivo());
        writ_pc.close();
        writ_tablet.close();
        return "\n\t***SE REALIZARON CAMBIOS A LOS ARCHIVOS PARA LA INFORMACIÓN DE LOS DISPOSITIVOS***\n";
    }

    public String pasar_archivo_a_pila(manejo_dispositivos pila) throws IOException {
        String[] datos;
        PrintWriter writ_pc = new PrintWriter(new FileWriter(arch_pc));
        PrintWriter writ_tablet = new PrintWriter(new FileWriter(arch_tablet));
        try (BufferedReader leer_pc = new BufferedReader(new FileReader("Computadores_portatiles.txt"))) {
            String linea_pc = leer_pc.readLine();
            while (linea_pc != null) {
                datos = linea_pc.split(",");
                computador_portatil pc = new computador_portatil(datos[0], datos[1], Float.parseFloat(datos[2]),
                        Float.parseFloat(datos[3]), datos[4], datos[5]);
                pila.pila_pc.add(pc);
                linea_pc = leer_pc.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader leer_tablet = new BufferedReader(new FileReader("Tabletas_graficas.txt"))) {
            String linea_tablet = leer_tablet.readLine();
            while (linea_tablet != null) {
                datos = linea_tablet.split(",");
                tableta_grafica tablet = new tableta_grafica(Integer.parseInt(datos[0]), datos[1], Float.parseFloat(datos[2]),
                        Float.parseFloat(datos[3]), datos[4], Float.parseFloat(datos[5]));
                pila.pila_tablet.add(tablet);
                linea_tablet = leer_tablet.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writ_pc.close();
        writ_tablet.close();
        return "\t***SE LEYERON LOS DATOS DE LOS DISPOSITIVOS***\n";
    }
}
