package com.projetobackend.primeirobackend.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.projetobackend.primeirobackend.model.Produto;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /** Metodo
     * Retorna uma lista de produtos
     * @return
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id
     * @param id do produto que sera localizado
     * @return retorna um produto caso seja localizado
     */

    public Optional<Produto> obterPorId(Integer id){
        return produtos
            .stream()
            .filter(produto -> produto.getId() == id)
            .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista
     * @param produto que sera adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Metodo oara deletar o produto por Id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizr o produto na lista
     * @param produto que sera atualizado
     * @return Retorna o produto a atualizar a lista
     */
    public Produto atualizar(Produto produto){
        //Encontra o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }
        //Eu tenho que remover o produto antigo na lista
        deletar(produto.getId());
        //Depoois adicionar o produto atualizado na lista
        produtos.add(produto);

        return produto;
    }
}
