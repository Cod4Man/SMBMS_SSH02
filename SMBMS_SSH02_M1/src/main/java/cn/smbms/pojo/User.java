package cn.smbms.pojo;

import jdk.nashorn.internal.ir.Flags;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@DynamicUpdate()
@Table(name = "smbms_user")
@Entity
public class User  {
	@Id
	@Column(name = "id", updatable = false)
	@GenericGenerator(strategy = "increment", name = "userId")
	@GeneratedValue(generator = "userId", strategy = GenerationType.SEQUENCE)
	private Integer id; //id

	@Basic
	@Column(name = "userCode", updatable = false)
	private String userCode; //用户编码

    @Basic
    @Column(name = "userName")
    private String userName; //用户名称

    @Basic
    @Column(name = "userPassword", updatable = false)
	private String userPassword; //用户密码

    @Basic
    @Column(name = "gender")
    private Integer gender;  //性别

    @Basic
    @Column(name = "birthday")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;  //出生日期

    @Basic
    @Column(name = "phone")
    private String phone;   //电话

    @Basic
    @Column(name = "address")
	private String address; //地址

    /*@Basic
    @Column(name = "userRole")*/
    @Transient
    private Integer userRole;    //用户角色

    @Basic
    @Column(name = "createdBy", updatable = false)
	private Integer createdBy;   //创建者

    @Basic
    @Column(name = "creationDate", updatable = false)
    //	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate; //创建时间

    @Basic
    @Column(name = "modifyBy")
    private Integer modifyBy;     //更新者

    @Basic
    @Column(name = "modifyDate")
    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyDate;   //更新时间

//    @Transient
//	private Integer age;//年龄
//    @Transient
//	private String userRoleName;    //用户角色名称

	@ManyToOne(targetEntity =Role.class/*, fetch = FetchType.LAZY*/)
	@JoinColumn(name = "userRole")
	private Role role;

    @Transient
	public String getUserRoleName() {
		return role.getRoleName();
	}
/*	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}*/
    @Transient
	public Integer getAge() {
		/*long time = System.currentTimeMillis()-birthday.getTime();
		Integer age = Long.valueOf(time/365/24/60/60/1000).IntegerValue();*/
		Date date = new Date();
		Integer age = date.getYear()-birthday.getYear();
		return age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return role.getId();
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
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

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", userCode='" + userCode + '\'' + ", userName='" + userName + '\'' + ", userPassword='" + userPassword + '\'' + ", gender=" + gender + ", birthday=" + birthday + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", userRole=" + userRole + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + ", age=" + getAge() + ", userRoleName='" + getUserRoleName() + '\'' + ", role=" + role + '}';
	}
}
