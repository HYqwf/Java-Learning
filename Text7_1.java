import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Text7_1 extends JFrame implements ActionListener{
	private JButton b_heng,b_zong;
	private JLabel[][]  rl;
	public Text7_1(){
		super("交通灯示例");
		setSize(500,500);
		setLocation(100,100);
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			
		JPanel p=new JPanel();
		add(p,BorderLayout.NORTH);
		 p.setLayout(new FlowLayout(FlowLayout.LEADING));
		JButton b_heng=new JButton("横向交通灯");
		JButton b_zong=new JButton("纵向交通灯");
     	p.add(b_heng); 
     	p.add(b_zong); 
     		
     	JPanel p2=new JPanel();
     	p2.setLayout(new GridLayout(6,6));
     	add(p2,BorderLayout.CENTER);
 		rl=new JLabel [6][6];
 		for(int i=0;i<rl.length;i++){
 			for(int j=0;j<rl[i].length;j++){
				rl[i][j]=new JLabel("    ");
				p2.add(rl[i][j]);
			}
 		}

		setVisible(true);
		b_heng.addActionListener(this);
		b_zong.addActionListener(this);
}
	private void hengxiang(){
		for(int i=0;i<rl.length;i++) rl[i][3].setBackground(Color.red);
		for(int i=0;i<rl.length;i++) rl[3][i].setBackground(Color.green);
		b_heng.setEnabled(false);
		b_zong.setEnabled(true);
	}
	
	private void zongxiang(){
		for(int i=0;i<rl.length;i++) rl[i][3].setBackground(Color.green);
		for(int i=0;i<rl.length;i++) rl[3][i].setBackground(Color.red);
		b_zong.setEnabled(false);
		b_heng.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent e){  //监听器的事件处理程序
        	if (e.getSource()==b_heng) 
        		System.out.println("11111");
        			//	hengxiang();
        	//	setVisible(true);   
        	
        		
    		else if(e.getSource()==b_zong)
    		
    			//zongxiang();
        		System.out.println("22222");
        		setVisible(true);   
    		
        		
        	   
	}
	public static void main(String[] args)
	{
		new Text7_1();
	}
	
}

