package glumlabs.glummy.Login;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginBusiness {

    public ArrayList<String> createConnection(String username, String password) throws ClassNotFoundException, SQLException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build(); //política de conección

        StrictMode.setThreadPolicy(policy);

        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        //String connectionUrl = "jdbc:jtds:sqlserver://192.168.100.126:1433;databaseName=Glummy;user=UAT;password=Proyecto-UAT;";
        String connectionUrl = "jdbc:jtds:sqlserver://192.168.43.233:1433;databaseName=Glummy;user=DBA;password=Proyecto-DBA;";

        Connection connection = DriverManager.getConnection(connectionUrl);

        Statement statement = connection.createStatement();
        //ejecuta la consulta y obtiene resultado
        String query = "SELECT c.name, r.name AS 'Rol Name', r.description FROM Clients c Inner Join Roles r On r.id = id_role WHERE( c.name = '" + username + "' AND password = '" + password + "');";

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<String> user = new ArrayList<>();
        //pregunta si la consulta trajo resultados
        if (resultSet.next()) {
            user.add(resultSet.getString("name"));
            user.add(resultSet.getString("Rol Name"));
            user.add(resultSet.getString("description"));
            return user;
        }

        return null;
    }


}
