import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class manejo_string {
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public String leer_sin_numeros_ni_caracteres_especiales(String mensaje) throws IOException {
        String dato = "";
        do {
            System.out.print(mensaje);
            dato = leer.readLine().toUpperCase().trim();
            if (!dato.matches("[a-zA-Z\\s]+")) {
                System.out.println("\n***ESCRIBE LA INFORMACIÓN SIN CARÁCTERES ESPECIALES NI NÚMEROS***");
            }
        } while (!dato.matches("[a-zA-Z\\s]+"));
        return dato;
    }

    public String leer_sin_caracteres_especiales(String mensaje) throws IOException {
        String dato = "";
        do {
            System.out.print(mensaje);
            dato = leer.readLine().toUpperCase().trim();
            if (!dato.matches("[a-zA-Z0-9\\s]+")) {
                System.out.println("\n***ESCRIBE LA INFORMACIÓN SIN CARÁCTERES ESPECIALES***");
            }
        } while (!dato.matches("[a-zA-Z0-9\\s]+"));
        return dato;
    }
}
