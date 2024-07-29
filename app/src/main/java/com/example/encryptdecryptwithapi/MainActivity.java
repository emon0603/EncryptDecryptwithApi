package com.example.encryptdecryptwithapi;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    TextInputEditText edpass, edtext;
    TextView randompassbt,tvdisplay;
    TextInputLayout edlay;
    Button lockbt, unlockbt;
    ImageView copybt, sharebt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edpass = findViewById(R.id.edpass);
        edtext = findViewById(R.id.textInputEditText);
        randompassbt = findViewById(R.id.randompassbt);
        lockbt = findViewById(R.id.button);
        unlockbt = findViewById(R.id.button2);
        tvdisplay = findViewById(R.id.tvdisplay);
        copybt = findViewById(R.id.copybt);
        sharebt = findViewById(R.id.sharebt);





        copybt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from TextView
                String textToCopy = tvdisplay.getText().toString().trim();

                // Copy text to clipboard
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copied Text", textToCopy);
                clipboardManager.setPrimaryClip(clipData);

                // Notify the user with a toast
                Toast.makeText(MainActivity.this, "Text copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        sharebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, tvdisplay.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });



    }
}