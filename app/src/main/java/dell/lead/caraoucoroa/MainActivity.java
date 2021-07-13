package dell.lead.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setButtonEvent();
    }

    private void setButtonEvent() {
        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> sendAnswer());
    }

    private void sendAnswer() {
        EditText userAnswerEditText = findViewById(R.id.userAnswerEditText);
        String userAnswerText = userAnswerEditText.getText().toString();

        Intent intent = new Intent(this, Activity2.class);

        intent.putExtra("CoinSide", convertStringAnswerToEnum(userAnswerText));

        startActivity(intent);
    }

    private CoinSide convertStringAnswerToEnum(String answer)
    {
        CoinSide coinSide;

        if(answer.equals("cara") || answer.equals("Cara")){
            coinSide = CoinSide.CARA;
            return coinSide;
        }
        else if(answer.equals("coroa") || answer.equals("Coroa")){
            coinSide = CoinSide.COROA;
            return coinSide;
        }
        else{
            return null;
        }
    }
}