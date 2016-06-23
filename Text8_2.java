import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel{
	private JTextField tf,tf2;
	private JButton bt1,bt2;
	private JLabel l,l2;
	private int num=0;
	MyPanel(){
		JPanel p=new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.setBackground(Color.lightGray);
		add(p);
		l=new JLabel("sleep",5);
		p.add(l);
		num=(int)(Math.random()*100);
		System.out.println(num);
		String s=" ";
		s=String.valueOf(num);
		tf =new JTextField(s,5);
		p.add(tf);
		bt1 =new JButton("Æô¶¯");
		bt2 =new JButton("ÖÐ¶Ï");
		p.add(bt1);
		p.add(bt2);
		p.add(new JLabel("state"));
		tf2 =new  JTextField(10);
		p.add(tf2);
	}
}
class Me extends JFrame {
	private JTextArea ta;
	private JPanel[] p;
	public Me(JPanel[] p){
		super("¹ö¶¯×Ö");
		setSize(400,400);
		setLocation(200,200);
		setBackground(Color.blue);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ta = new JTextArea(" ",100);
		//setEditable(false);
		add(ta,BorderLayout.NORTH);
		p=p;
		for(int i=0;i<p.length;i++){
			add(p[i]);
			p[i].bt1.addActionListener(this);
		    p[i].bt2.addActionListener(this);
		}
		setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e){ 
		for(int j=0;j<p.length;j++)
		{
			if(e.getSource()==p[i].bt1){
			
		}
			else if(e.getSource()==p[i].bt2){
			
		}
		}
	}
	public static void main(String[] args){
		new Me(aa);
		MyPanel[] aa=new MyPanel[3];
		aa[0]=new MyPanel();
		aa[1]=new MyPanel();
		aa[2]=new MyPanel();
	}
}


	


