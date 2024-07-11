package br.unicamp.ic.inf335.app.inf335_trabalho4.beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class ProdutoBeanTest {

    private static ProdutoBean produto;

    @BeforeEach
    void setUp() {
        produto = new ProdutoBean(
        	"001", 
        	"Produto Teste", 
        	"Descrição do produto", 
        	100.0, 
        	"Novo"
        );
    }

    @Test
    public void testGetCodigo() {
        assertEquals("001", produto.getCodigo());
    }

    @Test
    public void testSetCodigo() {
        produto.setCodigo("002");
        assertEquals("002", produto.getCodigo());
    }

    @Test
    public void testGetNome() {
        assertEquals("Produto Teste", produto.getNome());
    }

    @Test
    public void testSetNome() {
        produto.setNome("Novo Nome");
        assertEquals("Novo Nome", produto.getNome());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Descrição do produto", produto.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        produto.setDescricao("Nova descrição");
        assertEquals("Nova descrição", produto.getDescricao());
    }

    @Test
    public void testGetValor() {
        assertEquals((double)100.0, produto.getValor());
    }

    @Test
    public void testSetValor() {
        produto.setValor(200.0);
        assertEquals((double)200.0, produto.getValor());
    }

    @Test
    public void testGetEstado() {
        assertEquals("Novo", produto.getEstado());
    }

    @Test
    public void testSetEstado() {
        produto.setEstado("Usado");
        assertEquals("Usado", produto.getEstado());
    }

    @Test
    public void testCompareTo() {
        ProdutoBean produto2 = new ProdutoBean(
        	"002", 
        	"Produto 2", 
        	"Descrição produto 2", 
        	150.0, 
        	"Usado"
        );
        assertTrue(produto.compareTo(produto2) < 0);

        produto.setValor(250.0);
        assertTrue(produto.compareTo(produto2) > 0);

        produto.setValor(150.0);
        assertEquals(0, produto.compareTo(produto2));
    }
}
