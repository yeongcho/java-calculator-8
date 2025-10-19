package calculator;

//구분자 처리 기능 및 커스텀 구분자 처리
public class Parser {
    public static String[] Default(String inputValue) {
        //문자열이 '//'로 시작하면 커스텀 구분자 처리를 맡는 Custom() 호출
        if (inputValue.startsWith("//")) {
            return Custom(inputValue);
        }
        //기본 구분자(, 또는 :)를 기준으로 문자열을 분리
        return inputValue.split("[,:]");
    }

    //커스텀 구분자를 기준으로 입력 문자열을 분리
    private static String[] Custom(String input) {
        //'\n'의 위치(인덱스) 찾기
        int lastCharIndex = input.indexOf("\n");
        //'//'와 '\n' 사이에 있는 문자를 커스텀 구분자로 지정
        String customDelimiter = input.substring(2, lastCharIndex);

        //'\n' 이후의 숫자 부분을 잘라서 커스텀 구분자를 기준으로 분리
        String numbers = input.substring(lastCharIndex + 1);
        return numbers.split(customDelimiter);
    }
}