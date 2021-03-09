public class Principal {
    
    private static int aux=0;
    //	GET SET
    public static void setAux(int aux) {
        Principal.aux = aux;
    }
    public static int getAux() {
        return aux;
    }

    public static void main(String[] args) {
        
        // PROCESSOS 
        Processos p1= new Processos("P1","Livre",1);
        Processos p2= new Processos("P2","Livre",5);
        Processos p3= new Processos("P3","Livre",4);
        Processos p4= new Processos("P4","Livre",3);
        Processos p5= new Processos("P5","Livre",2);

        // INDICE DO LOOP. PARA ORIENTAÇÃO APENAS
		int indice = 0;

        // LOOP INFINITO
	    while (true) {
            
            if (p1.getEstado() != "Finalizado" || p2.getEstado() != "Finalizado" 
            || p3.getEstado() != "Finalizado" || p4.getEstado() != "Finalizado" 
            || p5.getEstado() != "Finalizado") {
		        
                p1.printProcessos();
				p2.printProcessos();
				p3.printProcessos();
				p4.printProcessos();
				p5.printProcessos();

			} else {
				System.out.println("Todos os processos finalizados!\n");
				
                p1.printProcessos();
                p1.printProcessos();
                p1.printProcessos();
                p1.printProcessos();
                p1.printProcessos();

				break;
		}
			System.out.println("\n--------------" + indice + "* Loop--------------\n");
            // INCREMENTO, E ATRIBUIÇÃO 	
			Principal.setAux(Principal.getAux()+1);
			++indice;
        }

    }
}
