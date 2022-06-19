import java.util.Objects;

public class LinkedList {
	
	private int qnt, valor;
	
	public LinkedList(int qnt, int valor){
		this.qnt = qnt;
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(qnt, valor);
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	@Override
	public String toString() {
		return "qnt: " + this.qnt;
		
	}

}
