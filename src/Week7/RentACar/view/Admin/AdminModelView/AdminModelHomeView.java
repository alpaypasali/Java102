package Week7.RentACar.view.Admin.AdminModelView;

import Week7.RentACar.business.Concrete.ModelManager;
import Week7.RentACar.business.Services.IModelService;
import Week7.RentACar.entity.Brand;
import Week7.RentACar.entity.Model;
import Week7.RentACar.entity.User;
import Week7.RentACar.view.Admin.AdminBrandView.AdminEditBrandView;
import Week7.RentACar.view.AdminLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminModelHomeView extends AdminLayout {
    private JPanel container;
    private JScrollPane scrl_model;
    private JTable tbl_modelList;
    private JButton createButton;
    private User user;
    private  JPopupMenu brandMenu;
    private IModelService modelService;
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private  JPopupMenu modelMenu;


    public AdminModelHomeView(User user){

        this.add(container);
        this.user = user;
        this.modelService = new ModelManager();
        this.brandMenu = new JPopupMenu();
        guiIntilaze();
        this.tbl_modelList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_modelList.rowAtPoint(e.getPoint());
                tbl_modelList.setRowSelectionInterval(selectedRow, selectedRow);
                if (SwingUtilities.isRightMouseButton(e)) {
                    brandMenu.show(tbl_modelList, e.getX(), e.getY());
                }
            }
        });
        CreateTable();
        UpdateModel();

    }

    public void CreateTable(){
        Object[] columnNames = {"Model ID", "Marka", "Model Adı", "Tip", "Yıl", "Yakıt Türü", "Vites"};
        ArrayList<Object[]> userList = modelService.getForTable(columnNames.length,this.modelService.getAll());
        createTable(defaultTableModel,tbl_modelList,columnNames,userList);
    }
    public void UpdateModel(){

        this.brandMenu.add("Update").addActionListener(e -> {
            int selectedRow = tbl_modelList.getSelectedRow();
            if (selectedRow != -1) {
                int selectedId = Integer.parseInt(tbl_modelList.getValueAt(selectedRow, 0).toString());
                Model selectedModel = this.modelService.getById(selectedId);
                AdminEditModelView editView = new AdminEditModelView(selectedModel, this);
                editView.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        CreateTable();
                    }
                });
            }
        });


    }
}
