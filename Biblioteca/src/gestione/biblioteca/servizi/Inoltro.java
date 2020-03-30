package gestione.biblioteca.servizi;

public class Inoltro<T> {
	
	private T daInoltrare;
	
	public Inoltro(T daInoltrare)
	{
		this.daInoltrare=daInoltrare;
	}
	
	public String stampaScheda () {
		return daInoltrare.toString()+" (inoltro messaggio ok)";
	}
}
