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
		super("输入用户信息");
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
        t_2 =new JTextField("姓名",12);
        p.add(t_2);
        JPanel p2=new JPanel();
        p.add(p2);
        rb1=new JRadioButton("男",true);
        rb2=new JRadioButton("女");
       p2.add(rb1);
       p2.add(rb2);
       	Object[] pro={"浙江省","江西省","广西省"};
    	cb=new JComboBox(pro);
     	p.add(cb);
     	Object[] cities={"宁波市","温州市","杭州市"};
     	cb2=new JComboBox(cities);
		p.add(cb2);
		ad=new JButton("添加",JButton.CENTER);
		p.add(ad);
		setVisible(true);
		
		cb.addItemListener(this);
		ad.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		String s=" ";
		if(e.getSource()==ad){
				
				s+=l_1.getText()+","+t_2.getText()+",";
				if(rb1.isSelected())  s+="男";
				else s+="女"+",";
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
	   		  cb2.addItem("宁波市");
	   		  cb2.addItem("杭州市");
	   		  cb2.addItem("温州市");
	   		}
	   		if(cb.getSelectedIndex()==1)
	   		{
	   		  cb2.removeAllItems();
	   		  cb2.addItem("南昌市                      ");
	   		  cb2.addItem("赣州市");
	   		  cb2.addItem("九江市");
	   		}
	   		if(cb.getSelectedIndex()==2)
	   		{
	   		  cb2.removeAllItems();
	   		  cb2.addItem("南宁市");
	   		  cb2.addItem("桂林市");
	   		  cb2.addItem("百色市");
	   		}
	   }
	public static void main(String[] args){
		new MyFrame();
	}
	
}