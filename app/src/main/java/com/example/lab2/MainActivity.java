package com.example.lab2;

import static com.example.lab2.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main_linear);

        Button pressMeButton = findViewById(id.button);
        EditText outputTextView= findViewById(R.id.inputtext);

        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = outputTextView.getText().toString();
                outputTextView.setText(inputText);
                String toastMessage = getResources().getString(R.string.toast_message);
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox checkBox = findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                String message = "The checkbox is now " + (b ? getResources().getString(R.string.checkbox_on) : getResources().getString(R.string.checkbox_off));
                Snackbar snackbar = Snackbar.make(findViewById(id.checkBox), message, Snackbar.LENGTH_LONG);
                snackbar.setAction(getResources().getString(R.string.undo), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cb.setChecked(!b);
                    }
                });
                snackbar.show();
            }
        });
    }

}