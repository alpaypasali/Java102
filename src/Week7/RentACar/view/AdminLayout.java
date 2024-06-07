package Week7.RentACar.view;

import Week7.RentACar.business.Helpers.FrameHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminLayout extends JFrame {

        public void  guiIntilaze(){
            FrameHelper.setupFrame(this, 500, 250, "Rent A Car");
        }

    public void createTable(DefaultTableModel model, JTable jTable, Object[] columns, ArrayList<Object[]> rows) {
        model.setColumnIdentifiers(columns);
        jTable.setModel(model);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(75);
        jTable.setEnabled(false);


        model.setRowCount(0);

        if (rows == null) {
            rows = new ArrayList<>();
        }

        for (Object[] row : rows) {
            model.addRow(row);
        }

    }
}
