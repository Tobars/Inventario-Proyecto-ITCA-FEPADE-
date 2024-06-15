/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import DAOs.DAO_Categorias;
import DAOs.DAO_Productos;
import DAOs.DAO_Proveedores;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Productos;

/**
 *
 * @author user
 */
public class vModificarProductos extends javax.swing.JFrame {

    String encabezados[] = {"Prod ID", "Nombre", "Precio", "In Stock", "Foto", "Categoría", "Proveedor"};
    
    DAO_Productos daoProds = new DAO_Productos();
    DAO_Categorias daoCateg = new DAO_Categorias();
    DAO_Proveedores daoProveedor = new DAO_Proveedores();
    ArrayList<Object[]> datos = new ArrayList<>();
    ArrayList Imagenes;
    
    DefaultTableModel mModeloTabla = new DefaultTableModel();
    String Ruta = "";
    /**
     * Creates new form vModificarProductos
     */
    public vModificarProductos() {
        initComponents();
        for(String nombre : encabezados) {
            mModeloTabla.addColumn(nombre);
        }
        deshabilitarCampos();
        Limpiar();
        CargarImagenes();
        cargarComboBox();
    }
    
    private void habilitarCampos() {
        txtNombre.setEditable(true);
        txtPrecio.setEnabled(true);
        btnExaminar.setEnabled(true);
        cmbCategorias.setEnabled(true);
        cmbProveedores.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    
    private void deshabilitarCampos() {
        txtNombre.setEditable(false);
        txtPrecio.setEnabled(false);
        txtStock.setEnabled(false);
        btnExaminar.setEnabled(false);
        cmbCategorias.setEnabled(false);
        cmbProveedores.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    private void cargarComboBox() {
        ArrayList<String> nombresCateg = this.daoCateg.getNombres();
        ArrayList<String> nombresCategBuscar = new ArrayList<>();
        nombresCategBuscar.add("Todos");
        
        ArrayList<String> nombresProveedores = this.daoProveedor.getNombres();
        ArrayList<String> nombresProveedoresBuscar = new ArrayList<>();
        nombresProveedoresBuscar.add("Todos");
        
        for(String nombreCateg : nombresCateg) {
            cmbCategorias.addItem(nombreCateg);
            nombresCategBuscar.add(nombreCateg);
        }
        
        for(String nombreProv : nombresProveedores) {
            cmbProveedores.addItem(nombreProv);
            nombresProveedoresBuscar.add(nombreProv);
        }
        
        for(String nomCateg : nombresCategBuscar) {
            cmbCategBuscar.addItem(nomCateg);
        }
        
        for(String nomProv : nombresProveedoresBuscar) {
            cmbProvBuscar.addItem(nomProv);
        }
    }
    
    private void CargarImagenes() {
        tblDatos.setDefaultRenderer(Object.class, new RenderImagen());

        ArrayList Imagenes;
        //ImagenAlmacen mImagenAlmacen;
        Productos producto;

        Object Datos[] = new Object[7];
        Imagenes = daoProds.CargarImagenes();

        if (Imagenes != null) {
            for (int i = 0; i < Imagenes.size(); i++) {
                producto = (Productos) Imagenes.get(i);
                Datos[0] = String.valueOf(producto.getProducto_id());
                Datos[1] = producto.getNombre_producto();
                Datos[2] = producto.getPrecio();
                Datos[3] = producto.getInStock();
                try {
                    byte[] imagen = producto.getFoto();
                    BufferedImage bufferedImage = null;
                    InputStream inputStream = new ByteArrayInputStream(imagen);
                    bufferedImage = ImageIO.read(inputStream);
                    ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0));
                    Datos[4] = new JLabel(mIcono);
                } catch (Exception e) {
                    Datos[4] = new JLabel("No imagen");
                }


                Datos[5] = producto.getCategoria_id();
                Datos[6] = producto.getProveedor_id();

                mModeloTabla.addRow(Datos);
            }

            tblDatos.setModel(mModeloTabla);
            tblDatos.setRowHeight(60);
            tblDatos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblDatos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblDatos.getColumnModel().getColumn(2).setPreferredWidth(60);

        }
    }
    
    private void Limpiar() {
        mModeloTabla.setNumRows(0);
    }
    
    private void limpiarCampos() {
        Ruta = "";
        imgProducto.setIcon(null);
        txtID.setText("");
        txtNombre.setText("");
        txtPrecio.setValue(1);
        txtStock.setValue(0);
        cmbCategorias.setSelectedIndex(0);
        cmbProveedores.setSelectedIndex(0);
        imgProducto.setText("");
    }
    
    private byte[] getImagen(String Ruta) {
        File imagen = new File(Ruta);
        try {
            byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            input.read(icono);
            return icono;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStock = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        imgProducto = new javax.swing.JLabel();
        cmbCategorias = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbProveedores = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIDBuscar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNombreBuscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbCategBuscar = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbProvBuscar = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtPrecio = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modificar/Eliminar Productos");

        btnVolver.setText("Volver al menú");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        jLabel2.setText("ID Producto:");

        txtID.setEditable(false);

        jLabel3.setText("Nombre producto:");

        jLabel4.setText("Precio: $");

        jLabel5.setText("Stock:");

        jLabel6.setText("Categoría:");

        jLabel7.setText("Foto:");

        btnExaminar.setText("Examinar");
        btnExaminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExaminarMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setText("Proveedores:");

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        jLabel10.setText("Filtrar productos");

        jLabel11.setText("ID Producto:");

        jLabel12.setText("Nombre producto:");

        jLabel13.setText("Categoria:");

        jLabel14.setText("Proveedores:");

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnReset.setText("Todos los productos");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        txtPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnModificar)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVolver)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(btnExaminar))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel10))
                                .addGap(92, 92, 92)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIDBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbCategBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbProvBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnVolver))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(btnExaminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar))))
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProvBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnReset))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        // TODO add your handling code here:
        vMenu vMenu = new vMenu();
        vMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverMouseClicked

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        // TODO add your handling code here:
        habilitarCampos();
        this.txtID.setText(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 0).toString());
        this.txtNombre.setText(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 1).toString());
        this.txtPrecio.setValue(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 2));
        
        this.txtStock.setValue(this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 3));
        this.cmbCategorias.setSelectedIndex((int)this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 5) - 1);
        this.cmbProveedores.setSelectedIndex((int)this.tblDatos.getValueAt(this.tblDatos.getSelectedRow(), 6) - 1);
        
        // Proceso para colocar la imagen en el JLabel
        int idSelected = tblDatos.rowAtPoint(evt.getPoint());
        Imagenes = daoProds.CargarImagenes();
        Productos prod = new Productos();
        if(idSelected == Imagenes.size()) {
            prod = (Productos) Imagenes.getLast();
        } else {
            prod = (Productos) Imagenes.get(idSelected);
        }
        
        byte[] imagen = prod.getFoto();
        BufferedImage bufferedImage = null;
        InputStream inputStream = new ByteArrayInputStream(imagen);
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(vModificarProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(bufferedImage == null) {
            imgProducto.setText("No hay foto de este producto");
            imgProducto.setIcon(null);
        } else {
            imgProducto.setText("");
            ImageIcon icon = new ImageIcon(bufferedImage.getScaledInstance(170, 135, 0));
            imgProducto.setIcon(icon);
        }
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnExaminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExaminarMouseClicked
        // TODO add your handling code here:
        imgProducto.setText("");
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        jFileChooser.setFileFilter(fileNameExtensionFilter);

        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Ruta = jFileChooser.getSelectedFile().getAbsolutePath();
            Image mImagen = new ImageIcon(Ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(this.imgProducto.getWidth(), this.imgProducto.getHeight(), Image.SCALE_SMOOTH));
            imgProducto.setIcon(mIcono);
        }
    }//GEN-LAST:event_btnExaminarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
        Productos prod = new Productos();
        prod.setProducto_id(Integer.parseInt(this.txtID.getText()));
        prod.setNombre_producto(this.txtNombre.getText());
        prod.setPrecio(Float.parseFloat(this.txtPrecio.getValue().toString()));
        prod.setInStock(Integer.parseInt(this.txtStock.getValue().toString()));
        
        Imagenes = daoProds.CargarImagenes();
        Productos prodImagen = (Productos) Imagenes.get(tblDatos.rowAtPoint(evt.getPoint()));
        if(getImagen(Ruta) != null) {
            prod.setFoto(getImagen(Ruta));
        } else {
            prod.setFoto(prodImagen.getFoto());
        }
        
        prod.setCategoria_id(this.cmbCategorias.getSelectedIndex() + 1);
        prod.setProveedor_id(this.cmbProveedores.getSelectedIndex() + 1);
        
        // Ingresando el proceso en su tabla
        if(JOptionPane.showConfirmDialog(this, "Desea modificar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            if(daoProds.modificar(prod)) {
                JOptionPane.showMessageDialog(this, "Producto modificado con éxito", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo modificar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Proceso cancelado", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        
        Limpiar();
        CargarImagenes();
        limpiarCampos();
        deshabilitarCampos();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
        int idProd = 0; // producto_id
        String nombreProd = "";// nombre_producto
        int idCateg = this.cmbCategBuscar.getSelectedIndex(); // categoria_id
        int idProv = this.cmbProvBuscar.getSelectedIndex(); // proveedor_id
        
        // Seteando los valores
        if(this.txtIDBuscar.getText().length() > 0) idProd = Integer.parseInt(this.txtIDBuscar.getText());
        if(this.txtNombreBuscar.getText().length() > 0) nombreProd = this.txtNombreBuscar.getText();
        
        
        // cargando los datos filtrados
        mModeloTabla.setNumRows(0);
        tblDatos.setDefaultRenderer(Object.class, new RenderImagen());

        ArrayList Imagenes;
        
        Productos producto;

        Object Datos[] = new Object[7];
        Imagenes = daoProds.FiltrarImagenes(nombreProd, idProd, idCateg, idProv);
        txtStock.setValue(Imagenes.size());

        if (Imagenes != null) {
            for (int i = 0; i < Imagenes.size(); i++) {
                producto = (Productos) Imagenes.get(i);
                Datos[0] = String.valueOf(producto.getProducto_id());
                Datos[1] = producto.getNombre_producto();
                Datos[2] = producto.getPrecio();
                Datos[3] = producto.getInStock();
                try {
                    byte[] imagen = producto.getFoto();
                    BufferedImage bufferedImage = null;
                    InputStream inputStream = new ByteArrayInputStream(imagen);
                    bufferedImage = ImageIO.read(inputStream);
                    ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0));
                    Datos[4] = new JLabel(mIcono);
                } catch (Exception e) {
                    Datos[4] = new JLabel("No imagen");
                }


                Datos[5] = producto.getCategoria_id();
                Datos[6] = producto.getProveedor_id();

                mModeloTabla.addRow(Datos);
            }

            tblDatos.setModel(mModeloTabla);
            tblDatos.setRowHeight(60);
            tblDatos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblDatos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tblDatos.getColumnModel().getColumn(2).setPreferredWidth(60);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        Limpiar();
        CargarImagenes();
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        Productos prod = new Productos();
        prod.setProducto_id(Integer.parseInt(this.txtID.getText()));
        prod.setNombre_producto(this.txtNombre.getText());
        prod.setPrecio(Float.parseFloat(this.txtPrecio.getValue().toString()));
        prod.setInStock(Integer.parseInt(this.txtStock.getValue().toString()));
        
        Imagenes = daoProds.CargarImagenes();
        Productos prodImagen = (Productos) Imagenes.get(tblDatos.rowAtPoint(evt.getPoint()));
        if(getImagen(Ruta) != null) {
            prod.setFoto(getImagen(Ruta));
        } else {
            prod.setFoto(prodImagen.getFoto());
        }
        
        prod.setCategoria_id(this.cmbCategorias.getSelectedIndex() + 1);
        prod.setProveedor_id(this.cmbProveedores.getSelectedIndex() + 1);
        
        if(JOptionPane.showConfirmDialog(this, "Desea eliminar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            if(daoProds.eliminar(prod)) {
                JOptionPane.showMessageDialog(this, "Producto eliminado con éxito", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Proceso cancelado", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        Limpiar();
        CargarImagenes();
        limpiarCampos();
        deshabilitarCampos();
    }//GEN-LAST:event_btnEliminarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vModificarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vModificarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vModificarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vModificarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vModificarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbCategBuscar;
    private javax.swing.JComboBox<String> cmbCategorias;
    private javax.swing.JComboBox<String> cmbProvBuscar;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JLabel imgProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDBuscar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreBuscar;
    private javax.swing.JSpinner txtPrecio;
    private javax.swing.JSpinner txtStock;
    // End of variables declaration//GEN-END:variables
}
