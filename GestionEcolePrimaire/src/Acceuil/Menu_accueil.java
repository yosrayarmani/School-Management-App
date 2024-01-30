package Acceuil;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import Affichage.listEleve;
import Affichage.listcharge;
import Affichage.listcours;
import Affichage.listprofesseurs;
import Gestion.ges_charge;
import Gestion.ges_cours;
import Gestion.ges_eleve;
import Gestion.ges_prof;
import frame.Fen_ajout_Elève;
import frame.Fen_ajout_Professeurs;
import frame.Fen_ajout_cours;
import frame.Jlabel;
import frame.fen_charge;




public class Menu_accueil extends JFrame implements ActionListener{
	
	private JMenuItem list_charge,listeleves,list_cours,list_prof,quite,listresult,user,addprof,addcours,addeleve, app1;
	private JMenuBar menu;
	private JMenu Fich, app;
	private JPanel img,img2;
	private JToolBar menubar ;
	private JLabel ne;
	
      private JButton listelevebutton = new JButton("   Liste des elèves          ");
	  private JButton listcoursbutton = new JButton("   Liste des cours          ");
	  private JButton listprofbutton = new  JButton("   Liste des professeurs");
	  private JButton listresultsbutton = new JButton("Les resultats         ");
	  private JButton listchargebutton = new JButton("   Liste des cours /profs   "); 
	  
	  private JButton gestioneleve= new JButton("     Eleve               ");
	  private JButton gestionprof = new JButton("    professeurs         ");
	  private JButton gestioncharge = new JButton("    Charge              ");
	  private JButton gestioncours= new JButton("     Cours               ");
	  private JButton gestionresultat= new JButton("     Resultat            ");
	 
	  
	  private JTabbedPane onglet=new JTabbedPane(); 
	  
	  private JPanel re=new JPanel();
	  private JPanel affichagearea=new JPanel();
	  private JPanel gestionarea=new JPanel();
	  
	  Container c=getContentPane();
	
	 private String requete01 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'eleves'";
	
//------------------------------------------------------------------------------
	 public <split, split1> Menu_accueil(){ 
		
		 JSplitPane split;		JSplitPane split1;
		 
		 
		 ne =  new JLabel();		ne.setIcon(new ImageIcon(""));		ne.setPreferredSize(new Dimension(800,400));
		 
		this.setTitle("HOME PAGE");		this.setSize(900,700);		this.setLocation(250,50);
		  
	      
	     
	    listelevebutton.addActionListener(this);   listelevebutton.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\list.png"));
	    listchargebutton.addActionListener(this);  listchargebutton.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\list.png"));
	    listcoursbutton.addActionListener(this);   listcoursbutton.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\list.png"));
	    listprofbutton.addActionListener(this);    listprofbutton.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\list.png"));
	    listresultsbutton.addActionListener(this); listresultsbutton.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\list.png"));
	  
	    JLabel txt=new JLabel("BIENVENUE");
	      
	    JMenuBar menu=new JMenuBar();
	    setJMenuBar(menu);

//----------------- MENU AJOUTER ----------------------------
	    Fich=new JMenu("Ajouter");		Fich.setMnemonic('A'); 	menu.add(Fich);		 Fich.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\fichier1.png"));
	   
	    
	    img=new JPanel(); 
	    img.add(ne); 
	    
	    JLabel fond_img=new JLabel();
	    fond_img.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\blue1.jpg"));
	    fond_img.setSize(700, 900);
	 
	    //ONGLET
	    re.setBounds(5, 20,218, 800);		re.setLayout(new BorderLayout());		re.add(onglet);
	    
	    onglet.setSize(400, 830);		onglet.setBorder(null);		onglet.setBackground(Color.blue);
	    
//------------- AFFICHAGE ----------------------------------------------------
	    onglet.add("Affichage",affichagearea);		 affichagearea.setBackground(Color.gray);
		 
	     affichagearea.add(listelevebutton,BorderLayout.WEST );   	listelevebutton.setBackground(Color.white);		listelevebutton.setPreferredSize(new Dimension(200,30)); 
	     affichagearea.add(listprofbutton,BorderLayout.WEST);  		listprofbutton.setBackground(Color.white);		listprofbutton.setPreferredSize(new Dimension(200,30));
	     affichagearea.add(listcoursbutton,BorderLayout.WEST); 		listcoursbutton.setBackground(Color.white);		listcoursbutton.setPreferredSize(new Dimension(200,30));
	     affichagearea.add(listchargebutton,BorderLayout.WEST);		listchargebutton.setBackground(Color.white);	listchargebutton.setPreferredSize(new Dimension(200,30));
	     affichagearea.add(listresultsbutton,BorderLayout.WEST);	    listresultsbutton.setBackground(Color.white);	listresultsbutton.setPreferredSize(new Dimension(200,30));

		 
//------------ GESTION --------------------------------------------------------
		 gestionarea.add(gestioneleve,BorderLayout.WEST ); gestioneleve.setBackground(Color.white); gestioneleve.setPreferredSize(new Dimension(200,30));  gestioneleve.addActionListener(this);
		 gestionarea.add(gestionprof,BorderLayout.WEST); gestionprof.setBackground(Color.white);  gestionprof.setPreferredSize(new Dimension(200,30));  gestionprof.addActionListener(this);
		 gestionarea.add(gestioncharge,BorderLayout.WEST); gestioncharge.setBackground(Color.white);  gestioncharge.setPreferredSize(new Dimension(200,30));  gestioncharge.addActionListener(this);
		 gestionarea.add(gestioncours,BorderLayout.WEST); gestioncours.setBackground(Color.white);  gestioncours.setPreferredSize(new Dimension(200,30));  gestioncours.addActionListener(this);
		 gestionarea.add(gestionresultat,BorderLayout.WEST); gestionresultat.setBackground(Color.white);  gestionresultat.setPreferredSize(new Dimension(200,30));  gestionresultat.addActionListener(this);
	     
		 onglet.add("Gestion",gestionarea);
	     gestionarea.setBackground(Color.gray);
		 
		
		
		
			split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(null), null);
		    split.setDividerLocation(100);
		    split.setDividerSize(2);
		    split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, re, split);
		    split1.setDividerLocation(220);
		    split1.setDividerSize(2);
		  

		 
	    img.setBounds(210,100,1400,625);
	    img.setBackground(Color.white);
	    
	     img.setLayout(new BorderLayout());
	      
	      
	    
	    img2=new JPanel(); 
	    img2.setLayout(null);
	    
//--------------------- IMAGE GIF BIENVENUE --------------------
	    JButton welcomegif=new JButton("");
	    welcomegif.setBounds(10,30, 700, 80);
	    welcomegif.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\welcome.gif"));
	    img2.setBounds(210,2,1400,90); 		img2.setBackground(Color.WHITE);		img2.add(welcomegif);
	    
//----------------------------- MENU BARE -------------------------------------
	    
	    menubar=new JToolBar();		menubar.setBounds(5, 2, 1400,19);
	    
	    
//--------------------------- SOUS MENU   NOUVEAU -----------------------------------------
	    
	   JMenu ajout=new JMenu("Nouveau");		Fich.add(ajout);		ajout.setMnemonic('N');
	    
//-------------------------- AJOUT ------------------------------------------
	    
	    addeleve=new JMenuItem(" Elève");  addeleve.setIcon(new ImageIcon("elv.png"));
	    ajout.add(addeleve);
	    addeleve.setMnemonic('e');
	   
	    addeleve.setBounds(0,0,0,20);
	    addcours=new JMenuItem(" Cours"); addcours.setIcon(new ImageIcon("crss.png"));
	    ajout.add(addcours);
	    addcours.setMnemonic('c');
	  
	    addprof=new JMenuItem(" Professeurs"); addprof.setMnemonic('p');
	    addprof.setIcon(new ImageIcon("profs.gif"));
	    ajout.add(addprof);
	    
	     
	    JMenuItem nvrlt=new JMenuItem("Resultats des eleves"); nvrlt.setIcon(new ImageIcon("rsl.jpg"));
	    ajout.add(nvrlt);  nvrlt.setMnemonic('r');
	     
	    JMenuItem crep=new JMenuItem("Cours enseigner/prof "); 	ajout.add(crep);	crep.setMnemonic('C');
	    
	     

	    JPanel i=new JPanel(); 
	    i.setLayout(null);

//--------------------------------  QUIT -------------------------------------
	 quite=new JMenuItem("Quitter");		quite.setMnemonic('q');		Fich.add(quite);		quite.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\quit.png"));
	 
	    
//**************************** EVENT QUIT ***********************************************
	  quite.addActionListener(new ActionListener()
	  {
            @Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
	}
		  
	  });
	    
//-------------------- DELETE ------------------------------------------
	   JMenu delete=new JMenu(" Suppression ");		menu.add(delete); 		delete.setMnemonic('s');		delete.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\fer.gif"));
	   JMenu tables=new JMenu ("supprimer : ");
	   delete.add(tables);
	   
	    listeleves=new JMenuItem("Eleve"); listeleves.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\list.png"));
	    tables.add(listeleves);
		 
		list_prof=new JMenuItem("Professeurs");  list_prof.setIcon(new ImageIcon("C:\\Users\\yossra\\Desktop\\images\\list.png"));
		tables.add(list_prof);

//------------------------ APP -->> APROPOS ----------------------------------
	    app=new JMenu("App");		app.setMnemonic('A'); 		app.addActionListener(this);		menu.add(app);

		 app1=new JMenuItem("About");		app.add(app1);  app1.setMnemonic('A'); 		app1.addActionListener(this);
		 
//+++++++++++++++++++++++++++++++++++++++++++
	    i.add(re); 
	    img.add(fond_img); 
	    i.add(menubar);
	    i.add(img); 
	    i.add(img2); 
	    add(i); 
	    
//ADD FRAMES AND THEIR EVENTS
//---------------- APROPOS ----------------------------------------------- done
	   app1.addActionListener(new ActionListener()
	   {
		@Override
		public void actionPerformed(ActionEvent a) {
			Jlabel lb=new Jlabel();
			lb.setVisible(true);
			
		}}
	   );
	   
//************************ LISTE ELEVES ****************************************** done
	   listeleves.addActionListener(new ActionListener()
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				listEleve el=new listEleve();
				el.setVisible(true);
				el.setResizable(false);
			}
	    	
	    });
	    
//**********************************************************************
	    crep.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				fen_charge ch=new fen_charge();
				ch.setVisible(true);
				ch.setResizable(true);
				
			}
	    	
	    });
//******************************* LISTE PROF *********************************************
	   list_prof.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			listprofesseurs pr=new listprofesseurs();
			pr.setVisible(true);
		}});

//******************************* AJOUT PROF ***************************************** 
	   addprof.addActionListener(new ActionListener()
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Fen_ajout_Professeurs pr=new Fen_ajout_Professeurs();
				pr.setVisible(true);
				pr.setResizable(false);
			}
	    });
//***********************************AJOUT COURS **************************************
	   addcours.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Fen_ajout_cours f=new Fen_ajout_cours();
			f.setVisible(true);
			f.setResizable(false);
		}
		   
	   });
//*********************************** AJOUT ELEVE ***************************************
	   addeleve.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Fen_ajout_Elève fe=new Fen_ajout_Elève();
			fe.setVisible(true);
			fe.setResizable(false);
		}
	   });}
	 
//-------------------------------- AFFICHAGE ONGLETS -------------------------------------------

@Override
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource()==listelevebutton)
	{
		listEleve el=new listEleve();
		el.setVisible(true);
	}
//**************************************************************
	if(e.getSource()==listcoursbutton)
	{
		listcours cr=new listcours();
				cr.setVisible(true);
				cr.setResizable(true);
	}
//*************************************************************
	if(e.getSource()==listprofbutton)
	{ 
		listprofesseurs pr=new listprofesseurs();
		pr.setVisible(true);
		
	}
//*************************************************************
	if(e.getSource()==listchargebutton)
	{
		listcharge ch=new listcharge();
		ch.setVisible(true);
		ch.setResizable(false);
	}
//**************************************************************
  if(e.getSource()==gestioneleve)
  {  
	   ges_eleve ge=new ges_eleve();
	   ge.setVisible(true);  
	}
  
  if(e.getSource()==gestionprof)
  {  
	   ges_prof gp=new ges_prof();
	   gp.setVisible(true);  
	   gp.setResizable(false);
	}
  
  if(e.getSource()==gestioncharge)
  {  
	   ges_charge gch=new ges_charge();
	   gch.setVisible(true);  
	   gch.setResizable(false);
	}
  
  if(e.getSource()==gestioncours)
  {  
	   ges_cours gcrs=new ges_cours();
	   gcrs.setVisible(true);  
	   gcrs.setResizable(false);
	}
  
	  }

  

public static void main(String[] args)
 {
	
		Menu_accueil x=new Menu_accueil();
		x.setVisible(true);
		
		x.setResizable(false);
		

	}

	
}


