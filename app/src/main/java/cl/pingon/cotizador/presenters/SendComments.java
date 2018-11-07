package cl.pingon.cotizador.presenters;

import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.Machines;
import cl.pingon.cotizador.model.MachinesDetails;
import cl.pingon.cotizador.views.main.inputdata.InputDataCallback;

public class SendComments {

    private InputDataCallback callback;
    private MachinesDetails machinesDetails = new MachinesDetails();

    public void fromUser(String key, String comment) {
        if (comment.trim().length() > 0){
            machinesDetails.setComments(comment);

        }else {
            callback.error("Debe ingresar un comentario");
            return;

        }

        new Nodes().machines(key).child("comments").setValue(key, comment);
    }
}
