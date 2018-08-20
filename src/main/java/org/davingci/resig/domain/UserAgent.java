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

public class UserAgent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	
	private String loginIp;
	
	private String loginLocation;
	
	private String clientOs;
	
	private String ClientOsVersion;
	
	private String clientCpu;

}
