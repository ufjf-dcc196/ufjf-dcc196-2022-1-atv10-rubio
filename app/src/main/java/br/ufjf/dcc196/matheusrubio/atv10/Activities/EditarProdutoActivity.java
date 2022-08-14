package br.ufjf.dcc196.matheusrubio.atv10.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import br.ufjf.dcc196.matheusrubio.atv10.Model.AppDatabase;
import br.ufjf.dcc196.matheusrubio.atv10.Model.Produto;
import br.ufjf.dcc196.matheusrubio.atv10.R;

public class EditarProdutoActivity extends AppCompatActivity {
    private EditText editTextNomeProduto;
    private EditText editTextQuantidadeProduto;
    private EditText editTextPreçoProduto;
    private AppDatabase db;
    private Produto produtoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        Intent intent = getIntent();
        Long idProduto = intent.getLongExtra("ID_PRODUTO", 0);
        db = AppDatabase.getInstance(getApplicationContext());
        produtoSelecionado = db.produtoDao().findById(idProduto);
        editTextNomeProduto = findViewById(R.id.editTextNomeProduto);
        editTextQuantidadeProduto = findViewById(R.id.editTextQuantidadeProduto);
        editTextPreçoProduto = findViewById(R.id.editTextPreçoProduto);

        editTextNomeProduto.setText(produtoSelecionado.getNome());
        editTextQuantidadeProduto.setText(produtoSelecionado.getQuantidade().toString());
        editTextPreçoProduto.setText(produtoSelecionado.getPreço().toString());

    }

    public void editarProduto(View view) {
        try {
            String nomeProduto = editTextNomeProduto.getText().toString();
            Integer quantidadeProduto = Integer.parseInt(editTextQuantidadeProduto.getText().toString());
            Double preçoProduto = Double.parseDouble(editTextPreçoProduto.getText().toString());
            produtoSelecionado.setNome(nomeProduto);
            produtoSelecionado.setQuantidade(quantidadeProduto);
            produtoSelecionado.setPreço(preçoProduto);
            db.produtoDao().update(produtoSelecionado);
            finish();
        } catch (Exception e) {
            Log.v("ERRO", e.getMessage());
        }
    }

    public void voltar(View view) {
        finish();
    }
}