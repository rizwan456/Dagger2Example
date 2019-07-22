package droids.rizz.dagger2example;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import droids.rizz.dagger2example.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    ActivityMain2Binding main2Binding;
    private MyComponent myComponent;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        myComponent.inject(this);
        setUp();
    }

    private void setUp() {
        main2Binding.userNamewTxt.setText(sharedPreferences.getString("UserName","DEFAULT"));
        main2Binding.numberTxt.setText(sharedPreferences.getString("Number","123456"));
    }
}
