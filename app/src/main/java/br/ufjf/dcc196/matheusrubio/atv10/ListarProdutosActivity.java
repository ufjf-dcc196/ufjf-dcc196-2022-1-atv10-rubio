package br.ufjf.dcc196.matheusrubio.atv10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListarProdutosActivity extends AppCompatActivity {
    private RecyclerView recyclerProdutos;
    private ProdutoAdapter avistamentoAdapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);
        db = AppDatabase.getInstance(getApplicationContext());

        recyclerProdutos = findViewById(R.id.recyclerProdutos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerProdutos.setLayoutManager(layoutManager);

        List<Produto> produtos = db.produtoDao().findAll();
        avistamentoAdapter = new ProdutoAdapter(produtos);
        recyclerProdutos.setAdapter(avistamentoAdapter);
    }
}