package cl.pingon.cotizador.views.main.inputdata;

import com.google.firebase.database.DatabaseReference;

import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Categories;

public class DataValidation {

    private InputDataCallback callback;
    private Categories categories = new Categories();

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
            //categories.setClient(client);
        } else {
            callback.error("Debe ingresar un cliente");
            return;
        }
    }

    public void inputProject(String project) {
        if (project.trim().length() > 0) {
            categories.setName(project);

        } else {
            callback.error("Debe ingresar una obra");
            return;
        }
    }

    public void inputDate(String date) {
        if (date.trim().length() > 0) {
            //categories.setDate(date);
            createVisit(categories);
        }else {
            callback.error("Debe ingresar una fecha");
            return;
        }
    }

    private void createVisit(Categories categories) {
        DatabaseReference ref = new Nodes().categories();
        String key = ref.push().getKey();
        categories.setKey(key);
        new Nodes().categories().child(key).setValue(categories);
        callback.succes();
    }

}
