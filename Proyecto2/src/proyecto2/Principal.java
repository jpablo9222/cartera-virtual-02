package proyecto2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tono
 */
import java.util.ArrayList;
public class Principal {
    private static ArrayList <AplicacionesInternet> listAppI=new ArrayList();
    private static ArrayList <DispositivosE> listDispE=new ArrayList();
    private static ArrayList <Membresia> listMembresia =new ArrayList();
    private static ArrayList <ProductosInfo> listProdInfo =new ArrayList();
    
    public static void addAppI(AplicacionesInternet AplicacionesInternet){
            listAppI.add(AplicacionesInternet);
    }
    public static void addDispE(DispositivosE DispositivosE){
        listDispE.add(DispositivosE);
    }
    public static void addMembresia(Membresia Membresia){
        listMembresia.add(Membresia);
    }
    public static void addProdInfo(ProductosInfo ProductosInfo){
        listProdInfo.add(ProductosInfo);
    }
    public static void main(String[] args) {
        
    }
}
