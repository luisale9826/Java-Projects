package glumlabs.glummy.Technician;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import glumlabs.glummy.Login.LoginActivity;
import glumlabs.glummy.R;

public class Technician extends Activity {

    private Button logOutBt;
    private TextView technicianName;
    private TextView technicianRol;

    @Override
    @Nullable
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician);

        logOutBt = findViewById(R.id.buttonLogOut);
        technicianName = findViewById(R.id.technician_name);
        technicianRol = findViewById(R.id.technician_rol_description);

        Bundle bundle = this.getIntent().getExtras();
        String username = bundle.getString("username");
        String rolDescription = bundle.getString("rol_description");

        technicianName.setText(username);
        technicianRol.setText(rolDescription);

        logOutBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Technician.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
