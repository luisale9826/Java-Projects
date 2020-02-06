package glumlabs.glummy.Manager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import glumlabs.glummy.R;

public class Manager extends AppCompatActivity {

    private String username;
    private String rolDescription;
    private HomeManagerFragment home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        BottomNavigationView btnNav = findViewById(R.id.ManagerNavBar);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        Bundle bundle = this.getIntent().getExtras();
        username = bundle.getString("username");
        rolDescription = bundle.getString("rol_description");

        bundle = new Bundle();
        bundle.putString("name", username);
        bundle.putString("rol_description", rolDescription);
        home = new HomeManagerFragment();
        home.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, home).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.home:
                    selectedFragment = home;
                    break;
                case R.id.process:
                    selectedFragment = new ProcessManagerFragment();
                    break;
                case R.id.network:
                    selectedFragment = new NetworkManagerFragment();
                    break;
                case R.id.files:
                    selectedFragment = new FilesManagerFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };


    public void onBackPressed(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("¿Está seguro que quiere cerrar sesión?")
                .setCancelable(false)
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Manager.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
