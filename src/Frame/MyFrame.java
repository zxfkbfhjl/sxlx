package Frame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
public class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame()
	{
		//创建一个窗体对象
		
		this.setSize(300,200);
		this.setTitle("First  frame...."); 
		//在屏幕上显示这个窗体
		BorderLayout borderLayout=new  BorderLayout(3,2);
		this.setLayout(borderLayout);
		JButton btnNorth=new JButton("北方");
		JButton btnSouth=new JButton("南方");
		JButton btnEast=new JButton("东方");
		JButton btnWest=new JButton("西方");
		JButton btnCenter=new JButton("中间");
		this.add(btnNorth,BorderLayout.NORTH);
		this.add(btnSouth,BorderLayout.SOUTH);
		this.add(btnEast,BorderLayout.EAST);
		this.add(btnWest,BorderLayout.WEST);
		this.add(btnCenter,BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
public static void  main(String [] args) {
	 @SuppressWarnings("unused")
	MyFrame myFrame=new  MyFrame();
	
	}
}
