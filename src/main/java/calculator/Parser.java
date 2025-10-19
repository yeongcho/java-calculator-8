package calculator;

import java.util.regex.Pattern;

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

    // 커스텀 구분자를 기준으로 입력 문자열 분리
    private static String[] Custom(String input) {
        // "//" 이후 첫 번째 리터럴 "\n" 위치
        int litIndex = input.indexOf("\\n", 2);

        // "//" 이후 첫 번째 실제 개행 위치
        int realIndex = input.indexOf('\n', 2);

        // 두 후보가 모두 없으면 잘못된 입력
        if (litIndex == -1 && realIndex == -1) {
            throw new IllegalArgumentException("Invalid custom delimiter format: " + input);
        }

        // 경계 위치
        int boundaryIndex;
        // 경계 문자열의 길이 (리터럴 "\n"은 2, 실제 개행은 1)
        int boundaryLength;
        if (litIndex != -1 && (realIndex == -1 || litIndex < realIndex)) {
            boundaryIndex = litIndex;
            boundaryLength = 2; // "\\n"
        } else {
            // 그렇지 않으면 실제 개행을 경계로 사용
            boundaryIndex = realIndex;
            boundaryLength = 1; // '\n'
        }

        // "//"와 경계 사이가 구분자(문자 그대로)
        String customDelimiter = input.substring(2, boundaryIndex);
        String numbers = input.substring(boundaryIndex + boundaryLength);

        // 숫자 부분이 비어있으면 빈 배열 반환
        if (numbers.isEmpty()) {
            return new String[0];
        }

        // 숫자 문자열을 커스텀 구분자로 split
        return numbers.split(Pattern.quote(customDelimiter));
    }

}