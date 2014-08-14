
import gui.MainMenuFrame;

/**
 *
 * @author Kendall Lauren Chin
 */
public class Main {

    public static void main(String[] args) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuFrame().setVisible(true);
            }
        });
    }
}
