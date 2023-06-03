package kata.erma.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

  private Anagram() {}

  /**
   * Test if the given text is an anagram of the subject.
   *
   * <p>An anagram is a word or phrase formed by rearranging the letters of a different word. <br>
   * Time Complexity: O(n)
   *
   * @param subject text subject
   * @param text anagram candidate
   * @return true if text is an anagram of the subject, false otherwise
   */
  public static boolean isAnagram(String subject, String text) {
    var result = false;
    if (subject != null && text != null) {
      // O(n)
      var subjectLetters = extractLetters(subject);
      // O(n)
      var textLetters = extractLetters(text);
      // O(n)
      result = subjectLetters.equals(textLetters);
    }
    return result;
  }

  /**
   * Extract letters from text. <br>
   * Time Complexity: O(n)
   *
   * @param text text to extract letters from
   * @return a bag of letters and their amounts
   */
  private static Map<Character, Integer> extractLetters(String text) {
    // O(n)
    return text.chars()
        .filter(Character::isLetter)
        .map(Character::toLowerCase)
        .mapToObj(c -> (char) c)
        // O(1) insertion on HashMap
        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
  }
}
