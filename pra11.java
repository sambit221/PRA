// qs-11
import java.util.*;
class Player{
    private int playerId ;
    private int points;
    private String level;
    private String skill; 

    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    } 
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getSkill() {
        return skill;
    }
    public void setSkill(String skill) {
        this.skill = skill;
    }
    Player(int playerId, String skill, String level, int points){
        this.playerId=playerId;
        this.skill=skill;
        this.level=level;
        this.points=points;
    }
}
public class pra11 {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        Player[] pl=new Player[n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt(); sc.nextLine();
            // int id=Integer.parseInt(s);
            String skill= sc.nextLine();//sc.nextLine();
            if(skill.equals("\n"))System.out.println("ok bitch");
            String level=sc.nextLine(); //sc.nextLine();
            int points=sc.nextInt(); sc.nextLine();
            pl[i]= new Player(id,skill,level,points);
            System.out.println("id is: "+id+" skill: "+skill+" level: "+ level+" points: "+points);
        } 
        String sk=sc.nextLine(); //System.out.println("sk is "+sk);
        String lev=sc.nextLine(); //System.out.println("lev is "+lev);
        System.out.println("pt for given skill "+ findPointsForGivenSkill(pl,sk));
        System.out.println("player based on level : "+getPlayerBasedOnLevel(lev,sk,pl).getPlayerId());
        sc.close();
}

    public static int findPointsForGivenSkill (Player[] pl, String sk){ 
        int c=0;
        for(Player p:pl){
            if(p.getSkill().equals(sk)){c+=p.getPoints();}
        } return c;
    }

    public static Player getPlayerBasedOnLevel (String level, String skill, Player[] pl){
        for(Player p:pl){
            if(p.getLevel().toLowerCase().equals(level.toLowerCase()) && p.getSkill().toLowerCase().equals(skill.toLowerCase()) && p.getPoints()>=20){
                return p;
            }
        }
        return null;
    }
}

/* Input 
4
101
Cricket
Basic
20
102
Cricket
Intermediate
25
111
Football
Intermediate
50
113
BaseBall
Advanced
100
Cricket
Intermediate
 */

 /* Output-------------------
  id is: 101 skill: Cricket level: Basic points: 20
id is: 102 skill: Cricket level: Intermediate points: 25
id is: 111 skill: Football level: Intermediate points: 50
id is: 113 skill: BaseBall level: Advanced points: 100
pt for given skill 45
player based on level : 102
  */