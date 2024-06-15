package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Config;
import modelo.Detalles_procesos;
import modelo.OperacionesBasicas;
import modelo.Productos;

/**
 *
 * @author Tobar
 */
public class DAO_Productos implements OperacionesBasicas {

    Config bd = new Config();

    Productos producto = new Productos();

    @Override
    public boolean insertar(Object obj) {
 
        try {
            this.producto = (Productos) obj;

            Connection con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            String sql = "insert into productos (nombre_producto,precio,inStock,foto,categoria_id,proveedor_id) values(?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, producto.getNombre_producto());
            pst.setFloat(2, producto.getPrecio());
            pst.setInt(3,producto.getInStock());
            pst.setBytes(4, producto.getFoto());
            pst.setInt(5, producto.getCategoria_id());
            pst.setInt(6, producto.getProveedor_id());

            int filasAfectadas = pst.executeUpdate();

            con.close();
            pst.close();

            return filasAfectadas > 0;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar producto: " + ex.getMessage());
            return false;
        }
    }
    
    public void registrarDetalleProceso(int productoId, int accion) {
        try {
            Connection con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            PreparedStatement pst = con.prepareStatement("INSERT INTO Detalles_Procesos (producto_id, proceso_id) VALUES (?, ?)");

            pst.setInt(1, productoId);
            pst.setInt(2, accion);

            pst.executeUpdate();

            con.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar detalles del proceso: " + e.getMessage());
        }
    }

    @Override
    public boolean modificar(Object obj) {
        try {
            this.producto = (Productos) obj;
            Connection con = null;
            PreparedStatement pst = null;
            String sql = "UPDATE productos SET nombre_producto = ?, precio = ?, inStock = ?, foto = ?, categoria_id = ?, proveedor_id = ? WHERE producto_id = ?";

            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            pst = con.prepareStatement(sql);

            pst.setString(1, this.producto.getNombre_producto());
            pst.setFloat(2, this.producto.getPrecio());
            pst.setInt(3, this.producto.getInStock());
            pst.setBytes(4, this.producto.getFoto());
            pst.setInt(5, this.producto.getCategoria_id());
            pst.setInt(6, this.producto.getProveedor_id());
            pst.setInt(7, this.producto.getProducto_id());

            int filasAfectadas = pst.executeUpdate();

            return filasAfectadas > 0;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar producto: " + ex.getMessage());
            return false;
        }
    }

    public boolean existeProducto(int productoID) {
        try {
            Connection con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            String sql = "SELECT * FROM productos WHERE producto_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, productoID);
            ResultSet rs = pst.executeQuery();
            boolean existe = rs.next();
            rs.close();
            pst.close();
            con.close();
            return existe;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del producto: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(Object obj) {
        try {           
            this.producto = (Productos) obj;
            Connection con = null;
            PreparedStatement pst = null;
            String sql = "DELETE FROM detalles_procesos WHERE producto_id = ?";

            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            pst = con.prepareStatement(sql);
            pst.setInt(1, this.producto.getProducto_id());
            pst.executeUpdate();
            
            return eliminarEnCascada(this.producto.getProducto_id()) > 0;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + ex.getMessage());
            return false;
        }
    }
    
    private int eliminarEnCascada(int id) {
        int filasAfectadas = 0;
        try {
            Connection con = null;
            PreparedStatement pst = null;
            String sql = "DELETE FROM Productos WHERE producto_id = " + id;

            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            pst = con.prepareStatement(sql);
            filasAfectadas = pst.executeUpdate();
            
            con.close();
            pst.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + ex.getMessage());
        }
        return filasAfectadas;
    }



    @Override
    public ArrayList<Object[]> seleccionar() {
        ArrayList<Object[]> datos = new ArrayList<>();

        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select productos.producto_id , productos.nombre_producto, productos.precio, productos.inStock, productos.foto , productos.categoria_id, categorias.nombre_categoria, categorias.descripcion , productos.proveedor_id , proveedores.nombre_proveedor from productos inner JOIN categorias ON productos.categoria_id  = categorias.categoria_id inner JOIN proveedores on productos.proveedor_id = proveedores.proveedor_id;";

        try {
            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[10];
                for (int i = 0; i < 10; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                datos.add(fila);

            }

            con.close();
            pst.close();
            rs.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return datos;
    }
    
    public ArrayList<Object[]> seleccionarFiltrado() {
        ArrayList<Object[]> datos = new ArrayList<>();

        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select producto_id, nombre_producto, precio, inStock, foto, c.nombre_categoria, pv.nombre_proveedor from productos p inner join categorias c on p.categoria_id = c.categoria_id inner join proveedores pv on p.proveedor_id = pv.proveedor_id;";

        try {
            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[7];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                datos.add(fila);

            }

            con.close();
            pst.close();
            rs.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return datos;
    }
    
    public boolean eliminarProductosEnCategoria(int categoriaID) {
        try {
            Connection con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            String sql = "DELETE FROM productos WHERE categoria_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, categoriaID);
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            con.close();
            return filasAfectadas > 0; // devuelve true si se eliminaron productos, false si no se eliminaron
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar productos de la categoria: " + ex.getMessage());
            return false;
        }
    }

    
    public boolean productosEnCategoria(int categoriaID) {
        try {
            Connection con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            String sql = "SELECT COUNT(*) FROM productos WHERE categoria_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, categoriaID);
            ResultSet rs = pst.executeQuery();
            rs.next(); // Mover el cursor al primer resultado
            int count = rs.getInt(1); // Obtener el valor del primer resultado
            rs.close();
            pst.close();
            con.close();
            return count > 0; // Devolver true si hay productos en la categoria, false si no los hay
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de productos en la categoría: " + ex.getMessage());
            return false;
        }
    }
    
    // Agregué un parametro "proveedorID" para filtrar aun mas los productos
    public ArrayList<Object[]> filtrarProductos(String nombre, int productoID, int categoriaID, int proveedorID) {
        ArrayList<Object[]> datosFiltrados = new ArrayList<>();

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Construir la consulta SQL base
            String sql = "select producto_id, nombre_producto, precio, inStock, foto, c.nombre_categoria, pv.nombre_proveedor from productos p inner join categorias c on p.categoria_id = c.categoria_id inner join proveedores pv on p.proveedor_id = pv.proveedor_id WHERE 1=1";


            if (!nombre.isEmpty()) {
                sql += " AND nombre_producto LIKE ?";
            }
            if (productoID > 0) {
                sql += " AND producto_id = ?";
            }
            if (categoriaID > 0) {
                sql += " AND c.categoria_id = ?";
            }
            if(proveedorID > 0) {
                sql += " AND p.proveedor_id = ?";
            }

            // Establecer la conexion y preparar la consulta
            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            pst = con.prepareStatement(sql);

            // Configurar los parametros de la consulta segun los valores proporcionados
            int paramIndex = 1; // indice para los parametros en la consulta preparada
            if (!nombre.isEmpty()) {
                pst.setString(paramIndex++, "%" + nombre + "%"); // Utilizamos "%" para buscar coincidencias parciales en el nombre
            }
            if (productoID > 0) {
                pst.setInt(paramIndex++, productoID);
            }
            if (categoriaID > 0) {
                pst.setInt(paramIndex++, categoriaID);
            }
            if(proveedorID > 0) {
                pst.setInt(paramIndex++, proveedorID);
            }

            // Ejecutar la consulta y obtener los resultados
            rs = pst.executeQuery();

            // Procesar los resultados y agregarlos a la lista de datos filtrados
            while (rs.next()) {
                Object[] fila = new Object[7];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                datosFiltrados.add(fila);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al filtrar productos: " + ex.getMessage());
        } finally {
            try {
                // Cerrar los recursos utilizados
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return datosFiltrados;
    }

    public float calcularTotalProductos() {
        float total = 0;
        try {
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            // Consulta SQL para obtener el total de productos multiplicando el precio por el stock
            String sql = "SELECT SUM(precio * inStock) AS total FROM productos";

            // Establecer la conexion y ejecutar la consulta
            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            // Obtener el total de la consulta
            if (rs.next()) {
                total = rs.getFloat("total");
            }

            // Cerrar recursos
            rs.close();
            pst.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular el total de productos: " + ex.getMessage());
        }
        return total;
    }
    
    // Método agregado por Juan
    // Función que devuelve la cantidad en stock de los productos
    public double getInStock(int productoID) {
        ArrayList<Object[]> datos = new ArrayList<>();
        double cantInStock = 0;

        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT inStock FROM productos where producto_id = ?";

        try {
            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            pst = con.prepareStatement(sql);
            pst.setInt(1, productoID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[1];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                    cantInStock = rs.getInt(i + 1);
                }

                datos.add(fila);

            }

            con.close();
            pst.close();
            rs.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return cantInStock;
    }
    
    public boolean updateInStock(int productoID, double cantidad) {
        try {

            Connection con = null;
            PreparedStatement pst = null;

            String sql = "UPDATE Productos SET inStock = ? WHERE producto_id = ?";

            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            pst = con.prepareStatement(sql);

            pst.setDouble(1, cantidad);
            pst.setInt(2, productoID);

            int filasAfectadas = pst.executeUpdate();

            con.close();
            pst.close();

            return filasAfectadas > 0;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar detalle de proceso: " + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<Object[]> filtrar(Object obj, Object obj1) {
        ArrayList<Object[]> datos = new ArrayList<>();
        String sql = "select productos.producto_id , productos.nombre_producto, productos.precio, productos.inStock, productos.foto , productos.categoria_id, categorias.nombre_categoria, categorias.descripcion , productos.proveedor_id , proveedores.nombre_proveedor from productos inner JOIN categorias ON productos.categoria_id  = categorias.categoria_id inner JOIN proveedores on productos.proveedor_id = proveedores.proveedor_id where " + (String)obj + " = ?";
        
        try{
            Class.forName(this.bd.getDriver());
            Connection con = DriverManager.getConnection(this.bd.getUrl(),
                                              this.bd.getUsuario(),
                                              this.bd.getContrasena());
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,(String)obj1);            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Object[] fila = new Object[10];
                
                for(int i =0; i < 10;i++){
                    fila[i] = rs.getObject(i+1);
                }
                datos.add(fila);                                   
            }
            
             con.close();
             ps.close();
             rs.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return datos;    
    }
    
    public double getLasID() {
        ArrayList<Object[]> datos = new ArrayList<>();
        int ultimoID = 0;

        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT MAX(producto_id) FROM Productos";

        try {
            Class.forName(this.bd.getDriver());
            con = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Object[] fila = new Object[1];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getObject(i + 1);
                    ultimoID = rs.getInt(i + 1) + 1;
                }

                datos.add(fila);

            }

            con.close();
            pst.close();
            rs.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return ultimoID;
    }
    
    public ArrayList CargarImagenes(){
        ArrayList Imagenes = new ArrayList();
        
        Connection Conection;
        Statement Consulta;
        ResultSet Resultado;
        String sql = "SELECT * FROM Productos";
        
        try {
            Class.forName(this.bd.getDriver());
            Conection = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            Consulta = Conection.createStatement();
            Resultado = Consulta.executeQuery(sql);
            while (Resultado.next()) {
                Productos prod = new Productos();
                prod.setProducto_id(Resultado.getInt("producto_id"));
                prod.setNombre_producto(Resultado.getString("nombre_producto"));
                prod.setPrecio(Resultado.getFloat("precio"));
                prod.setInStock(Resultado.getInt("inStock"));
                prod.setFoto(Resultado.getBytes("foto"));
                prod.setCategoria_id(Resultado.getInt("categoria_id"));
                prod.setProveedor_id(Resultado.getInt("proveedor_id"));
                Imagenes.add(prod);
            }
            
        }catch (Exception e){
            return null;
        }
        return Imagenes;
    }
    
    public ArrayList FiltrarImagenes(String nombre, int productoID, int categoriaID, int proveedorID){
        ArrayList Imagenes = new ArrayList();
        
        Connection Conection;
        Statement Consulta;
        ResultSet Resultado;
        String sql = "SELECT * FROM Productos WHERE 1 = 1";
        try {
            
            if (!nombre.isEmpty()) {
                sql += " AND nombre_producto LIKE %" + nombre + "%";
            }
            if (productoID > 0) {
                sql += " AND producto_id = " + productoID;
            }
            if (categoriaID > 0) {
                sql += " AND categoria_id = " + categoriaID;
            }
            if(proveedorID > 0) {
                sql += " AND proveedor_id = " + proveedorID;
            }
            Class.forName(this.bd.getDriver());
            Conection = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            Consulta = Conection.createStatement();
            Resultado = Consulta.executeQuery(sql);
            while (Resultado.next()) {
                Productos prod = new Productos();
                prod.setProducto_id(Resultado.getInt("producto_id"));
                prod.setNombre_producto(Resultado.getString("nombre_producto"));
                prod.setPrecio(Resultado.getFloat("precio"));
                prod.setInStock(Resultado.getInt("inStock"));
                prod.setFoto(Resultado.getBytes("foto"));
                prod.setCategoria_id(Resultado.getInt("categoria_id"));
                prod.setProveedor_id(Resultado.getInt("proveedor_id"));
                Imagenes.add(prod);
            }
            
        }catch (Exception e){
            return Imagenes;
        }
        return Imagenes;
    }
    
    public ArrayList FiltrarImagenes(){
        ArrayList Imagenes = new ArrayList();
        
        Connection Conection;
        Statement Consulta;
        ResultSet Resultado;
        String sql = "select producto_id, nombre_producto, precio, foto, c.nombre_categoria, pv.nombre_proveedor  from productos p inner join categorias c on c.categoria_id = p.categoria_id inner join proveedores pv on pv.proveedor_id  = p.proveedor_id";
        
        try {
            Class.forName(this.bd.getDriver());
            Conection = DriverManager.getConnection(this.bd.getUrl(), this.bd.getUsuario(), this.bd.getContrasena());

            Consulta = Conection.createStatement();
            Resultado = Consulta.executeQuery(sql);
            while (Resultado.next()) {
                Productos prod = new Productos();
                prod.setProducto_id(Resultado.getInt("producto_id"));
                prod.setNombre_producto(Resultado.getString("nombre_producto"));
                prod.setPrecio(Resultado.getFloat("precio"));
                prod.setInStock(Resultado.getInt("inStock"));
                prod.setFoto(Resultado.getBytes("foto"));
                prod.setCategoria_id(Resultado.getInt("categoria_id"));
                prod.setProveedor_id(Resultado.getInt("proveedor_id"));
                Imagenes.add(prod);
            }
            
        }catch (Exception e){
            return Imagenes;
        }
        return Imagenes;
    }
}
