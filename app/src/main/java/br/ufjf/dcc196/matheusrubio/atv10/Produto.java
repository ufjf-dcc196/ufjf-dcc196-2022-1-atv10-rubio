package br.ufjf.dcc196.matheusrubio.atv10;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produto")
public class Produto {

    public Produto(String nome, Integer quantidade, Double preço){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preço = preço;
    }
    @PrimaryKey(autoGenerate = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "quantidade")
    private Integer quantidade;

    @ColumnInfo(name = "preço")
    private Double preço;
}
