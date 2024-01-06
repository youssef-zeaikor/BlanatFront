package com.blanat.blanatfront.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.blanat.blanatfront.R;

import java.util.Locale;

public class Language extends AppCompatActivity {

    Spinner spinnerLanguage;
    public static final String[] languages = {"Select language", "English", "Français", "عربي"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        spinnerLanguage = findViewById(R.id.languageSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapter);
        spinnerLanguage.setSelection(0);
        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = parent.getItemAtPosition(position).toString();
                if (!selectedLanguage.equals("Select language")) {
                    setLocale(Language.this, getLanguageCode(selectedLanguage));
                    Intent loginIntent = new Intent(Language.this, MainActivity.class);
                    startActivity(loginIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private String getLanguageCode(String language) {
        switch (language) {
            case "English":
                return "en";
            case "Français":
                return "fr";
            case "عربي":
                return "ar";
            default:
                return "en"; // Default to English
        }
    }

    private void setLocale(Activity activity, String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
