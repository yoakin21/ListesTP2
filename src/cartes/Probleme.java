package cartes;

public class Probleme extends Carte {
	private Type type;
	
	protected Probleme (Type type) {
		this.type = type;
	}
	
	
	public Type getType() {
		return type;
	}
	
	@Override 
	public String toString() {
		return type.name();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (obj!=null && getClass().equals((obj).getClass())) {
			Probleme probleme = (Probleme) obj;
			return type==probleme.getType();
		}
		return false;
	}
}
