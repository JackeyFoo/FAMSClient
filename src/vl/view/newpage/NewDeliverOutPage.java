package vl.view.newpage;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import vl.interfaces.MyDialog;
import vl.interfaces.MyJFrame;
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

	public NewDeliverOutPage(MyJFrame jframe, Assets asset,
			DeliverOut deliverout, boolean editable) {

		super(jframe, "资产出库", false);

		this.jframe = jframe;
		this.asset = asset;

		if (deliverout == null) {

			this.setTitle("资产出库");

			this.deliverout = new DeliverOut();
		} else {

			if (editable) {
				this.setTitle("资产出库编辑");
			} else {
				this.setTitle("资产出库详情");
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
		contentpanel.setBorder(BorderFactory.createTitledBorder("出库信息"));

		add(contentpanel, BorderLayout.CENTER);

		controlpanel = new JPanel();

		add(controlpanel, BorderLayout.PAGE_END);

		initContentPanel();
		initControlPanel();
	}

	public void initControlPanel() {

		save = new JButton("保存");
		cancel = new JButton("取消");

		controlpanel.add(save);
		controlpanel.add(cancel);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NewDeliverOutPage.this.dispose();
			}

		});

		if (this.getTitle().equals("资产出库")) {
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
		} else if (this.getTitle().equals("资产出库编辑")) {
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
		rightpanel.setBorder(BorderFactory.createTitledBorder("出库凭证"));
		rightpanel.setLayout(new BorderLayout());

		contentpanel.add(leftpanel);
		contentpanel.add(rightpanel);

		/**************** 资产ID: *************/
		JPanel leftpanel01 = new JPanel();
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftpanel.add(leftpanel01);

		JLabel assetidlabel = new JLabel("资产ID:  ");
		assetidlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		assetid = new JLabel(asset.getFormatAssetid());

		leftpanel01.add(assetidlabel);
		leftpanel01.add(assetid);

		/**************** 出库ID *************/
		JPanel leftpanel02 = new JPanel();
		leftpanel.add(leftpanel02);

		JLabel deliveroutlabel = new JLabel("出库ID(系统自动生成):  ");
		deliveroutid = new JLabel(deliverout.getFormatID());

		leftpanel02.add(deliveroutlabel);
		leftpanel02.add(deliveroutid);

		/*************** 领用部门 **************/
		JPanel leftpanel03 = new JPanel();
		leftpanel.add(leftpanel03);

		JLabel deliverdepartmentlabel = new JLabel("领用部门(必填):  ");
		deliverdepartment = new JTextField(deliverout.getDeliverdepartment());
		deliverdepartment.setColumns(30);

		leftpanel03.add(deliverdepartmentlabel);
		leftpanel03.add(deliverdepartment);

		/************** 领用人 ***************/
		JPanel leftpanel04 = new JPanel();
		leftpanel.add(leftpanel04);

		JLabel deliverstafflabel = new JLabel("领用人(必填):  ");
		deliverstaff = new JTextField(deliverout.getDeliverstaff());
		deliverstaff.setColumns(30);

		leftpanel04.add(deliverstafflabel);
		leftpanel04.add(deliverstaff);

		/**************** 领用日期 *************/
		JPanel leftpanel05 = new JPanel();
		leftpanel.add(leftpanel05);

		JLabel deliverdatelabel = new JLabel("领用日期(必填):  ");
		deliverdate = new JTextField(deliverout.getDeliverdate());
		deliverdate.setColumns(30);

		leftpanel05.add(deliverdatelabel);
		leftpanel05.add(deliverdate);

		/************** 存在地址 ***************/
		JPanel leftpanel06 = new JPanel();
		leftpanel.add(leftpanel06);

		JLabel deliveraddresslabel = new JLabel("存在地址(必填):  ");
		deliveraddress = new JTextField(deliverout.getDeliveraddress());
		deliveraddress.setColumns(30);

		leftpanel06.add(deliveraddresslabel);
		leftpanel06.add(deliveraddress);

		/************** 备注 ***************/
		JPanel leftpanel07 = new JPanel();
		leftpanel.add(leftpanel07);

		JLabel deliverremarklabel = new JLabel("备注:  ");
		deliverremark = new JTextField(deliverout.getDeliverremark());
		deliverremark.setColumns(30);

		leftpanel07.add(deliverremarklabel);
		leftpanel07.add(deliverremark);
		

		/**************** 归还日期 *************/
		JPanel leftpanel11 = new JPanel();
		leftpanel.add(leftpanel11);

		JLabel returndatelabel = new JLabel("归还日期 :  ");
		returndate = new JTextField(deliverout.getReturndate());
		returndate.setColumns(30);

		leftpanel11.add(returndatelabel);
		leftpanel11.add(returndate);
		
		/************** 归还人员 ***************/
		JPanel leftpanel12 = new JPanel();
		leftpanel.add(leftpanel12);

		JLabel returnstafflabel = new JLabel("归还人员:  ");
		returnstaff = new JTextField(deliverout.getReturnstaff());
		returnstaff.setColumns(30);

		leftpanel12.add(returnstafflabel);
		leftpanel12.add(returnstaff);

		/************** 记录状态 ***************/
		JPanel leftpanel08 = new JPanel();
		leftpanel.add(leftpanel08);

		JLabel deliverrecordisnewlabel = new JLabel("记录状态:  ");
		deliverrecordisnew = new JLabel(deliverout.getDeliverrecordisnew());

		leftpanel08.add(deliverrecordisnewlabel);
		leftpanel08.add(deliverrecordisnew);

		/************** 出库凭证 ***************/

		leftpanel10 = new JPanel();
		rightpanel.add(leftpanel10, BorderLayout.NORTH);

		JLabel delivercertificatelabel = new JLabel("出库凭证(必填):  ");
		delivercertificate = new JTextField();
		delivercertificate.setColumns(30);

		JButton selectbutton = new JButton("选择");

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

			cancel.setText("确定");
			save.setVisible(false);
			leftpanel10.setVisible(false);

		}
	}

}
