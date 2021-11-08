import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaConsultar extends JFrame{
    
    int index;
    List lista, lista2;
    public TelaConsultar(String email, String senha){
        Container janelaConsultar = getContentPane();
		janelaConsultar.setLayout(null);
        BancoDadosDAO banco = new BancoDadosDAO();

        
      
        lista = new List(3,false);
        lista2 = new List(3,false);
        
        banco.SetLista(lista, lista2);

        JButton botaoRemover = new JButton("Remover");
        janelaConsultar.add(botaoRemover);
        botaoRemover.setBounds(350,330,100,30);

        JButton botaoVoltar = new JButton("Voltar");
        janelaConsultar.add(botaoVoltar);
        botaoVoltar.setBounds(200,330,100,30);
        
        banco.ConsultaBanco();


        lista = banco.getLista();
        lista2 = banco.getListaIMC();

        janelaConsultar.add(lista);
        janelaConsultar.add(lista2);
        lista2.setBounds(310,20,290,300);
        lista.setBounds(10,20,310,300);
        lista2.setMultipleMode(false); 
        lista.setMultipleMode(false);
        
        lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    lista2.select(lista.getSelectedIndex());        
            }
        });

        lista2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    lista.select(lista2.getSelectedIndex());        
            }
        });




         botaoRemover.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evento) {
                        int index = lista.getSelectedIndex();
                        String selec1 = lista.getItem(index);
                        System.out.println(selec1);
                        String selec2 = lista2.getItem(index);
                        System.out.println(selec2);
                        String[] array = selec1.split(" ");
                        
                        int idlista = 0;
                        Boolean Erro;

                        
                        for(int i = 0 ; i < array.length ; i++){
                            if(i == 2){
                               idlista = Integer.parseInt(array[i]);
                            }  
                        }

                        banco.RemoveDoBanco(idlista);

                        if (banco.Erro == true){

                            JOptionPane.showMessageDialog(janelaConsultar, "Erro no Banco de Dados", "Erro!", JOptionPane.ERROR_MESSAGE);
                     
                        }else{
                            lista.remove(index);
                            lista2.remove(index);
                        }

                     

                    }
              }

              
          );


           botaoVoltar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evento) {
                        TelaIMC imc = new TelaIMC(email, senha);
                        dispose();
                    }
              }

              
          );


        setTitle("IMC - Consulta");
        setSize(600,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   




}
