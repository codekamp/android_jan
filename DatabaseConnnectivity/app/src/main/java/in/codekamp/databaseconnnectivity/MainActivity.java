package in.codekamp.databaseconnnectivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText todoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoEditText = (EditText)findViewById(R.id.todo_edit_text);
    }

    public void addTodo(View view) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("title", todoEditText.getText().toString());

        db.insert("todo", null, values);
    }

    public void fetchTodos(View view) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("todo", null, null,null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            int completed = cursor.getInt(cursor.getColumnIndex("completed"));
            String title = cursor.getString(cursor.getColumnIndex("title"));

            Log.d("codekamp", "id: " + id + ", title: " + title + ", completed: " +  completed);
        }

    }


}
