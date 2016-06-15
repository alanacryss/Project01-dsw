package Constants;

public class Constants {
	
	public static String SQL = "insert into cadastro (linguagem,paradigmas,habilidades,anos_exp,certificacao,email) " +
		     "values (?,?,?,?,?,?)";
	
	public static String SQLLOGIN = "insert into login (name, email) " +
		     "values (?,?)";
	
	public static String SQLQUERY = "select * from cadastro where email = ?";
	
	public static String SQLQUERYLOG = "select * from login";
}
