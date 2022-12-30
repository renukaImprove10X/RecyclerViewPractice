package com.improve10x.recyclerviewpractice;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.improve10x.recyclerviewpractice.databinding.ActivityMainBinding;
import com.improve10x.recyclerviewpractice.filmDiary.movies.MoviesActivity;
import com.improve10x.recyclerviewpractice.filmDiary.series.SeriesActivity;
import com.improve10x.recyclerviewpractice.grocery.CategoriesActivity;
import com.improve10x.recyclerviewpractice.whatsapp.messages.MessageActivity;
import com.improve10x.recyclerviewpractice.whatsapp.templates.TemplatesActivity;

import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );

    List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.PhoneBuilder().build());
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setupButtons();
    }

    private void setupButtons() {
        handleTemplates();
        handleMessages();
        handleSeries();
        handleMovies();
        handleGroceries();
        handleLogin();
        handleLogout();
    }

    private void handleLogout() {
        binding.logoutBtn.setOnClickListener(view -> {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(DashboardActivity.this, "Logged out!", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

    private void handleLogin() {
        binding.loginBtn.setOnClickListener(view -> {
            Toast.makeText(this, "Clicked on Login", Toast.LENGTH_SHORT).show();
            Intent signInIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build();
            signInLauncher.launch(signInIntent);
        });
    }

    private void handleGroceries() {
        binding.groceryBtn.setOnClickListener(view -> {
            Intent groceryIntent = new Intent(this, CategoriesActivity.class);
            startActivity(groceryIntent);
        });
    }

    private void handleMovies() {
        binding.movieBtn.setOnClickListener(view -> {
            Intent movieIntent = new Intent(this, MoviesActivity.class);
            startActivity(movieIntent);
        });
    }

    private void handleSeries() {
        binding.seriesBtn.setOnClickListener(view -> {
            Intent seriesIntent = new Intent(this, SeriesActivity.class);
            startActivity(seriesIntent);
        });
    }

    private void handleMessages() {
        binding.messagesBtn.setOnClickListener(view -> {
            Intent messageIntent = new Intent(this, MessageActivity.class);
            startActivity(messageIntent);
        });
    }

    private void handleTemplates() {
        binding.templatesBtn.setOnClickListener(view -> {
            Intent templateIntent = new Intent(this, TemplatesActivity.class);
            startActivity(templateIntent);
        });
    }

    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == RESULT_OK) {
            // Successfully signed in
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            // ...
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }
}