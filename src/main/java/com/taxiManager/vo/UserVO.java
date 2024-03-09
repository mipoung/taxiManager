package com.taxiManager.vo;

public class UserVO {
	private int no;
    private String id;
    private String taxiNumber;
    private String email;
    private String operationShift;
    private String phoneNum;
    private String password;
    private String createdAt;
    
    
    
    @Override
    public String toString() {
        return "UserVO{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", taxiNumber='" + taxiNumber + '\'' +
                ", email='" + email + '\'' +
                ", operationShift='" + operationShift + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
    
    
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaxiNumber() {
		return taxiNumber;
	}
	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOperationShift() {
		return operationShift;
	}
	public void setOperationShift(String operationShift) {
		this.operationShift = operationShift;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
    

}
