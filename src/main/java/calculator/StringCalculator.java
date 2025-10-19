package calculator;

//문자열 계산 기능
public class StringCalculator {
    public static int add(String inputValue) {
        //합계 변수
        int sum = 0;

        //입력값이 비었으면 기본값 0 반환
        if (inputValue == null || inputValue.isEmpty()) {
            return 0;
        }
        //기본 구분자(, 또는 :)를 기준으로 문자열 분리
        String[] characters = Parser.Default(inputValue);

        //분리된 문자열을 정수로 변환 후 합산
        for (String chracter : characters) {
            sum += Integer.parseInt(chracter);
        }
        //최종 합계 반환
        return sum;
    }

}
