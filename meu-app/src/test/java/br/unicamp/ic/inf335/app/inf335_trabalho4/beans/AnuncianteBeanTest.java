package br.unicamp.ic.inf335.app.inf335_trabalho4.beans;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.ArrayList;

public class AnuncianteBeanTest {

    private AnuncianteBean anunciante;

    @BeforeEach
    public void setUp() {
    	ProdutoBean produto1 = new ProdutoBean(
            	"001", 
            	"Produto Teste", 
            	"Descrição do produto", 
            	100.0, 
            	"Novo"
            );
    	ArrayList<URL> fotos1 = new ArrayList<>();
    	
    	ProdutoBean produto2 = new ProdutoBean(
    			"002", 
    			"Produto 2", 
    			"Descrição 2", 
    			200.0, 
    			"Usado"
            );
    	ArrayList<URL> fotos2 = new ArrayList<>();
        
    	ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(
        	new AnuncioBean(
        		produto1, 
        		fotos1, 
        		0.1
        		)
        	);
        anuncios.add(
        	new AnuncioBean(
        		produto2, 
        		fotos2, 
        		0.2
        		)
        	);

        anunciante = new AnuncianteBean(
        	"João", 
        	"12345678900", 
        	anuncios
        );
    }

    @Test
    public void testGetNome() {
        assertEquals("João", anunciante.getNome());
    }

    @Test
    public void testSetNome() {
        anunciante.setNome("Maria");
        assertEquals("Maria", anunciante.getNome());
    }

    @Test
    public void testGetCPF() {
        assertEquals("12345678900", anunciante.getCPF());
    }

    @Test
    public void testSetCPF() {
        anunciante.setCPF("98765432100");
        assertEquals("98765432100", anunciante.getCPF());
    }

    @Test
    public void testGetAnuncios() {
        assertEquals(2, anunciante.getAnuncios().size());
    }

    @Test
    public void testAddAnuncio() {
        int initialSize = anunciante.getAnuncios().size();
        ProdutoBean produto3 = new ProdutoBean(
        		"003", 
        		"Novo Produto", 
        		"Descrição nova", 
        		150.0, 
        		"Novo"
            );
        ArrayList<URL> fotos3 = new ArrayList<>();
        AnuncioBean novoAnuncio = new AnuncioBean(
        	produto3, 
        	fotos3, 
        	0.15
        );
        anunciante.addAnuncio(novoAnuncio);
        assertEquals(initialSize + 1, anunciante.getAnuncios().size());
    }

    @Test
    public void testRemoveAnuncio() {
        int initialSize = anunciante.getAnuncios().size();
        anunciante.removeAnuncio(0);
        assertEquals(initialSize - 1, anunciante.getAnuncios().size());
    }

    @Test
    public void testValorMedioAnuncios() { 
        assertEquals(
        	((100.0-0.1*100.0) + (200.0-0.2*200.0)) / 2, 
        	anunciante.valorMedioAnuncios()
        );
    }
}
