/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interface.IArduino;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agnaldo Filho
 */
public class SemaforoController implements Runnable {
    private final IArduino _arduino;
    public SemaforoController(IArduino arduino){
        _arduino = arduino;
    }
    @Override
    public void run() {
        while (true) {
        try {
            _arduino.comunicacaoArduino("1");
            _arduino.ouvirArduino();
            Thread.sleep(5000);
            _arduino.comunicacaoArduino("2");
            Thread.sleep(2000);
            _arduino.comunicacaoArduino("4");
            Thread.sleep(1000);
            _arduino.comunicacaoArduino("5");
            Thread.sleep(5000);
            _arduino.comunicacaoArduino("3");
            Thread.sleep(2000);
            _arduino.comunicacaoArduino("4");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaforoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }

    
}
