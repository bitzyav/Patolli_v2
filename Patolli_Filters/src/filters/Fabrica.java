/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

/**
 *
 * @author alfonsofelix
 */
public class Fabrica {
    static IFilter filter;
    
    public static IFilter getFachada(){
        if(filter==null){
            filter=new FFilter();
        }
        return filter;
    }
}
