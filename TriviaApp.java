
//-----------------------------------------------------------------Andres-----------------------------------------------------------------
// Paquetes de importación para que el proyecto funcione de la manera esperada
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

// Inicio de de la clase en donde se le dice al programa que herede de el siguiente paquete javax.swing.JFrame
public class TriviaApp extends javax.swing.JFrame {

    // Declaración de la url para saber de donde saldrán las preguntas
    static String urlBD = "";
    // Se le dice que lea el archivo que se le pasa en la urlBD
    static String textoBaseDePreguntas = LeerArchivo_ASCII(urlBD);
    // Se mete en un arreglo el archivo para poder separarlo por espacios
    static String[] renglones = textoBaseDePreguntas.split("\n");
    // Se obtiene la longitud de el arreglo
    static int cantidadDePreguntas = renglones.length;

    // Seteamos un nuevo arreglo que será de tipo String
    static String[][] baseDePreguntas = new String[cantidadDePreguntas][5];

    // Declaración de variables
    String[] preguntaEscogida;
    String pregunta;
    String respuesta;
    String img;

    // Declaración de un array list
    ArrayList<String> Opciones = new ArrayList<>();

    // Inicialización de una variable global para que siempre se limpie y siempre
    // este en 0
    int n_pregunta = 0;

    // #region

    /*
     * 
     * - En esta clase es en donde se va a poder hacer un run o un debug del
     * programa
     * y es para saber si hay algún error o corrió de manera correcta
     * - Se intenta capturar el error en caso de que exista uno, si no existe ningún
     * error el programa corre correcamente
     * - Con el for y el if se intenta hacer que toda la interfaz del usuario se
     * obtenga y se cargue de manera correcta
     * 
     */

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
        new TriviaApp();
    }
}
    // #endregion
    // -----------------------------------------------------------------Andres-----------------------------------------------------------------
