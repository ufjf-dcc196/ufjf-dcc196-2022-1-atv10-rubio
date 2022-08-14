package br.ufjf.dcc196.matheusrubio.atv10.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import br.ufjf.dcc196.matheusrubio.atv10.Model.AppDatabase;
import br.ufjf.dcc196.matheusrubio.atv10.Model.Produto;
import br.ufjf.dcc196.matheusrubio.atv10.Adapter.ProdutoAdapter;
import br.ufjf.dcc196.matheusrubio.atv10.R;

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

    @Override
    protected void onResume() {
        super.onResume();
        List<Produto> produtos = db.produtoDao().findAll();
        avistamentoAdapter = new ProdutoAdapter(produtos);
        recyclerProdutos.setAdapter(avistamentoAdapter);
    }

    public void voltar(View view) { finish(); }
}