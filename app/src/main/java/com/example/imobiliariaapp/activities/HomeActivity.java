package com.example.imobiliariaapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.imobiliariaapp.Adapter.ItemsAdapter;
import com.example.imobiliariaapp.Domain.ItemsDomain;
import com.example.imobiliariaapp.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular, adapterNew;
    private RecyclerView recyclerViewPopular, recyclerViewNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<ItemsDomain> itemsArrayList = new ArrayList<>();
        itemsArrayList.add(new ItemsDomain(
                "Casa com uma linda vista para o mar",
                "Ubatuba, Praia da enseada",
                "Uma elegante casa de frente para o mar azul da praia da enseada. Muito conforto para você que busca um local de lazer e tranquilidade.",
                2, 1, 8400000, "cottage", false));

        itemsArrayList.add(new ItemsDomain(
                "Casa com uma linda vista para o mar",
                "Ubatuba, Praia da enseada",
                "Uma elegante casa de frente para o mar azul da praia da enseada. Muito conforto para você que busca um local de lazer e tranquilidade.",
                2, 1, 8400000, "flat", true));

        itemsArrayList.add(new ItemsDomain(
                "Casa com uma linda vista para o mar",
                "Ubatuba, Praia da enseada",
                "Uma elegante casa de frente para o mar azul da praia da enseada. Muito conforto para você que busca um local de lazer e tranquilidade.",
                2, 1, 8400000, "house", true));

        itemsArrayList.add(new ItemsDomain(
                "Casa com uma linda vista para o mar",
                "Ubatuba, Praia da enseada",
                "Uma elegante casa de frente para o mar azul da praia da enseada. Muito conforto para você que busca um local de lazer e tranquilidade.",
                2, 1, 8400000, "office", true));

        recyclerViewPopular = findViewById(R.id.homeReciclerViewPopular);
        recyclerViewNew = findViewById(R.id.homeReciclerViewNews);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPopular = new ItemsAdapter(itemsArrayList);
        adapterNew = new ItemsAdapter(itemsArrayList);

        recyclerViewNew.setAdapter(adapterNew);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}