package droids.rizz.dagger2example;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import droids.rizz.dagger2example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private MyComponent myComponent;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        myComponent.inject(this);
        setUp();
    }

    private void setUp() {
        mainBinding.btnGet.setOnClickListener(v -> {
            mainBinding.inUsername.setText(sharedPreferences.getString("UserName", "DEFAULT"));
            mainBinding.inNumber.setText(sharedPreferences.getString("Number", "123456"));
        });

        mainBinding.btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("UserName", mainBinding.inUsername.getText().toString());
            editor.putString("Number", mainBinding.inNumber.getText().toString());
            editor.apply();
        });

        mainBinding.nextBtn.setOnClickListener(v->{
            Intent i=new Intent(this,Main2Activity.class);
            startActivity(i);
        });
    }
}
