package Week7.RentACar.view.Admin.AdminBrandView;

import Week7.RentACar.business.Concrete.BrandManager;
import Week7.RentACar.business.Handlers.SuccessInformationMessage;
import Week7.RentACar.business.Helpers.FrameHelper;
import Week7.RentACar.business.Services.IBrandService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Week7.RentACar.entity.Brand;

public class AdminCreateBrandView extends JFrame {

    private JPanel container;
    private JTextField txt_brandName;
    private JButton Btn_save;
    private  AdminEditBrandView brandView;
    private IBrandService brandService;
    private Brand brand;

    public AdminCreateBrandView(ActionListener brandHomeView) {
        this.add(container);
        this.brandService = new BrandManager();
        this.brand = new Brand();
        FrameHelper.setupFrame(this, 300, 200, "Rent A Car");


        Btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brand.setName(txt_brandName.getText());
               SuccessInformationMessage createdBrand = brandService.create(brand);
               createdBrand.getMessage();
               dispose();
            }
        });
    }
}
