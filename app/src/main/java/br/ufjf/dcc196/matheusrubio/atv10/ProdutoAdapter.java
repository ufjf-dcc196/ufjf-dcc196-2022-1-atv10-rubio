package br.ufjf.dcc196.matheusrubio.atv10;

import android.content.Context;
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
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View avistamentoView = inflater.inflate(R.layout.produto_layout, parent, false);
        ProdutoViewHolder holder = new ProdutoViewHolder(avistamentoView, new ClickListener() {
            @Override
            public void onClickButtonEditar(int position) {
                Log.v("TESTE EDITAR", produtos.get(position).getNome());
            }

            @Override
            public void onClickButtonExcluir(int position) {
                Log.v("TESTE EXCLUIR", produtos.get(position).getNome());
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
