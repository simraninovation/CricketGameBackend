package com.tekion.cricket.service;

import com.tekion.cricket.dto.matchrequest.MatchResultDto;
import com.tekion.cricket.dto.matchrequest.NewMatchDto;
import com.tekion.cricket.entity.*;
import com.tekion.cricket.repository.InningsRepository;
import com.tekion.cricket.repository.MatchesRepository;
import com.tekion.cricket.repository.TeamRepository;
import com.tekion.cricket.repository.TossRepository;
import com.tekion.cricket.utils.ScorecardGenerator;
import com.tekion.cricket.utils.TossUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchesServiceImpl implements MatchesService{
    @Autowired
    private MatchesRepository matchesRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private InningsRepository inningsRepository;
    @Autowired
    private TossRepository tossRepository;
    @Override
    public void save(Matches matches) {
        matchesRepository.save(matches);
    }
    public static Map<String, Object> playInnings(Team teamA, Team teamB, int oversForAMatch, Long matchId){
        Innings inningsDetails = new Innings();
        List<Object> result = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        int wicket = 0;
        int event = 0;
        int totalScores = 0;
        int runs = 0;
        int ballsPerOver = 0;
        int OverTillNow=1;
        String ballStats ="";
        List<BallSummary> ballDetailsList = new ArrayList<>();
        List<PlayerStats> playerDetails = new ArrayList<>();

        Long totalBalls = 0L;
        Long totalRuns = 0L;
        Long extraRuns = 0L;

        for(Players batsman : teamA.getPlayer()){
            PlayerStats playerStat = new PlayerStats();
            playerStat.setPlayers(batsman);
            boolean wicketTaken = false;
            for (int over = OverTillNow; over <= oversForAMatch; over++) {
                BallSummary ballDetail = new BallSummary();
                ballDetail.setCurrentOver(over);
                for (int ball = 1; ball <= 6; ball++) {
                    totalBalls++;
                    String eve = ScorecardGenerator.getRandomScore();
                    if (wicket < 10) {
                        if (eve.equals("W")) {
                            wicketTaken = true;
                            playerStat.setRunScored(runs);
                            runs = 0;
                            wicket++;
                            ballStats += "W ";
                            playerStat = new PlayerStats();
                            break;
                        } else {
                            event = Integer.parseInt(eve);
                            if (wicket <= 10) {
                                totalScores = totalScores + event;
                                runs = runs + event;
                                ballStats += (eve + " ");
                            }
                        }
                       // System.out.println("Total ballDetail: " + ballDetail);
//                        ballNo++;
                    }
                    else {
                        break;
                    }
                }
                ballStats="";
                ballDetail.setOutcomeOfBall(ballStats);
                ballDetailsList.add(ballDetail);
                //if (ballsPerOver == 6) {
//                    oversPerRun++;
                   // ballsPerOver = 0;
                //}
                OverTillNow = over;
                if(wicketTaken == true)
                    break;
            }
            playerDetails.add(playerStat);
        }

        int totalWickets = 0;
        int totalOvers = 0;
        int maxWicketsAllowed = 10;
        int overBowledCount = 0;
        Random random = new Random();

        for (int i = 5; i < teamB.getPlayers().size(); i++) {
            Players bowler = teamB.getPlayers().get(i);
            PlayerStats playerStat = new PlayerStats();
            playerStat.setPlayers(bowler);

            int wicketsTaken = 0;
            int oversBowled = 0;
            int oversPerBowler = 0;
            oversPerBowler = (oversForAMatch > 20) ? 10 : 4;

            while (wicketsTaken < maxWicketsAllowed && totalOvers < oversForAMatch && oversBowled < oversPerBowler) {
                int wicketProbability = random.nextInt(10);
                if (wicketProbability < 2 && totalWickets < maxWicketsAllowed) {
                    wicketsTaken++;
                    totalWickets++;
                }
                oversBowled++;
                totalOvers++;
            }
            overBowledCount += oversBowled;
            if(i == teamB.getPlayers().size() - 1 && totalWickets < maxWicketsAllowed){
                wicketsTaken = maxWicketsAllowed - totalWickets;
            }
            playerStat.setWicketTaken(wicketsTaken);
            playerStat.setBallIsBowled(oversPerBowler*6);
            playerStat.setOverIsBowled(oversPerBowler);
            playerDetails.add(playerStat);
        }
        inningsDetails.setWicketsFallen(wicket*1L);
        inningsDetails.setExtraRuns(extraRuns);
        inningsDetails.setBallingTeamId(teamB.getTeamId());
        inningsDetails.setBattingTeamId(teamA.getTeamId());
        inningsDetails.setNoOfNoBalls(0L);
        inningsDetails.setNoOfWideBalls(0L);
        inningsDetails.setInnStatus(1L);
        inningsDetails.setTotalScore(totalScores*1L);
        response.put("inningsDetails",inningsDetails);
        response.put("playerStats",playerDetails);
        return response;
    }
    public static Map<String, Object> matchResult(Team teamA, Team teamB, int matchOvers, Long matchId) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> innings = playInnings(teamA, teamB, matchOvers, matchId);
        response.put("inningsDetails", innings.get("inningsDetails"));
        response.put("overDetails", innings.get("overDetails"));
        return response;
    }
    @Override
    public MatchResultDto playTheMatch(NewMatchDto request){
        MatchResultDto matchResultDto = new MatchResultDto();
        Long matchId = request.getMatchId();
        Long team1 = request.getTeamA();
        Long team2 = request.getTeamB();
        int matchOvers = request.getMatchOvers();
        Optional<Team> teamA = teamRepository.findById(team1);
        Optional<Team> teamB = teamRepository.findById(team2);
        Toss tossWnner = TossUtil.tossSetup(teamA.get(),teamB.get());

        Map<String, Object> res = matchResult(teamA.get(), teamB.get(), matchOvers, 1L);
        Map<String, Object> res1 = matchResult(teamB.get(), teamA.get(), matchOvers, 2L);
        Innings firstInningsDetails = (Innings) res.get("inningsDetails");
        Innings secondInningsDetails = (Innings) res1.get("inningsDetails");
        Matches matches = new Matches();
        matches.setMatchId(matchId);
        firstInningsDetails.setMatches(matches);
        secondInningsDetails.setMatches(matches);

        Long teamAResult = firstInningsDetails.getTotalScore();
        Long teamBResult = secondInningsDetails.getTotalScore();

        String result = Optional.of(teamAResult - teamBResult)
                .filter(differences -> differences > 0)
                .map(differences -> "Team " + teamA.get().getTeamName() + " Won the match by : " + differences + " runs")
                .orElseGet(() -> teamAResult == teamBResult ? "Match Drawn!" : "Team " + teamB.get().getTeamName() + " Won the match by : " + Math.abs(teamAResult - teamBResult) + " runs");

        System.out.println(result);

        matchResultDto.setMatchId(matchId);
        matchResultDto.setTeamA(team1);
        matchResultDto.setTeamB(team2);
        if(teamAResult > teamBResult)
            matchResultDto.setTeamIdWhoWonMatch(team1);
        else
            matchResultDto.setTeamIdWhoWonMatch(team2);
        matchResultDto.setTeamIdWonToss(tossWnner.getTeamIdWonToss());

        matches.setMatchId(matchId);
        matches.setTeamA(teamA.get());
        matches.setTeamB(teamB.get());
        if(teamAResult > teamBResult)
            matches.setTeamIdWhoWonMatch(team1);
        else
            matches.setTeamIdWhoWonMatch(team2);
        matches.setTeamIdWonToss(team1);

        Matches matchesRes = matchesRepository.save(matches);
        Innings innings1 = inningsRepository.save(firstInningsDetails);
        Innings innings2 = inningsRepository.save(secondInningsDetails);
        Toss toss = tossRepository.save(tossWnner);
        return matchResultDto;
    }

}
