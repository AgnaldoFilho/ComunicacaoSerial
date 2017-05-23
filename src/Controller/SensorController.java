/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interface.IArduino;

/**
 *
 * @author Agnaldo Filho
 */
public class SensorController implements Runnable {
    private final IArduino _arduino;
    private int qtdCarros;
    public SensorController(IArduino arduino){
        _arduino = arduino;
        qtdCarros = 0;
    }
    @Override
    public void run(){
        while(true){
            int code = _arduino.ouvirArduino();
            
            if (code > -1) {
                qtdCarros ++;
                System.out.println("Sensor: Passou " + qtdCarros + " carros" );
            }
            
        }
        
    }
}
