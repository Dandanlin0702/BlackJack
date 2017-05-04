package com.example.dandan_lin.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class BlackJack extends AppCompatActivity {
    // a random variable for choosing players
    private Random random = new Random();

    public TextView textViewUser, textViewComputer, textViewGameStatus;
    public Button clickToHit, clickToStart, clickToStand, clickToNextRound, clickToRestart;
    public ImageView imageViewUser1, imageViewUser2, imageViewUser3, imageViewComputer1, imageViewComputer2, imageViewComputer3;
    public int userScore = 0, computerScore = 0, currScoreUser = 0, currScoreComputer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);

        textViewUser = (TextView) findViewById(R.id.userScore);
        textViewComputer = (TextView) findViewById(R.id.computerScore);
        textViewGameStatus = (TextView) findViewById(R.id.gameStatus);

        clickToHit = (Button) findViewById(R.id.hitButton);
        clickToStart = (Button) findViewById(R.id.startGame);
        clickToStand = (Button) findViewById(R.id.holdButton);
        clickToRestart = (Button) findViewById(R.id.restartBtn);
        clickToNextRound = (Button) findViewById(R.id.nextRound);

        imageViewUser1 = (ImageView) findViewById(R.id.userCard1);
        imageViewUser2 = (ImageView) findViewById(R.id.userCard2);
        imageViewUser3 = (ImageView) findViewById(R.id.userCard3);

        imageViewComputer1 = (ImageView) findViewById(R.id.computerCard1);
        imageViewComputer2 = (ImageView) findViewById(R.id.computerCard2);
        imageViewComputer3 = (ImageView) findViewById(R.id.computerCard3);

        clickToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewGameStatus.setText("User Turn");

                currScoreUser += userTurn(imageViewUser1, currScoreUser);
                currScoreUser = userTurn(imageViewUser2, currScoreUser);

                currScoreComputer += computerTurn(imageViewComputer1, currScoreComputer);
                currScoreComputer = computerTurn(imageViewComputer2, currScoreComputer);
            }
        });

        clickToHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currScoreUser = userTurn(imageViewUser3, currScoreUser);

                if (currScoreUser == 21) {
                    textViewGameStatus.setText("BLACK JACK. You Win. Congratulations");
                    userScore++;
                } else if (currScoreUser > 21) {
                    textViewGameStatus.setText("Oops, you burst. Computer Wins");
                    computerScore++;
                } else {
                    ;
                }
            }
        });

        clickToStand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currScoreComputer = computerTurn(imageViewComputer3, currScoreComputer);

                if (currScoreComputer == 21) {
                    textViewGameStatus.setText("BLACK JACK. Computer Wins");
                    computerScore++;
                } else if (currScoreUser > 21) {
                    textViewGameStatus.setText("Congratulations, Computer Burst. You Win");
                    userScore++;
                } else {
                    if (currScoreUser > currScoreComputer) {
                        textViewGameStatus.setText("Congratulations, You Win");
                        userScore++;
                    } else if (currScoreComputer > currScoreUser && currScoreComputer <= 21) {
                        textViewGameStatus.setText("Wuuu, Compute Wins");
                        computerScore++;
                    }
                }
            }
        });

        clickToNextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTurnScore();
                textViewGameStatus.setText("New Round - User Turn");
                resetImageView();

                textViewUser.setText("User Score: " + userScore);
                textViewComputer.setText("Computer Score: " + computerScore);
            }
        });

        clickToRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetImageView();

                userScore = 0;
                computerScore = 0;

                textViewUser.setText("User Score: " + userScore);
                textViewComputer.setText("Computer Score: " + computerScore);

                resetTurnScore();

                textViewGameStatus.setText("Game Started. Good Luck");
            }
        });

    }

    int computerTurn(ImageView imageViewTemp, int currScoreComputerTemp) {
        int point = random.nextInt(13)+1;
        switch(point) {
            case 1:
                imageViewTemp.setImageResource(R.drawable.one);
                if (currScoreUser <= 10) {
                    currScoreComputerTemp += 10;
                } else {
                    currScoreComputerTemp += 1;
                }
                break;
            case 2:
                imageViewTemp.setImageResource(R.drawable.two);
                currScoreComputerTemp += 2;
                break;
            case 3:
                imageViewTemp.setImageResource(R.drawable.three);
                currScoreComputerTemp += 3;
                break;
            case 4:
                imageViewTemp.setImageResource(R.drawable.four);
                currScoreComputerTemp += 4;
                break;
            case 5:
                imageViewTemp.setImageResource(R.drawable.five);
                currScoreComputerTemp += 5;
                break;
            case 6:
                imageViewTemp.setImageResource(R.drawable.six);
                currScoreComputerTemp += 6;
                break;
            case 7:
                imageViewTemp.setImageResource(R.drawable.seven);
                currScoreComputerTemp += 7;
                break;
            case 8:
                imageViewTemp.setImageResource(R.drawable.eight);
                currScoreComputerTemp += 8;
                break;
            case 9:
                imageViewTemp.setImageResource(R.drawable.nine);
                currScoreComputerTemp += 9;
                break;
            case 10:
                imageViewTemp.setImageResource(R.drawable.ten);
                currScoreComputerTemp += 10;
                break;
            case 11:
                imageViewTemp.setImageResource(R.drawable.eleven);
                currScoreComputerTemp += 10;
                break;
            case 12:
                imageViewTemp.setImageResource(R.drawable.twelve);
                currScoreComputerTemp += 10;
                break;
            case 13:
                imageViewTemp.setImageResource(R.drawable.thirteen);
                currScoreComputerTemp += 10;
                break;
        }

        return currScoreComputerTemp;
    }

    int userTurn(ImageView imageViewTemp, int currScoreUserTemp) {
        int point = random.nextInt(13)+1;
        switch(point) {
            case 1:
                imageViewTemp.setImageResource(R.drawable.one);
                if (currScoreUser <= 10) {
                    currScoreUserTemp += 10;
                } else {
                    currScoreUserTemp += 1;
                }
                break;
            case 2:
                imageViewTemp.setImageResource(R.drawable.two);
                currScoreUserTemp += 2;
                break;
            case 3:
                imageViewTemp.setImageResource(R.drawable.three);
                currScoreUserTemp += 3;
                break;
            case 4:
                imageViewTemp.setImageResource(R.drawable.four);
                currScoreUserTemp += 4;
                break;
            case 5:
                imageViewTemp.setImageResource(R.drawable.five);
                currScoreUserTemp += 5;
                break;
            case 6:
                imageViewTemp.setImageResource(R.drawable.six);
                currScoreUserTemp += 6;
                break;
            case 7:
                imageViewTemp.setImageResource(R.drawable.seven);
                currScoreUserTemp += 7;
                break;
            case 8:
                imageViewTemp.setImageResource(R.drawable.eight);
                currScoreUserTemp += 8;
                break;
            case 9:
                imageViewTemp.setImageResource(R.drawable.nine);
                currScoreUserTemp += 9;
                break;
            case 10:
                imageViewTemp.setImageResource(R.drawable.ten);
                currScoreUserTemp += 10;
                break;
            case 11:
                imageViewTemp.setImageResource(R.drawable.eleven);
                currScoreUserTemp += 10;
                break;
            case 12:
                imageViewTemp.setImageResource(R.drawable.twelve);
                currScoreUserTemp += 10;
                break;
            case 13:
                imageViewTemp.setImageResource(R.drawable.thirteen);
                currScoreUserTemp += 10;
                break;
        }

        return currScoreUserTemp;
    }

    void resetImageView() {
        imageViewUser1.setImageResource(R.drawable.cardback);
        imageViewUser2.setImageResource(R.drawable.cardback);
        imageViewUser3.setImageResource(R.drawable.cardback);

        imageViewComputer1.setImageResource(R.drawable.cardback);
        imageViewComputer2.setImageResource(R.drawable.cardback);
        imageViewComputer3.setImageResource(R.drawable.cardback);
    }

    void resetTurnScore() {
        currScoreUser = 0;
        currScoreComputer = 0;
    }

}
