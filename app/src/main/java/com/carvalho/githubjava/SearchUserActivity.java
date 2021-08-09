package com.carvalho.githubjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchUserActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        setComponents();
        onClickButton();
        validateForm();
    }

    private void validateForm() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editText.getText().toString().isEmpty()) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void onClickButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText() != null) {
                    requestUser();
                }
            }
        });
    }

    private void requestUser() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL + "/users/" + editText.getText().toString(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            User gitUser = new User(
                                    U.checkNull(response.getString("name")),
                                    U.checkNull(response.getString("login")),
                                    U.checkNull(response.getString("company")),
                                    U.checkNull(response.getString("bio")),
                                    response.getInt("followers"),
                                    response.getInt("following"),
                                    response.getInt("public_repos"),
                                    U.checkNull(response.getString("avatar_url"))
                            );

                            Intent navigateForm = new Intent(SearchUserActivity.this, UserActivity.class);
                            navigateForm.putExtra("gitUser",gitUser);
                            startActivity(navigateForm);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        queue.add(request);
    }

    private void setComponents() {
        button = findViewById(R.id.btnSearch);
        editText = findViewById(R.id.editTextUser);
        queue = Volley.newRequestQueue(this);
    }
}