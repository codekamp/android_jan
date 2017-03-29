package in.codekamp.databaseconnnectivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cerebro on 07/03/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "codekamp", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("codekamp", "onCreate of DatabaseHelper called");
        db.execSQL( "CREATE TABLE todo ( `_id` int AUTO_INCREMENT, `title` VARCHAR(255), `completed` int(1) DEFAULT 0);" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
