package Acceuil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Affichage.listEleve;
import Affichage.listprofesseurs;
import Gestion.Gestion_Eleve;
import Gestion.Gestion_Prof;
import frame.Ajout_Eleve;
import frame.Ajout_Professeur;
import frame.Jlabel;

public class Menu_accueil extends JFrame implements ActionListener {

    private JMenuItem listeleves, list_prof, addprof, addeleve, app1;
    private JMenu Fich, app;
    private JPanel img, img2;
    private JToolBar menubar;
    private JButton listeElevesBtn = new JButton("List of students");
    private JButton listprofbutton = new JButton("List of teachers");
    private JButton gestionElevesBtn = new JButton("students");
    private JButton gestionProfsBtn = new JButton("teachers");
    private JTabbedPane onglet = new JTabbedPane();
    private JPanel sidePanel = new JPanel();
    private JPanel affichagearea = new JPanel();
    private JPanel gestionarea = new JPanel();

    public <split, split1> Menu_accueil() {
        JSplitPane split;
        JSplitPane split1;

        this.setTitle("HOME PAGE");
        this.setSize(900, 700);
        this.setLocation(250, 50);

				ImageIcon listIcon = new ImageIcon("images1\\list.png");
        Image resizedListIcon = listIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

				ImageIcon deleteIcon = new ImageIcon("images1\\delete.png");
        Image resizedDeleteIcon = deleteIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

        listeElevesBtn.addActionListener(this);
        listeElevesBtn.setIcon(new ImageIcon(resizedListIcon));

        listprofbutton.addActionListener(this);
        listprofbutton.setIcon(new ImageIcon(resizedListIcon));

        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);

        // Menu add
        Fich = new JMenu("Add");
        menu.add(Fich);

        img = new JPanel();

        JLabel fond_img = new JLabel();
        fond_img.setIcon(new ImageIcon("images1\\blue1.jpg"));
        fond_img.setSize(700, 900);

        sidePanel.setBounds(5, 20, 218, 800);
        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(onglet);

        onglet.setSize(400, 830);
        onglet.setBorder(null);
        onglet.setBackground(Color.blue);

        // Tab display
        onglet.add("Display", affichagearea);
        affichagearea.setBackground(Color.gray);
        affichagearea.add(listeElevesBtn, BorderLayout.WEST);
        listeElevesBtn.setBackground(Color.white);
        listeElevesBtn.setPreferredSize(new Dimension(200, 30));
        affichagearea.add(listprofbutton, BorderLayout.WEST);
        listprofbutton.setBackground(Color.white);
        listprofbutton.setPreferredSize(new Dimension(200, 30));

        // Tab management
        gestionarea.add(gestionElevesBtn, BorderLayout.WEST);
        gestionElevesBtn.setBackground(Color.white);
        gestionElevesBtn.setPreferredSize(new Dimension(200, 30));
        gestionElevesBtn.addActionListener(this);
        gestionarea.add(gestionProfsBtn, BorderLayout.WEST);
        gestionProfsBtn.setBackground(Color.white);
        gestionProfsBtn.setPreferredSize(new Dimension(200, 30));
        gestionProfsBtn.addActionListener(this);

        onglet.add("Management", gestionarea);
        gestionarea.setBackground(Color.gray);

        split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(null), null);
        split.setDividerLocation(100);
        split.setDividerSize(2);
        split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidePanel, split);
        split1.setDividerLocation(220);
        split1.setDividerSize(2);

        img.setBounds(210, 100, 1400, 625);
        img.setBackground(Color.white);
        img.setLayout(new BorderLayout());

        img2 = new JPanel();
        img2.setLayout(null);

        // Welcome GIF
        JButton welcomegif = new JButton("");
        welcomegif.setBounds(10, 30, 700, 80);
        welcomegif.setIcon(new ImageIcon("images1\\welcome.gif"));
        img2.setBounds(210, 2, 1400, 90);
        img2.setBackground(Color.WHITE);
        img2.add(welcomegif);

        menubar = new JToolBar();
        menubar.setBounds(5, 2, 1400, 19);

        // Menu "Ajout"
        JMenu ajout = new JMenu("New");
        Fich.add(ajout);

        addeleve = new JMenuItem("Student");
        addeleve.setIcon(new ImageIcon(resizedListIcon));
        ajout.add(addeleve);

        addprof = new JMenuItem("Teacher");
        addprof.setIcon(new ImageIcon(resizedListIcon));
        ajout.add(addprof);

        JPanel i = new JPanel();
        i.setLayout(null);

        // Menu Deletion
        JMenu suppressionMenu = new JMenu(" Deletion ");
        menu.add(suppressionMenu);

        JMenu tables = new JMenu("Delete : ");
        suppressionMenu.add(tables);

        listeleves = new JMenuItem("Student");
        listeleves.setIcon(new ImageIcon(resizedDeleteIcon));
        tables.add(listeleves);

        list_prof = new JMenuItem("Teacher");
        list_prof.setIcon(new ImageIcon(resizedDeleteIcon));
        tables.add(list_prof);

        // Menu "App"
        app = new JMenu("App");
        menu.add(app);

        app1 = new JMenuItem("About");
        ImageIcon aboutIcon = new ImageIcon("images1\\about.png");
        Image resizedAboutIcon = aboutIcon.getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        app1.setIcon(new ImageIcon(resizedAboutIcon));
        app.add(app1);
        app1.addActionListener(this);

        JMenuItem closeItem = new JMenuItem("Close");
        ImageIcon closeIcon = new ImageIcon("images1\\close.png");
        Image resizedCloseIcon = closeIcon.getImage().getScaledInstance(11, 11, Image.SCALE_SMOOTH);
        closeItem.setIcon(new ImageIcon(resizedCloseIcon));
        app.add(closeItem);
        closeItem.addActionListener(e -> dispose());

        i.add(sidePanel);
        img.add(fond_img);
        i.add(menubar);
        i.add(img);
        i.add(img2);
        add(i);

        // Event handlers
        app1.addActionListener(e -> new Jlabel().setVisible(true));
        listeleves.addActionListener(e -> new listEleve().setVisible(true));
        list_prof.addActionListener(e -> new listprofesseurs().setVisible(true));
        addprof.addActionListener(e -> new Ajout_Professeur().setVisible(true));
        addeleve.addActionListener(e -> new Ajout_Eleve().setVisible(true));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listeElevesBtn) new listEleve().setVisible(true);
        if (e.getSource() == listprofbutton) new listprofesseurs().setVisible(true);
        if (e.getSource() == gestionElevesBtn) new Gestion_Eleve().setVisible(true);
        if (e.getSource() == gestionProfsBtn) new Gestion_Prof().setVisible(true);
    }

    public static void main(String[] args) {
        Menu_accueil x = new Menu_accueil();
        x.setVisible(true);
        x.setResizable(false);
    }
}
