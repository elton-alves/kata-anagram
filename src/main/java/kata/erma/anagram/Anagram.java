package kata.erma.anagram;

import java.util.Arrays;

public class Anagram {

  private Anagram() {}

  /**
   * Test if the given text is an anagram of the subject.
   *
   * <p>An anagram is a word or phrase formed by rearranging the letters of a different word. <br>
   * Time Complexity: O(n log n)
   *
   * @param subject text subject
   * @param text anagram candidate
   * @return true if text is an anagram of the subject, false otherwise
   */
  public static boolean isAnagram(String subject, String text) {
    var result = false;
    if (subject != null && text != null) {
      // O(n log n)
      var subjectLetters = extractLetters(subject);
      // O(n log n)
      var textLetters = extractLetters(text);
      // O(n)
      result = Arrays.equals(subjectLetters, textLetters);
    }
    return result;
  }

  /**
   * Extract letters from text. <br>
   * Time Complexity: O(n log n)
   *
   * @param text text to extract letters from
   * @return array of letters sorted alphabetically and in lower case
   */
  private static Character[] extractLetters(String text) {
    return text.chars()
        // O(n)
        .filter(Character::isLetter)
        .map(Character::toLowerCase)
        .mapToObj(c -> (char) c)
        // TimSort -> O(n log n)
        .sorted()
        .toArray(Character[]::new);
  }
}
