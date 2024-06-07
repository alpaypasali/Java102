package Week7.RentACar.dao.Abstract;

import Week7.RentACar.entity.Model;

import java.util.ArrayList;

public interface IModelDal {
    ArrayList<Model> getAll();
    boolean create(Model model);
    boolean update(Model model);
    boolean delete(int id);
    Model getByid(int id);


}
