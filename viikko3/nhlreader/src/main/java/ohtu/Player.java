
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private String nationality;
    private String birthdate;
    private int goals;
    private int assists;
    private int penalties;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return team;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    private String rightPad() {
        return String.format("%-18s", name);
    }

    @Override
    public String toString() {
        return rightPad() + "\t" + team + "\t" + goals + " + " + assists + " = " + (goals+assists);
    }

    @Override
    public int compareTo(Player p) {
        return (p.goals + p.assists) - (this.goals + this.assists);
    }
      
}
