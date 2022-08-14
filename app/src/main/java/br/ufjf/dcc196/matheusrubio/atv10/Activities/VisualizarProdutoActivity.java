package br.ufjf.dcc196.matheusrubio.atv10.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.ufjf.dcc196.matheusrubio.atv10.Activities.EditarProdutoActivity;
import br.ufjf.dcc196.matheusrubio.atv10.Model.AppDatabase;
import br.ufjf.dcc196.matheusrubio.atv10.Model.Produto;
import br.ufjf.dcc196.matheusrubio.atv10.R;

public class VisualizarProdutoActivity extends AppCompatActivity {
    private TextView textViewNomeProduto;
    private TextView textViewQuantidadeProduto;
    private TextView textViewPreçoProduto;
    private AppDatabase db;
    private Produto produtoSelecionado;
    private Long idProdutoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_produto);
        db = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        idProdutoSelecionado = intent.getLongExtra("ID_PRODUTO", 0);
        produtoSelecionado = db.produtoDao().findById(idProdutoSelecionado);
        textViewNomeProduto = findViewById(R.id.textViewNomeProduto);
        textViewQuantidadeProduto = findViewById(R.id.textViewQuantidadeProduto);
        textViewPreçoProduto = findViewById(R.id.textViewPreçoProduto);

        textViewNomeProduto.setText(produtoSelecionado.getNome());
        textViewQuantidadeProduto.setText(produtoSelecionado.getQuantidade().toString());
        textViewPreçoProduto.setText(produtoSelecionado.getPreço().toString());


    }

    @Override
    protected void onResume() {
        super.onResume();
        produtoSelecionado = db.produtoDao().findById(idProdutoSelecionado);
        textViewNomeProduto.setText(produtoSelecionado.getNome());
        textViewQuantidadeProduto.setText(produtoSelecionado.getQuantidade().toString());
        textViewPreçoProduto.setText("R$" + produtoSelecionado.getPreço().toString());
    }

    public void toEditarProduto(View view) {
        Intent editarProdutoActivity = new Intent(this, EditarProdutoActivity.class);
        editarProdutoActivity.putExtra("ID_PRODUTO", produtoSelecionado.getId());
        startActivity(editarProdutoActivity);
    }

    public void voltar(View view) {
        finish();
    }
}