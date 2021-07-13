package dell.lead.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        showResult();
        setButtonEvent();
    }

    private void showResult() {
        Intent intent = getIntent();

        CoinSide userCoinSideAnswer = (CoinSide) intent.getSerializableExtra("CoinSide");
        CoinSide randomCoinSide = generateRandomCoinSide();

        TextView resultText = findViewById(R.id.textView);

        if(userCoinSideAnswer == randomCoinSide){
            resultText.setText("Você ganhou!!");
        }
        else if(userCoinSideAnswer != randomCoinSide && userCoinSideAnswer != null){
            resultText.setText("Você perdeu... Mas pode tentar denovo!!");
        }
        else{
            resultText.setText("Resposta inválida, tente novamente.");
        }
    }

    private CoinSide generateRandomCoinSide() {
        CoinSide[] values = CoinSide.values();
        int enumLength = values.length;
        int randomIndex = new Random().nextInt(enumLength);

        return values[randomIndex];
    }

    private void setButtonEvent() {
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> playAgain());
    }

    private void playAgain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}