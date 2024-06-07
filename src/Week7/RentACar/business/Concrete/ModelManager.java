package Week7.RentACar.business.Concrete;

import Week7.RentACar.business.Exceptions.BusinessException;
import Week7.RentACar.business.Exceptions.DatabaseException;
import Week7.RentACar.business.Handlers.ErrorHandler;
import Week7.RentACar.business.Handlers.SuccessInformationMessage;
import Week7.RentACar.business.Services.IModelService;
import Week7.RentACar.dao.Abstract.IModelDal;
import Week7.RentACar.dao.Concrete.ModelDal;
import Week7.RentACar.entity.Model;

import java.util.ArrayList;

public class ModelManager implements IModelService {
   private final IModelDal modelDal;

    public ModelManager() {
        this.modelDal = new ModelDal();
    }

    @Override
    public SuccessInformationMessage create(Model model) {
        try {

            ModelCannotBeEmpty(model);
            boolean createdModel = modelDal.update(model);
            if(createdModel == false){

                throw new DatabaseException("Something Wrong database");
            }

            SuccessInformationMessage successMessage = new SuccessInformationMessage("Created Model successfully.");

            return successMessage;

        } catch (Exception e) {
            ErrorHandler.handleException(e);
            return null;

        }
    }

    @Override
    public SuccessInformationMessage update(Model model) {
        try {

            ModelCannotBeEmpty(model);
            boolean updatedModel = modelDal.create(model);
            if(updatedModel == false){

                throw new DatabaseException("Something Wrong database");
            }

            SuccessInformationMessage successMessage = new SuccessInformationMessage("Updated Model successfully.");

            return successMessage;

        } catch (Exception e) {
            ErrorHandler.handleException(e);
            return null;

        }
    }

    @Override
    public SuccessInformationMessage delete(int id) {
        try {

            ModelCannotBeEmpty(id);
            boolean deletedModel = modelDal.delete(id);
            if(deletedModel == false){

                throw new DatabaseException("Something Wrong database");
            }

            SuccessInformationMessage successMessage = new SuccessInformationMessage("Deleted Model successfully.");

            return successMessage;

        } catch (Exception e) {
            ErrorHandler.handleException(e);
            return null;

        }
    }

    @Override
    public Model getById(int id) {
        try{
            Model model = modelDal.getByid(id);
            this.ModelCannotBeEmpty(model);
            return  model;

        }catch (Exception e){
            ErrorHandler.handleException(e);
            return null;

        }
    }

    @Override
    public ArrayList<Model> getAll() {
        ArrayList<Model> models = modelDal.getAll();
        if(models.isEmpty())
            return  null;

        return models;
    }

    private  void ModelCannotBeEmpty(Model model) throws BusinessException {

        if (model == null) {
            throw new BusinessException("Username cannot be null or empty");
        }


    }
    private  void ModelCannotBeEmpty(int id) throws BusinessException {
        Model model = modelDal.getByid(id);
        if (model == null) {
            throw new BusinessException("Username cannot be null or empty");
        }


    }
}
