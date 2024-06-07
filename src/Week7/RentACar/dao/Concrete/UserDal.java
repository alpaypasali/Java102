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
    public User signIn(String email, String password) {
       User user = null;
       String query = "Select * from public.user where email = ? And password = ?";

       try{
           PreparedStatement pr = this.conn.prepareStatement(query);
           pr.setString(1,email);
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
    public boolean create(User user) {
        String query = "INSERT INTO public.user ( email, password, role, name , phone) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, user.getEmail());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getRole());
            pr.setString(4, user.getName());
            pr.setString(5, user.getPhone());

            return pr.executeUpdate() != -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        user.setName(rs.getString("name"));
        user.setPhone(rs.getString("phone"));
        return user;
    }
}
