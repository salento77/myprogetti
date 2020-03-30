package gestione.biblioteca.prestito.eccezioni;

import gestione.biblioteca.prestito.base.OperaPrestabile;

@SuppressWarnings("serial")
public class PrestitoNonEseguibile extends Exception{
	
	private OperaPrestabile opera;
	
	public PrestitoNonEseguibile ( OperaPrestabile opera ) {
		
		this.opera = opera;
		
	}
	
	@Override
	public String getMessage() {
		return "Eccezione scattata: fallito il prestito di" +opera.getTitolo();
	}
}
