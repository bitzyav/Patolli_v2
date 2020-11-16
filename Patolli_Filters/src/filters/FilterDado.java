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
class FilterDado extends Filter{

    @Override
    protected void doChain(Pipe pipe) {
        new FilterMovimiento().doChain(pipe);
    }
    
}
