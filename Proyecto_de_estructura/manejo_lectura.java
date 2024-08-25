import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class manejo_lectura {
    // instancia de la clase BufferedReader
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    // metodo que lee una cadena de texto, pero sin numeros ni caracteres especiales
    public String leer_sin_numeros_ni_caracteres_especiales(String mensaje) throws IOException { // recibe un mensaje/pregunta para pedir la variable
        //variable auxiliar
        String dato = "";

        do {
            System.out.print(mensaje);
            dato = leer.readLine().toUpperCase().trim(); // variable a retornar
            if (!dato.matches("[a-zA-Z\\s]+")) { // si el dato leido posee caracteres fuera de los permitidos (caracteres especiales y numeros)
                System.out.println("\n***ESCRIBE ALGO DE INFORMACIÓN SIN CARÁCTERES ESPECIALES, NI NÚMEROS***");
            }
        } while (!dato.matches("[a-zA-Z\\s]+")); // mientras haya caracteres fuera de los permitidos
        return dato;
    }
 
    // metodo que lee una cadena de texto, pero sin caracteres especiales
    public String leer_sin_caracteres_especiales(String mensaje) throws IOException { // recibe un mensaje/pregunta para pedir la variable
        //variable auxiliar
        String dato = "";

        do {
            System.out.print(mensaje);
            dato = leer.readLine().toUpperCase().trim(); // variable a retornar
            if (!dato.matches("[a-zA-Z0-9\\s]+")) { // si el dato leido posee caracteres fuera de los permitidos (caracteres especiales)
                System.out.println("\n***ESCRIBE ALGO DE INFORMACIÓN SIN CARÁCTERES ESPECIALES***");
            }
        } while (!dato.matches("[a-zA-Z0-9\\s]+")); // mientras haya caracteres fuera de los permitidos
        return dato;
    }

    // metodo que lee un entero, manejando sus excepciones
    public int leer_entero_excepciones(String mensaje) throws IOException { // recibe un mensaje/pregunta para pedir la variable
        //variable auxiliar
        int dato = 0;

        //variable de control de iteración
        boolean flag = false;

        do {
            try {
                System.out.print(mensaje);
                dato = Integer.parseInt(leer.readLine().trim()); // variable a retornar
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE ALGO DE INFORMACIÓN SIN LETRAS, NI CARÁCTERES ESPECIALES***");
                flag = false;
            }
        } while (flag != true);
        return dato;
    }

    // metodo que lee un flotante, manejando sus excepciones
    public float leer_flotante_excepciones(String mensaje) throws IOException { // recibe un mensaje/pregunta para pedir la variable
        //variable auxiliar
        float dato = 0;

        //variable de control de iteración
        boolean flag = false;

        do {
            try {
                System.out.print(mensaje);
                dato = Float.parseFloat(leer.readLine().trim()); // variable a retornar
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE ALGO DE INFORMACIÓN CON UN PUNTO SI HAY DECIMALES, SIN LETRAS, NI CARÁCTERES ESPECIALES***");
                flag = false;
            }
        } while (flag != true);
        return dato;
    }

    public char leer_char_excepciones(String mensaje) throws IOException { // recibe un char para pedir la variable
        //variable auxiliar
        char dato = 0;

        System.out.print(mensaje);
        dato = leer.readLine().trim().toUpperCase().charAt(0); // variable a retornar
        return dato;
    }
}
