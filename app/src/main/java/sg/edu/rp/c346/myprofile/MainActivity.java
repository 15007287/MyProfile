package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox ckbLike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText)findViewById(R.id.editTextName);
        etGPA = (EditText)findViewById(R.id.editTextGPA);
        rgGender = (RadioGroup) findViewById(R.id.RadioGroupGender);
        ckbLike = (CheckBox) findViewById(R.id.checkBoxProg);

    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        Float GPA = Float.parseFloat(etGPA.getText().toString());
        Boolean Check = ckbLike.isChecked();
        int Gender = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strName);
        prefEdit.putFloat("gpa",GPA);
        prefEdit.putBoolean("check",Check);
        prefEdit.putInt("gender",Gender);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strName = prefs.getString("name","John");
        Float GPA = prefs.getFloat("gpa",0);
        Boolean check = prefs.getBoolean("check", false);
        int gender = prefs.getInt("gender", 0);
        etName.setText(strName);
        etGPA.setText("" + GPA);
        ckbLike.setChecked(check);
        rgGender.check(gender);


    }



}
