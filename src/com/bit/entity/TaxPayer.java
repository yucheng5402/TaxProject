package com.bit.entity;


/**
 * 缂佹儳纾埣锝嗙鏉為绻嗛柟顓у灥閵嗭拷 tb_tax_payer
 * @author hornlee
 *
 */


public class TaxPayer {

	private int id;//濞戞挸顭烽弫锟�
	
	private String payerCode;//缂佹儳纾埣锝嗙妤﹁法妲曢柛鎺濆亜瑜帮拷 not null
	
	private String payerName;//缂佹儳纾埣锝嗙閸濆嫭鍊崇紒澶屾畬ot null
	
	private String bizAddress;//闁汇垻鍠嶆鍥╃磼韫囨碍鍎夐柛锔芥緲濞煎兇ot null
	
	private int taxOrganId;// 闁圭鎷烽悘鐐靛仧閳硷綁宕濋埄鍐╃皻闁稿骏鎷� ot null
	
	private int industryId;//閻炴稑濂旂粭锟�
	
	private String bizScope;//缂備礁绻楅幆锟介柤鐓庡暙濞诧拷 
	
	private String invoiceType;//缂佷降鍔庨～鎺楀冀缁嬭法鏆� 
	
	private String legalPerson;//婵炲娲戝Ч澶嬬閿濆牄锟斤拷 
	
	private String legalIdCard;//闂婎剦鍋傞崬銈夊矗妞嬪海鍨� 
	
	private String legalMobile;//闁归潧顑嗗┃锟介柛娆擃棑閻栵拷 
	
	private String legalIdCardImageURL;//婵炲娲戝Ч澶嬬閿濆牄锟藉啴鐓鈥虫暅閻犲洣鐒︽竟鍌炲箵韫囨挻绂堥柣妤嬫嫹 
	
	private String finaceName;//閻犳劑鍨规慨鐔哥閸濆嫭鍠� 
	
	private String finaceIdCard;//閻犳劑鍨规慨鐔哥閸濆嫭鍠呴棅顒夊亗閸炪倝宕ｆ搴ｅ灣
	
	private String finaceMobile;//閻犳劑鍨规慨鐔哥閸濆嫭鍠呴柟闈涱儐濠э拷闁告瑩顥撻悥锟� 
	
	private String finaceIdCardImageURL;//閻犳劑鍨规慨鐔哥閸濆嫭鍠呴棅顒夊亗閸炪倗鎷犳担鐟邦棁闁硅绻愬ù姗�鎮ч敓锟�
	
	private String taxerName;//闁告梻鍋熼埣锝嗙閸濆嫭鍠� 
	
	private String taxerIdCard;//闁告梻鍋熼埣锝嗙閸濆嫭鍠呴棅顒夊亗閸炪倝宕ｆ搴ｅ灣 
	
	private String taxerMobile;//闁告梻鍋熼埣锝嗙閸濆嫭鍠呴柟闈涱儐濠э拷闁告瑩顥撻悥锟� 
	
	private String taxerIdCardImageURL;//闁告梻鍋熼埣锝嗙閸濆嫭鍠呴棅顒夊亗閸炪倗鎷犳担鐟邦棁闁硅绻愬ù姗�鎮ч敓锟�
	
	private String bizAddressPhone;// 闁汇垻鍠嶆鍥╃磼韫囨碍鍎夐柛锔藉閺佸摜鎷犻敓锟� 
	
	private String recordDate;// 鐟滅増娲栭崣鍡涘籍閵夛附鍩� 
	
	private int userId;//鐟滅増娲栭崣鍡樼閸濆嫭鍠� 
	
	private int removeState;

	/**
	 * getter 闁告粣鎷� setter 闁哄倽顫夌涵锟�
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRemoveState() {
		return removeState;
	}

	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getBizAddress() {
		return bizAddress;
	}

	public void setBizAddress(String bizAddress) {
		this.bizAddress = bizAddress;
	}

	public int gettaxOrganId() {
		return taxOrganId;
	}

	public void settaxOrganId(int taxOrganId) {
		this.taxOrganId = taxOrganId;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getBizScope() {
		return bizScope;
	}

	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalIdCard() {
		return legalIdCard;
	}

	public void setLegalIdCard(String legalIdCard) {
		this.legalIdCard = legalIdCard;
	}

	public String getLegalMobile() {
		return legalMobile;
	}

	public void setLegalMobile(String legalMobile) {
		this.legalMobile = legalMobile;
	}

	public String getLegalIdCardImageURL() {
		return legalIdCardImageURL;
	}

	public void setLegalIdCardImageURL(String legalIdCardImageURL) {
		this.legalIdCardImageURL = legalIdCardImageURL;
	}

	public String getFinaceName() {
		return finaceName;
	}

	public void setFinaceName(String finaceName) {
		this.finaceName = finaceName;
	}

	public String getFinaceIdCard() {
		return finaceIdCard;
	}

	public void setFinaceIdCard(String finaceIdCard) {
		this.finaceIdCard = finaceIdCard;
	}

	public String getFinaceMobile() {
		return finaceMobile;
	}

	public void setFinaceMobile(String finaceMobile) {
		this.finaceMobile = finaceMobile;
	}

	public String getFinaceIdCardImageURL() {
		return finaceIdCardImageURL;
	}

	public void setFinaceIdCardImageURL(String finaceIdCardImageURL) {
		this.finaceIdCardImageURL = finaceIdCardImageURL;
	}

	public String getTaxerName() {
		return taxerName;
	}

	public void setTaxerName(String taxerName) {
		this.taxerName = taxerName;
	}

	public String getTaxerIdCard() {
		return taxerIdCard;
	}

	public void setTaxerIdCard(String taxerIdCard) {
		this.taxerIdCard = taxerIdCard;
	}

	public String getTaxerMobile() {
		return taxerMobile;
	}

	public void setTaxerMobile(String taxerMobile) {
		this.taxerMobile = taxerMobile;
	}

	public String getTaxerIdCardImageURL() {
		return taxerIdCardImageURL;
	}

	public void setTaxerIdCardImageURL(String taxerIdCardImageURL) {
		this.taxerIdCardImageURL = taxerIdCardImageURL;
	}

	public String getBizAddressPhone() {
		return bizAddressPhone;
	}

	public void setBizAddressPhone(String bizAddressPhone) {
		this.bizAddressPhone = bizAddressPhone;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
	public TaxPayer() {
		super();
	}

	public TaxPayer(String payerCode, String payerName, String bizAddress, int taxOrganId, int industryId,
			String bizScope, String invoiceType, String legalPerson, String legalIdCard, String finaceName,
			String finaceIdCard, String taxerName, String bizAddressPhone, String recordDate,int userId) {
		super();
		this.payerCode = payerCode;
		this.payerName = payerName;
		this.bizAddress = bizAddress;
		this.taxOrganId = taxOrganId;
		this.industryId = industryId;
		this.bizScope = bizScope;
		this.invoiceType = invoiceType;
		this.legalPerson = legalPerson;
		this.legalIdCard = legalIdCard;
		this.finaceName = finaceName;
		this.finaceIdCard = finaceIdCard;
		this.taxerName = taxerName;
		this.bizAddressPhone = bizAddressPhone;
		this.recordDate = recordDate;
		this.userId =userId;
	}

	@Override
	public String toString() {
		return "TaxPayer [id=" + id + ", payerCode=" + payerCode + ", payerName=" + payerName + ", bizAddress="
				+ bizAddress + ", taxOrganId=" + taxOrganId + ", industryId=" + industryId + ", bizScope=" + bizScope
				+ ", invoiceType=" + invoiceType + ", legalPerson=" + legalPerson + ", legalIdCard=" + legalIdCard
				+ ", legalMobile=" + legalMobile + ", legalIdCardImageURL=" + legalIdCardImageURL + ", finaceName="
				+ finaceName + ", finaceIdCard=" + finaceIdCard + ", finaceMobile=" + finaceMobile
				+ ", finaceIdCardImageURL=" + finaceIdCardImageURL + ", taxerName=" + taxerName + ", taxerIdCard="
				+ taxerIdCard + ", taxerMobile=" + taxerMobile + ", taxerIdCardImageURL=" + taxerIdCardImageURL
				+ ", bizAddressPhone=" + bizAddressPhone + ", recordDate=" + recordDate + ", userId=" + userId
				+ ", removeState=" + removeState + "]";
	}
	
	
	
}
