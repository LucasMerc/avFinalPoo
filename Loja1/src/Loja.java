import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IntSummaryStatistics;

import java.util.Scanner;
import java.util.stream.Collectors;

import classes.Produto;
import classes.Venda;


public class Loja {
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
         Scanner in = new Scanner(System.in);
         String opcao;
         ArrayList<Produto> estoque = new ArrayList<>();
         ArrayList<Venda> vendas = new ArrayList<>();

          do {
                System.out.println("\n****\nMENU\n****\n");
                System.out.println("[1] - Incluir produto");
                System.out.println("[2] - Consultar produto");
                System.out.println("[3] - Listagem de produtos");
                System.out.println("[4] - Vendas por período");
                System.out.println("[5] - Realizar venda");
                System.out.println("[0] - Sair");
                System.out.print("Digite a opção desejada: ");
            
                 opcao = in.nextLine();
           

                switch(opcao){
                
                    case "1": {
                        System.out.println("=== CADASTRO DE PRODUTO ===\n");

                        System.out.println("Digite o nome do produto: ");
                        String nomeProd = in.nextLine();

                        System.out.println("Digite o código do produto: ");
                        String codProd = in.nextLine();

                        System.out.println("Digite o valor unitário do produto: ");
                        float valorProd = in.nextFloat();

                        System.out.println("Digite a quantidade que deseja cadastrar: ");
                        int qtdEstoque = in.nextInt();

                        Produto p1 = new Produto();
                        p1.setNomeProduto(nomeProd);
                        p1.setCodigoProduto(codProd);
                        p1.setValorProduto(valorProd);
                        p1.setQtdEstoque(qtdEstoque);

                        estoque.add(p1);
                        voltarMenu(in);
                        System.out.println("= PRODUTO CADASTRADO COM SUCESSO =");
                        voltarMenu(in);
                        break;
                }
                    case "2": {

                        System.out.println("=== CONSULTA DE PRODUTO ===\n");
                        System.out.printf("Digite o código do produto \n");
                        String codProd = in.nextLine();

                        for(int i = 0; i < estoque.size(); ++i){
                            Produto pTemp = new Produto();
                            pTemp = estoque.get(i);
                            
                            if (codProd.equals(pTemp.getCodigoProduto())){
                                System.out.println("=== PRODUTO ENCONTRADO ===\n ");
                                System.out.printf("\tNome do produto: %s\n" , pTemp.getNomeProduto());
                                System.out.printf("\tCódigo do produto: %s\n" , pTemp.getCodigoProduto());
                                System.out.printf("\tValor unitário do produto: %s\n" , pTemp.getValorProduto());
                                System.out.printf("\tQuantidade em estoque : %s\n" , pTemp.getQtdEstoque());
                                
                                voltarMenu(in);
                            }
                        }

                        break;
                }
                     case "3": {
                        System.out.println("=== PRODUTOS CADASTRADOS ===\n");
                        for (int i = 0; i < estoque.size(); ++i){

                        System.out.printf("Produto %s\n" ,i);
                        System.out.printf("\tNome do produto: %s\n" , estoque.get(i).getNomeProduto());
                        System.out.printf("\tCódigo do produto: %s\n" , estoque.get(i).getCodigoProduto());
                        System.out.printf("\tValor unitário do produto: %s\n" , estoque.get(i).getValorProduto());
                        System.out.printf("\tQuantidade em estoque : %s\n" , estoque.get(i).getQtdEstoque());
                        System.out.println("--------------------------------------------------------------------");  

                        }
                        
                        IntSummaryStatistics sumarizacao = estoque.stream()
                        .collect(Collectors.summarizingInt(Produto::getQtdEstoque));
                        System.out.printf("\tA média dos produtos cadastrados é de: %s\n" , sumarizacao.getAverage());
                        System.out.printf("\tO valor mínimo dos produtos é de: %s\n " , sumarizacao.getMin());
                        System.out.printf("\tO valor máximo dos produtos é de: %s\n " , sumarizacao.getMax());
                        System.out.println("--------------------------------------------------------------------");


                        voltarMenu(in);
                        break;
                }
                    case "4":{ 
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            
                            System.out.println("=== RELATÓRIO DE VENDAS POR PERÍODO ===\n");

                            System.out.println("Digite a data (ex:10/12/2012) que você deseja obter o relatório");
                            String dataRelat = in.nextLine();

                            Date dataFormatada = formato.parse(dataRelat);

                            System.out.printf("Relatório relacionado a data %s ", dataRelat );

                            for (Venda v1 : vendas) {
    
                                if(v1.getDataVenda().equals(dataFormatada)){
                                    System.out.println(v1.getProdVendido());
                                    System.out.printf("Data de venda: %s\n", v1.getDataVenda());

                                    IntSummaryStatistics sumarizacao = vendas.stream()
                                    .collect(Collectors.summarizingInt(Venda::getTotalVendas));
                                    System.out.printf("\t A média de vendas por este período é: %s\n" , sumarizacao.getAverage());
                                    System.out.printf("\t O máximo de vendas neste período é: %s\n" , sumarizacao.getMax());
                                    System.out.printf("\t O mínimo de vendas neste período é: %s\n" , sumarizacao.getMin());
                                    System.out.printf("\t A soma total de vendas deste período é: %s\n" , sumarizacao.getSum());
                                    System.out.printf("\t O valor máximo dos produtos é de: %s\n " , sumarizacao.getMax());
                                    System.out.println("--------------------------------------------------------------------");
                                   
                                } 
                                System.out.println("\t\t=== RELATÓRIO FINALIZADO ===");
                            }
                                if(vendas.isEmpty()){
                                System.out.println("Nenhuma venda realizada nessa data");
                                }
                            voltarMenu(in);
                        break;
                      }
                    case "5":{ 
                        Venda v1 = new Venda();

                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        
                        System.out.println("=== REALIZAR VENDAS ===\n");

                        System.out.println("Digite o código do produto que deseja vender");
                        String codVenda = in.nextLine();

                        for (Produto p : estoque) {
                            if(p.getCodigoProduto() != codVenda){

                                System.out.println("= PRODUTO NÃO CADASTRADO");     
                                
                            }       
                            
                            System.out.println("\t\t=== PROGRAMA ENCERRADO ===");
                            in.close();
                            
                        }
                        
                        
                        System.out.println("Digite a data (ex:10/12/2012) de venda dos(as) produtos(as)");
                        String dataVenda = in.nextLine();
                        System.out.println("Digite a quantidade que deseja vender deste produto(a)");
                        int qtdVenda = in.nextInt();

                        Date dataFormatada = formato.parse(dataVenda);
 

                        v1.setQtdVendido(qtdVenda);
                        v1.setDataVenda(dataFormatada);

                        for (Produto p1 : estoque) {
                            if(p1.getCodigoProduto() == codVenda){ 
                              v1.setProdVendido(p1);                           
        
                                 p1.subtrairEstoque(v1.getQtdVendido());     
                            }       
                            voltarMenu(in);
                        }
                        vendas.add(v1);
                        System.out.println("\t\t=== VENDA REALIZADA E CADASTRADA COM SUCESSO ===\n");
                        voltarMenu(in);
                        break;
                    }
                    case "0":{
                        System.out.println("\t\t=== PROGRAMA ENCERRADO ===");

                        in.close();
                        break;
                    }   

                default:{
                    System.out.println("\t\t=== OPÇÃO INVÁLIDA ===");

                    voltarMenu(in);
                }
                 
        
            }

            }while ( opcao != "0");
            

                System.out.println("Fim do ;programa!");
                System.out.println("\n= PRESSIONE ENTER PARA VOLTAR AO MENU = ");

                in.close();

        }



    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\n= PRESSIONE ENTER PARA VOLTAR AO MENU = ");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}



