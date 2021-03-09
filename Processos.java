public class Processos {

    private String nome;
    private String estado;
    private int turno;

    // METODO CONSTRUTOR
    public Processos(String nome, String estado, int turno){
        this.setNome(nome);
        this.setEstado(estado);
        this.setTurno(turno);
    }
    // SET, GET
    public void setNome(String nome) {
        this.nome=nome;
    }
    public void setEstado(String estado) {
        this.estado=estado;
    }
    public void setTurno(int turno) {
        this.turno=turno;
    }
    public String getNome(){
        return nome;
    }
    public String getEstado(){
        return estado;
    }    
    public int getTurno(){
        return turno;
    }

    //  METODO QUE IMPRIME OS ATRIBUTOS DOS OBJETOS(SEMAFORO,PROCESSOS).
    public void printProcessos(){
        System.out.println("SEMAFORO: "+ Semaforo.getValor());
		System.out.println("\nNome: "+ this.getNome()+
        "\nTempo: " + this.getTurno() + "\nEstado: " + this.getEstado());
		System.out.println("___________________________________");
        loopProcessos();
    }

    /* METODO QUE ATRIBUI 1 PARA SEMAFORO CASO SEJA FINALIZADO 1 PROCESSO, 
    METODO ONDE LIBERA O SEMAFORO E FINALIZA PROCESSOS*/
    public void up() {

        if(this.getNome()=="P1" && this.getEstado()=="Executando" 
        || this.getNome()=="P2" && this.getEstado()=="Executando"
        || this.getNome()=="P3" && this.getEstado()=="Executando"	
        || this.getNome()=="P4" && this.getEstado()=="Executando"
        || this.getNome()=="P5" && this.getEstado()=="Executando") {
            
            this.setTurno(this.getTurno() - 1);
            if(this.getTurno() == 0) {

                this.setEstado("Finalizado");
                Semaforo.setValor(Semaforo.getValor() + 1);
            } 
        }
    }
    
    /* METODO QUE ATRIBUI 0 PARA SEMAFORO CASO SEJA EXECUTADO 1 PROCESSO, 
    METODO ONDE É TRATADO IS ESTADOS DOS PROCESSOS*/
    public void Down() {
	
        if(Semaforo.getValor() == 1 && this.getEstado() == "Livre") {
        
            System.out.println("\n***********************************"
            + "\n*Processo-" + this.getNome() +" Solicitando recurso!!*\n"
            + "***********************************");
            System.out.println("___________________________________");
            this.setEstado("Executando");
            Semaforo.setValor(Semaforo.getValor() - 1);
    
        }else if (Semaforo.getValor() == 0 && this.getEstado() == "Executando") {
            
            up();

        }else if (Semaforo.getValor() == 0 && this.getEstado() == "Livre") {
            
            this.setEstado("Dormindo");
        
        }else if (Semaforo.getValor() == 1 && this.getEstado() == "Dormindo") {
            
            System.out.println("\n***********************************"
            + "\n*Processo-" + this.getNome() +" Solicitando recurso!!*\n"
            + "***********************************");
            System.out.println("___________________________________");
            this.setEstado("Executando");
            Semaforo.setValor(Semaforo.getValor() - 1);
            
        }
    }
    /* METODO, QUE VERIFICA QUAL PROCESSO VAI ENTRAR, EX: LOOP 0 SOLICITA  E NO 
    LOOP 1 O PROCESSO 1 MUDA O ESTADO, A CADA LOOP OS PROCESSOS IRÃO 
    ENTRANDO*/
    public void loopProcessos() {

		up();
		if(Principal.getAux()==1 && this.getNome()=="P1") {
			System.out.println("++"+Principal.getAux()+"++");
			Down();

		}else if(Principal.getAux()==2 && this.getNome()=="P2") {
			System.out.println("++"+Principal.getAux()+"++");
			Down();

		}else if(Principal.getAux()==3 && this.getNome()=="P3") {
			System.out.println("++"+Principal.getAux()+"++");
			Down();

		}else if(Principal.getAux()==4 && this.getNome()=="P4") {
			System.out.println("++"+Principal.getAux()+"++");
			Down();

		}else if(Principal.getAux()==5 && this.getNome()=="P5") {
			System.out.println("++"+Principal.getAux()+"++");
			Down();

            /* VARIAVEL ESTATICA DECLARADA NA PRINCIPAL. SERVE PARA QUE O QUANDO 
            CHEGAR NO 5 LOOP, ELA ZERE PARA REICINAR.
		    * OU SEJA PASSO PELO P5,ZERA  PARA ENTRAR NO P1.*/
			Principal.setAux(0);
		}	
	}

}