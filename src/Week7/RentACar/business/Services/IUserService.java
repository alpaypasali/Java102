package Week7.RentACar.business.Services;

import Week7.RentACar.business.Handlers.SuccessMessage;
import Week7.RentACar.business.Handlers.SuccessInformationMessage;
import Week7.RentACar.entity.User;

import java.util.ArrayList;

public interface IUserService {
    SuccessMessage<User> signIn(String email, String password);
    SuccessInformationMessage create(User user);
    User getById(int id);
    ArrayList<User> getAll();
    ArrayList<Object[]> getForTable(int size);

}
