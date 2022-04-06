public class Relatorio {
    double custo, receita, saldo, despesa, mediaAbastecimento, mediaDespesa, mediaReceita;
    int contAbastecimento = 0;
    int contDespesa = 0;
    int contReceita = 0;
    public Relatorio(Veiculo car){
        abastecimentoTotal(car);
        receitaTotal(car);
        despesaTotal(car);
        
		System.out.println("Custo total: " +  this.custo);
		System.out.println("Receita: " + this.receita);
		
        this.saldo = this.custo < this.receita ? this.receita - this.custo : this.custo - this.receita;
		System.out.println("Saldo: " + this.saldo);
	}
    
    
    
	double abastecimentoTotal(Veiculo carVeiculo){
        for (int i = 0; carVeiculo.abastecimentos[i] != null; i++) {
            this.custo = this.custo + carVeiculo.abastecimentos[i].getValor();
            contAbastecimento ++;
        }
        
        return this.custo;
	}
	
	double receitaTotal(Veiculo carVeiculo){
        for (int i = 0; carVeiculo.receitas[i] != null; i++) {
            this.receita = this.receita + carVeiculo.receitas[i].getValor();
            contReceita++;
        }
        
        return this.receita;
    }
    	
    double despesaTotal(Veiculo carVeiculo){
		for (int i = 0; carVeiculo.despesas[i] != null; i++) {
            this.custo = this.custo + carVeiculo.despesas[i].getValor();
            contDespesa++;
        }
        
        return this.despesa;
    }
    
    
    void mediaGeral(Veiculo carVeiculo) {
       double mediaAbastecimento = abastecimentoTotal(carVeiculo) / contAbastecimento;
       double mediaDespesa = despesaTotal(carVeiculo) / contDespesa;
       double mediaReceita = receitaTotal(carVeiculo) / contReceita;
    }



    void gerarRelatorio(){
        
    }
}
