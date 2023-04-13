
import com.servico.CalculadoraServico;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Programa cliente dos serviços da calculadora.
 * 
 * @author osmar
 */
public class Principal {

    public static void main(String[] args) {
        try {
            //Especifica o endereço do serviço
            URL url = new URL("http://localhost:8080/CalculadoraServico?wsdl");
            //Valores fornecidos pela WSDL
            //1o parâmetro usar valor do atributo namespace da tag binding\operation\input\soap do wsdl
            //Classe de implementação acrescida de "service
            //2o parâmetro usar valor do atributo name(URI) da tag service do wsdl
            QName qName = new QName("http://servico.com/", "CalculadoraServicoImplService");
            //Cria o serviço e retorna uma referência do objeto
            Service servico = Service.create(url, qName);
            //Especifica o objeto pelo qual podemos invocar operações
            CalculadoraServico calculadora = servico.getPort(CalculadoraServico.class);

            // Chamando os métodos remotos
            String opcao = "";
            double valorA = 0;
            double valorB = 0;
            
            while (!opcao.equals("9")) {
                opcao = JOptionPane.showInputDialog("1 - Leitura \n2 - Soma \n3 - Subtração \n4 - Produto \n5 - Divisão \n9 - Sair");
                switch (Integer.parseInt(opcao)) {
                    case 1:
                        valorA = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor A"));
                        valorB = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor B"));
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Soma: " + calculadora.getAdicao(valorA, valorB));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Subtração: " + calculadora.getSubtracao(valorA, valorB));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Produto: " + calculadora.getProduto(valorA, valorB));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Divisão: " + calculadora.getDivisao(valorA, valorB));
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Alternativa inválida!");
                        break;
                }
            }

        } catch (MalformedURLException mue) {
            System.out.println("Excecao :" + mue.getMessage());
        }
    }
}
