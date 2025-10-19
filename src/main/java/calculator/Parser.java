package calculator;

//구분자 처리 기능 및 커스텀 구분자 처리
public class Parser {
    public static String[] Default(String inputValue) {
        //기본 구분자(, 또는 :)를 기준으로 문자열을 분리
        return inputValue.split(", | :");
    }
}
