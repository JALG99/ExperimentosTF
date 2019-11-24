package Test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tp.Controller.ClienteController;
import com.tp.Controller.ProductoController;
import com.tp.Controller.CargoController;
import com.tp.Controller.EmpleadoController;
import com.tp.Entity.Producto;
import com.tp.Entity.Cliente;
import com.tp.Entity.Cargo;
import com.tp.Entity.Empleado;
import com.tp.Service.ClienteServiceImpl;
import com.tp.Service.ProductoServiceImpl;
import com.tp.Service.CargoServiceImpl;
import com.tp.Service.EmpleadoServiceImpl;


public class TestGenerales {
	
	ClienteController clientecontroller = new ClienteController();
	ClienteServiceImpl clienteservice = new ClienteServiceImpl();
	
	ProductoController productocontroller = new ProductoController();
	ProductoServiceImpl productoservice = new ProductoServiceImpl();
	
	CargoController cargocontroller = new CargoController();
	CargoServiceImpl cargoservice = new CargoServiceImpl();
	
	EmpleadoController empleadocontroller = new EmpleadoController();
	EmpleadoServiceImpl empleadoservice = new EmpleadoServiceImpl();
	
	@Before
	public void InicializarTienda() {
		productocontroller.setProductoService(productoservice);
		clientecontroller.setClienteService(clienteservice);
		cargocontroller.setCargoService(cargoservice);
		empleadocontroller.setEmpleadoService(empleadoservice);		
	}
	
	@Test
	public void testActualizarCliente() {
		Cliente clientetest = new Cliente(1, "Jorge Landaverry");
		
		clientecontroller.setCliente(clientetest);
		clientecontroller.saveCliente();
		clientecontroller.cleanCliente();
		
		clientetest = new Cliente(1, "Victor Landaverry");
		
		clientecontroller.setCliente(clientetest);
		clientecontroller.updateCliente();
		clientecontroller.cleanCliente();
		
		Cliente resultado = clientetest;
		Cliente esperado = new Cliente(1, "Victor Landaverry");
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testActualizarCargo() {
		Cargo cargotest = new Cargo(1, "Jefaso", 2000);
		
		cargocontroller.setCargo(cargotest);
		cargocontroller.saveCargo();
		cargocontroller.cleanCargo();
		
		cargotest = new Cargo(1, "Empleado", 1000);
		
		cargocontroller.setCargo(cargotest);
		cargocontroller.updateCargo();
		cargocontroller.cleanCargo();
		
		Cargo resultado = cargotest;
		Cargo esperado = new Cargo(1, "Empleado", 1000);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testActualizarEmpleado() {
		Empleado empleadotest = new Empleado(1, "Marco Polo", "Bajo el puente", 999771220);
		
		empleadocontroller.setEmpleado(empleadotest);
		empleadocontroller.saveEmpleado();
		empleadocontroller.cleanEmpleado();
		
		empleadotest = new Empleado(1, "Juana de Arco", "Bajo el puente", 999771220);
		
		empleadocontroller.setEmpleado(empleadotest);
		empleadocontroller.updateEmpleado();
		empleadocontroller.cleanEmpleado();
		
		Empleado resultado = empleadotest;
		Empleado esperado = new Empleado(1, "Juana de Arco", "Bajo el puente de al lado", 999441220);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testActualizarProducto() {
		Producto productotest = new Producto(1, "Hamburguesa con queso", 20, "Hamburguesa clásica con queso cheddar al centro", "Hamburguesas", 20);
		
		productocontroller.setProducto(productotest);
		productocontroller.saveProducto();
		productocontroller.cleanProducto();
		
		productotest = new Producto(1, "Hamburguesa royal", 25, "Hamburguesa clásica con queso y huevo", "Hamburguesas", 10);
		
		productocontroller.setProducto(productotest);
		productocontroller.updateProducto();
		productocontroller.cleanProducto();
		
		Producto resultado = productotest;
		Producto esperado = new Producto(1, "Hamburguesa royal", 25, "Hamburguesa clásica con queso y huevo", "Hamburguesas", 10);
		
		assertEquals(esperado, resultado);
	}
	

}
