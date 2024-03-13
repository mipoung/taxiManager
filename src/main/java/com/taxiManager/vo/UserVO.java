package com.taxiManager.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	private int no;
    private String id;
    private String CarNumber;
    private String email;
    private String operationShift;
    private String phoneNum;
    private String password;
    private String createdAt;
    
    
    
    @Override
    public String toString() {
        return "UserVO{" +
                "no=" + no +
                ", username='" + id + '\'' +
                ", taxiNumber='" + CarNumber + '\'' +
                ", email='" + email + '\'' +
                ", operationShift='" + operationShift + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
    
    
	
    

}
