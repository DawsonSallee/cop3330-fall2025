public class Player implements Comparable<Player> {

    public int score;

    public Player (int score) {
        this.score = score;
    }
    public static void main(String[] args) {

        Player player = new Player(5);

        int result = player.compareTo(new Player(6));

        System.out.println(result);
    }

    @Override 
    public int compareTo(Player other) {
        return other.score - this.score;
    }
}