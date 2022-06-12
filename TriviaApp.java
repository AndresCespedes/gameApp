
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

        // -----------------------------------------------------------------Camilo-----------------------------------------------------------------
    // #region
    // Con esta función se obtiene la pregunta y se limpia cuando cambie de pantalla
    // para así obtener la siguiente pregunta
    public void escogerPregunta(int n) {
        preguntaEscogida = baseDePreguntas[n];
        pregunta = preguntaEscogida[0];
        respuesta = preguntaEscogida[1];
        if (preguntaEscogida.length > 5) {
            img = preguntaEscogida[5];
        } else {
            img = "";
        }
        Opciones.clear();
        for (int i = 1; i < 5; i++) {
            Opciones.add(preguntaEscogida[i]);
        }
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(Opciones);
        }
    }
    // #endregion

    // #region
    /*
     * En esta función se muestra la imágen que se va a cargar a la vista del
     * usuario y se valida si se puede obtener o si no
     * Tambien se obtiene los distintos botones de repuesta, se setean y se les da
     * la posición
     */
    public void mostrarPregunta() {
        jLabel1.setText(pregunta);
        if (img.equals("")) {
            jLabel2.setVisible(false);
        } else {
            jLabel2.setVisible(true);
            jLabel2.setText("");
            try {
                BufferedImage imagen = ImageIO.read(new URL(img));
                Image imagenEscalada = imagen.getScaledInstance(-1, 200, Image.SCALE_SMOOTH);
                jLabel2.setIcon(new ImageIcon(imagenEscalada));
            } catch (Exception e) {
                jLabel2.setText("La imágen no se pudo cargar");
                jLabel2.setIcon(null);
            }
        }
        jButton1.setText(Opciones.get(0));
        jButton2.setText(Opciones.get(1));
        jButton4.setText(Opciones.get(2));
        jButton3.setText(Opciones.get(3));
    }
    // #endregion
    // -----------------------------------------------------------------Camilo-----------------------------------------------------------------
