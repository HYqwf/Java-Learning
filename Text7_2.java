import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener,ItemListener {
	private JTextArea t_a;
	private Label l_1;
	private JTextField t_2;
	private JRadioButton rb1,rb2;
	private JComboBox cb,cb2;
	private JButton ad;
	private int count=1;
	public MyFrame(){
		super("�����û���Ϣ");
		setSize(350,235);
		setLocation(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLayout(new GridLayout(1,2));
	//	setBackground(Color.BLUE);
		t_a=new JTextArea();
		add(t_a);
		JPanel p=new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEADING));
		//add(p,FlowLayout.RIGHT);
		add(p);
		l_1=new Label(count+"  ");
        p.add(l_1);
        t_2 =new JTextField("����",12);
        p.add(t_2);
        JPanel p2=new JPanel();
        p.add(p2);
        rb1=new JRadioButton("��",true);
        rb2=new JRadioButton("Ů");
       p2.add(rb1);
       p2.add(rb2);
       	Object[] pro={"�㽭ʡ","����ʡ","����ʡ"};
    	cb=new JComboBox(pro);
     	p.add(cb);
     	Object[] cities={"������","������","������"};
     	cb2=new JComboBox(cities);
		p.add(cb2);
		ad=new JButton("���",JButton.CENTER);
		p.add(ad);
		setVisible(true);
		
		cb.addItemListener(this);
		ad.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		String s=" ";
		if(e.getSource()==ad){
				
				s+=l_1.getText()+","+t_2.getText()+",";
				if(rb1.isSelected())  s+="��";
				else s+="Ů"+",";
				s+=cb.getSelectedItem()+","+cb2.getSelectedItem()+"\n";
			   	t_a.append(s);
			   	count++;
				l_1.setText(count+" ");
				setVisible(true);
		}
	}
	 public void itemStateChanged(ItemEvent e)
	   {
	   		if(cb.getSelectedIndex()==0)
	   		{
	   		  cb2.removeAllItems();
	   		  cb2.addItem("������");
	   		  cb2.addItem("������");
	   		  cb2.addItem("������");
	   		}
	   		if(cb.getSelectedIndex()==1)
	   		{
	   		  cb2.removeAllItems();
	   		  cb2.addItem("�ϲ���                      ");
	   		  cb2.addItem("������");
	   		  cb2.addItem("�Ž���");
	   		}
	   		if(cb.getSelectedIndex()==2)
	   		{
	   		  cb2.removeAllItems();
	   		  cb2.addItem("������");
	   		  cb2.addItem("������");
	   		  cb2.addItem("��ɫ��");
	   		}
	   }
	public static void main(String[] args){
		new MyFrame();
	}
	
}