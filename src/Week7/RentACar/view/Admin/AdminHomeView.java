package Week7.RentACar.view.Admin;

import Week7.RentACar.business.Helpers.FrameHelper;
import Week7.RentACar.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeView extends  JFrame {
    private JPanel container;
    private JButton btn_mngBrands;
    private JButton btn_mngUsers;
    private JButton btn_mngModels;
    private JButton btn_mngBooks;
    private JButton btn_mngCars;
    private User user;

    public  AdminHomeView(User user){
        this.add(container);
        this.user = user;
        FrameHelper.setupFrame(this, 500, 250, "Rent A Car");


        btn_mngUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminUserView userView = new AdminUserView(user);

            }
        });
    }


}
