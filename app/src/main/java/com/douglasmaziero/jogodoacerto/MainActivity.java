package com.douglasmaziero.jogodoacerto;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectStone(View view) {
        checkWinner("Stone");
    }
    public void selectPaper(View view) {
        checkWinner("Paper");
    }
    public void selectScissors(View view) {
        checkWinner("Scissors");
    }

    private String generateRandomChoose() {
        String[] options = {
                "Stone",
                "Paper",
                "Scissors"
        };
        int numberRandom = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String optionChosen = options[numberRandom];

        switch ( optionChosen ){
                case "Stone":
                    imagemApp.setImageResource(R.drawable.pedra);
                break;
                case "Paper":
                    imagemApp.setImageResource(R.drawable.papel);
                break;
                case "Scissors":
                    imagemApp.setImageResource(R.drawable.tesoura);
                break;

        }

        return optionChosen;
    }

    private void checkWinner( String chooseUser ){
        String chooseApp = generateRandomChoose();
        TextView textResult = findViewById(R.id.text_result);

        if(
            (chooseApp == "Stone" && chooseUser == "Scissors") ||
            (chooseApp == "Paper" && chooseUser == "Stone") ||
            (chooseApp == "Scissors" && chooseUser == "Paper")
        ) {
            textResult.setText("Você perdeu :(");
            return;
        }else if(chooseApp == chooseUser){
            textResult.setText("Empatamos ;)");
            return;
        }

        textResult.setText("Você ganhou :)");
        return;
    }


}