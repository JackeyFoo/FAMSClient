package dal.model;


public class Discard {
	private int assetid = 0;
	private String discarddepartment = null;
	private String prediscarddate = null;
	private String discarddate = null;
	private String discardreason = null;
	private String discardcertificate = null;
	
	public Discard(int assetid, String discarddepartment,
			String prediscarddate, String discarddate, String discardreason,
			String discardcertificate) {
		super();
		this.assetid = assetid;
		this.discarddepartment = discarddepartment;
		this.prediscarddate = prediscarddate;
		this.discarddate = discarddate;
		this.discardreason = discardreason;
		this.discardcertificate = discardcertificate;
	}
	
	public int getAssetid() {
		return assetid;
	}
	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}
	public String getDiscarddepartment() {
		return discarddepartment;
	}
	public void setDiscarddepartment(String discarddepartment) {
		this.discarddepartment = discarddepartment;
	}
	public String getPrediscarddate() {
		return prediscarddate;
	}
	public void setPrediscarddate(String prediscarddate) {
		this.prediscarddate = prediscarddate;
	}
	public String getDiscarddate() {
		return discarddate;
	}
	public void setDiscarddate(String discarddate) {
		this.discarddate = discarddate;
	}
	public String getDiscardreason() {
		return discardreason;
	}
	public void setDiscardreason(String discardreason) {
		this.discardreason = discardreason;
	}
	public String getDiscardcertificate() {
		return discardcertificate;
	}
	public void setDiscardcertificate(String discardcertificate) {
		this.discardcertificate = discardcertificate;
	}

	
}
/*
CREATE TABLE Discard
(
	DiscardID Decimal(9) NOT NULL IDENTITY, --报废ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	DiscardDepartment varchar(200) NOT NULL, --报废部门，100字以内
	PreDiscardDate SMALLDATETIME NOT NULL, --预报废时间
	DiscardDate SMALLDATETIME NOT NULL, --报废时间
	DiscardReason varchar(200) NOT NULL, --报废原因
	DiscardCertificate varchar(200) NOT NULL, --报废凭证，图片路径

	PRIMARY KEY (DiscardID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go
*/