import java.io.IOException;

public class estudiante {

    protected String CC, nombre, apellido, telefono; // variables locales de la clase estudiante

    public estudiante() {
    }

    // constructor de la clase estudiante
    public estudiante(String CC, String nombre, String apellido, String telefono) {
        this.CC = CC;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // getters y setters
    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // metodo para mostrar los datos del objeto estudiante
    @Override
    public String toString() {
        return "\nNOMBRE: " + nombre + "\nAPELLIDO: " + apellido + "\nTELÉFONO: " + telefono;
    }

    // metodo que pide los datos de un estudiante de ingeniería y retorna un objeto estudiante ingenieria
    public estudiante ingresar_datos_base(String ced) throws IOException {
        manejo_string str = new manejo_string();
        String nom = "", ape = "", tel = "";
        boolean flag = true;
        do {
            try {
                nom = str.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL NOMBRE DEL ESTUDIANTE: ");
                ape = str.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL APELLIDO DEL ESTUDIANTE: ");
                tel = str.leer_sin_caracteres_especiales("\nINGRESE EL TELÉFONO DEL ESTUDIANTE: ");
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE CON UN TIPO DE CARACTERES CORRECTOS***\n");
                flag = false;
            }
        } while (flag == false);
        estudiante est = new estudiante(ced, nom, ape, tel); // objeto a retornar
        return est;
    }
}
