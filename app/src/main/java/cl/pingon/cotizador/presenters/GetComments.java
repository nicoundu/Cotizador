package cl.pingon.cotizador.presenters;

import cl.pingon.cotizador.data.Nodes;

public class GetComments {

    public void userComments(String key, String comments) {

        if (comments.replace(" "," ").length() !=0)return;

        new Nodes().comments(key).setValue(comments);


    }


}
