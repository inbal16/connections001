package inbal.dolev.connections001;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activityPhoneCall extends AppCompatActivity {

    private EditText etNum;
    private Button bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        etNum = findViewById(R.id.etNum);
        bCall = findViewById(R.id.btnCall);

        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etNum.getText().toString().trim();

                if (phoneNumber.isEmpty()) {
                    Toast.makeText(activityPhoneCall.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                } else {
                    // יצירת Intent לפתיחת החייגן עם המספר שהוזן
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(intent);
                }
            }
        });
    }
}

