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
abstract class Sink <T>{
    Pipe<T> pipe;
    
    public Sink(){
        
    }

    public void setPipe(Pipe<T> pipe) {
        this.pipe = pipe;
    }
    
    public Pipe<T> recibirPipe(){
        return pipe;
    }
}
