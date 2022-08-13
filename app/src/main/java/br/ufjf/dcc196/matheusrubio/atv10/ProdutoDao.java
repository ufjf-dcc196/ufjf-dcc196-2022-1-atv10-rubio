package br.ufjf.dcc196.matheusrubio.atv10;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProdutoDao {
    @Insert
    void insertProduto(Produto novoProduto);

    @Update
    void update(Produto produto);

    @Delete
    void delete(Produto produto);

    @Query("SELECT * from produto")
    List<Produto> findAll();

    @Query("SELECT * from produto where id=:id LIMIT 1")
    Produto findById(Long id);
}
