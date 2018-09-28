import controller.ExcelController;
import controller.Sender;
import view.ProgramGUI;

/**
 * Created by DORDV on 17.08.2018.
 */
public class Main {
    public static void main(String[] args) {

        Sender sender = new Sender("test@mannatech.com.ua", "testMannatech123");
        ProgramGUI programGUI = new ProgramGUI(sender);
        programGUI.setVisible(true);



    }
}
