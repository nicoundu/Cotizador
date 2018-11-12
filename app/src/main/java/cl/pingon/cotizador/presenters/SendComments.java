package cl.pingon.cotizador.presenters;

import cl.pingon.cotizador.data.CurrentUser;
import cl.pingon.cotizador.data.Nodes;
import cl.pingon.cotizador.model.MachinesDetails;
import cl.pingon.cotizador.views.main.inputdata.InputCommentsFragment;

public class SendComments {

    public void fromUser(String key, String comments) {

        if (comments.replace(" "," ").length() ==0)return;

        new Nodes().comments(key).push().setValue(comments);

    }
}

