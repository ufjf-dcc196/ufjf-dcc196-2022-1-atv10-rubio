package br.ufjf.dcc196.matheusrubio.atv10;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {
    private List<Produto> produtos;
    public ProdutoAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();
        Activity activity = (Activity) contexto;
        LayoutInflater inflater = LayoutInflater.from(contexto);
        AppDatabase db = AppDatabase.getInstance(contexto);
        View avistamentoView = inflater.inflate(R.layout.produto_layout, parent, false);
        ProdutoViewHolder holder = new ProdutoViewHolder(avistamentoView, new ClickListener() {
            @Override
            public void onClickButtonEditar(int position) {
                Produto produtoSelecionado = produtos.get(position);
                Intent editarProdutoActivity = new Intent(contexto, EditarProdutoActivity.class);
                editarProdutoActivity.putExtra("ID_PRODUTO", produtoSelecionado.getId());
                contexto.startActivity(editarProdutoActivity);
            }

            @Override
            public void onClickButtonExcluir(int position) {
                Produto produtoSelecionado = produtos.get(position);
                AlertDialog alertDialog = new AlertDialog.Builder(contexto).create();
                alertDialog.setTitle("Você realmente deseja exluir o produto: " + produtoSelecionado.getNome() + "?");
                alertDialog.setMessage("Essa ação será permanente!");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sim",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                db.produtoDao().delete(produtoSelecionado);
                                activity.recreate();
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Não",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }

            @Override
            public void onClickButtonVisualizar(int position) {
                Log.v("TESTE VISUALIZAR", produtos.get(position).getNome());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        holder.textViewNome.setText(produto.getNome());
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public interface ClickListener {
        void onClickButtonEditar(int position);
        void onClickButtonExcluir(int position);
        void onClickButtonVisualizar(int position);
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ClickListener listener;
        private TextView textViewNome;
        private ImageButton buttonEditarProduto;
        private ImageButton buttonExcluirProduto;
        private ImageButton buttonVisualizarProduto;

        public ProdutoViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            buttonEditarProduto = itemView.findViewById(R.id.buttonEditarProduto);
            buttonExcluirProduto = itemView.findViewById(R.id.buttonExcluirProduto);
            buttonVisualizarProduto = itemView.findViewById(R.id.buttonVisualizarProduto);

            listener = clickListener;

            buttonEditarProduto.setOnClickListener(this);
            buttonExcluirProduto.setOnClickListener(this);
            buttonVisualizarProduto.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttonEditarProduto:
                    listener.onClickButtonEditar(this.getLayoutPosition());
                    break;
                case R.id.buttonExcluirProduto:
                    listener.onClickButtonExcluir(this.getLayoutPosition());
                    break;
                case R.id.buttonVisualizarProduto:
                    listener.onClickButtonVisualizar(this.getLayoutPosition());
                    break;
            }
        }
    }
}
