package glumlabs.glummy.Manager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import glumlabs.glummy.R;

public class ProcessManagerFragment extends Fragment {

    ListView processList;
    TextView name;
    TextView description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View processView = inflater.inflate(R.layout.fragment_manager_process, container, false);
        processList = (ListView) processView.findViewById(R.id.process_listView);

        ArrayList<String> process = new ArrayList<>();
        process.add("Proceso FireFox");
        process.add("Proceso TextEditor");
        process.add("Proceso Netbeans");
        process.add("Proceso Event Viewer");
        process.add("Proceso Visor Archivos");
        process.add("Proceso Gnome");

        ArrayAdapter adapter = new ArrayAdapter(processView.getContext(), android.R.layout.simple_list_item_1, process);
        processList.setAdapter(adapter);

        processList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Selecciona " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }
        });

        return processView;
    }


}
