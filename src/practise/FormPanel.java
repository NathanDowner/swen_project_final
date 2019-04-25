package practise;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel, occupationLabel, ageCatLabel, empStatusLabel;
	private JTextField nameField, occupationField;
	private JComboBox empCombo; //employment
	private JButton submitBtn;
	private JList<AgeCategory> ageList;
	
	private FormListener formListener;

	public FormPanel() {
		this.setPreferredSize(new Dimension(250, 10));
		this.nameLabel = new JLabel("Name: ");
		this.occupationLabel = new JLabel("Occupaiton: ");
		this.ageCatLabel = new JLabel("Age Category: ");
		this.empStatusLabel = new JLabel("Status: ");
		this.nameField = new JTextField(10);
		this.occupationField = new JTextField(10);
		this.ageList = new JList<AgeCategory>();
		this.empCombo = new JComboBox();
		
		///// Set up for list box
		
		DefaultListModel<AgeCategory> ageModel = new DefaultListModel<AgeCategory>();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 64"));
		ageModel.addElement(new AgeCategory(2, "65 and over"));
		ageList.setModel(ageModel);
		
		ageList.setPreferredSize(new Dimension(104, 66));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);
		
		
		///// SET UP COMBOBOX
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("self-employed");
		empModel.addElement("employed");
		empModel.addElement("un-employed");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		
		
		this.submitBtn = new JButton("Submit");
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCategory = ageList.getSelectedValue();
				String empCat = (String)empCombo.getSelectedItem();
				
				nameField.setText("");
				occupationField.setText("");
				FormEvent ev = new FormEvent(this, name, occupation, ageCategory, empCat);
				if (formListener != null) {
					formListener.formEventOccurred(ev);					
				}
			}		
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		this.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
		
	}
	
	public void layoutComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		
		gc.fill = GridBagConstraints.NONE; //or both or horizontal vertical
		Insets defaultInset = new Insets(0,0,0,0);
		Insets labelInset = new Insets(0,0,0,10);

		gc.gridy = 0;
		
//////////// first row ////////////////
		
		gc.gridx = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = labelInset;
		this.add(nameLabel, gc);
		
		gc.gridx = 1;
	
		gc.insets = defaultInset;
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(nameField, gc);
		
//////////// second row ////////////////
		gc.gridy++;
		gc.gridx = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = labelInset;
		this.add(occupationLabel, gc);
		
		gc.gridx = 1;
		gc.insets = defaultInset;
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(occupationField, gc);
		
//////////// third row ////////////////
		gc.gridy++;
		gc.gridx = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = labelInset;
		this.add(ageCatLabel, gc);
		
		
		gc.gridx = 1;
		
		gc.insets = defaultInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(ageList, gc);
		
////////////forth row ////////////////
		gc.gridy++;
		gc.gridx = 0;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = labelInset;
		this.add(empStatusLabel, gc);
		
		gc.gridx = 1;
		
		gc.insets = defaultInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(empCombo, gc);
		
//////////// fifth row ////////////////
		gc.gridy++;
		gc.gridx = 1;
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(submitBtn, gc);
		
	}
	
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}

}

class AgeCategory { //utility class
	private int id;
	private String text;
	
	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public String getText() {return this.text;}
	
	public String toString() {
		return this.text;
	}
	
	public int getId() {return this.id;}
}
