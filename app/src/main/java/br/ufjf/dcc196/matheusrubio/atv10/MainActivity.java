package br.ufjf.dcc196.matheusrubio.atv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;
    private Integer qtdProdutosCadastrados;
    private TextView textViewProdutosCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getInstance(getApplicationContext());
        textViewProdutosCadastrados = findViewById(R.id.textViewProdutosCadastrados);
        qtdProdutosCadastrados = db.produtoDao().findAll().size();
        textViewProdutosCadastrados.setText(qtdProdutosCadastrados.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        textViewProdutosCadastrados = findViewById(R.id.textViewProdutosCadastrados);
        qtdProdutosCadastrados = db.produtoDao().findAll().size();
        textViewProdutosCadastrados.setText(qtdProdutosCadastrados.toString());
    }

    public void toListarProdutosActivity (View view) {
        if (qtdProdutosCadastrados > 0) {
            Intent novoAvistamentoActivity = new Intent(this, ListarProdutosActivity.class);
            startActivity(novoAvistamentoActivity);
            return;
        }
        Toast toast = Toast.makeText(this, "Não existem produtos cadastrados no sistema...", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void toCadastrarProdutoActivity (View view) {
        Intent novoAvistamentoActivity = new Intent(this, CadastrarProdutoActivity.class);
        startActivity(novoAvistamentoActivity);
    }
}