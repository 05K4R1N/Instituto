
package config;


import institucion.Views.Principal.Welcome;
import java.io.FileReader;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;

/**
 * Esta es la clase principal, la clase que se encarga de comprar los fonemas
 * y compararlos con el carchivo ("c:/SimpleGrammarES2.txt"), donde se establecen
 * las palabras que se utilizaran en el fonema.....
 * 
 * @version 1.0.0.0 Educativa
 * @author Carlos Mario Montaño Lopera
 */
public class Reconocedor extends ResultAdapter implements Runnable {

    /**
     *Permite manipular la calculadora desde esta clase, y ejecutar las acciones
     *segun el comando de voz
     */
    Welcome principalView;
    
    /**Reconoce el comado de voz del Usuario*/
    Recognizer reconocedorVoz;
    
    /**Palabra que el usuario a pronunciado*/
    String palabra;

    public Reconocedor(Welcome pv) {
        this.principalView = pv;
    }

   
    /**
     * Captura el fonema(palabra), y la compara con un conjunto de palabras y
     * ejecuta una accion establecida.
     * 
     * Importante: yo e utilizado <code>if</code>, por que mi version del jdk
     * no permite la la utilizacion de <code>switch</code> con String
     * @param re 
     */
    @Override
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();
            
            for (int i = 0; i < tokens.length; i++) {
                palabra = tokens[i].getSpokenText();
                
                if(palabra.equals("Perfil")){
                    this.principalView.abrirSeccion("Ver");
                }
                if(palabra.equals("Editar")){
                    this.principalView.abrirSeccion("Editar");
                }
                if(palabra.equals("Enviar")){
                    this.principalView.abrirSeccion("Enviar");
                }
                if(palabra.equals("Asistencia")){
                    this.principalView.abrirSeccion("Asistencia");
                }
                if(palabra.equals("Salas")){
                    this.principalView.abrirSeccion("Salas");
                }
                if(palabra.equals("Actividades")){
                    this.principalView.abrirSeccion("Actividades");
                }
                if(palabra.equals("Estadisticas")){
                    this.principalView.abrirSeccion("Estadisticas");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Carga el archivo ("c:/InstitutoDict.txt") y para poder empezar un proceso de
     * comparacion gramatical y hacer los procesesos de reconocimiento
     * 
     * Importante: Se debe establecer un archivo ("c:/InstitutoDict.txt"), con 
     * un conjunto de expresiones gramaticales(Palabras) para poder generar
     * un proceso correcto de reconocimiento 
     */
    public void reconocerVoz() {
        try {
            reconocedorVoz = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            reconocedorVoz.allocate();

            FileReader gramatica = new FileReader("c:/InstitutoDict.txt");

            RuleGrammar reglaGramatica = reconocedorVoz.loadJSGF(gramatica);
            reglaGramatica.setEnabled(true);

             reconocedorVoz.addResultListener(new Reconocedor(principalView));
             reconocedorVoz.commitChanges();
             reconocedorVoz.requestFocus();
        } catch (Exception e) {
            System.out.println("Error en " + e.toString());
        }
    }

    @Override
    public void run() {
            this.reconocerVoz();
    }
}
