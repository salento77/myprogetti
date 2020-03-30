package gestione.biblioteca.app;

import java.util.Scanner;

import gestione.biblioteca.prestito.Biblioteca;
import gestione.biblioteca.prestito.CD;
import gestione.biblioteca.prestito.Libro;
import gestione.biblioteca.prestito.Studente;

public class MainBiblio {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Biblioteca biblio = new Biblioteca();
		
		Studente stud1 = new Studente ("Claudio", "Rossi");
		Studente stud2 = new Studente ("Elena", "Celesti");
		
		
		Libro testo1 = new Libro("Elettronica 1", 594);
		Libro testo2 = new Libro("Matematica 1", 387);
		Libro testo3 = new Libro("Matematica 2", 487);
	    
		CD cd = new CD ("Canzoni di Natale", 18);
		
		System.out.print("*****MENU' SCELTA*****");
		System.out.print("\n");
		
		Scanner in = new Scanner(System.in);
		
		for (int i = 1; i <= 3; i++)

            System.out.println(i + ". Scelta #" + i);
			System.out.println("0. Esci");
			
			boolean quit = false;
            int menuItem;
		
            do {

                System.out.print("Scegli Opzione: ");

                menuItem = in.nextInt();

                switch (menuItem) {

                case 1:
 
                      System.out.println("\n****Studente1 prende un libro e un CD ****\n");
                      System.out.println("Studente1: "+" "+stud1.getNominativo());
                      biblio.effettuaPrestito(stud1, testo1);
                      System.out.println(testo1.produciScheda());
                      System.out.println("\t");
                      biblio.effettuaPrestito(stud1, cd); 
                      System.out.println(cd.produciScheda()); 
                      System.out.println("\t");
                      biblio.effettuaPrestito(stud1, testo2);
                      System.out.println("\t");
                   
                      break;

                case 2:
                     
                     System.out.println("\n****Studente2 prende un libro ****\n");
                     System.out.println("Studente2: "+stud2.getNominativo());
                     biblio.effettuaPrestito(stud2, testo1);
                     System.out.println("\t");
                     biblio.effettuaPrestito(stud2,testo2);
                     System.out.println(testo2.produciScheda());
                     System.out.println("\t");
                     
                     break;
                     
                case 3:
                	System.out.println("\n****La Biblioteca Segnala un'Opera danneggiata ****\n");
                	System.out.println("\t");
                	biblio.segnalazioneOperaDanneggiata(testo3);
                    System.out.println("\t");
                    
                    break;
                
                case 0:

                      quit = true;
                      System.out.println("\t");

                      break;

                default:

                      System.out.println("Scelta non valida.");

                }

          } while (!quit);

          System.out.println("\n***** situazione finale studenti ****");
          
          System.out.println(stud1);
          System.out.println(stud2);
	}

}
