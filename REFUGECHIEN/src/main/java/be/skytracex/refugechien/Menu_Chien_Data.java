package be.skytracex.refugechien;

import be.skytracex.refugechien.Constructeur.Chien;
import be.skytracex.refugechien.Constructeur.Proprio;
import be.skytracex.refugechien.Constructeur.Refuge;
import be.skytracex.refugechien.DAO.DAO;
import be.skytracex.refugechien.DAO.DAO_CHIEN;
import be.skytracex.refugechien.DAO.DAO_PROPRIO;
import be.skytracex.refugechien.DAO.DAO_REFUGE;
import be.skytracex.refugechien.Enum_Race_Chien.Race_Chien;
import be.skytracex.refugechien.Enum_Sexe_Chien.Sexe_Chien;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
                JOptionPane INFO = new JOptionPane();
                INFO.showMessageDialog(null, "Version 1.0 fait avec <3 par skytraceX");//\n               MAJ du 20/04/22");
 */
/**
 * @author Pc
 */
public class Menu_Chien_Data extends javax.swing.JFrame implements ItemListener, ListSelectionListener {

    private final DAO<Chien, Integer> daoChien = new DAO_CHIEN();
    private final DAO<Refuge, Integer> daoRefuge = new DAO_REFUGE();
    private final DAO<Proprio, Integer> daoProprio = new DAO_PROPRIO();
    private final Chien[] TabloChien;
    private Refuge[] TabloRefuge;
    private Proprio[] TabloProprio;
    private final Controller ctrl = new Controller();
    private Menu_Chien_Data MCD;
    private int Visible;
    LocalDate today = LocalDate.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Menu_Chien_Data() throws SQLException, IOException {
        initComponents();

        TabloChien = daoChien.FindALL();
        TabloRefuge = daoRefuge.FindALL();
        TabloProprio = daoProprio.FindALL();

        CBB_Refuge_Nom_Chien.addItemListener(this);
        CBB_Proprio_Nom_Chien.addItemListener(this);
        CBB_REFUGE_NAME();
        CBB_PROPRIO_NAME();
        ImageMENU();
        JtableAffichageINNERJOIN();
        //JtableAffichage();
        //JtableAffichageFindByName();
        //JtableAffichageFindByRace();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Lay_Chien.setVisible(false);
        Lay_Refuge.setVisible(false);
        Lay_Pro.setVisible(false);
        Lay_Invisible.setVisible(false);

        //CBB pour RACE de chien enum
        CBB_Race_Chien.removeAllItems();
        for (Race_Chien race : Race_Chien.values()) {
            CBB_Race_Chien.addItem(race.toString());
        }
        //CBB pour SEXE de chien enum
        CBB_Sexe.removeAllItems();
        for (Sexe_Chien sexe : Sexe_Chien.values()) {
            CBB_Sexe.addItem(sexe.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePrincipal = new javax.swing.JTable();
        Lbl_Multy_Name = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        LBL_INNERJOIN = new javax.swing.JLabel();
        LBL_IMAGE = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableRECHERCHE = new javax.swing.JTable();
        Lay_Refuge = new javax.swing.JLayeredPane();
        Txt_Nom_Refuge = new javax.swing.JTextField();
        Txt_Adresse_Refuge = new javax.swing.JTextField();
        Txt_Num_Tel = new javax.swing.JTextField();
        LBL_NOMREFUGE = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LBL_NUM_TEL = new javax.swing.JLabel();
        Lay_Refuge_Recherche = new javax.swing.JLayeredPane();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        javax.swing.JButton jButton4 = new javax.swing.JButton();
        Txt_FindByName_Refuge = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        Txt_FindByAdresse_Refuge = new javax.swing.JTextField();
        Lay_Chien = new javax.swing.JLayeredPane();
        Lbl_Entre = new javax.swing.JLabel();
        Txt_Sortie = new javax.swing.JTextField();
        Lbl_Nom = new javax.swing.JLabel();
        Lbl_Nee = new javax.swing.JLabel();
        Lbl_Sex = new javax.swing.JLabel();
        Lbl_Race = new javax.swing.JLabel();
        Txt_Nom = new javax.swing.JTextField();
        Lbl_Sortie = new javax.swing.JLabel();
        Lbl_Refuge = new javax.swing.JLabel();
        Lbl_Proprio = new javax.swing.JLabel();
        CBB_Race_Chien = new javax.swing.JComboBox<>();
        CBB_Sexe = new javax.swing.JComboBox<>();
        CBB_Refuge_Nom_Chien = new javax.swing.JComboBox<>();
        CBB_Proprio_Nom_Chien = new javax.swing.JComboBox<>();
        Txt_Nee = new javax.swing.JTextField();
        Txt_Entre = new javax.swing.JTextField();
        CHECK_Steril = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        Lay_Chien_Recherche = new javax.swing.JLayeredPane();
        Txt_FindByName_Chien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Txt_FindByRace_Chien = new javax.swing.JTextField();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        Lay_Pro = new javax.swing.JLayeredPane();
        Txt_Nom_Pro = new javax.swing.JTextField();
        Txt_Adr_Pro = new javax.swing.JTextField();
        javax.swing.JLabel LBL_ADR_PRO = new javax.swing.JLabel();
        javax.swing.JLabel LBL_NOM_PRO = new javax.swing.JLabel();
        Lay_Proprio_Recherche = new javax.swing.JLayeredPane();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        Txt_FindByAdresse_PRO = new javax.swing.JTextField();
        Txt_FindByName_PRO = new javax.swing.JTextField();
        javax.swing.JLabel jLabel14 = new javax.swing.JLabel();
        javax.swing.JLayeredPane Lay_Rad_Btn = new javax.swing.JLayeredPane();
        Rad_Chien = new javax.swing.JRadioButton();
        Rad_Refuge = new javax.swing.JRadioButton();
        Rad_Proprio = new javax.swing.JRadioButton();
        Lay_Invisible = new javax.swing.JLayeredPane();
        Txt_ID = new javax.swing.JTextField();
        Txt_Refuge = new javax.swing.JTextField();
        Txt_Proprio = new javax.swing.JTextField();
        Lbl_ID = new javax.swing.JLabel();
        Txt_ID_refuge = new javax.swing.JTextField();
        LBL_ID_REFUGE = new javax.swing.JLabel();
        LBL_ID_PRO = new javax.swing.JLabel();
        Txt_ID_Pro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txt_Sterile = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Btn_Delete = new javax.swing.JButton();
        javax.swing.JButton Btn_Fermer_Admin = new javax.swing.JButton();
        javax.swing.JLayeredPane Lay_Btn_Cree_MAJ_Vider = new javax.swing.JLayeredPane();
        Btn_Cree = new javax.swing.JButton();
        Btn_MAJ = new javax.swing.JButton();
        Btn_Vider = new javax.swing.JButton();
        javax.swing.JButton Btn_Admin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TablePrincipal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablePrincipal);

        Lbl_Multy_Name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Lbl_Multy_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Table);

        LBL_INNERJOIN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LBL_INNERJOIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_INNERJOIN.setText("INFO Complementaire");

        TableRECHERCHE.setModel(new javax.swing.table.DefaultTableModel(
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
        TableRECHERCHE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRECHERCHEMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableRECHERCHE);

        Lay_Refuge.setBorder(new javax.swing.border.MatteBorder(null));

        LBL_NOMREFUGE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_NOMREFUGE.setText("Nom : ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Adresse :");

        LBL_NUM_TEL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_NUM_TEL.setText("Num Tel : ");

        Lay_Refuge_Recherche.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("RECHERCHE ");

        jButton4.setBackground(new java.awt.Color(0, 0, 0));

        Txt_FindByName_Refuge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_FindByName_RefugeKeyReleased(evt);
            }
        });

        jLabel4.setText("Nom : ");

        jLabel9.setText("Adresse : ");

        Txt_FindByAdresse_Refuge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_FindByAdresse_RefugeKeyReleased(evt);
            }
        });

        Lay_Refuge_Recherche.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge_Recherche.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge_Recherche.setLayer(Txt_FindByName_Refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge_Recherche.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge_Recherche.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge_Recherche.setLayer(Txt_FindByAdresse_Refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_Refuge_RechercheLayout = new javax.swing.GroupLayout(Lay_Refuge_Recherche);
        Lay_Refuge_Recherche.setLayout(Lay_Refuge_RechercheLayout);
        Lay_Refuge_RechercheLayout.setHorizontalGroup(
            Lay_Refuge_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Lay_Refuge_RechercheLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_Refuge_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Lay_Refuge_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_FindByAdresse_Refuge)
                    .addComponent(Txt_FindByName_Refuge))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_Refuge_RechercheLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        Lay_Refuge_RechercheLayout.setVerticalGroup(
            Lay_Refuge_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_Refuge_RechercheLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_Refuge_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Txt_FindByName_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_Refuge_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Txt_FindByAdresse_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Lay_Refuge.setLayer(Txt_Nom_Refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge.setLayer(Txt_Adresse_Refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge.setLayer(Txt_Num_Tel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge.setLayer(LBL_NOMREFUGE, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge.setLayer(LBL_NUM_TEL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Refuge.setLayer(Lay_Refuge_Recherche, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_RefugeLayout = new javax.swing.GroupLayout(Lay_Refuge);
        Lay_Refuge.setLayout(Lay_RefugeLayout);
        Lay_RefugeLayout.setHorizontalGroup(
            Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_RefugeLayout.createSequentialGroup()
                .addGroup(Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_RefugeLayout.createSequentialGroup()
                        .addGroup(Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_NOMREFUGE, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_RefugeLayout.createSequentialGroup()
                        .addComponent(LBL_NUM_TEL)
                        .addGap(8, 8, 8)))
                .addGroup(Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_Num_Tel)
                    .addComponent(Txt_Nom_Refuge)
                    .addComponent(Txt_Adresse_Refuge))
                .addGap(6, 6, 6))
            .addGroup(Lay_RefugeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lay_Refuge_Recherche)
                .addContainerGap())
        );
        Lay_RefugeLayout.setVerticalGroup(
            Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_RefugeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_RefugeLayout.createSequentialGroup()
                        .addComponent(Txt_Nom_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Adresse_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Lay_RefugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Num_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_NUM_TEL)))
                    .addComponent(LBL_NOMREFUGE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lay_Refuge_Recherche)
                .addContainerGap())
        );

        Lay_Chien.setBorder(new javax.swing.border.MatteBorder(null));

        Lbl_Entre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Entre.setText("ENTRÉ LE :");
        Lbl_Entre.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Entre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        Lbl_Nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Nom.setText("NOM :");

        Lbl_Nee.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Nee.setText("NÉ LE :");

        Lbl_Sex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Sex.setText("SEXE :");

        Lbl_Race.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Race.setText("RACE :");

        Lbl_Sortie.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Sortie.setText("SORTIE LE :");
        Lbl_Sortie.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Sortie.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        Lbl_Refuge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Refuge.setText("REFUGE :");
        Lbl_Refuge.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Refuge.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        Lbl_Proprio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_Proprio.setText("PROPRIÉTAIRE :");
        Lbl_Proprio.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Proprio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        CBB_Race_Chien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBB_Sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBB_Refuge_Nom_Chien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBB_Proprio_Nom_Chien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CHECK_Steril.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHECK_SterilActionPerformed(evt);
            }
        });

        jLabel8.setText("A ÉTÉ STÉRILISÉ : ");

        Lay_Chien_Recherche.setBorder(new javax.swing.border.MatteBorder(null));

        Txt_FindByName_Chien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_FindByName_ChienKeyReleased(evt);
            }
        });

        jLabel1.setText("Nom :");

        jLabel3.setText("Race :");

        Txt_FindByRace_Chien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_FindByRace_ChienKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("RECHERCHE ");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));

        Lay_Chien_Recherche.setLayer(Txt_FindByName_Chien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien_Recherche.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien_Recherche.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien_Recherche.setLayer(Txt_FindByRace_Chien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien_Recherche.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien_Recherche.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_Chien_RechercheLayout = new javax.swing.GroupLayout(Lay_Chien_Recherche);
        Lay_Chien_Recherche.setLayout(Lay_Chien_RechercheLayout);
        Lay_Chien_RechercheLayout.setHorizontalGroup(
            Lay_Chien_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Lay_Chien_RechercheLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(Lay_Chien_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_Chien_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txt_FindByName_Chien, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(Txt_FindByRace_Chien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_Chien_RechercheLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        Lay_Chien_RechercheLayout.setVerticalGroup(
            Lay_Chien_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_Chien_RechercheLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(Lay_Chien_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_Chien_RechercheLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txt_FindByName_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_Chien_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_FindByRace_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        Lay_Chien.setLayer(Lbl_Entre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Txt_Sortie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lbl_Nom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lbl_Nee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lbl_Sex, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lbl_Race, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Txt_Nom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lbl_Sortie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lbl_Refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lbl_Proprio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(CBB_Race_Chien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(CBB_Sexe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(CBB_Refuge_Nom_Chien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(CBB_Proprio_Nom_Chien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Txt_Nee, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Txt_Entre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(CHECK_Steril, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Chien.setLayer(Lay_Chien_Recherche, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_ChienLayout = new javax.swing.GroupLayout(Lay_Chien);
        Lay_Chien.setLayout(Lay_ChienLayout);
        Lay_ChienLayout.setHorizontalGroup(
            Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_ChienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Lay_Chien_Recherche)
                    .addGroup(Lay_ChienLayout.createSequentialGroup()
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_ChienLayout.createSequentialGroup()
                                .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Lbl_Nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Lbl_Nee, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Lbl_Race, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lbl_Sex, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(Lay_ChienLayout.createSequentialGroup()
                                .addComponent(Lbl_Proprio)
                                .addGap(7, 7, 7)))
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CBB_Proprio_Nom_Chien, 0, 115, Short.MAX_VALUE)
                            .addComponent(Txt_Nom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBB_Race_Chien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Txt_Nee, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBB_Sexe, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Lay_ChienLayout.createSequentialGroup()
                                .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Lay_ChienLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Lbl_Entre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Lbl_Sortie, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_ChienLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(Lbl_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_Sortie)
                                    .addComponent(Txt_Entre)
                                    .addGroup(Lay_ChienLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(CBB_Refuge_Nom_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(Lay_ChienLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CHECK_Steril)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        Lay_ChienLayout.setVerticalGroup(
            Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_ChienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Lay_ChienLayout.createSequentialGroup()
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_Nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Txt_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_Nee, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_Nee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBB_Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_Sex))
                        .addGap(10, 10, 10)
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_Race)
                            .addComponent(CBB_Race_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Lay_ChienLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(CHECK_Steril))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Entre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_Entre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_Sortie)
                            .addComponent(Txt_Sortie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBB_Refuge_Nom_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_ChienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBB_Proprio_Nom_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_Proprio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(Lay_Chien_Recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Lay_Pro.setBorder(new javax.swing.border.MatteBorder(null));

        LBL_ADR_PRO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_ADR_PRO.setText("Adresse :");

        LBL_NOM_PRO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_NOM_PRO.setText("Nom :");

        Lay_Proprio_Recherche.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("RECHERCHE ");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel13.setText("Adresse : ");

        Txt_FindByAdresse_PRO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_FindByAdresse_PROKeyReleased(evt);
            }
        });

        Txt_FindByName_PRO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_FindByName_PROKeyReleased(evt);
            }
        });

        jLabel14.setText("Nom : ");

        Lay_Proprio_Recherche.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Proprio_Recherche.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Proprio_Recherche.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Proprio_Recherche.setLayer(Txt_FindByAdresse_PRO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Proprio_Recherche.setLayer(Txt_FindByName_PRO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Proprio_Recherche.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_Proprio_RechercheLayout = new javax.swing.GroupLayout(Lay_Proprio_Recherche);
        Lay_Proprio_Recherche.setLayout(Lay_Proprio_RechercheLayout);
        Lay_Proprio_RechercheLayout.setHorizontalGroup(
            Lay_Proprio_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_Proprio_RechercheLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_Proprio_RechercheLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(Lay_Proprio_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Lay_Proprio_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_FindByName_PRO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_FindByAdresse_PRO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        Lay_Proprio_RechercheLayout.setVerticalGroup(
            Lay_Proprio_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_Proprio_RechercheLayout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_Proprio_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(Txt_FindByName_PRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_Proprio_RechercheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Txt_FindByAdresse_PRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Lay_Pro.setLayer(Txt_Nom_Pro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Pro.setLayer(Txt_Adr_Pro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Pro.setLayer(LBL_ADR_PRO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Pro.setLayer(LBL_NOM_PRO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Pro.setLayer(Lay_Proprio_Recherche, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_ProLayout = new javax.swing.GroupLayout(Lay_Pro);
        Lay_Pro.setLayout(Lay_ProLayout);
        Lay_ProLayout.setHorizontalGroup(
            Lay_ProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_ProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_ProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_ProLayout.createSequentialGroup()
                        .addComponent(Lay_Proprio_Recherche)
                        .addContainerGap())
                    .addGroup(Lay_ProLayout.createSequentialGroup()
                        .addGroup(Lay_ProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_NOM_PRO, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_ADR_PRO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Lay_ProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_Adr_Pro)
                            .addComponent(Txt_Nom_Pro)))))
        );
        Lay_ProLayout.setVerticalGroup(
            Lay_ProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_ProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_ProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Nom_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_NOM_PRO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Lay_ProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Adr_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_ADR_PRO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lay_Proprio_Recherche)
                .addContainerGap())
        );

        Lay_Rad_Btn.setBorder(new javax.swing.border.MatteBorder(null));

        buttonGroup1.add(Rad_Chien);
        Rad_Chien.setText("CHIEN");
        Rad_Chien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rad_ChienActionPerformed(evt);
            }
        });

        buttonGroup1.add(Rad_Refuge);
        Rad_Refuge.setText("REFUGE");
        Rad_Refuge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rad_RefugeActionPerformed(evt);
            }
        });

        buttonGroup1.add(Rad_Proprio);
        Rad_Proprio.setText("PROPRIO");
        Rad_Proprio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rad_ProprioActionPerformed(evt);
            }
        });

        Lay_Rad_Btn.setLayer(Rad_Chien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Rad_Btn.setLayer(Rad_Refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Rad_Btn.setLayer(Rad_Proprio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_Rad_BtnLayout = new javax.swing.GroupLayout(Lay_Rad_Btn);
        Lay_Rad_Btn.setLayout(Lay_Rad_BtnLayout);
        Lay_Rad_BtnLayout.setHorizontalGroup(
            Lay_Rad_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_Rad_BtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_Rad_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_Rad_BtnLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(Lay_Rad_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Rad_Proprio)
                            .addComponent(Rad_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Rad_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        Lay_Rad_BtnLayout.setVerticalGroup(
            Lay_Rad_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_Rad_BtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Rad_Chien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rad_Refuge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rad_Proprio)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Lay_Invisible.setBorder(new javax.swing.border.MatteBorder(null));

        Lbl_ID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_ID.setText("ID CHIEN :");

        LBL_ID_REFUGE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_ID_REFUGE.setText("ID REFUGE :");

        LBL_ID_PRO.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_ID_PRO.setText("ID PROPRIO : ");

        jLabel5.setText("ID PROPRIO CHIEN : ");

        jLabel6.setText("ID REFUGE CHIEN : ");

        jLabel7.setText("STÉRIL TRUE/FALSE : ");

        Btn_Delete.setBackground(new java.awt.Color(204, 0, 0));
        Btn_Delete.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Btn_Delete.setText("DELETE CHIEN");

        Btn_Fermer_Admin.setBackground(new java.awt.Color(51, 255, 51));
        Btn_Fermer_Admin.setText("FERMER");
        Btn_Fermer_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Fermer_AdminActionPerformed(evt);
            }
        });

        Lay_Invisible.setLayer(Txt_ID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Txt_Refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Txt_Proprio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Lbl_ID, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Txt_ID_refuge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(LBL_ID_REFUGE, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(LBL_ID_PRO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Txt_ID_Pro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Txt_Sterile, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Btn_Delete, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Invisible.setLayer(Btn_Fermer_Admin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_InvisibleLayout = new javax.swing.GroupLayout(Lay_Invisible);
        Lay_Invisible.setLayout(Lay_InvisibleLayout);
        Lay_InvisibleLayout.setHorizontalGroup(
            Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Proprio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txt_Refuge))
                    .addComponent(jLabel7)
                    .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(Txt_Sterile, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Lbl_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_InvisibleLayout.createSequentialGroup()
                        .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LBL_ID_PRO)
                            .addComponent(LBL_ID_REFUGE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_ID_refuge, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Txt_ID_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(Btn_Fermer_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Lay_InvisibleLayout.setVerticalGroup(
            Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(Txt_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(Txt_Proprio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Lbl_ID)))
                .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_ID_PRO)
                            .addComponent(Txt_ID_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_ID_refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_ID_REFUGE)))
                    .addGroup(Lay_InvisibleLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(Lay_InvisibleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_Sterile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Fermer_Admin)
                .addContainerGap())
        );

        Lay_Btn_Cree_MAJ_Vider.setBorder(new javax.swing.border.MatteBorder(null));

        Btn_Cree.setBackground(new java.awt.Color(51, 255, 51));
        Btn_Cree.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Btn_Cree.setText("Créé");
        Btn_Cree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CreeActionPerformed(evt);
            }
        });

        Btn_MAJ.setBackground(new java.awt.Color(255, 255, 51));
        Btn_MAJ.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Btn_MAJ.setText("MAJ");
        Btn_MAJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MAJActionPerformed(evt);
            }
        });

        Btn_Vider.setBackground(new java.awt.Color(204, 0, 204));
        Btn_Vider.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Btn_Vider.setText("VIDER");
        Btn_Vider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ViderActionPerformed(evt);
            }
        });

        Btn_Admin.setBackground(new java.awt.Color(51, 255, 153));
        Btn_Admin.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Btn_Admin.setText("ADMIN");
        Btn_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AdminActionPerformed(evt);
            }
        });

        Lay_Btn_Cree_MAJ_Vider.setLayer(Btn_Cree, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Btn_Cree_MAJ_Vider.setLayer(Btn_MAJ, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Btn_Cree_MAJ_Vider.setLayer(Btn_Vider, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Lay_Btn_Cree_MAJ_Vider.setLayer(Btn_Admin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Lay_Btn_Cree_MAJ_ViderLayout = new javax.swing.GroupLayout(Lay_Btn_Cree_MAJ_Vider);
        Lay_Btn_Cree_MAJ_Vider.setLayout(Lay_Btn_Cree_MAJ_ViderLayout);
        Lay_Btn_Cree_MAJ_ViderLayout.setHorizontalGroup(
            Lay_Btn_Cree_MAJ_ViderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_Btn_Cree_MAJ_ViderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lay_Btn_Cree_MAJ_ViderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_Vider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Cree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_MAJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addContainerGap())
        );
        Lay_Btn_Cree_MAJ_ViderLayout.setVerticalGroup(
            Lay_Btn_Cree_MAJ_ViderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lay_Btn_Cree_MAJ_ViderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Btn_Cree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_MAJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Vider, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Lay_Rad_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Lay_Btn_Cree_MAJ_Vider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Lay_Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Lay_Invisible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Lay_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Lay_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LBL_IMAGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LBL_INNERJOIN, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(566, 566, 566)
                            .addComponent(Lbl_Multy_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lay_Rad_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lay_Pro))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Lay_Btn_Cree_MAJ_Vider)
                                .addGap(18, 18, 18)))
                        .addComponent(Lay_Invisible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lay_Chien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lay_Refuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LBL_INNERJOIN)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LBL_IMAGE, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbl_Multy_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
////////////////////      JCREATE       ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    private void Btn_CreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CreeActionPerformed

        switch (Visible) {
            case 1 -> {
                String Name, Sexe, Race,
                        DateN = this.Txt_Nee.getText(),
                        DateE = this.Txt_Entre.getText();

                Boolean Steril;
                Integer ID_Pro, ID_Ref;

                Name = this.Txt_Nom.getText();
                Sexe = (String) this.CBB_Sexe.getSelectedItem();
                Race = (String) this.CBB_Race_Chien.getSelectedItem();
                Steril = Boolean.valueOf(this.Txt_Sterile.getText());
                ID_Pro = Integer.valueOf(this.Txt_Proprio.getText());
                ID_Ref = Integer.valueOf(this.Txt_Refuge.getText());
                LocalDate ld = LocalDate.parse(DateN, dtf);
                LocalDate ld2 = LocalDate.parse(DateE, dtf);
                Chien c = new Chien(Name, ld, Sexe, Race, Steril, ld2, ID_Pro, ID_Ref);

                try {
                    ctrl.AddChien(c);
                } catch (SQLException ex) {
                    Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            case 2 -> {
                String Name, Adresse, Num;

                Name = this.Txt_Nom_Refuge.getText();
                Adresse = this.Txt_Adresse_Refuge.getText();
                Num = this.Txt_Num_Tel.getText();

                Refuge r = new Refuge(Name, Adresse, Num);

                ctrl.AddRefuge(r);

            }
            case 3 -> {
                String Name, Adresse;

                Name = this.Txt_Nom_Pro.getText();
                Adresse = this.Txt_Adr_Pro.getText();

                Proprio p = new Proprio(Name, Adresse);

                ctrl.AddProprio(p);

            }
            default -> {
            }

        }
        try {
            JtableAffichage();
            JtableAffichageINNERJOIN();
            JTableAfficheFindByAdresse_Proprio();
            JTableAfficheFindByAdresse_Refuge();
            JTableAfficheFindByName_Proprio();
            JTableAfficheFindByName_Refuge();
            JtableAffichageFindByName();
            JtableAffichageFindByRace();
            CBB_REFUGE_NAME();
            CBB_PROPRIO_NAME();
            ReloadMenu();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, "Erreur", ex);
            System.err.println("Erreur : " + ex.getMessage());
        }

    }//GEN-LAST:event_Btn_CreeActionPerformed
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
////////////////////      JUPDATE       ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    private void Btn_MAJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MAJActionPerformed

        switch (Visible) {
            case 1 -> {
                String Name, Sexe, Race,
                        DateN = this.Txt_Nee.getText(),
                        DateE = this.Txt_Entre.getText(),
                        DateS = this.Txt_Sortie.getText();

                Boolean Steril;
                Integer ID_Pro, ID_Ref, ID_Chien;
                try {
                    if (this.Txt_Sortie.getText().isEmpty()) {
                        Name = this.Txt_Nom.getText();
                        Sexe = (String) this.CBB_Sexe.getSelectedItem();
                        Race = (String) this.CBB_Race_Chien.getSelectedItem();
                        Steril = Boolean.valueOf(this.Txt_Sterile.getText());
                        ID_Pro = Integer.valueOf(this.Txt_Proprio.getText());
                        ID_Chien = Integer.valueOf(this.Txt_ID.getText());
                        ID_Ref = Integer.valueOf(this.Txt_Refuge.getText());
                        LocalDate ld = LocalDate.parse(DateN, dtf);
                        LocalDate ld2 = LocalDate.parse(DateE, dtf);

                        Chien c = new Chien(ID_Chien, Name, ld, Sexe, Race, Steril, ld2, ID_Pro, ID_Ref);

                        ctrl.MajChien2(c);

                    } else {
                        Name = this.Txt_Nom.getText();
                        Sexe = (String) this.CBB_Sexe.getSelectedItem();
                        Race = (String) this.CBB_Race_Chien.getSelectedItem();
                        Steril = Boolean.valueOf(this.Txt_Sterile.getText());
                        ID_Pro = Integer.valueOf(this.Txt_Proprio.getText());
                        ID_Chien = Integer.valueOf(this.Txt_ID.getText());
                        ID_Ref = Integer.valueOf(this.Txt_Refuge.getText());
                        LocalDate ld = LocalDate.parse(DateN, dtf);
                        LocalDate ld2 = LocalDate.parse(DateE, dtf);
                        LocalDate ld3 = LocalDate.parse(DateS, dtf);

                        Chien c = new Chien(ID_Chien, Name, ld, Sexe, Race, Steril, ld2, ld3, ID_Pro, ID_Ref);

                        ctrl.MajChien(c);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("Erreur : " + ex.getMessage());

                }
            }
            case 2 -> {
                String Name, Adresse, Num;
                Integer ID_Refuge;
                try {
                    Name = this.Txt_Nom_Refuge.getText();
                    Adresse = this.Txt_Adresse_Refuge.getText();
                    Num = this.Txt_Num_Tel.getText();
                    ID_Refuge = Integer.valueOf(this.Txt_ID_refuge.getText());

                    Refuge r = new Refuge(ID_Refuge, Name, Adresse, Num);

                    ctrl.MajRefuge(r);

                } catch (SQLException ex) {
                    Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("Erreur : " + ex.getMessage());
                }
            }
            case 3 -> {
                String Name, Adresse;
                Integer ID_PRO;
                Name = this.Txt_Nom_Pro.getText();
                Adresse = this.Txt_Adr_Pro.getText();
                ID_PRO = Integer.valueOf(this.Txt_ID_Pro.getText());
                Proprio p = new Proprio(ID_PRO, Name, Adresse);
                ctrl.MajProprio(p);
            }

            default -> {
            }
        }
        try {
            JtableAffichage();
            JtableAffichageINNERJOIN();
            JTableAfficheFindByAdresse_Proprio();
            JTableAfficheFindByAdresse_Refuge();
            JTableAfficheFindByName_Proprio();
            JTableAfficheFindByName_Refuge();
            JtableAffichageFindByName();
            JtableAffichageFindByRace();
            CBB_REFUGE_NAME();
            CBB_PROPRIO_NAME();
            ReloadMenu();
        } catch (SQLException | FileNotFoundException sQLException) {
        }
    }//GEN-LAST:event_Btn_MAJActionPerformed
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
/////////////////////      JRADIO       ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    private void Rad_ChienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rad_ChienActionPerformed
        Visible = 1;
        try {
            JtableAffichage();
            JtableAffichageINNERJOIN();
            JtableAffichageFindByName();
            JtableAffichageFindByRace();
            CBB_REFUGE_NAME();
            CBB_PROPRIO_NAME();
            CheckEarly();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Lbl_Multy_Name.setText("CHIEN");
        Lay_Chien.setVisible(true);
        Lay_Refuge.setVisible(false);
        Lay_Pro.setVisible(false);
        Btn_ViderActionPerformed(evt);
    }//GEN-LAST:event_Rad_ChienActionPerformed

    private void Rad_RefugeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rad_RefugeActionPerformed
        Visible = 2;
        try {
            JtableAffichage();
            JtableAffichageINNERJOIN();
            JTableAfficheFindByAdresse_Refuge();
            JTableAfficheFindByName_Refuge();
            CBB_REFUGE_NAME();
            CBB_PROPRIO_NAME();
            CheckEarly();

        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Lbl_Multy_Name.setText("REFUGE");
        Lay_Refuge.setVisible(true);
        Lay_Chien.setVisible(false);
        Lay_Pro.setVisible(false);
    }//GEN-LAST:event_Rad_RefugeActionPerformed

    private void Rad_ProprioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rad_ProprioActionPerformed
        Visible = 3;
        try {
            JtableAffichage();
            JtableAffichageINNERJOIN();
            JTableAfficheFindByAdresse_Proprio();
            JTableAfficheFindByName_Proprio();
            CBB_REFUGE_NAME();
            CBB_PROPRIO_NAME();
            CheckEarly();

        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Lbl_Multy_Name.setText("PROPRIO");
        Lay_Pro.setVisible(true);
        Lay_Refuge.setVisible(false);
        Lay_Chien.setVisible(false);
    }//GEN-LAST:event_Rad_ProprioActionPerformed
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
/////////////////////      JVIDER       ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    private void Btn_ViderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ViderActionPerformed
        this.Txt_Nom.setText("");
        this.Txt_Nee.setText("");
        this.Txt_Entre.setText(today.format(dtf));
        this.Txt_Sortie.setText("");

    }//GEN-LAST:event_Btn_ViderActionPerformed
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
/////////////////////      JCHECK      ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    private void CHECK_SterilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHECK_SterilActionPerformed
        if (this.CHECK_Steril.isSelected()) {
            this.Txt_Sterile.setText("true");
            this.CHECK_Steril.setText("OUI");
        } else {
            this.Txt_Sterile.setText("false");
            this.CHECK_Steril.setText("NON");
        }
    }//GEN-LAST:event_CHECK_SterilActionPerformed

    private void Txt_FindByName_ChienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_FindByName_ChienKeyReleased
        try {
            JtableAffichageFindByName();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Txt_FindByName_ChienKeyReleased

    private void Txt_FindByRace_ChienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_FindByRace_ChienKeyReleased
        try {
            JtableAffichageFindByRace();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Txt_FindByRace_ChienKeyReleased

    private void Btn_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AdminActionPerformed

        String password = "Admin1234";
        String inputPassword = JOptionPane.showInputDialog("Entrez votre MDP");
        if (inputPassword != null && inputPassword.equals(password)) {
            Lay_Invisible.setVisible(true);
            Lay_Refuge.setVisible(false);
            Lay_Pro.setVisible(false);
            Lay_Chien.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "MDP incorect");
        }


    }//GEN-LAST:event_Btn_AdminActionPerformed

    private void Btn_Fermer_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Fermer_AdminActionPerformed
        this.Lay_Invisible.setVisible(false);
    }//GEN-LAST:event_Btn_Fermer_AdminActionPerformed

    private void Txt_FindByName_RefugeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_FindByName_RefugeKeyReleased
        try {
            JTableAfficheFindByName_Refuge();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Txt_FindByName_RefugeKeyReleased

    private void Txt_FindByAdresse_RefugeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_FindByAdresse_RefugeKeyReleased
        try {
            JTableAfficheFindByAdresse_Refuge();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Txt_FindByAdresse_RefugeKeyReleased

    private void Txt_FindByName_PROKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_FindByName_PROKeyReleased
        try {
            JTableAfficheFindByName_Proprio();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Txt_FindByName_PROKeyReleased

    private void Txt_FindByAdresse_PROKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_FindByAdresse_PROKeyReleased
        try {
            JTableAfficheFindByAdresse_Proprio();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Txt_FindByAdresse_PROKeyReleased

    private void TableRECHERCHEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRECHERCHEMouseClicked

        if (Visible == 1) {
            if (evt.getClickCount() == 1) { // vérifier si l'utilisateur a cliqué une fois
                int row = TableRECHERCHE.getSelectedRow();
                if (row >= 0 && row < TableRECHERCHE.getRowCount()) {
                    String chienName = (String) TableRECHERCHE.getValueAt(row, 0);
                    List<Chien> c = ctrl.getChiensByName(chienName);
                    JOptionPane.showMessageDialog(null, "Information :\n" + c);
                }
            }
        } else if (Visible == 2) {
            if (evt.getClickCount() == 1) { // vérifier si l'utilisateur a cliqué une fois
                int row = TableRECHERCHE.getSelectedRow();
                if (row >= 0 && row < TableRECHERCHE.getRowCount()) {
                    String RefugeName = (String) TableRECHERCHE.getValueAt(row, 0);
                    List<Refuge> r;
                    try {
                        r = ctrl.getRefugeByName(RefugeName);
                        JOptionPane.showMessageDialog(null, "Information :\n" + r);
                    } catch (SQLException ex) {
                        Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        } else if (Visible == 3) {
            if (evt.getClickCount() == 1) { // vérifier si l'utilisateur a cliqué une fois
                int row = TableRECHERCHE.getSelectedRow();
                if (row >= 0 && row < TableRECHERCHE.getRowCount()) {
                    String ProprioName = (String) TableRECHERCHE.getValueAt(row, 0);
                    List<Proprio> p;
                    try {
                        p = ctrl.getProprioByName(ProprioName);
                        JOptionPane.showMessageDialog(null, "Information :\n" + p);
                    } catch (SQLException ex) {
                        Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }
    }//GEN-LAST:event_TableRECHERCHEMouseClicked

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
            java.util.logging.Logger.getLogger(Menu_Chien_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Chien_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Chien_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Chien_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Menu_Chien_Data().setVisible(true);

            } catch (SQLException | IOException ex) {
                Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
///////////////////      JAFFICHE       ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////

    private void Affichage_CHIEN(Chien c) {
        this.Txt_ID.setText(String.valueOf(c.getID_Chien()));
        this.Txt_Nom.setText(String.valueOf(c.getNom_Chien()));
        this.Txt_Nee.setText(c.getDate_Chien().format(dtf));
        this.CBB_Sexe.setSelectedItem(c.getSex_Chien());
        this.CBB_Race_Chien.setSelectedItem(c.getRace_Chien());
        this.CHECK_Steril.setText(String.valueOf(c.isSteril_Chien()));
        this.CHECK_Steril.setSelected(c.isSteril_Chien());
        this.Txt_Entre.setText(c.getDate_Entre_Chien().format(dtf));
        LocalDate dateSortie = c.getDate_Sortie_Chien();
        if (dateSortie != null) {
            this.Txt_Sortie.setText(c.getDate_Sortie_Chien().format(dtf));
        } else {
            this.Txt_Sortie.setText("");
        }
        this.Txt_Refuge.setText(String.valueOf(c.getID_Refuge_Chien()));
        this.Txt_Proprio.setText(String.valueOf(c.getID_Proprio_Chien()));

    }

    private void Affichage_REFUGE(Refuge r) {
        this.Txt_ID_refuge.setText(String.valueOf(r.getId()));
        this.Txt_Nom_Refuge.setText(String.valueOf(r.getNom()));
        this.Txt_Adresse_Refuge.setText(r.getAdresse());
        this.Txt_Num_Tel.setText(r.getNumTel());

    }

    private void Affichage_PROPRIO(Proprio p) {
        this.Txt_ID_Pro.setText(String.valueOf(p.getIdProprio()));
        this.Txt_Nom_Pro.setText(String.valueOf(p.getNomProprio()));
        this.Txt_Adr_Pro.setText(String.valueOf(p.getAdresseProprio()));

    }

///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
/////////////////////      JCOMBO       ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////  
    public void CBB_REFUGE_NAME() throws SQLException {

        int index = CBB_Refuge_Nom_Chien.getSelectedIndex();
        index++;
        TabloRefuge = daoRefuge.Find_Refuge_Name();
        this.CBB_Refuge_Nom_Chien.removeAllItems();
        for (Refuge refuge : TabloRefuge) {
            this.CBB_Refuge_Nom_Chien.addItem(refuge.getNom());

        }
    }

    public void CBB_PROPRIO_NAME() throws SQLException {
        int index2 = CBB_Proprio_Nom_Chien.getSelectedIndex();
        index2++;
        TabloProprio = daoProprio.Find_Proprio_Name();
        this.CBB_Proprio_Nom_Chien.removeAllItems();
        for (Proprio pro : TabloProprio) {
            this.CBB_Proprio_Nom_Chien.addItem(pro.getNomProprio());

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            int index = CBB_Refuge_Nom_Chien.getSelectedIndex() + 1;
            //System.out.println("Index : " + index);
            this.Txt_Refuge.setText(String.valueOf(index));
            for (Refuge r : TabloRefuge) {
                if (r.getNom() == this.CBB_Refuge_Nom_Chien.getSelectedItem() || r.getNom() == this.CBB_Proprio_Nom_Chien.getSelectedItem()) {
                    Affichage_REFUGE(r);
                    if (r.getNom() == this.CBB_Proprio_Nom_Chien.getSelectedItem()) {
                        break;
                    }
                }
            }
            int index2 = CBB_Proprio_Nom_Chien.getSelectedIndex() + 1;
            //System.out.println("Index2 : " + index2);
            this.Txt_Proprio.setText(String.valueOf(index2));
            for (Proprio p : TabloProprio) {
                if (p.getNomProprio() == this.CBB_Proprio_Nom_Chien.getSelectedItem() || p.getNomProprio() == this.CBB_Proprio_Nom_Chien.getSelectedItem()) {
                    Affichage_PROPRIO(p);
                    if (p.getNomProprio() == this.CBB_Proprio_Nom_Chien.getSelectedItem()) {
                        break;
                    }
                }
            }
        }
        if (e.getStateChange() == ItemEvent.SELECTED) {
            for (Refuge r : TabloRefuge) {
                int index = CBB_Refuge_Nom_Chien.getSelectedIndex();
                index++;
                this.Txt_Refuge.setText(String.valueOf(index));
                if (r.getNom() == this.CBB_Refuge_Nom_Chien.getSelectedItem()) {
                    Affichage_REFUGE(r);

                    break;
                }
            }
        }
        if (e.getStateChange() == ItemEvent.SELECTED) {
            for (Proprio p : TabloProprio) {
                int index2 = CBB_Proprio_Nom_Chien.getSelectedIndex();
                index2++;
                this.Txt_Proprio.setText(String.valueOf(index2));
                if (p.getNomProprio() == this.CBB_Proprio_Nom_Chien.getSelectedItem()) {
                    Affichage_PROPRIO(p);
                    //System.out.println(index2);
                    break;
                }
            }
        }
    }
    ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////
    /////////////////////      JTABLE       ///////////////////////
    ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////

    public void JtableAffichage() throws SQLException, FileNotFoundException {

        switch (Visible) {
            case 1 -> {

                DefaultTableModel dtm = new DefaultTableModel();
                ResultSetMetaData rsmd;

                ResultSet rs = daoChien.InnerJoin2();
                rsmd = rs.getMetaData();

                this.TablePrincipal.removeAll();

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    dtm.addColumn(rsmd.getColumnName(i));
                }

                try {
                    while (rs.next()) {
                        String ligne[] = {String.valueOf(rs.getInt(1)),
                            rs.getString(2),
                            rs.getTimestamp(3).toLocalDateTime().format(dtf),
                            rs.getString(4),
                            rs.getString(5),
                            String.valueOf(rs.getBoolean(6)),
                            rs.getTimestamp(7).toLocalDateTime().format(dtf),
                            (rs.getTimestamp(8) != null) ? rs.getTimestamp(8).toLocalDateTime().format(dtf) : "",
                            rs.getString(9),
                            rs.getString(10)};

                        dtm.addRow(ligne);
                    }
                    CBB_REFUGE_NAME();
                    CBB_PROPRIO_NAME();
                    CheckEarly();
                    this.TablePrincipal.setModel(dtm);
                    this.TablePrincipal.getSelectionModel().addListSelectionListener(this);

                } catch (SQLException ex) {
                    Logger.getLogger(DAO_CHIEN.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
            case 2 -> {
                ResultSet rs = daoRefuge.FindAllRs();
                String entete[] = {"ID", "Nom", "Adresse", "Num"};

                DefaultTableModel dtm = new DefaultTableModel();
                for (int i = 0; i < entete.length; i++) {
                    dtm.addColumn(entete[i]);
                }
                try {
                    while (rs.next()) {
                        String ligne[] = {String.valueOf(rs.getInt(1)),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)};
                        dtm.addRow(ligne);
                    }
                    CBB_REFUGE_NAME();
                    CBB_PROPRIO_NAME();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_CHIEN.class.getName()).log(Level.SEVERE, null, ex);

                }
                this.TablePrincipal.setModel(dtm);
                this.TablePrincipal.getSelectionModel().addListSelectionListener(this);
            }
            case 3 -> {
                ResultSet rs = daoProprio.FindAllRs();
                String entete[] = {"ID", "Nom", "Adresse"};

                DefaultTableModel dtm = new DefaultTableModel();
                for (int i = 0; i < entete.length; i++) {
                    dtm.addColumn(entete[i]);
                }
                try {
                    while (rs.next()) {
                        String ligne[] = {String.valueOf(rs.getInt(1)),
                            rs.getString(2),
                            rs.getString(3)};
                        dtm.addRow(ligne);
                    }
                    CBB_REFUGE_NAME();
                    CBB_PROPRIO_NAME();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_CHIEN.class.getName()).log(Level.SEVERE, null, ex);

                }
                this.TablePrincipal.setModel(dtm);
                this.TablePrincipal.getSelectionModel().addListSelectionListener(this);
            }
            default -> {

            }
        }
    }

    public void JtableAffichageINNERJOIN() throws SQLException, FileNotFoundException {
        ResultSet rs = daoChien.InnerJoin();

        String entete[] = {"Nom", "Refuge", "Date d'entré", "Proprio", "Date d'adaption"};
        DefaultTableModel dtm = new DefaultTableModel();

        for (int i = 0; i < entete.length; i++) {
            dtm.addColumn(entete[i]);
        }
        try {
            while (rs.next()) {
                String ligne[] = {
                    rs.getString(1),
                    rs.getString(2),
                    String.valueOf(rs.getDate(3).toLocalDate().format(dtf)),
                    rs.getString(4),
                    (rs.getTimestamp(5) != null) ? rs.getTimestamp(5).toLocalDateTime().format(dtf) : "",};
                dtm.addRow(ligne);
            }

            CBB_PROPRIO_NAME();
            CBB_REFUGE_NAME();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_CHIEN.class.getName()).log(Level.SEVERE, null, ex);

        }
        this.Table.setModel(dtm);
    }

    public void JtableAffichageFindByName() throws SQLException, FileNotFoundException {

        DefaultTableModel dtm = new DefaultTableModel();
        String name = this.Txt_FindByName_Chien.getText();
        List<Chien> chiens = ctrl.getChiensByName(name);
        dtm.setColumnIdentifiers(new String[]{"Nom", "Date", "Sexe", "Race", "Sterilisé", "Date d'entrée", "Date de sortie"});
        if (!chiens.isEmpty()) {
            for (Chien chien : chiens) {
                Object[] rowData = {chien.getNom_Chien(),
                    chien.getDate_Chien().format(dtf),
                    chien.getSex_Chien(),
                    chien.getRace_Chien(),
                    chien.isSteril_Chien(),
                    chien.getDate_Entre_Chien().format(dtf),
                    chien.getDate_Sortie_Chien() != null ? chien.getDate_Sortie_Chien().format(dtf) : ""};

                dtm.addRow(rowData);
            }
        }
        this.TableRECHERCHE.setModel(dtm);
        this.TableRECHERCHE.getSelectionModel().addListSelectionListener(this);

    }

    public void JtableAffichageFindByRace() throws SQLException, FileNotFoundException {

        DefaultTableModel dtm = new DefaultTableModel();
        String race = this.Txt_FindByRace_Chien.getText();
        List<Chien> chiens = ctrl.getChiensByRace(race);
        dtm.setColumnIdentifiers(new String[]{"Nom", "Date", "Sexe", "Race", "Sterilisé", "Date d'entrée", "Date de sortie"});
        if (!chiens.isEmpty()) {
            for (Chien chien : chiens) {
                Object[] rowData = {chien.getNom_Chien(),
                    chien.getDate_Chien().format(dtf),
                    chien.getSex_Chien(),
                    chien.getRace_Chien(),
                    chien.isSteril_Chien(),
                    chien.getDate_Entre_Chien().format(dtf),
                    chien.getDate_Sortie_Chien() != null ? chien.getDate_Sortie_Chien().format(dtf) : ""};
                dtm.addRow(rowData);
            }
        }
        this.TableRECHERCHE.setModel(dtm);
        this.TableRECHERCHE.getSelectionModel().addListSelectionListener(this);

    }

    public void JTableAfficheFindByName_Refuge() throws SQLException, FileNotFoundException {

        DefaultTableModel dtm = new DefaultTableModel();
        String name = this.Txt_FindByName_Refuge.getText();
        List<Refuge> refuges = ctrl.getRefugeByName(name);
        dtm.setColumnIdentifiers(new String[]{"Nom", "Adresse", "Nul Telephone"});

        if (!refuges.isEmpty()) {
            for (Refuge refuge : refuges) {
                Object[] rowDate = {
                    refuge.getNom(),
                    refuge.getAdresse(),
                    refuge.getNumTel()};
                dtm.addRow(rowDate);
            }
        }
        this.TableRECHERCHE.setModel(dtm);
        this.TableRECHERCHE.getSelectionModel().addListSelectionListener(this);
    }

    public void JTableAfficheFindByAdresse_Refuge() throws SQLException, FileNotFoundException {
        DefaultTableModel dtm = new DefaultTableModel();
        String adresse = this.Txt_FindByAdresse_Refuge.getText();
        List<Refuge> refuges = ctrl.getRefugeByAdresse(adresse);
        dtm.setColumnIdentifiers(new String[]{"Nom", "Adresse", "Nul Telephone"});

        if (!refuges.isEmpty()) {
            for (Refuge refuge : refuges) {
                Object[] rowDate = {
                    refuge.getNom(),
                    refuge.getAdresse(),
                    refuge.getNumTel()};
                dtm.addRow(rowDate);
            }
        }
        this.TableRECHERCHE.setModel(dtm);
        this.TableRECHERCHE.getSelectionModel().addListSelectionListener(this);

    }

    public void JTableAfficheFindByName_Proprio() throws SQLException, FileNotFoundException {
        DefaultTableModel dtm = new DefaultTableModel();
        String name = this.Txt_FindByName_PRO.getText();
        List<Proprio> proprios = ctrl.getProprioByName(name);
        dtm.setColumnIdentifiers(new String[]{"Nom", "Adresse"});

        if (!proprios.isEmpty()) {
            for (Proprio proprio : proprios) {
                Object[] rowDate = {
                    proprio.getNomProprio(),
                    proprio.getAdresseProprio()};

                dtm.addRow(rowDate);
            }
        }
        this.TableRECHERCHE.setModel(dtm);
        this.TableRECHERCHE.getSelectionModel().addListSelectionListener(this);
    }

    public void JTableAfficheFindByAdresse_Proprio() throws SQLException, FileNotFoundException {
        DefaultTableModel dtm = new DefaultTableModel();
        String adresse = this.Txt_FindByAdresse_PRO.getText();
        List<Proprio> proprios = ctrl.getProprioByAdresse(adresse);
        dtm.setColumnIdentifiers(new String[]{"Nom", "Adresse"});

        if (!proprios.isEmpty()) {
            for (Proprio proprio : proprios) {
                Object[] rowDate = {
                    proprio.getNomProprio(),
                    proprio.getAdresseProprio()};

                dtm.addRow(rowDate);
            }
        }
        this.TableRECHERCHE.setModel(dtm);
        this.TableRECHERCHE.getSelectionModel().addListSelectionListener(this);
    }
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
/////////////////////      JIMAGE       ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////

    private void ImageMENU() {
        int min = 1;
        int max = 10;
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        //DECLARER UNE NOUVELLE IMAGE     
        if (randomNumber == 1) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\choses-que-chiens-detestent-062141-650-400.jpg");
                img = ImageIO.read(fic);

                Image img1 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img1);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 2) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\mini-chien-40-petites-boules-de-poils-a-croquer-335e0c1815c2885c.jpeg");
                img = ImageIO.read(fic);

                Image img2 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img2);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 3) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\racedecien-083123-650-325.jpg");
                img = ImageIO.read(fic);

                Image img3 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img3);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 4) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\refuge05.jpg");
                img = ImageIO.read(fic);

                Image img4 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img4);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 5) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\images (1).jpg");
                img = ImageIO.read(fic);

                Image img5 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img5);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 6) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\images (2).jpg");
                img = ImageIO.read(fic);

                Image img6 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img6);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 7) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\images (3).jpg");
                img = ImageIO.read(fic);

                Image img7 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img7);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 8) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\intoxication-chien-aliments-toxques.jpg");
                img = ImageIO.read(fic);

                Image img8 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img8);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 9) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\images.jpg");
                img = ImageIO.read(fic);

                Image img9 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img9);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (randomNumber == 10) {
            try {
                BufferedImage img = null;
                File fic = new File("src\\main\\Ressource\\langage-chien-(2)-151744.jpg");
                img = ImageIO.read(fic);

                Image img10 = img.getScaledInstance(LBL_IMAGE.getWidth(),
                        -1,
                        Image.SCALE_SMOOTH);
                ImageIcon formatIcone = new ImageIcon(img10);
                LBL_IMAGE.setIcon(formatIcone);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
/////////////////////      JRELOAD      ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////

    public void ReloadMenu() {
        try {

            MCD = new Menu_Chien_Data();
            MCD.setVisible(true);
            MCD.setLocationRelativeTo(null);
            MCD.dispose();
            ImageMENU();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Menu_Chien_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CheckEarly() {
        if (this.CHECK_Steril.isSelected()) {
            this.Txt_Sterile.setText("true");
            this.CHECK_Steril.setText("OUI");
        } else {
            this.Txt_Sterile.setText("false");
            this.CHECK_Steril.setText("NON");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton Btn_Cree;
    protected javax.swing.JButton Btn_Delete;
    protected javax.swing.JButton Btn_MAJ;
    protected javax.swing.JButton Btn_Vider;
    protected javax.swing.JComboBox<String> CBB_Proprio_Nom_Chien;
    protected javax.swing.JComboBox<String> CBB_Race_Chien;
    protected javax.swing.JComboBox<String> CBB_Refuge_Nom_Chien;
    protected javax.swing.JComboBox<String> CBB_Sexe;
    protected javax.swing.JCheckBox CHECK_Steril;
    protected javax.swing.JLabel LBL_ID_PRO;
    protected javax.swing.JLabel LBL_ID_REFUGE;
    protected javax.swing.JLabel LBL_IMAGE;
    protected javax.swing.JLabel LBL_INNERJOIN;
    protected javax.swing.JLabel LBL_NOMREFUGE;
    protected javax.swing.JLabel LBL_NUM_TEL;
    protected javax.swing.JLayeredPane Lay_Chien;
    protected javax.swing.JLayeredPane Lay_Chien_Recherche;
    protected javax.swing.JLayeredPane Lay_Invisible;
    protected javax.swing.JLayeredPane Lay_Pro;
    protected javax.swing.JLayeredPane Lay_Proprio_Recherche;
    protected javax.swing.JLayeredPane Lay_Refuge;
    protected javax.swing.JLayeredPane Lay_Refuge_Recherche;
    protected javax.swing.JLabel Lbl_Entre;
    protected javax.swing.JLabel Lbl_ID;
    protected javax.swing.JLabel Lbl_Multy_Name;
    protected javax.swing.JLabel Lbl_Nee;
    protected javax.swing.JLabel Lbl_Nom;
    protected javax.swing.JLabel Lbl_Proprio;
    protected javax.swing.JLabel Lbl_Race;
    protected javax.swing.JLabel Lbl_Refuge;
    protected javax.swing.JLabel Lbl_Sex;
    protected javax.swing.JLabel Lbl_Sortie;
    protected javax.swing.JRadioButton Rad_Chien;
    protected javax.swing.JRadioButton Rad_Proprio;
    protected javax.swing.JRadioButton Rad_Refuge;
    protected javax.swing.JTable Table;
    protected javax.swing.JTable TablePrincipal;
    protected javax.swing.JTable TableRECHERCHE;
    protected javax.swing.JTextField Txt_Adr_Pro;
    protected javax.swing.JTextField Txt_Adresse_Refuge;
    protected javax.swing.JTextField Txt_Entre;
    protected javax.swing.JTextField Txt_FindByAdresse_PRO;
    protected javax.swing.JTextField Txt_FindByAdresse_Refuge;
    protected javax.swing.JTextField Txt_FindByName_Chien;
    protected javax.swing.JTextField Txt_FindByName_PRO;
    protected javax.swing.JTextField Txt_FindByName_Refuge;
    protected javax.swing.JTextField Txt_FindByRace_Chien;
    protected javax.swing.JTextField Txt_ID;
    protected javax.swing.JTextField Txt_ID_Pro;
    protected javax.swing.JTextField Txt_ID_refuge;
    protected javax.swing.JTextField Txt_Nee;
    protected javax.swing.JTextField Txt_Nom;
    protected javax.swing.JTextField Txt_Nom_Pro;
    protected javax.swing.JTextField Txt_Nom_Refuge;
    protected javax.swing.JTextField Txt_Num_Tel;
    protected javax.swing.JTextField Txt_Proprio;
    protected javax.swing.JTextField Txt_Refuge;
    protected javax.swing.JTextField Txt_Sortie;
    protected javax.swing.JTextField Txt_Sterile;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JLabel jLabel8;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
////////////////////      JCOLLECT      ///////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int row = TablePrincipal.getSelectedRow();
            if (row >= 0 && row < TablePrincipal.getRowCount()) {

                if (Visible == 1) {
                    int chienId = Integer.parseInt((String) TablePrincipal.getValueAt(row, 0));
                    Chien c = ctrl.GetChien(chienId);
                    Affichage_CHIEN(c);
                    String refugeValue = (String) TablePrincipal.getValueAt(row, 8);
                    String proprioValue = (String) TablePrincipal.getValueAt(row, 9);
                    CBB_Refuge_Nom_Chien.setSelectedItem(refugeValue);
                    CBB_Proprio_Nom_Chien.setSelectedItem(proprioValue);
                    CheckEarly();
                } else if (Visible == 2) {
                    int RefugeId = Integer.parseInt((String) TablePrincipal.getValueAt(row, 0));
                    Refuge r = ctrl.GetRefuge(RefugeId);
                    Affichage_REFUGE(r);
                    CheckEarly();
                } else if (Visible == 3) {
                    int ProprioId = Integer.parseInt((String) TablePrincipal.getValueAt(row, 0));
                    Proprio p = ctrl.GetProprio(ProprioId);
                    Affichage_PROPRIO(p);
                    CheckEarly();
                }
            }
        }
    }

}
