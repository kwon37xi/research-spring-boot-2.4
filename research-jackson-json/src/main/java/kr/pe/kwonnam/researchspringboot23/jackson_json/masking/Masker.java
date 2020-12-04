package kr.pe.kwonnam.researchspringboot23.jackson_json.masking;

/**
 * 필드 마스킹을 수행하는 코드.
 * <p/>
 * <em>기본 생성자</em>가 존재해야만한다. 무조건 기본 생성자로 객체를 생성한다.
 * <p/>
 * <em>Thread Safe</em> 하게 구현해야한다.
 */
public interface Masker {
    String doMask(Object fieldValue);
}
