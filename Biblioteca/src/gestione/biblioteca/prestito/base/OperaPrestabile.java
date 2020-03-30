package gestione.biblioteca.prestito.base;

public abstract class OperaPrestabile extends Opera implements Prestabile{
	
	private boolean inPrestito;
	
	protected OperaPrestabile(String titolo)
	{
		super(titolo);
	}
	
	public boolean inPrestito()
	{
		return inPrestito;
	}
	
	
	public void collocazioneInPrestito()
	{
		inPrestito=true;
	}
	
	public void restituzioneDalPrestito()
	{
		inPrestito=false;
	}
	
	public String getTitolo()
	{
		return titolo;
	}
	
	public abstract String produciScheda();
	
	@Override
	public String toString() {
		return titolo+"\n"+
			   ( (inPrestito)?"Attualmente in prestito":"Non in prestito" );
	}
}
