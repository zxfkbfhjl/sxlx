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
		//����һ���������
		
		this.setSize(300,200);
		this.setTitle("First  frame...."); 
		//����Ļ����ʾ�������
		BorderLayout borderLayout=new  BorderLayout(3,2);
		this.setLayout(borderLayout);
		JButton btnNorth=new JButton("����");
		JButton btnSouth=new JButton("�Ϸ�");
		JButton btnEast=new JButton("����");
		JButton btnWest=new JButton("����");
		JButton btnCenter=new JButton("�м�");
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
