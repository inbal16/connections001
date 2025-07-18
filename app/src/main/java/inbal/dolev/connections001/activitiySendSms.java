package inbal.dolev.connections001;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class activitiySendSms extends AppCompatActivity {
    private EditText etNumber, etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitiy_send_sms);

        etNumber = findViewById(R.id.etNumber);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.bSend);

        btnSend.setOnClickListener(v -> {
            String phoneNumber = etNumber.getText().toString().trim();
            String message = etMessage.getText().toString().trim();

            if (!phoneNumber.isEmpty() && !message.isEmpty()) {
                if (ActivityCompat.checkSelfPermission(activitiySendSms.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activitiySendSms.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                    return;
                }

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Toast.makeText(activitiySendSms.this, "SMS Sent", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activitiySendSms.this, "Please enter both phone number and message", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
