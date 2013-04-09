package vl.view.newpage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import vl.interfaces.MyDialog;
import bll.controll.ChooseImageActionListen;
import bll.controll.Controller;
import bll.controll.NWEDialog;
import bll.controll.StrToFile;
import dal.model.Assets;
import dal.model.DeliverOut;

public class NewDeliverOutPage extends MyDialog {

	private DeliverOut deliverout;

	private JLabel assetid;
	private JLabel deliveroutid;
	private JTextField deliverdepartment;
	private JTextField deliverstaff;
	private JTextField deliverdate;
	private JTextField deliveraddress;
	private JTextField deliverremark;
	private JTextField delivercertificate;
	private JLabel deliverrecordisnew;
	private JTextField returndate;
	private JTextField returnstaff;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */

	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;

	public NewDeliverOutPage(JFrame jframe, Assets asset,
			DeliverOut deliverout, boolean editable) {

		super(jframe, "�ʲ�����", false);

		this.jframe = jframe;
		this.asset = asset;

		if (deliverout == null) {

			this.setTitle("�ʲ�����");

			this.deliverout = new DeliverOut();
		} else {

			if (editable) {
				this.setTitle("�ʲ�����༭");
			} else {
				this.setTitle("�ʲ���������");
			}

			this.deliverout = deliverout;
		}

		setResizable(false);
		setSize(800, 500);
		setLocation(200, 150);
		setVisible(true);
		setLayout(new BorderLayout());
		initDialog();

		setVisible(true);
	}

	public void initDialog() {

		contentpanel = new JPanel();
		contentpanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}

	public void initControlPanel() {

		save = new JButton("����");
		cancel = new JButton("ȡ��");

		controlpanel.add(save);
		controlpanel.add(cancel);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewDeliverOutPage.this.dispose();
			}

		});

		if (this.getTitle().equals("�ʲ�����")) {
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.saveNewDeliverOutInfo(jframe, deliverout,
								files, NewDeliverOutPage.this);

					} else {
						NWEDialog.necessaryDataError();
					}
				}

			});
		} else if (this.getTitle().equals("�ʲ�����༭")) {
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isFull()) {

						packData();

						Controller.updateDeliverOutInfo(jframe, deliverout,
								files, NewDeliverOutPage.this);

					} else {
						NWEDialog.necessaryDataError();
					}
				}

			});
		}

	}

	public void initContentPanel() {

		contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(BorderFactory.createTitledBorder("����ƾ֤"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/**************** �ʲ�ID: *************/
		JPanel leftpanel01 = new JPanel();
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);

		JLabel assetidlabel = new JLabel("�ʲ�ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatAssetid());

		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);

		/**************** ����ID *************/
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel deliveroutlabel = new JLabel("����ID(ϵͳ�Զ�����):  ");
		deliveroutid = new JLabel(deliverout.getFormatID());

		leftpanel02.add(deliveroutlabel);
		leftpanel02.add(deliveroutid);

		/*************** ���ò��� **************/
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel deliverdepartmentlabel = new JLabel("���ò���(����):  ");
		deliverdepartment = new JTextField(deliverout.getDeliverdepartment());
		deliverdepartment.setColumns(30);

		leftpanel03.add(deliverdepartmentlabel);
		leftpanel03.add(deliverdepartment);

		/************** ������ ***************/
		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel deliverstafflabel = new JLabel("������(����):  ");
		deliverstaff = new JTextField(deliverout.getDeliverstaff());
		deliverstaff.setColumns(30);

		leftpanel04.add(deliverstafflabel);
		leftpanel04.add(deliverstaff);

		/**************** �������� *************/
		JPanel leftpanel05 = new JPanel();
		leftpanel.add(leftpanel05);

		JLabel deliverdatelabel = new JLabel("��������(����):  ");
		deliverdate = new JTextField(deliverout.getDeliverdate());
		deliverdate.setColumns(30);

		leftpanel05.add(deliverdatelabel);
		leftpanel05.add(deliverdate);

		/************** ���ڵ�ַ ***************/
		JPanel leftpanel06 = new JPanel();
		leftpanel.add(leftpanel06);

		JLabel deliveraddresslabel = new JLabel("���ڵ�ַ(����):  ");
		deliveraddress = new JTextField(deliverout.getDeliveraddress());
		deliveraddress.setColumns(30);

		leftpanel06.add(deliveraddresslabel);
		leftpanel06.add(deliveraddress);

		/************** ��ע ***************/
		JPanel leftpanel07 = new JPanel();
		leftpanel.add(leftpanel07);

		JLabel deliverremarklabel = new JLabel("��ע:  ");
		deliverremark = new JTextField(deliverout.getDeliverremark());
		deliverremark.setColumns(30);

		leftpanel07.add(deliverremarklabel);
		leftpanel07.add(deliverremark);
		

		/**************** �黹���� *************/
		JPanel leftpanel11 = new JPanel();
		leftpanel.add(leftpanel11);

		JLabel returndatelabel = new JLabel("�黹���� :  ");
		returndate = new JTextField(deliverout.getReturndate());
		returndate.setColumns(30);

		leftpanel11.add(returndatelabel);
		leftpanel11.add(returndate);
		
		/************** �黹��Ա ***************/
		JPanel leftpanel12 = new JPanel();
		leftpanel.add(leftpanel12);

		JLabel returnstafflabel = new JLabel("�黹��Ա:  ");
		returnstaff = new JTextField(deliverout.getReturnstaff());
		returnstaff.setColumns(30);

		leftpanel12.add(returnstafflabel);
		leftpanel12.add(returnstaff);

		/************** ��¼״̬ ***************/
		JPanel leftpanel08 = new JPanel();
		leftpanel.add(leftpanel08);

		JLabel deliverrecordisnewlabel = new JLabel("��¼״̬:  ");
		deliverrecordisnew = new JLabel(deliverout.getDeliverrecordisnew());

		leftpanel08.add(deliverrecordisnewlabel);
		leftpanel08.add(deliverrecordisnew);

		/************** ����ƾ֤ ***************/

		leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel delivercertificatelabel = new JLabel("����ƾ֤(����):  ");
		delivercertificate = new JTextField();
		delivercertificate.setColumns(30);

		JButton selectbutton = new JButton("ѡ��");

		selectbutton.addActionListener(new ChooseImageActionListen(
				NewDeliverOutPage.this));

		leftpanel10.add(delivercertificatelabel);
		leftpanel10.add(delivercertificate);
		leftpanel10.add(selectbutton);

		rightpanel01 = new JPanel();

		JScrollPane rightscroll = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		rightpanel01
				.setLayout(new BoxLayout(rightpanel01, BoxLayout.PAGE_AXIS));
		rightpanel.add(rightscroll, BorderLayout.CENTER);

		rightscroll.setViewportView(rightpanel01);

		addImageToPanel(StrToFile.filesAnalytical(
				deliverout.getDelivercertificate(), "<"));
	}

	@Override
	public void packData() {
		// TODO Auto-generated method stub
		deliverout = new DeliverOut();

		deliverout.setAssetid(asset.getAssetid());
		deliverout.setDeliveroutid(Integer.parseInt(deliveroutid.getText()));
		deliverout.setDeliverdepartment(deliverdepartment.getText());
		deliverout.setDeliverstaff(deliverstaff.getText());
		deliverout.setDeliverdate(deliverdate.getText());
		deliverout.setDeliveraddress(deliveraddress.getText());
		deliverout.setDeliverremark(deliverremark.getText());
		deliverout.setDeliverrecordisnew(deliverrecordisnew.getText());
		deliverout.setReturndate(returndate.getText());
		deliverout.setReturnstaff(returnstaff.getText());
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if (deliverdepartment.getText().equals("")) {
			return false;
		} else if (deliverstaff.getText().equals("")) {
			return false;
		} else if (deliverdate.getText().equals("")) {
			return false;
		} else if (deliveraddress.getText().equals("")) {
			return false;
		} else if (deliverout.getDelivercertificate() == null) {
			if(delivercertificate.getText().equals("")){
				return false;
			}else{
				return true;
			}
		} else {
			return true;
		}
	}

	@Override
	public void setImagePath(String txt) {
		// TODO Auto-generated method stub
		delivercertificate.setText(txt);
	}

	@Override
	public void isEditable(boolean editable) {
		// TODO Auto-generated method stub
		if (editable) {

		} else {

			deliverdepartment.setEditable(false);
			deliverstaff.setEditable(false);
			deliverdate.setEditable(false);
			deliveraddress.setEditable(false);
			deliverremark.setEditable(false);
			delivercertificate.setEditable(false);

			cancel.setText("ȷ��");
			save.setVisible(false);
			leftpanel10.setVisible(false);

		}
	}

}