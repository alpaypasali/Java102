package Week7.RentACar.dao.Abstract;

import Week7.RentACar.entity.User;

import java.util.ArrayList;

public interface IUserDal {

    User signIn(String email , String password);
    boolean create(User user);
    User getById(int id);
    ArrayList<User> getAll();

}
