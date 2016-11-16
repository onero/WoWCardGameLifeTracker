package dk.adamino.LifeTracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtPlayerHealth;
    private ImageButton imgPlayerHealthUp;
    private ImageButton imgPlayerHealthDown;
    private TextView txtPlayerDamage;
    private ImageButton imgPlayerDamageUp;
    private ImageButton imgPlayerDamageDown;

    private TextView txtOpponentHealth;
    private ImageButton imgOpponentHealthUp;
    private ImageButton imgOpponentHealthDown;
    private TextView txtOpponentDamage;
    private ImageButton imgOpponentDamageUp;
    private ImageButton imgOpponentDamageDown;

    private int mPlayerHealth = 25;
    private int mPlayerDamage = 0;

    private int mOpponentHealth = 25;
    private int mOpponentDamage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set views for player
        txtPlayerHealth = (TextView) findViewById(R.id.txtHealth);
        txtPlayerHealth.setText("25");
        imgPlayerHealthUp = (ImageButton) findViewById(R.id.imgBtnPlayerHealthUp);
        imgPlayerHealthDown = (ImageButton) findViewById(R.id.imgBtnPlayerHealthDown);
        txtPlayerDamage = (TextView) findViewById(R.id.txtDamage);
        imgPlayerDamageUp = (ImageButton) findViewById(R.id.imgBtnPlayerDamageUp);
        imgPlayerDamageDown = (ImageButton) findViewById(R.id.imgBtnPlayerDamageDown);

        //Set views for opponent
        txtOpponentHealth = (TextView) findViewById(R.id.txtOpponentHealth);
        txtOpponentHealth.setText("25");
        imgOpponentHealthUp = (ImageButton) findViewById(R.id.imgBtnOpponentHealthUp);
        imgOpponentHealthDown = (ImageButton) findViewById(R.id.imgBtnOpponentHealthDown);
        txtOpponentDamage = (TextView) findViewById(R.id.txtOpponentDamage);
        imgOpponentDamageUp = (ImageButton) findViewById(R.id.imgBtnOpponentDamageUp);
        imgOpponentDamageDown = (ImageButton) findViewById(R.id.imgBtnOpponentDamageDown);

        //Set buttons for player
        View.OnClickListener playerHealthUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayerHealth++;
                txtPlayerHealth.setText("" + mPlayerHealth);
            }
        };
        imgPlayerHealthUp.setOnClickListener(playerHealthUpListener);

        View.OnClickListener playerHealthDownListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPlayerHealth > 0) {
                mPlayerHealth--;
                txtPlayerHealth.setText("" + mPlayerHealth);
                }
            }
        };
        imgPlayerHealthDown.setOnClickListener(playerHealthDownListener);

        View.OnClickListener playerDamageUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayerDamage++;
                txtPlayerDamage.setText("" + mPlayerDamage);
            }
        };
        imgPlayerDamageUp.setOnClickListener(playerDamageUpListener);

        View.OnClickListener playerDamageDownListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPlayerDamage > 0) {
                mPlayerDamage--;
                txtPlayerDamage.setText("" + mPlayerDamage);
                }
            }
        };
        imgPlayerDamageDown.setOnClickListener(playerDamageDownListener);

        //Set buttons for opponent
        View.OnClickListener OpponentHealthUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOpponentHealth++;
                txtOpponentHealth.setText("" + mOpponentHealth);
            }
        };
        imgOpponentHealthUp.setOnClickListener(OpponentHealthUpListener);

        View.OnClickListener OpponentHealthDownListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOpponentHealth > 0) {
                    mOpponentHealth--;
                    txtOpponentHealth.setText("" + mOpponentHealth);
                }
            }
        };
        imgOpponentHealthDown.setOnClickListener(OpponentHealthDownListener);

        View.OnClickListener OpponentDamageUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOpponentDamage++;
                txtOpponentDamage.setText("" + mOpponentDamage);
            }
        };
        imgOpponentDamageUp.setOnClickListener(OpponentDamageUpListener);

        View.OnClickListener OpponentDamageDownListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOpponentDamage > 0) {
                    mOpponentDamage--;
                    txtOpponentDamage.setText("" + mOpponentDamage);
                }
            }
        };
        imgOpponentDamageDown.setOnClickListener(OpponentDamageDownListener);
    }


}
