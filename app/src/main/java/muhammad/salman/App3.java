package muhammad.salman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class App3 extends AppCompatActivity {

    DatabaseHandler db;
    String tabel;
    TableRow row;
    Intent back;
    Button btnback;
    TextView tbl_name;
    Intent baru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app3);

        baru = getIntent();
        tabel = baru.getStringExtra("tabel");

        tbl_name = (TextView) findViewById(R.id.txt_tablename);
        tbl_name.setText(tabel);
        Toast.makeText(this, tabel, Toast.LENGTH_SHORT).show();

        TableLayout ll = (TableLayout) findViewById(R.id.table_db);

        back = new Intent(App3.this, App2.class);

        btnback = (Button) findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.putExtra("tabel",tabel);
                startActivity(back);
            }
        });



        db = new DatabaseHandler(this, tabel);
        List<Nim> Nims = db.getAllNim();

        for (Nim nim : Nims){
            row = new TableRow(this);
            TextView t = new TextView(this);
            TextView t1 = new TextView(this);
            TextView t2 = new TextView(this);

            t.setText(String.valueOf(nim.getId()));
            t.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            t1.setText(String.valueOf(nim.getNim()));
            t1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            t2.setText(String.valueOf(nim.getNama()));
            t2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

            row.addView(t);
            row.addView(t1);
            row.addView(t2);
            ll.addView(row,new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
}
