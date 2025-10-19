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

        // 분리된 문자열을 정수로 변환 후 합산
        for (String character : characters) {
            try {
                int number = Integer.parseInt(character);

                //음수를 입력된 경우
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                }

                //유효한 숫자면 합계에 더하기
                sum += number;

            //숫자가 아닌 문자가 구분자외에 입력된 경우
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + character);
            }
        }

        //최종 합계 반환
        return sum;
    }
}