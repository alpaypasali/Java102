package Week7.RentACar.business.Services;

import Week7.RentACar.entity.User;

public interface IUserService {
    User signIn(String username, String password);
}
