

package Model;

import Interface.IArduino;
import comunicacaoserial.ControlePorta;


/**
 * @author klauder
 */
public class Arduino implements IArduino {
  private final ControlePorta arduino;
  
  public Arduino(String porta){
        arduino = new ControlePorta(porta,9600);
  }   
  @Override
  public int ouvirArduino(){
      return arduino.receberDados();
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
