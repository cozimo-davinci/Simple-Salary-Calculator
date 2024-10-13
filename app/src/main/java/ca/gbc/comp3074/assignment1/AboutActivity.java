package ca.gbc.comp3074.assignment1;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView fullName = findViewById(R.id.fullName);
        TextView studentID = findViewById(R.id.studentID);
        ImageView backButtonIcon = findViewById(R.id.backButtonIcon);
        ImageView menuIcon = findViewById(R.id.menuIcon);



        backButtonIcon.setOnClickListener(v -> {
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        });
        menuIcon.setOnClickListener(this::showMenu);

        fullName.setText("Full Name: Teimur Terchyyev");
        studentID.setText("Student ID: 101412670");


    }
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(AboutActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_main) {
                    Intent mainTransfer = new Intent(AboutActivity.this, MainActivity.class);
                    startActivity(mainTransfer);
                }
                if(item.getItemId() == R.id.action_about) {
                    Intent aboutTransfer = new Intent(AboutActivity.this, AboutActivity.class);
                    startActivity(aboutTransfer);
                }
                return true;
            }
        });
        popupMenu.show();
    }



}
