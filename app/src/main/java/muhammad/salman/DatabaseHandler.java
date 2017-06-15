package muhammad.salman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.version;

/**
 * Created by Qoharu on 3/7/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DBNAME = "dataNim";
    private String table;


    public DatabaseHandler(Context context, String table) {
        super(context, DBNAME, null, DATABASE_VERSION);
        this.table = table;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + this.table + "(id INTEGER PRIMARY KEY,nim TEXT, nama TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + this.table);
    }

    void addNim(Nim nim) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nama", nim.getNama());
        values.put("nim", nim.getNim());

        // Inserting Row
        db.insert(this.table, null, values);
        db.close(); // Closing database connection
    }

    public List<Nim> getAllNim() {
        List<Nim> nimList = new ArrayList<Nim>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + this.table;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Nim nim = new Nim(cursor.getInt(0),cursor.getInt(1), cursor.getString(2) );
                nimList.add(nim);
            } while (cursor.moveToNext());
        }

        return nimList;
    }
}
