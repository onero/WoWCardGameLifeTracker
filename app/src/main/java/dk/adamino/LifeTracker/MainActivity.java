package dk.adamino.LifeTracker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    private TextView mWinnerText;
    private Button btnNewGame;

    public static final String PLAYER_WINTEXT = "Yay you won!";
    public static final String OPPONENT_WINTEXT = "LOOSER!!!";

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

        mWinnerText = (TextView) findViewById(R.id.txtWinner);

        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setVisibility(View.INVISIBLE);

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
                    checkGameOver();
                }
            }
        };
        imgPlayerHealthDown.setOnClickListener(playerHealthDownListener);

        View.OnClickListener playerDamageUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayerDamage++;
                txtPlayerDamage.setText("" + mPlayerDamage);
                checkGameOver();
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
                    checkGameOver();
                }
            }
        };
        imgOpponentHealthDown.setOnClickListener(OpponentHealthDownListener);

        View.OnClickListener OpponentDamageUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOpponentDamage++;
                txtOpponentDamage.setText("" + mOpponentDamage);
                checkGameOver();
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

        //Set new game button
        View.OnClickListener newGameListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        };
        btnNewGame.setOnClickListener(newGameListener);
    }

    /**
     * Checks if the game is won
     */
    private void checkGameOver() {
        //If opponent wins
        if (mPlayerDamage >= mPlayerHealth || mPlayerHealth == 0) {
            mWinnerText.setText(OPPONENT_WINTEXT);
            mWinnerText.setTextColor(Color.parseColor("#e15258"));
            mWinnerText.setVisibility(View.VISIBLE);
            btnNewGame.setVisibility(View.VISIBLE);
            //If we win
        } else if (mOpponentDamage >= mOpponentHealth || mOpponentHealth == 0) {
            mWinnerText.setText(PLAYER_WINTEXT);
            mWinnerText.setTextColor(Color.parseColor("#51b46d"));
            mWinnerText.setVisibility(View.VISIBLE);
            btnNewGame.setVisibility(View.VISIBLE);
        }
    }


}
