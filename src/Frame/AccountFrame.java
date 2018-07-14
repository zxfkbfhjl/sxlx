package Frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	 private JButton btnAdd=new JButton("add");
    private JButton btnDelete=new JButton("delete");
    private JButton btnModify=new JButton("modify");
    private JTextField text1=new  JTextField(); 
    private  JPanel  panelSearch=new JPanel();
    private  JPanel  panelPanecess=new JPanel();
    private  JTextField  txtSearch=new  JTextField();
    private  JButton  btnSearch=new  JButton("Seach");
    private  JPanel panelAdd=new JPanel();
    JLabel m1=new JLabel("ÍøÕ¾:");
	JTextField  n1=new  JTextField(50);
	JLabel m2=new  JLabel("ÕËºÅ£º");
	JTextField   n2=new  JTextField(50);
	JLabel m3=new  JLabel("ÃÜÂë£º");
	JTextField   n3=new  JTextField(50);
	JLabel m4=new JLabel("±¸×¢£º");
    JTextField   n4=new  JTextField(50);
    
    public  AccountFrame() {
    	 this.add(panelSearch, BorderLayout.NORTH);
    	 this.add(text1,BorderLayout.CENTER);
         this.add(panelPanecess,BorderLayout.SOUTH);
         
         
      panelSearch.setLayout(new BorderLayout());  
      panelSearch.add(txtSearch);
   	  panelSearch.add(btnSearch,BorderLayout.EAST);
	   
		panelPanecess.add(btnAdd);
		panelPanecess.add(btnDelete);
		panelPanecess.add(btnModify);
       
		
    	btnSearch.addActionListener(new  ActionListener(){
			public void  actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog( null, ""+txtSearch.getText());
			}
});
    	GridLayout  gridLayout=new GridLayout(4,2);
		panelAdd.setLayout(gridLayout);
		panelAdd.add(m1);
		panelAdd.add(n1);
		panelAdd.add(m2);
		panelAdd.add(n2);
		panelAdd.add(m3);
		panelAdd.add(n3);
		panelAdd.add(m4);
		panelAdd.add(n4);
		
    btnAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		  String text=btnAdd.getText();
		  if(text.equals("add")) {
			  text="save";
			  AccountFrame.this.remove(panelSearch);
			  AccountFrame.this.remove(text1);
			  AccountFrame.this.add(panelAdd);
		  }
		  else {
			  text="add";
			  AccountFrame.this.remove(panelAdd);
			  text1.setText("±£´æ³É¹¦£¡");
			  AccountFrame.this.add (text1);
			  
		  }
		  
		  btnAdd.setText(text);
		  btnDelete.setText("cancel");
		  btnModify.setVisible(false);
		  AccountFrame.this.setVisible(false);
		  AccountFrame.this.setVisible(true);
		}
		
	});
    
    this.setSize(800,600);
	this.setTitle("ÕËºÅÊ×Ò³");
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    }
    
   public static void main (String arg[]){
	   new  AccountFrame();
   }
 
    
    
}
