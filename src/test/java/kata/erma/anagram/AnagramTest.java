package kata.erma.anagram;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class AnagramTest {

  @Test
  void givenNullSubjectThenIsNotAnagram() {
    String nullSubject = null;

    var result = Anagram.isAnagram(nullSubject, null);

    assertThat(result).isFalse();
  }

  @Test
  void givenSubjectWithoutLettersThenIsNotAnagram() {
    String subjectWithoutLetters = "1 , - 3 ' 4";

    var result = Anagram.isAnagram(subjectWithoutLetters, null);

    assertThat(result).isFalse();
  }

  @Test
  void givenTextWithDifferentLettersFromSubjectThenIsNotAnagram() {
    String subject = "A";
    String text = "B";

    var result = Anagram.isAnagram(subject, text);

    assertThat(result).isFalse();
  }

  @Test
  void givenTextWithSameLettersButDifferentAmountsThenIsNotAnagram() {
    String subject = "ABC";
    String text = "AABBCC";

    var result = Anagram.isAnagram(subject, text);

    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @CsvSource({
    // Same words
    "A, A",
    // Same letters
    "ABC, CBA",
    // Same letters, different case
    "abc, ABC"
  })
  void givenBasicValidAnagramThenReturnTrue(String subject, String text) {
    var result = Anagram.isAnagram(subject, text);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @MethodSource("validAnagrams")
  void givenComplexValidAnagramThenReturnTrue(String subject, String text) {
    var result = Anagram.isAnagram(subject, text);

    assertThat(result).isTrue();
  }

  private static Stream<Arguments> validAnagrams() {
    return Stream.of(
        Arguments.of("New York Times", "monkeys write"),
        Arguments.of("Church of Scientology", "rich-chosen goofy cult"),
        Arguments.of("McDonald's restaurants", "Uncle Sam's standard rot"),
        Arguments.of("She Sells Sanctuary", "Santa; shy, less cruel"));
  }
}
