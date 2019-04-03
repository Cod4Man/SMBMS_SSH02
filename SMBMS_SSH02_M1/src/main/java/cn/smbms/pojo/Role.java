package cn.smbms.pojo;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@DynamicUpdate
@Entity
@Table(name = "smbms_role", schema = "smbms")
public class Role {


	private Integer id;   //id
	private String roleCode; //角色编码
	private String roleName; //角色名称
	private Integer createdBy; //创建者
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate; //创建时间
	private Integer modifyBy; //更新者
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyDate;//更新时间

    @Id
    @GenericGenerator(name = "roleId", strategy = "increment")
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "roleId")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		return "Role{" + "id=" + id + ", roleCode='" + roleCode + '\'' + ", roleName='" + roleName + '\'' + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + '}';
	}
}
