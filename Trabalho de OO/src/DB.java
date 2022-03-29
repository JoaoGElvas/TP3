public class DB {
    private static Dono[] donos = new Dono[50];
    int contadorDonos = -1;
    private Carro[] veiculos = new Carro[50];
    private Receita[] receitas = new Receita[50];
    private Despesa[] despesas = new Despesa[50];
    private Relatorio[] relatorios = new Relatorio[50];
    private Abastecimentos[] abastecimentos = new Abastecimentos[50];
    
    public void InsertDono(String nome){
        if(contadorDonos < 0) contadorDonos++;
        
        donos[contadorDonos] = new Dono(nome);
        donos[contadorDonos].nome();
        contadorDonos++;
    }

    public boolean SearchDono(String nome){
        if(contadorDonos < 0){
            System.out.println("Nao ha registros ainda");
            return false;
        }
    	for(int cont = 0; cont <= contadorDonos; cont++) {
    		if(nome.equals(donos[cont].nome())) {
                System.out.println("Achei");
    			return true;
    		}
    	}
    	System.out.println("Nao achei");
    	return false;
    }
    
}