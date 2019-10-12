package P3Pmerger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.swing.DocumentTreeModel;

import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Color;

import java.net.URL;

public class Engine extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextField txtURL1;
	private JTextField txtURL2;
	private JButton btnUpload1;
	private JButton btnUpload2;
	private JTextArea txtConsole;
	private File filep3p;
	private String newline = "\n";
	private String newtab = "\t";
	private URL p3pURL;
	private JTree treeP3P2;
	private JTree treeP3P1;
	private JPanel panelTree1;
	private JPanel panelTree2;
	private JScrollPane scrollPane_2;
	private Document document2;
	private Document document1;
	private Document newP3Pdoc;
	private JButton btnMatch;
	private JTextArea txtMatching;
	private JTextField txtPolicyname;
	private JTextField txtPolicydiscuri;
	private JTextField txtPolicyopturi;
	private JButton btnMerge;
	private JTree mergedP3PTree;
	private JTextArea txtmergedP3P;
	/**
	 * Create the frame.
	 */
	
	public Engine(){
		setTitle("P3P Merger System v1.0");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelTree1 = new JPanel();
		panelTree1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P3P Policy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTree1.setBounds(10, 11, 327, 504);
		contentPane.add(panelTree1);
		panelTree1.setLayout(null);
		
		treeP3P1 = new JTree();
		treeP3P1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		treeP3P1.setBounds(1, 1, 299, 383);
		treeP3P1.setModel(null);
		panelTree1.add(treeP3P1);
		
	    btnUpload1 = new JButton("Upload P3P");
		btnUpload1.addActionListener(this);
		btnUpload1.setBounds(194, 470, 117, 23);
		panelTree1.add(btnUpload1);
		
		txtURL1 = new JTextField();
		txtURL1.setBounds(10, 427, 301, 20);
		panelTree1.add(txtURL1);
		txtURL1.setColumns(10);
		
		JLabel lblUrl = new JLabel("The URI where a P3P policy is found");
		lblUrl.setBounds(10, 413, 178, 14);
		panelTree1.add(lblUrl);
		
		JButton btnValidatePolicy1 = new JButton("Validate Policy");
		btnValidatePolicy1.setBounds(10, 470, 117, 23);
		panelTree1.add(btnValidatePolicy1);
		
		JLabel lblExampleHttpmicrosoftcomwcppxml = new JLabel("Example: http://microsoft.com/w3c/p3p.xml");
		lblExampleHttpmicrosoftcomwcppxml.setForeground(Color.LIGHT_GRAY);
		lblExampleHttpmicrosoftcomwcppxml.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblExampleHttpmicrosoftcomwcppxml.setBounds(10, 445, 183, 14);
		panelTree1.add(lblExampleHttpmicrosoftcomwcppxml);
		
		scrollPane_2 = new JScrollPane(treeP3P1);
		scrollPane_2.setBounds(10, 21, 301, 383);
		panelTree1.add(scrollPane_2);
		
		panelTree2 = new JPanel();
		panelTree2.setLayout(null);
		panelTree2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P3P Policy", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTree2.setBounds(971, 11, 327, 504);
		contentPane.add(panelTree2);
		
		btnUpload2 = new JButton("Upload P3P");
		btnUpload2.addActionListener(this);
		btnUpload2.setBounds(194, 470, 117, 23);
		panelTree2.add(btnUpload2);
		
		txtURL2 = new JTextField();
		txtURL2.setColumns(10);
		txtURL2.setBounds(10, 427, 301, 20);
		panelTree2.add(txtURL2);
		
		JLabel label = new JLabel("The URI where a P3P policy is found");
		label.setBounds(10, 413, 178, 14);
		panelTree2.add(label);
		
		JButton btnValidatePolicy2 = new JButton("Validate Policy");
		btnValidatePolicy2.setBounds(10, 470, 117, 23);
		panelTree2.add(btnValidatePolicy2);
		
		JLabel label_1 = new JLabel("Example: http://microsoft.com/w3c/p3p.xml");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(10, 445, 183, 14);
		panelTree2.add(label_1);
		
		treeP3P2 = new JTree();
		treeP3P2.setFont(new Font("Tahoma", Font.PLAIN, 11));
 		treeP3P2.setBounds(10, 21, 301, 383);
 		treeP3P2.setModel(null);
 		panelTree2.add(treeP3P2);
 			
		JScrollPane scrollPane_1 = new JScrollPane(treeP3P2);
		scrollPane_1.setBounds(10, 21, 301, 383);
		panelTree2.add(scrollPane_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 519, 1288, 181);
		contentPane.add(tabbedPane);
		
		JPanel panelConsole = new JPanel();
		tabbedPane.addTab("Console", null, panelConsole, null);
		panelConsole.setLayout(null);
		
		txtConsole = new JTextArea();
		txtConsole.setWrapStyleWord(true);
		txtConsole.setEditable(false);
		txtConsole.setBounds(20, 11, 1215, 139);
		panelConsole.add(txtConsole);
		
		JScrollPane scrollPane = new JScrollPane(txtConsole);
		scrollPane.setBounds(20, 11, 1253, 139);
		panelConsole.add(scrollPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(375, 5, 560, 510);
		contentPane.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Policy Settings ", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 26, 535, 179);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblPolicyName = new JLabel("Policy Name :");
		lblPolicyName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPolicyName.setForeground(Color.BLACK);
		lblPolicyName.setBounds(10, 21, 78, 14);
		panel_4.add(lblPolicyName);
		
		txtPolicyname = new JTextField();
		txtPolicyname.setBounds(93, 19, 244, 20);
		panel_4.add(txtPolicyname);
		txtPolicyname.setColumns(10);
		
		JLabel lblmandatoryAttribute = new JLabel("(mandatory attribute)");
		lblmandatoryAttribute.setForeground(Color.LIGHT_GRAY);
		lblmandatoryAttribute.setBounds(347, 22, 114, 14);
		panel_4.add(lblmandatoryAttribute);
		
		txtPolicydiscuri = new JTextField();
		txtPolicydiscuri.setBounds(93, 50, 244, 20);
		panel_4.add(txtPolicydiscuri);
		txtPolicydiscuri.setColumns(10);
		
		JLabel lblDiscuri = new JLabel("Discuri :");
		lblDiscuri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiscuri.setBounds(10, 46, 55, 14);
		panel_4.add(lblDiscuri);
		
		JLabel lblOpturi = new JLabel("Opturi :");
		lblOpturi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOpturi.setBounds(10, 92, 46, 14);
		panel_4.add(lblOpturi);
		
		JLabel label_2 = new JLabel("(mandatory attribute)");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setBounds(347, 53, 114, 14);
		panel_4.add(label_2);
		
		JLabel lbluriOfThe = new JLabel("\"URI of the natural language privacy statement.\"");
		lbluriOfThe.setBounds(91, 69, 246, 17);
		panel_4.add(lbluriOfThe);
		
		txtPolicyopturi = new JTextField();
		txtPolicyopturi.setBounds(93, 90, 244, 20);
		panel_4.add(txtPolicyopturi);
		txtPolicyopturi.setColumns(10);
		
		JLabel lblUriOfInstructions = new JLabel("URI of instructions that users can follow to request ");
		lblUriOfInstructions.setBounds(93, 113, 368, 20);
		panel_4.add(lblUriOfInstructions);
		
		JLabel lblOrDecline = new JLabel("or decline to have their data used for a particular purpose (opt-in or opt-out).");
		lblOrDecline.setBounds(93, 132, 442, 14);
		panel_4.add(lblOrDecline);
		
		btnMatch = new JButton("Match");
		btnMatch.setBounds(156, 216, 95, 23);
		panel_3.add(btnMatch);
		
		btnMerge = new JButton("Merge");
		btnMerge.addActionListener(this);
		btnMerge.setBounds(301, 216, 95, 23);
		panel_3.add(btnMerge);
		btnMatch.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Matching Result", null, panel_2, null);
		panel_2.setLayout(null);
		
		txtMatching = new JTextArea();
		txtMatching.setWrapStyleWord(true);
		txtMatching.setBounds(1, 1, 533, 470);
		panel_2.add(txtMatching);
		
		JScrollPane scrollPane_3 = new JScrollPane(txtMatching);
		scrollPane_3.setBounds(10, 5, 535, 466);
		panel_2.add(scrollPane_3);
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("Merged P3P Tree Model", null, panel, null);
		panel.setLayout(null);
		
		mergedP3PTree = new JTree();
		mergedP3PTree.setBounds(10, 0, 535, 471);
		mergedP3PTree.setModel(null);
		panel.add(mergedP3PTree);
		
		JScrollPane scrollPane_4 = new JScrollPane(mergedP3PTree);
		scrollPane_4.setBounds(10, 0, 535, 471);
		panel.add(scrollPane_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Merged P3P Policy", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnValidatePolicy = new JButton("Validate Policy");
		btnValidatePolicy.setBounds(10, 448, 130, 23);
		panel_1.add(btnValidatePolicy);
		
		JButton btnSavePolicy = new JButton("Save Policy");
		btnSavePolicy.setBounds(415, 448, 130, 23);
		panel_1.add(btnSavePolicy);
		
		txtmergedP3P = new JTextArea();
		txtmergedP3P.setWrapStyleWord(true);
		txtmergedP3P.setBounds(10, 11, 535, 426);
		panel_1.add(txtmergedP3P);
		
		JScrollPane scrollPane_5 = new JScrollPane(txtmergedP3P);
		scrollPane_5.setBounds(10, 11, 535, 426);
		panel_1.add(scrollPane_5);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnUpload1 )
		{
			getPolicy1Path();
		}
		
		if(e.getSource() == btnUpload2)
		{
			getPolicy2Path();
		}
		if(e.getSource() == btnMatch)
		{
			txtConsole.append(newline+"Matching P3P Policies A and B"+newline);
			txtMatching.setText("") ;
			P3PMatch objmatch = new P3PMatch();
			txtMatching.append(objmatch.matchP3P(document1, document2));
			
			
		}
		if(e.getSource().equals(btnMerge))
		{
			mergeP3P objP3P = new mergeP3P();
			objP3P.merge(txtPolicyname.getText(), txtPolicydiscuri.getText(), txtPolicyopturi.getText());
			newP3Pdoc = objP3P.merged(document1, document2);
			DocumentTreeModel treemodelP3P = new DocumentTreeModel(newP3Pdoc);
			mergedP3PTree.setModel(treemodelP3P);
		}
	}
	
	
	public void getPolicy1Path()
	{
		 
		if((txtURL1 == null) || (txtURL1.getText().equals(""))){
			 
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("P3P Polcies: ", "xml");
			 JFileChooser fileChooser = new JFileChooser();
			 fileChooser.setFileFilter(filter);
			 fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
			 int resultVal = fileChooser.showOpenDialog(this);
			 	if(resultVal == JFileChooser.APPROVE_OPTION)
			 	{
			 		filep3p = fileChooser.getSelectedFile();
				 		try
				 		{
				 			txtConsole.append("Opening Policy "+filep3p.getName()+newline);
					 		txtConsole.append("from :"+filep3p.getPath()+newline);
					 		
				 			SAXReader reader = new SAXReader();
				 			String usepath = filep3p.getPath();
				 			document1 = reader.read(usepath);
				 			
				 			DocumentTreeModel treemodel = new DocumentTreeModel(document1);
				 			treeP3P1.setModel(treemodel);
				 			
				 		}
				 		catch(Exception e)
				 		{
				 			e.printStackTrace();
				 		}
			 	}
			 
		 }else 
		 {
			 try
			 {		
		 			SAXReader reader = new SAXReader();
				    String usepath = txtURL1.getText();
				 	p3pURL = new URL(usepath);
				 	
		 			txtConsole.append("Opening Policy from URI"+newline);
			 		txtConsole.append("from :"+usepath);
		 			
		 			document1 = reader.read(p3pURL);
		 			DocumentTreeModel treemodel = new DocumentTreeModel(document1);
		 			treeP3P1.setModel(treemodel);
			 }
			 catch (Exception e)
			 {
				e.printStackTrace();
			 }
		 }
		 
		 
	}
	

	public void getPolicy2Path()
	{
		if((txtURL2 == null) || (txtURL2.getText().equals(""))){
			 
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("P3P Polcies: ", "xml");
			 JFileChooser fileChooser = new JFileChooser();
			 fileChooser.setFileFilter(filter);
			 fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
			 int resultVal = fileChooser.showOpenDialog(this);
			 	if(resultVal == JFileChooser.APPROVE_OPTION)
			 	{
			 		filep3p = fileChooser.getSelectedFile();
				 		try
				 		{
				 			txtConsole.append("Opening Policy "+filep3p.getName()+newline);
					 		txtConsole.append("from :"+filep3p.getPath() + newline);
					 		
				 			SAXReader reader2 = new SAXReader();
				 			String usepath = filep3p.getPath();
				 			document2 = reader2.read(usepath);
				 			
				 			DocumentTreeModel treemodel = new DocumentTreeModel(document2);
				 			treeP3P2.setModel(treemodel);
				 			
				 		}
				 		catch(Exception e)
				 		{
				 			e.printStackTrace();
				 		}
			 	}
			 
		 }else 
		 {
			 try
			 {		
		 			SAXReader reader2 = new SAXReader();
				    String usepath = txtURL2.getText();
				 	p3pURL = new URL(usepath);
				 	
				 	txtConsole.append("Opening Policy from URI"+newline);
			 		txtConsole.append("from :"+usepath);
		 			
		 			document2 = reader2.read(p3pURL);
		 			DocumentTreeModel treemodel = new DocumentTreeModel(document2);
		 			treeP3P2.setModel(treemodel);
			 }
			 catch (Exception e)
			 {
				e.printStackTrace();
			 }
		 }
		 
	}
	

}
