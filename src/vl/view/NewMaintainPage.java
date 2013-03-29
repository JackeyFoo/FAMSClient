package vl.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bll.controll.Controller;
import dal.dal.MaintainDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;
import dal.model.Maintain;

import vl.interfaces.MyDialog;

public class NewMaintainPage extends MyDialog {

	/**
	 * Launch the application.
	 */
	
	private static final long serialVersionUID = 1L;
	
	private Maintain maintain;

	private JPanel contentpanel;
	private JPanel controlpanel;
	
	private JLabel assetid;
	private JLabel maintainid;
	private JTextField maintaindepartment;
	private JTextField downdate;
	private JTextField maintainhandler;
	private JTextField downremark;
	private JTextField downphenomenon;
	private JTextField maintainprocess;
	private JTextField devicestatus;
	private JTextField maintaincost;
	private JLabel maintainrecordisnew;
	/**
	/**
	 * Create the dialog.
	 */
	public NewMaintainPage(JFrame jframe, ModelObject o) {

		super(jframe, "�豸ά��", false);
		
		this.jframe = jframe;
		this.asset = (Assets) o;

		setResizable(false);
		setSize(400, 500);
		setLocation(400, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);
	}

	public void initDialog() {
		

		contentpanel = new JPanel(); 
		contentpanel.setBorder(BorderFactory.createTitledBorder("ά����Ϣ"));
		
		
	    add(contentpanel, BorderLayout.CENTER);
		
		controlpanel = new JPanel();
		
		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}
	public void initControlPanel(){
		
		JButton save = new JButton("����");
		JButton cancel = new JButton("ȡ��");
		
		controlpanel.add(save);
		controlpanel.add(cancel);
		
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewMaintainPage.this.dispose();
			}
			
		});
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (isFull()) {

					packData();

					 Controller.saveNewMaintainInfo(jframe, maintain,
					 NewMaintainPage.this);

				} else {
					JOptionPane.showMessageDialog(null, "����д��Ҫ������", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		
	}
	//initContengpanel
	public void initContentPanel(){
	
		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));
		
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
		
		contentpanel.add(leftpanel);
		
		/****************�ʲ�ID:*************/
		JPanel leftpanel01 = new JPanel();	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);
		
		JLabel assetidlabel = new JLabel("�ʲ�ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatID());
		
		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);
		
		/****************ά��ID*************/
		JPanel leftpanel02 = new JPanel();	
		leftpanel.add(leftpanel02);
		
		JLabel maintainidlabel = new JLabel("����ID(ϵͳ�Զ�����):  ");	
		maintainid = new JLabel(new DecimalFormat("00000000").format(MaintainDAO.getID()));
		
		leftpanel02.add(maintainidlabel);
		leftpanel02.add(maintainid);
		
		/***************ά�޲���**************/
		JPanel leftpanel03 = new JPanel();	
		leftpanel.add(leftpanel03);
		
		JLabel maintaindepartmentlabel = new JLabel("ά�޲���(����):  ");	
		maintaindepartment = new JTextField();
		maintaindepartment.setColumns(30);
		
		leftpanel03.add(maintaindepartmentlabel);
		leftpanel03.add(maintaindepartment);
		
		/**************��������***************/
		JPanel leftpanel04 = new JPanel();	
		leftpanel.add(leftpanel04);
		
		JLabel downdatelabel = new JLabel("��������(����):  ");	
		downdate = new JTextField();
		downdate.setColumns(30);
		
		leftpanel04.add(downdatelabel);
		leftpanel04.add(downdate);
		
		/****************������*************/
		JPanel leftpanel05 = new JPanel();	
		leftpanel.add(leftpanel05);
		
		JLabel maintainhandlerlabel = new JLabel("������(����):  ");	
		maintainhandler = new JTextField();
		maintainhandler.setColumns(30);
		
		leftpanel05.add(maintainhandlerlabel);
		leftpanel05.add(maintainhandler);
		
		
		/**************�������***************/
		JPanel leftpanel06 = new JPanel();	
		leftpanel.add(leftpanel06);
		
		JLabel downremarklabel = new JLabel("�������:  ");	
		downremark = new JTextField();
		downremark.setColumns(30);
		
		leftpanel06.add(downremarklabel);
		leftpanel06.add(downremark);
		
		
		/**************��������***************/
		JPanel leftpanel07 = new JPanel();	
		leftpanel.add(leftpanel07);
		
		JLabel downphenomenonlabel = new JLabel("��������:  ");	
		downphenomenon = new JTextField();
		downphenomenon.setColumns(30);
		
		leftpanel07.add(downphenomenonlabel);
		leftpanel07.add(downphenomenon);	
		
		/**************ά�޹���***************/
		JPanel leftpanel08 = new JPanel();	
		leftpanel.add(leftpanel08);
		
		JLabel maintainprocesslabel = new JLabel("ά�޹���:  ");	
		maintainprocess = new JTextField();
		maintainprocess.setColumns(30);
		
		leftpanel08.add(maintainprocesslabel);
		leftpanel08.add(maintainprocess);
		
		/**************�豸״��***************/
		JPanel leftpanel09 = new JPanel();	
		leftpanel.add(leftpanel09);
		
		JLabel devicestatuslabel = new JLabel("ά�޹���:  ");	
		devicestatus = new JTextField();
		devicestatus.setColumns(30);
		
		leftpanel09.add(devicestatuslabel);
		leftpanel09.add(devicestatus);
		
		/**************ά�޷���***************/
		JPanel leftpanel10 = new JPanel();	
		leftpanel.add(leftpanel10);
		
		JLabel maintaincostlabel = new JLabel("ά�޷���(RMB):  ");	
		maintaincost = new JTextField();
		maintaincost.setColumns(30);
		
		leftpanel10.add(maintaincostlabel);
		leftpanel10.add(maintaincost);
		
		
		/**************��¼״̬***************/
		JPanel leftpanel11 = new JPanel();	
		leftpanel.add(leftpanel11);
		
		JLabel maintainrecordisnewlabel = new JLabel("��¼״̬:  ");	
		maintainrecordisnew = new JLabel("����");
		
		leftpanel11.add(maintainrecordisnewlabel);
		leftpanel11.add(maintainrecordisnew);

	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub
		maintain = new Maintain();
		
		maintain.setAssetid(asset.getAssetid());
		maintain.setMaintainid(Integer.parseInt(maintainid.getText()));
		maintain.setMaintaindepartment(maintaindepartment.getText());
		maintain.setDowndate(downdate.getText());
		maintain.setMaintainhandler(maintainhandler.getText());
		maintain.setDownremark(downremark.getText());
		maintain.setDownphenomenon(downphenomenon.getText());
		maintain.setMaintainprocess(maintainprocess.getText());
		maintain.setDevicestatus(devicestatus.getText());
		maintain.setMaintaincost(Double.parseDouble(maintaincost.getText()));
		maintain.setMaintainrecordisnew(maintainrecordisnew.getText());
		
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(maintaindepartment.getText().equals("")){
			return false;
		}else if(downdate.getText().equals("")){
			return false;
		}else if(maintainhandler.getText().equals("")){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub
		
	}
	
}