package comunicacaoserial;

import Controller.SemaforoController;
import Controller.SensorController;
import Model.Arduino;
import Model.PortaSerial;
import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

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
                Thread tSemaforo = new Thread(semCtrl);
                tSemaforo.start();
                SensorController sensorController = new SensorController(ard);
                Thread tSensor = new Thread(sensorController);
                tSensor.start();
                
            }
        }
        
        
        
        
            
    } 
}
