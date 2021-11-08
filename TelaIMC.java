import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaIMC extends JFrame{
    public TelaIMC(String email, String senha){
        
        Container janelaIMC = getContentPane();
		janelaIMC.setLayout(null);



        BancoDadosDAO consultaDados = new BancoDadosDAO();
        consultaDados.ConsultaBanco(email, senha);
        
        if(consultaDados.getNome() == null){
            System.exit(0);            
        }


        JLabel lblNome = new JLabel("Nome : "+ consultaDados.getNome());
		janelaIMC.add(lblNome);
		lblNome.setBounds(0,5,100,30);

        JLabel lblPeso = new JLabel("Peso : " +  consultaDados.getPeso());
		janelaIMC.add(lblPeso);
		lblPeso.setBounds(200,5,100,30);

        JLabel lblAltura = new JLabel("Altura: "+  consultaDados.getAltura());
		janelaIMC.add(lblAltura);
		lblAltura.setBounds(400,5,100,30);

        JLabel lblIMC = new JLabel("IMC: " +  consultaDados.getImc());
		janelaIMC.add(lblIMC);
		lblIMC.setBounds(0,40,100,30);

        JLabel lblClass = new JLabel("Classificacao: "+ consultaDados.getClassificacao());
		janelaIMC.add(lblClass);
		lblClass.setBounds(200,40,200,30);



	    JButton botaoAtualizar = new JButton("Atualizar");
        janelaIMC.add(botaoAtualizar);
        botaoAtualizar.setBounds(200,100,100,30);

        JButton botaoConsultar = new JButton("Consultar");
        janelaIMC.add(botaoConsultar);
        botaoConsultar.setBounds(200,150,100,30);







        botaoAtualizar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evento) {
					TelaAtualizar telatualizar = new TelaAtualizar(email, senha);
                    dispose();
				}
			}
		);

        botaoConsultar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
                    TelaConsultar telaconsultar = new TelaConsultar(email, senha);
                    dispose();
                }
            }   
        );

        setTitle("IMC - Inicio");
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
