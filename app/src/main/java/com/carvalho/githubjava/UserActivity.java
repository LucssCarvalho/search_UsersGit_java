package com.carvalho.githubjava;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class UserActivity extends AppCompatActivity {

    private TextView nameView, userView, orgView, bioView, fwsView, fwgView, repView;

    private ImageView avatarImage;

    private User user;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createComponents();
        final Intent data = getIntent();
        if (data.hasExtra("gitUser")) {
            user = (User) data.getSerializableExtra("gitUser");
            setComponents(user);
        }
    }

    private void createComponents() {
        context = this;
        nameView = findViewById(R.id.nameVal);
        userView = findViewById(R.id.userVal);
        orgView = findViewById(R.id.orgVal);
        bioView = findViewById(R.id.bioVal);
        fwsView = findViewById(R.id.fwsVal);
        fwgView = findViewById(R.id.fwgVal);
        repView = findViewById(R.id.repVal);
        avatarImage = findViewById(R.id.imageView);
    }


    private void setComponents(User user) {
        nameView.setText(user.getName());
        userView.setText(user.getUserName());
        orgView.setText(user.getOrganization());
        bioView.setText(user.getBio());
        fwgView.setText(Integer.toString(user.getFollowing()));
        fwsView.setText(Integer.toString(user.getFollowers()));
        repView.setText(Integer.toString(user.getRepositories()));
        Glide.with(context).load(user.getAvatarUrl()).centerInside().into(avatarImage);
    }

}