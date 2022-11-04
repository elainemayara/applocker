package DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Funcionarios;

import java.util.ArrayList;

public class FuncionariosBD extends SQLiteOpenHelper {

    private static final String DATABASE = "bdfuncionarios";
    private static final int VERSION =1;

    public FuncionariosBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public FuncionariosBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public FuncionariosBD(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }


    public FuncionariosBD(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String funcionario = "CREATE TABLE produtos(id INTEGER PRIMARY AUTOINCREMENT NOT NULL, nomefuncionario TEXT NOT NULL, CPF INTERGER);";
        db.execSQL(funcionario);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String funcionario = "DROP TABLE IF EXISTS funcionarios";
        db.execSQL(funcionario);
    }

    public void salvarFuncionario (Funcionarios funcionario){
        ContentValues values = new ContentValues();

        values.put("nomeFuncionario", funcionario.getNomefuncionario());
        values.put("CPF", funcionario.getCPF());

        getWritableDatabase().insert("funcionario", null, values);
    }

    public ArrayList<Funcionarios> getLista(){
        String columns = String.valueOf(new String[]{"id", "nomefuncionario", "CPF"});
        Cursor cursor = getWritableDatabase(). query("funcionarios", new String[]{columns}, null,null,null,null,null);
        ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();

        while (cursor.moveToNext()){
            Funcionarios funcionario = new Funcionarios();
            funcionario.setId(cursor.getLong(0));
            funcionario.setCPF(cursor.getInt(1));
            funcionario.setNomefuncionario(cursor.getString(2));

            Funcionarios.add(funcionario);

        }
        return funcionarios;
    }
}
