package ca.gbc.comp3074.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText numberOfHours;
    EditText hourlyRate;
    TextView displayResult;
    Button calculateResult;
    Animation fadeInANIMATION;
    ImageView menuIcon;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        numberOfHours = findViewById(R.id.numberOfHours);
        hourlyRate = findViewById(R.id.hourlyRate);
        displayResult = findViewById(R.id.displayResult);
        calculateResult = findViewById(R.id.calculateResult);
        menuIcon = findViewById(R.id.menuIcon);




        fadeInANIMATION = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        calculateResult.setOnClickListener(v -> {

            calculateResult();
        }
        );

        menuIcon.setOnClickListener(this::showMenu);

    }
    void calculateResult() {
        String hours = numberOfHours.getText().toString();
        String rate = hourlyRate.getText().toString();
        double totalPay = 0;
        double overTimePay = 0;
        double regularPay = 0;

        if (hours.isEmpty() || rate.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Please enter both hours and rate", Toast.LENGTH_SHORT).show();
            return;
        }
        double hoursWorked = Double.parseDouble(hours);
        double hourlyRate = Double.parseDouble(rate);

        if (hoursWorked <=40) {
            regularPay = hoursWorked * hourlyRate;
            totalPay = regularPay;
        } else {
            regularPay = 40 * hourlyRate;
            overTimePay = (hoursWorked - 40) * (hourlyRate * 1.5);
            totalPay = regularPay + overTimePay;
        }
        double tax = totalPay * 0.18;
        Toast.makeText(MainActivity.this, "Calculating...", Toast.LENGTH_SHORT).show();
        String resultText =  "Regular Pay: $" + String.format("%.2f", regularPay) + "\n"
                + "Overtime Pay: $" + String.format("%.2f", overTimePay) + "\n"
                + "Total Pay: $" + String.format("%.2f", totalPay) + "\n"
                + "Tax: $" + String.format("%.2f", tax);

        displayResult.setText(resultText);
        displayResult.startAnimation(fadeInANIMATION);

    }


    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_main) {
                    Intent mainTransfer = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(mainTransfer);
                }
                if(item.getItemId() == R.id.action_about) {
                    Intent aboutTransfer = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(aboutTransfer);
                }
                return true;
            }
        });
        popupMenu.show();
    }




}