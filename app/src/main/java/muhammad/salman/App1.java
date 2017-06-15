package muhammad.salman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class App1 extends AppCompatActivity {

    Button createDB;
    Intent app2;
    EditText tabel;
    String namatabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app1);

        app2 = new Intent(App1.this, App2.class);



        createDB = (Button) findViewById(R.id.btn_createdb);
        createDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabel = (EditText) findViewById(R.id.edit_formtabel);
                namatabel = tabel.getText().toString();
                Toast.makeText(App1.this, namatabel, Toast.LENGTH_SHORT).show();
                app2.putExtra("tabel",namatabel);
                startActivity(app2);
            }
        });

    }
}
