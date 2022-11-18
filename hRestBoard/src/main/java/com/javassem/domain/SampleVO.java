package com.javassem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data: 모든 인자를 다 인식하는 생성자 함수는 들어 있지 않다 - 생성자 있는 함수를 만들려면 아래 전부 입력
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SampleVO {
	
	private String name;
	private Integer age;
	private String message;
	
}
