package objects;

import java.util.Arrays;
import java.util.Comparator;

public class Checker implements Comparator<Player>{

	@Override
	public int compare(Player p1,Player p2) {
		if(p1.score>p2.score)return -1;
		else if(p1.score<p2.score)return 1;
		else {
			return p1.name.compareTo(p2.name);
		}
	}
	
	public static void main(String[] args) {
		Player p1 = new Player("stuatr",3);
		Player p2 = new Player("rajesh",4);
		Player p3 = new Player("amresh",3);
		
		Player arr[]= {p1,p2,p3};
		Arrays.sort(arr,new Checker());
		Arrays.stream(arr).forEach(System.out::println);
	}
}


class Player{
	public Player(String string, int i) {
		this.name = string;
		this.score=i;
	}
	int score;
	String name;
	@Override
	public String toString() {
		return "Player [score=" + score + ", name=" + name + "]";
	}
	
	
}