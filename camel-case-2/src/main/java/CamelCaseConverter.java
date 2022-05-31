
public class CamelCaseConverter {
	public String converter(String nome) {
		// TODO Auto-generated method stub
		return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
	}
}
