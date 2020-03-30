package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;
import gestione.biblioteca.prestito.base.OperaPrestabile;
import gestione.biblioteca.prestito.eccezioni.PrestitoNonEseguibile;
import gestione.biblioteca.servizi.Inoltro;
import gestione.biblioteca.servizi.ServizioRiparazione;

public class Biblioteca {
	
	private ServizioRiparazione riparazioni = new ServizioRiparazione();
	
	public void effettuaPrestito(Studente studente, OperaPrestabile daPrendere)
	{
		if (daPrendere.inPrestito())
		{
			System.out.println("Volume già in prestito");
			return;
		}
		else if (!studente.prestitiDisponibili())
		{
			System.out.println("Prestito NON possibile (numero prestiti esauriti): "+daPrendere.getTitolo());
			return;
		}
				
		try 
		{
			studente.creaPrestito(daPrendere);
			{
				System.out.println("Prestito effettuato: "+daPrendere.getTitolo());
				daPrendere.collocazioneInPrestito();
			}
					
		}
		catch ( PrestitoNonEseguibile e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void restituzioneDalPrestito(Studente studente, OperaPrestabile daRestituire)
	{
		if (studente.restituzionePrestito(daRestituire))
		{
			System.out.println("Prestito concluso: "+daRestituire.getTitolo());
			daRestituire.restituzioneDalPrestito();
		}
		else
			System.out.println("Errore in restituzione");
			
		
	}
	
	public void segnalazioneOperaDanneggiata(Opera danneggiata) {
		Inoltro<Opera> inoltro = new Inoltro<>(danneggiata);
		String ricevuta = riparazioni.ricezioneInoltro(inoltro);
		System.out.println(ricevuta);
	}
	

}