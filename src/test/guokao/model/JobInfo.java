package test.guokao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobinfo")
public class JobInfo extends Page{

	@Id
	@GeneratedValue
	private int id;
	private String deptcode;//部门代码A
	private String deptname;//部门名称B
	private String employplace;//用人司局C
	private String institutional_properties;//机构性质D
	private String institutional_level;//机构层级E
	private String position_property;//职位属性F
	private String position_name;//职位名称G
	private String position_summary;//职位简介H
	private String position_number;//职位代码I
	private String test_category;//考试类别J
	private String recruit_number;//招考人数K
	private String speciality;//专业L
	private String degree;//学位M
	private String education;//学历N
	private String political_status;//政治面貌O
	private String basic_level;//基层工作最低年限P
	private String three_hand_students;//‘三支一扶’大学生Q
	private String volunteers_west;//西部志愿者R
	private String village_officials;//大学生村官S
	private String special_teacther;//特岗计划教师T
	private String unlimit;//无限制U
	private String professional_exam;//是否组织专业考试V
	private String percentage;//比例W
	private String other;//其他条件X
	private String notes;//备注Y
	private String position;//职位分布Z
	private String website;//部门网站AA
	private String telephone1;//咨询电话1AB
	private String telephone2;//咨询电话2AC
	private String telephone3;//咨询电话3AD
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getEmployplace() {
		return employplace;
	}
	public void setEmployplace(String employplace) {
		this.employplace = employplace;
	}
	public String getInstitutional_properties() {
		return institutional_properties;
	}
	public void setInstitutional_properties(String institutionalProperties) {
		institutional_properties = institutionalProperties;
	}
	public String getInstitutional_level() {
		return institutional_level;
	}
	public void setInstitutional_level(String institutionalLevel) {
		institutional_level = institutionalLevel;
	}
	public String getPosition_property() {
		return position_property;
	}
	public void setPosition_property(String positionProperty) {
		position_property = positionProperty;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String positionName) {
		position_name = positionName;
	}
	public String getPosition_summary() {
		return position_summary;
	}
	public void setPosition_summary(String positionSummary) {
		position_summary = positionSummary;
	}
	public String getPosition_number() {
		return position_number;
	}
	public void setPosition_number(String positionNumber) {
		position_number = positionNumber;
	}
	public String getTest_category() {
		return test_category;
	}
	public void setTest_category(String testCategory) {
		test_category = testCategory;
	}
	public String getRecruit_number() {
		return recruit_number;
	}
	public void setRecruit_number(String recruitNumber) {
		recruit_number = recruitNumber;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPolitical_status() {
		return political_status;
	}
	public void setPolitical_status(String politicalStatus) {
		political_status = politicalStatus;
	}
	public String getBasic_level() {
		return basic_level;
	}
	public void setBasic_level(String basicLevel) {
		basic_level = basicLevel;
	}
	public String getThree_hand_students() {
		return three_hand_students;
	}
	public void setThree_hand_students(String threeHandStudents) {
		three_hand_students = threeHandStudents;
	}
	public String getVolunteers_west() {
		return volunteers_west;
	}
	public void setVolunteers_west(String volunteersWest) {
		volunteers_west = volunteersWest;
	}
	public String getVillage_officials() {
		return village_officials;
	}
	public void setVillage_officials(String villageOfficials) {
		village_officials = villageOfficials;
	}
	public String getSpecial_teacther() {
		return special_teacther;
	}
	public void setSpecial_teacther(String specialTeacther) {
		special_teacther = specialTeacther;
	}
	public String getUnlimit() {
		return unlimit;
	}
	public void setUnlimit(String unlimit) {
		this.unlimit = unlimit;
	}
	public String getProfessional_exam() {
		return professional_exam;
	}
	public void setProfessional_exam(String professionalExam) {
		professional_exam = professionalExam;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public String getTelephone3() {
		return telephone3;
	}
	public void setTelephone3(String telephone3) {
		this.telephone3 = telephone3;
	}
	@Override
	public String toString() {
		return "JobInfo [basic_level=" + basic_level + ", degree=" + degree
				+ ", deptcode=" + deptcode + ", deptname=" + deptname
				+ ", education=" + education + ", employplace=" + employplace
				+ ", id=" + id + ", institutional_level=" + institutional_level
				+ ", institutional_properties=" + institutional_properties
				+ ", notes=" + notes + ", other=" + other + ", percentage="
				+ percentage + ", political_status=" + political_status
				+ ", position=" + position + ", position_name=" + position_name
				+ ", position_number=" + position_number
				+ ", position_property=" + position_property
				+ ", position_summary=" + position_summary
				+ ", professional_exam=" + professional_exam
				+ ", recruit_number=" + recruit_number + ", special_teacther="
				+ special_teacther + ", speciality=" + speciality
				+ ", telephone1=" + telephone1 + ", telephone2=" + telephone2
				+ ", telephone3=" + telephone3 + ", test_category="
				+ test_category + ", three_hand_students="
				+ three_hand_students + ", unlimit=" + unlimit
				+ ", village_officials=" + village_officials
				+ ", volunteers_west=" + volunteers_west + ", website="
				+ website + "]";
	}
	

}
