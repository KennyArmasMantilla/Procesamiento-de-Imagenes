import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Interfaz extends javax.swing.JFrame {
    javax.swing.JFileChooser jFileChooser1;
    javax.swing.JFileChooser jFileChooser2;
    javax.swing.JFileChooser jFileChooser3;
    Imagen imagen;
    Imagen ima;
    String path;
    String pth;
    boolean activado=true;
    int []f = new int[768];
    int []b=new int[96];
    int []d = new int[768];
    int []patron=new int[768];
    String nomb1,nomb2;
    public Interfaz() {
        jFileChooser1  = new javax.swing.JFileChooser();
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        jFileChooser2  = new javax.swing.JFileChooser();
        jFileChooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);

        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu25 = new javax.swing.JMenu();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenu23 = new javax.swing.JMenu();
        jMenuItem59 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenu21 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem56 = new javax.swing.JMenuItem();
        jMenu22 = new javax.swing.JMenu();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenu24 = new javax.swing.JMenu();
        jMenuItem61 = new javax.swing.JMenuItem();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenuItem63 = new javax.swing.JMenuItem();
        jMenuItem68 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procesamiento Digital de Imagenes  By: DarkKingKP");

        jLabel1.setText("Topicos Especiales en Procesamiento Grafico");

        jMenu1.setText("Archivo");
        jMenu1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jMenu1ItemStateChanged(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem6.setText("Abrir Otra Imag");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setText("Guardar Gris");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Guardar RGB");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setText("Convertir Negativo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Guardar Negativo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Escalamiento");

        jMenuItem8.setText("Aumentar x2");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem7.setText("Aumentar NxM");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem10.setText("Reducir a la mitad");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem9.setText("Reducir NxM");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem33.setText("Libre");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem33);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Operaciones");

        jMenuItem11.setText("Suma1");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem15.setText("Suma2");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuItem16.setText("Resta1");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuItem17.setText("Resta2");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuItem18.setText("Resta3");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuItem19.setText("Multiplicacion");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem19);

        jMenuItem20.setText("Division1");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem20);

        jMenuItem21.setText("Division2");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem21);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Rotaciones");

        jMenuItem12.setText("Rotacion 90º Derecha");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem13.setText("Rotacion 90º Izquierda");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuItem14.setText("Rotar 180º ");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem32.setText("Rotacion Libre");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem32);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Operaciones Logicas");

        jMenuItem22.setText("And");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem22);

        jMenuItem23.setText("Or");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem23);

        jMenuItem24.setText("Not");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem24);

        jMenuItem25.setText("NAND");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem25);

        jMenuItem26.setText("XOR");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem26);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Binarizacion");

        jMenuItem28.setText("A color");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem28);

        jMenuItem29.setText("A blanco y Negro");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem29);

        jMenuBar1.add(jMenu7);

        jMenu6.setText("Histograma");

        jMenuItem27.setText("Histograma Color");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem27);

        jMenuItem30.setText("Histograma Gries");
        jMenu6.add(jMenuItem30);

        jMenuBar1.add(jMenu6);

        jMenu9.setText("Morfologia");

        jMenu10.setText("Dilatacion");

        jMenuItem38.setText("Binario");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem38);

        jMenuItem39.setText("Gries");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem39);

        jMenu9.add(jMenu10);

        jMenu11.setText("Erosion");

        jMenuItem34.setText("Binario");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem34);

        jMenuItem40.setText("Gries");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem40);

        jMenu9.add(jMenu11);

        jMenu12.setText("Apertura");

        jMenuItem41.setText("Binario");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem41);

        jMenuItem42.setText("Gries");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem42);

        jMenu9.add(jMenu12);

        jMenu13.setText("Cierre");

        jMenuItem35.setText("Binario");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem35);

        jMenuItem36.setText("Gries");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem36);

        jMenu9.add(jMenu13);

        jMenu25.setText("Top-Hat");

        jMenuItem64.setText("Apertura");
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem64);

        jMenuItem65.setText("Cierre");
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem65);

        jMenu9.add(jMenu25);

        jMenuItem66.setText("Relleno");
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem66);

        jMenuItem67.setText("Esqueleto");
        jMenuItem67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem67ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem67);

        jMenuBar1.add(jMenu9);

        jMenu8.setText("Contornos");

        jMenu14.setText("Gradiente");

        jMenuItem37.setText("Erosion");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem37);

        jMenuItem43.setText("Dilatacion");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem43);

        jMenuItem44.setText("Simetrica");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem44);

        jMenu23.setText("Aproximada");

        jMenuItem59.setText("Binario");
        jMenuItem59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem59ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem59);

        jMenuItem60.setText("Gries");
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem60);

        jMenu14.add(jMenu23);

        jMenu8.add(jMenu14);

        jMenu18.setText("Derivada");

        jMenu19.setText("X");

        jMenuItem55.setText("Binario");
        jMenuItem55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem55ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem55);

        jMenuItem50.setText("Gries");
        jMenuItem50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem50ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem50);

        jMenu18.add(jMenu19);

        jMenu17.setText("Y");

        jMenuItem51.setText("Binario");
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem51);

        jMenuItem52.setText("Gries");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem52);

        jMenu18.add(jMenu17);

        jMenu20.setText("Mutua");

        jMenuItem53.setText("Binario");
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem53);

        jMenuItem54.setText("Gries");
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem54);

        jMenu18.add(jMenu20);

        jMenu21.setText("Cuadratica");

        jMenuItem31.setText("Binario");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem31);

        jMenuItem56.setText("Gries");
        jMenuItem56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem56ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem56);

        jMenu18.add(jMenu21);

        jMenu22.setText("Variable");

        jMenuItem57.setText("Binario");
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem57);

        jMenuItem58.setText("Gries");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem58);

        jMenu18.add(jMenu22);

        jMenu8.add(jMenu18);

        jMenuBar1.add(jMenu8);

        jMenu15.setText("Filtros");

        jMenu16.setText("Suavizado");

        jMenuItem45.setText("Media");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem45);

        jMenuItem46.setText("Maximo");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem46);

        jMenuItem47.setText("Minimo");
        jMenuItem47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem47ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem47);

        jMenuItem48.setText("Mediana");
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem48);

        jMenuItem49.setText("Gausiana");
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem49);

        jMenu15.add(jMenu16);

        jMenu24.setText("Realce");

        jMenuItem61.setText("Roberts");
        jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem61ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem61);

        jMenuItem62.setText("Sobel");
        jMenuItem62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem62ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem62);

        jMenuItem63.setText("Laplaciano");
        jMenuItem63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem63ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem63);

        jMenuItem68.setText("GradienteDigital");
        jMenuItem68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem68ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem68);

        jMenu15.add(jMenu24);

        jMenuBar1.add(jMenu15);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showOpenDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION)
        {
            File nombreImagen = jFileChooser1.getSelectedFile();
            path=nombreImagen.getAbsolutePath();
            nomb1=nombreImagen.getName();
            imagen = new Imagen(path);

        //    System.out.println("esta es lo q muestra"+nomb1);
             try
             {
                 //imag1.add(imagen);
                 JFrame f = new JFrame("Imágenes");
                 f.setResizable(false);
                 f.add(imagen);
        		 f.pack();                
        		 f.setVisible(true);

             }
              catch (Exception e)
              {}
        }
        else
        {}           
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION)
        {
            File archivoImagen = jFileChooser1.getSelectedFile();

            imagen.guardarImagen(imagen.getMatrizImg(),archivoImagen.getAbsolutePath());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION)
        {
            File archivoImagen = jFileChooser1.getSelectedFile();
            imagen.guardarImagen(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed
    private void jMenu1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jMenu1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ItemStateChanged
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
    int valorRetor = jFileChooser2.showOpenDialog(null);
        if (valorRetor == JFileChooser.APPROVE_OPTION)
        {
            File nombImagen = jFileChooser2.getSelectedFile();
            pth=nombImagen.getAbsolutePath();
            ima = new Imagen(pth);
            //nomb2=nombImagen.getName();
            
           try
             {   JFrame f1 = new JFrame("Imágenes");
                 f1.setResizable(false);
                 f1.add(ima);
        		 f1.pack();                
        		 f1.setVisible(true);
              }
              catch (Exception e)
              {}
           }
            else
            {}           
       
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here: int valorRetorno = jFileChooser1.showSaveDialog(null);
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenANegativo(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
        try
             {
                 //imag1.add(imagen);
                
                 JFrame f = new JFrame("Imágenes");
                 f.setResizable(false);
                 f.add(imagen);
                 f.setLocation(500,500);
        		 f.pack();                
        		 f.setVisible(true);

             }
              catch (Exception e)
              {}
        /*
        int valorRetorno = jFileChooser1.showSaveDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION)
        {
            File archivoImagen = jFileChooser1.getSelectedFile();
            imagen.ImagenANegativo(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
             
        }
        */
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION)
        {
            File archivoImagen = jFileChooser1.getSelectedFile();
            imagen.guardarImagenNegativo(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
           
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        //File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenAumento(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),path);
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.guardarImagen(imagen.matrizImg_1,imagen.matrizImg_1,imagen.matrizImg_1,archivoImagen.getAbsolutePath());
        
        /*int valorRetorno = jFileChooser1.showSaveDialog(null);
        if (valorRetorno == JFileChooser.APPROVE_OPTION)
        {
            File archivoImagen = jFileChooser1.getSelectedFile();
            imagen.ImagenAumento(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
        }
        
        /*try
             {
                 //imag1.add(imagen);
                
                 JFrame f = new JFrame("Imágenes");
                 f.setResizable(false);
                 f.add(imagen);
                 f.setLocation(500,500);
        		 f.pack();                
        		 f.setVisible(true);

             }
              catch (Exception e)
              {}
        */      
    }//GEN-LAST:event_jMenuItem8ActionPerformed
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        //int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        String valorN = JOptionPane.showInputDialog("Introduce n: ");
        String valorM = JOptionPane.showInputDialog("Introduce m: ");
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenAumentoNxM(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),Integer.parseInt(valorN), Integer.parseInt(valorM), activado);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        String valorN = JOptionPane.showInputDialog("Introduce n: ");
        String valorM = JOptionPane.showInputDialog("Introduce m: ");
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenReduccion(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),Integer.parseInt(valorN), Integer.parseInt(valorM), activado);
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenReduccionMitad(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
    
    }//GEN-LAST:event_jMenuItem10ActionPerformed
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.SumaImagen1(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenRotacion90Derecha(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
    }//GEN-LAST:event_jMenuItem12ActionPerformed
    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenRotacion90Izquierda(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
    }//GEN-LAST:event_jMenuItem13ActionPerformed
    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ImagenRotacion180(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
    }//GEN-LAST:event_jMenuItem14ActionPerformed
    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        String alfa = JOptionPane.showInputDialog("Introduce alfa: ");
        String beta = JOptionPane.showInputDialog("Introduce beta: ");
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.SumaImagen2(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),
                archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B(),Float.parseFloat(alfa), Float.parseFloat(beta));        
    }//GEN-LAST:event_jMenuItem15ActionPerformed
    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.RestaImagen1(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem16ActionPerformed
    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.RestaImagen2(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem17ActionPerformed
    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.RestaImagen3(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem18ActionPerformed
    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.MultiplicacionImagen(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem19ActionPerformed
    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DivisionImagen1(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem20ActionPerformed
    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DivisionImagen2(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem21ActionPerformed
    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.AndImagen(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
        
    }//GEN-LAST:event_jMenuItem22ActionPerformed
    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.OrImagen(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem23ActionPerformed
    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.NotImagen(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
    }//GEN-LAST:event_jMenuItem24ActionPerformed
    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.NandImagen(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem25ActionPerformed
    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.XORImagen(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),ima.getMatrizImg_R(),ima.getMatrizImg_G(),ima.getMatrizImg_B());        
    }//GEN-LAST:event_jMenuItem26ActionPerformed
    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.BinarizacionImagenColor(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath());
        
    }//GEN-LAST:event_jMenuItem28ActionPerformed
    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.BinarizacionImagenGris(imagen.getMatrizImg(),archivoImagen.getAbsolutePath());
    }//GEN-LAST:event_jMenuItem29ActionPerformed
    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
        imagen.HistogramaImagenColor(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B());
    }//GEN-LAST:event_jMenuItem27ActionPerformed
    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        // TODO add your handling code here:
        String angulo = JOptionPane.showInputDialog("Ángulo de rotación: ");
        imagen.rotarLibreDerecha(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),Float.parseFloat(angulo),path);
    }//GEN-LAST:event_jMenuItem32ActionPerformed
    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        // TODO add your handling code here:
        String valorN = JOptionPane.showInputDialog("Introduce n: ");
        String valorM = JOptionPane.showInputDialog("Introduce m: ");
        int n,m;
        n=Integer.parseInt(valorN);
        m=Integer.parseInt(valorM);
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        if(n>0)
        {
            int Repuesto=1;
            imagen.ImagenAumentoNxM(imagen.getMatrizImg_R(),imagen.getMatrizImg_G(),imagen.getMatrizImg_B(),archivoImagen.getAbsolutePath(),Integer.parseInt(valorN), Repuesto, activado);
        }
        else
        {
            n=Math.abs(n);
        }
        
    }//GEN-LAST:event_jMenuItem33ActionPerformed
    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DilatacionBinario(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem38ActionPerformed
    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ErosionBinario(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem34ActionPerformed
    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.ErosionBinario(imagen.getMatrizImg(),null,activado);
        activado=true;
        //imagen.DilatacionBinario(imagen.matrizImg_R,archivoImagen.getAbsolutePath(),activado);
        int[][] matrizImg_2=imagen.DilatacionBinario(matrizImg1,archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem41ActionPerformed
    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.DilatacionBinario(imagen.getMatrizImg(),null,activado);
        activado=true;
        int[][] matrizImg_2=imagen.ErosionBinario(matrizImg1,archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem35ActionPerformed
    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DilatacionGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem39ActionPerformed
    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.ErosionGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem40ActionPerformed
    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.ErosionGries(imagen.getMatrizImg(),null,activado);
        activado=true;
        //imagen.DilatacionBinario(imagen.matrizImg_R,archivoImagen.getAbsolutePath(),activado);
        int[][] matrizImg_2=imagen.DilatacionGries(matrizImg1,archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem42ActionPerformed
    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.DilatacionGries(imagen.getMatrizImg(),null,activado);
        activado=true;
        int[][] matrizImg_2=imagen.ErosionGries(matrizImg1,archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem36ActionPerformed
    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroMedia(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem45ActionPerformed
    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroMaximo(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem46ActionPerformed
    private void jMenuItem47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem47ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroMinimo(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem47ActionPerformed
    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroMediana(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem48ActionPerformed
    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroMediaGaussiana(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem49ActionPerformed
    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        // TODO add your handling code here:
        //GRADIENTE POR Simetria
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.DilatacionBinario(imagen.getMatrizImg(),null,activado);
        int [][] matrizImg2=imagen.ErosionBinario(imagen.getMatrizImg(),null, activado);
        activado=true;
        //imagen.DilatacionBinario(imagen.matrizImg_R,archivoImagen.getAbsolutePath(),activado);
        int[][] matrizImg_3=imagen.GradienteSimetricaBinario(matrizImg1,matrizImg2,archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem44ActionPerformed
    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        // TODO add your handling code here:
        //GRADIENTE POR Dilatacion
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.DilatacionBinario(imagen.getMatrizImg(),null,activado);
        activado=true;
        //imagen.DilatacionBinario(imagen.matrizImg_R,archivoImagen.getAbsolutePath(),activado);
        int[][] matrizImg_3=imagen.GradienteDilatacionBinario(matrizImg1,imagen.matrizImg_1,archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem43ActionPerformed
    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        // TODO add your handling code here:
        //GRADIENTE POR EROSION
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.ErosionBinario(imagen.getMatrizImg(),null,activado);
        activado=true;
        //imagen.DilatacionBinario(imagen.matrizImg_R,archivoImagen.getAbsolutePath(),activado);
        int[][] matrizImg_3=imagen.GradienteErosionBinario(matrizImg1,imagen.matrizImg_1,archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem37ActionPerformed
    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaXBinario(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem55ActionPerformed
    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaXGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem50ActionPerformed
    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaYBinario(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem51ActionPerformed
    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaYGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem52ActionPerformed
    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaMutuaBinaria(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem53ActionPerformed
    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaMutuaGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem54ActionPerformed
    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaCuadraticaBinaria(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem31ActionPerformed
    private void jMenuItem56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem56ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaCuadraticaGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem56ActionPerformed
    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaVariableBinaria(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem57ActionPerformed
    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.DerivadaVariableGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem58ActionPerformed
    private void jMenuItem59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem59ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.GradienteAproximadaBinaria(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);    
    }//GEN-LAST:event_jMenuItem59ActionPerformed
    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.GradienteAproximadaGries(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem60ActionPerformed
    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroRoberts(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem61ActionPerformed
    private void jMenuItem62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem62ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroSobel(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem62ActionPerformed
    private void jMenuItem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem63ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroLaplaciano(imagen.getMatrizImg(),archivoImagen.getAbsolutePath(),activado);
    }//GEN-LAST:event_jMenuItem63ActionPerformed
    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.ErosionBinario(imagen.getMatrizImg(),null,activado);
        activado=false;
        //imagen.DilatacionBinario(imagen.matrizImg_R,archivoImagen.getAbsolutePath(),activado);
        int[][] matrizImg_2=imagen.DilatacionBinario(matrizImg1,archivoImagen.getAbsolutePath(),activado);
        activado=true;
        imagen.TophatApertura(imagen.getMatrizImg(), matrizImg_2, archivoImagen.getAbsolutePath(), activado);
    }//GEN-LAST:event_jMenuItem64ActionPerformed
    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int [][] matrizImg1=imagen.DilatacionBinario(imagen.getMatrizImg(),null,activado);
        activado=false;
        //imagen.DilatacionBinario(imagen.matrizImg_R,archivoImagen.getAbsolutePath(),activado);
        int[][] matrizImg_2=imagen.ErosionBinario(matrizImg1,archivoImagen.getAbsolutePath(),activado);
        activado=true;
        imagen.TophatCierre(imagen.getMatrizImg(), matrizImg_2, archivoImagen.getAbsolutePath(), activado);
    }//GEN-LAST:event_jMenuItem65ActionPerformed
    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        activado=false;
        int[][] matrizImg_1=imagen.ErosionBinario(imagen.getMatrizImg(), archivoImagen.getAbsolutePath(), activado);
        int[][] matrizImg_2=imagen.ErosionBinario(matrizImg_1, archivoImagen.getAbsolutePath(), activado);
        int[][] matrizImg_3=imagen.DerivadaMutuaGries(matrizImg_2,archivoImagen.getAbsolutePath(),activado);
        
        activado=true;
        //imagen.RellenoRegiones(matrizImg_3,archivoImagen.getAbsolutePath(), activado);
    }//GEN-LAST:event_jMenuItem66ActionPerformed
    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.Esqueleto(imagen.getMatrizImg(), archivoImagen.getAbsolutePath(), activado);
    }//GEN-LAST:event_jMenuItem67ActionPerformed
    private void jMenuItem68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem68ActionPerformed
        // TODO add your handling code here:
        int valorRetorno = jFileChooser1.showSaveDialog(null);//abre la ventana para renombrar a la img para guardar
        File archivoImagen = jFileChooser1.getSelectedFile();
        imagen.FiltroGradienteDigital(imagen.getMatrizImg(), archivoImagen.getAbsolutePath(), activado);
    }//GEN-LAST:event_jMenuItem68ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem56;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem59;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JMenuItem jMenuItem61;
    private javax.swing.JMenuItem jMenuItem62;
    private javax.swing.JMenuItem jMenuItem63;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem68;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables

}
