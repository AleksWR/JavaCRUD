import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BancoDadosDAO {

    public boolean Erro;
    public int Id;
    public List lista, lista2;
    private String nome, Classificacao;
    private double imc, peso, altura;
    private int idLista;

/////////////////////////////////CONEXÃO COM O BANCO//////////////////////////////////////////////////////
    public void ConexaoComBanco(String comando, boolean Consulta, boolean Paciente, boolean IMC){
        
        try{ 
            String c_user="root";
            String c_senha="";
            String c_fonte="jdbc:mysql://localhost/banco";
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");

            con=DriverManager.getConnection(c_fonte,c_user,c_senha);
            System.out.println("Conexao MS-ACCESS O.K.");

            Statement st = con.createStatement();

            if (Consulta == true){

                ResultSet rs = st.executeQuery(comando);
                
                while(rs.next()){
                    if(Paciente == true){
                        
                        nome=rs.getString("Nome");
                        peso=rs.getDouble("Peso");
                        altura=rs.getDouble("Altura");

                         if (lista!= null){
                             idLista = rs.getInt("Id");
                             lista.addItem("Id = "+ idLista +" NOME = " +nome + "         ALTURA = " +  altura + "         PESO = " + peso);
                            
                         }
                    }
                    if(IMC == true){
                            imc=rs.getDouble("imc");
                            Classificacao=rs.getString("classificacao");
                            if (lista2!= null){
                                lista2.addItem( "         IMC = "+ imc + "         CLASSIFICAÇÃO = " + Classificacao);
                                
                            }
                    } 
                    if (Paciente == false && IMC == false) {
                        Id = rs.getInt("fk_Id");
                    }
                
                   
            }

               if(rs.first() == false){
                    Erro = true;
               }
              
            }else{

                st.executeUpdate(comando);
            }

            con.close(); 
            
        }catch( Exception e) { 
            System.out.println("Erro na Abertura do banco de Dados" + e); 
            Erro = true;

        }         
    }


///////////////////////////////////////OPERAÇÕES COM O BANCO//////////////////////////////////////////////////////



    public void AdicionaNoBanco(String nome, String email, String senha, double peso, double altura, double IMC, String Classificacao){

        String select = "(SELECT Id FROM paciente ORDER BY ID DESC LIMIT "+ 1+"), ";
        String comando2 = "INSERT INTO login(fk_Id, login, senha) values ("+ select + "'" + email +"', "+"'" + senha+ "' " + ");";
        String comando = "INSERT INTO paciente(Nome, Peso, Altura) values ('" +nome+"', " + peso + ", "+ altura + ");";
        String comando3 = "INSERT INTO imc (fk_IdP, imc, classificacao) values ("+select +IMC+ ", '"+ Classificacao+"'"+ ");";
       
        ConexaoComBanco(comando, false, false, false);
        ConexaoComBanco(comando2, false, false, false);
        ConexaoComBanco(comando3, false, false, false);


    }



    public void RemoveDoBanco(int idArray){
        String comando = "DELETE FROM login WHERE fk_Id = "+idArray;
        String comando2= "DELETE FROM paciente WHERE Id = "+idArray;
        String comando3= "DELETE FROM imc WHERE fk_IdP = "+idArray;
        ConexaoComBanco(comando3, false, false, false);
        ConexaoComBanco(comando, false, false, false);
        ConexaoComBanco(comando2, false, false, false);

    }


    public void AtualizaBanco(String email, String senha, double pesoNovo, double alturaNovo, double imc, String classificacao){
        String select = "SELECT fk_Id FROM login WHERE login = '"+email+"' AND senha = " + "'" + senha + "'";
        ConexaoComBanco(select, true, false, false);
        String comando = "UPDATE paciente SET Peso= "+pesoNovo+", Altura = " +alturaNovo + " WHERE Id= "+Id+ "";
        ConexaoComBanco(comando, false, false, false);
        String comando2 = "UPDATE imc SET imc = "+imc+", classificacao= '" + classificacao + "' WHERE fk_idP= "+Id+ "";
        ConexaoComBanco(comando2, false, false, false);
    }


    public void ConsultaBanco(){

        String comando = "SELECT Id,Nome, Altura, Peso FROM paciente";
        String comando2 =  "SELECT imc, classificacao FROM imc";
        ConexaoComBanco(comando, true, true, false);
        ConexaoComBanco(comando2, true, false, true);

    }


    public void ConsultaBanco(String email, String senha){
        String select = "SELECT fk_Id FROM login WHERE login = '"+email+"' AND senha = " + "'" + senha + "'";
        ConexaoComBanco(select, true, false, false);
        String comando = "SELECT Nome, Altura, Peso FROM paciente WHERE Id = "+Id;
        ConexaoComBanco(comando, true, true, false);
        String comando2 = "SELECT imc, classificacao FROM imc WHERE fk_IdP = "+Id;
        ConexaoComBanco(comando2, true, false, true);

    }


    public String getNome(){
        return nome;
    }
    public double getPeso(){
        return peso;
    }
    public double getAltura(){
        return altura;
    }
    public double getImc(){
        return imc;
    }
    public String getClassificacao(){
        return Classificacao;
    }
    public int getId(){
        return idLista;
    }
    public void SetLista(List lista, List lista2){
        this.lista = lista;
        this.lista2 = lista2;
    }
    public List getLista(){

        return this.lista;
    }
    public List getListaIMC(){

        return this.lista2;
    }



}

