package Week7.RentACar.view.Admin.AdminBrandView;

import Week7.RentACar.business.Concrete.BrandManager;
import Week7.RentACar.business.Handlers.SuccessInformationMessage;
import Week7.RentACar.business.Helpers.FrameHelper;
import Week7.RentACar.business.Services.IBrandService;
import Week7.RentACar.entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminEditBrandView extends  JFrame{


    private JPanel container;
    private JTextField txt_brandName;
    private JButton btn_save;
    private  Brand brand;
    private IBrandService brandService;

    public AdminEditBrandView(Brand brand, AdminBrandHomeView brandHomeView) {

        this.add(container);
        this.brand = new Brand();
        this.brandService = new BrandManager();
        FrameHelper.setupFrame(this, 300, 200, "Rent A Car");
        txt_brandName.setText(brand.getName());

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brand.setName(txt_brandName.getText());
               SuccessInformationMessage brandUpdated = brandService.update(brand);
                brandUpdated.showMessageDialog();
                dispose();
            }
        });
    }


}
