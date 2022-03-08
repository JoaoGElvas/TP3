import java.util.Iterator;

public class Dados_Aleatorios {
    private Dono[] donos = new Dono[5];
    private Carro[] veiculos = new Carro[5];
    private Receita[] receitas = new Receita[5];
    private Despesa[] despesas = new Despesa[5];
    private Relatorio[] relatorios = new Relatorio[5];
    private Abastecimentos[] abastecimentos = new Abastecimentos[5];


    void fillWithData(){
        for (int i = 0; i < 5; i++) {
        	donos[i] = new Dono("Dono "+i);
            veiculos[i] = new Carro("Veiculo "+i , "Marca "+i , "Modelo "+i);
            receitas[i] = new Receita("Receita "+i , 2.5 , "Observação "+i);
            despesas[i] = new Despesa("Despesa "+i , 3.5 , "Observação "+i);
            relatorios[i] = new Relatorio("Relatorio "+i , 10.50);
            abastecimentos[i] = new Abastecimentos(30.6, 45.7, 56.8);
          
		}
    }

    void showData(){
        for (int i = 0; i < 5; i++) {
            System.out.println(donos[i]);
            System.out.println(veiculos[i]);
            System.out.println(receitas[i]);
            System.out.println(despesas[i]);
            System.out.println(relatorios[i]);
            System.out.println(abastecimentos[i]);

        }
    }
}
