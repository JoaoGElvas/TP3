/**
 * Classe relatorio
*/

public class Relatorio {
    double  custo, receita, saldo, despesa, mediaAbastecimento, mediaDespesa, mediaReceita , abastecimento;
    int contAbastecimento = 0;
    int contDespesa = 0;
    int contReceita = 0;
    public Relatorio(Veiculo car){
        abastecimentoTotal(car);
        receitaTotal(car);
        despesaTotal(car);
        mediaGeral(car);
        
        
        this.saldo = this.custo < this.receita ? this.receita - this.custo : -1 * (this.custo - this.receita);
		System.out.println("Custo total: " +  this.custo);
		System.out.println("Receita: " + this.receita);
		System.out.println("Saldo: " + this.saldo);
		
	}
    
    double getSaldo(){
        return this.saldo;
    }
    
    /**
     * Calcula o abastecimento total de um veiculo
     * @param Veiculo veiculo para calcular o abastecimento total
     * @return double
    */
    
	double abastecimentoTotal(Veiculo carVeiculo){
        for (int i = 0; carVeiculo.abastecimentos[i] != null; i++) {
            this.custo = this.custo + carVeiculo.abastecimentos[i].getValor();
            this.abastecimento = this.abastecimento + carVeiculo.abastecimentos[i].getValor();
            contAbastecimento ++;
        }
        
        return this.custo;
	}
	
	/**
     * Calcula a receita total de um veiculo
     * @param Veiculo veiculo para calcular a receita total
     * @return double
    */
	double receitaTotal(Veiculo carVeiculo){
        for (int i = 0; carVeiculo.receitas[i] != null; i++) {
            this.receita = this.receita + carVeiculo.receitas[i].getValor();
            contReceita++;
        }
        
        return this.receita;
    }

    double getReceita(){
        return this.receita;
    }
    
    /**
     * Calcula a despesa total de um veiculo
     * @param Veiculo veiculo para calcular a despesa total
     * @return double
    */
    double despesaTotal(Veiculo carVeiculo){
		for (int i = 0; carVeiculo.despesas[i] != null; i++) {
            this.custo = this.custo + carVeiculo.despesas[i].getValor();
            this.despesa = this.despesa + carVeiculo.despesas[i].getValor();
            contDespesa++;
        }
        
        return this.despesa;
    }

    double getDespesa(){
        return this.despesa;
    }
    
    /**
     * Calcula a media geral dos abastecimentos, despesas e receitas total de um veiculo
     * @param Veiculo veiculo para calcular a media geral
     * @return void
    */
    void mediaGeral(Veiculo carVeiculo) {
       this.mediaAbastecimento = this.abastecimento / contAbastecimento;
       this.mediaDespesa = this.despesa / contDespesa;
       this.mediaReceita = this.receita / contReceita;
    }
    
    

    double getCustoTotal(){
        return this.custo;
    }

    double getMediaAbastecimento() {
    	return this.mediaAbastecimento;
    }
    
    double getMediaDespesa() {
    	return this.mediaDespesa;
    }
    
    double getMediaReceita() {
    	return this.mediaReceita;
    }
   
}
