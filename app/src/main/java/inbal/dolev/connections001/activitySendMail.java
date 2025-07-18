package inbal.dolev.connections001;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class activitySendMail extends AppCompatActivity {
    private EditText etAddress, etSubj, etText;
    private Button btnMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        etAddress = findViewById(R.id.etAddress);
        etSubj = findViewById(R.id.etSubj);
        etText = findViewById(R.id.etText);
        btnMail = findViewById(R.id.bMail);

        btnMail.setOnClickListener(v -> {
            String address = etAddress.getText().toString().trim();
            String subject = etSubj.getText().toString().trim();
            String text = etText.getText().toString().trim();

            if (!address.isEmpty() && !subject.isEmpty() && !text.isEmpty()) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + address));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, text);

                startActivity(Intent.createChooser(emailIntent, "Send Email"));
            }
        });
    }
}
