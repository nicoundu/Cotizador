package cl.pingon.cotizador.views.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cl.pingon.cotizador.R;
import cl.pingon.cotizador.model.Categories;
import cl.pingon.cotizador.views.main.machines.CategoriesFragment;

public class MachinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machines);

        Categories categories = (Categories) getIntent().getSerializableExtra(CategoriesFragment.CATEGORIES);
        getSupportActionBar().setTitle(categories.getName());
    }
}
