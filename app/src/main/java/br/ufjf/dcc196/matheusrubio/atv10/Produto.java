package br.ufjf.dcc196.matheusrubio.atv10;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produto")
public class Produto {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "quantidade")
    private Integer quantidade;

    @ColumnInfo(name = "preço")
    private Double preço;
}
