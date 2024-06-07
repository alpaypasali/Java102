package Week7.RentACar.business.Handlers;

import javax.swing.*;


public class SuccessİnformationMessage {

    private String message;

    public SuccessİnformationMessage(String message) {

        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void showMessageDialog() {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
