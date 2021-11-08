public class CadastraCliente {
        public boolean Erro;

    public void CadastrarCli(String nome, String email, String senha, double altura, double peso, double IMC, String Classificacao){

        BancoDadosDAO bancodadosAdiciona = new BancoDadosDAO();
        bancodadosAdiciona.AdicionaNoBanco(nome, email, senha, peso, altura, IMC, Classificacao);
        
        if (bancodadosAdiciona.Erro == true){
               Erro = bancodadosAdiciona.Erro;

        }
    }


    
}
