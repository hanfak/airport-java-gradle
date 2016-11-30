
public class Weather {
	public boolean isStormy(){
		return randomNumber() > 8;
	}
	
	protected int randomNumber() {
		return (int)(Math.random() * (9) + 1);
	}
}
