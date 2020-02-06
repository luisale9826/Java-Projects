package glumlabs.glummy.Manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import glumlabs.glummy.Login.LoginActivity;
import glumlabs.glummy.R;

public class HomeManagerFragment extends Fragment {

    Button logoutBtn;
    TextView name;
    TextView rolDescription;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View homeView = inflater.inflate(R.layout.fragment_manager_home, container, false);
        logoutBtn = homeView.findViewById(R.id.buttonLogOut);
        name = homeView.findViewById(R.id.manager_name);
        rolDescription = homeView.findViewById(R.id.rol_description);
        if (getArguments() != null) {
            String username = getArguments().getString("name");
            String rolData = getArguments().getString("rol_description");
            name.setText(username);
            rolDescription.setText(rolData);
        }

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return homeView;
    }
}
