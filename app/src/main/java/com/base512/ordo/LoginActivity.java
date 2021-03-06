package com.base512.ordo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.base512.ordo.data.source.DataModel;
import com.base512.ordo.data.User;
import com.base512.ordo.data.source.BaseDataSource;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Super simple (insecure) login screen that requires a passphrase
 */
public class LoginActivity extends OrdoActivity {

    @BindView(R.id.unlockButton)
    ImageView mUnlockButton;

    @BindView(R.id.loginInput)
    EditText mLoginInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
    }

    private void setupViews() {

        ButterKnife.bind(this);

        mUnlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        String keyCode = mLoginInput.getText().toString().toLowerCase();

        DataModel.getDataModel().attemptLogin(keyCode, new BaseDataSource.GetDataCallback<User>() {
            @Override
            public void onDataLoaded(User user) {
                DataModel.getDataModel().setUser(user);
                returnToMenu();
            }

            @Override
            public void onDataError() {
                // TODO: This should be loaded from XML resources
                Toast.makeText(LoginActivity.this, "not a recognized user", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void returnToMenu() {
        Intent menuIntent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(menuIntent);
        finish();
    }

}
