package br.ufjf.dcc196.matheusrubio.atv10.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import br.ufjf.dcc196.matheusrubio.atv10.Model.AppDatabase;
import br.ufjf.dcc196.matheusrubio.atv10.Model.Produto;
import br.ufjf.dcc196.matheusrubio.atv10.R;

public class CadastrarProdutoActivity extends AppCompatActivity {
    private EditText editTextNomeProduto;
    private EditText editTextQuantidadeProduto;
    private EditText editTextPreçoProduto;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);
        db = AppDatabase.getInstance(getApplicationContext());
        editTextNomeProduto = findViewById(R.id.editTextNomeProduto);
        editTextQuantidadeProduto = findViewById(R.id.editTextQuantidadeProduto);
        editTextPreçoProduto = findViewById(R.id.editTextPreçoProduto);
    }

    public void criarProduto(View view) {
        try {
            String nomeProduto = editTextNomeProduto.getText().toString();
            Integer quantidadeProduto = Integer.parseInt(editTextQuantidadeProduto.getText().toString());
            Double preçoProduto = Double.parseDouble(editTextPreçoProduto.getText().toString());
            Produto novoProduto = new Produto(nomeProduto, quantidadeProduto, preçoProduto);
            db.produtoDao().insertProduto(novoProduto);
            finish();
        } catch (Exception e) {
            Log.v("ERRO", e.getMessage());
        }
    }

    public void voltar(View view) {
        finish();
    }
}