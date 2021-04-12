package com.example.project_1.Service;

import android.os.AsyncTask;

import com.example.project_1.Domain.ScoreBoardDomain;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

public class ScoreFetcher extends AsyncTask<String,Void, ScoreBoardDomain> {

    String scoreJson;
    String uniqueId = "";
    ScoreBoardDomain board;
    @Override
    protected ScoreBoardDomain doInBackground(String... strings) {

        try {

            URL url = new URL("https://cricapi.com/api/cricketScore?unique_id=+"+uniqueId+"+&&apikey=94oEvY0JjrZQLjuUdHnYglfxduh1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                scoreJson = output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        board = ScoreBoardDomain.createScoreBoard(scoreJson);
        return board;
    }
    }

