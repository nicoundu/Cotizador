package cl.pingon.cotizador.presenters;

import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.MachinesDetails;
import cl.pingon.cotizador.views.main.inputdata.InputCommentsFragment;

public class SendComments {


    public void fromUser(String key, String comment) {


        new Nodes().machines(key).child("comments").setValue(key, comment);


    }
}

