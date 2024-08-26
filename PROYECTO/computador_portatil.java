import java.io.IOException;

public class computador_portatil extends dispositivo {

    // variables locales de la clase computador_portatil
    private String sist_ope, proce, serial;

    public computador_portatil() {

    }

    // constructor de la clase computador_portatil
    public computador_portatil(String serial, String marca, float tam, float precio, String sist_ope, String proce) {
        super(serial, marca, tam, precio);
        this.sist_ope = sist_ope;
        this.proce = proce;
        this.serial = serial;
    }

    // getters y setters
    public String getserial() {
        return serial;
    }

    public void setserial(String serial) {
        this.serial = serial;
    }

    public String getsist_ope() {
        return sist_ope;
    }

    public void setsist_ope(String sist_ope) {
        this.sist_ope = sist_ope;
    }

    public String getproce() {
        return proce;
    }

    public void setproce(String proce) {
        this.proce = proce;
    }

    // metodo para mostrar los datos del objeto computador_portatil
    @Override
    public String toString() {
        return super.toString() + "\nSISTEMA OPERATIVO: " + sist_ope + "\nPROCESADOR: " + proce + "\nSERIAL: " + serial + "\n";
    }

    // metodo que crea un objeto computador_portatil
    public computador_portatil ingresar_datos_pc(String serial, manejo_lectura lectura) throws IOException { //recibe el serial y la instancia de manejo_lectura
        //instancia auxiliar
        dispositivo disp_aux = new dispositivo();

        //varibles auxiliares
        String sist_ope = "", proce = "";

        disp_aux = disp_aux.ingresar_datos_base(lectura, serial);
        sist_ope = obtener_sistema_operativo(lectura);
        proce = obtener_procesador(lectura);
        computador_portatil pc = new computador_portatil(disp_aux.getSerial(), disp_aux.getmarca(), disp_aux.gettam(), disp_aux.getprecio(), sist_ope, proce); // objeto a retornar
        return pc;
    }

    // metodo que obtiene el sistema operativo
    public String obtener_sistema_operativo(manejo_lectura lectura) throws IOException { // recibe la instancia de manejo_lectura
        // variables auxiliares
        int opc;
        String sist = "";

        //variable de control de iteración
        boolean flag = false;

        do {
            opc = lectura.leer_entero_excepciones("\n¿QUÉ SISTEMA OPERATIVO POSEE EL PORTATIL?\n1) WINDOWS 7.\n2) WINDOWS 10.\n3) WINDOWS 11.\nR// ");
            switch (opc) {
                case 1:
                    sist = "WINDOWS 7"; // variable a retornar
                    flag = true;
                    break;
                case 2:
                    sist = "WINDOWS 10"; // variable a retornar
                    flag = true;
                    break;
                case 3:
                    sist = "WINDOWS 11"; // variable a retornar
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return sist;
    }

    // metodo que obtiene el procesador
    public String obtener_procesador(manejo_lectura lectura) throws IOException { // recibe la instancia de manejo_lectura
        // variables auxiliares
        int opc;
        String proc = "";

        // variable de control de iteración
        boolean flag = false;

        do {
            opc = lectura.leer_entero_excepciones("\n¿QUÉ PROCESADOR POSEE EL PORTATIL?\n1) AMD RYZEN.\n2) INTEL CORE i5.\nR// ");
            switch (opc) {
                case 1:
                    proc = "AMD RYZEN"; // variable a retornar
                    flag = true;
                    break;
                case 2:
                    proc = "INTEL CORE i5"; // variable a retornar
                    flag = true;
                    break;
                default:
                    System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                    break;
            }
        } while (flag == false);
        return proc;
    }
}
