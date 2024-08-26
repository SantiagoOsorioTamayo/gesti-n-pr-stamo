import java.io.IOException;

public class estudiante_ingenieria extends estudiante {

    // variables locales de la clase estudiante_ingenieria
    private int num_sem;
    private float prom_acum;
    private String serial;

    public estudiante_ingenieria() {
    }

    // constructor de la clase estudiante_ingenieria
    public estudiante_ingenieria(String CC, String nombre, String apellido, String telefono, int num_sem,
            float prom_acum, String serial) {
        super(CC, nombre, apellido, telefono);
        this.num_sem = num_sem;
        this.prom_acum = prom_acum;
        this.serial = serial;
    }

    // getters y setters
    public int getNum_sem() {
        return num_sem;
    }

    public void setNum_sem(int num_sem) {
        this.num_sem = num_sem;
    }

    public float getProm_acum() {
        return prom_acum;
    }

    public void setProm_acum(float prom_acum) {
        this.prom_acum = prom_acum;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    // metodo para mostrar los datos del objeto estudiante
    @Override
    public String toString() {
        return super.toString() + "\nNÚMERO DE SEMESTRE: " + num_sem + "\nPROMEDIO ACUMULADO: " + prom_acum + "\nDISPOSITIVO PRESTADO (SERIAL): " + serial + "\n";
    }

    // metodo que crea un objeto estudiante_ingenieria
    public estudiante_ingenieria ingresar_datos_inge(manejo_estudiantes lista, manejo_dispositivos pila, manejo_lectura lectura, String ced)
            throws IOException { // recibe las instancias de cada "manejo" y la cedula
        //instancias auxiliares
        estudiante est_aux = new estudiante();
        estudiante_ingenieria est;

        //variables auxiliares
        int num_sem = 0;
        float prom = 0F;
        String seri = "";

        est_aux = est_aux.ingresar_datos_base(ced, lectura);
        seri = lectura.leer_sin_caracteres_especiales("\nINGRESE EL SERIAL DEL DISPOSITIVO A PRESTAR: ");
        if (pila.buscar_portatil_por_serial(seri) == null) {  // si no encuentra el portatil puede seguir ingresando datos
            num_sem = lectura
                    .leer_entero_excepciones("\nINGRESE EL NÚMERO DEL SEMESTRE EN EL QUE CURSA EL ESTUDIANTE: ");
            prom = lectura.leer_flotante_excepciones("\nINGRESE EL PROMEDIO ACUMULADO DEL ESTUDIANTE: ");
            est = new estudiante_ingenieria(ced, est_aux.getNombre(), est_aux.getApellido(), est_aux.getTelefono(),
                    num_sem, prom, seri); // objeto a retornar
        } else { // si lo encuentra quiere decir que ya ha sido prestado
            System.out.println("\n\t***EL COMPUTADOR PORTATIL YA HA SIDO PRESTADO***");
            est = null; // objeto a retornar
        }
        return est;
    }
}
