import com.codegym.dao.BaseRepository;
import com.codegym.model.User;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {

        String queryById = "{CALL insert_user(?,?,?)}";

        Connection conn = BaseRepository.getConnectDB();

        try {
            CallableStatement cs = conn.prepareCall(queryById);

            cs.setString(1, "Minh Chou");
            cs.setString(2, "minhchoucute@gmail.com");
            cs.setString(3, "Vietnam");


           cs.executeUpdate();


        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }

    }
}
