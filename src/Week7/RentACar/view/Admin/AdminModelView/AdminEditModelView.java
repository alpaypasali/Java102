package Week7.RentACar.view.Admin.AdminModelView;


import Week7.RentACar.business.Concrete.BrandManager;
import Week7.RentACar.business.Concrete.ModelManager;
import Week7.RentACar.business.Helpers.ComboItem;
import Week7.RentACar.business.Helpers.FrameHelper;
import Week7.RentACar.business.Services.IBrandService;
import Week7.RentACar.business.Services.IModelService;
import Week7.RentACar.entity.Brand;
import Week7.RentACar.entity.Model;
import Week7.RentACar.entity.enums.Fuel;
import Week7.RentACar.entity.enums.Gear;
import Week7.RentACar.entity.enums.Type;

import javax.swing.*;

public class AdminEditModelView extends JFrame {


    private JPanel container;
    private JComboBox cmb_brand;
    private JTextField txt_name;
    private JTextField txt_year;
    private JComboBox<Week7.RentACar.entity.enums.Type> cmb_type;
    private JComboBox<Fuel> cmb_fuel;
    private JComboBox<Gear> cmb_gear;
    private  Model model;
    private IModelService modelService;
    private IBrandService brandService;

    public AdminEditModelView(Model model, AdminModelHomeView adminModelHomeView) {
        this.add(container);
        this.model = new Model();
        this.modelService = new ModelManager();
        FrameHelper.setupFrame(this, 300, 500, "Rent A Car");
        brandService= new BrandManager();

        for (Brand brand : this.brandService.getAll())
        {
            this.cmb_brand.addItem(new ComboItem(brand.getId(),brand.getName()));
        }
        this.cmb_fuel.setModel(new DefaultComboBoxModel<>(Fuel.values()));
        this.cmb_type.setModel(new DefaultComboBoxModel<>(Week7.RentACar.entity.enums.Type.values()));
        this.cmb_gear.setModel(new DefaultComboBoxModel<>(Gear.values()));


        this.txt_year.setText(String.valueOf(this.model.getYear()));
        this.txt_name.setText(this.model.getName());
        this.cmb_fuel.getModel().setSelectedItem(this.model.getFuel());
        this.cmb_type.getModel().setSelectedItem(this.model.getType());
        this.cmb_gear.getModel().setSelectedItem(this.model.getGear());
        ComboItem defaultBrand = new ComboItem(this.model.getBrand().getId(),this.model.getBrand().getName());
        this.cmb_brand.getModel().setSelectedItem(defaultBrand);
}
}
