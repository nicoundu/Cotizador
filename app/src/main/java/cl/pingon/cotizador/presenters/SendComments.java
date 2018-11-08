package cl.pingon.cotizador.presenters;

import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.MachinesDetails;

public class SendComments {

    private MachinesDetails machinesDetails = new MachinesDetails();

    public void fromUser(String key, String comment) {
        if (comment.trim().length() > 0) {
            machinesDetails.setComments(comment);

        }

        new Nodes().machines(key).child("comments").setValue(key, comment);


    }

}

