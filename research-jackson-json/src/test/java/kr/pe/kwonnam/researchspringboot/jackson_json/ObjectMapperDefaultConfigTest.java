package kr.pe.kwonnam.researchspringboot.jackson_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
@Disabled
@DisplayName("Jackson Object Mapper 의 설정을 테스트한다.")
public class ObjectMapperDefaultConfigTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void dateTimeTest() {
    }
}
