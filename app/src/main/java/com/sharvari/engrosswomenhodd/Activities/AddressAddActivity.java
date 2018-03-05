package com.sharvari.engrosswomenhodd.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sharvari.engrosswomenhodd.R;
import com.sharvari.engrosswomenhodd.Realm.UserDetails;
import com.sharvari.engrosswomenhodd.Utils.RealmController;
import com.sharvari.engrosswomenhodd.Utils.SharedPreference;

import java.util.UUID;

/**
 * Created by sharvari on 05-Mar-18.
 */

public class AddressAddActivity extends AppCompatActivity{
    private EditText type, address, landmark, area, city, pincode, country;
    private Button add;
    private RelativeLayout layout;
    private SharedPreference preference;
    private String addressType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        preference = new SharedPreference(this);

        addressType = getIntent().getExtras().getString("Type");
        Toast.makeText(this, addressType, Toast.LENGTH_SHORT).show();

        type = findViewById(R.id.type);
        address = findViewById(R.id.address);
        landmark = findViewById(R.id.landmark);
        area = findViewById(R.id.area);
        city = findViewById(R.id.city);
        pincode = findViewById(R.id.pincode);
        country = findViewById(R.id.country);
        add = findViewById(R.id.add);
        layout = findViewById(R.id.layout);
        /*Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show();*/
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData(){
        if(type.getText().toString().isEmpty()){
            Snackbar.make(layout, "Enter type of address",Snackbar.LENGTH_SHORT).show();
            return;
        }else if(address.getText().toString().isEmpty()){
            Snackbar.make(layout, "Enter flat no/ buldg no/ street",Snackbar.LENGTH_SHORT).show();
            return;
        }else if(landmark.getText().toString().isEmpty()){
            Snackbar.make(layout, "Enter landmark",Snackbar.LENGTH_SHORT).show();
            return;
        }else if(area.getText().toString().isEmpty()){
            Snackbar.make(layout, "Enter area",Snackbar.LENGTH_SHORT).show();
            return;
        }else if(city.getText().toString().isEmpty()){
            Snackbar.make(layout, "Enter city",Snackbar.LENGTH_SHORT).show();
            return;
        }else if(pincode.getText().toString().isEmpty()){
            Snackbar.make(layout, "Enter pincode",Snackbar.LENGTH_SHORT).show();
            return;
        }else if(country.getText().toString().isEmpty()){
            Snackbar.make(layout, "Enter country",Snackbar.LENGTH_SHORT).show();
            return;
        }

        UserDetails details = new UserDetails(
                UUID.randomUUID().toString(),
                preference.getUserId(),
                type.getText().toString(),
                address.getText().toString(),
                landmark.getText().toString(),
                area.getText().toString(),
                city.getText().toString(),
                pincode.getText().toString(),
                country.getText().toString(),
                System.currentTimeMillis(),
                System.currentTimeMillis()
        );
        RealmController.with(this).updateUserDetails(details);
        Toast.makeText(this, "Address added against your profile.", Toast.LENGTH_SHORT).show();
        finish();
    }

}