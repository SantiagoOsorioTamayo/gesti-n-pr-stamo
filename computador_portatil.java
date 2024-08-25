import java.io.BufferedReader;
import java.io.InputStreamReader;

public class computador_portatil extends dispositivo {

    // variables locales de la clase computador portatil
    private String sist_ope, proce, serial;

    public computador_portatil() {

    }

    // constructor de la clase computador portatil
    public computador_portatil(String serial, String marca, float tam, float precio, String sist_ope, String proce) {
        super(marca, tam, precio);
        this.sist_ope = sist_ope;
        this.proce = proce;
        this.serial = serial;
    }

    // getters y setters
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

    public String getserial(){
        return serial;
    }

    public void setserial(String serial){
        this.serial = serial;
    }
    
    // metodo para mostrar los datos del objeto computador portatil
    @Override
    public String toString() {
        return super.toString() + "\nSISTEMA OPERATIVO: " + sist_ope + "\nPROCESADOR: " + proce + "\n";
    }

    public computador_portatil ingresar_datos_pc(String serial) {
        dispositivo disp_aux = new dispositivo();
        String sist_ope = "", proce = "";
        boolean flag = true;
        do {
            try {
                disp_aux = disp_aux.ingresar_datos_base();
                sist_ope = obtener_sistema_operatico();
                proce = obtener_procesador();
                flag = true;
            } catch (Exception e) {
                System.out.println("\n***ESCRIBE CON UN TIPO DE CARACTERES CORRECTOS***\n");
                flag = false;
            }
        } while (flag == false);
        computador_portatil pc = new computador_portatil(serial, disp_aux.getmarca(), disp_aux.gettam(), disp_aux.getprecio(), sist_ope, proce); // objeto a retornar
        return pc;
    }

    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public String obtener_sistema_operatico() {
        int opc;
        String sist = "";
        boolean flag = false;
        do {
            try {
                System.out.print("\n¿QUÉ SISTEMA OPERATIVO POSEE EL PORTATIL?\n1) Windows 7.\n2) Windows 10.\n3) Windows 11.\nR// ");
                opc = Integer.parseInt(leer.readLine());
                switch (opc) {
                    case 1:
                        sist = "Windows 7";
                        flag = true;
                        break;
                    case 2:
                        sist = "Windows 10";
                        flag = true;
                        break;
                    case 3:
                        sist = "Windows 11";
                        flag = true;
                        break;
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);
        return sist;
    }

    public String obtener_procesador() {
        int opc;
        String proc = "";
        boolean flag = false;
        do {
            try {
                System.out.print("\n¿QUÉ PROCESADOR POSEE EL PORTATIL?\n1) AMD Ryzen.\n2) Intel Core i5.\nR// ");
                opc = Integer.parseInt(leer.readLine());
                switch (opc) {
                    case 1:
                        proc = "AMD Ryzen";
                        flag = true;
                        break;
                    case 2:
                        proc = "Intel Core i5";
                        flag = true;
                        break;
                    default:
                        System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n\t***INGRESE UNA OPCIÓN VÁLIDA***\n");
            }
        } while (flag == false);
        return proc;
    }
}
