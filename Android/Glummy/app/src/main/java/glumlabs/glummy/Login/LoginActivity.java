package glumlabs.glummy.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

import glumlabs.glummy.Manager.Manager;
import glumlabs.glummy.R;
import glumlabs.glummy.SysAdmin;
import glumlabs.glummy.Technician.Technician;

public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText USERNAME, PASSWORD;
        final Button ACCEPT;

        //obtener el texto ingresado en el txtUserName
        USERNAME = findViewById(R.id.username);

        //obtener el texto ingresado en el txtPassword
        PASSWORD = findViewById(R.id.password);

        ACCEPT = findViewById(R.id.sign_in_button);

        //le da funcionalidad al botón Accept
        ACCEPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameString = USERNAME.getText().toString();
                String passwordString = PASSWORD.getText().toString();

                ArrayList<String> rol = null;

                LoginBusiness loginBusiness = new LoginBusiness();
                try {
                    rol = loginBusiness.createConnection(usernameString, passwordString);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                Intent intent;

                if (rol.get(1).equalsIgnoreCase("sysadmin")) {
                    intent = new Intent(LoginActivity.this, SysAdmin.class);
                    startActivity(intent);
                } else if (rol.get(1).equalsIgnoreCase("technician")) {

                    intent = new Intent(LoginActivity.this, Technician.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", rol.get(0));
                    bundle.putString("rol_description", rol.get(2));

                    intent.putExtras(bundle);
                    startActivity(intent);

                } else if (rol.get(1).equalsIgnoreCase("manager")) {

                    intent = new Intent(LoginActivity.this, Manager.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("username", rol.get(0));
                    bundle.putString("rol_description", rol.get(2));

                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "¡No posee permisos para iniciar sesión!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
