package cartes;

public class Borne extends Carte {
	
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return km + "KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (obj == null || obj.getClass() != getClass())
			return false;
		Borne carteBorne = (Borne) obj;
		return carteBorne.km == km;
	}
	
	@Override
	public int hashCode() {
	    return java.util.Objects.hash(getClass(), km);
	}
}
