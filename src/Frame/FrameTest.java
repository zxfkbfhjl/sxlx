package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FrameTest extends JFrame {
    public FrameTest() {
        //���ô����С
        this.setSize(800,600);
        this.setTitle("���ҳ��");
        //�������񲼾�
        GridLayout gridLayout = new GridLayout(5, 2);
        this.setLayout(gridLayout);
        //���ñ�ǩ
        JLabel jlabelweb=new JLabel("��վ:");
        JLabel jLabelaccount=new JLabel("�˺�:");
        JLabel jLabelpassword=new JLabel("����:");
        JLabel jLabelremark=new JLabel("��ע:");
       //�����ı���
        JTextField txtweb = new JTextField(20);
        JTextField txtaccount = new JTextField(20);
        JTextField txtpassword = new JTextField(20);
        JTextField txtremark = new JTextField(20);
        //���ð�ť
        JButton buttonYes=new JButton("ȷ��");
        JButton buttonNo=new JButton("ȡ��");
        //�����¼�����
        buttonYes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        // TODO Auto-generated method stub
                        JOptionPane.showMessageDialog(null,""+txtweb.getText()+","+txtaccount.getText()+","+txtpassword.getText()+","+txtremark.getText());
                    }
                });
        
        //���������ӱ�ǩ���ı��򡢰�ť
        this.add(jlabelweb);
        this.add(txtweb);
        this.add(jLabelaccount);
        this.add(txtaccount);
        this.add(jLabelpassword);
        this.add(txtpassword);
        this.add(jLabelremark);
        this.add(txtremark);
        this.add(buttonYes);
        this.add(buttonNo);

        //��ʾ���
        this.setVisible(true);
        }
    public static void main(String args[]) {
        new FrameTest();
    }
}
