package ar.edu.unlam.pb2.obras;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.obras.Autor;
import ar.edu.unlam.pb2.obras.Catalogo;
import ar.edu.unlam.pb2.obras.ObraDeArte;

public class CatalogoTest {
    private Catalogo catalogo;
    
    @Before
    public void init(){
        catalogo = new Catalogo();
    }
    
    @Test
    public void testCrearCatalogoVacio(){
        Assert.assertTrue(0 == catalogo.ontenerCantidadObras());
    }

    @Test
    public void testAgregarObra() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarr?n con acianos y amapolas", new Autor("Vincent Van Gogh ")));
        Assert.assertTrue(1 == catalogo.ontenerCantidadObras());
    }

    @Test
    public void testExisteObra() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarr?n con acianos y amapolas", new Autor("Vincent Van Gogh ")));
        Assert.assertTrue(catalogo.existeObra(new ObraDeArte("Jarr?n con acianos y amapolas", new Autor("Vincent Van Gogh "))));
    }
    
    @Test(expected= Exception.class)
    public void testAgregarObraDuplicada() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarr?n con acianos y amapolas", new Autor("Vincent Van Gogh ")));
        catalogo.agregarObra(new ObraDeArte("Jarr?n con acianos y amapolas", new Autor("Vincent Van Gogh ")));
    }
    
    @Test
    public void testObrasOrdenadasPorNombre() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Masaccio", new Autor("Miguel Angel")));
        catalogo.agregarObra(new ObraDeArte("Giotto", new Autor("Miguel Angel")));
        catalogo.agregarObra(new ObraDeArte("Hercules", new Autor("Miguel Angel")));
        
        int i = 0;
        for(Iterator<ObraDeArte> it = catalogo.getObras().iterator();it.hasNext();){
            ObraDeArte each = it.next();
            switch (i){
            case 0:
                Assert.assertTrue("Giotto".equals(each.getNombre()));
                break;
            case 1:
                Assert.assertTrue("Hercules".equals(each.getNombre()));
                break;
            case 2:
                Assert.assertTrue("Masaccio".equals(each.getNombre()));
                break;
            }
            i++;
        }
    }
}
