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
    public static void addAppI(AppsInternet AplicacionesInternet){
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
    public static ArrayList getAppi(){
        return listAppI;
    }
    public static ArrayList getDispE(){
        return listDispE;
    }
    public static ArrayList getMembresia(){
        return listMembresia;
    }
    public static ArrayList getProdInfo(){
        return listProdInfo;
    }
    public static void main(String[] args) {
        
    }
}
