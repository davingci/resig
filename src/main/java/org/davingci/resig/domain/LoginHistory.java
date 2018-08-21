package org.davingci.resig.domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of= {"id", "username"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	
	private String loginIp;
	
	private String loginLocation;
	
	private Date loginDate;
	
	private String clientOs;
	
	private String clientOsVersion;
	
	private String clientBrowser;
	
	private String clientEngine;
	
	private String clientCpu;
	

}
