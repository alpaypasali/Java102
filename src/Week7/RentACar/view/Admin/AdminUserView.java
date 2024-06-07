package Week7.RentACar.view.Admin;

import Week7.RentACar.business.Concrete.UserManager;
import Week7.RentACar.business.Services.IUserService;
import Week7.RentACar.entity.User;
import Week7.RentACar.view.AdminLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AdminUserView extends AdminLayout {
    private JPanel container;
    private JLabel lbl_userTitle;
    private JTable tbl_userList;

    private User user;
    private IUserService userService;
    public DefaultTableModel defaultTableModel = new DefaultTableModel();

    public AdminUserView(User user) {
        this.user = user;
        userService = new UserManager();
        // Initialize components
            guiIntilaze();

        // Set up the frame
        this.add(container);






        createTable();
    }

    public void createTable() {
        // Column names for the table
        Object[] columnNames = {"id", "name", "email", "phone", "role"};
        ArrayList<Object[]> userList = userService.getForTable(columnNames.length);


        createTable(defaultTableModel,tbl_userList,columnNames,userList);




    }
}
