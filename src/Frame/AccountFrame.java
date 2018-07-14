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
	//添加按钮
	 private JButton btnAdd=new JButton("add");
	 //
    private JButton btnDelete=new JButton("delete");
    //
    private JButton btnModify=new JButton("modify");
    private JTextField text1=new  JTextField();
    //上部放置查询相关组件的面板
    private  JPanel  panelSearch=new JPanel();
    //下部提供add、dEl、modify操作的面板
    private  JPanel  panelPanecess=new JPanel();
    //搜索框
    private  JTextField  txtSearch=new  JTextField();
    //搜索按钮
    private  JButton  btnSearch=new  JButton("Seach");
    private  JPanel panelAdd=new JPanel();
    //设置标签和文本框
    JLabel m1=new JLabel("网站:");
	JTextField  n1=new  JTextField(50);
	JLabel m2=new  JLabel("账号：");
	JTextField   n2=new  JTextField(50);
	JLabel m3=new  JLabel("密码：");
	JTextField   n3=new  JTextField(50);
	JLabel m4=new JLabel("备注：");
    JTextField   n4=new  JTextField(50);
    
    public  AccountFrame() {
    	//初始化组件
    	 this.add(panelSearch, BorderLayout.NORTH);//添加搜索板面道顶部
    	 this.add(text1,BorderLayout.CENTER);
         this.add(panelPanecess,BorderLayout.SOUTH);//添加操作板面道底部
         
         
      panelSearch.setLayout(new BorderLayout());  //设置搜索板面布局
      panelSearch.add(txtSearch);//添加搜索框道中间部分
   	  panelSearch.add(btnSearch,BorderLayout.EAST);//添加搜索按钮到右边
	   
		panelPanecess.add(btnAdd);
		panelPanecess.add(btnDelete);
		panelPanecess.add(btnModify);
       
		//搜索按钮事件监听，弹出对话框，显示搜索框中输入的内容
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
		//add按钮事件监听
    btnAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//一个按钮实现两个功能
		  String text=btnAdd.getText();
		  if(text.equals("add")) {
			  text="save";
			  AccountFrame.this.remove(panelSearch);//移除搜索组件
			  AccountFrame.this.remove(text1);//移除中间文本框组件
			  AccountFrame.this.add(panelAdd);//添加添加板面
		  }
		  else {//还原初始状态
			  text="add";
			  AccountFrame.this.remove(panelAdd);
			  text1.setText("保存成功！");
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
	this.setTitle("账号首页");
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
    }
    
   public static void main (String arg[]){
	   new  AccountFrame();
   }
 
    
    
}
