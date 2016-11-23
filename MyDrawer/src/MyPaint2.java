

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class MyPaint2 extends JFrame implements ActionListener{

	JButton btn1 = new JButton("Ǧ            ��");
	JButton btn2 = new JButton("ֱ            ��");
	JButton btn3 = new JButton("��            ��");
	JButton btn4 = new JButton("Բ            ��");
	JButton btn5 = new JButton("��            Բ");
	JButton btn6 = new JButton("Բ��  �� ��");
	JButton btn7 = new JButton("��            Ƥ");
	JButton btn8 = new JButton("��           ��");	
	JButton btn9 = new JButton("��    ��   ��");	
	JButton btn10 = new JButton("��       ǹ");
	JButton btn11 = new JButton("��      ��1");
	JButton btn12 = new JButton("��     ��2");
	JButton btn13 = new JButton("��      ��3");
	JButton btn14 = new JButton("��    ��4");
	JLabel label = new JLabel();
	JPanel jp2 = new JPanel();
	
	JMenuBar mb = new JMenuBar(), mb2 = new JMenuBar();//�˵���
	JMenu wj = new JMenu("�ļ�(F)");//�˵�
	JMenu ys = new JMenu("��ɫ(C)");
	JMenu bz = new JMenu("����(H)");
	JMenuItem  openfile, save, saveas, exit, help, about,coloredit;//�˵�����
	
	Box box = Box.createVerticalBox();//���ϵ�����ʾ�������Box
	
	JPopupMenu pmu = new JPopupMenu();//����ʽ�˵�
	JSeparator spt1 = new JSeparator(), spt2 = new JSeparator();//�»���
	
	MyJPanel2 jp = new MyJPanel2(this);
	Color selectColor = Color.black;
	//int size = 4;
	
	public MyPaint2(){
		super("����");
		
		//����ť���ñ���ͼƬ(ͨ��setIcon���߹��캯������)
		btn1.setIcon(new ImageIcon("D:\\��ͼ����\\Ǧ��.jpg"));
		btn2.setIcon(new ImageIcon("D:\\��ͼ����\\ֱ��.jpg"));
		btn3.setIcon(new ImageIcon("D:\\��ͼ����\\����.jpg"));
		btn4.setIcon(new ImageIcon("D:\\��ͼ����\\Բ.jpg"));
		btn5.setIcon(new ImageIcon("D:\\��ͼ����\\��Բ.jpg"));
		btn6.setIcon(new ImageIcon("D:\\��ͼ����\\Բ�Ǿ���.jpg"));
		btn7.setIcon(new ImageIcon("D:\\��ͼ����\\��Ƥ��.jpg"));
		btn8.setIcon(new ImageIcon("D:\\��ͼ����\\ѡ����ɫ.jpg"));
		btn9.setIcon(new ImageIcon("D:\\��ͼ����\\�����.jpg"));
		btn10.setIcon(new ImageIcon("D:\\��ͼ����\\��ǹ.jpg"));
		btn11.setIcon(new ImageIcon("D:\\��ͼ����\\����1.jpg"));
		btn12.setIcon(new ImageIcon("D:\\��ͼ����\\����2.jpg"));
		btn13.setIcon(new ImageIcon("D:\\��ͼ����\\����3.jpg"));
		btn14.setIcon(new ImageIcon("D:\\��ͼ����\\����4.jpg"));
		
		
		openfile = new JMenuItem("��(O)",KeyEvent.VK_O);//�򿪲�����ӦO��(�������Ƿ�)����ͬ
		save = new JMenuItem("����(S)",KeyEvent.VK_S);
		saveas = new JMenuItem("���Ϊ(D)",KeyEvent.VK_D);
		exit = new JMenuItem("�˳�(X)",KeyEvent.VK_F4);
		coloredit = new JMenuItem("�༭��ɫ(E)",KeyEvent.VK_E); 
		help = new JMenuItem("��������(H)",KeyEvent.VK_H);
		about = new JMenuItem("���ڻ�ͼ(M)",KeyEvent.VK_M);
		
		//�ļ��˵�
		mb.add(wj);
		wj.add(openfile);
		wj.add(save);
		wj.add(saveas);
		wj.add(spt1);// ����ָ���
		wj.add(exit);
		
		//��ɫ�˵�
		mb.add(ys);
		ys.add(coloredit);
		
		//�����˵�
		mb.add(bz);
		bz.add(help);
		bz.add(spt2);
		bz.add(about);
		
		//�����˵�
		pmu.add("�����ߣ�");
		pmu.add("Ѧ��, ���ķ�");
		//setVisible(true);
		
		setBounds(200, 80, 840, 700);
		setBackground(jp.getBackground());// ���ô��ڱ�����ɫ
		setJMenuBar(mb);// ���˵������뵽����
		
		//box������	
		jp2.setBackground(Color.gray);
		jp2.setBounds(1, 5, 120, 600);
		jp2.add(box);
		box.add(btn1);
		box.add(new JSeparator());
		box.add(btn2);
		box.add(new JSeparator());
		box.add(btn3);
		box.add(new JSeparator());
		box.add(btn4);
		box.add(new JSeparator());
		box.add(btn5);
		box.add(new JSeparator());
		box.add(btn6);
		box.add(new JSeparator());
		box.add(btn7);
		box.add(new JSeparator());
		box.add(btn8);
		box.add(new JSeparator());
		//box.add(btn9);
		//box.add(new JSeparator());
		//box.add(btn10);
		//box.add(new JSeparator());
		box.add(btn11);
		box.add(new JSeparator());
		box.add(btn12);
		box.add(new JSeparator());
		box.add(btn13);
		box.add(new JSeparator());
		box.add(btn14);
		box.add(new JSeparator());
		this.add(jp2,BorderLayout.WEST);
		setLayout(null);
		setVisible(true);
		//box.add(btn9);
		
		//���ÿ�ݼ�
		wj.setMnemonic(KeyEvent.VK_F);
		ys.setMnemonic(KeyEvent.VK_C);
		bz.setMnemonic(KeyEvent.VK_H);
		//exit.setMnemonic(KeyEvent.VK_F4);//ͬ�¾�����һ��
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
		openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		saveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		coloredit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
				
		
		// ���Ӽ�����
		openfile.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
		coloredit.addActionListener(this);
		about.addActionListener(this);
		help.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		
		jp.setBackground(Color.white);
		jp.setBounds(130, 5, 660, 600);
		this.add(jp);
		
		this.setLayout(null);
		//this.setSize(850, 660);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1){
			jp.setType(1);
		}else if(e.getSource()==btn2){
			jp.setType(2);
		}else if(e.getSource()==btn3){
			jp.setType(3);
		}else if(e.getSource()==btn4){
			jp.setType(4);
		}else if(e.getSource()==btn5){
			jp.setType(5);
		}else if(e.getSource()==btn6){
			jp.setType(6);
		}else if(e.getSource()==btn7){
			jp.setType(7);
		}else if(e.getSource()==btn8){
			JColorChooser jc = new JColorChooser();
			selectColor = jc.showDialog(this, "��ɫ��",selectColor);
		   // selectColor=newColor;
		    btn8.setBackground(selectColor);
		    //jp.setType(1);
		}else if(e.getSource()==btn9){
			jp.setType(9);
		}else if(e.getSource()==btn10){
			jp.setType(10);
		}else if(e.getSource()==btn11){
			jp.setSize(2);
		}else if(e.getSource()==btn12){
			jp.setSize(4);
		}else if(e.getSource()==btn13){
			jp.setSize(6);
		}else if(e.getSource()==btn14){
			jp.setSize(8);
		}else if(e.getSource()==exit){
			// ��ȡ�¼�Դ
			int result = JOptionPane.showConfirmDialog(this, "�����ı��浽 δ������", "��ͼ",
					JOptionPane.YES_NO_OPTION);
			switch (result) {
			case JOptionPane.YES_OPTION:
				JFileChooser jf = new JFileChooser();
				jf.showSaveDialog(this);
				jp.save(jf.getSelectedFile());
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
				break;
			}					
		}else if(e.getSource()==openfile){
			FileDialog FD1 = new FileDialog(this, "��", FileDialog.LOAD);
			FD1.setVisible(true);
			if (FD1.getFile() != null){
				
			}
			/*JFileChooser jf = new JFileChooser();
			jf.showOpenDialog(this);
			if(jf.getSelectedFile() != null){
				jp.openfile(jf.getSelectedFile());
			}else{
				jp.openfile(null);
			}*/
		}else if(e.getSource()==save || e.getSource()==saveas){
			JFileChooser jf = new JFileChooser();
			jf.showSaveDialog(this);
			jp.save(jf.getSelectedFile());
		}else if(e.getSource()==coloredit){
			Color newColor = JColorChooser.showDialog(this, "��ɫ��",jp.getBackground());
			if (jp.getBackground() != null) {
				jp.setBackground(newColor);
			}
		}else if(e.getSource()==about){
			JDialog D = new JDialog(this, "���ڻ�ͼ");//�µ������Ĵ���
			((JComponent) D.getContentPane()).setOpaque(false);//��ȡ��岢�ѱ�������Ϊ͸�� �����Ͳ�����ס����ı��� 
			ImageIcon img = new ImageIcon("D:\\��ͼ����\\about.jpg"); 
			JLabel background = new JLabel(img);
			D.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); //��JLabel(background)��ӵ�JDialog�����е�ָ��λ��
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
			D.setBounds(400, 250, img.getIconWidth(), img.getIconHeight());
			D.setResizable(false);
			D.setVisible(true);
		}else if(e.getSource()==help){
			try {
				//Runtime.getRuntime().exec("C:\\Program Files\\Kingsoft\\WPS Office School\\office6\\wps.exe c:\\help.doc");
				Runtime.getRuntime().exec("cmd.exe /c start D:\\��ͼ����\\help.chm");//�򿪰����ĵ�
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "�޷����ĵ�");
			}
		}
	}
	
	public static void main(String[] args){
		new MyPaint2();
	}
	
}
