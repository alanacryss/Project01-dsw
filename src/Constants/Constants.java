package Constants;

public class Constants {
	
	public static String SQL = "insert into cadastro (linguagem,paradigmas,habilidades,anos_exp,certificacao) " +
		     "values (?,?,?,?,?)";
	
	public static String SQLLOGIN = "insert into login (name, email) " +
		     "values (?,?)";
}
