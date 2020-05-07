package com.example.thirdeye;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;


public class Registration extends AppCompatActivity {

     FirebaseAuth firebaseAuth;
     FirebaseDatabase database;
     RadioButton male,female;
     DatabaseReference ref;
     String gender="";
     userData userData;

     EditText edtUsername2, edtEmail, edtNumber, edtPassword2,edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        final EditText edtUsername2 = findViewById(R.id.edtUsername2);
        final EditText edtEmail = findViewById(R.id.edtEmail);
        final EditText edtNumber = findViewById(R.id.edtNumber);
        final EditText edtPassword2 = findViewById(R.id.edtPassword2);
        final EditText edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        Button signup = findViewById(R.id.signup);
        database = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        ref = database.getInstance().getReference("userData");
        userData=new userData();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name= edtUsername2.getText().toString();
                final String email= edtEmail.getText().toString();
                final String number= edtNumber.getText().toString();
                final String password= edtPassword2.getText().toString();
                String confirmPassword= edtConfirmPassword.getText().toString();

                if(TextUtils.isEmpty(name)){
                    edtUsername2.setError("Please Enter Name");
                    edtUsername2.requestFocus();
                    return;

                }
                if(TextUtils.isEmpty(email)){
                    edtEmail.setError("Please Enter Email");
                    edtEmail.requestFocus();
                    return;
                }
                if (male.isChecked()){

                    gender="Male";
                }
                if (female.isChecked()){

                    gender="Female";
                }

                if(TextUtils.isEmpty(number)){
                    edtNumber.setError("Please Enter Phone Number");
                    edtNumber.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    edtPassword2.setError("Please Enter Password");
                    edtPassword2.requestFocus();
                    return;

                }
                if(password.length()<6){
                    edtPassword2.setError("Minimum 6 Characters Required");
                    edtPassword2.requestFocus();
                    return;}


                if(TextUtils.isEmpty(confirmPassword)){
                    edtConfirmPassword.setError("Please Enter Confirm Password");
                    edtConfirmPassword.requestFocus();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {



                                    userData information=new userData(

                                            name,
                                            email,
                                            number,
                                            gender,
                                            password

                                    );


                                    FirebaseDatabase.getInstance().getReference("userData")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Registration.this,"Registration Complete",Toast.LENGTH_SHORT).show();

                                        }
                                    });


                                } else {

                                    Toast.makeText(Registration.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();

                                }


                            }
                        });



            }
        });



    }

}
