package Week7.RentACar.business.Concrete;

import Week7.RentACar.business.Exceptions.BusinessException;
import Week7.RentACar.business.Exceptions.DatabaseException;
import Week7.RentACar.business.Exceptions.ValidationException;
import Week7.RentACar.business.Handlers.ErrorHandler;
import Week7.RentACar.business.Handlers.SuccessMessage;
import Week7.RentACar.business.Handlers.SuccessInformationMessage;
import Week7.RentACar.business.Services.IUserService;
import Week7.RentACar.dao.Abstract.IUserDal;
import Week7.RentACar.dao.Concrete.UserDal;
import Week7.RentACar.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager implements IUserService {
    private  final IUserDal userDal;

    public UserManager() {
        this.userDal = new UserDal();
    }

        @Override
        public ArrayList<Object[]> getForTable(int size) {
            ArrayList<Object[]> arrayList = new ArrayList<>();
            for (User u : this.getAll()) {
                Object[] rowObject = new Object[size];
                int i = 0;
                rowObject[i++] = u.getId();
                rowObject[i++] = u.getName();
                rowObject[i++] = u.getEmail();
                rowObject[i++] = u.getPhone();
                rowObject[i++] = u.getRole();
                arrayList.add(rowObject);
            }
            return arrayList;
        }



    @Override
    public SuccessMessage<User> signIn(String email, String password) {
        try {
            validateCredentials(email, password);
            User user = userDal.signIn(email, password);
            UserCannotBeEmpty(user);
            SuccessMessage<User> successMessage = new SuccessMessage<>(user, "Login successful.");

            return successMessage;
        } catch (Exception e) {
            ErrorHandler.handleException(e);
            return null;
        }

    }

    @Override
    public SuccessInformationMessage create(User user) {
        try {

            UserCannotBeEmpty(user);
            boolean createdUser = userDal.create(user);
            if(createdUser == false){

                throw new DatabaseException("Something Wrong database");
            }

            SuccessInformationMessage successMessage = new SuccessInformationMessage("Register successful.");

            return successMessage;

        } catch (Exception e) {
            ErrorHandler.handleException(e);
            return null;

        }
    }

    @Override
    public User getById(int id) {
        try{
            User user = userDal.getById(id);
            this.UserCannotBeEmpty(user);
            return  user;

        }catch (Exception e){
            ErrorHandler.handleException(e);
            return null;

        }
    }

    @Override
    public ArrayList<User> getAll() {
       ArrayList<User> users = userDal.getAll();
       if(users.isEmpty())
           return  null;

       return users;
    }

    private void validateCredentials(String email, String password) throws ValidationException {
       if (email == null || email.trim().isEmpty()) {
                throw new ValidationException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new ValidationException("password cannot be null or empty");
        }


    }

    private  void UserCannotBeEmpty(User user) throws BusinessException {

            if (user == null) {
                throw new BusinessException("Username cannot be null or empty");
            }


    }
}
