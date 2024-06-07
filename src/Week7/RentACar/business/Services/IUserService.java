package Week7.RentACar.business.Services;

import Week7.RentACar.business.Handlers.SuccessMessage;
import Week7.RentACar.business.Handlers.SuccessİnformationMessage;
import Week7.RentACar.entity.User;

public interface IUserService {
    SuccessMessage<User> signIn(String email, String password);
    SuccessİnformationMessage create(User user);
}
