package br.ufjf.dcc196.matheusrubio.atv10;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "produto-db";
    private static AppDatabase INSTANCE;

    public abstract ProdutoDao produtoDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DB_NAME
            ).build();
        }
        return INSTANCE;
    }
}
