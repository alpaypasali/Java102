package Week7.RentACar;

import Week5.Icerık6.DbConn;
import Week7.RentACar.core.Db;
import Week7.RentACar.view.User.Login.LoginView;
import Week7.RentACar.view.User.Register.RegisterView;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        LoginView loginView = new LoginView();
    }
}
