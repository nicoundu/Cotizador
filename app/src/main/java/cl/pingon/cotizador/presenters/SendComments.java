package cl.pingon.cotizador.presenters;

import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.MachinesDetails;

public class SendComments {


    public void fromUser(String key, String comment) {

        new Nodes().machines(key).child("comments").setValue(key, comment);


    }

}

