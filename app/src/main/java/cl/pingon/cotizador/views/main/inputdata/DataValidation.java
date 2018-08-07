package cl.pingon.cotizador.views.main.inputdata;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import cl.pingon.cotizador.data.CurrentUser;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Visits;

public class DataValidation {

    private InputDataCallback callback;
    private Visits visits = new Visits();

    public DataValidation(InputDataCallback callback) {
        this.callback = callback;
    }

    public void startValidation(String client, String project, String date) {
        inputClient(client);
        inputProject(project);
        inputDate(date);
    }

    public void inputClient(String client) {
        if (client.trim().length() > 0) {
            visits.setClient(client);
        } else {
            callback.error("Debe ingresar un cliente");
            return;
        }
    }

    public void inputProject(String project) {
        if (project.trim().length() > 0) {
            visits.setProject(project);

        } else {
            callback.error("Debe ingresar una obra");
            return;
        }
    }

    public void inputDate(String date) {
        if (date.trim().length() > 0) {
            visits.setDate(date);
            createVisit(visits);
        }else {
            callback.error("Debe ingresar una fecha");
            return;
        }
    }

    private void createVisit(Visits visits) {
        DatabaseReference ref = new Nodes().visits();
        String key = ref.push().getKey();
        visits.setKey(key);
        new Nodes().visits().child(key).setValue(visits);
        callback.succes();
    }

}
