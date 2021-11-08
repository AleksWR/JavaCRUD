import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastro extends JFrame{

	public TelaCadastro(){
        Container janelaCadastro = getContentPane();
        janelaCadastro.setLayout(null);

      
        JLabel lblNome = new JLabel("Nome:");
        janelaCadastro.add(lblNome);
        lblNome.setBounds(70,0,45,20);

        JLabel lblEmail = new JLabel("E-mail:");
        janelaCadastro.add(lblEmail);
        lblEmail.setBounds(70,30,45,20);
        

        JLabel lblSenha = new JLabel("Senha:");
        janelaCadastro.add(lblSenha);
        lblSenha.setBounds(70,60,45,20);
	

        JLabel lblCSenha = new JLabel("Confirmar Senha:");
        janelaCadastro.add(lblCSenha);
        lblCSenha.setBounds(10,90,100,20);

        JLabel lblPeso = new JLabel("Peso:");
	    	janelaCadastro.add(lblPeso);
	     	lblPeso.setBounds(70,120,45,20);

        JLabel lblAltura = new JLabel("Altura:");
		    janelaCadastro.add(lblAltura);
		    lblAltura.setBounds(70,150,45,20);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JTextField txtNome = new JTextField();
        janelaCadastro.add(txtNome);
        txtNome.setBounds(115,0,200,20);

	 	    JTextField txtEmail = new JTextField();
        janelaCadastro.add(txtEmail);
        txtEmail.setBounds(115,30,200,20);
        

        JPasswordField txtSenha = new JPasswordField();
        janelaCadastro.add(txtSenha);
        txtSenha.setBounds(115,60,200,20);
      
        
        JPasswordField txtConfirmarSenha = new JPasswordField();
        janelaCadastro.add(txtConfirmarSenha);
        txtConfirmarSenha.setBounds(115,90,200,20);

        JTextField txtPeso = new JTextField();
        janelaCadastro.add(txtPeso);
        txtPeso.setBounds(115,120,200,20);

        JTextField txtAltura = new JTextField();
        janelaCadastro.add(txtAltura);
        txtAltura.setBounds(115,150,200,20);

        JButton botaoConfirmar = new JButton("Confirmar");
        janelaCadastro.add(botaoConfirmar);
        botaoConfirmar.setBounds(215,180,100,30);

        JButton botaoCancelar = new JButton("Cancelar");
        janelaCadastro.add(botaoCancelar);
        botaoCancelar.setBounds(115,180,90,30);



          botaoCancelar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evento) {
                        TelaInicio telainicio = new TelaInicio();
                        dispose();
                    }
              }

              
          );


          botaoConfirmar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evento) {

                      String nome = new String(txtNome.getText());
                      String email = new String(txtEmail.getText());
                      String senha = new String(txtSenha.getPassword());
                      String confirmasenha = new String(txtConfirmarSenha.getPassword());
                      double peso =  Double.parseDouble((txtPeso.getText()));
                      double altura = Double.parseDouble((txtAltura.getText()));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                      


                      CadastraCliente cadastraCliente = new CadastraCliente();
                      BancoDadosBLL calculaIMC = new BancoDadosBLL();

                      double IMC = calculaIMC.CalculaIMC(peso, altura);
                      String Classificacao = calculaIMC.ClassificaIMC(IMC);
                      cadastraCliente.CadastrarCli(nome, email, senha, altura, peso, IMC, Classificacao);




                      if (cadastraCliente.Erro == true){

                        JOptionPane.showMessageDialog(janelaCadastro, "Erro no Cadastro", "Erro!", JOptionPane.ERROR_MESSAGE);
                      }
                      else
                      {
                        JOptionPane.showMessageDialog(janelaCadastro, "Cadastro Efetuado com Sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                         TelaIMC telaimc = new TelaIMC(email, senha);
						          	dispose();	


                      }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                      


                    if(senha.equals(confirmasenha) == false){
                          JOptionPane.showMessageDialog(janelaCadastro, "Senhas nao coincidem!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    }else{
                        if(senha.equals("") || email.equals("")){
                          JOptionPane.showMessageDialog(janelaCadastro, "Preencha todos os campos!", "Erro!", JOptionPane.ERROR_MESSAGE);
                        }
                      }
                    }
              }

              
              );

          setTitle("IMC - Cadastrar");
          setSize(400,300);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}