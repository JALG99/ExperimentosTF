package Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tp.Controller.DetalleController;
import com.tp.Controller.OrdenController;
import com.tp.Controller.ProductoController;
import com.tp.Controller.PromocionController;
import com.tp.Controller.PromocionDetalleController;
import com.tp.Entity.Promocion;
import com.tp.Entity.PromocionDetalle;
import com.tp.Entity.PromocionDetallePK;
import com.tp.Entity.Detalle;
import com.tp.Entity.DetallePK;
import com.tp.Entity.Orden;
import com.tp.Entity.Producto;
import com.tp.Service.DetalleServiceImpl;
import com.tp.Service.OrdenServiceImpl;
import com.tp.Service.ProductoServiceImpl;
import com.tp.Service.PromocionDetalleServiceImpl;
import com.tp.Service.PromocionServiceImpl;

public class TestNegocio {
	ProductoController productocontroller = new ProductoController();
	ProductoServiceImpl productoservice = new ProductoServiceImpl();
	
	OrdenController ordencontroller = new OrdenController();
	OrdenServiceImpl ordenservice = new OrdenServiceImpl();
	
	DetalleController detallecontroller = new DetalleController();
	DetalleServiceImpl detalleservice = new DetalleServiceImpl();
	
	PromocionController promocioncontroller = new PromocionController();
	PromocionServiceImpl promocionservice = new PromocionServiceImpl();
	
	PromocionDetalleController promociondetallecontroller = new PromocionDetalleController();
	PromocionDetalleServiceImpl promociondetalleservice = new PromocionDetalleServiceImpl();
	
	@Before
	public void InicializarTienda() {
		productocontroller.setProductoService(productoservice);
		ordencontroller.setOrdenService(ordenservice);
		detallecontroller.setDetalleService(detalleservice);
		promocioncontroller.setPromocionService(promocionservice);
		promociondetallecontroller.setPromocionDetalleService(promociondetalleservice);
		
	}

	@Test
	public void testActualizarStock() {
		Producto productotest = new Producto(1, "Hamburguesa con queso", 20, "Hamburguesa clásica con queso cheddar al centro", "Hamburguesas", 5);
		
		productocontroller.setProducto(productotest);
		productocontroller.saveProducto();
		productocontroller.cleanProducto();
		
		productotest = new Producto(1, "Hamburguesa con queso", 25, "Hamburguesa clásica con queso cheddar al centro", "Hamburguesas", 20);
		
		productocontroller.setProducto(productotest);
		productocontroller.updateProducto();
		
		int resultado = productotest.getStock();
		int esperado = 20;
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testActualizarPrecio() {
		Producto productotest = new Producto(1, "Hamburguesa con queso", 20, "Hamburguesa clásica con queso cheddar al centro", "Hamburguesas", 5);
		
		productocontroller.setProducto(productotest);
		productocontroller.saveProducto();
		productocontroller.cleanProducto();
		
		productotest = new Producto(1, "Hamburguesa con queso", 25, "Hamburguesa clásica con queso cheddar al centro", "Hamburguesas", 5);
		
		productocontroller.setProducto(productotest);
		productocontroller.updateProducto();
		productocontroller.cleanProducto();
		
		int resultado = productotest.getPrecioproducto();
		int esperado = 25;
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testStock() {
		Orden ordentest = new Orden(1, "28/09/2019", "Efectivo");
		
		Producto productotest = new Producto(1, "Hamburguesa con queso", 20, "Hamburguesa clásica con queso cheddar al centro", "Hamburguesas", 5);
		DetallePK detallepktest = new DetallePK(1,1);
		Detalle detalletest = new Detalle(detallepktest, 5);
		detalletest.setProducto(productotest);
		detalletest.setOrden(ordentest);
		
		productocontroller.setProducto(productotest);
		productocontroller.saveProducto();
		productocontroller.cleanProducto();
		
		ordencontroller.setOrden(ordentest);
		ordencontroller.saveOrden();
		ordencontroller.cleanOrden();
		
		detallecontroller.setDetalle(detalletest);
		detallecontroller.saveDetalle();
		detallecontroller.cleanDetalle();
		
		int resultado = productotest.getStock();
		int esperado = 0;
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testOrden() {
		Orden ordentest = new Orden(1, "28/09/2019", "Efectivo");
		
		Producto productotest = new Producto(1, "Hamburguesa con queso", 20, "Hamburguesa clásica con queso cheddar al centro", "Hamburguesas", 20);
		DetallePK detallepktest = new DetallePK(1,1);
		Detalle detalletest = new Detalle(detallepktest, 5);
		detalletest.setProducto(productotest);
		detalletest.setOrden(ordentest);
		
		productocontroller.setProducto(productotest);
		productocontroller.saveProducto();
		productocontroller.cleanProducto();
		
		ordencontroller.setOrden(ordentest);
		ordencontroller.saveOrden();
		ordencontroller.cleanOrden();
		
		detallecontroller.setDetalle(detalletest);
		detallecontroller.saveDetalle();
		detallecontroller.cleanDetalle();
		
		Producto productotest2 = new Producto(2, "Milkshake de oreo", 12, "Milksahke hecho a base de helado cookies and cream con trozos de oreo", "Milkshakes", 10);
		DetallePK detallepktest2 = new DetallePK(2,1);
		Detalle detalletest2 = new Detalle(detallepktest2, 4);
		detalletest2.setProducto(productotest2);
		detalletest2.setOrden(ordentest);
		
		productocontroller.setProducto(productotest2);
		productocontroller.saveProducto();
		productocontroller.cleanProducto();
		
		detallecontroller.setDetalle(detalletest2);
		detallecontroller.saveDetalle();
		detallecontroller.cleanDetalle();
		
		int resultado = ordentest.getPreciototal();
		int esperado = 148;
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testPrecioPromocion() {
		Promocion promociontest = new Promocion(1, "Happy Saturday", 0, "Dos hamburguesas royal con dos milkshakes de oreo a precio especial", 0);
		Producto productotest1 = new Producto(1, "Hamburguesa royal", 25, "Hamburguesa clásica con queso y huevo", "Hamburguesas", 10);
		Producto productotest2 = new Producto(2, "Milkshake de oreo", 12, "Milksahke hecho a base de helado cookies and cream con trozos de oreo", "Milkshakes", 10);
		PromocionDetallePK promocionpktest1 = new PromocionDetallePK(1,1);
		PromocionDetallePK promocionpktest2 = new PromocionDetallePK(2,1);
		PromocionDetalle promociondetalletest1 = new PromocionDetalle(promocionpktest1, 2);
		PromocionDetalle promociondetalletest2 = new PromocionDetalle(promocionpktest2, 2);
		promociondetalletest1.setProducto(productotest1);
		promociondetalletest1.setPromocion(promociontest);
		promociondetalletest2.setProducto(productotest2);
		promociondetalletest2.setPromocion(promociontest);
		
		promocioncontroller.setPromocion(promociontest);
		promocioncontroller.savePromocion();
		promocioncontroller.cleanPromocion();
		
		promociondetallecontroller.setPromocionDetalle(promociondetalletest1);
		promociondetallecontroller.savePromocionDetalle();
		promociondetallecontroller.cleanPromocionDetalle();
		
		promociondetallecontroller.setPromocionDetalle(promociondetalletest2);
		promociondetallecontroller.savePromocionDetalle();
		promociondetallecontroller.cleanPromocionDetalle();
		
		int resultado = promociontest.getPreciototal();
		int esperado = 54;
		
		assertEquals(esperado, resultado);
	}

	@Test
	public void testActualizarPromocion(){
		Promocion promociontest = new Promocion(1, "Happy Saturday", 0, "Dos hamburguesas royal con dos milkshakes de oreo a precio especial", 0);
		
		promocioncontroller.setPromocion(promociontest);
		promocioncontroller.savePromocion();
		promocioncontroller.cleanPromocion();
		
		promociontest = new Promocion(1, "Happy Monday", 0, "Dos hamburguesas royal con dos milkshakes de oreo a precio especial", 0);
		
		promocioncontroller.setPromocion(promociontest);
		promocioncontroller.updatePromocion();
		promocioncontroller.cleanPromocion();
		
		Promocion resultado = promociontest;
		Promocion esperado = new Promocion(1, "Happy Monday", 0, "Dos hamburguesas royal con dos milkshakes de oreo a precio especial", 0);
		
		assertEquals(esperado, resultado);
	}
	
	
}
