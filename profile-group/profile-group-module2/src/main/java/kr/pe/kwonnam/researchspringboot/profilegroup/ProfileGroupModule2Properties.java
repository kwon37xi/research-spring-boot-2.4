package kr.pe.kwonnam.researchspringboot.profilegroup;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix="profile-group.module2")
public class ProfileGroupModule2Properties {
    private String name;
    private String target;
    private String preOverride;
}
