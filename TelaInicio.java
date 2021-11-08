import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaInicio extends JFrame{

Container janelaInicio;

public TelaInicio(){
    
       janelaInicio = getContentPane();
       janelaInicio.setLayout(null);

       
       
       JButton botaoCadastrar = new JButton("Cadastrar");
       janelaInicio.add(botaoCadastrar);
       botaoCadastrar.setBounds(150,80,100,30);

       JButton botaoLogin = new JButton("Login");
       janelaInicio.add(botaoLogin);
       botaoLogin.setBounds(150,130,100,30);



       botaoCadastrar.addMouseListener( new MouseAdapter() {
      public void mouseClicked(MouseEvent evento) {
                TelaCadastro telacadastro = new TelaCadastro();
                dispose();
             }

             }
             );

        botaoLogin.addMouseListener( new MouseAdapter() {
      public void mouseClicked(MouseEvent evento) {
                  TelaLogin telalogin = new TelaLogin();
                  dispose();
             }
             }
             );



       setTitle("IMC - Inicio");
       setSize(400,300);
       setVisible(true);

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

}

       
        public static void main(String args[]){
            TelaInicio app = new TelaInicio();

            BancoDadosDAO bancoDados = new BancoDadosDAO();

            //bancoDados.AdicionaNoBanco("Alekao","alekao@gmail.com", "alekao123", 70, 1.77);
            //bancoDados.AdicionaNoBanco("Caxera","caxa@gmail.com", "caxa123", 50, 1.73);
           
            //bancoDados.RemoveDoBanco("caxa@gmail.com",  "caxa123");
            //bancoDados.AtualizaBanco("alekao@gmail.com", "alekao123", 80, 1.80);
              bancoDados.ConsultaBanco();


            




            
        }




}