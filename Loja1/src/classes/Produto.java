package classes;

public class Produto {
    private String codigoProduto;
    private String nomeProduto;
    private Float valorProduto;
    private int qtdEstoque;


    // construtor vazio 
    public Produto() {
    }
    

    //construtor
    public Produto(String codigoProduto, String nomeProduto, Float valorProduto, int qtdEstoque) {
    this.codigoProduto = codigoProduto;
    this.nomeProduto = nomeProduto;
    this.valorProduto = valorProduto;
    this.qtdEstoque = qtdEstoque;
    }
  
    // getters e setters 
    public String getCodigoProduto() {
        return codigoProduto;
    }   
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public Float getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(Float valorProduto) {
        this.valorProduto = valorProduto;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void subtrairEstoque (int subtrairEstoque){
         qtdEstoque -=  subtrairEstoque;
    }


    
    }



    




    

