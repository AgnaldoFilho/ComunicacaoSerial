/*
 * To change this licportasse header, choose Licportasse Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and opportas the template in the editor.
 */
package comunicacaoserial;

import Controller.SemaforoController;
import Model.Arduino;
import Model.PortaSerial;
import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 *
 * @author Agnaldo Filho
 */
public class Principal {
    static CommPortIdentifier portId;
    public static void main(String[] args) throws InterruptedException{
        PortaSerial portaSerial = new PortaSerial();
        Enumeration portas = portaSerial.listPortChoices();
        
        while (portas.hasMoreElements()) {
            portId = (CommPortIdentifier) portas.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                Arduino ard = new Arduino(portId.getName());
                SemaforoController semCtrl = new SemaforoController(ard);
                Thread t = new Thread(semCtrl);
                t.start();
            }
        }
        
        
        
        
            
    } 
}
