public class LoginCliente {
    
    public boolean Erro;

    public void LogarCliente(String email, String senha){

            BancoDadosDAO bancoDeDadosLogin = new BancoDadosDAO();

            bancoDeDadosLogin.ConsultaBanco(email, senha);

            if (bancoDeDadosLogin.Erro == true){
                Erro = bancoDeDadosLogin.Erro;
 
         }


    }




}
