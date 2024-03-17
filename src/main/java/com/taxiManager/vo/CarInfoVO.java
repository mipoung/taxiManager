package com.taxiManager.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarInfoVO {
	
	private String userId;
    private String carNumber;
    private String carName;
    private String totalKm;
    private String averageMpg;
    private String mainCar;
    private String type;

}
