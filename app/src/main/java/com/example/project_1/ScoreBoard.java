package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project_1.Domain.ScoreBoardDomain;
import com.example.project_1.Service.ScoreFetcher;

import java.util.concurrent.ExecutionException;

public class ScoreBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        ScoreFetcher fetch = new ScoreFetcher();
        try {
            ScoreBoardDomain score = fetch.execute("").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}