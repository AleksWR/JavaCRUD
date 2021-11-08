import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaAtualizar extends JFrame{
    public TelaAtualizar(String email, String senha){
        
        Container janelaConsultar = getContentPane();
		janelaConsultar.setLayout(null);


        BancoDadosDAO consultaDados = new BancoDadosDAO();
        consultaDados.ConsultaBanco(email, senha);


        JLabel lblNome = new JLabel("Nome:");
        janelaConsultar.add(lblNome);
        lblNome.setBounds(70,10,45,20);

        JLabel lblPeso = new JLabel("Peso:");
	    janelaConsultar.add(lblPeso);
	    lblPeso.setBounds(70,40,45,20);

        JLabel lblAltura = new JLabel("Altura:");
		janelaConsultar.add(lblAltura);
		lblAltura.setBounds(70,70,45,20);

		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JTextField txtNome = new JTextField();
        janelaConsultar.add(txtNome);
        txtNome.setBounds(115,10,200,20);
        txtNome.setText(consultaDados.getNome());
        txtNome.setEnabled(false);


        JTextField txtPeso = new JTextField();
        janelaConsultar.add(txtPeso);
        txtPeso.setBounds(115,40,200,20);
        txtPeso.setText(Double.toString(consultaDados.getPeso()));

        JTextField txtAltura = new JTextField();
        janelaConsultar.add(txtAltura);
        txtAltura.setBounds(115,70,200,20);
        txtAltura.setText(Double.toString(consultaDados.getAltura()));

        

        JButton botaoConfirmar = new JButton("Confirmar");
        janelaConsultar.add(botaoConfirmar);
        botaoConfirmar.setBounds(215,100,100,30);

        JButton botaoCancelar = new JButton("Cancelar");
        janelaConsultar.add(botaoCancelar);
        botaoCancelar.setBounds(115,100,90,30);

        botaoConfirmar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evento) {
                    BancoDadosBLL calculaIMC = new BancoDadosBLL();
                    double IMC = calculaIMC.CalculaIMC(Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtAltura.getText()));
                    String Classificacao = calculaIMC.ClassificaIMC(IMC);
					consultaDados.AtualizaBanco(email, senha, Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtAltura.getText()), IMC, Classificacao);
                    TelaIMC telaimc = new TelaIMC(email, senha);
                    dispose();
                }
			}
		);

         botaoCancelar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evento) {
                        TelaIMC telaimc = new TelaIMC(email, senha);
                        dispose();
                    }
              }

              
          );



        setTitle("IMC - Inicio");
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
