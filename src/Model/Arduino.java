

package Model;

import Interface.IArduino;
import comunicacaoserial.ControlePorta;


/**
 * @author klauder
 */
public class Arduino implements IArduino {
  private ControlePorta arduino;
  
  /**
   * Construtor da classe Arduino
     * @param porta
   */
  public Arduino(String porta){
        arduino = new ControlePorta(porta,9600);
  }    


  public void comunicacaoArduino(String comando) {        
    if(null == comando){
        arduino.close();
        //System.out.println(button.getText());//Imprime o nome do botão pressionado
    }
    else switch (comando) {
          case "1":
              arduino.enviaDados(1);
              //System.out.println(button.getText());//Imprime o nome do botão pressionado
              break;
          case "2":
              arduino.enviaDados(2);
              //System.out.println(button.getText());
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
              //System.out.println(button.getText());//Imprime o nome do botão pressionado
              break;
      }
  }
}
