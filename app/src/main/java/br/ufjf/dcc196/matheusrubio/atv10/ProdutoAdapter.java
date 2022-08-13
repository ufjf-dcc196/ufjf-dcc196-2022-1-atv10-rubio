package br.ufjf.dcc196.matheusrubio.atv10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        ProdutoViewHolder holder = new ProdutoViewHolder(avistamentoView);
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

    public interface OnProdutoClickListener {
        void onProdutoClick(View source, int position);
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNome;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
        }
    }
}
