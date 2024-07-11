package br.unicamp.ic.inf335.app.inf335_trabalho4.beans;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AnuncioBeanTest {

    private AnuncioBean anuncio;

    @BeforeEach
    public void setUp() {
        ProdutoBean produto = new ProdutoBean(
        	"001", 
        	"Produto Teste", 
        	"Descrição do produto", 
        	100.0, 
        	"Novo"
        );
        ArrayList<URL> fotos = new ArrayList<>();
        try {
			fotos.add(new URL("http://example.com/foto1.jpg"));
			fotos.add(new URL("http://example.com/foto2.jpg"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        anuncio = new AnuncioBean(
        	produto, 
        	fotos, 
        	0.1
        );
    }

    @Test
    public void testGetProduto() {
        assertEquals("001", anuncio.getProduto().getCodigo());
    }

    @Test
    public void testSetProduto() {
        ProdutoBean novoProduto = new ProdutoBean(
        	"002", 
        	"Novo Produto", 
        	"Descrição do novo produto", 
        	200.0, 
        	"Usado"
        );
        anuncio.setProduto(novoProduto);
        assertEquals("002", anuncio.getProduto().getCodigo());
    }

    @Test
    public void testGetFotosUrl() throws MalformedURLException {
        assertEquals(2, anuncio.getFotosUrl().size());
    }

    @Test
    public void testSetFotosUrl() throws MalformedURLException {
        ArrayList<URL> novasFotos = new ArrayList<>();
        novasFotos.add(new URL("http://example.com/nova_foto.jpg"));
        anuncio.setFotosUrl(novasFotos);
        assertEquals(1, anuncio.getFotosUrl().size());
    }

    @Test
    public void testGetDesconto() {
        assertEquals(0.1, anuncio.getDesconto());
    }

    @Test
    public void testSetDesconto() {
        anuncio.setDesconto(0.2);
        assertEquals(0.2, anuncio.getDesconto());
    }

    @Test
    public void testGetValor() {
        assertEquals(90.0, anuncio.getValor());
    }
}
