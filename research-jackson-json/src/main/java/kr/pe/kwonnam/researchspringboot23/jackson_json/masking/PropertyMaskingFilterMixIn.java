package kr.pe.kwonnam.researchspringboot23.jackson_json.masking;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter(PropertyMaskingFilter.MASKING_FILTER_ID)
public class PropertyMaskingFilterMixIn {
}
