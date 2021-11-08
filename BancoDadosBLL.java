import java.text.DecimalFormat;
import java.text.Format;
import java.util.function.DoubleBinaryOperator;

public class BancoDadosBLL {
 

    public double CalculaIMC(double peso, double altura){

        double IMC;
        
        IMC = peso/(altura*altura);

        
        DecimalFormat df = new DecimalFormat("##.##");
        String IMCST = df.format(IMC);
        IMCST = IMCST.replaceAll(",", ".");
        IMC = Double.parseDouble(IMCST);
        
        
        
        ClassificaIMC(IMC);

        return IMC;

    }

    public String ClassificaIMC(double IMC){
        String classificacao = "";

        if(IMC < 18.5){
            classificacao = "Magreza";
        }
        if(IMC >= 18.5 && IMC <= 24.9){
            classificacao = "Saudável";
        }
        if(IMC >= 25 && IMC <= 29.9){
            classificacao = "Sobrepeso";
        }
        if(IMC >= 30 && IMC <= 34.9){
            classificacao = "Obesidade Grau 1";
        }
        if(IMC >= 35 && IMC <= 39.9){
            classificacao = "Obesidade Grau 2";
        }
        if(IMC >= 40){
            classificacao = "Obesidade Grau 3";
        }

        return classificacao;
    }

        


}
