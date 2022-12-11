package com.projetobackend.primeirobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetobackend.primeirobackend.model.Produto;
import com.projetobackend.primeirobackend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /***
     * Metodo para retornar uma lista de produtos
     * @return Lista de Produtos
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id
     * @param id do produto que sera localizado
     * @return retorna um produto caso seja localizado
     */

     public Optional<Produto> obterPorId(Integer id){
       return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo para adicionar produto na lista
     * @param produto que sera adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo oara deletar o produto por Id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

     /**
     * Metodo para atualizr o produto na lista
     * @param produto que sera atualizado
     * @return Retorna o produto a atualizar a lista
     */
    public Produto atualizar(Integer id,Produto produto){// id vem separado

        produto.setId(id);
        
        return produtoRepository.atualizar(produto);
        
    }
    
}
