package muhammad.salman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class App2 extends AppCompatActivity {

    DatabaseHandler db;
    Intent app3;
    Button simpan;
    Button next;
    Button btnback;
    Intent back;
    EditText edit_nama;
    EditText edit_nim;
    String tabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app2);

        simpan = (Button) findViewById(R.id.btn_simpan);
        next = (Button) findViewById(R.id.btn_next);
        edit_nama = (EditText) findViewById(R.id.edit_formnama);
        edit_nim = (EditText) findViewById(R.id.edit_formnim);
        app3 = new Intent(App2.this, App3.class);


        Intent baru = getIntent();
        tabel = baru.getStringExtra("tabel");
        if (tabel == null){
            tabel = "tb_nim";
        }
        Toast.makeText(this, tabel, Toast.LENGTH_SHORT).show();

        db = new DatabaseHandler(this, tabel);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addNim(new Nim(Integer.parseInt(edit_nim.getText().toString()),edit_nama.getText().toString()));
                Toast.makeText(App2.this, "NIM:"+edit_nim.getText()+" Added", Toast.LENGTH_SHORT).show();
            }
        });

        back = new Intent(App2.this, App1.class);

        btnback = (Button) findViewById(R.id.btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app3.putExtra("tabel",tabel);
                startActivity(app3);
            }
        });

    }
}
