package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);

    }

    @Override
    protected void onPause() {
        super.onPause();


        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        Integer intGenderId = rgGender.getCheckedRadioButtonId();

        float gpa = Float.parseFloat(strGPA);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("genderId", intGenderId);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        String strName = etName.getText().toString();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("name", strName);
        Float gpa = prefs.getFloat("gpa", 0);
        Integer gender = prefs.getInt("genderId", R.id.radioButtonGenderMale);

        etName.setText(strName);
        etGPA.setText(gpa + "");
    }
}
