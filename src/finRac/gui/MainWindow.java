package finRac.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	public MainWindow(String title) throws HeadlessException {
		super(title);
	}
	
	public void init() {
//		Creating the gridLayout for the JFrame
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{261, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
//		Creating new menubar item
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
// 		Creating menu "Kontni okvir"
		JMenu mnKontniOkvir = new JMenu("Kontni okvir");
		menuBar.add(mnKontniOkvir);
		
//		Creating item's for menu "Kontni okvir"
		JMenuItem mntmPregledKontnogOkvira = new JMenuItem("Pregled kontnog okvira");
		JMenuItem mntmDodajKonto = new JMenuItem("Dodaj novi konto");
		
//		Adding action listeners to "Kontni okvir" menu item's
		mntmPregledKontnogOkvira.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pregled kontnog okvira");
			}
			
		});
		mntmDodajKonto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Dodaj kontno");
			}
			
		});
		
//		Adding items to menu "Kontni okvir"
		mnKontniOkvir.add(mntmPregledKontnogOkvira);
		mnKontniOkvir.add(mntmDodajKonto);
		
		
		
// 		Creating menu "Nalozi"	
		JMenu mnNalozi = new JMenu("Nalozi");
		menuBar.add(mnNalozi);
		
//		Creating item's for menu "Nalozi"
		JMenuItem mntmNoviNalog = new JMenuItem("Novi nalog");
		JMenuItem mntmPregledNaloga = new JMenuItem("Pregled naloga");
		
//		Adding action listeners to "Nalozi" menu item's
		mntmNoviNalog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Novi nalog");
			}
			
		});

		mntmPregledNaloga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pregled naloga");
			}
			
		});

//		Adding items to menu "Nalozi"
		mnNalozi.add(mntmNoviNalog);
		mnNalozi.add(mntmPregledNaloga);
		
		
// 		Creating menu "Komitenti"
		JMenu mnKomitenti = new JMenu("Komitenti");
		menuBar.add(mnKomitenti);
		
//		Creating item's for menu "Komitenti"
		JMenuItem mntmPregledKomitenata = new JMenuItem("Pregled komitenata");		
		JMenuItem mntmDodajKomitenta = new JMenuItem("Dodaj komitenta");
		
//		Adding action listeners to "Komitenti" menu item's
		mntmPregledKomitenata.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pregled komitenata");
			}
			
		});
		mntmDodajKomitenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dodaj komitenta");
			}
			
		});
		
//		Adding items to menu "Komitenti"
		mnKomitenti.add(mntmPregledKomitenata);
		mnKomitenti.add(mntmDodajKomitenta);
		
		
// 		Creating menu "Izvestaji"
		JMenu mnIzvestaji = new JMenu("Izvestaji");
		menuBar.add(mnIzvestaji);
		
//		Creating item's for menu "Izvestaji"
		JMenuItem mntmBrutoBilans = new JMenuItem("Bruto bilans");		
		JMenuItem mntmDnevnik = new JMenuItem("Dnevnik");		
		JMenuItem mntmGlavnaKnjiga = new JMenuItem("Glavna knjiga");
		
//		Adding action listeners to "Komitenti" menu item's
		mntmBrutoBilans.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bruto bilans");
			}
			
		});
		mntmDnevnik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dnevnik");
			}
			
		});
		mntmGlavnaKnjiga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("GlavnaKnjiga");
			}
			
		});
		
//		Adding items to menu "Izvestaji"
		mnIzvestaji.add(mntmBrutoBilans);
		mnIzvestaji.add(mntmDnevnik);
		mnIzvestaji.add(mntmGlavnaKnjiga);
		
		
// 		Creating menu "options"
		JMenu options = new JMenu("Options");
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(options);
		
//		Creating item's for menu "options"
		JMenuItem mntmExit = new JMenuItem("Exit");
		
//		Adding action listeners to "Komitenti" menu item's
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
			
		});
		
//		Adding items to menu "options"
		options.add(mntmExit);
		
		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		this.setUndecorated(true);
		this.setResizable(false);
		this.setTitle("Finansijsko racunovodstvo - Dimitrije Jelic");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		device.setFullScreenWindow(this);
	}
	
}
