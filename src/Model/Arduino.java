

package Model;

import Interface.IArduino;
import comunicacaoserial.ControlePorta;
import comunicacaoserial.EscutaSerial;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author klauder
 */
public class Arduino implements IArduino {
  private ControlePorta arduino;
  private EscutaSerial escuta;
  
  /**
   * Construtor da classe Arduino
     * @param porta
   */
  public Arduino(String porta){
        arduino = new ControlePorta("COM4",9600);
        escuta = new EscutaSerial(porta,9600);
  }   
  @Override
  public int ouvirArduino(){
      try {
          return arduino.receberDados();
      } catch (IOException ex) {
          Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
      }
      return 0;
  }
  @Override
  public void comunicacaoArduino(String comando) {        
    if(null == comando){
        arduino.close();
    }
    else switch (comando) {
          case "1":
              arduino.enviaDados(1);
              break;
          case "2":
              arduino.enviaDados(2);
              break;
          case "3":
               arduino.enviaDados(3);
              break;
          case "4":
              arduino.enviaDados(4);
              break;
          case "5":
              arduino.enviaDados(5);
              break;
          default:
              arduino.close();
              break;
      }
  }
}
