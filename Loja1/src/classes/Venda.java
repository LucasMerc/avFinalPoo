package classes;

import java.util.Date;

public class Venda {

    private Date dataDeVenda;
    private int qtdVendido;
    private Produto prodVendido;
    private int totalVendas;

      
    // construtores 
    public Venda( int qtdVendido, Produto prodVendido , Date dataVenda) {
        this.qtdVendido = qtdVendido;
        this.prodVendido = prodVendido;
        this.dataDeVenda = dataVenda;
    } 
    // construtor vazio 
    public Venda() {
   }

    
    public Date getDataVenda() {
        return dataDeVenda;
    }
    public void setDataVenda(Date dataFormatada) {
        this.dataDeVenda = dataFormatada;
    }
    public int getQtdVendido() {
        return qtdVendido;
    }
    public void setQtdVendido(int qtdVendido) {
        this.qtdVendido = qtdVendido;
    }
    public Produto getProdVendido() {
        return prodVendido;
    }
    public void setProdVendido(Produto prodVendido) {
        super.getClass();
    }
    public Date getDataDeVenda() {
        return dataDeVenda;
    }
    public void setDataDeVenda(Date dataDeVenda) {
        this.dataDeVenda = dataDeVenda;
    }
    public int getTotalVendas() {
        return totalVendas;
    }
    public void setTotalVendas(int totalVendas) {
        this.totalVendas = totalVendas;
    }
   
    
  
    
    

    
    

    
    
    
    

    
}
