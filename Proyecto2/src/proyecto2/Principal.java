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
    private ArrayList <AplicacionesIntenet> listAppI=new ArrayList();
    private ArrayList <DispositivosE> listDispE=new ArrayList();
    private ArrayList <Membresia> listMembrecia =new ArrayList();
    private ArrayList <ProductosInfo> listProdInfo =new ArrayList();
    
    public static void addAppI(Cuenta AplicacionesInternet){
            listAppI.add(AplicacionesInternet);
    }
    public static void addDispE(Cuenta DispositivosE){
        listDispE.add(DispositivosE);
    }
    public static void addMembresia(Cuenta Membresia){
        listMembresia.add(Membresia);
    }
    public static void addProdInfo(Cuenta ProductosInfo){
        listProdInfo.add(ProductosInfo);
    }
    public static void main(String[] args) {
        
    }
}
