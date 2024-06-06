package Week7.RentACar.dao.Abstract;

import Week7.RentACar.entity.User;

public interface IUserDal {

    User signIn(String username , String password);

}
