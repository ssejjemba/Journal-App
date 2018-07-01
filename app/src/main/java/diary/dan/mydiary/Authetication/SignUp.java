package diary.dan.mydiary.Authetication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import diary.dan.mydiary.R;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "message_tag";
    EditText et_email, et_password;
    Button btn_signup;
    ProgressBar signup_progress;
    TextView tv_signUp;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        populateViews();
        mAuth = FirebaseAuth.getInstance();


        btn_signup.setOnClickListener(this);
        tv_signUp.setOnClickListener(this);
    }

    private void populateViews() {
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_signup = (Button) findViewById(R.id.btn_submit);
        signup_progress = (ProgressBar) findViewById(R.id.signup_progress);
        tv_signUp = (TextView) findViewById(R.id.tv_signUp);
    }

    private void createUsers(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            signup_progress.setVisibility(View.GONE);
                            //@TODO take the user to a welcome screen
                            Intent intent = new Intent(SignUp.this, SignIn.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            signup_progress.setVisibility(View.GONE);
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit:
                signup_progress.setVisibility(View.VISIBLE);
                createUsers(et_email.getText().toString(), et_password.getText().toString());
                break;
            case R.id.tv_signUp:
                signin();
                break;
        }
    }

    private void signin() {
        Intent intent = new Intent(SignUp.this, SignIn.class);
        startActivity(intent);
    }
}
