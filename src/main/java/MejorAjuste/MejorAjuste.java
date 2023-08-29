/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package MejorAjuste;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 *
 * @author JOSHUA
 */
public class MejorAjuste {

    public static void Ordenamiento(List<Particion> particiones) {
        int n = particiones.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (particiones.get(j).tamano > particiones.get(j + 1).tamano) {
                    Particion temp = particiones.get(j);
                    particiones.set(j, particiones.get(j + 1));
                    particiones.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        int MemoriaTotal = 2000;
        int MemoriaUtilizada =0;//memoria que utiliza el sistema Operativo
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de particiones(El sistema Operativo cuenta como particion con valor de 100): ");
        int numParticiones = scanner.nextInt();

        List<Proceso> procesos = new ArrayList<>();
        List<Particion> particiones = new ArrayList<>();

        for (int i = 0; i < numParticiones; i++) {
            System.out.print("Ingrese el tamaño de la partición " + (i + 1) + ": ");
            int tamanoParticion = scanner.nextInt();
            if (tamanoParticion > MemoriaTotal) {
                System.out.print("El tamaño de la Partición no puede ser más grande que la memoria Total");
                return;
            }
            particiones.add(new Particion(i + 1, tamanoParticion));
        }

        Ordenamiento(particiones);
        System.out.println("Particiones ordenadas por tamaño:");
    for (Particion particion : particiones) {
        System.out.println("Partición " + particion.id + ": Tamaño = " + particion.tamano);
    }
        procesos.add(new Proceso("S.O", 100));
        procesos.add(new Proceso("JAVA", 70));
        procesos.add(new Proceso("word", 200));
        procesos.add(new Proceso("Paint", 10));
        procesos.add(new Proceso("sql", 10));
        procesos.add(new Proceso("a", 250));
        for (int i = 0; i < procesos.size(); i++) {
            Proceso
                    proceso = procesos.get(i);
            boolean asignado = false;

            for (int j = 0; j < particiones.size(); j++) {
                Particion particion = particiones.get(j);
                if (!particion.ocupada && particion.tamano >= proceso.tamano) {
                    particion.ocupada = true;
                    particion.nombreProceso = proceso.nombre;
                    asignado = true;
                    System.out.println(proceso.nombre + " asignado a la Particion " + particion.id);
                    MemoriaUtilizada+=proceso.tamano;
                    break;
                }
            }

            if (!asignado) {
                System.out.println(proceso.nombre + " no fue asignado a memoria.");
            }
        }
        
        int MemoriaDisponible=MemoriaTotal-MemoriaUtilizada;
        System.out.println("Memoria dispnible es: "+MemoriaDisponible);
   
    }
}
