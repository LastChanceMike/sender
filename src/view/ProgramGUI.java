package view;

import controller.ExcelController;
import controller.Sender;
import model.User;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

/**
 * Created by DORDV on 17.08.2018.
 */
public class ProgramGUI extends JFrame {

    ExcelController controller = new ExcelController();

    private JButton button = new JButton("Send");
    private JTextField filePath = new JTextField("E:/it/Igor/Mannatech Orders on mannatech.online.xlsx", 15);
    private JLabel label = new JLabel("File path:");
    private Sender sender;

    public ProgramGUI(Sender sender){
        super("Sender");
        this.setBounds(100, 100, 500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.sender = sender;

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(filePath);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /*java.util.List<User> result = new LinkedList<User>();
            String message = new String();

            try {
                result = controller.getAll(filePath.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            for (User u: result) {
                message += "\n" + u.toString();
            }*/

            String message = "";
            String newMessage = "";
            Connection con = Jsoup.connect("https://preview.mailerlite.com/w0c9d3");
            try {
                Document doc = con.get();
                message = doc.outerHtml();
                newMessage = message.replace("05228952954303", "New number");
            } catch (IOException e1) {
                e1.printStackTrace();
            }


            sender.send("test", newMessage, "test@mannatech.com.ua", "mykhailprykhodko@gmail.com");
        }
    }

}
