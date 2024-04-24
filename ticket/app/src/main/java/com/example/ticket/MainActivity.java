import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.ticket.R;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView lblOutput;
    private RadioGroup rgTicketType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lblOutput = findViewById(R.id.lblOutput);
        rgTicketType = findViewById(R.id.rgTicketType);

        Button btnChoose = findViewById(R.id.btnChoose);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgTicketType.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String ticketType = selectedRadioButton.getText().toString();
                lblOutput.setText("你的選擇：" + ticketType);
            }
        });
    }
}
