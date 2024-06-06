package Week7.RentACar.business.Concrete;

import Week7.RentACar.business.Exceptions.ValidationException;
import Week7.RentACar.business.Handlers.ErrorHandler;
import Week7.RentACar.business.Services.IUserService;
import Week7.RentACar.dao.Abstract.IUserDal;
import Week7.RentACar.dao.Concrete.UserDal;
import Week7.RentACar.entity.User;

public class UserManager implements IUserService {
    private  final IUserDal userDal;

    public UserManager() {
        this.userDal = new UserDal();
    }

    @Override
    public User signIn(String username, String password) {
        validateCredentials(username,password);
       return userDal.signIn(username,password);

    }

    private void validateCredentials(String username, String password) {
      try{  if (username == null || username.trim().isEmpty()) {
                throw new ValidationException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new ValidationException("password cannot be null or empty");
        }}
        catch(ValidationException e){
            ErrorHandler.handleException(e);
        }

    }
}
