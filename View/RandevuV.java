package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ClinicController;
import Controller.DoctorController;
import Controller.RandevuController;
import Dao.DaoClinic;
import Dao.DaoDoctor;
import Dao.DaoRandevu;
import Model.Doctor;
import Model.Hasta;
import Model.Randevu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RandevuV extends JFrame {

	private JPanel contentPane;


	
	RandevuController rC=new RandevuController();
	Randevu ran= new Randevu();
	
	DoctorController dC=new DoctorController();
	
	ClinicController cC=new ClinicController();
	
	
	//tablo oluşturma
	
		private DefaultTableModel modelim = new DefaultTableModel();
		private Object[] kolonlar= {"ID","Doktor","Klinik","Tarih"};
		private Object[] satirlar= new Object[4];
		
		public JTable tableRandevu ;
		private JTextField tarih;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandevuV frame = new RandevuV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RandevuV() {
		setTitle("Randevu İşlemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//tablo işlmeleri
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 385, 251);
		contentPane.add(scrollPane);
		
		tableRandevu = new JTable();
		tableRandevu.setBounds(10, 36, 409, 217);
		 
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(tableRandevu);
		
		JButton sil = new JButton("SİL");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 if(tableRandevu.getSelectedRow()<0) {
		 				
						JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
						
					}
					else {
						 ran=rC.randevu_Listele(6).get(tableRandevu.getSelectedRow());  // tablodan nesne alma işlemi... id'si 6 olan hastayı al
						 
						 rC.delete_Randevu(ran);
				 
				 JOptionPane.showMessageDialog(null, " Randevu Başarıyla Silindi!", "Randevu Silme Paneli", JOptionPane.INFORMATION_MESSAGE);
				
				 listeYenileRandevu();
					}
			
			
			}
		});
		sil.setBounds(415, 30, 90, 23);
		contentPane.add(sil);
		
		JButton duzenle = new JButton("DÜZENLE");
		duzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
if(tableRandevu.getSelectedRow()<0) {
					
					JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
					
				}
				else {
					
					// Tabloyu hücre içinden güncelleme
					  int ii = tableRandevu.getSelectedRow();
					  int id_Al= Integer.parseInt(tableRandevu.getModel().getValueAt(ii, 0).toString());
					  String doktor_id=tableRandevu.getModel().getValueAt(ii,1).toString();
					  String klinik_al=tableRandevu.getModel().getValueAt(ii,2).toString();
		              String tarih=tableRandevu.getModel().getValueAt(ii,3).toString();
		          
		    
		              tableRandevu.revalidate();
		              tableRandevu.repaint();
		        
		              ran= new Randevu(id_Al,6,doktor_id,klinik_al,tarih);
		      
					  rC.update_Randevu(ran);
					
			
					
					
			 }
				
				
			}
		});
		duzenle.setBounds(517, 30, 139, 23);
		contentPane.add(duzenle);
		
		JComboBox doktorlistele = new JComboBox();
		doktorlistele.setBounds(416, 104, 240, 22);
		contentPane.add(doktorlistele);
		
		for(int i=0; i<dC.get_DoctorList().size() ;i++ ) {
			
		doktorlistele.addItem(dC.get_DoctorList().get(i).getName());
		 
			
		}
		
		
		JLabel lblNewLabel = new JLabel("Randevu Ekleme Paneli:");
		lblNewLabel.setBounds(416, 79, 186, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox kliniklistele = new JComboBox();
		kliniklistele.setBounds(416, 153, 240, 22);
		contentPane.add(kliniklistele);
		
		for(int i=0; i<cC.get_ClinicList().size() ;i++ ) {
			
		kliniklistele.addItem(cC.get_ClinicList().get(i).getName());
	 
			}
		
		tarih = new JTextField();
		tarih.setText("tarih gir:");
		tarih.setBounds(419, 204, 237, 20);
		contentPane.add(tarih);
		tarih.setColumns(10);
		
		JButton ekle = new JButton("RANDEVU EKLE");
		ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String clinicID = cC.get_ClinicList().get(kliniklistele.getSelectedIndex()).getName();
				String doktorID = dC.get_DoctorList().get(doktorlistele.getSelectedIndex()).getName();
				
				ran= new Randevu(6,doktorID,clinicID,tarih.getText()); 
				
				rC.add_Randevu(ran);
				
				JOptionPane.showMessageDialog(null, "Eklendi!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
				listeYenileRandevu();
				
			}
		});
		ekle.setBounds(416, 263, 240, 23);
		contentPane.add(ekle);
		
		listeYenileRandevu();
		
		//--------------------------------
		
	}
	
public void listeYenileRandevu() {
		
		modelim.setRowCount(0);
		
		
		
	for(int i=0; i<rC.randevu_Listele(6).size(); i++) { // 6 sayısı herhangi bir hastanın id'si
			
		//int dr_id=rC.randevu_Listele(6).get(i).getDoctor_id();
		//int kl_id=rC.randevu_Listele(6).get(i).getClinic_id();
		 
		
			satirlar[0]=rC.randevu_Listele(6).get(i).getId();
			satirlar[1]=rC.randevu_Listele(6).get(i).getDoctor_id();
			satirlar[2]=rC.randevu_Listele(6).get(i).getClinic_id(); 
			satirlar[3]=rC.randevu_Listele(6).get(i).getTarih();
		
			modelim.addRow(satirlar);
			}
	tableRandevu.setModel(modelim);
	}
}
