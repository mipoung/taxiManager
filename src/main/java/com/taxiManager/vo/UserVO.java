package com.taxiManager.vo;

public class UserVO {
	private int id;
    private String username;
    private String CarNumber;
    private String email;
    private String operationShift;
    private String phoneNum;
    private String password;
    private String createdAt;
    
    
    
    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", taxiNumber='" + CarNumber + '\'' +
                ", email='" + email + '\'' +
                ", operationShift='" + operationShift + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
    
    
	
    

}
