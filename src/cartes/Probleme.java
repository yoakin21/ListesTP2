package cartes;

public class Probleme extends Carte {
	private Type type;
	
	public Probleme (Type type) {
		this.type = type;
	}
	
	
	public Type getType() {
		return type;
	}
	
	@Override 
	public String toString() {
		return type.name();
	}
}
