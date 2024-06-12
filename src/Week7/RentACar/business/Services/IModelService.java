package Week7.RentACar.business.Services;

import Week7.RentACar.business.Handlers.SuccessInformationMessage;
import Week7.RentACar.entity.Model;

import java.util.ArrayList;

public interface IModelService {
    SuccessInformationMessage create(Model model);
    SuccessInformationMessage update(Model model);
    SuccessInformationMessage delete(int id);
    Model getById(int id);
    ArrayList<Model> getAll();
    ArrayList<Object[]> getForTable(int size, ArrayList<Model> modelList);

}
