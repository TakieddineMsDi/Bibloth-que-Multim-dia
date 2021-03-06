package jTablesClasses;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.Media.ImageInJframe;
//import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames.Updateb;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Auteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Etudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class UpdateAction extends AbstractAction {
	private final JTable table;
	private Model Model = null;

	public UpdateAction(JTable table,Model model,String ButtonName) {
		super(ButtonName);
		this.table = table;
		Model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
		int row = table.convertRowIndexToModel(table.getEditingRow());
		Object model = null;
		if(Model.isAuteur()){
				model = new Auteur().setNum_Personne(table.getModel().getValueAt(row, 0)).get();
		}if(Model.isEtudiant()){
			model = new Etudiant().setNum_Personne(table.getModel().getValueAt(row, 0)).get();
		}if(Model.isLivre()){
			model = new Livre().setISBN(table.getModel().getValueAt(row, 0)).get();
		}
		if(model != null){
			//new Update((Model)model);
		}else{
			JOptionPane.showMessageDialog(table, "erreur!");
		}
		//Object o = table.getModel().getValueAt(row, 0);
	}
}