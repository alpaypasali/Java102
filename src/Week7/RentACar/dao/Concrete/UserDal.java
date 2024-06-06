package Week7.RentACar.dao.Concrete;

import Week7.RentACar.core.Db;
import Week7.RentACar.dao.Abstract.IUserDal;
import Week7.RentACar.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDal implements IUserDal {
    private  final Connection conn;

    public UserDal() {
        this.conn = Db.getInstance();
    }
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM public.user";
        try (PreparedStatement pr = conn.prepareStatement(query);
             ResultSet rs = pr.executeQuery()) {
            while (rs.next()) {
                users.add(extractUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User signIn(String username, String password) {
       User user = null;
       String query = "Select * from public.user where username = ? And password = ?";

       try{
           PreparedStatement pr = this.conn.prepareStatement(query);
           pr.setString(1,username);
           pr.setString(2,password);
           ResultSet rs = pr.executeQuery();
           if(rs.next()){
              user = this.extractUser(rs);

           }
       }
       catch (SQLException e){

           e.printStackTrace();
       }
       return  user;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
