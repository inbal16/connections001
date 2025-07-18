package inbal.dolev.connections001;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnPhone, btnSMS, btnMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPhone = findViewById(R.id.phone);
        btnSMS = findViewById(R.id.sendSMS);
        btnMail = findViewById(R.id.sendMail);

        btnPhone.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, activityPhoneCall.class)));
        btnSMS.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, activitiySendSms.class)));
        btnMail.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, activitySendMail.class)));
    }
}
