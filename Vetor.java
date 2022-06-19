
public class Vetor {
	private LinkedList[] acoes = new LinkedList[10];
	private int totaldeAcoes = 0, transacoes = 0, capital_obtido = 0, dinheiro=2000;
	
	void comprar (LinkedList acao) {
		
		for (int i=0; i < this.acoes.length; i++) {
			//a posicao está livre?
			if (this.acoes[i]==null) {
				this.acoes[i] = acao;
				this.totaldeAcoes += acao.getQnt();
				this.transacoes++;
				break;
			}
		}
		dinheiro -= acao.getQnt() * acao.getValor();
	}
	
	void vender(int qnt_vendida, int valor_venda) {
		for (int i=0; i < this.acoes.length-1; i++) {
			if (this.acoes[i]==null) 
			{
				break;
			}
			else {
				if(this.acoes[i].getQnt() >= qnt_vendida){
					capital_obtido += qnt_vendida * (valor_venda - this.acoes[i].getValor());
					totaldeAcoes -= qnt_vendida;
					this.acoes[i].setQnt(this.acoes[i].getQnt() - qnt_vendida);
					qnt_vendida = 0;
				}
				else{
					capital_obtido += this.acoes[i].getQnt() * (valor_venda - this.acoes[i].getValor());
					totaldeAcoes -= this.acoes[i].getQnt();
					qnt_vendida = (qnt_vendida - this.acoes[i].getQnt());
					this.acoes[i].setQnt(0);
				}	
			}
					
		}
		this.totaldeAcoes -= qnt_vendida;
		this.transacoes++;
		this.dinheiro += capital_obtido;
		System.out.println("\nQuantidade de ações restantes é " + this.totaldeAcoes + " e o Capital obtido foi : R$ " + this.capital_obtido + ",00");
	}
	
	void MostrarCarteira(){
		System.out.println("\nQuantidade de ações na carteira: " + this.totaldeAcoes);
		System.out.println("Quantidade de transações realizadas (compra/venda): " + this.transacoes);
		System.out.println("\nSaldo disponível para compra de ações : " + this.dinheiro);
	} 

	int transacoes() {
		return this.transacoes;
	}

	int deposito(int saldo){
		dinheiro += saldo;
		return this.dinheiro;
	}

	int valornaconta(){
		return this.dinheiro;
	}
	int totaldeAcoes(){
		return this.totaldeAcoes;
	}
	
	public String toString() {
		if (this.transacoes == 0) {
			return "[]";
		}
		
		StringBuilder saida = new StringBuilder();
		
		saida.append("[");
		
		for (int p=0; p<this.transacoes-1; p++) {
			saida.append(this.acoes[p]);
			saida.append(", ");
		}
		
		saida.append(this.acoes[this.transacoes-1]);
		saida.append("]");
			
		return saida.toString();
	}
}
















