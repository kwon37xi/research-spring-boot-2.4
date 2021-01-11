package kr.pe.kwonnam.researchspringboot.profilegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProfileGroupController {
    private final ProfileGroupModule1Properties profileGroupModule1Properties;
    private final ProfileGroupModule2Properties profileGroupModule2Properties;

    @Autowired
    public ProfileGroupController(ProfileGroupModule1Properties profileGroupModule1Properties, ProfileGroupModule2Properties profileGroupModule2Properties) {
        this.profileGroupModule1Properties = profileGroupModule1Properties;
        this.profileGroupModule2Properties = profileGroupModule2Properties;
    }


    @GetMapping("/")
    public Map<String, String> properties() {
        var props = new HashMap<String, String>();
        props.put("pg-module1-name", profileGroupModule1Properties.getName());
        props.put("pg-module1-target", profileGroupModule1Properties.getTarget());
        props.put("pg-module1-pre-override", profileGroupModule1Properties.getPreOverride());
        props.put("pg-module2-name", profileGroupModule2Properties.getName());
        props.put("pg-module2-target", profileGroupModule2Properties.getTarget());
        props.put("pg-module2-pre-override", profileGroupModule2Properties.getPreOverride());
        return props;
    }
}
