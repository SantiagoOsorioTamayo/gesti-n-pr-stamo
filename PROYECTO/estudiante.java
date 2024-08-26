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
        return "\nCÉDULA: " + CC + "\nNOMBRE: " + nombre.toUpperCase() + "\nAPELLIDO: " + apellido.toUpperCase() + "\nTELÉFONO: " + telefono;
    }

    // metodo que crea un objeto estudiante
    public estudiante ingresar_datos_base(String ced, manejo_lectura lectura) throws IOException { //recibe la cedula y la instancia de manejo_lectura
        // variables auxiliares
        String nom = "", ape = "", tel = "";

        nom = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL NOMBRE DEL ESTUDIANTE: ");
        ape = lectura.leer_sin_numeros_ni_caracteres_especiales("\nINGRESE EL APELLIDO DEL ESTUDIANTE: ");
        tel = lectura.leer_sin_caracteres_especiales("\nINGRESE EL TELÉFONO DEL ESTUDIANTE: ");
        estudiante est = new estudiante(ced, nom, ape, tel); // objeto a retornar
        return est;
    }
}
