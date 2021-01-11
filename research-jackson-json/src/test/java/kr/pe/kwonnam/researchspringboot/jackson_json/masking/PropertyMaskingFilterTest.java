package kr.pe.kwonnam.researchspringboot.jackson_json.masking;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PropertyMaskingFilterTest")
class PropertyMaskingFilterTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void name() {

    }
}