package Controller;

import Interface.IArduino;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaforoController implements Runnable {

    private final IArduino _arduino;
    public int qtdCarros;
    private long tempoInicial;
    private long tempoFinal;
    private long tempoSemaforo1;
    private long tempoSemarofo2;
    public SemaforoController(IArduino arduino) {
        _arduino = arduino;
        tempoSemaforo1 = 5000;
        tempoSemarofo2 = 5000;
    }
    public SemaforoController(IArduino arduino, int somaTempo) {
        _arduino = arduino;
        tempoSemaforo1 = 5000 + somaTempo;
        tempoSemarofo2 = 5000 + somaTempo;
    }
    @Override
    public void run() {
        try {
                _arduino.comunicacaoArduino("1");
                tempoInicial = System.currentTimeMillis();
                tempoFinal = System.currentTimeMillis();
                while (tempoFinal - tempoInicial <= tempoSemaforo1) {
                    int code = _arduino.ouvirArduino();
                    if (code > -1) {
                        qtdCarros++;
                    }
                    tempoFinal = System.currentTimeMillis();
                }
                tempoInicial=0;
                tempoFinal=0;
                _arduino.comunicacaoArduino("2");
                Thread.sleep(2000);
                _arduino.comunicacaoArduino("4");
                Thread.sleep(1000);
                _arduino.comunicacaoArduino("5");
                tempoInicial = System.currentTimeMillis();
                tempoFinal = System.currentTimeMillis();
                while (tempoFinal - tempoInicial <= tempoSemarofo2) {
                    int code = _arduino.ouvirArduino();
                    if (code > -1) {
                        qtdCarros++;
                    }
                    tempoFinal = System.currentTimeMillis();
                }
                tempoInicial=0;
                tempoFinal=0;
                _arduino.comunicacaoArduino("3");
                Thread.sleep(2000);
                _arduino.comunicacaoArduino("4");
                Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaforoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
