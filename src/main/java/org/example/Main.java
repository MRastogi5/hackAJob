package org.example;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {
    public static void main(String[] args) {
        System.out.println(run("arsenal"));

    }

    // The teamKey is the name of the team eg "arsenal"
    public static int run(String teamKey) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        //teamKey = "arsenal";
        Season season = null;
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            Gson gson = new Gson();
            season = gson.fromJson(result.toString(), Season.class);

            if(null != season.getRounds()){
                System.out.println("Season rounds not null");
            }
            else {
                System.out.println("Season rounds null");
            }

        } catch (Exception e) {

        }
        int goals = 0;




        Round[] rounds = season.getRounds();
        for (Round round :rounds) {
            Match[] matches = round.getMatches();
            for(Match match : matches){
                if(match.getTeam1().getKey().equals(teamKey)){
                    goals+=match.getScore1();
                }
                if(match.getTeam2().getKey().equals(teamKey)){
                    goals+=match.getScore2();
                }
            }
        }
        System.out.println(goals);
        return goals;
    }
}


class Team{
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String key ;
    private String name ;
    private String code ;

}

class Match{
    private String date;
    private Team team1;
    private Team team2;
    private int score1;
    private int score2;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}

class Round{
    private String name;
    private Match[] matches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }
}
class Season{

    private String name;
    private Round[] rounds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Round[] getRounds() {
        return rounds;
    }

    public void setRounds(Round[] rounds) {
        this.rounds = rounds;
    }
}