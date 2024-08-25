import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class estudiante_ingenieria extends estudiante {

    // variables locales de la clase estudiante ingeniería
    private int num_sem;
    private float prom_acum;
    private String serial;

    public estudiante_ingenieria() {
    }

    // constructor de la clase estudiante ingeniería
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

    public String getSerial(){
        return serial;
    }

    public void setSerial(String serial){
        this.serial = serial;
    }

    // metodo para mostrar los datos del objeto estudiante
    @Override
    public String toString() {
        return super.toString() + "\nNÚMERO DE SEMESTRE: " + num_sem + "\nPROMEDIO ACUMULADO: " + prom_acum + "\n";
    }

    // metodo que pide los datos de un estudiante de ingeniería y retorna un objeto
    // estudiante ingenieria
    public estudiante_ingenieria ingresar_datos_inge(manejo_estudiantes lista, manejo_dispositivos pila, String ced) throws IOException {
        estudiante est_aux = new estudiante();
        manejo_string str = new manejo_string();
        estudiante_ingenieria est = null;
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int num_sem = 0;
        float prom = 0F;
        String seri = "";
        boolean flag = false;
        do {
            try {
                est_aux = est_aux.ingresar_datos_base(ced);
                seri = str.leer_sin_caracteres_especiales("\nINGRESE EL SERIAL DEL DISPOSITIVO A PRESTAR: ");
                if (pila.buscar_portatil_por_serial(seri) == null) {
                    System.out.print("\nINGRESE EL NÚMERO DEL SEMESTRE EN EL QUE CURSA EL ESTUDIANTE: ");
                    num_sem = Integer.parseInt(leer.readLine());
                    System.out.print("\nINGRESE EL PROMEDIO ACUMULADO DEL ESTUDIANTE: ");
                    prom = Float.parseFloat(leer.readLine());
                    est = new estudiante_ingenieria(ced, est_aux.getNombre(), est_aux.getApellido(), est_aux.getTelefono(), num_sem, prom, seri); // objeto a retornar
                } else {
                    System.out.println("\n\t***EL COMPUTADOR PORTATIL YA HA SIDO PRESTADO***");
                    est = null;
                }
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE CON UN TIPO DE CARACTERES CORRECTOS***\n");
                flag = false;
            }
        } while (flag == false);
        return est;
    }
}
