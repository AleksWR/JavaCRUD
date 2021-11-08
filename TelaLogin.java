import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame{

	public TelaLogin(){

		Container janelaLogin = getContentPane();
		janelaLogin.setLayout(null);

		JLabel lblEmail = new JLabel("E-mail:");
		janelaLogin.add(lblEmail);
		lblEmail.setBounds(70,30,45,20);
			

		JLabel lblSenha = new JLabel("Senha:");
		janelaLogin.add(lblSenha);
		lblSenha.setBounds(70,60,45,20);
		

		JTextField txtEmail = new JTextField();
		janelaLogin.add(txtEmail);
		txtEmail.setBounds(115,30,200,20);
			


		JPasswordField txtSenha = new JPasswordField();
		janelaLogin.add(txtSenha);
		txtSenha.setBounds(115,60,200,20);
		
	

		JButton botaoConfirmar = new JButton("Confirmar");
		janelaLogin.add(botaoConfirmar);
		botaoConfirmar.setBounds(215,90,100,30);

		JButton botaoCancelar = new JButton("Cancelar");
		janelaLogin.add(botaoCancelar);
		botaoCancelar.setBounds(115,90,90,30);

		botaoCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evento) {
							TelaInicio telainicio = new TelaInicio();
							dispose();
						}
				  }
	
				  
			  );


		botaoConfirmar.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent evento) {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
				

						String senha = new String(txtSenha.getPassword());
						String email = new String(txtEmail.getText());

						LoginCliente LogaCliente = new LoginCliente();
                      
						LogaCliente.LogarCliente(email, senha);

						if (LogaCliente.Erro == true){

						  	JOptionPane.showMessageDialog(janelaLogin, "Erro no Login", "Erro!", JOptionPane.ERROR_MESSAGE);
							
						}
						else{

							JOptionPane.showMessageDialog(janelaLogin, "Login Efetuado com Sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
							TelaIMC telaimc = new TelaIMC(email, senha);
							dispose();		
						}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						
						if(senha.equals("") || email.equals("")){
							JOptionPane.showMessageDialog(janelaLogin, "Preencha todos os campos!", "Erro!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				
				);
	

		setTitle("IMC - Login");
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}