package Week7.RentACar.view.User.Register;

import Week7.RentACar.business.Concrete.UserManager;
import Week7.RentACar.business.Handlers.SuccessİnformationMessage;
import Week7.RentACar.business.Helpers.FrameHelper;
import Week7.RentACar.business.Services.IUserService;
import Week7.RentACar.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JPanel container;
    private JLabel lbl_title;
    private JLabel lbl_name;
    private JTextField fld_name;
    private JTextField fld_email;
    private JTextField fld_phone;
    private  User user;
    private JPasswordField fld_password;
    private JButton registerButton;
    private IUserService userService;

    public RegisterView(User user){
        this.add(container);
        FrameHelper.setupFrame(this, 250, 400, "Rent A Car");
        userService = new UserManager();
        this.user = user;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setEmail(fld_email.getText());
                user.setName(fld_name.getText());
                user.setPassword(fld_password.getText());
                user.setPhone(fld_phone.getText());

                SuccessİnformationMessage createdUser = userService.create(user);
                createdUser.showMessageDialog();
                dispose();
            }
        });
    }
}
