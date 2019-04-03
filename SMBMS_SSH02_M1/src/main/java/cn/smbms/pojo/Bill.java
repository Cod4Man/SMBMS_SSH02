package cn.smbms.pojo;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@DynamicUpdate
@Entity
@Table(schema = "smbms", name = "smbms_bill")
public class Bill {
	@Id
    @Column(updatable = false)
	@GenericGenerator(name = "billId", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billId")
	private Integer id;   //id 
	private String billCode; //账单编码 
	private String productName; //商品名称 
	private String productDesc; //商品描述 
	private String productUnit; //商品单位
	private BigDecimal productCount; //商品数量 
	private BigDecimal totalPrice; //总金额
	private Integer isPayment; //是否支付
    @Column(updatable = false)
	private Integer createdBy; //创建者
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
	private Date creationDate; //创建时间
	private Integer modifyBy; //更新者
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyDate;//更新时间
	@Transient
	private Integer providerId; //供应商ID

	@Transient
	private String providerName;//供应商名称

	@ManyToOne(targetEntity = Provider.class)
	@JoinColumn(name = "providerId")
	private Provider provider;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getProviderName() {
		return provider.getProName();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public BigDecimal getProductCount() {
		return productCount;
	}
	public void setProductCount(BigDecimal productCount) {
		this.productCount = productCount;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
	}
	
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}
